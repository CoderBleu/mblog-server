package com.mblog.core.mybatisplus.utils;

import java.io.Serializable;
import java.util.List;

/**
 * @author lauy
 * @date 2022/8/28
 * @description
 */
public class PageResult<T> implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 总记录数
     */
    private long total;
    /**
     * 每页记录数
     */
    private long pageSize;
    /**
     * 总页数
     */
    private long pages;
    /**
     * 当前页数
     */
    private long pageNumber;
    /**
     * 列表数据
     */
    private List<T> records;

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public long getPageSize() {
        return pageSize;
    }

    public void setPageSize(long pageSize) {
        this.pageSize = pageSize;
    }

    public long getPages() {
        return pages;
    }

    public void setPages(long pages) {
        this.pages = pages;
    }

    public long getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(long pageNumber) {
        this.pageNumber = pageNumber;
    }

    public List<T> getRecords() {
        return records;
    }

    public void setRecords(List<T> records) {
        this.records = records;
    }

    public PageResult() {
    }

    public PageResult(long total, long pageSize, long pages, long pageNumber, List<T> records) {
        this.total = total;
        this.pageSize = pageSize;
        this.pages = pages;
        this.pageNumber = pageNumber;
        this.records = records;
    }

    public <T> PageResult replaceList(List<T> list) {
        PageResult pageResult = new PageResult<>();
        pageResult.setTotal(this.getTotal());
        pageResult.setPageSize(this.getPageSize());
        pageResult.setPages(this.getPages());
        pageResult.setPageNumber(this.getPageNumber());
        pageResult.setRecords(list);
        return pageResult;
    }
}
