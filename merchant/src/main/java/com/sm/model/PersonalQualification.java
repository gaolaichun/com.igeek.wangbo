package com.sm.model;

public class PersonalQualification {
    private Integer id;

    private String certificateType;

    private String realname;

    private String certificateNo;

    private Integer certificationStatus;

    private Integer sid;

    private String idcardPicone;

    private String idcardPictwo;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCertificateType() {
        return certificateType;
    }

    public void setCertificateType(String certificateType) {
        this.certificateType = certificateType == null ? null : certificateType.trim();
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname == null ? null : realname.trim();
    }

    public String getCertificateNo() {
        return certificateNo;
    }

    public void setCertificateNo(String certificateNo) {
        this.certificateNo = certificateNo == null ? null : certificateNo.trim();
    }

    public Integer getCertificationStatus() {
        return certificationStatus;
    }

    public void setCertificationStatus(Integer certificationStatus) {
        this.certificationStatus = certificationStatus;
    }

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public String getIdcardPicone() {
        return idcardPicone;
    }

    public void setIdcardPicone(String idcardPicone) {
        this.idcardPicone = idcardPicone == null ? null : idcardPicone.trim();
    }

    public String getIdcardPictwo() {
        return idcardPictwo;
    }

    public void setIdcardPictwo(String idcardPictwo) {
        this.idcardPictwo = idcardPictwo == null ? null : idcardPictwo.trim();
    }

	@Override
	public String toString() {
		return "PersonalQualification [id=" + id + ", certificateType=" + certificateType + ", realname=" + realname
				+ ", certificateNo=" + certificateNo + ", certificationStatus=" + certificationStatus + ", sid=" + sid
				+ ", idcardPicone=" + idcardPicone + ", idcardPictwo=" + idcardPictwo + "]";
	}
    
    
}