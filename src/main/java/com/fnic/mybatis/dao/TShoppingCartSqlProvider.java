package com.fnic.mybatis.dao;

import com.fnic.mybatis.model.TShoppingCart;
import com.fnic.mybatis.model.TShoppingCartExample;
import com.fnic.mybatis.model.TShoppingCartExample.Criteria;
import com.fnic.mybatis.model.TShoppingCartExample.Criterion;

import java.util.List;
import java.util.Map;

import static org.apache.ibatis.jdbc.SqlBuilder.*;

public class TShoppingCartSqlProvider {

    public String countByExample(TShoppingCartExample example) {
        BEGIN();
        SELECT("count(*)");
        FROM("t_shopping_cart");
        applyWhere(example, false);
        return SQL();
    }

    public String deleteByExample(TShoppingCartExample example) {
        BEGIN();
        DELETE_FROM("t_shopping_cart");
        applyWhere(example, false);
        return SQL();
    }

    public String insertSelective(TShoppingCart record) {
        BEGIN();
        INSERT_INTO("t_shopping_cart");
        
        if (record.getId() != null) {
            VALUES("id", "#{id,jdbcType=INTEGER}");
        }
        
        if (record.getGoodsId() != null) {
            VALUES("goods_id", "#{goodsId,jdbcType=VARCHAR}");
        }
        
        if (record.getGoodsName() != null) {
            VALUES("goods_name", "#{goodsName,jdbcType=VARCHAR}");
        }
        
        if (record.getOperUserId() != null) {
            VALUES("oper_user_id", "#{operUserId,jdbcType=INTEGER}");
        }
        
        if (record.getAccountId() != null) {
            VALUES("account_id", "#{accountId,jdbcType=VARCHAR}");
        }
        
        if (record.getUserGroupId() != null) {
            VALUES("user_group_id", "#{userGroupId,jdbcType=VARCHAR}");
        }
        
        if (record.getGoodsNum() != null) {
            VALUES("goods_num", "#{goodsNum,jdbcType=INTEGER}");
        }
        
        if (record.getStartTime() != null) {
            VALUES("start_time", "#{startTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getEndTime() != null) {
            VALUES("end_time", "#{endTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getGoodsSum() != null) {
            VALUES("goods_sum", "#{goodsSum,jdbcType=INTEGER}");
        }
        
        if (record.getOperType() != null) {
            VALUES("oper_type", "#{operType,jdbcType=VARCHAR}");
        }
        
        if (record.getUpdateTime() != null) {
            VALUES("update_time", "#{updateTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getCreateTime() != null) {
            VALUES("create_time", "#{createTime,jdbcType=TIMESTAMP}");
        }
        
        return SQL();
    }

    public String selectByExample(TShoppingCartExample example) {
        BEGIN();
        if (example != null && example.isDistinct()) {
            SELECT_DISTINCT("id");
        } else {
            SELECT("id");
        }
        SELECT("goods_id");
        SELECT("goods_name");
        SELECT("oper_user_id");
        SELECT("account_id");
        SELECT("user_group_id");
        SELECT("goods_num");
        SELECT("start_time");
        SELECT("end_time");
        SELECT("goods_sum");
        SELECT("oper_type");
        SELECT("update_time");
        SELECT("create_time");
        FROM("t_shopping_cart");
        applyWhere(example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            ORDER_BY(example.getOrderByClause());
        }
        
        return SQL();
    }

    public String updateByExampleSelective(Map<String, Object> parameter) {
        TShoppingCart record = (TShoppingCart) parameter.get("record");
        TShoppingCartExample example = (TShoppingCartExample) parameter.get("example");
        
        BEGIN();
        UPDATE("t_shopping_cart");
        
        if (record.getId() != null) {
            SET("id = #{record.id,jdbcType=INTEGER}");
        }
        
        if (record.getGoodsId() != null) {
            SET("goods_id = #{record.goodsId,jdbcType=VARCHAR}");
        }
        
        if (record.getGoodsName() != null) {
            SET("goods_name = #{record.goodsName,jdbcType=VARCHAR}");
        }
        
        if (record.getOperUserId() != null) {
            SET("oper_user_id = #{record.operUserId,jdbcType=INTEGER}");
        }
        
        if (record.getAccountId() != null) {
            SET("account_id = #{record.accountId,jdbcType=VARCHAR}");
        }
        
        if (record.getUserGroupId() != null) {
            SET("user_group_id = #{record.userGroupId,jdbcType=VARCHAR}");
        }
        
        if (record.getGoodsNum() != null) {
            SET("goods_num = #{record.goodsNum,jdbcType=INTEGER}");
        }
        
        if (record.getStartTime() != null) {
            SET("start_time = #{record.startTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getEndTime() != null) {
            SET("end_time = #{record.endTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getGoodsSum() != null) {
            SET("goods_sum = #{record.goodsSum,jdbcType=INTEGER}");
        }
        
        if (record.getOperType() != null) {
            SET("oper_type = #{record.operType,jdbcType=VARCHAR}");
        }
        
        if (record.getUpdateTime() != null) {
            SET("update_time = #{record.updateTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getCreateTime() != null) {
            SET("create_time = #{record.createTime,jdbcType=TIMESTAMP}");
        }
        
        applyWhere(example, true);
        return SQL();
    }

    public String updateByExample(Map<String, Object> parameter) {
        BEGIN();
        UPDATE("t_shopping_cart");
        
        SET("id = #{record.id,jdbcType=INTEGER}");
        SET("goods_id = #{record.goodsId,jdbcType=VARCHAR}");
        SET("goods_name = #{record.goodsName,jdbcType=VARCHAR}");
        SET("oper_user_id = #{record.operUserId,jdbcType=INTEGER}");
        SET("account_id = #{record.accountId,jdbcType=VARCHAR}");
        SET("user_group_id = #{record.userGroupId,jdbcType=VARCHAR}");
        SET("goods_num = #{record.goodsNum,jdbcType=INTEGER}");
        SET("start_time = #{record.startTime,jdbcType=TIMESTAMP}");
        SET("end_time = #{record.endTime,jdbcType=TIMESTAMP}");
        SET("goods_sum = #{record.goodsSum,jdbcType=INTEGER}");
        SET("oper_type = #{record.operType,jdbcType=VARCHAR}");
        SET("update_time = #{record.updateTime,jdbcType=TIMESTAMP}");
        SET("create_time = #{record.createTime,jdbcType=TIMESTAMP}");
        
        TShoppingCartExample example = (TShoppingCartExample) parameter.get("example");
        applyWhere(example, true);
        return SQL();
    }

    public String updateByPrimaryKeySelective(TShoppingCart record) {
        BEGIN();
        UPDATE("t_shopping_cart");
        
        if (record.getGoodsId() != null) {
            SET("goods_id = #{goodsId,jdbcType=VARCHAR}");
        }
        
        if (record.getGoodsName() != null) {
            SET("goods_name = #{goodsName,jdbcType=VARCHAR}");
        }
        
        if (record.getOperUserId() != null) {
            SET("oper_user_id = #{operUserId,jdbcType=INTEGER}");
        }
        
        if (record.getAccountId() != null) {
            SET("account_id = #{accountId,jdbcType=VARCHAR}");
        }
        
        if (record.getUserGroupId() != null) {
            SET("user_group_id = #{userGroupId,jdbcType=VARCHAR}");
        }
        
        if (record.getGoodsNum() != null) {
            SET("goods_num = #{goodsNum,jdbcType=INTEGER}");
        }
        
        if (record.getStartTime() != null) {
            SET("start_time = #{startTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getEndTime() != null) {
            SET("end_time = #{endTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getGoodsSum() != null) {
            SET("goods_sum = #{goodsSum,jdbcType=INTEGER}");
        }
        
        if (record.getOperType() != null) {
            SET("oper_type = #{operType,jdbcType=VARCHAR}");
        }
        
        if (record.getUpdateTime() != null) {
            SET("update_time = #{updateTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getCreateTime() != null) {
            SET("create_time = #{createTime,jdbcType=TIMESTAMP}");
        }
        
        WHERE("id = #{id,jdbcType=INTEGER}");
        
        return SQL();
    }

    protected void applyWhere(TShoppingCartExample example, boolean includeExamplePhrase) {
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