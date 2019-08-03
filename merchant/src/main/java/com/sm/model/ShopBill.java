package com.sm.model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ShopBill {
	
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
    private Integer id;

    private Integer sid;

    private Integer typeTranscation;

    private String describeTranscation;

    private Double money;

    private Double totalMoney;

    private Integer statusTranscation;

    private Integer statusSettlement;

    private String remark;

    private String zfbAccount;

    private Date createTime;

    private Date finishTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public Integer getTypeTranscation() {
        return typeTranscation;
    }

    public void setTypeTranscation(Integer typeTranscation) {
        this.typeTranscation = typeTranscation;
    }

    public String getDescribeTranscation() {
        return describeTranscation;
    }

    public void setDescribeTranscation(String describeTranscation) {
        this.describeTranscation = describeTranscation == null ? null : describeTranscation.trim();
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }

    public Double getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(Double totalMoney) {
        this.totalMoney = totalMoney;
    }

    public Integer getStatusTranscation() {
        return statusTranscation;
    }

    public void setStatusTranscation(Integer statusTranscation) {
        this.statusTranscation = statusTranscation;
    }

    public Integer getStatusSettlement() {
        return statusSettlement;
    }

    public void setStatusSettlement(Integer statusSettlement) {
        this.statusSettlement = statusSettlement;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public String getZfbAccount() {
        return zfbAccount;
    }

    public void setZfbAccount(String zfbAccount) {
        this.zfbAccount = zfbAccount == null ? null : zfbAccount.trim();
    }

    public String getCreateTime() {
    	if(createTime==null) {
    		return "";
    	}
        return sdf.format(createTime);
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getFinishTime() {
    	if(finishTime==null) {
    		return "";
    	}
        return sdf.format(finishTime);
    }

    public void setFinishTime(Date finishTime) {
        this.finishTime = finishTime;
    }
}