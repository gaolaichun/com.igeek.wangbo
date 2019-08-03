package com.sm.model;

import java.util.ArrayList;
import java.util.List;

public class PersonalQualificationExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PersonalQualificationExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andCertificateTypeIsNull() {
            addCriterion("certificate_type is null");
            return (Criteria) this;
        }

        public Criteria andCertificateTypeIsNotNull() {
            addCriterion("certificate_type is not null");
            return (Criteria) this;
        }

        public Criteria andCertificateTypeEqualTo(String value) {
            addCriterion("certificate_type =", value, "certificateType");
            return (Criteria) this;
        }

        public Criteria andCertificateTypeNotEqualTo(String value) {
            addCriterion("certificate_type <>", value, "certificateType");
            return (Criteria) this;
        }

        public Criteria andCertificateTypeGreaterThan(String value) {
            addCriterion("certificate_type >", value, "certificateType");
            return (Criteria) this;
        }

        public Criteria andCertificateTypeGreaterThanOrEqualTo(String value) {
            addCriterion("certificate_type >=", value, "certificateType");
            return (Criteria) this;
        }

        public Criteria andCertificateTypeLessThan(String value) {
            addCriterion("certificate_type <", value, "certificateType");
            return (Criteria) this;
        }

        public Criteria andCertificateTypeLessThanOrEqualTo(String value) {
            addCriterion("certificate_type <=", value, "certificateType");
            return (Criteria) this;
        }

        public Criteria andCertificateTypeLike(String value) {
            addCriterion("certificate_type like", value, "certificateType");
            return (Criteria) this;
        }

        public Criteria andCertificateTypeNotLike(String value) {
            addCriterion("certificate_type not like", value, "certificateType");
            return (Criteria) this;
        }

        public Criteria andCertificateTypeIn(List<String> values) {
            addCriterion("certificate_type in", values, "certificateType");
            return (Criteria) this;
        }

        public Criteria andCertificateTypeNotIn(List<String> values) {
            addCriterion("certificate_type not in", values, "certificateType");
            return (Criteria) this;
        }

        public Criteria andCertificateTypeBetween(String value1, String value2) {
            addCriterion("certificate_type between", value1, value2, "certificateType");
            return (Criteria) this;
        }

        public Criteria andCertificateTypeNotBetween(String value1, String value2) {
            addCriterion("certificate_type not between", value1, value2, "certificateType");
            return (Criteria) this;
        }

        public Criteria andRealnameIsNull() {
            addCriterion("realname is null");
            return (Criteria) this;
        }

        public Criteria andRealnameIsNotNull() {
            addCriterion("realname is not null");
            return (Criteria) this;
        }

        public Criteria andRealnameEqualTo(String value) {
            addCriterion("realname =", value, "realname");
            return (Criteria) this;
        }

        public Criteria andRealnameNotEqualTo(String value) {
            addCriterion("realname <>", value, "realname");
            return (Criteria) this;
        }

        public Criteria andRealnameGreaterThan(String value) {
            addCriterion("realname >", value, "realname");
            return (Criteria) this;
        }

        public Criteria andRealnameGreaterThanOrEqualTo(String value) {
            addCriterion("realname >=", value, "realname");
            return (Criteria) this;
        }

        public Criteria andRealnameLessThan(String value) {
            addCriterion("realname <", value, "realname");
            return (Criteria) this;
        }

        public Criteria andRealnameLessThanOrEqualTo(String value) {
            addCriterion("realname <=", value, "realname");
            return (Criteria) this;
        }

        public Criteria andRealnameLike(String value) {
            addCriterion("realname like", value, "realname");
            return (Criteria) this;
        }

        public Criteria andRealnameNotLike(String value) {
            addCriterion("realname not like", value, "realname");
            return (Criteria) this;
        }

        public Criteria andRealnameIn(List<String> values) {
            addCriterion("realname in", values, "realname");
            return (Criteria) this;
        }

        public Criteria andRealnameNotIn(List<String> values) {
            addCriterion("realname not in", values, "realname");
            return (Criteria) this;
        }

        public Criteria andRealnameBetween(String value1, String value2) {
            addCriterion("realname between", value1, value2, "realname");
            return (Criteria) this;
        }

        public Criteria andRealnameNotBetween(String value1, String value2) {
            addCriterion("realname not between", value1, value2, "realname");
            return (Criteria) this;
        }

        public Criteria andCertificateNoIsNull() {
            addCriterion("certificate_no is null");
            return (Criteria) this;
        }

        public Criteria andCertificateNoIsNotNull() {
            addCriterion("certificate_no is not null");
            return (Criteria) this;
        }

        public Criteria andCertificateNoEqualTo(String value) {
            addCriterion("certificate_no =", value, "certificateNo");
            return (Criteria) this;
        }

        public Criteria andCertificateNoNotEqualTo(String value) {
            addCriterion("certificate_no <>", value, "certificateNo");
            return (Criteria) this;
        }

        public Criteria andCertificateNoGreaterThan(String value) {
            addCriterion("certificate_no >", value, "certificateNo");
            return (Criteria) this;
        }

        public Criteria andCertificateNoGreaterThanOrEqualTo(String value) {
            addCriterion("certificate_no >=", value, "certificateNo");
            return (Criteria) this;
        }

        public Criteria andCertificateNoLessThan(String value) {
            addCriterion("certificate_no <", value, "certificateNo");
            return (Criteria) this;
        }

        public Criteria andCertificateNoLessThanOrEqualTo(String value) {
            addCriterion("certificate_no <=", value, "certificateNo");
            return (Criteria) this;
        }

        public Criteria andCertificateNoLike(String value) {
            addCriterion("certificate_no like", value, "certificateNo");
            return (Criteria) this;
        }

        public Criteria andCertificateNoNotLike(String value) {
            addCriterion("certificate_no not like", value, "certificateNo");
            return (Criteria) this;
        }

        public Criteria andCertificateNoIn(List<String> values) {
            addCriterion("certificate_no in", values, "certificateNo");
            return (Criteria) this;
        }

        public Criteria andCertificateNoNotIn(List<String> values) {
            addCriterion("certificate_no not in", values, "certificateNo");
            return (Criteria) this;
        }

        public Criteria andCertificateNoBetween(String value1, String value2) {
            addCriterion("certificate_no between", value1, value2, "certificateNo");
            return (Criteria) this;
        }

        public Criteria andCertificateNoNotBetween(String value1, String value2) {
            addCriterion("certificate_no not between", value1, value2, "certificateNo");
            return (Criteria) this;
        }

        public Criteria andCertificationStatusIsNull() {
            addCriterion("certification_status is null");
            return (Criteria) this;
        }

        public Criteria andCertificationStatusIsNotNull() {
            addCriterion("certification_status is not null");
            return (Criteria) this;
        }

        public Criteria andCertificationStatusEqualTo(Integer value) {
            addCriterion("certification_status =", value, "certificationStatus");
            return (Criteria) this;
        }

        public Criteria andCertificationStatusNotEqualTo(Integer value) {
            addCriterion("certification_status <>", value, "certificationStatus");
            return (Criteria) this;
        }

        public Criteria andCertificationStatusGreaterThan(Integer value) {
            addCriterion("certification_status >", value, "certificationStatus");
            return (Criteria) this;
        }

        public Criteria andCertificationStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("certification_status >=", value, "certificationStatus");
            return (Criteria) this;
        }

        public Criteria andCertificationStatusLessThan(Integer value) {
            addCriterion("certification_status <", value, "certificationStatus");
            return (Criteria) this;
        }

        public Criteria andCertificationStatusLessThanOrEqualTo(Integer value) {
            addCriterion("certification_status <=", value, "certificationStatus");
            return (Criteria) this;
        }

        public Criteria andCertificationStatusIn(List<Integer> values) {
            addCriterion("certification_status in", values, "certificationStatus");
            return (Criteria) this;
        }

        public Criteria andCertificationStatusNotIn(List<Integer> values) {
            addCriterion("certification_status not in", values, "certificationStatus");
            return (Criteria) this;
        }

        public Criteria andCertificationStatusBetween(Integer value1, Integer value2) {
            addCriterion("certification_status between", value1, value2, "certificationStatus");
            return (Criteria) this;
        }

        public Criteria andCertificationStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("certification_status not between", value1, value2, "certificationStatus");
            return (Criteria) this;
        }

        public Criteria andSidIsNull() {
            addCriterion("sid is null");
            return (Criteria) this;
        }

        public Criteria andSidIsNotNull() {
            addCriterion("sid is not null");
            return (Criteria) this;
        }

        public Criteria andSidEqualTo(Integer value) {
            addCriterion("sid =", value, "sid");
            return (Criteria) this;
        }

        public Criteria andSidNotEqualTo(Integer value) {
            addCriterion("sid <>", value, "sid");
            return (Criteria) this;
        }

        public Criteria andSidGreaterThan(Integer value) {
            addCriterion("sid >", value, "sid");
            return (Criteria) this;
        }

        public Criteria andSidGreaterThanOrEqualTo(Integer value) {
            addCriterion("sid >=", value, "sid");
            return (Criteria) this;
        }

        public Criteria andSidLessThan(Integer value) {
            addCriterion("sid <", value, "sid");
            return (Criteria) this;
        }

        public Criteria andSidLessThanOrEqualTo(Integer value) {
            addCriterion("sid <=", value, "sid");
            return (Criteria) this;
        }

        public Criteria andSidIn(List<Integer> values) {
            addCriterion("sid in", values, "sid");
            return (Criteria) this;
        }

        public Criteria andSidNotIn(List<Integer> values) {
            addCriterion("sid not in", values, "sid");
            return (Criteria) this;
        }

        public Criteria andSidBetween(Integer value1, Integer value2) {
            addCriterion("sid between", value1, value2, "sid");
            return (Criteria) this;
        }

        public Criteria andSidNotBetween(Integer value1, Integer value2) {
            addCriterion("sid not between", value1, value2, "sid");
            return (Criteria) this;
        }

        public Criteria andIdcardPiconeIsNull() {
            addCriterion("idcard_picone is null");
            return (Criteria) this;
        }

        public Criteria andIdcardPiconeIsNotNull() {
            addCriterion("idcard_picone is not null");
            return (Criteria) this;
        }

        public Criteria andIdcardPiconeEqualTo(String value) {
            addCriterion("idcard_picone =", value, "idcardPicone");
            return (Criteria) this;
        }

        public Criteria andIdcardPiconeNotEqualTo(String value) {
            addCriterion("idcard_picone <>", value, "idcardPicone");
            return (Criteria) this;
        }

        public Criteria andIdcardPiconeGreaterThan(String value) {
            addCriterion("idcard_picone >", value, "idcardPicone");
            return (Criteria) this;
        }

        public Criteria andIdcardPiconeGreaterThanOrEqualTo(String value) {
            addCriterion("idcard_picone >=", value, "idcardPicone");
            return (Criteria) this;
        }

        public Criteria andIdcardPiconeLessThan(String value) {
            addCriterion("idcard_picone <", value, "idcardPicone");
            return (Criteria) this;
        }

        public Criteria andIdcardPiconeLessThanOrEqualTo(String value) {
            addCriterion("idcard_picone <=", value, "idcardPicone");
            return (Criteria) this;
        }

        public Criteria andIdcardPiconeLike(String value) {
            addCriterion("idcard_picone like", value, "idcardPicone");
            return (Criteria) this;
        }

        public Criteria andIdcardPiconeNotLike(String value) {
            addCriterion("idcard_picone not like", value, "idcardPicone");
            return (Criteria) this;
        }

        public Criteria andIdcardPiconeIn(List<String> values) {
            addCriterion("idcard_picone in", values, "idcardPicone");
            return (Criteria) this;
        }

        public Criteria andIdcardPiconeNotIn(List<String> values) {
            addCriterion("idcard_picone not in", values, "idcardPicone");
            return (Criteria) this;
        }

        public Criteria andIdcardPiconeBetween(String value1, String value2) {
            addCriterion("idcard_picone between", value1, value2, "idcardPicone");
            return (Criteria) this;
        }

        public Criteria andIdcardPiconeNotBetween(String value1, String value2) {
            addCriterion("idcard_picone not between", value1, value2, "idcardPicone");
            return (Criteria) this;
        }

        public Criteria andIdcardPictwoIsNull() {
            addCriterion("idcard_pictwo is null");
            return (Criteria) this;
        }

        public Criteria andIdcardPictwoIsNotNull() {
            addCriterion("idcard_pictwo is not null");
            return (Criteria) this;
        }

        public Criteria andIdcardPictwoEqualTo(String value) {
            addCriterion("idcard_pictwo =", value, "idcardPictwo");
            return (Criteria) this;
        }

        public Criteria andIdcardPictwoNotEqualTo(String value) {
            addCriterion("idcard_pictwo <>", value, "idcardPictwo");
            return (Criteria) this;
        }

        public Criteria andIdcardPictwoGreaterThan(String value) {
            addCriterion("idcard_pictwo >", value, "idcardPictwo");
            return (Criteria) this;
        }

        public Criteria andIdcardPictwoGreaterThanOrEqualTo(String value) {
            addCriterion("idcard_pictwo >=", value, "idcardPictwo");
            return (Criteria) this;
        }

        public Criteria andIdcardPictwoLessThan(String value) {
            addCriterion("idcard_pictwo <", value, "idcardPictwo");
            return (Criteria) this;
        }

        public Criteria andIdcardPictwoLessThanOrEqualTo(String value) {
            addCriterion("idcard_pictwo <=", value, "idcardPictwo");
            return (Criteria) this;
        }

        public Criteria andIdcardPictwoLike(String value) {
            addCriterion("idcard_pictwo like", value, "idcardPictwo");
            return (Criteria) this;
        }

        public Criteria andIdcardPictwoNotLike(String value) {
            addCriterion("idcard_pictwo not like", value, "idcardPictwo");
            return (Criteria) this;
        }

        public Criteria andIdcardPictwoIn(List<String> values) {
            addCriterion("idcard_pictwo in", values, "idcardPictwo");
            return (Criteria) this;
        }

        public Criteria andIdcardPictwoNotIn(List<String> values) {
            addCriterion("idcard_pictwo not in", values, "idcardPictwo");
            return (Criteria) this;
        }

        public Criteria andIdcardPictwoBetween(String value1, String value2) {
            addCriterion("idcard_pictwo between", value1, value2, "idcardPictwo");
            return (Criteria) this;
        }

        public Criteria andIdcardPictwoNotBetween(String value1, String value2) {
            addCriterion("idcard_pictwo not between", value1, value2, "idcardPictwo");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}