package com.fnic.mybatis.iot.dao;

import com.fnic.mybatis.iot.model.TCartSubItem;
import com.fnic.mybatis.iot.model.TCartSubItemExample;
import com.fnic.mybatis.iot.model.TCartSubItemExample.Criteria;
import com.fnic.mybatis.iot.model.TCartSubItemExample.Criterion;

import java.util.List;
import java.util.Map;

import static org.apache.ibatis.jdbc.SqlBuilder.*;

public class TCartSubItemSqlProvider {

    public String countByExample(TCartSubItemExample example) {
        BEGIN();
        SELECT("count(*)");
        FROM("t_cart_sub_item");
        applyWhere(example, false);
        return SQL();
    }

    public String deleteByExample(TCartSubItemExample example) {
        BEGIN();
        DELETE_FROM("t_cart_sub_item");
        applyWhere(example, false);
        return SQL();
    }

    public String insertSelective(TCartSubItem record) {
        BEGIN();
        INSERT_INTO("t_cart_sub_item");
        
        if (record.getId() != null) {
            VALUES("id", "#{id,jdbcType=INTEGER}");
        }
        
        if (record.getCartId() != null) {
            VALUES("cart_id", "#{cartId,jdbcType=INTEGER}");
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
        
        if (record.getPackageId() != null) {
            VALUES("package_id", "#{packageId,jdbcType=VARCHAR}");
        }
        
        return SQL();
    }

    public String selectByExample(TCartSubItemExample example) {
        BEGIN();
        if (example != null && example.isDistinct()) {
            SELECT_DISTINCT("id");
        } else {
            SELECT("id");
        }
        SELECT("cart_id");
        SELECT("item_id");
        SELECT("item_name");
        SELECT("item_type");
        SELECT("item_fee");
        SELECT("item_value");
        SELECT("package_id");
        FROM("t_cart_sub_item");
        applyWhere(example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            ORDER_BY(example.getOrderByClause());
        }
        
        return SQL();
    }

    public String updateByExampleSelective(Map<String, Object> parameter) {
        TCartSubItem record = (TCartSubItem) parameter.get("record");
        TCartSubItemExample example = (TCartSubItemExample) parameter.get("example");
        
        BEGIN();
        UPDATE("t_cart_sub_item");
        
        if (record.getId() != null) {
            SET("id = #{record.id,jdbcType=INTEGER}");
        }
        
        if (record.getCartId() != null) {
            SET("cart_id = #{record.cartId,jdbcType=INTEGER}");
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
        
        if (record.getPackageId() != null) {
            SET("package_id = #{record.packageId,jdbcType=VARCHAR}");
        }
        
        applyWhere(example, true);
        return SQL();
    }

    public String updateByExample(Map<String, Object> parameter) {
        BEGIN();
        UPDATE("t_cart_sub_item");
        
        SET("id = #{record.id,jdbcType=INTEGER}");
        SET("cart_id = #{record.cartId,jdbcType=INTEGER}");
        SET("item_id = #{record.itemId,jdbcType=VARCHAR}");
        SET("item_name = #{record.itemName,jdbcType=VARCHAR}");
        SET("item_type = #{record.itemType,jdbcType=VARCHAR}");
        SET("item_fee = #{record.itemFee,jdbcType=INTEGER}");
        SET("item_value = #{record.itemValue,jdbcType=VARCHAR}");
        SET("package_id = #{record.packageId,jdbcType=VARCHAR}");
        
        TCartSubItemExample example = (TCartSubItemExample) parameter.get("example");
        applyWhere(example, true);
        return SQL();
    }

    public String updateByPrimaryKeySelective(TCartSubItem record) {
        BEGIN();
        UPDATE("t_cart_sub_item");
        
        if (record.getCartId() != null) {
            SET("cart_id = #{cartId,jdbcType=INTEGER}");
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
        
        if (record.getPackageId() != null) {
            SET("package_id = #{packageId,jdbcType=VARCHAR}");
        }
        
        WHERE("id = #{id,jdbcType=INTEGER}");
        
        return SQL();
    }

    protected void applyWhere(TCartSubItemExample example, boolean includeExamplePhrase) {
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