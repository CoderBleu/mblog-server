package com.mblog.admin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * @author lauy
 * @date 2022/8/24
 * @description
 */
@RefreshScope
@EnableAsync
@EnableCaching
@EnableDiscoveryClient
@SpringBootApplication
// 多模块下注意这个扫包路径
@ComponentScan(basePackages = {"com.mblog.*"})
public class MblogAdminApplication {

    public static void main(String[] args) {
        SpringApplication.run(MblogAdminApplication.class,args);
    }
}
