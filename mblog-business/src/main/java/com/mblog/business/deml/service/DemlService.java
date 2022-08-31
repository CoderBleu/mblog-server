package com.mblog.business.deml.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.mblog.business.deml.model.Deml;

import java.util.List;

/**
 * @Author: MyBatis Plus Generator
 * @Date: 2022-08-27
 * @Description:
 */
public interface DemlService extends IService<Deml> {

    List<Deml> listDeml();
}
