package com.mblog.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lauy
 * @date 2022/8/25
 * @description
 */
@RestController
//@RequestMapping("/mblog/core")
public class HealthController {

    @GetMapping("/mblog/core/health")
    public String health() {
        return "health";
    }
}
