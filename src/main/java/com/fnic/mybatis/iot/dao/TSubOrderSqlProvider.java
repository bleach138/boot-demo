package com.fnic.mybatis.iot.dao;

import static org.apache.ibatis.jdbc.SqlBuilder.BEGIN;
import static org.apache.ibatis.jdbc.SqlBuilder.DELETE_FROM;
import static org.apache.ibatis.jdbc.SqlBuilder.FROM;
import static org.apache.ibatis.jdbc.SqlBuilder.INSERT_INTO;
import static org.apache.ibatis.jdbc.SqlBuilder.ORDER_BY;
import static org.apache.ibatis.jdbc.SqlBuilder.SELECT;
import static org.apache.ibatis.jdbc.SqlBuilder.SELECT_DISTINCT;
import static org.apache.ibatis.jdbc.SqlBuilder.SET;
import static org.apache.ibatis.jdbc.SqlBuilder.SQL;
import static org.apache.ibatis.jdbc.SqlBuilder.UPDATE;
import static org.apache.ibatis.jdbc.SqlBuilder.VALUES;
import static org.apache.ibatis.jdbc.SqlBuilder.WHERE;

import com.fnic.mybatis.iot.model.TSubOrder;
import com.fnic.mybatis.iot.model.TSubOrderExample.Criteria;
import com.fnic.mybatis.iot.model.TSubOrderExample.Criterion;
import com.fnic.mybatis.iot.model.TSubOrderExample;
import java.util.List;
import java.util.Map;

public class TSubOrderSqlProvider {

    public String countByExample(TSubOrderExample example) {
        BEGIN();
        SELECT("count(*)");
        FROM("t_sub_order");
        applyWhere(example, false);
        return SQL();
    }

    public String deleteByExample(TSubOrderExample example) {
        BEGIN();
        DELETE_FROM("t_sub_order");
        applyWhere(example, false);
        return SQL();
    }

    public String insertSelective(TSubOrder record) {
        BEGIN();
        INSERT_INTO("t_sub_order");
        
        if (record.getId() != null) {
            VALUES("id", "#{id,jdbcType=VARCHAR}");
        }
        
        if (record.getOrderId() != null) {
            VALUES("order_id", "#{orderId,jdbcType=VARCHAR}");
        }
        
        if (record.getStatus() != null) {
            VALUES("status", "#{status,jdbcType=VARCHAR}");
        }
        
        if (record.getItemId() != null) {
            VALUES("item_id", "#{itemId,jdbcType=VARCHAR}");
        }
        
        if (record.getItemName() != null) {
            VALUES("item_name", "#{itemName,jdbcType=VARCHAR}");
        }
        
        if (record.getItemType() != null) {
            VALUES("item_type", "#{itemType,jdbcType=VARCHAR}");
        }
        
        if (record.getItemFee() != null) {
            VALUES("item_fee", "#{itemFee,jdbcType=INTEGER}");
        }
        
        if (record.getItemValue() != null) {
            VALUES("item_value", "#{itemValue,jdbcType=VARCHAR}");
        }
        
        if (record.getCreateTime() != null) {
            VALUES("create_time", "#{createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getUpdateTime() != null) {
            VALUES("update_time", "#{updateTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getStartTime() != null) {
            VALUES("start_time", "#{startTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getEndTime() != null) {
            VALUES("end_time", "#{endTime,jdbcType=TIMESTAMP}");
        }
        
        return SQL();
    }

    public String selectByExample(TSubOrderExample example) {
        BEGIN();
        if (example != null && example.isDistinct()) {
            SELECT_DISTINCT("id");
        } else {
            SELECT("id");
        }
        SELECT("order_id");
        SELECT("status");
        SELECT("item_id");
        SELECT("item_name");
        SELECT("item_type");
        SELECT("item_fee");
        SELECT("item_value");
        SELECT("create_time");
        SELECT("update_time");
        SELECT("start_time");
        SELECT("end_time");
        FROM("t_sub_order");
        applyWhere(example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            ORDER_BY(example.getOrderByClause());
        }
        
        return SQL();
    }

    public String updateByExampleSelective(Map<String, Object> parameter) {
        TSubOrder record = (TSubOrder) parameter.get("record");
        TSubOrderExample example = (TSubOrderExample) parameter.get("example");
        
        BEGIN();
        UPDATE("t_sub_order");
        
        if (record.getId() != null) {
            SET("id = #{record.id,jdbcType=VARCHAR}");
        }
        
        if (record.getOrderId() != null) {
            SET("order_id = #{record.orderId,jdbcType=VARCHAR}");
        }
        
        if (record.getStatus() != null) {
            SET("status = #{record.status,jdbcType=VARCHAR}");
        }
        
        if (record.getItemId() != null) {
            SET("item_id = #{record.itemId,jdbcType=VARCHAR}");
        }
        
        if (record.getItemName() != null) {
            SET("item_name = #{record.itemName,jdbcType=VARCHAR}");
        }
        
        if (record.getItemType() != null) {
            SET("item_type = #{record.itemType,jdbcType=VARCHAR}");
        }
        
        if (record.getItemFee() != null) {
            SET("item_fee = #{record.itemFee,jdbcType=INTEGER}");
        }
        
        if (record.getItemValue() != null) {
            SET("item_value = #{record.itemValue,jdbcType=VARCHAR}");
        }
        
        if (record.getCreateTime() != null) {
            SET("create_time = #{record.createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getUpdateTime() != null) {
            SET("update_time = #{record.updateTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getStartTime() != null) {
            SET("start_time = #{record.startTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getEndTime() != null) {
            SET("end_time = #{record.endTime,jdbcType=TIMESTAMP}");
        }
        
        applyWhere(example, true);
        return SQL();
    }

    public String updateByExample(Map<String, Object> parameter) {
        BEGIN();
        UPDATE("t_sub_order");
        
        SET("id = #{record.id,jdbcType=VARCHAR}");
        SET("order_id = #{record.orderId,jdbcType=VARCHAR}");
        SET("status = #{record.status,jdbcType=VARCHAR}");
        SET("item_id = #{record.itemId,jdbcType=VARCHAR}");
        SET("item_name = #{record.itemName,jdbcType=VARCHAR}");
        SET("item_type = #{record.itemType,jdbcType=VARCHAR}");
        SET("item_fee = #{record.itemFee,jdbcType=INTEGER}");
        SET("item_value = #{record.itemValue,jdbcType=VARCHAR}");
        SET("create_time = #{record.createTime,jdbcType=TIMESTAMP}");
        SET("update_time = #{record.updateTime,jdbcType=TIMESTAMP}");
        SET("start_time = #{record.startTime,jdbcType=TIMESTAMP}");
        SET("end_time = #{record.endTime,jdbcType=TIMESTAMP}");
        
        TSubOrderExample example = (TSubOrderExample) parameter.get("example");
        applyWhere(example, true);
        return SQL();
    }

    public String updateByPrimaryKeySelective(TSubOrder record) {
        BEGIN();
        UPDATE("t_sub_order");
        
        if (record.getOrderId() != null) {
            SET("order_id = #{orderId,jdbcType=VARCHAR}");
        }
        
        if (record.getStatus() != null) {
            SET("status = #{status,jdbcType=VARCHAR}");
        }
        
        if (record.getItemId() != null) {
            SET("item_id = #{itemId,jdbcType=VARCHAR}");
        }
        
        if (record.getItemName() != null) {
            SET("item_name = #{itemName,jdbcType=VARCHAR}");
        }
        
        if (record.getItemType() != null) {
            SET("item_type = #{itemType,jdbcType=VARCHAR}");
        }
        
        if (record.getItemFee() != null) {
            SET("item_fee = #{itemFee,jdbcType=INTEGER}");
        }
        
        if (record.getItemValue() != null) {
            SET("item_value = #{itemValue,jdbcType=VARCHAR}");
        }
        
        if (record.getCreateTime() != null) {
            SET("create_time = #{createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getUpdateTime() != null) {
            SET("update_time = #{updateTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getStartTime() != null) {
            SET("start_time = #{startTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getEndTime() != null) {
            SET("end_time = #{endTime,jdbcType=TIMESTAMP}");
        }
        
        WHERE("id = #{id,jdbcType=VARCHAR}");
        
        return SQL();
    }

    protected void applyWhere(TSubOrderExample example, boolean includeExamplePhrase) {
        if (example == null) {
            return;
        }
        
        String parmPhrase1;
        String parmPhrase1_th;
        String parmPhrase2;
        String parmPhrase2_th;
        String parmPhrase3;
        String parmPhrase3_th;
        if (includeExamplePhrase) {
            parmPhrase1 = "%s #{example.oredCriteria[%d].allCriteria[%d].value}";
            parmPhrase1_th = "%s #{example.oredCriteria[%d].allCriteria[%d].value,typeHandler=%s}";
            parmPhrase2 = "%s #{example.oredCriteria[%d].allCriteria[%d].value} and #{example.oredCriteria[%d].criteria[%d].secondValue}";
            parmPhrase2_th = "%s #{example.oredCriteria[%d].allCriteria[%d].value,typeHandler=%s} and #{example.oredCriteria[%d].criteria[%d].secondValue,typeHandler=%s}";
            parmPhrase3 = "#{example.oredCriteria[%d].allCriteria[%d].value[%d]}";
            parmPhrase3_th = "#{example.oredCriteria[%d].allCriteria[%d].value[%d],typeHandler=%s}";
        } else {
            parmPhrase1 = "%s #{oredCriteria[%d].allCriteria[%d].value}";
            parmPhrase1_th = "%s #{oredCriteria[%d].allCriteria[%d].value,typeHandler=%s}";
            parmPhrase2 = "%s #{oredCriteria[%d].allCriteria[%d].value} and #{oredCriteria[%d].criteria[%d].secondValue}";
            parmPhrase2_th = "%s #{oredCriteria[%d].allCriteria[%d].value,typeHandler=%s} and #{oredCriteria[%d].criteria[%d].secondValue,typeHandler=%s}";
            parmPhrase3 = "#{oredCriteria[%d].allCriteria[%d].value[%d]}";
            parmPhrase3_th = "#{oredCriteria[%d].allCriteria[%d].value[%d],typeHandler=%s}";
        }
        
        StringBuilder sb = new StringBuilder();
        List<Criteria> oredCriteria = example.getOredCriteria();
        boolean firstCriteria = true;
        for (int i = 0; i < oredCriteria.size(); i++) {
            Criteria criteria = oredCriteria.get(i);
            if (criteria.isValid()) {
                if (firstCriteria) {
                    firstCriteria = false;
                } else {
                    sb.append(" or ");
                }
                
                sb.append('(');
                List<Criterion> criterions = criteria.getAllCriteria();
                boolean firstCriterion = true;
                for (int j = 0; j < criterions.size(); j++) {
                    Criterion criterion = criterions.get(j);
                    if (firstCriterion) {
                        firstCriterion = false;
                    } else {
                        sb.append(" and ");
                    }
                    
                    if (criterion.isNoValue()) {
                        sb.append(criterion.getCondition());
                    } else if (criterion.isSingleValue()) {
                        if (criterion.getTypeHandler() == null) {
                            sb.append(String.format(parmPhrase1, criterion.getCondition(), i, j));
                        } else {
                            sb.append(String.format(parmPhrase1_th, criterion.getCondition(), i, j,criterion.getTypeHandler()));
                        }
                    } else if (criterion.isBetweenValue()) {
                        if (criterion.getTypeHandler() == null) {
                            sb.append(String.format(parmPhrase2, criterion.getCondition(), i, j, i, j));
                        } else {
                            sb.append(String.format(parmPhrase2_th, criterion.getCondition(), i, j, criterion.getTypeHandler(), i, j, criterion.getTypeHandler()));
                        }
                    } else if (criterion.isListValue()) {
                        sb.append(criterion.getCondition());
                        sb.append(" (");
                        List<?> listItems = (List<?>) criterion.getValue();
                        boolean comma = false;
                        for (int k = 0; k < listItems.size(); k++) {
                            if (comma) {
                                sb.append(", ");
                            } else {
                                comma = true;
                            }
                            if (criterion.getTypeHandler() == null) {
                                sb.append(String.format(parmPhrase3, i, j, k));
                            } else {
                                sb.append(String.format(parmPhrase3_th, i, j, k, criterion.getTypeHandler()));
                            }
                        }
                        sb.append(')');
                    }
                }
                sb.append(')');
            }
        }
        
        if (sb.length() > 0) {
            WHERE(sb.toString());
        }
    }
}