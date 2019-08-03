package com.sm.model;

import java.util.ArrayList;
import java.util.List;

public class SpecialQualificationExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SpecialQualificationExample() {
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

        public Criteria andCertificatePictureIsNull() {
            addCriterion("certificate_picture is null");
            return (Criteria) this;
        }

        public Criteria andCertificatePictureIsNotNull() {
            addCriterion("certificate_picture is not null");
            return (Criteria) this;
        }

        public Criteria andCertificatePictureEqualTo(String value) {
            addCriterion("certificate_picture =", value, "certificatePicture");
            return (Criteria) this;
        }

        public Criteria andCertificatePictureNotEqualTo(String value) {
            addCriterion("certificate_picture <>", value, "certificatePicture");
            return (Criteria) this;
        }

        public Criteria andCertificatePictureGreaterThan(String value) {
            addCriterion("certificate_picture >", value, "certificatePicture");
            return (Criteria) this;
        }

        public Criteria andCertificatePictureGreaterThanOrEqualTo(String value) {
            addCriterion("certificate_picture >=", value, "certificatePicture");
            return (Criteria) this;
        }

        public Criteria andCertificatePictureLessThan(String value) {
            addCriterion("certificate_picture <", value, "certificatePicture");
            return (Criteria) this;
        }

        public Criteria andCertificatePictureLessThanOrEqualTo(String value) {
            addCriterion("certificate_picture <=", value, "certificatePicture");
            return (Criteria) this;
        }

        public Criteria andCertificatePictureLike(String value) {
            addCriterion("certificate_picture like", value, "certificatePicture");
            return (Criteria) this;
        }

        public Criteria andCertificatePictureNotLike(String value) {
            addCriterion("certificate_picture not like", value, "certificatePicture");
            return (Criteria) this;
        }

        public Criteria andCertificatePictureIn(List<String> values) {
            addCriterion("certificate_picture in", values, "certificatePicture");
            return (Criteria) this;
        }

        public Criteria andCertificatePictureNotIn(List<String> values) {
            addCriterion("certificate_picture not in", values, "certificatePicture");
            return (Criteria) this;
        }

        public Criteria andCertificatePictureBetween(String value1, String value2) {
            addCriterion("certificate_picture between", value1, value2, "certificatePicture");
            return (Criteria) this;
        }

        public Criteria andCertificatePictureNotBetween(String value1, String value2) {
            addCriterion("certificate_picture not between", value1, value2, "certificatePicture");
            return (Criteria) this;
        }

        public Criteria andLicenseNumberIsNull() {
            addCriterion("license_number is null");
            return (Criteria) this;
        }

        public Criteria andLicenseNumberIsNotNull() {
            addCriterion("license_number is not null");
            return (Criteria) this;
        }

        public Criteria andLicenseNumberEqualTo(String value) {
            addCriterion("license_number =", value, "licenseNumber");
            return (Criteria) this;
        }

        public Criteria andLicenseNumberNotEqualTo(String value) {
            addCriterion("license_number <>", value, "licenseNumber");
            return (Criteria) this;
        }

        public Criteria andLicenseNumberGreaterThan(String value) {
            addCriterion("license_number >", value, "licenseNumber");
            return (Criteria) this;
        }

        public Criteria andLicenseNumberGreaterThanOrEqualTo(String value) {
            addCriterion("license_number >=", value, "licenseNumber");
            return (Criteria) this;
        }

        public Criteria andLicenseNumberLessThan(String value) {
            addCriterion("license_number <", value, "licenseNumber");
            return (Criteria) this;
        }

        public Criteria andLicenseNumberLessThanOrEqualTo(String value) {
            addCriterion("license_number <=", value, "licenseNumber");
            return (Criteria) this;
        }

        public Criteria andLicenseNumberLike(String value) {
            addCriterion("license_number like", value, "licenseNumber");
            return (Criteria) this;
        }

        public Criteria andLicenseNumberNotLike(String value) {
            addCriterion("license_number not like", value, "licenseNumber");
            return (Criteria) this;
        }

        public Criteria andLicenseNumberIn(List<String> values) {
            addCriterion("license_number in", values, "licenseNumber");
            return (Criteria) this;
        }

        public Criteria andLicenseNumberNotIn(List<String> values) {
            addCriterion("license_number not in", values, "licenseNumber");
            return (Criteria) this;
        }

        public Criteria andLicenseNumberBetween(String value1, String value2) {
            addCriterion("license_number between", value1, value2, "licenseNumber");
            return (Criteria) this;
        }

        public Criteria andLicenseNumberNotBetween(String value1, String value2) {
            addCriterion("license_number not between", value1, value2, "licenseNumber");
            return (Criteria) this;
        }

        public Criteria andUnitNameIsNull() {
            addCriterion("unit_name is null");
            return (Criteria) this;
        }

        public Criteria andUnitNameIsNotNull() {
            addCriterion("unit_name is not null");
            return (Criteria) this;
        }

        public Criteria andUnitNameEqualTo(String value) {
            addCriterion("unit_name =", value, "unitName");
            return (Criteria) this;
        }

        public Criteria andUnitNameNotEqualTo(String value) {
            addCriterion("unit_name <>", value, "unitName");
            return (Criteria) this;
        }

        public Criteria andUnitNameGreaterThan(String value) {
            addCriterion("unit_name >", value, "unitName");
            return (Criteria) this;
        }

        public Criteria andUnitNameGreaterThanOrEqualTo(String value) {
            addCriterion("unit_name >=", value, "unitName");
            return (Criteria) this;
        }

        public Criteria andUnitNameLessThan(String value) {
            addCriterion("unit_name <", value, "unitName");
            return (Criteria) this;
        }

        public Criteria andUnitNameLessThanOrEqualTo(String value) {
            addCriterion("unit_name <=", value, "unitName");
            return (Criteria) this;
        }

        public Criteria andUnitNameLike(String value) {
            addCriterion("unit_name like", value, "unitName");
            return (Criteria) this;
        }

        public Criteria andUnitNameNotLike(String value) {
            addCriterion("unit_name not like", value, "unitName");
            return (Criteria) this;
        }

        public Criteria andUnitNameIn(List<String> values) {
            addCriterion("unit_name in", values, "unitName");
            return (Criteria) this;
        }

        public Criteria andUnitNameNotIn(List<String> values) {
            addCriterion("unit_name not in", values, "unitName");
            return (Criteria) this;
        }

        public Criteria andUnitNameBetween(String value1, String value2) {
            addCriterion("unit_name between", value1, value2, "unitName");
            return (Criteria) this;
        }

        public Criteria andUnitNameNotBetween(String value1, String value2) {
            addCriterion("unit_name not between", value1, value2, "unitName");
            return (Criteria) this;
        }

        public Criteria andPremisesIsNull() {
            addCriterion("premises is null");
            return (Criteria) this;
        }

        public Criteria andPremisesIsNotNull() {
            addCriterion("premises is not null");
            return (Criteria) this;
        }

        public Criteria andPremisesEqualTo(String value) {
            addCriterion("premises =", value, "premises");
            return (Criteria) this;
        }

        public Criteria andPremisesNotEqualTo(String value) {
            addCriterion("premises <>", value, "premises");
            return (Criteria) this;
        }

        public Criteria andPremisesGreaterThan(String value) {
            addCriterion("premises >", value, "premises");
            return (Criteria) this;
        }

        public Criteria andPremisesGreaterThanOrEqualTo(String value) {
            addCriterion("premises >=", value, "premises");
            return (Criteria) this;
        }

        public Criteria andPremisesLessThan(String value) {
            addCriterion("premises <", value, "premises");
            return (Criteria) this;
        }

        public Criteria andPremisesLessThanOrEqualTo(String value) {
            addCriterion("premises <=", value, "premises");
            return (Criteria) this;
        }

        public Criteria andPremisesLike(String value) {
            addCriterion("premises like", value, "premises");
            return (Criteria) this;
        }

        public Criteria andPremisesNotLike(String value) {
            addCriterion("premises not like", value, "premises");
            return (Criteria) this;
        }

        public Criteria andPremisesIn(List<String> values) {
            addCriterion("premises in", values, "premises");
            return (Criteria) this;
        }

        public Criteria andPremisesNotIn(List<String> values) {
            addCriterion("premises not in", values, "premises");
            return (Criteria) this;
        }

        public Criteria andPremisesBetween(String value1, String value2) {
            addCriterion("premises between", value1, value2, "premises");
            return (Criteria) this;
        }

        public Criteria andPremisesNotBetween(String value1, String value2) {
            addCriterion("premises not between", value1, value2, "premises");
            return (Criteria) this;
        }

        public Criteria andLegalPersonIsNull() {
            addCriterion("legal_person is null");
            return (Criteria) this;
        }

        public Criteria andLegalPersonIsNotNull() {
            addCriterion("legal_person is not null");
            return (Criteria) this;
        }

        public Criteria andLegalPersonEqualTo(String value) {
            addCriterion("legal_person =", value, "legalPerson");
            return (Criteria) this;
        }

        public Criteria andLegalPersonNotEqualTo(String value) {
            addCriterion("legal_person <>", value, "legalPerson");
            return (Criteria) this;
        }

        public Criteria andLegalPersonGreaterThan(String value) {
            addCriterion("legal_person >", value, "legalPerson");
            return (Criteria) this;
        }

        public Criteria andLegalPersonGreaterThanOrEqualTo(String value) {
            addCriterion("legal_person >=", value, "legalPerson");
            return (Criteria) this;
        }

        public Criteria andLegalPersonLessThan(String value) {
            addCriterion("legal_person <", value, "legalPerson");
            return (Criteria) this;
        }

        public Criteria andLegalPersonLessThanOrEqualTo(String value) {
            addCriterion("legal_person <=", value, "legalPerson");
            return (Criteria) this;
        }

        public Criteria andLegalPersonLike(String value) {
            addCriterion("legal_person like", value, "legalPerson");
            return (Criteria) this;
        }

        public Criteria andLegalPersonNotLike(String value) {
            addCriterion("legal_person not like", value, "legalPerson");
            return (Criteria) this;
        }

        public Criteria andLegalPersonIn(List<String> values) {
            addCriterion("legal_person in", values, "legalPerson");
            return (Criteria) this;
        }

        public Criteria andLegalPersonNotIn(List<String> values) {
            addCriterion("legal_person not in", values, "legalPerson");
            return (Criteria) this;
        }

        public Criteria andLegalPersonBetween(String value1, String value2) {
            addCriterion("legal_person between", value1, value2, "legalPerson");
            return (Criteria) this;
        }

        public Criteria andLegalPersonNotBetween(String value1, String value2) {
            addCriterion("legal_person not between", value1, value2, "legalPerson");
            return (Criteria) this;
        }

        public Criteria andLicensePeriodIsNull() {
            addCriterion("license_period is null");
            return (Criteria) this;
        }

        public Criteria andLicensePeriodIsNotNull() {
            addCriterion("license_period is not null");
            return (Criteria) this;
        }

        public Criteria andLicensePeriodEqualTo(String value) {
            addCriterion("license_period =", value, "licensePeriod");
            return (Criteria) this;
        }

        public Criteria andLicensePeriodNotEqualTo(String value) {
            addCriterion("license_period <>", value, "licensePeriod");
            return (Criteria) this;
        }

        public Criteria andLicensePeriodGreaterThan(String value) {
            addCriterion("license_period >", value, "licensePeriod");
            return (Criteria) this;
        }

        public Criteria andLicensePeriodGreaterThanOrEqualTo(String value) {
            addCriterion("license_period >=", value, "licensePeriod");
            return (Criteria) this;
        }

        public Criteria andLicensePeriodLessThan(String value) {
            addCriterion("license_period <", value, "licensePeriod");
            return (Criteria) this;
        }

        public Criteria andLicensePeriodLessThanOrEqualTo(String value) {
            addCriterion("license_period <=", value, "licensePeriod");
            return (Criteria) this;
        }

        public Criteria andLicensePeriodLike(String value) {
            addCriterion("license_period like", value, "licensePeriod");
            return (Criteria) this;
        }

        public Criteria andLicensePeriodNotLike(String value) {
            addCriterion("license_period not like", value, "licensePeriod");
            return (Criteria) this;
        }

        public Criteria andLicensePeriodIn(List<String> values) {
            addCriterion("license_period in", values, "licensePeriod");
            return (Criteria) this;
        }

        public Criteria andLicensePeriodNotIn(List<String> values) {
            addCriterion("license_period not in", values, "licensePeriod");
            return (Criteria) this;
        }

        public Criteria andLicensePeriodBetween(String value1, String value2) {
            addCriterion("license_period between", value1, value2, "licensePeriod");
            return (Criteria) this;
        }

        public Criteria andLicensePeriodNotBetween(String value1, String value2) {
            addCriterion("license_period not between", value1, value2, "licensePeriod");
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