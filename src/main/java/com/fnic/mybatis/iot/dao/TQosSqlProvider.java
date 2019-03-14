package com.fnic.mybatis.iot.dao;

import com.fnic.mybatis.iot.model.TQos;
import com.fnic.mybatis.iot.model.TQosExample;
import com.fnic.mybatis.iot.model.TQosExample.Criteria;
import com.fnic.mybatis.iot.model.TQosExample.Criterion;

import java.util.List;
import java.util.Map;

import static org.apache.ibatis.jdbc.SqlBuilder.*;

public class TQosSqlProvider {

    public String countByExample(TQosExample example) {
        BEGIN();
        SELECT("count(*)");
        FROM("t_qos");
        applyWhere(example, false);
        return SQL();
    }

    public String deleteByExample(TQosExample example) {
        BEGIN();
        DELETE_FROM("t_qos");
        applyWhere(example, false);
        return SQL();
    }

    public String insertSelective(TQos record) {
        BEGIN();
        INSERT_INTO("t_qos");
        
        if (record.getId() != null) {
            VALUES("id", "#{id,jdbcType=INTEGER}");
        }
        
        if (record.getQosPriority() != null) {
            VALUES("qos_priority", "#{qosPriority,jdbcType=INTEGER}");
        }
        
        if (record.getQosName() != null) {
            VALUES("qos_name", "#{qosName,jdbcType=VARCHAR}");
        }
        
        if (record.getQosCode() != null) {
            VALUES("qos_code", "#{qosCode,jdbcType=VARCHAR}");
        }
        
        if (record.getDefaultRate() != null) {
            VALUES("default_rate", "#{defaultRate,jdbcType=INTEGER}");
        }
        
        if (record.getMaxRate() != null) {
            VALUES("max_rate", "#{maxRate,jdbcType=INTEGER}");
        }
        
        if (record.getAccountId() != null) {
            VALUES("account_id", "#{accountId,jdbcType=VARCHAR}");
        }
        
        if (record.getUserGroupId() != null) {
            VALUES("user_group_id", "#{userGroupId,jdbcType=VARCHAR}");
        }
        
        if (record.getCreateTime() != null) {
            VALUES("create_time", "#{createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getUpdateTime() != null) {
            VALUES("update_time", "#{updateTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getOperUserId() != null) {
            VALUES("oper_user_id", "#{operUserId,jdbcType=INTEGER}");
        }
        
        return SQL();
    }

    public String selectByExample(TQosExample example) {
        BEGIN();
        if (example != null && example.isDistinct()) {
            SELECT_DISTINCT("id");
        } else {
            SELECT("id");
        }
        SELECT("qos_priority");
        SELECT("qos_name");
        SELECT("qos_code");
        SELECT("default_rate");
        SELECT("max_rate");
        SELECT("account_id");
        SELECT("user_group_id");
        SELECT("create_time");
        SELECT("update_time");
        SELECT("oper_user_id");
        FROM("t_qos");
        applyWhere(example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            ORDER_BY(example.getOrderByClause());
        }
        
        return SQL();
    }

    public String updateByExampleSelective(Map<String, Object> parameter) {
        TQos record = (TQos) parameter.get("record");
        TQosExample example = (TQosExample) parameter.get("example");
        
        BEGIN();
        UPDATE("t_qos");
        
        if (record.getId() != null) {
            SET("id = #{record.id,jdbcType=INTEGER}");
        }
        
        if (record.getQosPriority() != null) {
            SET("qos_priority = #{record.qosPriority,jdbcType=INTEGER}");
        }
        
        if (record.getQosName() != null) {
            SET("qos_name = #{record.qosName,jdbcType=VARCHAR}");
        }
        
        if (record.getQosCode() != null) {
            SET("qos_code = #{record.qosCode,jdbcType=VARCHAR}");
        }
        
        if (record.getDefaultRate() != null) {
            SET("default_rate = #{record.defaultRate,jdbcType=INTEGER}");
        }
        
        if (record.getMaxRate() != null) {
            SET("max_rate = #{record.maxRate,jdbcType=INTEGER}");
        }
        
        if (record.getAccountId() != null) {
            SET("account_id = #{record.accountId,jdbcType=VARCHAR}");
        }
        
        if (record.getUserGroupId() != null) {
            SET("user_group_id = #{record.userGroupId,jdbcType=VARCHAR}");
        }
        
        if (record.getCreateTime() != null) {
            SET("create_time = #{record.createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getUpdateTime() != null) {
            SET("update_time = #{record.updateTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getOperUserId() != null) {
            SET("oper_user_id = #{record.operUserId,jdbcType=INTEGER}");
        }
        
        applyWhere(example, true);
        return SQL();
    }

    public String updateByExample(Map<String, Object> parameter) {
        BEGIN();
        UPDATE("t_qos");
        
        SET("id = #{record.id,jdbcType=INTEGER}");
        SET("qos_priority = #{record.qosPriority,jdbcType=INTEGER}");
        SET("qos_name = #{record.qosName,jdbcType=VARCHAR}");
        SET("qos_code = #{record.qosCode,jdbcType=VARCHAR}");
        SET("default_rate = #{record.defaultRate,jdbcType=INTEGER}");
        SET("max_rate = #{record.maxRate,jdbcType=INTEGER}");
        SET("account_id = #{record.accountId,jdbcType=VARCHAR}");
        SET("user_group_id = #{record.userGroupId,jdbcType=VARCHAR}");
        SET("create_time = #{record.createTime,jdbcType=TIMESTAMP}");
        SET("update_time = #{record.updateTime,jdbcType=TIMESTAMP}");
        SET("oper_user_id = #{record.operUserId,jdbcType=INTEGER}");
        
        TQosExample example = (TQosExample) parameter.get("example");
        applyWhere(example, true);
        return SQL();
    }

    public String updateByPrimaryKeySelective(TQos record) {
        BEGIN();
        UPDATE("t_qos");
        
        if (record.getQosPriority() != null) {
            SET("qos_priority = #{qosPriority,jdbcType=INTEGER}");
        }
        
        if (record.getQosName() != null) {
            SET("qos_name = #{qosName,jdbcType=VARCHAR}");
        }
        
        if (record.getQosCode() != null) {
            SET("qos_code = #{qosCode,jdbcType=VARCHAR}");
        }
        
        if (record.getDefaultRate() != null) {
            SET("default_rate = #{defaultRate,jdbcType=INTEGER}");
        }
        
        if (record.getMaxRate() != null) {
            SET("max_rate = #{maxRate,jdbcType=INTEGER}");
        }
        
        if (record.getAccountId() != null) {
            SET("account_id = #{accountId,jdbcType=VARCHAR}");
        }
        
        if (record.getUserGroupId() != null) {
            SET("user_group_id = #{userGroupId,jdbcType=VARCHAR}");
        }
        
        if (record.getCreateTime() != null) {
            SET("create_time = #{createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getUpdateTime() != null) {
            SET("update_time = #{updateTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getOperUserId() != null) {
            SET("oper_user_id = #{operUserId,jdbcType=INTEGER}");
        }
        
        WHERE("id = #{id,jdbcType=INTEGER}");
        
        return SQL();
    }

    protected void applyWhere(TQosExample example, boolean includeExamplePhrase) {
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