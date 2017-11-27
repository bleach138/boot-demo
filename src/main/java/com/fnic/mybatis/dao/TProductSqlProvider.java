package com.fnic.mybatis.dao;

import com.fnic.mybatis.model.TProduct;
import com.fnic.mybatis.model.TProductExample;
import com.fnic.mybatis.model.TProductExample.Criteria;
import com.fnic.mybatis.model.TProductExample.Criterion;

import java.util.List;
import java.util.Map;

import static org.apache.ibatis.jdbc.SqlBuilder.*;

public class TProductSqlProvider {

    public String countByExample(TProductExample example) {
        BEGIN();
        SELECT("count(*)");
        FROM("t_product");
        applyWhere(example, false);
        return SQL();
    }

    public String deleteByExample(TProductExample example) {
        BEGIN();
        DELETE_FROM("t_product");
        applyWhere(example, false);
        return SQL();
    }

    public String insertSelective(TProduct record) {
        BEGIN();
        INSERT_INTO("t_product");
        
        if (record.getProductId() != null) {
            VALUES("product_id", "#{productId,jdbcType=VARCHAR}");
        }
        
        if (record.getProductName() != null) {
            VALUES("product_name", "#{productName,jdbcType=VARCHAR}");
        }
        
        if (record.getIcon() != null) {
            VALUES("icon", "#{icon,jdbcType=VARCHAR}");
        }
        
        if (record.getDesc() != null) {
            VALUES("desc", "#{desc,jdbcType=VARCHAR}");
        }
        
        return SQL();
    }

    public String selectByExample(TProductExample example) {
        BEGIN();
        if (example != null && example.isDistinct()) {
            SELECT_DISTINCT("product_id");
        } else {
            SELECT("product_id");
        }
        SELECT("product_name");
        SELECT("icon");
        SELECT("desc");
        FROM("t_product");
        applyWhere(example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            ORDER_BY(example.getOrderByClause());
        }
        
        return SQL();
    }

    public String updateByExampleSelective(Map<String, Object> parameter) {
        TProduct record = (TProduct) parameter.get("record");
        TProductExample example = (TProductExample) parameter.get("example");
        
        BEGIN();
        UPDATE("t_product");
        
        if (record.getProductId() != null) {
            SET("product_id = #{record.productId,jdbcType=VARCHAR}");
        }
        
        if (record.getProductName() != null) {
            SET("product_name = #{record.productName,jdbcType=VARCHAR}");
        }
        
        if (record.getIcon() != null) {
            SET("icon = #{record.icon,jdbcType=VARCHAR}");
        }
        
        if (record.getDesc() != null) {
            SET("desc = #{record.desc,jdbcType=VARCHAR}");
        }
        
        applyWhere(example, true);
        return SQL();
    }

    public String updateByExample(Map<String, Object> parameter) {
        BEGIN();
        UPDATE("t_product");
        
        SET("product_id = #{record.productId,jdbcType=VARCHAR}");
        SET("product_name = #{record.productName,jdbcType=VARCHAR}");
        SET("icon = #{record.icon,jdbcType=VARCHAR}");
        SET("desc = #{record.desc,jdbcType=VARCHAR}");
        
        TProductExample example = (TProductExample) parameter.get("example");
        applyWhere(example, true);
        return SQL();
    }

    public String updateByPrimaryKeySelective(TProduct record) {
        BEGIN();
        UPDATE("t_product");
        
        if (record.getProductName() != null) {
            SET("product_name = #{productName,jdbcType=VARCHAR}");
        }
        
        if (record.getIcon() != null) {
            SET("icon = #{icon,jdbcType=VARCHAR}");
        }
        
        if (record.getDesc() != null) {
            SET("desc = #{desc,jdbcType=VARCHAR}");
        }
        
        WHERE("product_id = #{productId,jdbcType=VARCHAR}");
        
        return SQL();
    }

    protected void applyWhere(TProductExample example, boolean includeExamplePhrase) {
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