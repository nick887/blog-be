package icu.nickxiao.redis.config;

import icu.nickxiao.config.YamlPropertySourceFactory;
import icu.nickxiao.redis.property.BaseMasterSlaveProperties;
import icu.nickxiao.redis.property.BaseProperties;
import icu.nickxiao.redis.property.ClusterProperties;
import icu.nickxiao.redis.property.SingleProperties;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * @author nick
 * @version 1.0, 2021/12/11
 * @since 1.0.0
 */
@Data
@Configuration
@ConfigurationProperties(prefix = "spring.redis")
@PropertySource(value = "classpath:redis.yml", factory = YamlPropertySourceFactory.class)
@Slf4j
public class RedisConfig {
    /** single/cluster */
    private String mode;
    /** 基础配置 */
    private BaseProperties base;
    /** 单机配置 */
    private SingleProperties single;
    /** 基础主从配置 */
    private BaseMasterSlaveProperties masterSlave;
    /** 集群配置 */
    private ClusterProperties cluster;
}