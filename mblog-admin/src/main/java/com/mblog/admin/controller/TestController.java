package com.mblog.admin.controller;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mblog.business.deml.model.Deml;
import com.mblog.business.deml.service.DemlService;
import com.mblog.business.study.model.Study;
import com.mblog.business.study.service.StudyService;
import com.mblog.core.mybatisplus.utils.PageResult;
import com.mblog.core.mybatisplus.utils.PageUtil;
import com.mblog.core.redis.helper.RedisHelper;
import com.mblog.core.web.api.Result;
import com.mblog.core.web.helper.SpringContextHelper;
import org.redisson.api.RedissonClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
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
    private DemlService demlService;

    @Autowired
    private StudyService studyService;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private RedissonClient redissonClient;

    @Autowired
    RedisHelper redisHelper;

    @GetMapping("/mblog/admin/test")
    public Result test(@RequestParam(value = "pageNumber", defaultValue = "1")Integer pageNumber,
                       @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
                       @RequestParam List<Integer> ids,
                       @RequestParam(value = "time", required = false) LocalDateTime time) {
        Deml deml = demlService.getById(1);
        List<Study> list = studyService.list(null);
        List<Deml> demlList = demlService.listDeml();
        // 分页
        IPage<Deml> page = new Page<>(pageNumber, pageSize);
        LambdaQueryWrapper<Deml> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(Deml::getId, 1);
        IPage<Deml> pageInfo = demlService.page(page, wrapper);
        List<Deml> records = pageInfo.getRecords();
        PageResult pageResult = PageUtil.toPageResult(pageInfo);
        pageResult.getRecords().add(time);
        System.out.println(SpringContextHelper.getApplicationContext());
        logger.info("test info: {}", JSON.toJSONString(pageResult));
        // redis
        redisHelper.set("key1谁带谁", "skfjds速度速度", 120);
        return Result.success("r", list);
    }
}
