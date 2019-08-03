package com.sm.model;

import java.util.ArrayList;
import java.util.List;

public class PackageCategoryExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PackageCategoryExample() {
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

        public Criteria andPackageCategoryNameIsNull() {
            addCriterion("package_category_name is null");
            return (Criteria) this;
        }

        public Criteria andPackageCategoryNameIsNotNull() {
            addCriterion("package_category_name is not null");
            return (Criteria) this;
        }

        public Criteria andPackageCategoryNameEqualTo(String value) {
            addCriterion("package_category_name =", value, "packageCategoryName");
            return (Criteria) this;
        }

        public Criteria andPackageCategoryNameNotEqualTo(String value) {
            addCriterion("package_category_name <>", value, "packageCategoryName");
            return (Criteria) this;
        }

        public Criteria andPackageCategoryNameGreaterThan(String value) {
            addCriterion("package_category_name >", value, "packageCategoryName");
            return (Criteria) this;
        }

        public Criteria andPackageCategoryNameGreaterThanOrEqualTo(String value) {
            addCriterion("package_category_name >=", value, "packageCategoryName");
            return (Criteria) this;
        }

        public Criteria andPackageCategoryNameLessThan(String value) {
            addCriterion("package_category_name <", value, "packageCategoryName");
            return (Criteria) this;
        }

        public Criteria andPackageCategoryNameLessThanOrEqualTo(String value) {
            addCriterion("package_category_name <=", value, "packageCategoryName");
            return (Criteria) this;
        }

        public Criteria andPackageCategoryNameLike(String value) {
            addCriterion("package_category_name like", value, "packageCategoryName");
            return (Criteria) this;
        }

        public Criteria andPackageCategoryNameNotLike(String value) {
            addCriterion("package_category_name not like", value, "packageCategoryName");
            return (Criteria) this;
        }

        public Criteria andPackageCategoryNameIn(List<String> values) {
            addCriterion("package_category_name in", values, "packageCategoryName");
            return (Criteria) this;
        }

        public Criteria andPackageCategoryNameNotIn(List<String> values) {
            addCriterion("package_category_name not in", values, "packageCategoryName");
            return (Criteria) this;
        }

        public Criteria andPackageCategoryNameBetween(String value1, String value2) {
            addCriterion("package_category_name between", value1, value2, "packageCategoryName");
            return (Criteria) this;
        }

        public Criteria andPackageCategoryNameNotBetween(String value1, String value2) {
            addCriterion("package_category_name not between", value1, value2, "packageCategoryName");
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

        public Criteria andCategoryOrderIsNull() {
            addCriterion("category_order is null");
            return (Criteria) this;
        }

        public Criteria andCategoryOrderIsNotNull() {
            addCriterion("category_order is not null");
            return (Criteria) this;
        }

        public Criteria andCategoryOrderEqualTo(Integer value) {
            addCriterion("category_order =", value, "categoryOrder");
            return (Criteria) this;
        }

        public Criteria andCategoryOrderNotEqualTo(Integer value) {
            addCriterion("category_order <>", value, "categoryOrder");
            return (Criteria) this;
        }

        public Criteria andCategoryOrderGreaterThan(Integer value) {
            addCriterion("category_order >", value, "categoryOrder");
            return (Criteria) this;
        }

        public Criteria andCategoryOrderGreaterThanOrEqualTo(Integer value) {
            addCriterion("category_order >=", value, "categoryOrder");
            return (Criteria) this;
        }

        public Criteria andCategoryOrderLessThan(Integer value) {
            addCriterion("category_order <", value, "categoryOrder");
            return (Criteria) this;
        }

        public Criteria andCategoryOrderLessThanOrEqualTo(Integer value) {
            addCriterion("category_order <=", value, "categoryOrder");
            return (Criteria) this;
        }

        public Criteria andCategoryOrderIn(List<Integer> values) {
            addCriterion("category_order in", values, "categoryOrder");
            return (Criteria) this;
        }

        public Criteria andCategoryOrderNotIn(List<Integer> values) {
            addCriterion("category_order not in", values, "categoryOrder");
            return (Criteria) this;
        }

        public Criteria andCategoryOrderBetween(Integer value1, Integer value2) {
            addCriterion("category_order between", value1, value2, "categoryOrder");
            return (Criteria) this;
        }

        public Criteria andCategoryOrderNotBetween(Integer value1, Integer value2) {
            addCriterion("category_order not between", value1, value2, "categoryOrder");
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