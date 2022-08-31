package com.mblog.service.config;

import com.mblog.core.redis.BaseRedisConfig;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Configuration;

/**
 * @author lauy
 * EnableCaching 开启缓存
 * Configuration 配置类
 */
@EnableCaching
@Configuration
public class RedisConfig extends BaseRedisConfig {

}
