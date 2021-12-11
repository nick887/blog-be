package icu.nickxiao.redis.property;

import lombok.Data;

/**
 * @author nick
 * @version 1.0, 2021/12/11
 * @since 1.0.0
 */
@Data
public class BaseProperties {

    /** 空闲连接过期时长，单位：毫秒 */
    private int idleConnectionTimeout = 10000;

    /** 连接超时，单位：毫秒 */
    private int connectTimeout = 10000;

    /** 响应超时，单位：毫秒 */
    private int timeout = 3000;

    /** 重试次数 */
    private int retryAttempts = 3;

    /** 重试间隔，单位：毫秒 */
    private int retryInterval = 1500;

    /** 用户名 */
    private String username;

    /** 密码 */
    private String password;
}
