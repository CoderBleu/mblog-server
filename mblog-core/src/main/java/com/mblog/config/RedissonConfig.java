package com.mblog.config;

import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RedissonConfig {

    @Value("${spring.redis.host}")
    private String host;

    @Value("${spring.redis.port}")
    private String port;

    @Value("${spring.redis.password}")
    private String password;

    @Value("${spring.redis.database}")
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

        // 单机模式
        Config config = new Config();
        config.useSingleServer().setAddress("redis://172.16.50.129:6379").setDatabase(0).setPassword("root");
        return  Redisson.create(config);
    }
}
