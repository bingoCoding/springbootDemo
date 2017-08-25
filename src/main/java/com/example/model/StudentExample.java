package com.example.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class StudentExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public StudentExample() {
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

        public Criteria andIdEqualTo(String value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(String value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(String value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(String value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(String value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(String value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLike(String value) {
            addCriterion("id like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotLike(String value) {
            addCriterion("id not like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<String> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<String> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(String value1, String value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(String value1, String value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andStudentNoIsNull() {
            addCriterion("student_no is null");
            return (Criteria) this;
        }

        public Criteria andStudentNoIsNotNull() {
            addCriterion("student_no is not null");
            return (Criteria) this;
        }

        public Criteria andStudentNoEqualTo(String value) {
            addCriterion("student_no =", value, "studentNo");
            return (Criteria) this;
        }

        public Criteria andStudentNoNotEqualTo(String value) {
            addCriterion("student_no <>", value, "studentNo");
            return (Criteria) this;
        }

        public Criteria andStudentNoGreaterThan(String value) {
            addCriterion("student_no >", value, "studentNo");
            return (Criteria) this;
        }

        public Criteria andStudentNoGreaterThanOrEqualTo(String value) {
            addCriterion("student_no >=", value, "studentNo");
            return (Criteria) this;
        }

        public Criteria andStudentNoLessThan(String value) {
            addCriterion("student_no <", value, "studentNo");
            return (Criteria) this;
        }

        public Criteria andStudentNoLessThanOrEqualTo(String value) {
            addCriterion("student_no <=", value, "studentNo");
            return (Criteria) this;
        }

        public Criteria andStudentNoLike(String value) {
            addCriterion("student_no like", value, "studentNo");
            return (Criteria) this;
        }

        public Criteria andStudentNoNotLike(String value) {
            addCriterion("student_no not like", value, "studentNo");
            return (Criteria) this;
        }

        public Criteria andStudentNoIn(List<String> values) {
            addCriterion("student_no in", values, "studentNo");
            return (Criteria) this;
        }

        public Criteria andStudentNoNotIn(List<String> values) {
            addCriterion("student_no not in", values, "studentNo");
            return (Criteria) this;
        }

        public Criteria andStudentNoBetween(String value1, String value2) {
            addCriterion("student_no between", value1, value2, "studentNo");
            return (Criteria) this;
        }

        public Criteria andStudentNoNotBetween(String value1, String value2) {
            addCriterion("student_no not between", value1, value2, "studentNo");
            return (Criteria) this;
        }

        public Criteria andStudentPointsIsNull() {
            addCriterion("student_points is null");
            return (Criteria) this;
        }

        public Criteria andStudentPointsIsNotNull() {
            addCriterion("student_points is not null");
            return (Criteria) this;
        }

        public Criteria andStudentPointsEqualTo(Double value) {
            addCriterion("student_points =", value, "studentPoints");
            return (Criteria) this;
        }

        public Criteria andStudentPointsNotEqualTo(Double value) {
            addCriterion("student_points <>", value, "studentPoints");
            return (Criteria) this;
        }

        public Criteria andStudentPointsGreaterThan(Double value) {
            addCriterion("student_points >", value, "studentPoints");
            return (Criteria) this;
        }

        public Criteria andStudentPointsGreaterThanOrEqualTo(Double value) {
            addCriterion("student_points >=", value, "studentPoints");
            return (Criteria) this;
        }

        public Criteria andStudentPointsLessThan(Double value) {
            addCriterion("student_points <", value, "studentPoints");
            return (Criteria) this;
        }

        public Criteria andStudentPointsLessThanOrEqualTo(Double value) {
            addCriterion("student_points <=", value, "studentPoints");
            return (Criteria) this;
        }

        public Criteria andStudentPointsIn(List<Double> values) {
            addCriterion("student_points in", values, "studentPoints");
            return (Criteria) this;
        }

        public Criteria andStudentPointsNotIn(List<Double> values) {
            addCriterion("student_points not in", values, "studentPoints");
            return (Criteria) this;
        }

        public Criteria andStudentPointsBetween(Double value1, Double value2) {
            addCriterion("student_points between", value1, value2, "studentPoints");
            return (Criteria) this;
        }

        public Criteria andStudentPointsNotBetween(Double value1, Double value2) {
            addCriterion("student_points not between", value1, value2, "studentPoints");
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

        public Criteria andNamePyIsNull() {
            addCriterion("name_py is null");
            return (Criteria) this;
        }

        public Criteria andNamePyIsNotNull() {
            addCriterion("name_py is not null");
            return (Criteria) this;
        }

        public Criteria andNamePyEqualTo(String value) {
            addCriterion("name_py =", value, "namePy");
            return (Criteria) this;
        }

        public Criteria andNamePyNotEqualTo(String value) {
            addCriterion("name_py <>", value, "namePy");
            return (Criteria) this;
        }

        public Criteria andNamePyGreaterThan(String value) {
            addCriterion("name_py >", value, "namePy");
            return (Criteria) this;
        }

        public Criteria andNamePyGreaterThanOrEqualTo(String value) {
            addCriterion("name_py >=", value, "namePy");
            return (Criteria) this;
        }

        public Criteria andNamePyLessThan(String value) {
            addCriterion("name_py <", value, "namePy");
            return (Criteria) this;
        }

        public Criteria andNamePyLessThanOrEqualTo(String value) {
            addCriterion("name_py <=", value, "namePy");
            return (Criteria) this;
        }

        public Criteria andNamePyLike(String value) {
            addCriterion("name_py like", value, "namePy");
            return (Criteria) this;
        }

        public Criteria andNamePyNotLike(String value) {
            addCriterion("name_py not like", value, "namePy");
            return (Criteria) this;
        }

        public Criteria andNamePyIn(List<String> values) {
            addCriterion("name_py in", values, "namePy");
            return (Criteria) this;
        }

        public Criteria andNamePyNotIn(List<String> values) {
            addCriterion("name_py not in", values, "namePy");
            return (Criteria) this;
        }

        public Criteria andNamePyBetween(String value1, String value2) {
            addCriterion("name_py between", value1, value2, "namePy");
            return (Criteria) this;
        }

        public Criteria andNamePyNotBetween(String value1, String value2) {
            addCriterion("name_py not between", value1, value2, "namePy");
            return (Criteria) this;
        }

        public Criteria andSexIsNull() {
            addCriterion("sex is null");
            return (Criteria) this;
        }

        public Criteria andSexIsNotNull() {
            addCriterion("sex is not null");
            return (Criteria) this;
        }

        public Criteria andSexEqualTo(String value) {
            addCriterion("sex =", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotEqualTo(String value) {
            addCriterion("sex <>", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexGreaterThan(String value) {
            addCriterion("sex >", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexGreaterThanOrEqualTo(String value) {
            addCriterion("sex >=", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexLessThan(String value) {
            addCriterion("sex <", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexLessThanOrEqualTo(String value) {
            addCriterion("sex <=", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexLike(String value) {
            addCriterion("sex like", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotLike(String value) {
            addCriterion("sex not like", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexIn(List<String> values) {
            addCriterion("sex in", values, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotIn(List<String> values) {
            addCriterion("sex not in", values, "sex");
            return (Criteria) this;
        }

        public Criteria andSexBetween(String value1, String value2) {
            addCriterion("sex between", value1, value2, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotBetween(String value1, String value2) {
            addCriterion("sex not between", value1, value2, "sex");
            return (Criteria) this;
        }

        public Criteria andCardTypeNoIsNull() {
            addCriterion("card_type_no is null");
            return (Criteria) this;
        }

        public Criteria andCardTypeNoIsNotNull() {
            addCriterion("card_type_no is not null");
            return (Criteria) this;
        }

        public Criteria andCardTypeNoEqualTo(Integer value) {
            addCriterion("card_type_no =", value, "cardTypeNo");
            return (Criteria) this;
        }

        public Criteria andCardTypeNoNotEqualTo(Integer value) {
            addCriterion("card_type_no <>", value, "cardTypeNo");
            return (Criteria) this;
        }

        public Criteria andCardTypeNoGreaterThan(Integer value) {
            addCriterion("card_type_no >", value, "cardTypeNo");
            return (Criteria) this;
        }

        public Criteria andCardTypeNoGreaterThanOrEqualTo(Integer value) {
            addCriterion("card_type_no >=", value, "cardTypeNo");
            return (Criteria) this;
        }

        public Criteria andCardTypeNoLessThan(Integer value) {
            addCriterion("card_type_no <", value, "cardTypeNo");
            return (Criteria) this;
        }

        public Criteria andCardTypeNoLessThanOrEqualTo(Integer value) {
            addCriterion("card_type_no <=", value, "cardTypeNo");
            return (Criteria) this;
        }

        public Criteria andCardTypeNoIn(List<Integer> values) {
            addCriterion("card_type_no in", values, "cardTypeNo");
            return (Criteria) this;
        }

        public Criteria andCardTypeNoNotIn(List<Integer> values) {
            addCriterion("card_type_no not in", values, "cardTypeNo");
            return (Criteria) this;
        }

        public Criteria andCardTypeNoBetween(Integer value1, Integer value2) {
            addCriterion("card_type_no between", value1, value2, "cardTypeNo");
            return (Criteria) this;
        }

        public Criteria andCardTypeNoNotBetween(Integer value1, Integer value2) {
            addCriterion("card_type_no not between", value1, value2, "cardTypeNo");
            return (Criteria) this;
        }

        public Criteria andCardTypeIsNull() {
            addCriterion("card_type is null");
            return (Criteria) this;
        }

        public Criteria andCardTypeIsNotNull() {
            addCriterion("card_type is not null");
            return (Criteria) this;
        }

        public Criteria andCardTypeEqualTo(String value) {
            addCriterion("card_type =", value, "cardType");
            return (Criteria) this;
        }

        public Criteria andCardTypeNotEqualTo(String value) {
            addCriterion("card_type <>", value, "cardType");
            return (Criteria) this;
        }

        public Criteria andCardTypeGreaterThan(String value) {
            addCriterion("card_type >", value, "cardType");
            return (Criteria) this;
        }

        public Criteria andCardTypeGreaterThanOrEqualTo(String value) {
            addCriterion("card_type >=", value, "cardType");
            return (Criteria) this;
        }

        public Criteria andCardTypeLessThan(String value) {
            addCriterion("card_type <", value, "cardType");
            return (Criteria) this;
        }

        public Criteria andCardTypeLessThanOrEqualTo(String value) {
            addCriterion("card_type <=", value, "cardType");
            return (Criteria) this;
        }

        public Criteria andCardTypeLike(String value) {
            addCriterion("card_type like", value, "cardType");
            return (Criteria) this;
        }

        public Criteria andCardTypeNotLike(String value) {
            addCriterion("card_type not like", value, "cardType");
            return (Criteria) this;
        }

        public Criteria andCardTypeIn(List<String> values) {
            addCriterion("card_type in", values, "cardType");
            return (Criteria) this;
        }

        public Criteria andCardTypeNotIn(List<String> values) {
            addCriterion("card_type not in", values, "cardType");
            return (Criteria) this;
        }

        public Criteria andCardTypeBetween(String value1, String value2) {
            addCriterion("card_type between", value1, value2, "cardType");
            return (Criteria) this;
        }

        public Criteria andCardTypeNotBetween(String value1, String value2) {
            addCriterion("card_type not between", value1, value2, "cardType");
            return (Criteria) this;
        }

        public Criteria andCardNoIsNull() {
            addCriterion("card_no is null");
            return (Criteria) this;
        }

        public Criteria andCardNoIsNotNull() {
            addCriterion("card_no is not null");
            return (Criteria) this;
        }

        public Criteria andCardNoEqualTo(String value) {
            addCriterion("card_no =", value, "cardNo");
            return (Criteria) this;
        }

        public Criteria andCardNoNotEqualTo(String value) {
            addCriterion("card_no <>", value, "cardNo");
            return (Criteria) this;
        }

        public Criteria andCardNoGreaterThan(String value) {
            addCriterion("card_no >", value, "cardNo");
            return (Criteria) this;
        }

        public Criteria andCardNoGreaterThanOrEqualTo(String value) {
            addCriterion("card_no >=", value, "cardNo");
            return (Criteria) this;
        }

        public Criteria andCardNoLessThan(String value) {
            addCriterion("card_no <", value, "cardNo");
            return (Criteria) this;
        }

        public Criteria andCardNoLessThanOrEqualTo(String value) {
            addCriterion("card_no <=", value, "cardNo");
            return (Criteria) this;
        }

        public Criteria andCardNoLike(String value) {
            addCriterion("card_no like", value, "cardNo");
            return (Criteria) this;
        }

        public Criteria andCardNoNotLike(String value) {
            addCriterion("card_no not like", value, "cardNo");
            return (Criteria) this;
        }

        public Criteria andCardNoIn(List<String> values) {
            addCriterion("card_no in", values, "cardNo");
            return (Criteria) this;
        }

        public Criteria andCardNoNotIn(List<String> values) {
            addCriterion("card_no not in", values, "cardNo");
            return (Criteria) this;
        }

        public Criteria andCardNoBetween(String value1, String value2) {
            addCriterion("card_no between", value1, value2, "cardNo");
            return (Criteria) this;
        }

        public Criteria andCardNoNotBetween(String value1, String value2) {
            addCriterion("card_no not between", value1, value2, "cardNo");
            return (Criteria) this;
        }

        public Criteria andBirthdayIsNull() {
            addCriterion("birthday is null");
            return (Criteria) this;
        }

        public Criteria andBirthdayIsNotNull() {
            addCriterion("birthday is not null");
            return (Criteria) this;
        }

        public Criteria andBirthdayEqualTo(String value) {
            addCriterion("birthday =", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayNotEqualTo(String value) {
            addCriterion("birthday <>", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayGreaterThan(String value) {
            addCriterion("birthday >", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayGreaterThanOrEqualTo(String value) {
            addCriterion("birthday >=", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayLessThan(String value) {
            addCriterion("birthday <", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayLessThanOrEqualTo(String value) {
            addCriterion("birthday <=", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayLike(String value) {
            addCriterion("birthday like", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayNotLike(String value) {
            addCriterion("birthday not like", value, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayIn(List<String> values) {
            addCriterion("birthday in", values, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayNotIn(List<String> values) {
            addCriterion("birthday not in", values, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayBetween(String value1, String value2) {
            addCriterion("birthday between", value1, value2, "birthday");
            return (Criteria) this;
        }

        public Criteria andBirthdayNotBetween(String value1, String value2) {
            addCriterion("birthday not between", value1, value2, "birthday");
            return (Criteria) this;
        }

        public Criteria andNationalityIsNull() {
            addCriterion("nationality is null");
            return (Criteria) this;
        }

        public Criteria andNationalityIsNotNull() {
            addCriterion("nationality is not null");
            return (Criteria) this;
        }

        public Criteria andNationalityEqualTo(String value) {
            addCriterion("nationality =", value, "nationality");
            return (Criteria) this;
        }

        public Criteria andNationalityNotEqualTo(String value) {
            addCriterion("nationality <>", value, "nationality");
            return (Criteria) this;
        }

        public Criteria andNationalityGreaterThan(String value) {
            addCriterion("nationality >", value, "nationality");
            return (Criteria) this;
        }

        public Criteria andNationalityGreaterThanOrEqualTo(String value) {
            addCriterion("nationality >=", value, "nationality");
            return (Criteria) this;
        }

        public Criteria andNationalityLessThan(String value) {
            addCriterion("nationality <", value, "nationality");
            return (Criteria) this;
        }

        public Criteria andNationalityLessThanOrEqualTo(String value) {
            addCriterion("nationality <=", value, "nationality");
            return (Criteria) this;
        }

        public Criteria andNationalityLike(String value) {
            addCriterion("nationality like", value, "nationality");
            return (Criteria) this;
        }

        public Criteria andNationalityNotLike(String value) {
            addCriterion("nationality not like", value, "nationality");
            return (Criteria) this;
        }

        public Criteria andNationalityIn(List<String> values) {
            addCriterion("nationality in", values, "nationality");
            return (Criteria) this;
        }

        public Criteria andNationalityNotIn(List<String> values) {
            addCriterion("nationality not in", values, "nationality");
            return (Criteria) this;
        }

        public Criteria andNationalityBetween(String value1, String value2) {
            addCriterion("nationality between", value1, value2, "nationality");
            return (Criteria) this;
        }

        public Criteria andNationalityNotBetween(String value1, String value2) {
            addCriterion("nationality not between", value1, value2, "nationality");
            return (Criteria) this;
        }

        public Criteria andAreaIsNull() {
            addCriterion("area is null");
            return (Criteria) this;
        }

        public Criteria andAreaIsNotNull() {
            addCriterion("area is not null");
            return (Criteria) this;
        }

        public Criteria andAreaEqualTo(String value) {
            addCriterion("area =", value, "area");
            return (Criteria) this;
        }

        public Criteria andAreaNotEqualTo(String value) {
            addCriterion("area <>", value, "area");
            return (Criteria) this;
        }

        public Criteria andAreaGreaterThan(String value) {
            addCriterion("area >", value, "area");
            return (Criteria) this;
        }

        public Criteria andAreaGreaterThanOrEqualTo(String value) {
            addCriterion("area >=", value, "area");
            return (Criteria) this;
        }

        public Criteria andAreaLessThan(String value) {
            addCriterion("area <", value, "area");
            return (Criteria) this;
        }

        public Criteria andAreaLessThanOrEqualTo(String value) {
            addCriterion("area <=", value, "area");
            return (Criteria) this;
        }

        public Criteria andAreaLike(String value) {
            addCriterion("area like", value, "area");
            return (Criteria) this;
        }

        public Criteria andAreaNotLike(String value) {
            addCriterion("area not like", value, "area");
            return (Criteria) this;
        }

        public Criteria andAreaIn(List<String> values) {
            addCriterion("area in", values, "area");
            return (Criteria) this;
        }

        public Criteria andAreaNotIn(List<String> values) {
            addCriterion("area not in", values, "area");
            return (Criteria) this;
        }

        public Criteria andAreaBetween(String value1, String value2) {
            addCriterion("area between", value1, value2, "area");
            return (Criteria) this;
        }

        public Criteria andAreaNotBetween(String value1, String value2) {
            addCriterion("area not between", value1, value2, "area");
            return (Criteria) this;
        }

        public Criteria andNationIsNull() {
            addCriterion("nation is null");
            return (Criteria) this;
        }

        public Criteria andNationIsNotNull() {
            addCriterion("nation is not null");
            return (Criteria) this;
        }

        public Criteria andNationEqualTo(String value) {
            addCriterion("nation =", value, "nation");
            return (Criteria) this;
        }

        public Criteria andNationNotEqualTo(String value) {
            addCriterion("nation <>", value, "nation");
            return (Criteria) this;
        }

        public Criteria andNationGreaterThan(String value) {
            addCriterion("nation >", value, "nation");
            return (Criteria) this;
        }

        public Criteria andNationGreaterThanOrEqualTo(String value) {
            addCriterion("nation >=", value, "nation");
            return (Criteria) this;
        }

        public Criteria andNationLessThan(String value) {
            addCriterion("nation <", value, "nation");
            return (Criteria) this;
        }

        public Criteria andNationLessThanOrEqualTo(String value) {
            addCriterion("nation <=", value, "nation");
            return (Criteria) this;
        }

        public Criteria andNationLike(String value) {
            addCriterion("nation like", value, "nation");
            return (Criteria) this;
        }

        public Criteria andNationNotLike(String value) {
            addCriterion("nation not like", value, "nation");
            return (Criteria) this;
        }

        public Criteria andNationIn(List<String> values) {
            addCriterion("nation in", values, "nation");
            return (Criteria) this;
        }

        public Criteria andNationNotIn(List<String> values) {
            addCriterion("nation not in", values, "nation");
            return (Criteria) this;
        }

        public Criteria andNationBetween(String value1, String value2) {
            addCriterion("nation between", value1, value2, "nation");
            return (Criteria) this;
        }

        public Criteria andNationNotBetween(String value1, String value2) {
            addCriterion("nation not between", value1, value2, "nation");
            return (Criteria) this;
        }

        public Criteria andPhotoNameIsNull() {
            addCriterion("photo_name is null");
            return (Criteria) this;
        }

        public Criteria andPhotoNameIsNotNull() {
            addCriterion("photo_name is not null");
            return (Criteria) this;
        }

        public Criteria andPhotoNameEqualTo(String value) {
            addCriterion("photo_name =", value, "photoName");
            return (Criteria) this;
        }

        public Criteria andPhotoNameNotEqualTo(String value) {
            addCriterion("photo_name <>", value, "photoName");
            return (Criteria) this;
        }

        public Criteria andPhotoNameGreaterThan(String value) {
            addCriterion("photo_name >", value, "photoName");
            return (Criteria) this;
        }

        public Criteria andPhotoNameGreaterThanOrEqualTo(String value) {
            addCriterion("photo_name >=", value, "photoName");
            return (Criteria) this;
        }

        public Criteria andPhotoNameLessThan(String value) {
            addCriterion("photo_name <", value, "photoName");
            return (Criteria) this;
        }

        public Criteria andPhotoNameLessThanOrEqualTo(String value) {
            addCriterion("photo_name <=", value, "photoName");
            return (Criteria) this;
        }

        public Criteria andPhotoNameLike(String value) {
            addCriterion("photo_name like", value, "photoName");
            return (Criteria) this;
        }

        public Criteria andPhotoNameNotLike(String value) {
            addCriterion("photo_name not like", value, "photoName");
            return (Criteria) this;
        }

        public Criteria andPhotoNameIn(List<String> values) {
            addCriterion("photo_name in", values, "photoName");
            return (Criteria) this;
        }

        public Criteria andPhotoNameNotIn(List<String> values) {
            addCriterion("photo_name not in", values, "photoName");
            return (Criteria) this;
        }

        public Criteria andPhotoNameBetween(String value1, String value2) {
            addCriterion("photo_name between", value1, value2, "photoName");
            return (Criteria) this;
        }

        public Criteria andPhotoNameNotBetween(String value1, String value2) {
            addCriterion("photo_name not between", value1, value2, "photoName");
            return (Criteria) this;
        }

        public Criteria andPhotoExtIsNull() {
            addCriterion("photo_ext is null");
            return (Criteria) this;
        }

        public Criteria andPhotoExtIsNotNull() {
            addCriterion("photo_ext is not null");
            return (Criteria) this;
        }

        public Criteria andPhotoExtEqualTo(String value) {
            addCriterion("photo_ext =", value, "photoExt");
            return (Criteria) this;
        }

        public Criteria andPhotoExtNotEqualTo(String value) {
            addCriterion("photo_ext <>", value, "photoExt");
            return (Criteria) this;
        }

        public Criteria andPhotoExtGreaterThan(String value) {
            addCriterion("photo_ext >", value, "photoExt");
            return (Criteria) this;
        }

        public Criteria andPhotoExtGreaterThanOrEqualTo(String value) {
            addCriterion("photo_ext >=", value, "photoExt");
            return (Criteria) this;
        }

        public Criteria andPhotoExtLessThan(String value) {
            addCriterion("photo_ext <", value, "photoExt");
            return (Criteria) this;
        }

        public Criteria andPhotoExtLessThanOrEqualTo(String value) {
            addCriterion("photo_ext <=", value, "photoExt");
            return (Criteria) this;
        }

        public Criteria andPhotoExtLike(String value) {
            addCriterion("photo_ext like", value, "photoExt");
            return (Criteria) this;
        }

        public Criteria andPhotoExtNotLike(String value) {
            addCriterion("photo_ext not like", value, "photoExt");
            return (Criteria) this;
        }

        public Criteria andPhotoExtIn(List<String> values) {
            addCriterion("photo_ext in", values, "photoExt");
            return (Criteria) this;
        }

        public Criteria andPhotoExtNotIn(List<String> values) {
            addCriterion("photo_ext not in", values, "photoExt");
            return (Criteria) this;
        }

        public Criteria andPhotoExtBetween(String value1, String value2) {
            addCriterion("photo_ext between", value1, value2, "photoExt");
            return (Criteria) this;
        }

        public Criteria andPhotoExtNotBetween(String value1, String value2) {
            addCriterion("photo_ext not between", value1, value2, "photoExt");
            return (Criteria) this;
        }

        public Criteria andPhotoAllNameIsNull() {
            addCriterion("photo_all_name is null");
            return (Criteria) this;
        }

        public Criteria andPhotoAllNameIsNotNull() {
            addCriterion("photo_all_name is not null");
            return (Criteria) this;
        }

        public Criteria andPhotoAllNameEqualTo(String value) {
            addCriterion("photo_all_name =", value, "photoAllName");
            return (Criteria) this;
        }

        public Criteria andPhotoAllNameNotEqualTo(String value) {
            addCriterion("photo_all_name <>", value, "photoAllName");
            return (Criteria) this;
        }

        public Criteria andPhotoAllNameGreaterThan(String value) {
            addCriterion("photo_all_name >", value, "photoAllName");
            return (Criteria) this;
        }

        public Criteria andPhotoAllNameGreaterThanOrEqualTo(String value) {
            addCriterion("photo_all_name >=", value, "photoAllName");
            return (Criteria) this;
        }

        public Criteria andPhotoAllNameLessThan(String value) {
            addCriterion("photo_all_name <", value, "photoAllName");
            return (Criteria) this;
        }

        public Criteria andPhotoAllNameLessThanOrEqualTo(String value) {
            addCriterion("photo_all_name <=", value, "photoAllName");
            return (Criteria) this;
        }

        public Criteria andPhotoAllNameLike(String value) {
            addCriterion("photo_all_name like", value, "photoAllName");
            return (Criteria) this;
        }

        public Criteria andPhotoAllNameNotLike(String value) {
            addCriterion("photo_all_name not like", value, "photoAllName");
            return (Criteria) this;
        }

        public Criteria andPhotoAllNameIn(List<String> values) {
            addCriterion("photo_all_name in", values, "photoAllName");
            return (Criteria) this;
        }

        public Criteria andPhotoAllNameNotIn(List<String> values) {
            addCriterion("photo_all_name not in", values, "photoAllName");
            return (Criteria) this;
        }

        public Criteria andPhotoAllNameBetween(String value1, String value2) {
            addCriterion("photo_all_name between", value1, value2, "photoAllName");
            return (Criteria) this;
        }

        public Criteria andPhotoAllNameNotBetween(String value1, String value2) {
            addCriterion("photo_all_name not between", value1, value2, "photoAllName");
            return (Criteria) this;
        }

        public Criteria andPhotoTopNameIsNull() {
            addCriterion("photo_top_name is null");
            return (Criteria) this;
        }

        public Criteria andPhotoTopNameIsNotNull() {
            addCriterion("photo_top_name is not null");
            return (Criteria) this;
        }

        public Criteria andPhotoTopNameEqualTo(String value) {
            addCriterion("photo_top_name =", value, "photoTopName");
            return (Criteria) this;
        }

        public Criteria andPhotoTopNameNotEqualTo(String value) {
            addCriterion("photo_top_name <>", value, "photoTopName");
            return (Criteria) this;
        }

        public Criteria andPhotoTopNameGreaterThan(String value) {
            addCriterion("photo_top_name >", value, "photoTopName");
            return (Criteria) this;
        }

        public Criteria andPhotoTopNameGreaterThanOrEqualTo(String value) {
            addCriterion("photo_top_name >=", value, "photoTopName");
            return (Criteria) this;
        }

        public Criteria andPhotoTopNameLessThan(String value) {
            addCriterion("photo_top_name <", value, "photoTopName");
            return (Criteria) this;
        }

        public Criteria andPhotoTopNameLessThanOrEqualTo(String value) {
            addCriterion("photo_top_name <=", value, "photoTopName");
            return (Criteria) this;
        }

        public Criteria andPhotoTopNameLike(String value) {
            addCriterion("photo_top_name like", value, "photoTopName");
            return (Criteria) this;
        }

        public Criteria andPhotoTopNameNotLike(String value) {
            addCriterion("photo_top_name not like", value, "photoTopName");
            return (Criteria) this;
        }

        public Criteria andPhotoTopNameIn(List<String> values) {
            addCriterion("photo_top_name in", values, "photoTopName");
            return (Criteria) this;
        }

        public Criteria andPhotoTopNameNotIn(List<String> values) {
            addCriterion("photo_top_name not in", values, "photoTopName");
            return (Criteria) this;
        }

        public Criteria andPhotoTopNameBetween(String value1, String value2) {
            addCriterion("photo_top_name between", value1, value2, "photoTopName");
            return (Criteria) this;
        }

        public Criteria andPhotoTopNameNotBetween(String value1, String value2) {
            addCriterion("photo_top_name not between", value1, value2, "photoTopName");
            return (Criteria) this;
        }

        public Criteria andPhotoOldNameIsNull() {
            addCriterion("photo_old_name is null");
            return (Criteria) this;
        }

        public Criteria andPhotoOldNameIsNotNull() {
            addCriterion("photo_old_name is not null");
            return (Criteria) this;
        }

        public Criteria andPhotoOldNameEqualTo(String value) {
            addCriterion("photo_old_name =", value, "photoOldName");
            return (Criteria) this;
        }

        public Criteria andPhotoOldNameNotEqualTo(String value) {
            addCriterion("photo_old_name <>", value, "photoOldName");
            return (Criteria) this;
        }

        public Criteria andPhotoOldNameGreaterThan(String value) {
            addCriterion("photo_old_name >", value, "photoOldName");
            return (Criteria) this;
        }

        public Criteria andPhotoOldNameGreaterThanOrEqualTo(String value) {
            addCriterion("photo_old_name >=", value, "photoOldName");
            return (Criteria) this;
        }

        public Criteria andPhotoOldNameLessThan(String value) {
            addCriterion("photo_old_name <", value, "photoOldName");
            return (Criteria) this;
        }

        public Criteria andPhotoOldNameLessThanOrEqualTo(String value) {
            addCriterion("photo_old_name <=", value, "photoOldName");
            return (Criteria) this;
        }

        public Criteria andPhotoOldNameLike(String value) {
            addCriterion("photo_old_name like", value, "photoOldName");
            return (Criteria) this;
        }

        public Criteria andPhotoOldNameNotLike(String value) {
            addCriterion("photo_old_name not like", value, "photoOldName");
            return (Criteria) this;
        }

        public Criteria andPhotoOldNameIn(List<String> values) {
            addCriterion("photo_old_name in", values, "photoOldName");
            return (Criteria) this;
        }

        public Criteria andPhotoOldNameNotIn(List<String> values) {
            addCriterion("photo_old_name not in", values, "photoOldName");
            return (Criteria) this;
        }

        public Criteria andPhotoOldNameBetween(String value1, String value2) {
            addCriterion("photo_old_name between", value1, value2, "photoOldName");
            return (Criteria) this;
        }

        public Criteria andPhotoOldNameNotBetween(String value1, String value2) {
            addCriterion("photo_old_name not between", value1, value2, "photoOldName");
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

        public Criteria andPostNoIsNull() {
            addCriterion("post_no is null");
            return (Criteria) this;
        }

        public Criteria andPostNoIsNotNull() {
            addCriterion("post_no is not null");
            return (Criteria) this;
        }

        public Criteria andPostNoEqualTo(String value) {
            addCriterion("post_no =", value, "postNo");
            return (Criteria) this;
        }

        public Criteria andPostNoNotEqualTo(String value) {
            addCriterion("post_no <>", value, "postNo");
            return (Criteria) this;
        }

        public Criteria andPostNoGreaterThan(String value) {
            addCriterion("post_no >", value, "postNo");
            return (Criteria) this;
        }

        public Criteria andPostNoGreaterThanOrEqualTo(String value) {
            addCriterion("post_no >=", value, "postNo");
            return (Criteria) this;
        }

        public Criteria andPostNoLessThan(String value) {
            addCriterion("post_no <", value, "postNo");
            return (Criteria) this;
        }

        public Criteria andPostNoLessThanOrEqualTo(String value) {
            addCriterion("post_no <=", value, "postNo");
            return (Criteria) this;
        }

        public Criteria andPostNoLike(String value) {
            addCriterion("post_no like", value, "postNo");
            return (Criteria) this;
        }

        public Criteria andPostNoNotLike(String value) {
            addCriterion("post_no not like", value, "postNo");
            return (Criteria) this;
        }

        public Criteria andPostNoIn(List<String> values) {
            addCriterion("post_no in", values, "postNo");
            return (Criteria) this;
        }

        public Criteria andPostNoNotIn(List<String> values) {
            addCriterion("post_no not in", values, "postNo");
            return (Criteria) this;
        }

        public Criteria andPostNoBetween(String value1, String value2) {
            addCriterion("post_no between", value1, value2, "postNo");
            return (Criteria) this;
        }

        public Criteria andPostNoNotBetween(String value1, String value2) {
            addCriterion("post_no not between", value1, value2, "postNo");
            return (Criteria) this;
        }

        public Criteria andEmailIsNull() {
            addCriterion("email is null");
            return (Criteria) this;
        }

        public Criteria andEmailIsNotNull() {
            addCriterion("email is not null");
            return (Criteria) this;
        }

        public Criteria andEmailEqualTo(String value) {
            addCriterion("email =", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotEqualTo(String value) {
            addCriterion("email <>", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailGreaterThan(String value) {
            addCriterion("email >", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailGreaterThanOrEqualTo(String value) {
            addCriterion("email >=", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLessThan(String value) {
            addCriterion("email <", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLessThanOrEqualTo(String value) {
            addCriterion("email <=", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLike(String value) {
            addCriterion("email like", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotLike(String value) {
            addCriterion("email not like", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailIn(List<String> values) {
            addCriterion("email in", values, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotIn(List<String> values) {
            addCriterion("email not in", values, "email");
            return (Criteria) this;
        }

        public Criteria andEmailBetween(String value1, String value2) {
            addCriterion("email between", value1, value2, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotBetween(String value1, String value2) {
            addCriterion("email not between", value1, value2, "email");
            return (Criteria) this;
        }

        public Criteria andAddrIsNull() {
            addCriterion("addr is null");
            return (Criteria) this;
        }

        public Criteria andAddrIsNotNull() {
            addCriterion("addr is not null");
            return (Criteria) this;
        }

        public Criteria andAddrEqualTo(String value) {
            addCriterion("addr =", value, "addr");
            return (Criteria) this;
        }

        public Criteria andAddrNotEqualTo(String value) {
            addCriterion("addr <>", value, "addr");
            return (Criteria) this;
        }

        public Criteria andAddrGreaterThan(String value) {
            addCriterion("addr >", value, "addr");
            return (Criteria) this;
        }

        public Criteria andAddrGreaterThanOrEqualTo(String value) {
            addCriterion("addr >=", value, "addr");
            return (Criteria) this;
        }

        public Criteria andAddrLessThan(String value) {
            addCriterion("addr <", value, "addr");
            return (Criteria) this;
        }

        public Criteria andAddrLessThanOrEqualTo(String value) {
            addCriterion("addr <=", value, "addr");
            return (Criteria) this;
        }

        public Criteria andAddrLike(String value) {
            addCriterion("addr like", value, "addr");
            return (Criteria) this;
        }

        public Criteria andAddrNotLike(String value) {
            addCriterion("addr not like", value, "addr");
            return (Criteria) this;
        }

        public Criteria andAddrIn(List<String> values) {
            addCriterion("addr in", values, "addr");
            return (Criteria) this;
        }

        public Criteria andAddrNotIn(List<String> values) {
            addCriterion("addr not in", values, "addr");
            return (Criteria) this;
        }

        public Criteria andAddrBetween(String value1, String value2) {
            addCriterion("addr between", value1, value2, "addr");
            return (Criteria) this;
        }

        public Criteria andAddrNotBetween(String value1, String value2) {
            addCriterion("addr not between", value1, value2, "addr");
            return (Criteria) this;
        }

        public Criteria andName1IsNull() {
            addCriterion("name1 is null");
            return (Criteria) this;
        }

        public Criteria andName1IsNotNull() {
            addCriterion("name1 is not null");
            return (Criteria) this;
        }

        public Criteria andName1EqualTo(String value) {
            addCriterion("name1 =", value, "name1");
            return (Criteria) this;
        }

        public Criteria andName1NotEqualTo(String value) {
            addCriterion("name1 <>", value, "name1");
            return (Criteria) this;
        }

        public Criteria andName1GreaterThan(String value) {
            addCriterion("name1 >", value, "name1");
            return (Criteria) this;
        }

        public Criteria andName1GreaterThanOrEqualTo(String value) {
            addCriterion("name1 >=", value, "name1");
            return (Criteria) this;
        }

        public Criteria andName1LessThan(String value) {
            addCriterion("name1 <", value, "name1");
            return (Criteria) this;
        }

        public Criteria andName1LessThanOrEqualTo(String value) {
            addCriterion("name1 <=", value, "name1");
            return (Criteria) this;
        }

        public Criteria andName1Like(String value) {
            addCriterion("name1 like", value, "name1");
            return (Criteria) this;
        }

        public Criteria andName1NotLike(String value) {
            addCriterion("name1 not like", value, "name1");
            return (Criteria) this;
        }

        public Criteria andName1In(List<String> values) {
            addCriterion("name1 in", values, "name1");
            return (Criteria) this;
        }

        public Criteria andName1NotIn(List<String> values) {
            addCriterion("name1 not in", values, "name1");
            return (Criteria) this;
        }

        public Criteria andName1Between(String value1, String value2) {
            addCriterion("name1 between", value1, value2, "name1");
            return (Criteria) this;
        }

        public Criteria andName1NotBetween(String value1, String value2) {
            addCriterion("name1 not between", value1, value2, "name1");
            return (Criteria) this;
        }

        public Criteria andPhone1IsNull() {
            addCriterion("phone1 is null");
            return (Criteria) this;
        }

        public Criteria andPhone1IsNotNull() {
            addCriterion("phone1 is not null");
            return (Criteria) this;
        }

        public Criteria andPhone1EqualTo(String value) {
            addCriterion("phone1 =", value, "phone1");
            return (Criteria) this;
        }

        public Criteria andPhone1NotEqualTo(String value) {
            addCriterion("phone1 <>", value, "phone1");
            return (Criteria) this;
        }

        public Criteria andPhone1GreaterThan(String value) {
            addCriterion("phone1 >", value, "phone1");
            return (Criteria) this;
        }

        public Criteria andPhone1GreaterThanOrEqualTo(String value) {
            addCriterion("phone1 >=", value, "phone1");
            return (Criteria) this;
        }

        public Criteria andPhone1LessThan(String value) {
            addCriterion("phone1 <", value, "phone1");
            return (Criteria) this;
        }

        public Criteria andPhone1LessThanOrEqualTo(String value) {
            addCriterion("phone1 <=", value, "phone1");
            return (Criteria) this;
        }

        public Criteria andPhone1Like(String value) {
            addCriterion("phone1 like", value, "phone1");
            return (Criteria) this;
        }

        public Criteria andPhone1NotLike(String value) {
            addCriterion("phone1 not like", value, "phone1");
            return (Criteria) this;
        }

        public Criteria andPhone1In(List<String> values) {
            addCriterion("phone1 in", values, "phone1");
            return (Criteria) this;
        }

        public Criteria andPhone1NotIn(List<String> values) {
            addCriterion("phone1 not in", values, "phone1");
            return (Criteria) this;
        }

        public Criteria andPhone1Between(String value1, String value2) {
            addCriterion("phone1 between", value1, value2, "phone1");
            return (Criteria) this;
        }

        public Criteria andPhone1NotBetween(String value1, String value2) {
            addCriterion("phone1 not between", value1, value2, "phone1");
            return (Criteria) this;
        }

        public Criteria andRelation1IsNull() {
            addCriterion("relation1 is null");
            return (Criteria) this;
        }

        public Criteria andRelation1IsNotNull() {
            addCriterion("relation1 is not null");
            return (Criteria) this;
        }

        public Criteria andRelation1EqualTo(String value) {
            addCriterion("relation1 =", value, "relation1");
            return (Criteria) this;
        }

        public Criteria andRelation1NotEqualTo(String value) {
            addCriterion("relation1 <>", value, "relation1");
            return (Criteria) this;
        }

        public Criteria andRelation1GreaterThan(String value) {
            addCriterion("relation1 >", value, "relation1");
            return (Criteria) this;
        }

        public Criteria andRelation1GreaterThanOrEqualTo(String value) {
            addCriterion("relation1 >=", value, "relation1");
            return (Criteria) this;
        }

        public Criteria andRelation1LessThan(String value) {
            addCriterion("relation1 <", value, "relation1");
            return (Criteria) this;
        }

        public Criteria andRelation1LessThanOrEqualTo(String value) {
            addCriterion("relation1 <=", value, "relation1");
            return (Criteria) this;
        }

        public Criteria andRelation1Like(String value) {
            addCriterion("relation1 like", value, "relation1");
            return (Criteria) this;
        }

        public Criteria andRelation1NotLike(String value) {
            addCriterion("relation1 not like", value, "relation1");
            return (Criteria) this;
        }

        public Criteria andRelation1In(List<String> values) {
            addCriterion("relation1 in", values, "relation1");
            return (Criteria) this;
        }

        public Criteria andRelation1NotIn(List<String> values) {
            addCriterion("relation1 not in", values, "relation1");
            return (Criteria) this;
        }

        public Criteria andRelation1Between(String value1, String value2) {
            addCriterion("relation1 between", value1, value2, "relation1");
            return (Criteria) this;
        }

        public Criteria andRelation1NotBetween(String value1, String value2) {
            addCriterion("relation1 not between", value1, value2, "relation1");
            return (Criteria) this;
        }

        public Criteria andRelationNo1IsNull() {
            addCriterion("relation_no1 is null");
            return (Criteria) this;
        }

        public Criteria andRelationNo1IsNotNull() {
            addCriterion("relation_no1 is not null");
            return (Criteria) this;
        }

        public Criteria andRelationNo1EqualTo(Integer value) {
            addCriterion("relation_no1 =", value, "relationNo1");
            return (Criteria) this;
        }

        public Criteria andRelationNo1NotEqualTo(Integer value) {
            addCriterion("relation_no1 <>", value, "relationNo1");
            return (Criteria) this;
        }

        public Criteria andRelationNo1GreaterThan(Integer value) {
            addCriterion("relation_no1 >", value, "relationNo1");
            return (Criteria) this;
        }

        public Criteria andRelationNo1GreaterThanOrEqualTo(Integer value) {
            addCriterion("relation_no1 >=", value, "relationNo1");
            return (Criteria) this;
        }

        public Criteria andRelationNo1LessThan(Integer value) {
            addCriterion("relation_no1 <", value, "relationNo1");
            return (Criteria) this;
        }

        public Criteria andRelationNo1LessThanOrEqualTo(Integer value) {
            addCriterion("relation_no1 <=", value, "relationNo1");
            return (Criteria) this;
        }

        public Criteria andRelationNo1In(List<Integer> values) {
            addCriterion("relation_no1 in", values, "relationNo1");
            return (Criteria) this;
        }

        public Criteria andRelationNo1NotIn(List<Integer> values) {
            addCriterion("relation_no1 not in", values, "relationNo1");
            return (Criteria) this;
        }

        public Criteria andRelationNo1Between(Integer value1, Integer value2) {
            addCriterion("relation_no1 between", value1, value2, "relationNo1");
            return (Criteria) this;
        }

        public Criteria andRelationNo1NotBetween(Integer value1, Integer value2) {
            addCriterion("relation_no1 not between", value1, value2, "relationNo1");
            return (Criteria) this;
        }

        public Criteria andMetier1IsNull() {
            addCriterion("metier1 is null");
            return (Criteria) this;
        }

        public Criteria andMetier1IsNotNull() {
            addCriterion("metier1 is not null");
            return (Criteria) this;
        }

        public Criteria andMetier1EqualTo(String value) {
            addCriterion("metier1 =", value, "metier1");
            return (Criteria) this;
        }

        public Criteria andMetier1NotEqualTo(String value) {
            addCriterion("metier1 <>", value, "metier1");
            return (Criteria) this;
        }

        public Criteria andMetier1GreaterThan(String value) {
            addCriterion("metier1 >", value, "metier1");
            return (Criteria) this;
        }

        public Criteria andMetier1GreaterThanOrEqualTo(String value) {
            addCriterion("metier1 >=", value, "metier1");
            return (Criteria) this;
        }

        public Criteria andMetier1LessThan(String value) {
            addCriterion("metier1 <", value, "metier1");
            return (Criteria) this;
        }

        public Criteria andMetier1LessThanOrEqualTo(String value) {
            addCriterion("metier1 <=", value, "metier1");
            return (Criteria) this;
        }

        public Criteria andMetier1Like(String value) {
            addCriterion("metier1 like", value, "metier1");
            return (Criteria) this;
        }

        public Criteria andMetier1NotLike(String value) {
            addCriterion("metier1 not like", value, "metier1");
            return (Criteria) this;
        }

        public Criteria andMetier1In(List<String> values) {
            addCriterion("metier1 in", values, "metier1");
            return (Criteria) this;
        }

        public Criteria andMetier1NotIn(List<String> values) {
            addCriterion("metier1 not in", values, "metier1");
            return (Criteria) this;
        }

        public Criteria andMetier1Between(String value1, String value2) {
            addCriterion("metier1 between", value1, value2, "metier1");
            return (Criteria) this;
        }

        public Criteria andMetier1NotBetween(String value1, String value2) {
            addCriterion("metier1 not between", value1, value2, "metier1");
            return (Criteria) this;
        }

        public Criteria andName2IsNull() {
            addCriterion("name2 is null");
            return (Criteria) this;
        }

        public Criteria andName2IsNotNull() {
            addCriterion("name2 is not null");
            return (Criteria) this;
        }

        public Criteria andName2EqualTo(String value) {
            addCriterion("name2 =", value, "name2");
            return (Criteria) this;
        }

        public Criteria andName2NotEqualTo(String value) {
            addCriterion("name2 <>", value, "name2");
            return (Criteria) this;
        }

        public Criteria andName2GreaterThan(String value) {
            addCriterion("name2 >", value, "name2");
            return (Criteria) this;
        }

        public Criteria andName2GreaterThanOrEqualTo(String value) {
            addCriterion("name2 >=", value, "name2");
            return (Criteria) this;
        }

        public Criteria andName2LessThan(String value) {
            addCriterion("name2 <", value, "name2");
            return (Criteria) this;
        }

        public Criteria andName2LessThanOrEqualTo(String value) {
            addCriterion("name2 <=", value, "name2");
            return (Criteria) this;
        }

        public Criteria andName2Like(String value) {
            addCriterion("name2 like", value, "name2");
            return (Criteria) this;
        }

        public Criteria andName2NotLike(String value) {
            addCriterion("name2 not like", value, "name2");
            return (Criteria) this;
        }

        public Criteria andName2In(List<String> values) {
            addCriterion("name2 in", values, "name2");
            return (Criteria) this;
        }

        public Criteria andName2NotIn(List<String> values) {
            addCriterion("name2 not in", values, "name2");
            return (Criteria) this;
        }

        public Criteria andName2Between(String value1, String value2) {
            addCriterion("name2 between", value1, value2, "name2");
            return (Criteria) this;
        }

        public Criteria andName2NotBetween(String value1, String value2) {
            addCriterion("name2 not between", value1, value2, "name2");
            return (Criteria) this;
        }

        public Criteria andPhone2IsNull() {
            addCriterion("phone2 is null");
            return (Criteria) this;
        }

        public Criteria andPhone2IsNotNull() {
            addCriterion("phone2 is not null");
            return (Criteria) this;
        }

        public Criteria andPhone2EqualTo(String value) {
            addCriterion("phone2 =", value, "phone2");
            return (Criteria) this;
        }

        public Criteria andPhone2NotEqualTo(String value) {
            addCriterion("phone2 <>", value, "phone2");
            return (Criteria) this;
        }

        public Criteria andPhone2GreaterThan(String value) {
            addCriterion("phone2 >", value, "phone2");
            return (Criteria) this;
        }

        public Criteria andPhone2GreaterThanOrEqualTo(String value) {
            addCriterion("phone2 >=", value, "phone2");
            return (Criteria) this;
        }

        public Criteria andPhone2LessThan(String value) {
            addCriterion("phone2 <", value, "phone2");
            return (Criteria) this;
        }

        public Criteria andPhone2LessThanOrEqualTo(String value) {
            addCriterion("phone2 <=", value, "phone2");
            return (Criteria) this;
        }

        public Criteria andPhone2Like(String value) {
            addCriterion("phone2 like", value, "phone2");
            return (Criteria) this;
        }

        public Criteria andPhone2NotLike(String value) {
            addCriterion("phone2 not like", value, "phone2");
            return (Criteria) this;
        }

        public Criteria andPhone2In(List<String> values) {
            addCriterion("phone2 in", values, "phone2");
            return (Criteria) this;
        }

        public Criteria andPhone2NotIn(List<String> values) {
            addCriterion("phone2 not in", values, "phone2");
            return (Criteria) this;
        }

        public Criteria andPhone2Between(String value1, String value2) {
            addCriterion("phone2 between", value1, value2, "phone2");
            return (Criteria) this;
        }

        public Criteria andPhone2NotBetween(String value1, String value2) {
            addCriterion("phone2 not between", value1, value2, "phone2");
            return (Criteria) this;
        }

        public Criteria andRelation2IsNull() {
            addCriterion("relation2 is null");
            return (Criteria) this;
        }

        public Criteria andRelation2IsNotNull() {
            addCriterion("relation2 is not null");
            return (Criteria) this;
        }

        public Criteria andRelation2EqualTo(String value) {
            addCriterion("relation2 =", value, "relation2");
            return (Criteria) this;
        }

        public Criteria andRelation2NotEqualTo(String value) {
            addCriterion("relation2 <>", value, "relation2");
            return (Criteria) this;
        }

        public Criteria andRelation2GreaterThan(String value) {
            addCriterion("relation2 >", value, "relation2");
            return (Criteria) this;
        }

        public Criteria andRelation2GreaterThanOrEqualTo(String value) {
            addCriterion("relation2 >=", value, "relation2");
            return (Criteria) this;
        }

        public Criteria andRelation2LessThan(String value) {
            addCriterion("relation2 <", value, "relation2");
            return (Criteria) this;
        }

        public Criteria andRelation2LessThanOrEqualTo(String value) {
            addCriterion("relation2 <=", value, "relation2");
            return (Criteria) this;
        }

        public Criteria andRelation2Like(String value) {
            addCriterion("relation2 like", value, "relation2");
            return (Criteria) this;
        }

        public Criteria andRelation2NotLike(String value) {
            addCriterion("relation2 not like", value, "relation2");
            return (Criteria) this;
        }

        public Criteria andRelation2In(List<String> values) {
            addCriterion("relation2 in", values, "relation2");
            return (Criteria) this;
        }

        public Criteria andRelation2NotIn(List<String> values) {
            addCriterion("relation2 not in", values, "relation2");
            return (Criteria) this;
        }

        public Criteria andRelation2Between(String value1, String value2) {
            addCriterion("relation2 between", value1, value2, "relation2");
            return (Criteria) this;
        }

        public Criteria andRelation2NotBetween(String value1, String value2) {
            addCriterion("relation2 not between", value1, value2, "relation2");
            return (Criteria) this;
        }

        public Criteria andRelationNo2IsNull() {
            addCriterion("relation_no2 is null");
            return (Criteria) this;
        }

        public Criteria andRelationNo2IsNotNull() {
            addCriterion("relation_no2 is not null");
            return (Criteria) this;
        }

        public Criteria andRelationNo2EqualTo(Integer value) {
            addCriterion("relation_no2 =", value, "relationNo2");
            return (Criteria) this;
        }

        public Criteria andRelationNo2NotEqualTo(Integer value) {
            addCriterion("relation_no2 <>", value, "relationNo2");
            return (Criteria) this;
        }

        public Criteria andRelationNo2GreaterThan(Integer value) {
            addCriterion("relation_no2 >", value, "relationNo2");
            return (Criteria) this;
        }

        public Criteria andRelationNo2GreaterThanOrEqualTo(Integer value) {
            addCriterion("relation_no2 >=", value, "relationNo2");
            return (Criteria) this;
        }

        public Criteria andRelationNo2LessThan(Integer value) {
            addCriterion("relation_no2 <", value, "relationNo2");
            return (Criteria) this;
        }

        public Criteria andRelationNo2LessThanOrEqualTo(Integer value) {
            addCriterion("relation_no2 <=", value, "relationNo2");
            return (Criteria) this;
        }

        public Criteria andRelationNo2In(List<Integer> values) {
            addCriterion("relation_no2 in", values, "relationNo2");
            return (Criteria) this;
        }

        public Criteria andRelationNo2NotIn(List<Integer> values) {
            addCriterion("relation_no2 not in", values, "relationNo2");
            return (Criteria) this;
        }

        public Criteria andRelationNo2Between(Integer value1, Integer value2) {
            addCriterion("relation_no2 between", value1, value2, "relationNo2");
            return (Criteria) this;
        }

        public Criteria andRelationNo2NotBetween(Integer value1, Integer value2) {
            addCriterion("relation_no2 not between", value1, value2, "relationNo2");
            return (Criteria) this;
        }

        public Criteria andMetier2IsNull() {
            addCriterion("metier2 is null");
            return (Criteria) this;
        }

        public Criteria andMetier2IsNotNull() {
            addCriterion("metier2 is not null");
            return (Criteria) this;
        }

        public Criteria andMetier2EqualTo(String value) {
            addCriterion("metier2 =", value, "metier2");
            return (Criteria) this;
        }

        public Criteria andMetier2NotEqualTo(String value) {
            addCriterion("metier2 <>", value, "metier2");
            return (Criteria) this;
        }

        public Criteria andMetier2GreaterThan(String value) {
            addCriterion("metier2 >", value, "metier2");
            return (Criteria) this;
        }

        public Criteria andMetier2GreaterThanOrEqualTo(String value) {
            addCriterion("metier2 >=", value, "metier2");
            return (Criteria) this;
        }

        public Criteria andMetier2LessThan(String value) {
            addCriterion("metier2 <", value, "metier2");
            return (Criteria) this;
        }

        public Criteria andMetier2LessThanOrEqualTo(String value) {
            addCriterion("metier2 <=", value, "metier2");
            return (Criteria) this;
        }

        public Criteria andMetier2Like(String value) {
            addCriterion("metier2 like", value, "metier2");
            return (Criteria) this;
        }

        public Criteria andMetier2NotLike(String value) {
            addCriterion("metier2 not like", value, "metier2");
            return (Criteria) this;
        }

        public Criteria andMetier2In(List<String> values) {
            addCriterion("metier2 in", values, "metier2");
            return (Criteria) this;
        }

        public Criteria andMetier2NotIn(List<String> values) {
            addCriterion("metier2 not in", values, "metier2");
            return (Criteria) this;
        }

        public Criteria andMetier2Between(String value1, String value2) {
            addCriterion("metier2 between", value1, value2, "metier2");
            return (Criteria) this;
        }

        public Criteria andMetier2NotBetween(String value1, String value2) {
            addCriterion("metier2 not between", value1, value2, "metier2");
            return (Criteria) this;
        }

        public Criteria andAccountBalanceIsNull() {
            addCriterion("account_balance is null");
            return (Criteria) this;
        }

        public Criteria andAccountBalanceIsNotNull() {
            addCriterion("account_balance is not null");
            return (Criteria) this;
        }

        public Criteria andAccountBalanceEqualTo(Double value) {
            addCriterion("account_balance =", value, "accountBalance");
            return (Criteria) this;
        }

        public Criteria andAccountBalanceNotEqualTo(Double value) {
            addCriterion("account_balance <>", value, "accountBalance");
            return (Criteria) this;
        }

        public Criteria andAccountBalanceGreaterThan(Double value) {
            addCriterion("account_balance >", value, "accountBalance");
            return (Criteria) this;
        }

        public Criteria andAccountBalanceGreaterThanOrEqualTo(Double value) {
            addCriterion("account_balance >=", value, "accountBalance");
            return (Criteria) this;
        }

        public Criteria andAccountBalanceLessThan(Double value) {
            addCriterion("account_balance <", value, "accountBalance");
            return (Criteria) this;
        }

        public Criteria andAccountBalanceLessThanOrEqualTo(Double value) {
            addCriterion("account_balance <=", value, "accountBalance");
            return (Criteria) this;
        }

        public Criteria andAccountBalanceIn(List<Double> values) {
            addCriterion("account_balance in", values, "accountBalance");
            return (Criteria) this;
        }

        public Criteria andAccountBalanceNotIn(List<Double> values) {
            addCriterion("account_balance not in", values, "accountBalance");
            return (Criteria) this;
        }

        public Criteria andAccountBalanceBetween(Double value1, Double value2) {
            addCriterion("account_balance between", value1, value2, "accountBalance");
            return (Criteria) this;
        }

        public Criteria andAccountBalanceNotBetween(Double value1, Double value2) {
            addCriterion("account_balance not between", value1, value2, "accountBalance");
            return (Criteria) this;
        }

        public Criteria andDiscountPptIsNull() {
            addCriterion("discount_ppt is null");
            return (Criteria) this;
        }

        public Criteria andDiscountPptIsNotNull() {
            addCriterion("discount_ppt is not null");
            return (Criteria) this;
        }

        public Criteria andDiscountPptEqualTo(Double value) {
            addCriterion("discount_ppt =", value, "discountPpt");
            return (Criteria) this;
        }

        public Criteria andDiscountPptNotEqualTo(Double value) {
            addCriterion("discount_ppt <>", value, "discountPpt");
            return (Criteria) this;
        }

        public Criteria andDiscountPptGreaterThan(Double value) {
            addCriterion("discount_ppt >", value, "discountPpt");
            return (Criteria) this;
        }

        public Criteria andDiscountPptGreaterThanOrEqualTo(Double value) {
            addCriterion("discount_ppt >=", value, "discountPpt");
            return (Criteria) this;
        }

        public Criteria andDiscountPptLessThan(Double value) {
            addCriterion("discount_ppt <", value, "discountPpt");
            return (Criteria) this;
        }

        public Criteria andDiscountPptLessThanOrEqualTo(Double value) {
            addCriterion("discount_ppt <=", value, "discountPpt");
            return (Criteria) this;
        }

        public Criteria andDiscountPptIn(List<Double> values) {
            addCriterion("discount_ppt in", values, "discountPpt");
            return (Criteria) this;
        }

        public Criteria andDiscountPptNotIn(List<Double> values) {
            addCriterion("discount_ppt not in", values, "discountPpt");
            return (Criteria) this;
        }

        public Criteria andDiscountPptBetween(Double value1, Double value2) {
            addCriterion("discount_ppt between", value1, value2, "discountPpt");
            return (Criteria) this;
        }

        public Criteria andDiscountPptNotBetween(Double value1, Double value2) {
            addCriterion("discount_ppt not between", value1, value2, "discountPpt");
            return (Criteria) this;
        }

        public Criteria andDiscountTypeIsNull() {
            addCriterion("discount_type is null");
            return (Criteria) this;
        }

        public Criteria andDiscountTypeIsNotNull() {
            addCriterion("discount_type is not null");
            return (Criteria) this;
        }

        public Criteria andDiscountTypeEqualTo(String value) {
            addCriterion("discount_type =", value, "discountType");
            return (Criteria) this;
        }

        public Criteria andDiscountTypeNotEqualTo(String value) {
            addCriterion("discount_type <>", value, "discountType");
            return (Criteria) this;
        }

        public Criteria andDiscountTypeGreaterThan(String value) {
            addCriterion("discount_type >", value, "discountType");
            return (Criteria) this;
        }

        public Criteria andDiscountTypeGreaterThanOrEqualTo(String value) {
            addCriterion("discount_type >=", value, "discountType");
            return (Criteria) this;
        }

        public Criteria andDiscountTypeLessThan(String value) {
            addCriterion("discount_type <", value, "discountType");
            return (Criteria) this;
        }

        public Criteria andDiscountTypeLessThanOrEqualTo(String value) {
            addCriterion("discount_type <=", value, "discountType");
            return (Criteria) this;
        }

        public Criteria andDiscountTypeLike(String value) {
            addCriterion("discount_type like", value, "discountType");
            return (Criteria) this;
        }

        public Criteria andDiscountTypeNotLike(String value) {
            addCriterion("discount_type not like", value, "discountType");
            return (Criteria) this;
        }

        public Criteria andDiscountTypeIn(List<String> values) {
            addCriterion("discount_type in", values, "discountType");
            return (Criteria) this;
        }

        public Criteria andDiscountTypeNotIn(List<String> values) {
            addCriterion("discount_type not in", values, "discountType");
            return (Criteria) this;
        }

        public Criteria andDiscountTypeBetween(String value1, String value2) {
            addCriterion("discount_type between", value1, value2, "discountType");
            return (Criteria) this;
        }

        public Criteria andDiscountTypeNotBetween(String value1, String value2) {
            addCriterion("discount_type not between", value1, value2, "discountType");
            return (Criteria) this;
        }

        public Criteria andDiscountTypeIdIsNull() {
            addCriterion("discount_type_id is null");
            return (Criteria) this;
        }

        public Criteria andDiscountTypeIdIsNotNull() {
            addCriterion("discount_type_id is not null");
            return (Criteria) this;
        }

        public Criteria andDiscountTypeIdEqualTo(String value) {
            addCriterion("discount_type_id =", value, "discountTypeId");
            return (Criteria) this;
        }

        public Criteria andDiscountTypeIdNotEqualTo(String value) {
            addCriterion("discount_type_id <>", value, "discountTypeId");
            return (Criteria) this;
        }

        public Criteria andDiscountTypeIdGreaterThan(String value) {
            addCriterion("discount_type_id >", value, "discountTypeId");
            return (Criteria) this;
        }

        public Criteria andDiscountTypeIdGreaterThanOrEqualTo(String value) {
            addCriterion("discount_type_id >=", value, "discountTypeId");
            return (Criteria) this;
        }

        public Criteria andDiscountTypeIdLessThan(String value) {
            addCriterion("discount_type_id <", value, "discountTypeId");
            return (Criteria) this;
        }

        public Criteria andDiscountTypeIdLessThanOrEqualTo(String value) {
            addCriterion("discount_type_id <=", value, "discountTypeId");
            return (Criteria) this;
        }

        public Criteria andDiscountTypeIdLike(String value) {
            addCriterion("discount_type_id like", value, "discountTypeId");
            return (Criteria) this;
        }

        public Criteria andDiscountTypeIdNotLike(String value) {
            addCriterion("discount_type_id not like", value, "discountTypeId");
            return (Criteria) this;
        }

        public Criteria andDiscountTypeIdIn(List<String> values) {
            addCriterion("discount_type_id in", values, "discountTypeId");
            return (Criteria) this;
        }

        public Criteria andDiscountTypeIdNotIn(List<String> values) {
            addCriterion("discount_type_id not in", values, "discountTypeId");
            return (Criteria) this;
        }

        public Criteria andDiscountTypeIdBetween(String value1, String value2) {
            addCriterion("discount_type_id between", value1, value2, "discountTypeId");
            return (Criteria) this;
        }

        public Criteria andDiscountTypeIdNotBetween(String value1, String value2) {
            addCriterion("discount_type_id not between", value1, value2, "discountTypeId");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNull() {
            addCriterion("update_time is null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNotNull() {
            addCriterion("update_time is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeEqualTo(Date value) {
            addCriterion("update_time =", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotEqualTo(Date value) {
            addCriterion("update_time <>", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThan(Date value) {
            addCriterion("update_time >", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("update_time >=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThan(Date value) {
            addCriterion("update_time <", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThanOrEqualTo(Date value) {
            addCriterion("update_time <=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIn(List<Date> values) {
            addCriterion("update_time in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotIn(List<Date> values) {
            addCriterion("update_time not in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeBetween(Date value1, Date value2) {
            addCriterion("update_time between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotBetween(Date value1, Date value2) {
            addCriterion("update_time not between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andInsertTimeIsNull() {
            addCriterion("insert_time is null");
            return (Criteria) this;
        }

        public Criteria andInsertTimeIsNotNull() {
            addCriterion("insert_time is not null");
            return (Criteria) this;
        }

        public Criteria andInsertTimeEqualTo(Date value) {
            addCriterion("insert_time =", value, "insertTime");
            return (Criteria) this;
        }

        public Criteria andInsertTimeNotEqualTo(Date value) {
            addCriterion("insert_time <>", value, "insertTime");
            return (Criteria) this;
        }

        public Criteria andInsertTimeGreaterThan(Date value) {
            addCriterion("insert_time >", value, "insertTime");
            return (Criteria) this;
        }

        public Criteria andInsertTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("insert_time >=", value, "insertTime");
            return (Criteria) this;
        }

        public Criteria andInsertTimeLessThan(Date value) {
            addCriterion("insert_time <", value, "insertTime");
            return (Criteria) this;
        }

        public Criteria andInsertTimeLessThanOrEqualTo(Date value) {
            addCriterion("insert_time <=", value, "insertTime");
            return (Criteria) this;
        }

        public Criteria andInsertTimeIn(List<Date> values) {
            addCriterion("insert_time in", values, "insertTime");
            return (Criteria) this;
        }

        public Criteria andInsertTimeNotIn(List<Date> values) {
            addCriterion("insert_time not in", values, "insertTime");
            return (Criteria) this;
        }

        public Criteria andInsertTimeBetween(Date value1, Date value2) {
            addCriterion("insert_time between", value1, value2, "insertTime");
            return (Criteria) this;
        }

        public Criteria andInsertTimeNotBetween(Date value1, Date value2) {
            addCriterion("insert_time not between", value1, value2, "insertTime");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdIsNull() {
            addCriterion("create_user_id is null");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdIsNotNull() {
            addCriterion("create_user_id is not null");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdEqualTo(String value) {
            addCriterion("create_user_id =", value, "createUserId");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdNotEqualTo(String value) {
            addCriterion("create_user_id <>", value, "createUserId");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdGreaterThan(String value) {
            addCriterion("create_user_id >", value, "createUserId");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdGreaterThanOrEqualTo(String value) {
            addCriterion("create_user_id >=", value, "createUserId");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdLessThan(String value) {
            addCriterion("create_user_id <", value, "createUserId");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdLessThanOrEqualTo(String value) {
            addCriterion("create_user_id <=", value, "createUserId");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdLike(String value) {
            addCriterion("create_user_id like", value, "createUserId");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdNotLike(String value) {
            addCriterion("create_user_id not like", value, "createUserId");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdIn(List<String> values) {
            addCriterion("create_user_id in", values, "createUserId");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdNotIn(List<String> values) {
            addCriterion("create_user_id not in", values, "createUserId");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdBetween(String value1, String value2) {
            addCriterion("create_user_id between", value1, value2, "createUserId");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdNotBetween(String value1, String value2) {
            addCriterion("create_user_id not between", value1, value2, "createUserId");
            return (Criteria) this;
        }

        public Criteria andCreateUserNameIsNull() {
            addCriterion("create_user_name is null");
            return (Criteria) this;
        }

        public Criteria andCreateUserNameIsNotNull() {
            addCriterion("create_user_name is not null");
            return (Criteria) this;
        }

        public Criteria andCreateUserNameEqualTo(String value) {
            addCriterion("create_user_name =", value, "createUserName");
            return (Criteria) this;
        }

        public Criteria andCreateUserNameNotEqualTo(String value) {
            addCriterion("create_user_name <>", value, "createUserName");
            return (Criteria) this;
        }

        public Criteria andCreateUserNameGreaterThan(String value) {
            addCriterion("create_user_name >", value, "createUserName");
            return (Criteria) this;
        }

        public Criteria andCreateUserNameGreaterThanOrEqualTo(String value) {
            addCriterion("create_user_name >=", value, "createUserName");
            return (Criteria) this;
        }

        public Criteria andCreateUserNameLessThan(String value) {
            addCriterion("create_user_name <", value, "createUserName");
            return (Criteria) this;
        }

        public Criteria andCreateUserNameLessThanOrEqualTo(String value) {
            addCriterion("create_user_name <=", value, "createUserName");
            return (Criteria) this;
        }

        public Criteria andCreateUserNameLike(String value) {
            addCriterion("create_user_name like", value, "createUserName");
            return (Criteria) this;
        }

        public Criteria andCreateUserNameNotLike(String value) {
            addCriterion("create_user_name not like", value, "createUserName");
            return (Criteria) this;
        }

        public Criteria andCreateUserNameIn(List<String> values) {
            addCriterion("create_user_name in", values, "createUserName");
            return (Criteria) this;
        }

        public Criteria andCreateUserNameNotIn(List<String> values) {
            addCriterion("create_user_name not in", values, "createUserName");
            return (Criteria) this;
        }

        public Criteria andCreateUserNameBetween(String value1, String value2) {
            addCriterion("create_user_name between", value1, value2, "createUserName");
            return (Criteria) this;
        }

        public Criteria andCreateUserNameNotBetween(String value1, String value2) {
            addCriterion("create_user_name not between", value1, value2, "createUserName");
            return (Criteria) this;
        }

        public Criteria andDelBooleanIsNull() {
            addCriterion("del_boolean is null");
            return (Criteria) this;
        }

        public Criteria andDelBooleanIsNotNull() {
            addCriterion("del_boolean is not null");
            return (Criteria) this;
        }

        public Criteria andDelBooleanEqualTo(String value) {
            addCriterion("del_boolean =", value, "delBoolean");
            return (Criteria) this;
        }

        public Criteria andDelBooleanNotEqualTo(String value) {
            addCriterion("del_boolean <>", value, "delBoolean");
            return (Criteria) this;
        }

        public Criteria andDelBooleanGreaterThan(String value) {
            addCriterion("del_boolean >", value, "delBoolean");
            return (Criteria) this;
        }

        public Criteria andDelBooleanGreaterThanOrEqualTo(String value) {
            addCriterion("del_boolean >=", value, "delBoolean");
            return (Criteria) this;
        }

        public Criteria andDelBooleanLessThan(String value) {
            addCriterion("del_boolean <", value, "delBoolean");
            return (Criteria) this;
        }

        public Criteria andDelBooleanLessThanOrEqualTo(String value) {
            addCriterion("del_boolean <=", value, "delBoolean");
            return (Criteria) this;
        }

        public Criteria andDelBooleanLike(String value) {
            addCriterion("del_boolean like", value, "delBoolean");
            return (Criteria) this;
        }

        public Criteria andDelBooleanNotLike(String value) {
            addCriterion("del_boolean not like", value, "delBoolean");
            return (Criteria) this;
        }

        public Criteria andDelBooleanIn(List<String> values) {
            addCriterion("del_boolean in", values, "delBoolean");
            return (Criteria) this;
        }

        public Criteria andDelBooleanNotIn(List<String> values) {
            addCriterion("del_boolean not in", values, "delBoolean");
            return (Criteria) this;
        }

        public Criteria andDelBooleanBetween(String value1, String value2) {
            addCriterion("del_boolean between", value1, value2, "delBoolean");
            return (Criteria) this;
        }

        public Criteria andDelBooleanNotBetween(String value1, String value2) {
            addCriterion("del_boolean not between", value1, value2, "delBoolean");
            return (Criteria) this;
        }

        public Criteria andStateIsNull() {
            addCriterion("state is null");
            return (Criteria) this;
        }

        public Criteria andStateIsNotNull() {
            addCriterion("state is not null");
            return (Criteria) this;
        }

        public Criteria andStateEqualTo(Integer value) {
            addCriterion("state =", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotEqualTo(Integer value) {
            addCriterion("state <>", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThan(Integer value) {
            addCriterion("state >", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThanOrEqualTo(Integer value) {
            addCriterion("state >=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThan(Integer value) {
            addCriterion("state <", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThanOrEqualTo(Integer value) {
            addCriterion("state <=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateIn(List<Integer> values) {
            addCriterion("state in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotIn(List<Integer> values) {
            addCriterion("state not in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateBetween(Integer value1, Integer value2) {
            addCriterion("state between", value1, value2, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotBetween(Integer value1, Integer value2) {
            addCriterion("state not between", value1, value2, "state");
            return (Criteria) this;
        }

        public Criteria andVersionIsNull() {
            addCriterion("version is null");
            return (Criteria) this;
        }

        public Criteria andVersionIsNotNull() {
            addCriterion("version is not null");
            return (Criteria) this;
        }

        public Criteria andVersionEqualTo(Long value) {
            addCriterion("version =", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionNotEqualTo(Long value) {
            addCriterion("version <>", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionGreaterThan(Long value) {
            addCriterion("version >", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionGreaterThanOrEqualTo(Long value) {
            addCriterion("version >=", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionLessThan(Long value) {
            addCriterion("version <", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionLessThanOrEqualTo(Long value) {
            addCriterion("version <=", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionIn(List<Long> values) {
            addCriterion("version in", values, "version");
            return (Criteria) this;
        }

        public Criteria andVersionNotIn(List<Long> values) {
            addCriterion("version not in", values, "version");
            return (Criteria) this;
        }

        public Criteria andVersionBetween(Long value1, Long value2) {
            addCriterion("version between", value1, value2, "version");
            return (Criteria) this;
        }

        public Criteria andVersionNotBetween(Long value1, Long value2) {
            addCriterion("version not between", value1, value2, "version");
            return (Criteria) this;
        }

        public Criteria andCopyVersionIsNull() {
            addCriterion("copy_version is null");
            return (Criteria) this;
        }

        public Criteria andCopyVersionIsNotNull() {
            addCriterion("copy_version is not null");
            return (Criteria) this;
        }

        public Criteria andCopyVersionEqualTo(Long value) {
            addCriterion("copy_version =", value, "copyVersion");
            return (Criteria) this;
        }

        public Criteria andCopyVersionNotEqualTo(Long value) {
            addCriterion("copy_version <>", value, "copyVersion");
            return (Criteria) this;
        }

        public Criteria andCopyVersionGreaterThan(Long value) {
            addCriterion("copy_version >", value, "copyVersion");
            return (Criteria) this;
        }

        public Criteria andCopyVersionGreaterThanOrEqualTo(Long value) {
            addCriterion("copy_version >=", value, "copyVersion");
            return (Criteria) this;
        }

        public Criteria andCopyVersionLessThan(Long value) {
            addCriterion("copy_version <", value, "copyVersion");
            return (Criteria) this;
        }

        public Criteria andCopyVersionLessThanOrEqualTo(Long value) {
            addCriterion("copy_version <=", value, "copyVersion");
            return (Criteria) this;
        }

        public Criteria andCopyVersionIn(List<Long> values) {
            addCriterion("copy_version in", values, "copyVersion");
            return (Criteria) this;
        }

        public Criteria andCopyVersionNotIn(List<Long> values) {
            addCriterion("copy_version not in", values, "copyVersion");
            return (Criteria) this;
        }

        public Criteria andCopyVersionBetween(Long value1, Long value2) {
            addCriterion("copy_version between", value1, value2, "copyVersion");
            return (Criteria) this;
        }

        public Criteria andCopyVersionNotBetween(Long value1, Long value2) {
            addCriterion("copy_version not between", value1, value2, "copyVersion");
            return (Criteria) this;
        }

        public Criteria andCopyTimeIsNull() {
            addCriterion("copy_time is null");
            return (Criteria) this;
        }

        public Criteria andCopyTimeIsNotNull() {
            addCriterion("copy_time is not null");
            return (Criteria) this;
        }

        public Criteria andCopyTimeEqualTo(Date value) {
            addCriterion("copy_time =", value, "copyTime");
            return (Criteria) this;
        }

        public Criteria andCopyTimeNotEqualTo(Date value) {
            addCriterion("copy_time <>", value, "copyTime");
            return (Criteria) this;
        }

        public Criteria andCopyTimeGreaterThan(Date value) {
            addCriterion("copy_time >", value, "copyTime");
            return (Criteria) this;
        }

        public Criteria andCopyTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("copy_time >=", value, "copyTime");
            return (Criteria) this;
        }

        public Criteria andCopyTimeLessThan(Date value) {
            addCriterion("copy_time <", value, "copyTime");
            return (Criteria) this;
        }

        public Criteria andCopyTimeLessThanOrEqualTo(Date value) {
            addCriterion("copy_time <=", value, "copyTime");
            return (Criteria) this;
        }

        public Criteria andCopyTimeIn(List<Date> values) {
            addCriterion("copy_time in", values, "copyTime");
            return (Criteria) this;
        }

        public Criteria andCopyTimeNotIn(List<Date> values) {
            addCriterion("copy_time not in", values, "copyTime");
            return (Criteria) this;
        }

        public Criteria andCopyTimeBetween(Date value1, Date value2) {
            addCriterion("copy_time between", value1, value2, "copyTime");
            return (Criteria) this;
        }

        public Criteria andCopyTimeNotBetween(Date value1, Date value2) {
            addCriterion("copy_time not between", value1, value2, "copyTime");
            return (Criteria) this;
        }

        public Criteria andLogicStateIsNull() {
            addCriterion("logic_state is null");
            return (Criteria) this;
        }

        public Criteria andLogicStateIsNotNull() {
            addCriterion("logic_state is not null");
            return (Criteria) this;
        }

        public Criteria andLogicStateEqualTo(Integer value) {
            addCriterion("logic_state =", value, "logicState");
            return (Criteria) this;
        }

        public Criteria andLogicStateNotEqualTo(Integer value) {
            addCriterion("logic_state <>", value, "logicState");
            return (Criteria) this;
        }

        public Criteria andLogicStateGreaterThan(Integer value) {
            addCriterion("logic_state >", value, "logicState");
            return (Criteria) this;
        }

        public Criteria andLogicStateGreaterThanOrEqualTo(Integer value) {
            addCriterion("logic_state >=", value, "logicState");
            return (Criteria) this;
        }

        public Criteria andLogicStateLessThan(Integer value) {
            addCriterion("logic_state <", value, "logicState");
            return (Criteria) this;
        }

        public Criteria andLogicStateLessThanOrEqualTo(Integer value) {
            addCriterion("logic_state <=", value, "logicState");
            return (Criteria) this;
        }

        public Criteria andLogicStateIn(List<Integer> values) {
            addCriterion("logic_state in", values, "logicState");
            return (Criteria) this;
        }

        public Criteria andLogicStateNotIn(List<Integer> values) {
            addCriterion("logic_state not in", values, "logicState");
            return (Criteria) this;
        }

        public Criteria andLogicStateBetween(Integer value1, Integer value2) {
            addCriterion("logic_state between", value1, value2, "logicState");
            return (Criteria) this;
        }

        public Criteria andLogicStateNotBetween(Integer value1, Integer value2) {
            addCriterion("logic_state not between", value1, value2, "logicState");
            return (Criteria) this;
        }

        public Criteria andEndClassTimeIsNull() {
            addCriterion("end_class_time is null");
            return (Criteria) this;
        }

        public Criteria andEndClassTimeIsNotNull() {
            addCriterion("end_class_time is not null");
            return (Criteria) this;
        }

        public Criteria andEndClassTimeEqualTo(Date value) {
            addCriterion("end_class_time =", value, "endClassTime");
            return (Criteria) this;
        }

        public Criteria andEndClassTimeNotEqualTo(Date value) {
            addCriterion("end_class_time <>", value, "endClassTime");
            return (Criteria) this;
        }

        public Criteria andEndClassTimeGreaterThan(Date value) {
            addCriterion("end_class_time >", value, "endClassTime");
            return (Criteria) this;
        }

        public Criteria andEndClassTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("end_class_time >=", value, "endClassTime");
            return (Criteria) this;
        }

        public Criteria andEndClassTimeLessThan(Date value) {
            addCriterion("end_class_time <", value, "endClassTime");
            return (Criteria) this;
        }

        public Criteria andEndClassTimeLessThanOrEqualTo(Date value) {
            addCriterion("end_class_time <=", value, "endClassTime");
            return (Criteria) this;
        }

        public Criteria andEndClassTimeIn(List<Date> values) {
            addCriterion("end_class_time in", values, "endClassTime");
            return (Criteria) this;
        }

        public Criteria andEndClassTimeNotIn(List<Date> values) {
            addCriterion("end_class_time not in", values, "endClassTime");
            return (Criteria) this;
        }

        public Criteria andEndClassTimeBetween(Date value1, Date value2) {
            addCriterion("end_class_time between", value1, value2, "endClassTime");
            return (Criteria) this;
        }

        public Criteria andEndClassTimeNotBetween(Date value1, Date value2) {
            addCriterion("end_class_time not between", value1, value2, "endClassTime");
            return (Criteria) this;
        }

        public Criteria andMemberBooleanIsNull() {
            addCriterion("member_boolean is null");
            return (Criteria) this;
        }

        public Criteria andMemberBooleanIsNotNull() {
            addCriterion("member_boolean is not null");
            return (Criteria) this;
        }

        public Criteria andMemberBooleanEqualTo(Integer value) {
            addCriterion("member_boolean =", value, "memberBoolean");
            return (Criteria) this;
        }

        public Criteria andMemberBooleanNotEqualTo(Integer value) {
            addCriterion("member_boolean <>", value, "memberBoolean");
            return (Criteria) this;
        }

        public Criteria andMemberBooleanGreaterThan(Integer value) {
            addCriterion("member_boolean >", value, "memberBoolean");
            return (Criteria) this;
        }

        public Criteria andMemberBooleanGreaterThanOrEqualTo(Integer value) {
            addCriterion("member_boolean >=", value, "memberBoolean");
            return (Criteria) this;
        }

        public Criteria andMemberBooleanLessThan(Integer value) {
            addCriterion("member_boolean <", value, "memberBoolean");
            return (Criteria) this;
        }

        public Criteria andMemberBooleanLessThanOrEqualTo(Integer value) {
            addCriterion("member_boolean <=", value, "memberBoolean");
            return (Criteria) this;
        }

        public Criteria andMemberBooleanIn(List<Integer> values) {
            addCriterion("member_boolean in", values, "memberBoolean");
            return (Criteria) this;
        }

        public Criteria andMemberBooleanNotIn(List<Integer> values) {
            addCriterion("member_boolean not in", values, "memberBoolean");
            return (Criteria) this;
        }

        public Criteria andMemberBooleanBetween(Integer value1, Integer value2) {
            addCriterion("member_boolean between", value1, value2, "memberBoolean");
            return (Criteria) this;
        }

        public Criteria andMemberBooleanNotBetween(Integer value1, Integer value2) {
            addCriterion("member_boolean not between", value1, value2, "memberBoolean");
            return (Criteria) this;
        }

        public Criteria andMemberNoIsNull() {
            addCriterion("member_no is null");
            return (Criteria) this;
        }

        public Criteria andMemberNoIsNotNull() {
            addCriterion("member_no is not null");
            return (Criteria) this;
        }

        public Criteria andMemberNoEqualTo(String value) {
            addCriterion("member_no =", value, "memberNo");
            return (Criteria) this;
        }

        public Criteria andMemberNoNotEqualTo(String value) {
            addCriterion("member_no <>", value, "memberNo");
            return (Criteria) this;
        }

        public Criteria andMemberNoGreaterThan(String value) {
            addCriterion("member_no >", value, "memberNo");
            return (Criteria) this;
        }

        public Criteria andMemberNoGreaterThanOrEqualTo(String value) {
            addCriterion("member_no >=", value, "memberNo");
            return (Criteria) this;
        }

        public Criteria andMemberNoLessThan(String value) {
            addCriterion("member_no <", value, "memberNo");
            return (Criteria) this;
        }

        public Criteria andMemberNoLessThanOrEqualTo(String value) {
            addCriterion("member_no <=", value, "memberNo");
            return (Criteria) this;
        }

        public Criteria andMemberNoLike(String value) {
            addCriterion("member_no like", value, "memberNo");
            return (Criteria) this;
        }

        public Criteria andMemberNoNotLike(String value) {
            addCriterion("member_no not like", value, "memberNo");
            return (Criteria) this;
        }

        public Criteria andMemberNoIn(List<String> values) {
            addCriterion("member_no in", values, "memberNo");
            return (Criteria) this;
        }

        public Criteria andMemberNoNotIn(List<String> values) {
            addCriterion("member_no not in", values, "memberNo");
            return (Criteria) this;
        }

        public Criteria andMemberNoBetween(String value1, String value2) {
            addCriterion("member_no between", value1, value2, "memberNo");
            return (Criteria) this;
        }

        public Criteria andMemberNoNotBetween(String value1, String value2) {
            addCriterion("member_no not between", value1, value2, "memberNo");
            return (Criteria) this;
        }

        public Criteria andBaseOrgIdIsNull() {
            addCriterion("base_org_id is null");
            return (Criteria) this;
        }

        public Criteria andBaseOrgIdIsNotNull() {
            addCriterion("base_org_id is not null");
            return (Criteria) this;
        }

        public Criteria andBaseOrgIdEqualTo(String value) {
            addCriterion("base_org_id =", value, "baseOrgId");
            return (Criteria) this;
        }

        public Criteria andBaseOrgIdNotEqualTo(String value) {
            addCriterion("base_org_id <>", value, "baseOrgId");
            return (Criteria) this;
        }

        public Criteria andBaseOrgIdGreaterThan(String value) {
            addCriterion("base_org_id >", value, "baseOrgId");
            return (Criteria) this;
        }

        public Criteria andBaseOrgIdGreaterThanOrEqualTo(String value) {
            addCriterion("base_org_id >=", value, "baseOrgId");
            return (Criteria) this;
        }

        public Criteria andBaseOrgIdLessThan(String value) {
            addCriterion("base_org_id <", value, "baseOrgId");
            return (Criteria) this;
        }

        public Criteria andBaseOrgIdLessThanOrEqualTo(String value) {
            addCriterion("base_org_id <=", value, "baseOrgId");
            return (Criteria) this;
        }

        public Criteria andBaseOrgIdLike(String value) {
            addCriterion("base_org_id like", value, "baseOrgId");
            return (Criteria) this;
        }

        public Criteria andBaseOrgIdNotLike(String value) {
            addCriterion("base_org_id not like", value, "baseOrgId");
            return (Criteria) this;
        }

        public Criteria andBaseOrgIdIn(List<String> values) {
            addCriterion("base_org_id in", values, "baseOrgId");
            return (Criteria) this;
        }

        public Criteria andBaseOrgIdNotIn(List<String> values) {
            addCriterion("base_org_id not in", values, "baseOrgId");
            return (Criteria) this;
        }

        public Criteria andBaseOrgIdBetween(String value1, String value2) {
            addCriterion("base_org_id between", value1, value2, "baseOrgId");
            return (Criteria) this;
        }

        public Criteria andBaseOrgIdNotBetween(String value1, String value2) {
            addCriterion("base_org_id not between", value1, value2, "baseOrgId");
            return (Criteria) this;
        }

        public Criteria andBaseOrgNoIsNull() {
            addCriterion("base_org_no is null");
            return (Criteria) this;
        }

        public Criteria andBaseOrgNoIsNotNull() {
            addCriterion("base_org_no is not null");
            return (Criteria) this;
        }

        public Criteria andBaseOrgNoEqualTo(String value) {
            addCriterion("base_org_no =", value, "baseOrgNo");
            return (Criteria) this;
        }

        public Criteria andBaseOrgNoNotEqualTo(String value) {
            addCriterion("base_org_no <>", value, "baseOrgNo");
            return (Criteria) this;
        }

        public Criteria andBaseOrgNoGreaterThan(String value) {
            addCriterion("base_org_no >", value, "baseOrgNo");
            return (Criteria) this;
        }

        public Criteria andBaseOrgNoGreaterThanOrEqualTo(String value) {
            addCriterion("base_org_no >=", value, "baseOrgNo");
            return (Criteria) this;
        }

        public Criteria andBaseOrgNoLessThan(String value) {
            addCriterion("base_org_no <", value, "baseOrgNo");
            return (Criteria) this;
        }

        public Criteria andBaseOrgNoLessThanOrEqualTo(String value) {
            addCriterion("base_org_no <=", value, "baseOrgNo");
            return (Criteria) this;
        }

        public Criteria andBaseOrgNoLike(String value) {
            addCriterion("base_org_no like", value, "baseOrgNo");
            return (Criteria) this;
        }

        public Criteria andBaseOrgNoNotLike(String value) {
            addCriterion("base_org_no not like", value, "baseOrgNo");
            return (Criteria) this;
        }

        public Criteria andBaseOrgNoIn(List<String> values) {
            addCriterion("base_org_no in", values, "baseOrgNo");
            return (Criteria) this;
        }

        public Criteria andBaseOrgNoNotIn(List<String> values) {
            addCriterion("base_org_no not in", values, "baseOrgNo");
            return (Criteria) this;
        }

        public Criteria andBaseOrgNoBetween(String value1, String value2) {
            addCriterion("base_org_no between", value1, value2, "baseOrgNo");
            return (Criteria) this;
        }

        public Criteria andBaseOrgNoNotBetween(String value1, String value2) {
            addCriterion("base_org_no not between", value1, value2, "baseOrgNo");
            return (Criteria) this;
        }

        public Criteria andBaseOrgNameIsNull() {
            addCriterion("base_org_name is null");
            return (Criteria) this;
        }

        public Criteria andBaseOrgNameIsNotNull() {
            addCriterion("base_org_name is not null");
            return (Criteria) this;
        }

        public Criteria andBaseOrgNameEqualTo(String value) {
            addCriterion("base_org_name =", value, "baseOrgName");
            return (Criteria) this;
        }

        public Criteria andBaseOrgNameNotEqualTo(String value) {
            addCriterion("base_org_name <>", value, "baseOrgName");
            return (Criteria) this;
        }

        public Criteria andBaseOrgNameGreaterThan(String value) {
            addCriterion("base_org_name >", value, "baseOrgName");
            return (Criteria) this;
        }

        public Criteria andBaseOrgNameGreaterThanOrEqualTo(String value) {
            addCriterion("base_org_name >=", value, "baseOrgName");
            return (Criteria) this;
        }

        public Criteria andBaseOrgNameLessThan(String value) {
            addCriterion("base_org_name <", value, "baseOrgName");
            return (Criteria) this;
        }

        public Criteria andBaseOrgNameLessThanOrEqualTo(String value) {
            addCriterion("base_org_name <=", value, "baseOrgName");
            return (Criteria) this;
        }

        public Criteria andBaseOrgNameLike(String value) {
            addCriterion("base_org_name like", value, "baseOrgName");
            return (Criteria) this;
        }

        public Criteria andBaseOrgNameNotLike(String value) {
            addCriterion("base_org_name not like", value, "baseOrgName");
            return (Criteria) this;
        }

        public Criteria andBaseOrgNameIn(List<String> values) {
            addCriterion("base_org_name in", values, "baseOrgName");
            return (Criteria) this;
        }

        public Criteria andBaseOrgNameNotIn(List<String> values) {
            addCriterion("base_org_name not in", values, "baseOrgName");
            return (Criteria) this;
        }

        public Criteria andBaseOrgNameBetween(String value1, String value2) {
            addCriterion("base_org_name between", value1, value2, "baseOrgName");
            return (Criteria) this;
        }

        public Criteria andBaseOrgNameNotBetween(String value1, String value2) {
            addCriterion("base_org_name not between", value1, value2, "baseOrgName");
            return (Criteria) this;
        }

        public Criteria andTimingPractiseCardStateIsNull() {
            addCriterion("timing_practise_card_state is null");
            return (Criteria) this;
        }

        public Criteria andTimingPractiseCardStateIsNotNull() {
            addCriterion("timing_practise_card_state is not null");
            return (Criteria) this;
        }

        public Criteria andTimingPractiseCardStateEqualTo(Integer value) {
            addCriterion("timing_practise_card_state =", value, "timingPractiseCardState");
            return (Criteria) this;
        }

        public Criteria andTimingPractiseCardStateNotEqualTo(Integer value) {
            addCriterion("timing_practise_card_state <>", value, "timingPractiseCardState");
            return (Criteria) this;
        }

        public Criteria andTimingPractiseCardStateGreaterThan(Integer value) {
            addCriterion("timing_practise_card_state >", value, "timingPractiseCardState");
            return (Criteria) this;
        }

        public Criteria andTimingPractiseCardStateGreaterThanOrEqualTo(Integer value) {
            addCriterion("timing_practise_card_state >=", value, "timingPractiseCardState");
            return (Criteria) this;
        }

        public Criteria andTimingPractiseCardStateLessThan(Integer value) {
            addCriterion("timing_practise_card_state <", value, "timingPractiseCardState");
            return (Criteria) this;
        }

        public Criteria andTimingPractiseCardStateLessThanOrEqualTo(Integer value) {
            addCriterion("timing_practise_card_state <=", value, "timingPractiseCardState");
            return (Criteria) this;
        }

        public Criteria andTimingPractiseCardStateIn(List<Integer> values) {
            addCriterion("timing_practise_card_state in", values, "timingPractiseCardState");
            return (Criteria) this;
        }

        public Criteria andTimingPractiseCardStateNotIn(List<Integer> values) {
            addCriterion("timing_practise_card_state not in", values, "timingPractiseCardState");
            return (Criteria) this;
        }

        public Criteria andTimingPractiseCardStateBetween(Integer value1, Integer value2) {
            addCriterion("timing_practise_card_state between", value1, value2, "timingPractiseCardState");
            return (Criteria) this;
        }

        public Criteria andTimingPractiseCardStateNotBetween(Integer value1, Integer value2) {
            addCriterion("timing_practise_card_state not between", value1, value2, "timingPractiseCardState");
            return (Criteria) this;
        }

        public Criteria andTimingPractiseCardIdIsNull() {
            addCriterion("timing_practise_card_id is null");
            return (Criteria) this;
        }

        public Criteria andTimingPractiseCardIdIsNotNull() {
            addCriterion("timing_practise_card_id is not null");
            return (Criteria) this;
        }

        public Criteria andTimingPractiseCardIdEqualTo(String value) {
            addCriterion("timing_practise_card_id =", value, "timingPractiseCardId");
            return (Criteria) this;
        }

        public Criteria andTimingPractiseCardIdNotEqualTo(String value) {
            addCriterion("timing_practise_card_id <>", value, "timingPractiseCardId");
            return (Criteria) this;
        }

        public Criteria andTimingPractiseCardIdGreaterThan(String value) {
            addCriterion("timing_practise_card_id >", value, "timingPractiseCardId");
            return (Criteria) this;
        }

        public Criteria andTimingPractiseCardIdGreaterThanOrEqualTo(String value) {
            addCriterion("timing_practise_card_id >=", value, "timingPractiseCardId");
            return (Criteria) this;
        }

        public Criteria andTimingPractiseCardIdLessThan(String value) {
            addCriterion("timing_practise_card_id <", value, "timingPractiseCardId");
            return (Criteria) this;
        }

        public Criteria andTimingPractiseCardIdLessThanOrEqualTo(String value) {
            addCriterion("timing_practise_card_id <=", value, "timingPractiseCardId");
            return (Criteria) this;
        }

        public Criteria andTimingPractiseCardIdLike(String value) {
            addCriterion("timing_practise_card_id like", value, "timingPractiseCardId");
            return (Criteria) this;
        }

        public Criteria andTimingPractiseCardIdNotLike(String value) {
            addCriterion("timing_practise_card_id not like", value, "timingPractiseCardId");
            return (Criteria) this;
        }

        public Criteria andTimingPractiseCardIdIn(List<String> values) {
            addCriterion("timing_practise_card_id in", values, "timingPractiseCardId");
            return (Criteria) this;
        }

        public Criteria andTimingPractiseCardIdNotIn(List<String> values) {
            addCriterion("timing_practise_card_id not in", values, "timingPractiseCardId");
            return (Criteria) this;
        }

        public Criteria andTimingPractiseCardIdBetween(String value1, String value2) {
            addCriterion("timing_practise_card_id between", value1, value2, "timingPractiseCardId");
            return (Criteria) this;
        }

        public Criteria andTimingPractiseCardIdNotBetween(String value1, String value2) {
            addCriterion("timing_practise_card_id not between", value1, value2, "timingPractiseCardId");
            return (Criteria) this;
        }

        public Criteria andTimingPractiseCardNoIsNull() {
            addCriterion("timing_practise_card_no is null");
            return (Criteria) this;
        }

        public Criteria andTimingPractiseCardNoIsNotNull() {
            addCriterion("timing_practise_card_no is not null");
            return (Criteria) this;
        }

        public Criteria andTimingPractiseCardNoEqualTo(String value) {
            addCriterion("timing_practise_card_no =", value, "timingPractiseCardNo");
            return (Criteria) this;
        }

        public Criteria andTimingPractiseCardNoNotEqualTo(String value) {
            addCriterion("timing_practise_card_no <>", value, "timingPractiseCardNo");
            return (Criteria) this;
        }

        public Criteria andTimingPractiseCardNoGreaterThan(String value) {
            addCriterion("timing_practise_card_no >", value, "timingPractiseCardNo");
            return (Criteria) this;
        }

        public Criteria andTimingPractiseCardNoGreaterThanOrEqualTo(String value) {
            addCriterion("timing_practise_card_no >=", value, "timingPractiseCardNo");
            return (Criteria) this;
        }

        public Criteria andTimingPractiseCardNoLessThan(String value) {
            addCriterion("timing_practise_card_no <", value, "timingPractiseCardNo");
            return (Criteria) this;
        }

        public Criteria andTimingPractiseCardNoLessThanOrEqualTo(String value) {
            addCriterion("timing_practise_card_no <=", value, "timingPractiseCardNo");
            return (Criteria) this;
        }

        public Criteria andTimingPractiseCardNoLike(String value) {
            addCriterion("timing_practise_card_no like", value, "timingPractiseCardNo");
            return (Criteria) this;
        }

        public Criteria andTimingPractiseCardNoNotLike(String value) {
            addCriterion("timing_practise_card_no not like", value, "timingPractiseCardNo");
            return (Criteria) this;
        }

        public Criteria andTimingPractiseCardNoIn(List<String> values) {
            addCriterion("timing_practise_card_no in", values, "timingPractiseCardNo");
            return (Criteria) this;
        }

        public Criteria andTimingPractiseCardNoNotIn(List<String> values) {
            addCriterion("timing_practise_card_no not in", values, "timingPractiseCardNo");
            return (Criteria) this;
        }

        public Criteria andTimingPractiseCardNoBetween(String value1, String value2) {
            addCriterion("timing_practise_card_no between", value1, value2, "timingPractiseCardNo");
            return (Criteria) this;
        }

        public Criteria andTimingPractiseCardNoNotBetween(String value1, String value2) {
            addCriterion("timing_practise_card_no not between", value1, value2, "timingPractiseCardNo");
            return (Criteria) this;
        }

        public Criteria andTimingPractisePasswordIsNull() {
            addCriterion("timing_practise_password is null");
            return (Criteria) this;
        }

        public Criteria andTimingPractisePasswordIsNotNull() {
            addCriterion("timing_practise_password is not null");
            return (Criteria) this;
        }

        public Criteria andTimingPractisePasswordEqualTo(String value) {
            addCriterion("timing_practise_password =", value, "timingPractisePassword");
            return (Criteria) this;
        }

        public Criteria andTimingPractisePasswordNotEqualTo(String value) {
            addCriterion("timing_practise_password <>", value, "timingPractisePassword");
            return (Criteria) this;
        }

        public Criteria andTimingPractisePasswordGreaterThan(String value) {
            addCriterion("timing_practise_password >", value, "timingPractisePassword");
            return (Criteria) this;
        }

        public Criteria andTimingPractisePasswordGreaterThanOrEqualTo(String value) {
            addCriterion("timing_practise_password >=", value, "timingPractisePassword");
            return (Criteria) this;
        }

        public Criteria andTimingPractisePasswordLessThan(String value) {
            addCriterion("timing_practise_password <", value, "timingPractisePassword");
            return (Criteria) this;
        }

        public Criteria andTimingPractisePasswordLessThanOrEqualTo(String value) {
            addCriterion("timing_practise_password <=", value, "timingPractisePassword");
            return (Criteria) this;
        }

        public Criteria andTimingPractisePasswordLike(String value) {
            addCriterion("timing_practise_password like", value, "timingPractisePassword");
            return (Criteria) this;
        }

        public Criteria andTimingPractisePasswordNotLike(String value) {
            addCriterion("timing_practise_password not like", value, "timingPractisePassword");
            return (Criteria) this;
        }

        public Criteria andTimingPractisePasswordIn(List<String> values) {
            addCriterion("timing_practise_password in", values, "timingPractisePassword");
            return (Criteria) this;
        }

        public Criteria andTimingPractisePasswordNotIn(List<String> values) {
            addCriterion("timing_practise_password not in", values, "timingPractisePassword");
            return (Criteria) this;
        }

        public Criteria andTimingPractisePasswordBetween(String value1, String value2) {
            addCriterion("timing_practise_password between", value1, value2, "timingPractisePassword");
            return (Criteria) this;
        }

        public Criteria andTimingPractisePasswordNotBetween(String value1, String value2) {
            addCriterion("timing_practise_password not between", value1, value2, "timingPractisePassword");
            return (Criteria) this;
        }

        public Criteria andTimingPractiseCardTimeIsNull() {
            addCriterion("timing_practise_card_time is null");
            return (Criteria) this;
        }

        public Criteria andTimingPractiseCardTimeIsNotNull() {
            addCriterion("timing_practise_card_time is not null");
            return (Criteria) this;
        }

        public Criteria andTimingPractiseCardTimeEqualTo(Date value) {
            addCriterion("timing_practise_card_time =", value, "timingPractiseCardTime");
            return (Criteria) this;
        }

        public Criteria andTimingPractiseCardTimeNotEqualTo(Date value) {
            addCriterion("timing_practise_card_time <>", value, "timingPractiseCardTime");
            return (Criteria) this;
        }

        public Criteria andTimingPractiseCardTimeGreaterThan(Date value) {
            addCriterion("timing_practise_card_time >", value, "timingPractiseCardTime");
            return (Criteria) this;
        }

        public Criteria andTimingPractiseCardTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("timing_practise_card_time >=", value, "timingPractiseCardTime");
            return (Criteria) this;
        }

        public Criteria andTimingPractiseCardTimeLessThan(Date value) {
            addCriterion("timing_practise_card_time <", value, "timingPractiseCardTime");
            return (Criteria) this;
        }

        public Criteria andTimingPractiseCardTimeLessThanOrEqualTo(Date value) {
            addCriterion("timing_practise_card_time <=", value, "timingPractiseCardTime");
            return (Criteria) this;
        }

        public Criteria andTimingPractiseCardTimeIn(List<Date> values) {
            addCriterion("timing_practise_card_time in", values, "timingPractiseCardTime");
            return (Criteria) this;
        }

        public Criteria andTimingPractiseCardTimeNotIn(List<Date> values) {
            addCriterion("timing_practise_card_time not in", values, "timingPractiseCardTime");
            return (Criteria) this;
        }

        public Criteria andTimingPractiseCardTimeBetween(Date value1, Date value2) {
            addCriterion("timing_practise_card_time between", value1, value2, "timingPractiseCardTime");
            return (Criteria) this;
        }

        public Criteria andTimingPractiseCardTimeNotBetween(Date value1, Date value2) {
            addCriterion("timing_practise_card_time not between", value1, value2, "timingPractiseCardTime");
            return (Criteria) this;
        }

        public Criteria andTimingPractiseCardBeginTimeIsNull() {
            addCriterion("timing_practise_card_begin_time is null");
            return (Criteria) this;
        }

        public Criteria andTimingPractiseCardBeginTimeIsNotNull() {
            addCriterion("timing_practise_card_begin_time is not null");
            return (Criteria) this;
        }

        public Criteria andTimingPractiseCardBeginTimeEqualTo(Date value) {
            addCriterion("timing_practise_card_begin_time =", value, "timingPractiseCardBeginTime");
            return (Criteria) this;
        }

        public Criteria andTimingPractiseCardBeginTimeNotEqualTo(Date value) {
            addCriterion("timing_practise_card_begin_time <>", value, "timingPractiseCardBeginTime");
            return (Criteria) this;
        }

        public Criteria andTimingPractiseCardBeginTimeGreaterThan(Date value) {
            addCriterion("timing_practise_card_begin_time >", value, "timingPractiseCardBeginTime");
            return (Criteria) this;
        }

        public Criteria andTimingPractiseCardBeginTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("timing_practise_card_begin_time >=", value, "timingPractiseCardBeginTime");
            return (Criteria) this;
        }

        public Criteria andTimingPractiseCardBeginTimeLessThan(Date value) {
            addCriterion("timing_practise_card_begin_time <", value, "timingPractiseCardBeginTime");
            return (Criteria) this;
        }

        public Criteria andTimingPractiseCardBeginTimeLessThanOrEqualTo(Date value) {
            addCriterion("timing_practise_card_begin_time <=", value, "timingPractiseCardBeginTime");
            return (Criteria) this;
        }

        public Criteria andTimingPractiseCardBeginTimeIn(List<Date> values) {
            addCriterion("timing_practise_card_begin_time in", values, "timingPractiseCardBeginTime");
            return (Criteria) this;
        }

        public Criteria andTimingPractiseCardBeginTimeNotIn(List<Date> values) {
            addCriterion("timing_practise_card_begin_time not in", values, "timingPractiseCardBeginTime");
            return (Criteria) this;
        }

        public Criteria andTimingPractiseCardBeginTimeBetween(Date value1, Date value2) {
            addCriterion("timing_practise_card_begin_time between", value1, value2, "timingPractiseCardBeginTime");
            return (Criteria) this;
        }

        public Criteria andTimingPractiseCardBeginTimeNotBetween(Date value1, Date value2) {
            addCriterion("timing_practise_card_begin_time not between", value1, value2, "timingPractiseCardBeginTime");
            return (Criteria) this;
        }

        public Criteria andTimingPractiseCardSchoolIsNull() {
            addCriterion("timing_practise_card_school is null");
            return (Criteria) this;
        }

        public Criteria andTimingPractiseCardSchoolIsNotNull() {
            addCriterion("timing_practise_card_school is not null");
            return (Criteria) this;
        }

        public Criteria andTimingPractiseCardSchoolEqualTo(String value) {
            addCriterion("timing_practise_card_school =", value, "timingPractiseCardSchool");
            return (Criteria) this;
        }

        public Criteria andTimingPractiseCardSchoolNotEqualTo(String value) {
            addCriterion("timing_practise_card_school <>", value, "timingPractiseCardSchool");
            return (Criteria) this;
        }

        public Criteria andTimingPractiseCardSchoolGreaterThan(String value) {
            addCriterion("timing_practise_card_school >", value, "timingPractiseCardSchool");
            return (Criteria) this;
        }

        public Criteria andTimingPractiseCardSchoolGreaterThanOrEqualTo(String value) {
            addCriterion("timing_practise_card_school >=", value, "timingPractiseCardSchool");
            return (Criteria) this;
        }

        public Criteria andTimingPractiseCardSchoolLessThan(String value) {
            addCriterion("timing_practise_card_school <", value, "timingPractiseCardSchool");
            return (Criteria) this;
        }

        public Criteria andTimingPractiseCardSchoolLessThanOrEqualTo(String value) {
            addCriterion("timing_practise_card_school <=", value, "timingPractiseCardSchool");
            return (Criteria) this;
        }

        public Criteria andTimingPractiseCardSchoolLike(String value) {
            addCriterion("timing_practise_card_school like", value, "timingPractiseCardSchool");
            return (Criteria) this;
        }

        public Criteria andTimingPractiseCardSchoolNotLike(String value) {
            addCriterion("timing_practise_card_school not like", value, "timingPractiseCardSchool");
            return (Criteria) this;
        }

        public Criteria andTimingPractiseCardSchoolIn(List<String> values) {
            addCriterion("timing_practise_card_school in", values, "timingPractiseCardSchool");
            return (Criteria) this;
        }

        public Criteria andTimingPractiseCardSchoolNotIn(List<String> values) {
            addCriterion("timing_practise_card_school not in", values, "timingPractiseCardSchool");
            return (Criteria) this;
        }

        public Criteria andTimingPractiseCardSchoolBetween(String value1, String value2) {
            addCriterion("timing_practise_card_school between", value1, value2, "timingPractiseCardSchool");
            return (Criteria) this;
        }

        public Criteria andTimingPractiseCardSchoolNotBetween(String value1, String value2) {
            addCriterion("timing_practise_card_school not between", value1, value2, "timingPractiseCardSchool");
            return (Criteria) this;
        }

        public Criteria andTimingPractiseCardSchoolIdIsNull() {
            addCriterion("timing_practise_card_school_id is null");
            return (Criteria) this;
        }

        public Criteria andTimingPractiseCardSchoolIdIsNotNull() {
            addCriterion("timing_practise_card_school_id is not null");
            return (Criteria) this;
        }

        public Criteria andTimingPractiseCardSchoolIdEqualTo(String value) {
            addCriterion("timing_practise_card_school_id =", value, "timingPractiseCardSchoolId");
            return (Criteria) this;
        }

        public Criteria andTimingPractiseCardSchoolIdNotEqualTo(String value) {
            addCriterion("timing_practise_card_school_id <>", value, "timingPractiseCardSchoolId");
            return (Criteria) this;
        }

        public Criteria andTimingPractiseCardSchoolIdGreaterThan(String value) {
            addCriterion("timing_practise_card_school_id >", value, "timingPractiseCardSchoolId");
            return (Criteria) this;
        }

        public Criteria andTimingPractiseCardSchoolIdGreaterThanOrEqualTo(String value) {
            addCriterion("timing_practise_card_school_id >=", value, "timingPractiseCardSchoolId");
            return (Criteria) this;
        }

        public Criteria andTimingPractiseCardSchoolIdLessThan(String value) {
            addCriterion("timing_practise_card_school_id <", value, "timingPractiseCardSchoolId");
            return (Criteria) this;
        }

        public Criteria andTimingPractiseCardSchoolIdLessThanOrEqualTo(String value) {
            addCriterion("timing_practise_card_school_id <=", value, "timingPractiseCardSchoolId");
            return (Criteria) this;
        }

        public Criteria andTimingPractiseCardSchoolIdLike(String value) {
            addCriterion("timing_practise_card_school_id like", value, "timingPractiseCardSchoolId");
            return (Criteria) this;
        }

        public Criteria andTimingPractiseCardSchoolIdNotLike(String value) {
            addCriterion("timing_practise_card_school_id not like", value, "timingPractiseCardSchoolId");
            return (Criteria) this;
        }

        public Criteria andTimingPractiseCardSchoolIdIn(List<String> values) {
            addCriterion("timing_practise_card_school_id in", values, "timingPractiseCardSchoolId");
            return (Criteria) this;
        }

        public Criteria andTimingPractiseCardSchoolIdNotIn(List<String> values) {
            addCriterion("timing_practise_card_school_id not in", values, "timingPractiseCardSchoolId");
            return (Criteria) this;
        }

        public Criteria andTimingPractiseCardSchoolIdBetween(String value1, String value2) {
            addCriterion("timing_practise_card_school_id between", value1, value2, "timingPractiseCardSchoolId");
            return (Criteria) this;
        }

        public Criteria andTimingPractiseCardSchoolIdNotBetween(String value1, String value2) {
            addCriterion("timing_practise_card_school_id not between", value1, value2, "timingPractiseCardSchoolId");
            return (Criteria) this;
        }

        public Criteria andTimingPractiseCardClassroomIsNull() {
            addCriterion("timing_practise_card_classroom is null");
            return (Criteria) this;
        }

        public Criteria andTimingPractiseCardClassroomIsNotNull() {
            addCriterion("timing_practise_card_classroom is not null");
            return (Criteria) this;
        }

        public Criteria andTimingPractiseCardClassroomEqualTo(String value) {
            addCriterion("timing_practise_card_classroom =", value, "timingPractiseCardClassroom");
            return (Criteria) this;
        }

        public Criteria andTimingPractiseCardClassroomNotEqualTo(String value) {
            addCriterion("timing_practise_card_classroom <>", value, "timingPractiseCardClassroom");
            return (Criteria) this;
        }

        public Criteria andTimingPractiseCardClassroomGreaterThan(String value) {
            addCriterion("timing_practise_card_classroom >", value, "timingPractiseCardClassroom");
            return (Criteria) this;
        }

        public Criteria andTimingPractiseCardClassroomGreaterThanOrEqualTo(String value) {
            addCriterion("timing_practise_card_classroom >=", value, "timingPractiseCardClassroom");
            return (Criteria) this;
        }

        public Criteria andTimingPractiseCardClassroomLessThan(String value) {
            addCriterion("timing_practise_card_classroom <", value, "timingPractiseCardClassroom");
            return (Criteria) this;
        }

        public Criteria andTimingPractiseCardClassroomLessThanOrEqualTo(String value) {
            addCriterion("timing_practise_card_classroom <=", value, "timingPractiseCardClassroom");
            return (Criteria) this;
        }

        public Criteria andTimingPractiseCardClassroomLike(String value) {
            addCriterion("timing_practise_card_classroom like", value, "timingPractiseCardClassroom");
            return (Criteria) this;
        }

        public Criteria andTimingPractiseCardClassroomNotLike(String value) {
            addCriterion("timing_practise_card_classroom not like", value, "timingPractiseCardClassroom");
            return (Criteria) this;
        }

        public Criteria andTimingPractiseCardClassroomIn(List<String> values) {
            addCriterion("timing_practise_card_classroom in", values, "timingPractiseCardClassroom");
            return (Criteria) this;
        }

        public Criteria andTimingPractiseCardClassroomNotIn(List<String> values) {
            addCriterion("timing_practise_card_classroom not in", values, "timingPractiseCardClassroom");
            return (Criteria) this;
        }

        public Criteria andTimingPractiseCardClassroomBetween(String value1, String value2) {
            addCriterion("timing_practise_card_classroom between", value1, value2, "timingPractiseCardClassroom");
            return (Criteria) this;
        }

        public Criteria andTimingPractiseCardClassroomNotBetween(String value1, String value2) {
            addCriterion("timing_practise_card_classroom not between", value1, value2, "timingPractiseCardClassroom");
            return (Criteria) this;
        }

        public Criteria andTimingPractiseCardClassroomIdIsNull() {
            addCriterion("timing_practise_card_classroom_id is null");
            return (Criteria) this;
        }

        public Criteria andTimingPractiseCardClassroomIdIsNotNull() {
            addCriterion("timing_practise_card_classroom_id is not null");
            return (Criteria) this;
        }

        public Criteria andTimingPractiseCardClassroomIdEqualTo(String value) {
            addCriterion("timing_practise_card_classroom_id =", value, "timingPractiseCardClassroomId");
            return (Criteria) this;
        }

        public Criteria andTimingPractiseCardClassroomIdNotEqualTo(String value) {
            addCriterion("timing_practise_card_classroom_id <>", value, "timingPractiseCardClassroomId");
            return (Criteria) this;
        }

        public Criteria andTimingPractiseCardClassroomIdGreaterThan(String value) {
            addCriterion("timing_practise_card_classroom_id >", value, "timingPractiseCardClassroomId");
            return (Criteria) this;
        }

        public Criteria andTimingPractiseCardClassroomIdGreaterThanOrEqualTo(String value) {
            addCriterion("timing_practise_card_classroom_id >=", value, "timingPractiseCardClassroomId");
            return (Criteria) this;
        }

        public Criteria andTimingPractiseCardClassroomIdLessThan(String value) {
            addCriterion("timing_practise_card_classroom_id <", value, "timingPractiseCardClassroomId");
            return (Criteria) this;
        }

        public Criteria andTimingPractiseCardClassroomIdLessThanOrEqualTo(String value) {
            addCriterion("timing_practise_card_classroom_id <=", value, "timingPractiseCardClassroomId");
            return (Criteria) this;
        }

        public Criteria andTimingPractiseCardClassroomIdLike(String value) {
            addCriterion("timing_practise_card_classroom_id like", value, "timingPractiseCardClassroomId");
            return (Criteria) this;
        }

        public Criteria andTimingPractiseCardClassroomIdNotLike(String value) {
            addCriterion("timing_practise_card_classroom_id not like", value, "timingPractiseCardClassroomId");
            return (Criteria) this;
        }

        public Criteria andTimingPractiseCardClassroomIdIn(List<String> values) {
            addCriterion("timing_practise_card_classroom_id in", values, "timingPractiseCardClassroomId");
            return (Criteria) this;
        }

        public Criteria andTimingPractiseCardClassroomIdNotIn(List<String> values) {
            addCriterion("timing_practise_card_classroom_id not in", values, "timingPractiseCardClassroomId");
            return (Criteria) this;
        }

        public Criteria andTimingPractiseCardClassroomIdBetween(String value1, String value2) {
            addCriterion("timing_practise_card_classroom_id between", value1, value2, "timingPractiseCardClassroomId");
            return (Criteria) this;
        }

        public Criteria andTimingPractiseCardClassroomIdNotBetween(String value1, String value2) {
            addCriterion("timing_practise_card_classroom_id not between", value1, value2, "timingPractiseCardClassroomId");
            return (Criteria) this;
        }

        public Criteria andMobilePhoneIsNull() {
            addCriterion("mobile_phone is null");
            return (Criteria) this;
        }

        public Criteria andMobilePhoneIsNotNull() {
            addCriterion("mobile_phone is not null");
            return (Criteria) this;
        }

        public Criteria andMobilePhoneEqualTo(String value) {
            addCriterion("mobile_phone =", value, "mobilePhone");
            return (Criteria) this;
        }

        public Criteria andMobilePhoneNotEqualTo(String value) {
            addCriterion("mobile_phone <>", value, "mobilePhone");
            return (Criteria) this;
        }

        public Criteria andMobilePhoneGreaterThan(String value) {
            addCriterion("mobile_phone >", value, "mobilePhone");
            return (Criteria) this;
        }

        public Criteria andMobilePhoneGreaterThanOrEqualTo(String value) {
            addCriterion("mobile_phone >=", value, "mobilePhone");
            return (Criteria) this;
        }

        public Criteria andMobilePhoneLessThan(String value) {
            addCriterion("mobile_phone <", value, "mobilePhone");
            return (Criteria) this;
        }

        public Criteria andMobilePhoneLessThanOrEqualTo(String value) {
            addCriterion("mobile_phone <=", value, "mobilePhone");
            return (Criteria) this;
        }

        public Criteria andMobilePhoneLike(String value) {
            addCriterion("mobile_phone like", value, "mobilePhone");
            return (Criteria) this;
        }

        public Criteria andMobilePhoneNotLike(String value) {
            addCriterion("mobile_phone not like", value, "mobilePhone");
            return (Criteria) this;
        }

        public Criteria andMobilePhoneIn(List<String> values) {
            addCriterion("mobile_phone in", values, "mobilePhone");
            return (Criteria) this;
        }

        public Criteria andMobilePhoneNotIn(List<String> values) {
            addCriterion("mobile_phone not in", values, "mobilePhone");
            return (Criteria) this;
        }

        public Criteria andMobilePhoneBetween(String value1, String value2) {
            addCriterion("mobile_phone between", value1, value2, "mobilePhone");
            return (Criteria) this;
        }

        public Criteria andMobilePhoneNotBetween(String value1, String value2) {
            addCriterion("mobile_phone not between", value1, value2, "mobilePhone");
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