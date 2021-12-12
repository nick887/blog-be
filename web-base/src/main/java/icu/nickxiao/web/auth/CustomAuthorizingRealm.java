package icu.nickxiao.web.auth;

import icu.nickxiao.common.pojo.CommonConfig;
import icu.nickxiao.common.pojo.Constants;
import icu.nickxiao.web.util.Claims;
import icu.nickxiao.web.util.JwtUtil;
import java.util.Optional;
import lombok.RequiredArgsConstructor;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.stereotype.Service;

/**
 * @author xiaoyi03 <xiaoyi03@kuaishou.com>
 * Created on 2021-12-12
 */
@Service
@RequiredArgsConstructor
public class CustomAuthorizingRealm extends AuthorizingRealm {
    private final CommonConfig commonConfig;

    @Override
    public boolean supports(AuthenticationToken token) {
        return token instanceof JwtToken;
    }

    /**
     * 获取授权信息
     *
     * @param principalCollection PrincipalCollection
     * @return 授权信息
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        Optional<String> role = JwtUtil.getClaim(principalCollection.toString(), Constants.ROLE);
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        simpleAuthorizationInfo.addRole(role.get());
        return simpleAuthorizationInfo;
    }

    /**
     * 认证
     *
     * @param authenticationToken AuthenticationToken
     * @return 认证结果
     * @throws AuthenticationException 认证异常
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        String token = (String) authenticationToken.getCredentials();
        Optional<String> id = JwtUtil.getClaim(token, Constants.USER_ID);
        if (!id.isPresent()) {
            throw new AuthenticationException("token invalid");
        }
        Optional<String> role = JwtUtil.getClaim(token, Constants.ROLE);
        if (!role.isPresent()) {
            throw new AuthenticationException("token invalid");
        }
        if (!JwtUtil.verify(token, commonConfig.getSecretKey(), Claims.builder()
                .id(id.get())
                .role(role.get())
                .build())) {
            throw new AuthenticationException("token invalid");
        }
        return new SimpleAuthenticationInfo(token, token, "CustomAuthorizingRealm");
    }
}
