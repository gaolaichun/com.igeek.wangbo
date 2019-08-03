package com.sm.model;

public class PackageCategory {
    private Integer id;

    private String packageCategoryName;

    private Integer sid;

    private Integer categoryOrder;

    private Integer sortMode;

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

    public Integer getSortMode() {
        return sortMode;
    }

    public void setSortMode(Integer sortMode) {
        this.sortMode = sortMode;
    }

	@Override
	public String toString() {
		return "PackageCategory [id=" + id + ", packageCategoryName=" + packageCategoryName + ", sid=" + sid
				+ ", categoryOrder=" + categoryOrder + ", sortMode=" + sortMode + "]";
	}
    
    
}