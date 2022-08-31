package com.mblog.core.redis;

import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;


/**
 * @author lauy
 * @date 2022/8/29
 * @description 常用API返回对象接口
 * // @Configuration
 */
@ConditionalOnClass(
        name = {"org.springframework.data.redis.cache.RedisCacheManager"}
)
@ConfigurationProperties(prefix = "spring.redis")
public class BaseRedissonConfig {

    @Value(value = "${spring.redis.host}")
    private String host;

    @Value(value = "${spring.redis.port}")
    private String port;

    @Value(value = "${spring.redis.password}")
    private String password;

    @Value(value = "${spring.redis.database}")
    private Integer database;

    @Bean
    public RedissonClient redissonClient() {
        // 集群
        // Config config = new Config();
        // config.useClusterServers()
        //         .setScanInterval(2000)
        //         .addNodeAddress("redis://127.0.0.1:6379");
        //
        // RedissonClient redisson = Redisson.create(config);
        // return redisson;

        // 单机模式 "redis://host:port"
        Config config = new Config();
        String address = String.format("redis://%s:%s", host, port);
        config.useSingleServer().setAddress(address).setDatabase(database).setPassword(password);
        return Redisson.create(config);
    }
}
