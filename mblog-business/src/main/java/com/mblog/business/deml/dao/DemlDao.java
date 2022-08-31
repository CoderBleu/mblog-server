package com.mblog.business.deml.dao;

import com.mblog.business.deml.model.Deml;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * @Author: MyBatis Plus Generator
 * @Date: 2022-08-27
 * @Description:
 */
public interface DemlDao extends BaseMapper<Deml> {

    List<Deml> listDeml();
}
