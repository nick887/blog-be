package icu.nickxiao.redis.property;

import lombok.Data;
import org.redisson.config.ReadMode;

/**
 * @author nick
 * @version 1.0, 2021/12/11
 * @since 1.0.0
 */
@Data
public class BaseMasterSlaveProperties {
    /** 每个从节点，最小空闲连接数 */
    private int slaveConnectionMinimumIdleSize = 24;
    /** 每个从节点，最大连接数 */
    private int slaveConnectionPoolSize = 64;
    /** 失败重连间隔，单位：毫秒 */
    private int failedSlaveReconnectionInterval = 3000;
    /** 失败检查间隔，单位：毫秒 */
    private int failedSlaveCheckInterval = 180000;
    /** 主节点最小连接数 */
    private int masterConnectionMinimumIdleSize = 24;
    /** 主节点最大连接数 */
    private int masterConnectionPoolSize = 64;
    /** 读取模式 */
    private ReadMode readMode = ReadMode.SLAVE;
}
