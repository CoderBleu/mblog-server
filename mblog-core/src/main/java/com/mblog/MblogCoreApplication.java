package com.mblog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author lauy
 * @date 2022/8/24
 * @description
 */
@EnableDiscoveryClient
@SpringBootApplication
public class MblogCoreApplication {

    public static void main(String[] args) {
        SpringApplication.run(MblogCoreApplication.class,args);
    }
}
