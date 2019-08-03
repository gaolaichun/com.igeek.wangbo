package com.igeek.crm.vo;

/**
 * @author Administrator
 * @create 2019/05/14
 */
public class UserQueryVo {
    private String custName;
    private String source;
    private String industry;
    private String level;

    public String getCustName() {
        return custName;
    }

    public void setCustName(String custName) {
        this.custName = custName;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getIndustry() {
        return industry;
    }

    public void setIndustry(String industry) {
        this.industry = industry;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public UserQueryVo(String custName, String source, String industry, String level) {
        this.custName = custName;
        this.source = source;
        this.industry = industry;
        this.level = level;
    }

    public UserQueryVo() {
    }
}
