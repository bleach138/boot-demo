package com.fnic.mybatis.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TQosExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TQosExample() {
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

        public Criteria andQosPriorityIsNull() {
            addCriterion("qos_priority is null");
            return (Criteria) this;
        }

        public Criteria andQosPriorityIsNotNull() {
            addCriterion("qos_priority is not null");
            return (Criteria) this;
        }

        public Criteria andQosPriorityEqualTo(Integer value) {
            addCriterion("qos_priority =", value, "qosPriority");
            return (Criteria) this;
        }

        public Criteria andQosPriorityNotEqualTo(Integer value) {
            addCriterion("qos_priority <>", value, "qosPriority");
            return (Criteria) this;
        }

        public Criteria andQosPriorityGreaterThan(Integer value) {
            addCriterion("qos_priority >", value, "qosPriority");
            return (Criteria) this;
        }

        public Criteria andQosPriorityGreaterThanOrEqualTo(Integer value) {
            addCriterion("qos_priority >=", value, "qosPriority");
            return (Criteria) this;
        }

        public Criteria andQosPriorityLessThan(Integer value) {
            addCriterion("qos_priority <", value, "qosPriority");
            return (Criteria) this;
        }

        public Criteria andQosPriorityLessThanOrEqualTo(Integer value) {
            addCriterion("qos_priority <=", value, "qosPriority");
            return (Criteria) this;
        }

        public Criteria andQosPriorityIn(List<Integer> values) {
            addCriterion("qos_priority in", values, "qosPriority");
            return (Criteria) this;
        }

        public Criteria andQosPriorityNotIn(List<Integer> values) {
            addCriterion("qos_priority not in", values, "qosPriority");
            return (Criteria) this;
        }

        public Criteria andQosPriorityBetween(Integer value1, Integer value2) {
            addCriterion("qos_priority between", value1, value2, "qosPriority");
            return (Criteria) this;
        }

        public Criteria andQosPriorityNotBetween(Integer value1, Integer value2) {
            addCriterion("qos_priority not between", value1, value2, "qosPriority");
            return (Criteria) this;
        }

        public Criteria andQosNameIsNull() {
            addCriterion("qos_name is null");
            return (Criteria) this;
        }

        public Criteria andQosNameIsNotNull() {
            addCriterion("qos_name is not null");
            return (Criteria) this;
        }

        public Criteria andQosNameEqualTo(String value) {
            addCriterion("qos_name =", value, "qosName");
            return (Criteria) this;
        }

        public Criteria andQosNameNotEqualTo(String value) {
            addCriterion("qos_name <>", value, "qosName");
            return (Criteria) this;
        }

        public Criteria andQosNameGreaterThan(String value) {
            addCriterion("qos_name >", value, "qosName");
            return (Criteria) this;
        }

        public Criteria andQosNameGreaterThanOrEqualTo(String value) {
            addCriterion("qos_name >=", value, "qosName");
            return (Criteria) this;
        }

        public Criteria andQosNameLessThan(String value) {
            addCriterion("qos_name <", value, "qosName");
            return (Criteria) this;
        }

        public Criteria andQosNameLessThanOrEqualTo(String value) {
            addCriterion("qos_name <=", value, "qosName");
            return (Criteria) this;
        }

        public Criteria andQosNameLike(String value) {
            addCriterion("qos_name like", value, "qosName");
            return (Criteria) this;
        }

        public Criteria andQosNameNotLike(String value) {
            addCriterion("qos_name not like", value, "qosName");
            return (Criteria) this;
        }

        public Criteria andQosNameIn(List<String> values) {
            addCriterion("qos_name in", values, "qosName");
            return (Criteria) this;
        }

        public Criteria andQosNameNotIn(List<String> values) {
            addCriterion("qos_name not in", values, "qosName");
            return (Criteria) this;
        }

        public Criteria andQosNameBetween(String value1, String value2) {
            addCriterion("qos_name between", value1, value2, "qosName");
            return (Criteria) this;
        }

        public Criteria andQosNameNotBetween(String value1, String value2) {
            addCriterion("qos_name not between", value1, value2, "qosName");
            return (Criteria) this;
        }

        public Criteria andQosCodeIsNull() {
            addCriterion("qos_code is null");
            return (Criteria) this;
        }

        public Criteria andQosCodeIsNotNull() {
            addCriterion("qos_code is not null");
            return (Criteria) this;
        }

        public Criteria andQosCodeEqualTo(String value) {
            addCriterion("qos_code =", value, "qosCode");
            return (Criteria) this;
        }

        public Criteria andQosCodeNotEqualTo(String value) {
            addCriterion("qos_code <>", value, "qosCode");
            return (Criteria) this;
        }

        public Criteria andQosCodeGreaterThan(String value) {
            addCriterion("qos_code >", value, "qosCode");
            return (Criteria) this;
        }

        public Criteria andQosCodeGreaterThanOrEqualTo(String value) {
            addCriterion("qos_code >=", value, "qosCode");
            return (Criteria) this;
        }

        public Criteria andQosCodeLessThan(String value) {
            addCriterion("qos_code <", value, "qosCode");
            return (Criteria) this;
        }

        public Criteria andQosCodeLessThanOrEqualTo(String value) {
            addCriterion("qos_code <=", value, "qosCode");
            return (Criteria) this;
        }

        public Criteria andQosCodeLike(String value) {
            addCriterion("qos_code like", value, "qosCode");
            return (Criteria) this;
        }

        public Criteria andQosCodeNotLike(String value) {
            addCriterion("qos_code not like", value, "qosCode");
            return (Criteria) this;
        }

        public Criteria andQosCodeIn(List<String> values) {
            addCriterion("qos_code in", values, "qosCode");
            return (Criteria) this;
        }

        public Criteria andQosCodeNotIn(List<String> values) {
            addCriterion("qos_code not in", values, "qosCode");
            return (Criteria) this;
        }

        public Criteria andQosCodeBetween(String value1, String value2) {
            addCriterion("qos_code between", value1, value2, "qosCode");
            return (Criteria) this;
        }

        public Criteria andQosCodeNotBetween(String value1, String value2) {
            addCriterion("qos_code not between", value1, value2, "qosCode");
            return (Criteria) this;
        }

        public Criteria andDefaultRateIsNull() {
            addCriterion("default_rate is null");
            return (Criteria) this;
        }

        public Criteria andDefaultRateIsNotNull() {
            addCriterion("default_rate is not null");
            return (Criteria) this;
        }

        public Criteria andDefaultRateEqualTo(Integer value) {
            addCriterion("default_rate =", value, "defaultRate");
            return (Criteria) this;
        }

        public Criteria andDefaultRateNotEqualTo(Integer value) {
            addCriterion("default_rate <>", value, "defaultRate");
            return (Criteria) this;
        }

        public Criteria andDefaultRateGreaterThan(Integer value) {
            addCriterion("default_rate >", value, "defaultRate");
            return (Criteria) this;
        }

        public Criteria andDefaultRateGreaterThanOrEqualTo(Integer value) {
            addCriterion("default_rate >=", value, "defaultRate");
            return (Criteria) this;
        }

        public Criteria andDefaultRateLessThan(Integer value) {
            addCriterion("default_rate <", value, "defaultRate");
            return (Criteria) this;
        }

        public Criteria andDefaultRateLessThanOrEqualTo(Integer value) {
            addCriterion("default_rate <=", value, "defaultRate");
            return (Criteria) this;
        }

        public Criteria andDefaultRateIn(List<Integer> values) {
            addCriterion("default_rate in", values, "defaultRate");
            return (Criteria) this;
        }

        public Criteria andDefaultRateNotIn(List<Integer> values) {
            addCriterion("default_rate not in", values, "defaultRate");
            return (Criteria) this;
        }

        public Criteria andDefaultRateBetween(Integer value1, Integer value2) {
            addCriterion("default_rate between", value1, value2, "defaultRate");
            return (Criteria) this;
        }

        public Criteria andDefaultRateNotBetween(Integer value1, Integer value2) {
            addCriterion("default_rate not between", value1, value2, "defaultRate");
            return (Criteria) this;
        }

        public Criteria andMaxRateIsNull() {
            addCriterion("max_rate is null");
            return (Criteria) this;
        }

        public Criteria andMaxRateIsNotNull() {
            addCriterion("max_rate is not null");
            return (Criteria) this;
        }

        public Criteria andMaxRateEqualTo(Integer value) {
            addCriterion("max_rate =", value, "maxRate");
            return (Criteria) this;
        }

        public Criteria andMaxRateNotEqualTo(Integer value) {
            addCriterion("max_rate <>", value, "maxRate");
            return (Criteria) this;
        }

        public Criteria andMaxRateGreaterThan(Integer value) {
            addCriterion("max_rate >", value, "maxRate");
            return (Criteria) this;
        }

        public Criteria andMaxRateGreaterThanOrEqualTo(Integer value) {
            addCriterion("max_rate >=", value, "maxRate");
            return (Criteria) this;
        }

        public Criteria andMaxRateLessThan(Integer value) {
            addCriterion("max_rate <", value, "maxRate");
            return (Criteria) this;
        }

        public Criteria andMaxRateLessThanOrEqualTo(Integer value) {
            addCriterion("max_rate <=", value, "maxRate");
            return (Criteria) this;
        }

        public Criteria andMaxRateIn(List<Integer> values) {
            addCriterion("max_rate in", values, "maxRate");
            return (Criteria) this;
        }

        public Criteria andMaxRateNotIn(List<Integer> values) {
            addCriterion("max_rate not in", values, "maxRate");
            return (Criteria) this;
        }

        public Criteria andMaxRateBetween(Integer value1, Integer value2) {
            addCriterion("max_rate between", value1, value2, "maxRate");
            return (Criteria) this;
        }

        public Criteria andMaxRateNotBetween(Integer value1, Integer value2) {
            addCriterion("max_rate not between", value1, value2, "maxRate");
            return (Criteria) this;
        }

        public Criteria andAccountIdIsNull() {
            addCriterion("account_id is null");
            return (Criteria) this;
        }

        public Criteria andAccountIdIsNotNull() {
            addCriterion("account_id is not null");
            return (Criteria) this;
        }

        public Criteria andAccountIdEqualTo(String value) {
            addCriterion("account_id =", value, "accountId");
            return (Criteria) this;
        }

        public Criteria andAccountIdNotEqualTo(String value) {
            addCriterion("account_id <>", value, "accountId");
            return (Criteria) this;
        }

        public Criteria andAccountIdGreaterThan(String value) {
            addCriterion("account_id >", value, "accountId");
            return (Criteria) this;
        }

        public Criteria andAccountIdGreaterThanOrEqualTo(String value) {
            addCriterion("account_id >=", value, "accountId");
            return (Criteria) this;
        }

        public Criteria andAccountIdLessThan(String value) {
            addCriterion("account_id <", value, "accountId");
            return (Criteria) this;
        }

        public Criteria andAccountIdLessThanOrEqualTo(String value) {
            addCriterion("account_id <=", value, "accountId");
            return (Criteria) this;
        }

        public Criteria andAccountIdLike(String value) {
            addCriterion("account_id like", value, "accountId");
            return (Criteria) this;
        }

        public Criteria andAccountIdNotLike(String value) {
            addCriterion("account_id not like", value, "accountId");
            return (Criteria) this;
        }

        public Criteria andAccountIdIn(List<String> values) {
            addCriterion("account_id in", values, "accountId");
            return (Criteria) this;
        }

        public Criteria andAccountIdNotIn(List<String> values) {
            addCriterion("account_id not in", values, "accountId");
            return (Criteria) this;
        }

        public Criteria andAccountIdBetween(String value1, String value2) {
            addCriterion("account_id between", value1, value2, "accountId");
            return (Criteria) this;
        }

        public Criteria andAccountIdNotBetween(String value1, String value2) {
            addCriterion("account_id not between", value1, value2, "accountId");
            return (Criteria) this;
        }

        public Criteria andUserGroupIdIsNull() {
            addCriterion("user_group_id is null");
            return (Criteria) this;
        }

        public Criteria andUserGroupIdIsNotNull() {
            addCriterion("user_group_id is not null");
            return (Criteria) this;
        }

        public Criteria andUserGroupIdEqualTo(String value) {
            addCriterion("user_group_id =", value, "userGroupId");
            return (Criteria) this;
        }

        public Criteria andUserGroupIdNotEqualTo(String value) {
            addCriterion("user_group_id <>", value, "userGroupId");
            return (Criteria) this;
        }

        public Criteria andUserGroupIdGreaterThan(String value) {
            addCriterion("user_group_id >", value, "userGroupId");
            return (Criteria) this;
        }

        public Criteria andUserGroupIdGreaterThanOrEqualTo(String value) {
            addCriterion("user_group_id >=", value, "userGroupId");
            return (Criteria) this;
        }

        public Criteria andUserGroupIdLessThan(String value) {
            addCriterion("user_group_id <", value, "userGroupId");
            return (Criteria) this;
        }

        public Criteria andUserGroupIdLessThanOrEqualTo(String value) {
            addCriterion("user_group_id <=", value, "userGroupId");
            return (Criteria) this;
        }

        public Criteria andUserGroupIdLike(String value) {
            addCriterion("user_group_id like", value, "userGroupId");
            return (Criteria) this;
        }

        public Criteria andUserGroupIdNotLike(String value) {
            addCriterion("user_group_id not like", value, "userGroupId");
            return (Criteria) this;
        }

        public Criteria andUserGroupIdIn(List<String> values) {
            addCriterion("user_group_id in", values, "userGroupId");
            return (Criteria) this;
        }

        public Criteria andUserGroupIdNotIn(List<String> values) {
            addCriterion("user_group_id not in", values, "userGroupId");
            return (Criteria) this;
        }

        public Criteria andUserGroupIdBetween(String value1, String value2) {
            addCriterion("user_group_id between", value1, value2, "userGroupId");
            return (Criteria) this;
        }

        public Criteria andUserGroupIdNotBetween(String value1, String value2) {
            addCriterion("user_group_id not between", value1, value2, "userGroupId");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("create_time not between", value1, value2, "createTime");
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

        public Criteria andOperUserIdIsNull() {
            addCriterion("oper_user_id is null");
            return (Criteria) this;
        }

        public Criteria andOperUserIdIsNotNull() {
            addCriterion("oper_user_id is not null");
            return (Criteria) this;
        }

        public Criteria andOperUserIdEqualTo(Integer value) {
            addCriterion("oper_user_id =", value, "operUserId");
            return (Criteria) this;
        }

        public Criteria andOperUserIdNotEqualTo(Integer value) {
            addCriterion("oper_user_id <>", value, "operUserId");
            return (Criteria) this;
        }

        public Criteria andOperUserIdGreaterThan(Integer value) {
            addCriterion("oper_user_id >", value, "operUserId");
            return (Criteria) this;
        }

        public Criteria andOperUserIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("oper_user_id >=", value, "operUserId");
            return (Criteria) this;
        }

        public Criteria andOperUserIdLessThan(Integer value) {
            addCriterion("oper_user_id <", value, "operUserId");
            return (Criteria) this;
        }

        public Criteria andOperUserIdLessThanOrEqualTo(Integer value) {
            addCriterion("oper_user_id <=", value, "operUserId");
            return (Criteria) this;
        }

        public Criteria andOperUserIdIn(List<Integer> values) {
            addCriterion("oper_user_id in", values, "operUserId");
            return (Criteria) this;
        }

        public Criteria andOperUserIdNotIn(List<Integer> values) {
            addCriterion("oper_user_id not in", values, "operUserId");
            return (Criteria) this;
        }

        public Criteria andOperUserIdBetween(Integer value1, Integer value2) {
            addCriterion("oper_user_id between", value1, value2, "operUserId");
            return (Criteria) this;
        }

        public Criteria andOperUserIdNotBetween(Integer value1, Integer value2) {
            addCriterion("oper_user_id not between", value1, value2, "operUserId");
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