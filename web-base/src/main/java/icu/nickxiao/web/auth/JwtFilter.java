package icu.nickxiao.web.auth;

import icu.nickxiao.common.ErrorCodeEnum;
import icu.nickxiao.common.pojo.AuthUser;
import icu.nickxiao.common.pojo.Constants;
import icu.nickxiao.common.pojo.UserStatusEnum;
import icu.nickxiao.model.dto.UserOperationLogDto;
import icu.nickxiao.model.service.IUserOperationLogModelService;
import icu.nickxiao.util.UidGeneratorUtil;
import icu.nickxiao.web.util.JwtUtil;
import java.io.PrintWriter;
import java.util.HashSet;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.minidev.json.JSONObject;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.web.filter.authc.BasicHttpAuthenticationFilter;
import org.slf4j.MDC;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMethod;

import static icu.nickxiao.common.pojo.Constants.KEY_REQUEST_ID;

/**
 * @author xiaoyi03 <xiaoyi03@kuaishou.com>
 * Created on 2021-12-12
 */
@Slf4j
@RequiredArgsConstructor
public class JwtFilter extends BasicHttpAuthenticationFilter {
    private final IUserOperationLogModelService userOperationLogModelService;

    /**
     * 总处理
     *
     * @param request     http request
     * @param response    http response
     * @param mappedValue mappedValue
     * @return 拦截器状态
     */
    @Override
    protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue) {
        if (isLoginAttempt(request, response)) {
            try {
                return executeLogin(request, response);
            } catch (Exception e) {
                return false;
            }
        }
        return true;
    }

    /**
     * 是否存在Authorization头
     *
     * @param request  http request
     * @param response http response
     * @return 拦截器状态
     */
    @Override
    protected boolean isLoginAttempt(ServletRequest request, ServletResponse response) {
        HttpServletRequest req = (HttpServletRequest) request;
        String authorization = req.getHeader("Authorization");
        return authorization != null;
    }

    /**
     * 鉴权，成功给路由传递AuthUser
     *
     * @param request  http request
     * @param response http resppnse
     * @return 拦截器状态
     */
    @Override
    protected boolean executeLogin(ServletRequest request, ServletResponse response) {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        String authorization = httpServletRequest.getHeader("Authorization");
        JwtToken token = new JwtToken(authorization);
        // 提交给realm进行登入，如果错误他会抛出异常并被捕获
        getSubject(request, response).login(token);
        String tokenString = token.getToken();
        // 获取claim信息
        Long claimId = Long.parseLong(JwtUtil.getClaim(tokenString, Constants.USER_ID).get());
        String claimRole = JwtUtil.getClaim(tokenString, Constants.ROLE).get();
        // add attribute
        request.setAttribute(Constants.SHIRO_ATTRIBUTE_AUTH_USER, AuthUser.builder()
                .id(claimId)
                .permissions(null)
                .roles(new HashSet<String>() {{
                    add(claimRole);
                }})
                .status(UserStatusEnum.NORMAL)
                .build());
        // 如果没有抛出异常则代表登入成功，返回true
        return true;
    }


    /**
     * cors支持 // TODO:生产环境修改
     *
     * @param request  http request
     * @param response http response
     * @return 拦截器状态
     * @throws Exception exception
     */
    @Override
    protected boolean preHandle(ServletRequest request, ServletResponse response) throws Exception {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        HttpServletResponse httpServletResponse = (HttpServletResponse) response;
        String requestId = httpServletRequest.getHeader(KEY_REQUEST_ID);
        Long requestIdL = UidGeneratorUtil.generateUid();
        if (StringUtils.isBlank(requestId)) {
            requestId = Long.toString(requestIdL);
        }
        //将生成的request-id放入MDC中，允许打印日志时获取
        MDC.put(KEY_REQUEST_ID, requestId);
        httpServletResponse.addHeader(KEY_REQUEST_ID, requestId);
        // 插入日志数据
        userOperationLogModelService.add(UserOperationLogDto.builder().requestId(requestIdL).build());
        // 跨域时会首先发送一个option请求，这里我们给option请求直接返回正常状态
        /*if (httpServletRequest.getMethod().equals(RequestMethod.OPTIONS.name())) {
            httpServletResponse.setStatus(HttpStatus.OK.value());
            return false;
        }*/
        return super.preHandle(request, response);
    }


    /**
     * jwt鉴权失败处理
     *
     * @param request  http request
     * @param response http response
     * @return 拦截器状态
     * @throws Exception exception
     */
    @Override
    protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {
        HttpServletResponse httpServletResponse = (HttpServletResponse) response;
        httpServletResponse.setStatus(HttpServletResponse.SC_FORBIDDEN);
        httpServletResponse.setContentType("application/json;charset=utf-8");
        PrintWriter out = httpServletResponse.getWriter();
        JSONObject json = new JSONObject();
        json.put("errorCode", ErrorCodeEnum.FORBIDDEN.getCode());
        json.put("errorMsg", ErrorCodeEnum.FORBIDDEN.name());
        out.println(json);
        out.flush();
        out.close();
        return false;
    }

}
