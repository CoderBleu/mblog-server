package com.mblog.core.web.api;

/**
 * @author lauy
 * @date 2022/8/29
 * @description
 */
public enum ResultCode implements CommonErrorCode {

    /**
     * 操作成功
     */
    SUCCESS(200, "操作成功"),

    /**
     * 操作失败
     */
    FAIL(500, "操作失败"),

    /**
     * 参数检验失败
     */
    VALIDATE_FAIL(400, "参数检验失败"),

    /**
     * 没有相关权限或暂未登录或token已经过期
     */
    UNAUTHORIZED(403, "没有相关权限");

    private long code;

    private String message;

    private ResultCode(long code, String message) {
        this.code = code;
        this.message = message;
    }

    @Override
    public long getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
