package com.mblog.service.controller;

import com.alibaba.fastjson.JSON;
import com.mblog.core.redis.helper.RedisHelper;
import com.mblog.core.web.api.Result;
import org.redisson.api.RedissonClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author lauy
 * @date 2022/8/25
 * @description
 */
@RestController
public class TestController {

    private static final Logger logger = LoggerFactory.getLogger(TestController.class);

    @Autowired
    private RedissonClient redissonClient;

    @Autowired
    RedisHelper redisHelper;

    @GetMapping("/mblog/service/test")
    public Result test(@RequestParam(value = "pageNumber", defaultValue = "1")Integer pageNumber,
                       @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
                       @RequestParam List<Integer> ids,
                       @RequestParam(value = "time", required = false) LocalDateTime time) {
        return Result.success("result", JSON.toJSONString(ids));
    }
}
