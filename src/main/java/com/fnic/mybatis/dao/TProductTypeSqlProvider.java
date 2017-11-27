package com.fnic.mybatis.dao;

import com.fnic.mybatis.model.TProductType;
import com.fnic.mybatis.model.TProductTypeExample;
import com.fnic.mybatis.model.TProductTypeExample.Criteria;
import com.fnic.mybatis.model.TProductTypeExample.Criterion;

import java.util.List;
import java.util.Map;

import static org.apache.ibatis.jdbc.SqlBuilder.*;

public class TProductTypeSqlProvider {

    public String countByExample(TProductTypeExample example) {
        BEGIN();
        SELECT("count(*)");
        FROM("t_product_type");
        applyWhere(example, false);
        return SQL();
    }

    public String deleteByExample(TProductTypeExample example) {
        BEGIN();
        DELETE_FROM("t_product_type");
        applyWhere(example, false);
        return SQL();
    }

    public String insertSelective(TProductType record) {
        BEGIN();
        INSERT_INTO("t_product_type");
        
        if (record.getProductTypeId() != null) {
            VALUES("product_type_id", "#{productTypeId,jdbcType=VARCHAR}");
        }
        
        if (record.getProductTypeName() != null) {
            VALUES("product_type_name", "#{productTypeName,jdbcType=VARCHAR}");
        }
        
        if (record.getShowOrder() != null) {
            VALUES("show_order", "#{showOrder,jdbcType=INTEGER}");
        }
        
        return SQL();
    }

    public String selectByExample(TProductTypeExample example) {
        BEGIN();
        if (example != null && example.isDistinct()) {
            SELECT_DISTINCT("product_type_id");
        } else {
            SELECT("product_type_id");
        }
        SELECT("product_type_name");
        SELECT("show_order");
        FROM("t_product_type");
        applyWhere(example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            ORDER_BY(example.getOrderByClause());
        }
        
        return SQL();
    }

    public String updateByExampleSelective(Map<String, Object> parameter) {
        TProductType record = (TProductType) parameter.get("record");
        TProductTypeExample example = (TProductTypeExample) parameter.get("example");
        
        BEGIN();
        UPDATE("t_product_type");
        
        if (record.getProductTypeId() != null) {
            SET("product_type_id = #{record.productTypeId,jdbcType=VARCHAR}");
        }
        
        if (record.getProductTypeName() != null) {
            SET("product_type_name = #{record.productTypeName,jdbcType=VARCHAR}");
        }
        
        if (record.getShowOrder() != null) {
            SET("show_order = #{record.showOrder,jdbcType=INTEGER}");
        }
        
        applyWhere(example, true);
        return SQL();
    }

    public String updateByExample(Map<String, Object> parameter) {
        BEGIN();
        UPDATE("t_product_type");
        
        SET("product_type_id = #{record.productTypeId,jdbcType=VARCHAR}");
        SET("product_type_name = #{record.productTypeName,jdbcType=VARCHAR}");
        SET("show_order = #{record.showOrder,jdbcType=INTEGER}");
        
        TProductTypeExample example = (TProductTypeExample) parameter.get("example");
        applyWhere(example, true);
        return SQL();
    }

    public String updateByPrimaryKeySelective(TProductType record) {
        BEGIN();
        UPDATE("t_product_type");
        
        if (record.getProductTypeName() != null) {
            SET("product_type_name = #{productTypeName,jdbcType=VARCHAR}");
        }
        
        if (record.getShowOrder() != null) {
            SET("show_order = #{showOrder,jdbcType=INTEGER}");
        }
        
        WHERE("product_type_id = #{productTypeId,jdbcType=VARCHAR}");
        
        return SQL();
    }

    protected void applyWhere(TProductTypeExample example, boolean includeExamplePhrase) {
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