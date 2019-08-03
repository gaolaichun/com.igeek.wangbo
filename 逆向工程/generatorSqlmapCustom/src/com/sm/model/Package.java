package com.sm.model;

import java.util.Date;

public class Package {
    private Integer id;

    private Integer sid;

    private String packageName;

    private Integer packageStatus;

    private Date startTime;

    private Date endTime;

    private String priority;

    private Integer sale;

    private String packagePicture;

    private Integer peopleNumber;

    private Integer currentStock;

    private Integer maxStock;

    private Double price;

    private Integer packageCategory;

    private Integer packageSort;

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

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName == null ? null : packageName.trim();
    }

    public Integer getPackageStatus() {
        return packageStatus;
    }

    public void setPackageStatus(Integer packageStatus) {
        this.packageStatus = packageStatus;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority == null ? null : priority.trim();
    }

    public Integer getSale() {
        return sale;
    }

    public void setSale(Integer sale) {
        this.sale = sale;
    }

    public String getPackagePicture() {
        return packagePicture;
    }

    public void setPackagePicture(String packagePicture) {
        this.packagePicture = packagePicture == null ? null : packagePicture.trim();
    }

    public Integer getPeopleNumber() {
        return peopleNumber;
    }

    public void setPeopleNumber(Integer peopleNumber) {
        this.peopleNumber = peopleNumber;
    }

    public Integer getCurrentStock() {
        return currentStock;
    }

    public void setCurrentStock(Integer currentStock) {
        this.currentStock = currentStock;
    }

    public Integer getMaxStock() {
        return maxStock;
    }

    public void setMaxStock(Integer maxStock) {
        this.maxStock = maxStock;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getPackageCategory() {
        return packageCategory;
    }

    public void setPackageCategory(Integer packageCategory) {
        this.packageCategory = packageCategory;
    }

    public Integer getPackageSort() {
        return packageSort;
    }

    public void setPackageSort(Integer packageSort) {
        this.packageSort = packageSort;
    }
}