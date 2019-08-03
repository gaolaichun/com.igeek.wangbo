package com.sm.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PackageExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PackageExample() {
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

        public Criteria andPackageNameIsNull() {
            addCriterion("package_name is null");
            return (Criteria) this;
        }

        public Criteria andPackageNameIsNotNull() {
            addCriterion("package_name is not null");
            return (Criteria) this;
        }

        public Criteria andPackageNameEqualTo(String value) {
            addCriterion("package_name =", value, "packageName");
            return (Criteria) this;
        }

        public Criteria andPackageNameNotEqualTo(String value) {
            addCriterion("package_name <>", value, "packageName");
            return (Criteria) this;
        }

        public Criteria andPackageNameGreaterThan(String value) {
            addCriterion("package_name >", value, "packageName");
            return (Criteria) this;
        }

        public Criteria andPackageNameGreaterThanOrEqualTo(String value) {
            addCriterion("package_name >=", value, "packageName");
            return (Criteria) this;
        }

        public Criteria andPackageNameLessThan(String value) {
            addCriterion("package_name <", value, "packageName");
            return (Criteria) this;
        }

        public Criteria andPackageNameLessThanOrEqualTo(String value) {
            addCriterion("package_name <=", value, "packageName");
            return (Criteria) this;
        }

        public Criteria andPackageNameLike(String value) {
            addCriterion("package_name like", value, "packageName");
            return (Criteria) this;
        }

        public Criteria andPackageNameNotLike(String value) {
            addCriterion("package_name not like", value, "packageName");
            return (Criteria) this;
        }

        public Criteria andPackageNameIn(List<String> values) {
            addCriterion("package_name in", values, "packageName");
            return (Criteria) this;
        }

        public Criteria andPackageNameNotIn(List<String> values) {
            addCriterion("package_name not in", values, "packageName");
            return (Criteria) this;
        }

        public Criteria andPackageNameBetween(String value1, String value2) {
            addCriterion("package_name between", value1, value2, "packageName");
            return (Criteria) this;
        }

        public Criteria andPackageNameNotBetween(String value1, String value2) {
            addCriterion("package_name not between", value1, value2, "packageName");
            return (Criteria) this;
        }

        public Criteria andPackageStatusIsNull() {
            addCriterion("package_status is null");
            return (Criteria) this;
        }

        public Criteria andPackageStatusIsNotNull() {
            addCriterion("package_status is not null");
            return (Criteria) this;
        }

        public Criteria andPackageStatusEqualTo(Integer value) {
            addCriterion("package_status =", value, "packageStatus");
            return (Criteria) this;
        }

        public Criteria andPackageStatusNotEqualTo(Integer value) {
            addCriterion("package_status <>", value, "packageStatus");
            return (Criteria) this;
        }

        public Criteria andPackageStatusGreaterThan(Integer value) {
            addCriterion("package_status >", value, "packageStatus");
            return (Criteria) this;
        }

        public Criteria andPackageStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("package_status >=", value, "packageStatus");
            return (Criteria) this;
        }

        public Criteria andPackageStatusLessThan(Integer value) {
            addCriterion("package_status <", value, "packageStatus");
            return (Criteria) this;
        }

        public Criteria andPackageStatusLessThanOrEqualTo(Integer value) {
            addCriterion("package_status <=", value, "packageStatus");
            return (Criteria) this;
        }

        public Criteria andPackageStatusIn(List<Integer> values) {
            addCriterion("package_status in", values, "packageStatus");
            return (Criteria) this;
        }

        public Criteria andPackageStatusNotIn(List<Integer> values) {
            addCriterion("package_status not in", values, "packageStatus");
            return (Criteria) this;
        }

        public Criteria andPackageStatusBetween(Integer value1, Integer value2) {
            addCriterion("package_status between", value1, value2, "packageStatus");
            return (Criteria) this;
        }

        public Criteria andPackageStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("package_status not between", value1, value2, "packageStatus");
            return (Criteria) this;
        }

        public Criteria andStartTimeIsNull() {
            addCriterion("start_time is null");
            return (Criteria) this;
        }

        public Criteria andStartTimeIsNotNull() {
            addCriterion("start_time is not null");
            return (Criteria) this;
        }

        public Criteria andStartTimeEqualTo(Date value) {
            addCriterion("start_time =", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeNotEqualTo(Date value) {
            addCriterion("start_time <>", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeGreaterThan(Date value) {
            addCriterion("start_time >", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("start_time >=", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeLessThan(Date value) {
            addCriterion("start_time <", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeLessThanOrEqualTo(Date value) {
            addCriterion("start_time <=", value, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeIn(List<Date> values) {
            addCriterion("start_time in", values, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeNotIn(List<Date> values) {
            addCriterion("start_time not in", values, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeBetween(Date value1, Date value2) {
            addCriterion("start_time between", value1, value2, "startTime");
            return (Criteria) this;
        }

        public Criteria andStartTimeNotBetween(Date value1, Date value2) {
            addCriterion("start_time not between", value1, value2, "startTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeIsNull() {
            addCriterion("end_time is null");
            return (Criteria) this;
        }

        public Criteria andEndTimeIsNotNull() {
            addCriterion("end_time is not null");
            return (Criteria) this;
        }

        public Criteria andEndTimeEqualTo(Date value) {
            addCriterion("end_time =", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeNotEqualTo(Date value) {
            addCriterion("end_time <>", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeGreaterThan(Date value) {
            addCriterion("end_time >", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("end_time >=", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeLessThan(Date value) {
            addCriterion("end_time <", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeLessThanOrEqualTo(Date value) {
            addCriterion("end_time <=", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeIn(List<Date> values) {
            addCriterion("end_time in", values, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeNotIn(List<Date> values) {
            addCriterion("end_time not in", values, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeBetween(Date value1, Date value2) {
            addCriterion("end_time between", value1, value2, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeNotBetween(Date value1, Date value2) {
            addCriterion("end_time not between", value1, value2, "endTime");
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

        public Criteria andPriorityEqualTo(String value) {
            addCriterion("priority =", value, "priority");
            return (Criteria) this;
        }

        public Criteria andPriorityNotEqualTo(String value) {
            addCriterion("priority <>", value, "priority");
            return (Criteria) this;
        }

        public Criteria andPriorityGreaterThan(String value) {
            addCriterion("priority >", value, "priority");
            return (Criteria) this;
        }

        public Criteria andPriorityGreaterThanOrEqualTo(String value) {
            addCriterion("priority >=", value, "priority");
            return (Criteria) this;
        }

        public Criteria andPriorityLessThan(String value) {
            addCriterion("priority <", value, "priority");
            return (Criteria) this;
        }

        public Criteria andPriorityLessThanOrEqualTo(String value) {
            addCriterion("priority <=", value, "priority");
            return (Criteria) this;
        }

        public Criteria andPriorityLike(String value) {
            addCriterion("priority like", value, "priority");
            return (Criteria) this;
        }

        public Criteria andPriorityNotLike(String value) {
            addCriterion("priority not like", value, "priority");
            return (Criteria) this;
        }

        public Criteria andPriorityIn(List<String> values) {
            addCriterion("priority in", values, "priority");
            return (Criteria) this;
        }

        public Criteria andPriorityNotIn(List<String> values) {
            addCriterion("priority not in", values, "priority");
            return (Criteria) this;
        }

        public Criteria andPriorityBetween(String value1, String value2) {
            addCriterion("priority between", value1, value2, "priority");
            return (Criteria) this;
        }

        public Criteria andPriorityNotBetween(String value1, String value2) {
            addCriterion("priority not between", value1, value2, "priority");
            return (Criteria) this;
        }

        public Criteria andSaleIsNull() {
            addCriterion("sale is null");
            return (Criteria) this;
        }

        public Criteria andSaleIsNotNull() {
            addCriterion("sale is not null");
            return (Criteria) this;
        }

        public Criteria andSaleEqualTo(Integer value) {
            addCriterion("sale =", value, "sale");
            return (Criteria) this;
        }

        public Criteria andSaleNotEqualTo(Integer value) {
            addCriterion("sale <>", value, "sale");
            return (Criteria) this;
        }

        public Criteria andSaleGreaterThan(Integer value) {
            addCriterion("sale >", value, "sale");
            return (Criteria) this;
        }

        public Criteria andSaleGreaterThanOrEqualTo(Integer value) {
            addCriterion("sale >=", value, "sale");
            return (Criteria) this;
        }

        public Criteria andSaleLessThan(Integer value) {
            addCriterion("sale <", value, "sale");
            return (Criteria) this;
        }

        public Criteria andSaleLessThanOrEqualTo(Integer value) {
            addCriterion("sale <=", value, "sale");
            return (Criteria) this;
        }

        public Criteria andSaleIn(List<Integer> values) {
            addCriterion("sale in", values, "sale");
            return (Criteria) this;
        }

        public Criteria andSaleNotIn(List<Integer> values) {
            addCriterion("sale not in", values, "sale");
            return (Criteria) this;
        }

        public Criteria andSaleBetween(Integer value1, Integer value2) {
            addCriterion("sale between", value1, value2, "sale");
            return (Criteria) this;
        }

        public Criteria andSaleNotBetween(Integer value1, Integer value2) {
            addCriterion("sale not between", value1, value2, "sale");
            return (Criteria) this;
        }

        public Criteria andPeopleNumberIsNull() {
            addCriterion("people_number is null");
            return (Criteria) this;
        }

        public Criteria andPeopleNumberIsNotNull() {
            addCriterion("people_number is not null");
            return (Criteria) this;
        }

        public Criteria andPeopleNumberEqualTo(Integer value) {
            addCriterion("people_number =", value, "peopleNumber");
            return (Criteria) this;
        }

        public Criteria andPeopleNumberNotEqualTo(Integer value) {
            addCriterion("people_number <>", value, "peopleNumber");
            return (Criteria) this;
        }

        public Criteria andPeopleNumberGreaterThan(Integer value) {
            addCriterion("people_number >", value, "peopleNumber");
            return (Criteria) this;
        }

        public Criteria andPeopleNumberGreaterThanOrEqualTo(Integer value) {
            addCriterion("people_number >=", value, "peopleNumber");
            return (Criteria) this;
        }

        public Criteria andPeopleNumberLessThan(Integer value) {
            addCriterion("people_number <", value, "peopleNumber");
            return (Criteria) this;
        }

        public Criteria andPeopleNumberLessThanOrEqualTo(Integer value) {
            addCriterion("people_number <=", value, "peopleNumber");
            return (Criteria) this;
        }

        public Criteria andPeopleNumberIn(List<Integer> values) {
            addCriterion("people_number in", values, "peopleNumber");
            return (Criteria) this;
        }

        public Criteria andPeopleNumberNotIn(List<Integer> values) {
            addCriterion("people_number not in", values, "peopleNumber");
            return (Criteria) this;
        }

        public Criteria andPeopleNumberBetween(Integer value1, Integer value2) {
            addCriterion("people_number between", value1, value2, "peopleNumber");
            return (Criteria) this;
        }

        public Criteria andPeopleNumberNotBetween(Integer value1, Integer value2) {
            addCriterion("people_number not between", value1, value2, "peopleNumber");
            return (Criteria) this;
        }

        public Criteria andPackagePictureIsNull() {
            addCriterion("package_picture is null");
            return (Criteria) this;
        }

        public Criteria andPackagePictureIsNotNull() {
            addCriterion("package_picture is not null");
            return (Criteria) this;
        }

        public Criteria andPackagePictureEqualTo(String value) {
            addCriterion("package_picture =", value, "packagePicture");
            return (Criteria) this;
        }

        public Criteria andPackagePictureNotEqualTo(String value) {
            addCriterion("package_picture <>", value, "packagePicture");
            return (Criteria) this;
        }

        public Criteria andPackagePictureGreaterThan(String value) {
            addCriterion("package_picture >", value, "packagePicture");
            return (Criteria) this;
        }

        public Criteria andPackagePictureGreaterThanOrEqualTo(String value) {
            addCriterion("package_picture >=", value, "packagePicture");
            return (Criteria) this;
        }

        public Criteria andPackagePictureLessThan(String value) {
            addCriterion("package_picture <", value, "packagePicture");
            return (Criteria) this;
        }

        public Criteria andPackagePictureLessThanOrEqualTo(String value) {
            addCriterion("package_picture <=", value, "packagePicture");
            return (Criteria) this;
        }

        public Criteria andPackagePictureLike(String value) {
            addCriterion("package_picture like", value, "packagePicture");
            return (Criteria) this;
        }

        public Criteria andPackagePictureNotLike(String value) {
            addCriterion("package_picture not like", value, "packagePicture");
            return (Criteria) this;
        }

        public Criteria andPackagePictureIn(List<String> values) {
            addCriterion("package_picture in", values, "packagePicture");
            return (Criteria) this;
        }

        public Criteria andPackagePictureNotIn(List<String> values) {
            addCriterion("package_picture not in", values, "packagePicture");
            return (Criteria) this;
        }

        public Criteria andPackagePictureBetween(String value1, String value2) {
            addCriterion("package_picture between", value1, value2, "packagePicture");
            return (Criteria) this;
        }

        public Criteria andPackagePictureNotBetween(String value1, String value2) {
            addCriterion("package_picture not between", value1, value2, "packagePicture");
            return (Criteria) this;
        }

        public Criteria andCurrentStockIsNull() {
            addCriterion("current_stock is null");
            return (Criteria) this;
        }

        public Criteria andCurrentStockIsNotNull() {
            addCriterion("current_stock is not null");
            return (Criteria) this;
        }

        public Criteria andCurrentStockEqualTo(Integer value) {
            addCriterion("current_stock =", value, "currentStock");
            return (Criteria) this;
        }

        public Criteria andCurrentStockNotEqualTo(Integer value) {
            addCriterion("current_stock <>", value, "currentStock");
            return (Criteria) this;
        }

        public Criteria andCurrentStockGreaterThan(Integer value) {
            addCriterion("current_stock >", value, "currentStock");
            return (Criteria) this;
        }

        public Criteria andCurrentStockGreaterThanOrEqualTo(Integer value) {
            addCriterion("current_stock >=", value, "currentStock");
            return (Criteria) this;
        }

        public Criteria andCurrentStockLessThan(Integer value) {
            addCriterion("current_stock <", value, "currentStock");
            return (Criteria) this;
        }

        public Criteria andCurrentStockLessThanOrEqualTo(Integer value) {
            addCriterion("current_stock <=", value, "currentStock");
            return (Criteria) this;
        }

        public Criteria andCurrentStockIn(List<Integer> values) {
            addCriterion("current_stock in", values, "currentStock");
            return (Criteria) this;
        }

        public Criteria andCurrentStockNotIn(List<Integer> values) {
            addCriterion("current_stock not in", values, "currentStock");
            return (Criteria) this;
        }

        public Criteria andCurrentStockBetween(Integer value1, Integer value2) {
            addCriterion("current_stock between", value1, value2, "currentStock");
            return (Criteria) this;
        }

        public Criteria andCurrentStockNotBetween(Integer value1, Integer value2) {
            addCriterion("current_stock not between", value1, value2, "currentStock");
            return (Criteria) this;
        }

        public Criteria andMaxStockIsNull() {
            addCriterion("max_stock is null");
            return (Criteria) this;
        }

        public Criteria andMaxStockIsNotNull() {
            addCriterion("max_stock is not null");
            return (Criteria) this;
        }

        public Criteria andMaxStockEqualTo(Integer value) {
            addCriterion("max_stock =", value, "maxStock");
            return (Criteria) this;
        }

        public Criteria andMaxStockNotEqualTo(Integer value) {
            addCriterion("max_stock <>", value, "maxStock");
            return (Criteria) this;
        }

        public Criteria andMaxStockGreaterThan(Integer value) {
            addCriterion("max_stock >", value, "maxStock");
            return (Criteria) this;
        }

        public Criteria andMaxStockGreaterThanOrEqualTo(Integer value) {
            addCriterion("max_stock >=", value, "maxStock");
            return (Criteria) this;
        }

        public Criteria andMaxStockLessThan(Integer value) {
            addCriterion("max_stock <", value, "maxStock");
            return (Criteria) this;
        }

        public Criteria andMaxStockLessThanOrEqualTo(Integer value) {
            addCriterion("max_stock <=", value, "maxStock");
            return (Criteria) this;
        }

        public Criteria andMaxStockIn(List<Integer> values) {
            addCriterion("max_stock in", values, "maxStock");
            return (Criteria) this;
        }

        public Criteria andMaxStockNotIn(List<Integer> values) {
            addCriterion("max_stock not in", values, "maxStock");
            return (Criteria) this;
        }

        public Criteria andMaxStockBetween(Integer value1, Integer value2) {
            addCriterion("max_stock between", value1, value2, "maxStock");
            return (Criteria) this;
        }

        public Criteria andMaxStockNotBetween(Integer value1, Integer value2) {
            addCriterion("max_stock not between", value1, value2, "maxStock");
            return (Criteria) this;
        }

        public Criteria andPriceIsNull() {
            addCriterion("price is null");
            return (Criteria) this;
        }

        public Criteria andPriceIsNotNull() {
            addCriterion("price is not null");
            return (Criteria) this;
        }

        public Criteria andPriceEqualTo(Double value) {
            addCriterion("price =", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotEqualTo(Double value) {
            addCriterion("price <>", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceGreaterThan(Double value) {
            addCriterion("price >", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceGreaterThanOrEqualTo(Double value) {
            addCriterion("price >=", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceLessThan(Double value) {
            addCriterion("price <", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceLessThanOrEqualTo(Double value) {
            addCriterion("price <=", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceIn(List<Double> values) {
            addCriterion("price in", values, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotIn(List<Double> values) {
            addCriterion("price not in", values, "price");
            return (Criteria) this;
        }

        public Criteria andPriceBetween(Double value1, Double value2) {
            addCriterion("price between", value1, value2, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotBetween(Double value1, Double value2) {
            addCriterion("price not between", value1, value2, "price");
            return (Criteria) this;
        }

        public Criteria andPackageCategoryIsNull() {
            addCriterion("package_category is null");
            return (Criteria) this;
        }

        public Criteria andPackageCategoryIsNotNull() {
            addCriterion("package_category is not null");
            return (Criteria) this;
        }

        public Criteria andPackageCategoryEqualTo(String value) {
            addCriterion("package_category =", value, "packageCategory");
            return (Criteria) this;
        }

        public Criteria andPackageCategoryNotEqualTo(String value) {
            addCriterion("package_category <>", value, "packageCategory");
            return (Criteria) this;
        }

        public Criteria andPackageCategoryGreaterThan(String value) {
            addCriterion("package_category >", value, "packageCategory");
            return (Criteria) this;
        }

        public Criteria andPackageCategoryGreaterThanOrEqualTo(String value) {
            addCriterion("package_category >=", value, "packageCategory");
            return (Criteria) this;
        }

        public Criteria andPackageCategoryLessThan(String value) {
            addCriterion("package_category <", value, "packageCategory");
            return (Criteria) this;
        }

        public Criteria andPackageCategoryLessThanOrEqualTo(String value) {
            addCriterion("package_category <=", value, "packageCategory");
            return (Criteria) this;
        }

        public Criteria andPackageCategoryLike(String value) {
            addCriterion("package_category like", value, "packageCategory");
            return (Criteria) this;
        }

        public Criteria andPackageCategoryNotLike(String value) {
            addCriterion("package_category not like", value, "packageCategory");
            return (Criteria) this;
        }

        public Criteria andPackageCategoryIn(List<String> values) {
            addCriterion("package_category in", values, "packageCategory");
            return (Criteria) this;
        }

        public Criteria andPackageCategoryNotIn(List<String> values) {
            addCriterion("package_category not in", values, "packageCategory");
            return (Criteria) this;
        }

        public Criteria andPackageCategoryBetween(String value1, String value2) {
            addCriterion("package_category between", value1, value2, "packageCategory");
            return (Criteria) this;
        }

        public Criteria andPackageCategoryNotBetween(String value1, String value2) {
            addCriterion("package_category not between", value1, value2, "packageCategory");
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