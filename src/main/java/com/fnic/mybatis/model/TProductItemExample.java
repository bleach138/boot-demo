package com.fnic.mybatis.model;

import java.util.ArrayList;
import java.util.List;

public class TProductItemExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TProductItemExample() {
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

        public Criteria andProductItemIdIsNull() {
            addCriterion("product_item_id is null");
            return (Criteria) this;
        }

        public Criteria andProductItemIdIsNotNull() {
            addCriterion("product_item_id is not null");
            return (Criteria) this;
        }

        public Criteria andProductItemIdEqualTo(String value) {
            addCriterion("product_item_id =", value, "productItemId");
            return (Criteria) this;
        }

        public Criteria andProductItemIdNotEqualTo(String value) {
            addCriterion("product_item_id <>", value, "productItemId");
            return (Criteria) this;
        }

        public Criteria andProductItemIdGreaterThan(String value) {
            addCriterion("product_item_id >", value, "productItemId");
            return (Criteria) this;
        }

        public Criteria andProductItemIdGreaterThanOrEqualTo(String value) {
            addCriterion("product_item_id >=", value, "productItemId");
            return (Criteria) this;
        }

        public Criteria andProductItemIdLessThan(String value) {
            addCriterion("product_item_id <", value, "productItemId");
            return (Criteria) this;
        }

        public Criteria andProductItemIdLessThanOrEqualTo(String value) {
            addCriterion("product_item_id <=", value, "productItemId");
            return (Criteria) this;
        }

        public Criteria andProductItemIdLike(String value) {
            addCriterion("product_item_id like", value, "productItemId");
            return (Criteria) this;
        }

        public Criteria andProductItemIdNotLike(String value) {
            addCriterion("product_item_id not like", value, "productItemId");
            return (Criteria) this;
        }

        public Criteria andProductItemIdIn(List<String> values) {
            addCriterion("product_item_id in", values, "productItemId");
            return (Criteria) this;
        }

        public Criteria andProductItemIdNotIn(List<String> values) {
            addCriterion("product_item_id not in", values, "productItemId");
            return (Criteria) this;
        }

        public Criteria andProductItemIdBetween(String value1, String value2) {
            addCriterion("product_item_id between", value1, value2, "productItemId");
            return (Criteria) this;
        }

        public Criteria andProductItemIdNotBetween(String value1, String value2) {
            addCriterion("product_item_id not between", value1, value2, "productItemId");
            return (Criteria) this;
        }

        public Criteria andProductItemNameIsNull() {
            addCriterion("product_item_name is null");
            return (Criteria) this;
        }

        public Criteria andProductItemNameIsNotNull() {
            addCriterion("product_item_name is not null");
            return (Criteria) this;
        }

        public Criteria andProductItemNameEqualTo(String value) {
            addCriterion("product_item_name =", value, "productItemName");
            return (Criteria) this;
        }

        public Criteria andProductItemNameNotEqualTo(String value) {
            addCriterion("product_item_name <>", value, "productItemName");
            return (Criteria) this;
        }

        public Criteria andProductItemNameGreaterThan(String value) {
            addCriterion("product_item_name >", value, "productItemName");
            return (Criteria) this;
        }

        public Criteria andProductItemNameGreaterThanOrEqualTo(String value) {
            addCriterion("product_item_name >=", value, "productItemName");
            return (Criteria) this;
        }

        public Criteria andProductItemNameLessThan(String value) {
            addCriterion("product_item_name <", value, "productItemName");
            return (Criteria) this;
        }

        public Criteria andProductItemNameLessThanOrEqualTo(String value) {
            addCriterion("product_item_name <=", value, "productItemName");
            return (Criteria) this;
        }

        public Criteria andProductItemNameLike(String value) {
            addCriterion("product_item_name like", value, "productItemName");
            return (Criteria) this;
        }

        public Criteria andProductItemNameNotLike(String value) {
            addCriterion("product_item_name not like", value, "productItemName");
            return (Criteria) this;
        }

        public Criteria andProductItemNameIn(List<String> values) {
            addCriterion("product_item_name in", values, "productItemName");
            return (Criteria) this;
        }

        public Criteria andProductItemNameNotIn(List<String> values) {
            addCriterion("product_item_name not in", values, "productItemName");
            return (Criteria) this;
        }

        public Criteria andProductItemNameBetween(String value1, String value2) {
            addCriterion("product_item_name between", value1, value2, "productItemName");
            return (Criteria) this;
        }

        public Criteria andProductItemNameNotBetween(String value1, String value2) {
            addCriterion("product_item_name not between", value1, value2, "productItemName");
            return (Criteria) this;
        }

        public Criteria andProductItemValueIsNull() {
            addCriterion("product_item_value is null");
            return (Criteria) this;
        }

        public Criteria andProductItemValueIsNotNull() {
            addCriterion("product_item_value is not null");
            return (Criteria) this;
        }

        public Criteria andProductItemValueEqualTo(String value) {
            addCriterion("product_item_value =", value, "productItemValue");
            return (Criteria) this;
        }

        public Criteria andProductItemValueNotEqualTo(String value) {
            addCriterion("product_item_value <>", value, "productItemValue");
            return (Criteria) this;
        }

        public Criteria andProductItemValueGreaterThan(String value) {
            addCriterion("product_item_value >", value, "productItemValue");
            return (Criteria) this;
        }

        public Criteria andProductItemValueGreaterThanOrEqualTo(String value) {
            addCriterion("product_item_value >=", value, "productItemValue");
            return (Criteria) this;
        }

        public Criteria andProductItemValueLessThan(String value) {
            addCriterion("product_item_value <", value, "productItemValue");
            return (Criteria) this;
        }

        public Criteria andProductItemValueLessThanOrEqualTo(String value) {
            addCriterion("product_item_value <=", value, "productItemValue");
            return (Criteria) this;
        }

        public Criteria andProductItemValueLike(String value) {
            addCriterion("product_item_value like", value, "productItemValue");
            return (Criteria) this;
        }

        public Criteria andProductItemValueNotLike(String value) {
            addCriterion("product_item_value not like", value, "productItemValue");
            return (Criteria) this;
        }

        public Criteria andProductItemValueIn(List<String> values) {
            addCriterion("product_item_value in", values, "productItemValue");
            return (Criteria) this;
        }

        public Criteria andProductItemValueNotIn(List<String> values) {
            addCriterion("product_item_value not in", values, "productItemValue");
            return (Criteria) this;
        }

        public Criteria andProductItemValueBetween(String value1, String value2) {
            addCriterion("product_item_value between", value1, value2, "productItemValue");
            return (Criteria) this;
        }

        public Criteria andProductItemValueNotBetween(String value1, String value2) {
            addCriterion("product_item_value not between", value1, value2, "productItemValue");
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