package com.dk.entity;

import java.io.Serializable;

/**
 * @author DingKai
 * @Classname Result
 * @Description 返回结果封装类
 * @create 2019/4/1
 */
public class Result implements Serializable {
    /**
     * 返回布尔值
     */
    private boolean success;

    /**
     * 返回消息
     */
    private String message;

    /**
     * 构造方法
     */
    public Result(boolean success, String message) {
        this.success = success;
        this.message = message;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
