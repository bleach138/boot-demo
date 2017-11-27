package com.fnic.mybatis.dao;

import com.fnic.mybatis.model.TOrder;
import com.fnic.mybatis.model.TOrderExample;
import com.fnic.mybatis.model.TOrderExample.Criteria;
import com.fnic.mybatis.model.TOrderExample.Criterion;

import java.util.List;
import java.util.Map;

import static org.apache.ibatis.jdbc.SqlBuilder.*;

public class TOrderSqlProvider {

    public String countByExample(TOrderExample example) {
        BEGIN();
        SELECT("count(*)");
        FROM("t_order");
        applyWhere(example, false);
        return SQL();
    }

    public String deleteByExample(TOrderExample example) {
        BEGIN();
        DELETE_FROM("t_order");
        applyWhere(example, false);
        return SQL();
    }

    public String insertSelective(TOrder record) {
        BEGIN();
        INSERT_INTO("t_order");
        
        if (record.getId() != null) {
            VALUES("id", "#{id,jdbcType=VARCHAR}");
        }
        
        if (record.getStatus() != null) {
            VALUES("status", "#{status,jdbcType=VARCHAR}");
        }
        
        if (record.getSubject() != null) {
            VALUES("subject", "#{subject,jdbcType=VARCHAR}");
        }
        
        if (record.getAccountId() != null) {
            VALUES("account_id", "#{accountId,jdbcType=VARCHAR}");
        }
        
        if (record.getOperUserId() != null) {
            VALUES("oper_user_id", "#{operUserId,jdbcType=INTEGER}");
        }
        
        if (record.getCreateTime() != null) {
            VALUES("create_time", "#{createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getUpdateTime() != null) {
            VALUES("update_time", "#{updateTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getTotalFee() != null) {
            VALUES("total_fee", "#{totalFee,jdbcType=INTEGER}");
        }
        
        if (record.getUserGroupId() != null) {
            VALUES("user_group_id", "#{userGroupId,jdbcType=VARCHAR}");
        }
        
        if (record.getRemark() != null) {
            VALUES("remark", "#{remark,jdbcType=VARCHAR}");
        }
        
        return SQL();
    }

    public String selectByExample(TOrderExample example) {
        BEGIN();
        if (example != null && example.isDistinct()) {
            SELECT_DISTINCT("id");
        } else {
            SELECT("id");
        }
        SELECT("status");
        SELECT("subject");
        SELECT("account_id");
        SELECT("oper_user_id");
        SELECT("create_time");
        SELECT("update_time");
        SELECT("total_fee");
        SELECT("user_group_id");
        SELECT("remark");
        FROM("t_order");
        applyWhere(example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            ORDER_BY(example.getOrderByClause());
        }
        
        return SQL();
    }

    public String updateByExampleSelective(Map<String, Object> parameter) {
        TOrder record = (TOrder) parameter.get("record");
        TOrderExample example = (TOrderExample) parameter.get("example");
        
        BEGIN();
        UPDATE("t_order");
        
        if (record.getId() != null) {
            SET("id = #{record.id,jdbcType=VARCHAR}");
        }
        
        if (record.getStatus() != null) {
            SET("status = #{record.status,jdbcType=VARCHAR}");
        }
        
        if (record.getSubject() != null) {
            SET("subject = #{record.subject,jdbcType=VARCHAR}");
        }
        
        if (record.getAccountId() != null) {
            SET("account_id = #{record.accountId,jdbcType=VARCHAR}");
        }
        
        if (record.getOperUserId() != null) {
            SET("oper_user_id = #{record.operUserId,jdbcType=INTEGER}");
        }
        
        if (record.getCreateTime() != null) {
            SET("create_time = #{record.createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getUpdateTime() != null) {
            SET("update_time = #{record.updateTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getTotalFee() != null) {
            SET("total_fee = #{record.totalFee,jdbcType=INTEGER}");
        }
        
        if (record.getUserGroupId() != null) {
            SET("user_group_id = #{record.userGroupId,jdbcType=VARCHAR}");
        }
        
        if (record.getRemark() != null) {
            SET("remark = #{record.remark,jdbcType=VARCHAR}");
        }
        
        applyWhere(example, true);
        return SQL();
    }

    public String updateByExample(Map<String, Object> parameter) {
        BEGIN();
        UPDATE("t_order");
        
        SET("id = #{record.id,jdbcType=VARCHAR}");
        SET("status = #{record.status,jdbcType=VARCHAR}");
        SET("subject = #{record.subject,jdbcType=VARCHAR}");
        SET("account_id = #{record.accountId,jdbcType=VARCHAR}");
        SET("oper_user_id = #{record.operUserId,jdbcType=INTEGER}");
        SET("create_time = #{record.createTime,jdbcType=TIMESTAMP}");
        SET("update_time = #{record.updateTime,jdbcType=TIMESTAMP}");
        SET("total_fee = #{record.totalFee,jdbcType=INTEGER}");
        SET("user_group_id = #{record.userGroupId,jdbcType=VARCHAR}");
        SET("remark = #{record.remark,jdbcType=VARCHAR}");
        
        TOrderExample example = (TOrderExample) parameter.get("example");
        applyWhere(example, true);
        return SQL();
    }

    public String updateByPrimaryKeySelective(TOrder record) {
        BEGIN();
        UPDATE("t_order");
        
        if (record.getStatus() != null) {
            SET("status = #{status,jdbcType=VARCHAR}");
        }
        
        if (record.getSubject() != null) {
            SET("subject = #{subject,jdbcType=VARCHAR}");
        }
        
        if (record.getAccountId() != null) {
            SET("account_id = #{accountId,jdbcType=VARCHAR}");
        }
        
        if (record.getOperUserId() != null) {
            SET("oper_user_id = #{operUserId,jdbcType=INTEGER}");
        }
        
        if (record.getCreateTime() != null) {
            SET("create_time = #{createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getUpdateTime() != null) {
            SET("update_time = #{updateTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getTotalFee() != null) {
            SET("total_fee = #{totalFee,jdbcType=INTEGER}");
        }
        
        if (record.getUserGroupId() != null) {
            SET("user_group_id = #{userGroupId,jdbcType=VARCHAR}");
        }
        
        if (record.getRemark() != null) {
            SET("remark = #{remark,jdbcType=VARCHAR}");
        }
        
        WHERE("id = #{id,jdbcType=VARCHAR}");
        
        return SQL();
    }

    protected void applyWhere(TOrderExample example, boolean includeExamplePhrase) {
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