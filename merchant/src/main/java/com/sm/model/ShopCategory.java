package com.sm.model;

import java.util.Date;

public class ShopCategory {
    private Integer id;

    private String categoryName;

    private Date createTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName == null ? null : categoryName.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

	@Override
	public String toString() {
		return "ShopCategory [id=" + id + ", categoryName=" + categoryName + ", createTime=" + createTime + "]";
	}
    
    
}