package com.sm.model;

import java.util.Date;

public class ShopOpeningHours {
    private Integer id;

    private Integer sid;

    private Date startTime;

    private Date endTime;

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

	@Override
	public String toString() {
		return "ShopOpeningHours [id=" + id + ", sid=" + sid + ", startTime=" + startTime + ", endTime=" + endTime
				+ "]";
	}
    
    
}