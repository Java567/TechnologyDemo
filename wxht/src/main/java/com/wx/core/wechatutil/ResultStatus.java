package com.wx.core.wechatutil;

/**
 * @author me
 * @date 2018-09-21 11:05
 */
public enum ResultStatus {
    /**
     * 服务器内部错误，服务错误，请求错误
     */
    SERVER_ERROR(500),
    SERVICE_ERROR(888),
    REQUEST_ERROR(400),
    OK(200);

    final int code;

    ResultStatus(int code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
