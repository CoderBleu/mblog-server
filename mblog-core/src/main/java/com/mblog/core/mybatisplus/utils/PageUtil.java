package com.mblog.core.mybatisplus.utils;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import java.io.Serializable;

/**
 * 分页工具类
 * @author lauy
 */
public class PageUtil implements Serializable {

    private static final long serialVersionUID = 1L;

    public static <T> PageResult toPageResult(IPage<T> page) {
        PageResult pageResult = new PageResult();
        pageResult.setPageNumber(page.getCurrent());
        pageResult.setPageSize(page.getSize());
        pageResult.setTotal(page.getTotal());
        pageResult.setPages(page.getPages());
        pageResult.setRecords(page.getRecords());
        return pageResult;
    }

}
