package icu.nickxiao.common.pojo;

import icu.nickxiao.config.YamlPropertySourceFactory;
import java.math.BigDecimal;
import lombok.Data;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * @author xiaoyi03 <xiaoyi03@kuaishou.com>
 * Created on 2021-12-12
 */
@Data
@Configuration
@PropertySource(value = "classpath:common-config.yml", factory = YamlPropertySourceFactory.class)
@ConfigurationProperties(prefix = "common")
public class CommonConfig {
    /** jwt加密密钥 */
    private String secretKey;
    /** Jwt token生效小时数 */
    private int jwtTokenExpireHours;
    /** 邮箱验证码生效时间 */
    private int emailCodeExpireMinutes;
}