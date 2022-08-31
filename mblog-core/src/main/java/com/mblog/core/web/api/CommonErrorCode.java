package com.mblog.core.web.api;

/**
 * @author lauy
 * @date 2022/8/29
 * @description 常用API返回对象接口
 */
public interface CommonErrorCode {

    /**
     * 返回码
     */
    long getCode();

    /**
     * 返回信息
     */
    String getMessage();
}
