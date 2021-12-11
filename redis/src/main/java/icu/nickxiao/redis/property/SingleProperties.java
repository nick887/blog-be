package icu.nickxiao.redis.property;

import lombok.Data;

/**
 * @author nick
 * @version 1.0, 2021/12/11
 * @since 1.0.0
 */
@Data
public class SingleProperties {
    /** 地址 */
    private String address;

    /** database，范围[0, 15] */
    private int database = 0;

    /** 最大连接数 */
    private int connectionPoolSize = 64;

    /** 最小空闲连接数 */
    private int connectionMinimumIdleSize = 24;
}
