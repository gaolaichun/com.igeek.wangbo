package com.igeek.vo;

import com.igeek.pojo.User;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: 60915
 * \* Date: 2019/8/16
 * \* Time: 23:30
 * \* To change this template use File | Settings | File Templates.
 * \* Description:
 * \
 */
public class QueryVo {
    private User user;
    private String orderNo;
    //如果还有其他查询条件，可以继续封装


    public QueryVo() {
    }

    public QueryVo(User user, String orderNo) {
        this.user = user;
        this.orderNo = orderNo;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    @Override
    public String toString() {
        return "QueryVo{" +
                "user=" + user +
                ", orderNo='" + orderNo + '\'' +
                '}';
    }
}