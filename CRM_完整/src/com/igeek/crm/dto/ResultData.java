package com.igeek.crm.dto;

/**
 * 封装ajax请求返回结果
 * @author Administrator
 * @create 2019/05/15
 */
public class ResultData {
    private Integer status;
    private String message;
    private Object data;

    public ResultData(Integer status, String message, Object data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }

    public ResultData() {
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
