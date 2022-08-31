package com.mblog.business.deml.service.impl;

import com.mblog.business.deml.dao.DemlDao;
import com.mblog.business.deml.model.Deml;
import com.mblog.business.deml.service.DemlService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: MyBatis Plus Generator
 * @Date: 2022-08-27
 * @Description:
 */
@Service
public class DemlServiceImpl extends ServiceImpl<DemlDao, Deml> implements DemlService {

    @Override
    public List<Deml> listDeml() {
        return baseMapper.listDeml();
    }
}
