package com.igeek.crm.dto;

import java.util.List;

/**
 * LayUI的数据表格默认返回数据类型
 * @author Administrator
 * @create 2019/05/14
 */
public class LayUITableData<T> {
    private Integer code;//返回状态码 0=>成功
    private String msg;//返回数据消息
    private Long count;
    private List<T> data;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }
}
