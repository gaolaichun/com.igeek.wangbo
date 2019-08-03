package com.sm.model;

import java.util.Date;

public class ShopPicture {
    private Integer id;

    private String picture;

    private Integer pictureCategory;

    private Integer sid;

    private Date createTime;

    private Integer checkStatus;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture == null ? null : picture.trim();
    }

    public Integer getPictureCategory() {
        return pictureCategory;
    }

    public void setPictureCategory(Integer pictureCategory) {
        this.pictureCategory = pictureCategory;
    }

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getCheckStatus() {
        return checkStatus;
    }

    public void setCheckStatus(Integer checkStatus) {
        this.checkStatus = checkStatus;
    }
}