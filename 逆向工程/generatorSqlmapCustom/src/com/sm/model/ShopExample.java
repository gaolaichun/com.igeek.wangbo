package com.sm.model;

import java.util.ArrayList;
import java.util.List;

public class ShopExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ShopExample() {
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

        public Criteria andShopNameIsNull() {
            addCriterion("shop_name is null");
            return (Criteria) this;
        }

        public Criteria andShopNameIsNotNull() {
            addCriterion("shop_name is not null");
            return (Criteria) this;
        }

        public Criteria andShopNameEqualTo(String value) {
            addCriterion("shop_name =", value, "shopName");
            return (Criteria) this;
        }

        public Criteria andShopNameNotEqualTo(String value) {
            addCriterion("shop_name <>", value, "shopName");
            return (Criteria) this;
        }

        public Criteria andShopNameGreaterThan(String value) {
            addCriterion("shop_name >", value, "shopName");
            return (Criteria) this;
        }

        public Criteria andShopNameGreaterThanOrEqualTo(String value) {
            addCriterion("shop_name >=", value, "shopName");
            return (Criteria) this;
        }

        public Criteria andShopNameLessThan(String value) {
            addCriterion("shop_name <", value, "shopName");
            return (Criteria) this;
        }

        public Criteria andShopNameLessThanOrEqualTo(String value) {
            addCriterion("shop_name <=", value, "shopName");
            return (Criteria) this;
        }

        public Criteria andShopNameLike(String value) {
            addCriterion("shop_name like", value, "shopName");
            return (Criteria) this;
        }

        public Criteria andShopNameNotLike(String value) {
            addCriterion("shop_name not like", value, "shopName");
            return (Criteria) this;
        }

        public Criteria andShopNameIn(List<String> values) {
            addCriterion("shop_name in", values, "shopName");
            return (Criteria) this;
        }

        public Criteria andShopNameNotIn(List<String> values) {
            addCriterion("shop_name not in", values, "shopName");
            return (Criteria) this;
        }

        public Criteria andShopNameBetween(String value1, String value2) {
            addCriterion("shop_name between", value1, value2, "shopName");
            return (Criteria) this;
        }

        public Criteria andShopNameNotBetween(String value1, String value2) {
            addCriterion("shop_name not between", value1, value2, "shopName");
            return (Criteria) this;
        }

        public Criteria andPasswordIsNull() {
            addCriterion("password is null");
            return (Criteria) this;
        }

        public Criteria andPasswordIsNotNull() {
            addCriterion("password is not null");
            return (Criteria) this;
        }

        public Criteria andPasswordEqualTo(String value) {
            addCriterion("password =", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotEqualTo(String value) {
            addCriterion("password <>", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordGreaterThan(String value) {
            addCriterion("password >", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordGreaterThanOrEqualTo(String value) {
            addCriterion("password >=", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLessThan(String value) {
            addCriterion("password <", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLessThanOrEqualTo(String value) {
            addCriterion("password <=", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLike(String value) {
            addCriterion("password like", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotLike(String value) {
            addCriterion("password not like", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordIn(List<String> values) {
            addCriterion("password in", values, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotIn(List<String> values) {
            addCriterion("password not in", values, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordBetween(String value1, String value2) {
            addCriterion("password between", value1, value2, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotBetween(String value1, String value2) {
            addCriterion("password not between", value1, value2, "password");
            return (Criteria) this;
        }

        public Criteria andNameIsNull() {
            addCriterion("name is null");
            return (Criteria) this;
        }

        public Criteria andNameIsNotNull() {
            addCriterion("name is not null");
            return (Criteria) this;
        }

        public Criteria andNameEqualTo(String value) {
            addCriterion("name =", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotEqualTo(String value) {
            addCriterion("name <>", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThan(String value) {
            addCriterion("name >", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThanOrEqualTo(String value) {
            addCriterion("name >=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThan(String value) {
            addCriterion("name <", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThanOrEqualTo(String value) {
            addCriterion("name <=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLike(String value) {
            addCriterion("name like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotLike(String value) {
            addCriterion("name not like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameIn(List<String> values) {
            addCriterion("name in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotIn(List<String> values) {
            addCriterion("name not in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameBetween(String value1, String value2) {
            addCriterion("name between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotBetween(String value1, String value2) {
            addCriterion("name not between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andLongitudeIsNull() {
            addCriterion("longitude is null");
            return (Criteria) this;
        }

        public Criteria andLongitudeIsNotNull() {
            addCriterion("longitude is not null");
            return (Criteria) this;
        }

        public Criteria andLongitudeEqualTo(String value) {
            addCriterion("longitude =", value, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeNotEqualTo(String value) {
            addCriterion("longitude <>", value, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeGreaterThan(String value) {
            addCriterion("longitude >", value, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeGreaterThanOrEqualTo(String value) {
            addCriterion("longitude >=", value, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeLessThan(String value) {
            addCriterion("longitude <", value, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeLessThanOrEqualTo(String value) {
            addCriterion("longitude <=", value, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeLike(String value) {
            addCriterion("longitude like", value, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeNotLike(String value) {
            addCriterion("longitude not like", value, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeIn(List<String> values) {
            addCriterion("longitude in", values, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeNotIn(List<String> values) {
            addCriterion("longitude not in", values, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeBetween(String value1, String value2) {
            addCriterion("longitude between", value1, value2, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeNotBetween(String value1, String value2) {
            addCriterion("longitude not between", value1, value2, "longitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeIsNull() {
            addCriterion("latitude is null");
            return (Criteria) this;
        }

        public Criteria andLatitudeIsNotNull() {
            addCriterion("latitude is not null");
            return (Criteria) this;
        }

        public Criteria andLatitudeEqualTo(String value) {
            addCriterion("latitude =", value, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeNotEqualTo(String value) {
            addCriterion("latitude <>", value, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeGreaterThan(String value) {
            addCriterion("latitude >", value, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeGreaterThanOrEqualTo(String value) {
            addCriterion("latitude >=", value, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeLessThan(String value) {
            addCriterion("latitude <", value, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeLessThanOrEqualTo(String value) {
            addCriterion("latitude <=", value, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeLike(String value) {
            addCriterion("latitude like", value, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeNotLike(String value) {
            addCriterion("latitude not like", value, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeIn(List<String> values) {
            addCriterion("latitude in", values, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeNotIn(List<String> values) {
            addCriterion("latitude not in", values, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeBetween(String value1, String value2) {
            addCriterion("latitude between", value1, value2, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeNotBetween(String value1, String value2) {
            addCriterion("latitude not between", value1, value2, "latitude");
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

        public Criteria andIndustryQualificationIsNull() {
            addCriterion("industry_qualification is null");
            return (Criteria) this;
        }

        public Criteria andIndustryQualificationIsNotNull() {
            addCriterion("industry_qualification is not null");
            return (Criteria) this;
        }

        public Criteria andIndustryQualificationEqualTo(String value) {
            addCriterion("industry_qualification =", value, "industryQualification");
            return (Criteria) this;
        }

        public Criteria andIndustryQualificationNotEqualTo(String value) {
            addCriterion("industry_qualification <>", value, "industryQualification");
            return (Criteria) this;
        }

        public Criteria andIndustryQualificationGreaterThan(String value) {
            addCriterion("industry_qualification >", value, "industryQualification");
            return (Criteria) this;
        }

        public Criteria andIndustryQualificationGreaterThanOrEqualTo(String value) {
            addCriterion("industry_qualification >=", value, "industryQualification");
            return (Criteria) this;
        }

        public Criteria andIndustryQualificationLessThan(String value) {
            addCriterion("industry_qualification <", value, "industryQualification");
            return (Criteria) this;
        }

        public Criteria andIndustryQualificationLessThanOrEqualTo(String value) {
            addCriterion("industry_qualification <=", value, "industryQualification");
            return (Criteria) this;
        }

        public Criteria andIndustryQualificationLike(String value) {
            addCriterion("industry_qualification like", value, "industryQualification");
            return (Criteria) this;
        }

        public Criteria andIndustryQualificationNotLike(String value) {
            addCriterion("industry_qualification not like", value, "industryQualification");
            return (Criteria) this;
        }

        public Criteria andIndustryQualificationIn(List<String> values) {
            addCriterion("industry_qualification in", values, "industryQualification");
            return (Criteria) this;
        }

        public Criteria andIndustryQualificationNotIn(List<String> values) {
            addCriterion("industry_qualification not in", values, "industryQualification");
            return (Criteria) this;
        }

        public Criteria andIndustryQualificationBetween(String value1, String value2) {
            addCriterion("industry_qualification between", value1, value2, "industryQualification");
            return (Criteria) this;
        }

        public Criteria andIndustryQualificationNotBetween(String value1, String value2) {
            addCriterion("industry_qualification not between", value1, value2, "industryQualification");
            return (Criteria) this;
        }

        public Criteria andSubjectQualificationIsNull() {
            addCriterion("subject_qualification is null");
            return (Criteria) this;
        }

        public Criteria andSubjectQualificationIsNotNull() {
            addCriterion("subject_qualification is not null");
            return (Criteria) this;
        }

        public Criteria andSubjectQualificationEqualTo(String value) {
            addCriterion("subject_qualification =", value, "subjectQualification");
            return (Criteria) this;
        }

        public Criteria andSubjectQualificationNotEqualTo(String value) {
            addCriterion("subject_qualification <>", value, "subjectQualification");
            return (Criteria) this;
        }

        public Criteria andSubjectQualificationGreaterThan(String value) {
            addCriterion("subject_qualification >", value, "subjectQualification");
            return (Criteria) this;
        }

        public Criteria andSubjectQualificationGreaterThanOrEqualTo(String value) {
            addCriterion("subject_qualification >=", value, "subjectQualification");
            return (Criteria) this;
        }

        public Criteria andSubjectQualificationLessThan(String value) {
            addCriterion("subject_qualification <", value, "subjectQualification");
            return (Criteria) this;
        }

        public Criteria andSubjectQualificationLessThanOrEqualTo(String value) {
            addCriterion("subject_qualification <=", value, "subjectQualification");
            return (Criteria) this;
        }

        public Criteria andSubjectQualificationLike(String value) {
            addCriterion("subject_qualification like", value, "subjectQualification");
            return (Criteria) this;
        }

        public Criteria andSubjectQualificationNotLike(String value) {
            addCriterion("subject_qualification not like", value, "subjectQualification");
            return (Criteria) this;
        }

        public Criteria andSubjectQualificationIn(List<String> values) {
            addCriterion("subject_qualification in", values, "subjectQualification");
            return (Criteria) this;
        }

        public Criteria andSubjectQualificationNotIn(List<String> values) {
            addCriterion("subject_qualification not in", values, "subjectQualification");
            return (Criteria) this;
        }

        public Criteria andSubjectQualificationBetween(String value1, String value2) {
            addCriterion("subject_qualification between", value1, value2, "subjectQualification");
            return (Criteria) this;
        }

        public Criteria andSubjectQualificationNotBetween(String value1, String value2) {
            addCriterion("subject_qualification not between", value1, value2, "subjectQualification");
            return (Criteria) this;
        }

        public Criteria andSpecialQualificationIsNull() {
            addCriterion("special_qualification is null");
            return (Criteria) this;
        }

        public Criteria andSpecialQualificationIsNotNull() {
            addCriterion("special_qualification is not null");
            return (Criteria) this;
        }

        public Criteria andSpecialQualificationEqualTo(String value) {
            addCriterion("special_qualification =", value, "specialQualification");
            return (Criteria) this;
        }

        public Criteria andSpecialQualificationNotEqualTo(String value) {
            addCriterion("special_qualification <>", value, "specialQualification");
            return (Criteria) this;
        }

        public Criteria andSpecialQualificationGreaterThan(String value) {
            addCriterion("special_qualification >", value, "specialQualification");
            return (Criteria) this;
        }

        public Criteria andSpecialQualificationGreaterThanOrEqualTo(String value) {
            addCriterion("special_qualification >=", value, "specialQualification");
            return (Criteria) this;
        }

        public Criteria andSpecialQualificationLessThan(String value) {
            addCriterion("special_qualification <", value, "specialQualification");
            return (Criteria) this;
        }

        public Criteria andSpecialQualificationLessThanOrEqualTo(String value) {
            addCriterion("special_qualification <=", value, "specialQualification");
            return (Criteria) this;
        }

        public Criteria andSpecialQualificationLike(String value) {
            addCriterion("special_qualification like", value, "specialQualification");
            return (Criteria) this;
        }

        public Criteria andSpecialQualificationNotLike(String value) {
            addCriterion("special_qualification not like", value, "specialQualification");
            return (Criteria) this;
        }

        public Criteria andSpecialQualificationIn(List<String> values) {
            addCriterion("special_qualification in", values, "specialQualification");
            return (Criteria) this;
        }

        public Criteria andSpecialQualificationNotIn(List<String> values) {
            addCriterion("special_qualification not in", values, "specialQualification");
            return (Criteria) this;
        }

        public Criteria andSpecialQualificationBetween(String value1, String value2) {
            addCriterion("special_qualification between", value1, value2, "specialQualification");
            return (Criteria) this;
        }

        public Criteria andSpecialQualificationNotBetween(String value1, String value2) {
            addCriterion("special_qualification not between", value1, value2, "specialQualification");
            return (Criteria) this;
        }

        public Criteria andHeadlinkIsNull() {
            addCriterion("headlink is null");
            return (Criteria) this;
        }

        public Criteria andHeadlinkIsNotNull() {
            addCriterion("headlink is not null");
            return (Criteria) this;
        }

        public Criteria andHeadlinkEqualTo(String value) {
            addCriterion("headlink =", value, "headlink");
            return (Criteria) this;
        }

        public Criteria andHeadlinkNotEqualTo(String value) {
            addCriterion("headlink <>", value, "headlink");
            return (Criteria) this;
        }

        public Criteria andHeadlinkGreaterThan(String value) {
            addCriterion("headlink >", value, "headlink");
            return (Criteria) this;
        }

        public Criteria andHeadlinkGreaterThanOrEqualTo(String value) {
            addCriterion("headlink >=", value, "headlink");
            return (Criteria) this;
        }

        public Criteria andHeadlinkLessThan(String value) {
            addCriterion("headlink <", value, "headlink");
            return (Criteria) this;
        }

        public Criteria andHeadlinkLessThanOrEqualTo(String value) {
            addCriterion("headlink <=", value, "headlink");
            return (Criteria) this;
        }

        public Criteria andHeadlinkLike(String value) {
            addCriterion("headlink like", value, "headlink");
            return (Criteria) this;
        }

        public Criteria andHeadlinkNotLike(String value) {
            addCriterion("headlink not like", value, "headlink");
            return (Criteria) this;
        }

        public Criteria andHeadlinkIn(List<String> values) {
            addCriterion("headlink in", values, "headlink");
            return (Criteria) this;
        }

        public Criteria andHeadlinkNotIn(List<String> values) {
            addCriterion("headlink not in", values, "headlink");
            return (Criteria) this;
        }

        public Criteria andHeadlinkBetween(String value1, String value2) {
            addCriterion("headlink between", value1, value2, "headlink");
            return (Criteria) this;
        }

        public Criteria andHeadlinkNotBetween(String value1, String value2) {
            addCriterion("headlink not between", value1, value2, "headlink");
            return (Criteria) this;
        }

        public Criteria andPhoneIsNull() {
            addCriterion("phone is null");
            return (Criteria) this;
        }

        public Criteria andPhoneIsNotNull() {
            addCriterion("phone is not null");
            return (Criteria) this;
        }

        public Criteria andPhoneEqualTo(String value) {
            addCriterion("phone =", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotEqualTo(String value) {
            addCriterion("phone <>", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneGreaterThan(String value) {
            addCriterion("phone >", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("phone >=", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneLessThan(String value) {
            addCriterion("phone <", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneLessThanOrEqualTo(String value) {
            addCriterion("phone <=", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneLike(String value) {
            addCriterion("phone like", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotLike(String value) {
            addCriterion("phone not like", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneIn(List<String> values) {
            addCriterion("phone in", values, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotIn(List<String> values) {
            addCriterion("phone not in", values, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneBetween(String value1, String value2) {
            addCriterion("phone between", value1, value2, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotBetween(String value1, String value2) {
            addCriterion("phone not between", value1, value2, "phone");
            return (Criteria) this;
        }

        public Criteria andAddressIsNull() {
            addCriterion("address is null");
            return (Criteria) this;
        }

        public Criteria andAddressIsNotNull() {
            addCriterion("address is not null");
            return (Criteria) this;
        }

        public Criteria andAddressEqualTo(String value) {
            addCriterion("address =", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotEqualTo(String value) {
            addCriterion("address <>", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressGreaterThan(String value) {
            addCriterion("address >", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressGreaterThanOrEqualTo(String value) {
            addCriterion("address >=", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLessThan(String value) {
            addCriterion("address <", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLessThanOrEqualTo(String value) {
            addCriterion("address <=", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLike(String value) {
            addCriterion("address like", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotLike(String value) {
            addCriterion("address not like", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressIn(List<String> values) {
            addCriterion("address in", values, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotIn(List<String> values) {
            addCriterion("address not in", values, "address");
            return (Criteria) this;
        }

        public Criteria andAddressBetween(String value1, String value2) {
            addCriterion("address between", value1, value2, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotBetween(String value1, String value2) {
            addCriterion("address not between", value1, value2, "address");
            return (Criteria) this;
        }

        public Criteria andSecondCategoryIsNull() {
            addCriterion("second_category is null");
            return (Criteria) this;
        }

        public Criteria andSecondCategoryIsNotNull() {
            addCriterion("second_category is not null");
            return (Criteria) this;
        }

        public Criteria andSecondCategoryEqualTo(Integer value) {
            addCriterion("second_category =", value, "secondCategory");
            return (Criteria) this;
        }

        public Criteria andSecondCategoryNotEqualTo(Integer value) {
            addCriterion("second_category <>", value, "secondCategory");
            return (Criteria) this;
        }

        public Criteria andSecondCategoryGreaterThan(Integer value) {
            addCriterion("second_category >", value, "secondCategory");
            return (Criteria) this;
        }

        public Criteria andSecondCategoryGreaterThanOrEqualTo(Integer value) {
            addCriterion("second_category >=", value, "secondCategory");
            return (Criteria) this;
        }

        public Criteria andSecondCategoryLessThan(Integer value) {
            addCriterion("second_category <", value, "secondCategory");
            return (Criteria) this;
        }

        public Criteria andSecondCategoryLessThanOrEqualTo(Integer value) {
            addCriterion("second_category <=", value, "secondCategory");
            return (Criteria) this;
        }

        public Criteria andSecondCategoryIn(List<Integer> values) {
            addCriterion("second_category in", values, "secondCategory");
            return (Criteria) this;
        }

        public Criteria andSecondCategoryNotIn(List<Integer> values) {
            addCriterion("second_category not in", values, "secondCategory");
            return (Criteria) this;
        }

        public Criteria andSecondCategoryBetween(Integer value1, Integer value2) {
            addCriterion("second_category between", value1, value2, "secondCategory");
            return (Criteria) this;
        }

        public Criteria andSecondCategoryNotBetween(Integer value1, Integer value2) {
            addCriterion("second_category not between", value1, value2, "secondCategory");
            return (Criteria) this;
        }

        public Criteria andMainCategoryIsNull() {
            addCriterion("main_category is null");
            return (Criteria) this;
        }

        public Criteria andMainCategoryIsNotNull() {
            addCriterion("main_category is not null");
            return (Criteria) this;
        }

        public Criteria andMainCategoryEqualTo(Integer value) {
            addCriterion("main_category =", value, "mainCategory");
            return (Criteria) this;
        }

        public Criteria andMainCategoryNotEqualTo(Integer value) {
            addCriterion("main_category <>", value, "mainCategory");
            return (Criteria) this;
        }

        public Criteria andMainCategoryGreaterThan(Integer value) {
            addCriterion("main_category >", value, "mainCategory");
            return (Criteria) this;
        }

        public Criteria andMainCategoryGreaterThanOrEqualTo(Integer value) {
            addCriterion("main_category >=", value, "mainCategory");
            return (Criteria) this;
        }

        public Criteria andMainCategoryLessThan(Integer value) {
            addCriterion("main_category <", value, "mainCategory");
            return (Criteria) this;
        }

        public Criteria andMainCategoryLessThanOrEqualTo(Integer value) {
            addCriterion("main_category <=", value, "mainCategory");
            return (Criteria) this;
        }

        public Criteria andMainCategoryIn(List<Integer> values) {
            addCriterion("main_category in", values, "mainCategory");
            return (Criteria) this;
        }

        public Criteria andMainCategoryNotIn(List<Integer> values) {
            addCriterion("main_category not in", values, "mainCategory");
            return (Criteria) this;
        }

        public Criteria andMainCategoryBetween(Integer value1, Integer value2) {
            addCriterion("main_category between", value1, value2, "mainCategory");
            return (Criteria) this;
        }

        public Criteria andMainCategoryNotBetween(Integer value1, Integer value2) {
            addCriterion("main_category not between", value1, value2, "mainCategory");
            return (Criteria) this;
        }

        public Criteria andWalletIsNull() {
            addCriterion("wallet is null");
            return (Criteria) this;
        }

        public Criteria andWalletIsNotNull() {
            addCriterion("wallet is not null");
            return (Criteria) this;
        }

        public Criteria andWalletEqualTo(Double value) {
            addCriterion("wallet =", value, "wallet");
            return (Criteria) this;
        }

        public Criteria andWalletNotEqualTo(Double value) {
            addCriterion("wallet <>", value, "wallet");
            return (Criteria) this;
        }

        public Criteria andWalletGreaterThan(Double value) {
            addCriterion("wallet >", value, "wallet");
            return (Criteria) this;
        }

        public Criteria andWalletGreaterThanOrEqualTo(Double value) {
            addCriterion("wallet >=", value, "wallet");
            return (Criteria) this;
        }

        public Criteria andWalletLessThan(Double value) {
            addCriterion("wallet <", value, "wallet");
            return (Criteria) this;
        }

        public Criteria andWalletLessThanOrEqualTo(Double value) {
            addCriterion("wallet <=", value, "wallet");
            return (Criteria) this;
        }

        public Criteria andWalletIn(List<Double> values) {
            addCriterion("wallet in", values, "wallet");
            return (Criteria) this;
        }

        public Criteria andWalletNotIn(List<Double> values) {
            addCriterion("wallet not in", values, "wallet");
            return (Criteria) this;
        }

        public Criteria andWalletBetween(Double value1, Double value2) {
            addCriterion("wallet between", value1, value2, "wallet");
            return (Criteria) this;
        }

        public Criteria andWalletNotBetween(Double value1, Double value2) {
            addCriterion("wallet not between", value1, value2, "wallet");
            return (Criteria) this;
        }

        public Criteria andHoldNoIsNull() {
            addCriterion("hold_no is null");
            return (Criteria) this;
        }

        public Criteria andHoldNoIsNotNull() {
            addCriterion("hold_no is not null");
            return (Criteria) this;
        }

        public Criteria andHoldNoEqualTo(Integer value) {
            addCriterion("hold_no =", value, "holdNo");
            return (Criteria) this;
        }

        public Criteria andHoldNoNotEqualTo(Integer value) {
            addCriterion("hold_no <>", value, "holdNo");
            return (Criteria) this;
        }

        public Criteria andHoldNoGreaterThan(Integer value) {
            addCriterion("hold_no >", value, "holdNo");
            return (Criteria) this;
        }

        public Criteria andHoldNoGreaterThanOrEqualTo(Integer value) {
            addCriterion("hold_no >=", value, "holdNo");
            return (Criteria) this;
        }

        public Criteria andHoldNoLessThan(Integer value) {
            addCriterion("hold_no <", value, "holdNo");
            return (Criteria) this;
        }

        public Criteria andHoldNoLessThanOrEqualTo(Integer value) {
            addCriterion("hold_no <=", value, "holdNo");
            return (Criteria) this;
        }

        public Criteria andHoldNoIn(List<Integer> values) {
            addCriterion("hold_no in", values, "holdNo");
            return (Criteria) this;
        }

        public Criteria andHoldNoNotIn(List<Integer> values) {
            addCriterion("hold_no not in", values, "holdNo");
            return (Criteria) this;
        }

        public Criteria andHoldNoBetween(Integer value1, Integer value2) {
            addCriterion("hold_no between", value1, value2, "holdNo");
            return (Criteria) this;
        }

        public Criteria andHoldNoNotBetween(Integer value1, Integer value2) {
            addCriterion("hold_no not between", value1, value2, "holdNo");
            return (Criteria) this;
        }

        public Criteria andShopQrCodeIsNull() {
            addCriterion("shop_qr_code is null");
            return (Criteria) this;
        }

        public Criteria andShopQrCodeIsNotNull() {
            addCriterion("shop_qr_code is not null");
            return (Criteria) this;
        }

        public Criteria andShopQrCodeEqualTo(String value) {
            addCriterion("shop_qr_code =", value, "shopQrCode");
            return (Criteria) this;
        }

        public Criteria andShopQrCodeNotEqualTo(String value) {
            addCriterion("shop_qr_code <>", value, "shopQrCode");
            return (Criteria) this;
        }

        public Criteria andShopQrCodeGreaterThan(String value) {
            addCriterion("shop_qr_code >", value, "shopQrCode");
            return (Criteria) this;
        }

        public Criteria andShopQrCodeGreaterThanOrEqualTo(String value) {
            addCriterion("shop_qr_code >=", value, "shopQrCode");
            return (Criteria) this;
        }

        public Criteria andShopQrCodeLessThan(String value) {
            addCriterion("shop_qr_code <", value, "shopQrCode");
            return (Criteria) this;
        }

        public Criteria andShopQrCodeLessThanOrEqualTo(String value) {
            addCriterion("shop_qr_code <=", value, "shopQrCode");
            return (Criteria) this;
        }

        public Criteria andShopQrCodeLike(String value) {
            addCriterion("shop_qr_code like", value, "shopQrCode");
            return (Criteria) this;
        }

        public Criteria andShopQrCodeNotLike(String value) {
            addCriterion("shop_qr_code not like", value, "shopQrCode");
            return (Criteria) this;
        }

        public Criteria andShopQrCodeIn(List<String> values) {
            addCriterion("shop_qr_code in", values, "shopQrCode");
            return (Criteria) this;
        }

        public Criteria andShopQrCodeNotIn(List<String> values) {
            addCriterion("shop_qr_code not in", values, "shopQrCode");
            return (Criteria) this;
        }

        public Criteria andShopQrCodeBetween(String value1, String value2) {
            addCriterion("shop_qr_code between", value1, value2, "shopQrCode");
            return (Criteria) this;
        }

        public Criteria andShopQrCodeNotBetween(String value1, String value2) {
            addCriterion("shop_qr_code not between", value1, value2, "shopQrCode");
            return (Criteria) this;
        }

        public Criteria andBusinessHouroneIsNull() {
            addCriterion("business_hourone is null");
            return (Criteria) this;
        }

        public Criteria andBusinessHouroneIsNotNull() {
            addCriterion("business_hourone is not null");
            return (Criteria) this;
        }

        public Criteria andBusinessHouroneEqualTo(String value) {
            addCriterion("business_hourone =", value, "businessHourone");
            return (Criteria) this;
        }

        public Criteria andBusinessHouroneNotEqualTo(String value) {
            addCriterion("business_hourone <>", value, "businessHourone");
            return (Criteria) this;
        }

        public Criteria andBusinessHouroneGreaterThan(String value) {
            addCriterion("business_hourone >", value, "businessHourone");
            return (Criteria) this;
        }

        public Criteria andBusinessHouroneGreaterThanOrEqualTo(String value) {
            addCriterion("business_hourone >=", value, "businessHourone");
            return (Criteria) this;
        }

        public Criteria andBusinessHouroneLessThan(String value) {
            addCriterion("business_hourone <", value, "businessHourone");
            return (Criteria) this;
        }

        public Criteria andBusinessHouroneLessThanOrEqualTo(String value) {
            addCriterion("business_hourone <=", value, "businessHourone");
            return (Criteria) this;
        }

        public Criteria andBusinessHouroneLike(String value) {
            addCriterion("business_hourone like", value, "businessHourone");
            return (Criteria) this;
        }

        public Criteria andBusinessHouroneNotLike(String value) {
            addCriterion("business_hourone not like", value, "businessHourone");
            return (Criteria) this;
        }

        public Criteria andBusinessHouroneIn(List<String> values) {
            addCriterion("business_hourone in", values, "businessHourone");
            return (Criteria) this;
        }

        public Criteria andBusinessHouroneNotIn(List<String> values) {
            addCriterion("business_hourone not in", values, "businessHourone");
            return (Criteria) this;
        }

        public Criteria andBusinessHouroneBetween(String value1, String value2) {
            addCriterion("business_hourone between", value1, value2, "businessHourone");
            return (Criteria) this;
        }

        public Criteria andBusinessHouroneNotBetween(String value1, String value2) {
            addCriterion("business_hourone not between", value1, value2, "businessHourone");
            return (Criteria) this;
        }

        public Criteria andBusinessHourtwoIsNull() {
            addCriterion("business_hourtwo is null");
            return (Criteria) this;
        }

        public Criteria andBusinessHourtwoIsNotNull() {
            addCriterion("business_hourtwo is not null");
            return (Criteria) this;
        }

        public Criteria andBusinessHourtwoEqualTo(String value) {
            addCriterion("business_hourtwo =", value, "businessHourtwo");
            return (Criteria) this;
        }

        public Criteria andBusinessHourtwoNotEqualTo(String value) {
            addCriterion("business_hourtwo <>", value, "businessHourtwo");
            return (Criteria) this;
        }

        public Criteria andBusinessHourtwoGreaterThan(String value) {
            addCriterion("business_hourtwo >", value, "businessHourtwo");
            return (Criteria) this;
        }

        public Criteria andBusinessHourtwoGreaterThanOrEqualTo(String value) {
            addCriterion("business_hourtwo >=", value, "businessHourtwo");
            return (Criteria) this;
        }

        public Criteria andBusinessHourtwoLessThan(String value) {
            addCriterion("business_hourtwo <", value, "businessHourtwo");
            return (Criteria) this;
        }

        public Criteria andBusinessHourtwoLessThanOrEqualTo(String value) {
            addCriterion("business_hourtwo <=", value, "businessHourtwo");
            return (Criteria) this;
        }

        public Criteria andBusinessHourtwoLike(String value) {
            addCriterion("business_hourtwo like", value, "businessHourtwo");
            return (Criteria) this;
        }

        public Criteria andBusinessHourtwoNotLike(String value) {
            addCriterion("business_hourtwo not like", value, "businessHourtwo");
            return (Criteria) this;
        }

        public Criteria andBusinessHourtwoIn(List<String> values) {
            addCriterion("business_hourtwo in", values, "businessHourtwo");
            return (Criteria) this;
        }

        public Criteria andBusinessHourtwoNotIn(List<String> values) {
            addCriterion("business_hourtwo not in", values, "businessHourtwo");
            return (Criteria) this;
        }

        public Criteria andBusinessHourtwoBetween(String value1, String value2) {
            addCriterion("business_hourtwo between", value1, value2, "businessHourtwo");
            return (Criteria) this;
        }

        public Criteria andBusinessHourtwoNotBetween(String value1, String value2) {
            addCriterion("business_hourtwo not between", value1, value2, "businessHourtwo");
            return (Criteria) this;
        }

        public Criteria andBusinessHourthreeIsNull() {
            addCriterion("business_hourthree is null");
            return (Criteria) this;
        }

        public Criteria andBusinessHourthreeIsNotNull() {
            addCriterion("business_hourthree is not null");
            return (Criteria) this;
        }

        public Criteria andBusinessHourthreeEqualTo(String value) {
            addCriterion("business_hourthree =", value, "businessHourthree");
            return (Criteria) this;
        }

        public Criteria andBusinessHourthreeNotEqualTo(String value) {
            addCriterion("business_hourthree <>", value, "businessHourthree");
            return (Criteria) this;
        }

        public Criteria andBusinessHourthreeGreaterThan(String value) {
            addCriterion("business_hourthree >", value, "businessHourthree");
            return (Criteria) this;
        }

        public Criteria andBusinessHourthreeGreaterThanOrEqualTo(String value) {
            addCriterion("business_hourthree >=", value, "businessHourthree");
            return (Criteria) this;
        }

        public Criteria andBusinessHourthreeLessThan(String value) {
            addCriterion("business_hourthree <", value, "businessHourthree");
            return (Criteria) this;
        }

        public Criteria andBusinessHourthreeLessThanOrEqualTo(String value) {
            addCriterion("business_hourthree <=", value, "businessHourthree");
            return (Criteria) this;
        }

        public Criteria andBusinessHourthreeLike(String value) {
            addCriterion("business_hourthree like", value, "businessHourthree");
            return (Criteria) this;
        }

        public Criteria andBusinessHourthreeNotLike(String value) {
            addCriterion("business_hourthree not like", value, "businessHourthree");
            return (Criteria) this;
        }

        public Criteria andBusinessHourthreeIn(List<String> values) {
            addCriterion("business_hourthree in", values, "businessHourthree");
            return (Criteria) this;
        }

        public Criteria andBusinessHourthreeNotIn(List<String> values) {
            addCriterion("business_hourthree not in", values, "businessHourthree");
            return (Criteria) this;
        }

        public Criteria andBusinessHourthreeBetween(String value1, String value2) {
            addCriterion("business_hourthree between", value1, value2, "businessHourthree");
            return (Criteria) this;
        }

        public Criteria andBusinessHourthreeNotBetween(String value1, String value2) {
            addCriterion("business_hourthree not between", value1, value2, "businessHourthree");
            return (Criteria) this;
        }

        public Criteria andAnnouncementIsNull() {
            addCriterion("announcement is null");
            return (Criteria) this;
        }

        public Criteria andAnnouncementIsNotNull() {
            addCriterion("announcement is not null");
            return (Criteria) this;
        }

        public Criteria andAnnouncementEqualTo(String value) {
            addCriterion("announcement =", value, "announcement");
            return (Criteria) this;
        }

        public Criteria andAnnouncementNotEqualTo(String value) {
            addCriterion("announcement <>", value, "announcement");
            return (Criteria) this;
        }

        public Criteria andAnnouncementGreaterThan(String value) {
            addCriterion("announcement >", value, "announcement");
            return (Criteria) this;
        }

        public Criteria andAnnouncementGreaterThanOrEqualTo(String value) {
            addCriterion("announcement >=", value, "announcement");
            return (Criteria) this;
        }

        public Criteria andAnnouncementLessThan(String value) {
            addCriterion("announcement <", value, "announcement");
            return (Criteria) this;
        }

        public Criteria andAnnouncementLessThanOrEqualTo(String value) {
            addCriterion("announcement <=", value, "announcement");
            return (Criteria) this;
        }

        public Criteria andAnnouncementLike(String value) {
            addCriterion("announcement like", value, "announcement");
            return (Criteria) this;
        }

        public Criteria andAnnouncementNotLike(String value) {
            addCriterion("announcement not like", value, "announcement");
            return (Criteria) this;
        }

        public Criteria andAnnouncementIn(List<String> values) {
            addCriterion("announcement in", values, "announcement");
            return (Criteria) this;
        }

        public Criteria andAnnouncementNotIn(List<String> values) {
            addCriterion("announcement not in", values, "announcement");
            return (Criteria) this;
        }

        public Criteria andAnnouncementBetween(String value1, String value2) {
            addCriterion("announcement between", value1, value2, "announcement");
            return (Criteria) this;
        }

        public Criteria andAnnouncementNotBetween(String value1, String value2) {
            addCriterion("announcement not between", value1, value2, "announcement");
            return (Criteria) this;
        }

        public Criteria andShopIntroductionIsNull() {
            addCriterion("shop_Introduction is null");
            return (Criteria) this;
        }

        public Criteria andShopIntroductionIsNotNull() {
            addCriterion("shop_Introduction is not null");
            return (Criteria) this;
        }

        public Criteria andShopIntroductionEqualTo(String value) {
            addCriterion("shop_Introduction =", value, "shopIntroduction");
            return (Criteria) this;
        }

        public Criteria andShopIntroductionNotEqualTo(String value) {
            addCriterion("shop_Introduction <>", value, "shopIntroduction");
            return (Criteria) this;
        }

        public Criteria andShopIntroductionGreaterThan(String value) {
            addCriterion("shop_Introduction >", value, "shopIntroduction");
            return (Criteria) this;
        }

        public Criteria andShopIntroductionGreaterThanOrEqualTo(String value) {
            addCriterion("shop_Introduction >=", value, "shopIntroduction");
            return (Criteria) this;
        }

        public Criteria andShopIntroductionLessThan(String value) {
            addCriterion("shop_Introduction <", value, "shopIntroduction");
            return (Criteria) this;
        }

        public Criteria andShopIntroductionLessThanOrEqualTo(String value) {
            addCriterion("shop_Introduction <=", value, "shopIntroduction");
            return (Criteria) this;
        }

        public Criteria andShopIntroductionLike(String value) {
            addCriterion("shop_Introduction like", value, "shopIntroduction");
            return (Criteria) this;
        }

        public Criteria andShopIntroductionNotLike(String value) {
            addCriterion("shop_Introduction not like", value, "shopIntroduction");
            return (Criteria) this;
        }

        public Criteria andShopIntroductionIn(List<String> values) {
            addCriterion("shop_Introduction in", values, "shopIntroduction");
            return (Criteria) this;
        }

        public Criteria andShopIntroductionNotIn(List<String> values) {
            addCriterion("shop_Introduction not in", values, "shopIntroduction");
            return (Criteria) this;
        }

        public Criteria andShopIntroductionBetween(String value1, String value2) {
            addCriterion("shop_Introduction between", value1, value2, "shopIntroduction");
            return (Criteria) this;
        }

        public Criteria andShopIntroductionNotBetween(String value1, String value2) {
            addCriterion("shop_Introduction not between", value1, value2, "shopIntroduction");
            return (Criteria) this;
        }

        public Criteria andBillIsNull() {
            addCriterion("bill is null");
            return (Criteria) this;
        }

        public Criteria andBillIsNotNull() {
            addCriterion("bill is not null");
            return (Criteria) this;
        }

        public Criteria andBillEqualTo(String value) {
            addCriterion("bill =", value, "bill");
            return (Criteria) this;
        }

        public Criteria andBillNotEqualTo(String value) {
            addCriterion("bill <>", value, "bill");
            return (Criteria) this;
        }

        public Criteria andBillGreaterThan(String value) {
            addCriterion("bill >", value, "bill");
            return (Criteria) this;
        }

        public Criteria andBillGreaterThanOrEqualTo(String value) {
            addCriterion("bill >=", value, "bill");
            return (Criteria) this;
        }

        public Criteria andBillLessThan(String value) {
            addCriterion("bill <", value, "bill");
            return (Criteria) this;
        }

        public Criteria andBillLessThanOrEqualTo(String value) {
            addCriterion("bill <=", value, "bill");
            return (Criteria) this;
        }

        public Criteria andBillLike(String value) {
            addCriterion("bill like", value, "bill");
            return (Criteria) this;
        }

        public Criteria andBillNotLike(String value) {
            addCriterion("bill not like", value, "bill");
            return (Criteria) this;
        }

        public Criteria andBillIn(List<String> values) {
            addCriterion("bill in", values, "bill");
            return (Criteria) this;
        }

        public Criteria andBillNotIn(List<String> values) {
            addCriterion("bill not in", values, "bill");
            return (Criteria) this;
        }

        public Criteria andBillBetween(String value1, String value2) {
            addCriterion("bill between", value1, value2, "bill");
            return (Criteria) this;
        }

        public Criteria andBillNotBetween(String value1, String value2) {
            addCriterion("bill not between", value1, value2, "bill");
            return (Criteria) this;
        }

        public Criteria andBusinessStatusIsNull() {
            addCriterion("business_status is null");
            return (Criteria) this;
        }

        public Criteria andBusinessStatusIsNotNull() {
            addCriterion("business_status is not null");
            return (Criteria) this;
        }

        public Criteria andBusinessStatusEqualTo(String value) {
            addCriterion("business_status =", value, "businessStatus");
            return (Criteria) this;
        }

        public Criteria andBusinessStatusNotEqualTo(String value) {
            addCriterion("business_status <>", value, "businessStatus");
            return (Criteria) this;
        }

        public Criteria andBusinessStatusGreaterThan(String value) {
            addCriterion("business_status >", value, "businessStatus");
            return (Criteria) this;
        }

        public Criteria andBusinessStatusGreaterThanOrEqualTo(String value) {
            addCriterion("business_status >=", value, "businessStatus");
            return (Criteria) this;
        }

        public Criteria andBusinessStatusLessThan(String value) {
            addCriterion("business_status <", value, "businessStatus");
            return (Criteria) this;
        }

        public Criteria andBusinessStatusLessThanOrEqualTo(String value) {
            addCriterion("business_status <=", value, "businessStatus");
            return (Criteria) this;
        }

        public Criteria andBusinessStatusLike(String value) {
            addCriterion("business_status like", value, "businessStatus");
            return (Criteria) this;
        }

        public Criteria andBusinessStatusNotLike(String value) {
            addCriterion("business_status not like", value, "businessStatus");
            return (Criteria) this;
        }

        public Criteria andBusinessStatusIn(List<String> values) {
            addCriterion("business_status in", values, "businessStatus");
            return (Criteria) this;
        }

        public Criteria andBusinessStatusNotIn(List<String> values) {
            addCriterion("business_status not in", values, "businessStatus");
            return (Criteria) this;
        }

        public Criteria andBusinessStatusBetween(String value1, String value2) {
            addCriterion("business_status between", value1, value2, "businessStatus");
            return (Criteria) this;
        }

        public Criteria andBusinessStatusNotBetween(String value1, String value2) {
            addCriterion("business_status not between", value1, value2, "businessStatus");
            return (Criteria) this;
        }

        public Criteria andPictureIsNull() {
            addCriterion("picture is null");
            return (Criteria) this;
        }

        public Criteria andPictureIsNotNull() {
            addCriterion("picture is not null");
            return (Criteria) this;
        }

        public Criteria andPictureEqualTo(String value) {
            addCriterion("picture =", value, "picture");
            return (Criteria) this;
        }

        public Criteria andPictureNotEqualTo(String value) {
            addCriterion("picture <>", value, "picture");
            return (Criteria) this;
        }

        public Criteria andPictureGreaterThan(String value) {
            addCriterion("picture >", value, "picture");
            return (Criteria) this;
        }

        public Criteria andPictureGreaterThanOrEqualTo(String value) {
            addCriterion("picture >=", value, "picture");
            return (Criteria) this;
        }

        public Criteria andPictureLessThan(String value) {
            addCriterion("picture <", value, "picture");
            return (Criteria) this;
        }

        public Criteria andPictureLessThanOrEqualTo(String value) {
            addCriterion("picture <=", value, "picture");
            return (Criteria) this;
        }

        public Criteria andPictureLike(String value) {
            addCriterion("picture like", value, "picture");
            return (Criteria) this;
        }

        public Criteria andPictureNotLike(String value) {
            addCriterion("picture not like", value, "picture");
            return (Criteria) this;
        }

        public Criteria andPictureIn(List<String> values) {
            addCriterion("picture in", values, "picture");
            return (Criteria) this;
        }

        public Criteria andPictureNotIn(List<String> values) {
            addCriterion("picture not in", values, "picture");
            return (Criteria) this;
        }

        public Criteria andPictureBetween(String value1, String value2) {
            addCriterion("picture between", value1, value2, "picture");
            return (Criteria) this;
        }

        public Criteria andPictureNotBetween(String value1, String value2) {
            addCriterion("picture not between", value1, value2, "picture");
            return (Criteria) this;
        }

        public Criteria andPriorityIsNull() {
            addCriterion("priority is null");
            return (Criteria) this;
        }

        public Criteria andPriorityIsNotNull() {
            addCriterion("priority is not null");
            return (Criteria) this;
        }

        public Criteria andPriorityEqualTo(Integer value) {
            addCriterion("priority =", value, "priority");
            return (Criteria) this;
        }

        public Criteria andPriorityNotEqualTo(Integer value) {
            addCriterion("priority <>", value, "priority");
            return (Criteria) this;
        }

        public Criteria andPriorityGreaterThan(Integer value) {
            addCriterion("priority >", value, "priority");
            return (Criteria) this;
        }

        public Criteria andPriorityGreaterThanOrEqualTo(Integer value) {
            addCriterion("priority >=", value, "priority");
            return (Criteria) this;
        }

        public Criteria andPriorityLessThan(Integer value) {
            addCriterion("priority <", value, "priority");
            return (Criteria) this;
        }

        public Criteria andPriorityLessThanOrEqualTo(Integer value) {
            addCriterion("priority <=", value, "priority");
            return (Criteria) this;
        }

        public Criteria andPriorityIn(List<Integer> values) {
            addCriterion("priority in", values, "priority");
            return (Criteria) this;
        }

        public Criteria andPriorityNotIn(List<Integer> values) {
            addCriterion("priority not in", values, "priority");
            return (Criteria) this;
        }

        public Criteria andPriorityBetween(Integer value1, Integer value2) {
            addCriterion("priority between", value1, value2, "priority");
            return (Criteria) this;
        }

        public Criteria andPriorityNotBetween(Integer value1, Integer value2) {
            addCriterion("priority not between", value1, value2, "priority");
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