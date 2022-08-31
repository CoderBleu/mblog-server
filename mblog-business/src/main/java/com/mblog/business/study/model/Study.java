package com.mblog.business.study.model;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @Author: MyBatis Plus Generator
 * @Date: 2022-08-28
 * @Description:
 */
public class Study implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;

    private String age;

    private LocalDateTime createTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "Study{" +
        "id=" + id +
        ", age=" + age +
        ", createTime=" + createTime +
        "}";
    }
}
