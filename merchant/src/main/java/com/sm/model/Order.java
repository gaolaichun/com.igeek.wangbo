package com.sm.model;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class Order {
	
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
    private Integer id;

    private String orderNo;

    private Integer uid;

    private Double price;

    private Date orderTime;

    private Integer coupon;

    private Integer redPackage;

    private Date payTime;

    private Integer sid;

    private Integer orderStatus;

    private String participants;

    private Integer packageId;

    private String note;

    private Integer partyId;

    private Date partyTime;
    
    private User user;
    
    private List<PackageDetail>packageDetailList;
    
    private Party party;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo == null ? null : orderNo.trim();
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getOrderTime() {
    	if(orderTime==null) {
    		return "";
    	}
        return sdf.format(orderTime);
    }

    public void setOrderTime(Date orderTime) {
        this.orderTime = orderTime;
    }

    public Integer getCoupon() {
        return coupon;
    }

    public void setCoupon(Integer coupon) {
        this.coupon = coupon;
    }

    public Integer getRedPackage() {
        return redPackage;
    }

    public void setRedPackage(Integer redPackage) {
        this.redPackage = redPackage;
    }

    public String getPayTime() {
    	if(payTime==null) {
    		return "";
    	}
        return sdf.format(payTime);
    }

    public void setPayTime(Date payTime) {
        this.payTime = payTime;
    }

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public Integer getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(Integer orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getParticipants() {
        return participants;
    }

    public void setParticipants(String participants) {
        this.participants = participants == null ? null : participants.trim();
    }

    public Integer getPackageId() {
        return packageId;
    }

    public void setPackageId(Integer packageId) {
        this.packageId = packageId;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note == null ? null : note.trim();
    }

    public Integer getPartyId() {
        return partyId;
    }

    public void setPartyId(Integer partyId) {
        this.partyId = partyId;
    }

    public String getPartyTime() {
    	if(partyTime==null) {
    		return "";
    	}
        return sdf.format(partyTime);
    }

    public void setPartyTime(Date partyTime) {
        this.partyTime = partyTime;
    }

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<PackageDetail> getPackageDetailList() {
		return packageDetailList;
	}

	public void setPackageDetailList(List<PackageDetail> packageDetailList) {
		this.packageDetailList = packageDetailList;
	}

	public Party getParty() {
		return party;
	}

	public void setParty(Party party) {
		this.party = party;
	}
}