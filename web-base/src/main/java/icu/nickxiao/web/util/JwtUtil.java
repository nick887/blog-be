package icu.nickxiao.web.util;

import icu.nickxiao.common.pojo.Constants;
import java.time.Duration;
import java.util.Date;
import java.util.Optional;
import lombok.extern.slf4j.Slf4j;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTDecodeException;

import static icu.nickxiao.common.pojo.Constants.ROLE;
import static icu.nickxiao.common.pojo.Constants.USER_ID;

/**
 * @author xiaoyi03 <xiaoyi03@kuaishou.com>
 * Created on 2021-12-12
 */
@Slf4j
public class JwtUtil {
    /**
     * 校验JWT字符串
     *
     * @param token  jwt token
     * @param secret 私钥
     * @param claims 用户id与地址
     * @return true - 验证通过；false - 验证失败
     */
    public static boolean verify(String token, String secret, Claims claims) {
        try {
            Algorithm algorithm = Algorithm.HMAC512(secret);
            JWTVerifier verifier = JWT.require(algorithm).withClaim(USER_ID, claims.getId()).withClaim(ROLE,claims.getRole()).build();
            verifier.verify(token);
            return true;
        } catch (Exception e) {
            // jwt token失效情况比较多，仅调试的时候打印
            log.debug("Verify jwt token {} failed.", token);
        }
        return false;
    }

    /**
     * 获取jwt关键信息，不用解码
     *
     * @param token jwt token
     * @return claim
     */
    public static Optional<String> getClaim(String token, String name) {
        try {
            return Optional.of(JWT.decode(token).getClaim(name).asString());
        } catch (JWTDecodeException e) {
            log.warn("Can't decode jwt {}", token);
        }
        return Optional.empty();
    }

    /**
     * 签名jwt token串
     *
     * @param claims 用户id与地址
     * @param secret 私钥
     * @param expire 过期时间
     * @return token
     */
    public static String sign(Claims claims, String secret, Duration expire) {
        Algorithm algorithm = Algorithm.HMAC512(secret);
        Date expiredDate = new Date(System.currentTimeMillis() + expire.toMillis());
        return JWT.create().withClaim(USER_ID, claims.getId()).withClaim(ROLE,claims.getRole()).withExpiresAt(expiredDate).sign(algorithm);
    }
}