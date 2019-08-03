package com.sm.model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class User {
	
	 private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
    private Integer id;

    private String phone;

    private String password;

    private String nickname;

    private String birth;

    private Integer age;

    private Integer sex;

    private String headlink;

    private String balance;

    private String home;

    private String job;

    private String credit;

    private String canjiaParty;

    private String zuzhiParty;

    private Integer realName;

    private String uid;

    private String label;

    private String aspirationLabel;

    private Date registerTime;

    private String weixin;

    private String qq;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname == null ? null : nickname.trim();
    }

    public String getBirth() {
        return birth;
    }

    public void setBirth(String birth) {
        this.birth = birth == null ? null : birth.trim();
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getHeadlink() {
        return headlink;
    }

    public void setHeadlink(String headlink) {
        this.headlink = headlink == null ? null : headlink.trim();
    }

    public String getBalance() {
        return balance;
    }

    public void setBalance(String balance) {
        this.balance = balance == null ? null : balance.trim();
    }

    public String getHome() {
        return home;
    }

    public void setHome(String home) {
        this.home = home == null ? null : home.trim();
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job == null ? null : job.trim();
    }

    public String getCredit() {
        return credit;
    }

    public void setCredit(String credit) {
        this.credit = credit == null ? null : credit.trim();
    }

    public String getCanjiaParty() {
        return canjiaParty;
    }

    public void setCanjiaParty(String canjiaParty) {
        this.canjiaParty = canjiaParty == null ? null : canjiaParty.trim();
    }

    public String getZuzhiParty() {
        return zuzhiParty;
    }

    public void setZuzhiParty(String zuzhiParty) {
        this.zuzhiParty = zuzhiParty == null ? null : zuzhiParty.trim();
    }

    public Integer getRealName() {
        return realName;
    }

    public void setRealName(Integer realName) {
        this.realName = realName;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid == null ? null : uid.trim();
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label == null ? null : label.trim();
    }

    public String getAspirationLabel() {
        return aspirationLabel;
    }

    public void setAspirationLabel(String aspirationLabel) {
        this.aspirationLabel = aspirationLabel == null ? null : aspirationLabel.trim();
    }

    public String getRegisterTime() {
    	if(registerTime==null) {
    		return "";
    	}
        return sdf.format(registerTime);
    }

    public void setRegisterTime(Date registerTime) {
        this.registerTime = registerTime;
    }

    public String getWeixin() {
        return weixin;
    }

    public void setWeixin(String weixin) {
        this.weixin = weixin == null ? null : weixin.trim();
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq == null ? null : qq.trim();
    }
}