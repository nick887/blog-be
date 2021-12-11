package icu.nickxiao.redis.config;


import icu.nickxiao.redis.property.BaseMasterSlaveProperties;
import icu.nickxiao.redis.property.BaseProperties;
import icu.nickxiao.redis.property.ClusterProperties;
import icu.nickxiao.redis.property.SingleProperties;
import org.apache.commons.lang3.StringUtils;
import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.BaseConfig;
import org.redisson.config.BaseMasterSlaveServersConfig;
import org.redisson.config.ClusterServersConfig;
import org.redisson.config.Config;
import org.redisson.config.SingleServerConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author nick
 * @version 1.0, 2021/12/11
 * @since 1.0.0
 */
@Configuration
public class RedissonClientConfig {
    private static final String REDIS_PREFIX = "redis://";

    @Autowired
    private RedisConfig redisConfig;

    /** single mode RedissonClient */
    @Bean
    @ConditionalOnProperty(name = "spring.redis.mode", havingValue = "single")
    RedissonClient redissonSingle() {
        final Config config = new Config();
        final SingleProperties singleProperties = this.redisConfig.getSingle();
        String node = this.redisConfig.getSingle().getAddress();
        node = node.startsWith(REDIS_PREFIX) ? node : REDIS_PREFIX + node;
        final SingleServerConfig serverConfig = config.useSingleServer()
                .setAddress(node)
                .setDatabase(singleProperties.getDatabase())
                .setConnectionPoolSize(singleProperties.getConnectionPoolSize())
                .setConnectionMinimumIdleSize(singleProperties.getConnectionMinimumIdleSize());
        this.assembleBaseConfig(serverConfig, this.redisConfig.getBase());
        return Redisson.create(config);
    }

    /** cluster mode RedissonClient */
    @Bean
    @ConditionalOnProperty(name = "spring.redis.mode", havingValue = "cluster")
    RedissonClient redissonCluster() {
        final Config config = new Config();
        final ClusterProperties clusterProperties = this.redisConfig.getCluster();
        final String[] nodeAddresses = clusterProperties.getNodes().stream()
                .map(node -> node.startsWith(REDIS_PREFIX) ? node : REDIS_PREFIX + node)
                .toArray(String[]::new);
        final ClusterServersConfig serverConfig = config.useClusterServers()
                .addNodeAddress(nodeAddresses)
                .setScanInterval(clusterProperties.getScanInterval())
                .setCheckSlotsCoverage(clusterProperties.isCheckSlotsCoverage());
        this.assembleBaseMasterSlaveConfig(serverConfig, this.redisConfig.getMasterSlave());
        this.assembleBaseConfig(serverConfig, this.redisConfig.getBase());
        return Redisson.create(config);
    }

    /**
     * 填充基础配置
     *
     * @param config     BaseConfig
     * @param properties 参数信息
     * @param <T>        泛型类型
     */
    private <T extends BaseConfig<T>> void assembleBaseConfig(T config, BaseProperties properties) {
        config.setIdleConnectionTimeout(properties.getIdleConnectionTimeout())
                .setConnectTimeout(properties.getConnectTimeout())
                .setTimeout(properties.getTimeout())
                .setRetryAttempts(properties.getRetryAttempts())
                .setRetryInterval(properties.getRetryInterval())
                .setUsername(StringUtils.trimToNull(properties.getUsername()))
                .setPassword(StringUtils.trimToNull(properties.getPassword()));
    }

    /**
     * 填充主从配置
     *
     * @param config     BaseMasterSlaveServersConfig
     * @param properties 参数信息
     * @param <T>        泛型类型
     */
    private <T extends BaseMasterSlaveServersConfig<T>> void assembleBaseMasterSlaveConfig
    (T config, BaseMasterSlaveProperties properties) {
        config.setSlaveConnectionMinimumIdleSize(properties.getSlaveConnectionMinimumIdleSize())
                .setSlaveConnectionPoolSize(properties.getSlaveConnectionPoolSize())
                .setFailedSlaveReconnectionInterval(properties.getFailedSlaveReconnectionInterval())
                .setFailedSlaveCheckInterval(properties.getFailedSlaveCheckInterval())
                .setMasterConnectionMinimumIdleSize(properties.getMasterConnectionMinimumIdleSize())
                .setMasterConnectionPoolSize(properties.getMasterConnectionPoolSize())
                .setReadMode(properties.getReadMode());
    }
}
