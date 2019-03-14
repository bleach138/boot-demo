package com.fnic.mybatis.iot.dao;

import com.fnic.mybatis.iot.model.TProductComb;
import com.fnic.mybatis.iot.model.TProductCombExample;
import com.fnic.mybatis.iot.model.TProductCombExample.Criteria;
import com.fnic.mybatis.iot.model.TProductCombExample.Criterion;

import java.util.List;
import java.util.Map;

import static org.apache.ibatis.jdbc.SqlBuilder.*;

public class TProductCombSqlProvider {

    public String countByExample(TProductCombExample example) {
        BEGIN();
        SELECT("count(*)");
        FROM("t_product_comb");
        applyWhere(example, false);
        return SQL();
    }

    public String deleteByExample(TProductCombExample example) {
        BEGIN();
        DELETE_FROM("t_product_comb");
        applyWhere(example, false);
        return SQL();
    }

    public String insertSelective(TProductComb record) {
        BEGIN();
        INSERT_INTO("t_product_comb");
        
        if (record.getId() != null) {
            VALUES("id", "#{id,jdbcType=VARCHAR}");
        }
        
        if (record.getCombId() != null) {
            VALUES("comb_id", "#{combId,jdbcType=VARCHAR}");
        }
        
        if (record.getCombType() != null) {
            VALUES("comb_type", "#{combType,jdbcType=VARCHAR}");
        }
        
        if (record.getItemId() != null) {
            VALUES("item_id", "#{itemId,jdbcType=VARCHAR}");
        }
        
        if (record.getItemType() != null) {
            VALUES("item_type", "#{itemType,jdbcType=VARCHAR}");
        }
        
        if (record.getPrice() != null) {
            VALUES("price", "#{price,jdbcType=INTEGER}");
        }
        
        if (record.getShowOrder() != null) {
            VALUES("show_order", "#{showOrder,jdbcType=INTEGER}");
        }
        
        return SQL();
    }

    public String selectByExample(TProductCombExample example) {
        BEGIN();
        if (example != null && example.isDistinct()) {
            SELECT_DISTINCT("id");
        } else {
            SELECT("id");
        }
        SELECT("comb_id");
        SELECT("comb_type");
        SELECT("item_id");
        SELECT("item_type");
        SELECT("price");
        SELECT("show_order");
        SELECT("(select product_name from t_product where product_id = item_id) product_name");
        SELECT("(select product_item_name from t_product_item where product_item_id = item_id) product_item_name");
        SELECT("(select icon from t_product where product_id = item_id) product_icon");
        SELECT("(select product_desc from t_product where product_id = item_id) product_desc");
        FROM("t_product_comb");
        applyWhere(example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            ORDER_BY(example.getOrderByClause());
        }
        
        return SQL();
    }

    public String updateByExampleSelective(Map<String, Object> parameter) {
        TProductComb record = (TProductComb) parameter.get("record");
        TProductCombExample example = (TProductCombExample) parameter.get("example");
        
        BEGIN();
        UPDATE("t_product_comb");
        
        if (record.getId() != null) {
            SET("id = #{record.id,jdbcType=VARCHAR}");
        }
        
        if (record.getCombId() != null) {
            SET("comb_id = #{record.combId,jdbcType=VARCHAR}");
        }
        
        if (record.getCombType() != null) {
            SET("comb_type = #{record.combType,jdbcType=VARCHAR}");
        }
        
        if (record.getItemId() != null) {
            SET("item_id = #{record.itemId,jdbcType=VARCHAR}");
        }
        
        if (record.getItemType() != null) {
            SET("item_type = #{record.itemType,jdbcType=VARCHAR}");
        }
        
        if (record.getPrice() != null) {
            SET("price = #{record.price,jdbcType=INTEGER}");
        }
        
        if (record.getShowOrder() != null) {
            SET("show_order = #{record.showOrder,jdbcType=INTEGER}");
        }
        
        applyWhere(example, true);
        return SQL();
    }

    public String updateByExample(Map<String, Object> parameter) {
        BEGIN();
        UPDATE("t_product_comb");
        
        SET("id = #{record.id,jdbcType=VARCHAR}");
        SET("comb_id = #{record.combId,jdbcType=VARCHAR}");
        SET("comb_type = #{record.combType,jdbcType=VARCHAR}");
        SET("item_id = #{record.itemId,jdbcType=VARCHAR}");
        SET("item_type = #{record.itemType,jdbcType=VARCHAR}");
        SET("price = #{record.price,jdbcType=INTEGER}");
        SET("show_order = #{record.showOrder,jdbcType=INTEGER}");
        
        TProductCombExample example = (TProductCombExample) parameter.get("example");
        applyWhere(example, true);
        return SQL();
    }

    public String updateByPrimaryKeySelective(TProductComb record) {
        BEGIN();
        UPDATE("t_product_comb");
        
        if (record.getCombId() != null) {
            SET("comb_id = #{combId,jdbcType=VARCHAR}");
        }
        
        if (record.getCombType() != null) {
            SET("comb_type = #{combType,jdbcType=VARCHAR}");
        }
        
        if (record.getItemId() != null) {
            SET("item_id = #{itemId,jdbcType=VARCHAR}");
        }
        
        if (record.getItemType() != null) {
            SET("item_type = #{itemType,jdbcType=VARCHAR}");
        }
        
        if (record.getPrice() != null) {
            SET("price = #{price,jdbcType=INTEGER}");
        }
        
        if (record.getShowOrder() != null) {
            SET("show_order = #{showOrder,jdbcType=INTEGER}");
        }
        
        WHERE("id = #{id,jdbcType=VARCHAR}");
        
        return SQL();
    }

    protected void applyWhere(TProductCombExample example, boolean includeExamplePhrase) {
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