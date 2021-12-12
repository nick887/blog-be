package icu.nickxiao.web.log;

import icu.nickxiao.common.pojo.AuthUser;
import icu.nickxiao.common.pojo.Constants;
import icu.nickxiao.model.dto.UserOperationLogDto;
import icu.nickxiao.model.service.IUserOperationLogModelService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.MDC;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author xiaoyi03 <xiaoyi03@kuaishou.com>
 * Created on 2021-12-12
 */
@Component
@RequiredArgsConstructor
@Slf4j
public class UserOperationLogInterceptor implements HandlerInterceptor {

    private final IUserOperationLogModelService userOperationLogModelService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        return HandlerInterceptor.super.preHandle(request, response, handler);
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

        AuthUser authUser = (AuthUser) request.getAttribute(Constants.SHIRO_ATTRIBUTE_AUTH_USER);
        Long userId;
        // 是否为带权限认证
        userId = authUser == null ? null : authUser.getId();
        // 获取请求参数
        ObjectMapper objectMapper = new ObjectMapper();
        String requestParams = objectMapper.writeValueAsString(request.getParameterMap());
        // 返回状态码
        int status = response.getStatus();
        // 请求方法
        String method = request.getMethod();
        // 请求url
        String url = request.getRequestURI();
        // requestId
        String requestId = MDC.get(Constants.KEY_REQUEST_ID);
        Long requestIdL = Long.parseLong(requestId);
        userOperationLogModelService.update(UserOperationLogDto.builder()
                .requestId(requestIdL)
                .method(method)
                .userId(userId)
                .status(status)
                .requestParams(requestParams)
                .url(url)
                .build());
        // 清除MDC
        MDC.clear();
    }
}
