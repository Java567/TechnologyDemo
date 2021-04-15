package com.wx.core.wechatutil;

import lombok.Getter;

@Getter
public class ProjectException extends RuntimeException {
    private String message;
    private ResultStatus status;


    public ProjectException(ResultStatus status, String message) {
        this.message = message;
        this.status = status;
    }

}


