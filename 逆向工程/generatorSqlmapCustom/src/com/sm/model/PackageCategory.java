package com.sm.model;

public class PackageCategory {
    private Integer id;

    private String packageCategoryName;

    private Integer sid;

    private Integer categoryOrder;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPackageCategoryName() {
        return packageCategoryName;
    }

    public void setPackageCategoryName(String packageCategoryName) {
        this.packageCategoryName = packageCategoryName == null ? null : packageCategoryName.trim();
    }

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public Integer getCategoryOrder() {
        return categoryOrder;
    }

    public void setCategoryOrder(Integer categoryOrder) {
        this.categoryOrder = categoryOrder;
    }
}