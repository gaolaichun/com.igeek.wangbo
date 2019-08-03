package com.sm.model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Party {
	
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
    private Integer id;

    private Integer pid;

    private Integer uid;

    private Integer sid;

    private String model;

    private String agreedTime;

    private String limitPerson;

    private String limitSex;

    private String limitAge;

    private String trust;

    private String allUid;

    private Double price;

    private String partyInstruction;

    private Date createTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model == null ? null : model.trim();
    }

    public String getAgreedTime() {
        return agreedTime;
    }

    public void setAgreedTime(String agreedTime) {
        this.agreedTime = agreedTime == null ? null : agreedTime.trim();
    }

    public String getLimitPerson() {
        return limitPerson;
    }

    public void setLimitPerson(String limitPerson) {
        this.limitPerson = limitPerson == null ? null : limitPerson.trim();
    }

    public String getLimitSex() {
        return limitSex;
    }

    public void setLimitSex(String limitSex) {
        this.limitSex = limitSex == null ? null : limitSex.trim();
    }

    public String getLimitAge() {
        return limitAge;
    }

    public void setLimitAge(String limitAge) {
        this.limitAge = limitAge == null ? null : limitAge.trim();
    }

    public String getTrust() {
        return trust;
    }

    public void setTrust(String trust) {
        this.trust = trust == null ? null : trust.trim();
    }

    public String getAllUid() {
        return allUid;
    }

    public void setAllUid(String allUid) {
        this.allUid = allUid == null ? null : allUid.trim();
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getPartyInstruction() {
        return partyInstruction;
    }

    public void setPartyInstruction(String partyInstruction) {
        this.partyInstruction = partyInstruction == null ? null : partyInstruction.trim();
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
}