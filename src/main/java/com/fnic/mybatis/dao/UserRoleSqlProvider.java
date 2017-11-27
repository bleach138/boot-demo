package com.fnic.mybatis.dao;

import com.fnic.mybatis.model.UserRole;
import com.fnic.mybatis.model.UserRoleExample;
import com.fnic.mybatis.model.UserRoleExample.Criteria;
import com.fnic.mybatis.model.UserRoleExample.Criterion;

import java.util.List;
import java.util.Map;

import static org.apache.ibatis.jdbc.SqlBuilder.*;

public class UserRoleSqlProvider {

    public String countByExample(UserRoleExample example) {
        BEGIN();
        SELECT("count(*)");
        FROM("user_role");
        applyWhere(example, false);
        return SQL();
    }

    public String deleteByExample(UserRoleExample example) {
        BEGIN();
        DELETE_FROM("user_role");
        applyWhere(example, false);
        return SQL();
    }

    public String insertSelective(UserRole record) {
        BEGIN();
        INSERT_INTO("user_role");
        
        if (record.getUserId() != null) {
            VALUES("user_id", "#{userId,jdbcType=INTEGER}");
        }
        
        if (record.getRoleId() != null) {
            VALUES("role_id", "#{roleId,jdbcType=INTEGER}");
        }
        
        return SQL();
    }

    public String selectByExample(UserRoleExample example) {
        BEGIN();
        if (example != null && example.isDistinct()) {
            SELECT_DISTINCT("user_id");
        } else {
            SELECT("user_id");
        }
        SELECT("role_id");
        FROM("user_role");
        applyWhere(example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            ORDER_BY(example.getOrderByClause());
        }
        
        return SQL();
    }

    public String updateByExampleSelective(Map<String, Object> parameter) {
        UserRole record = (UserRole) parameter.get("record");
        UserRoleExample example = (UserRoleExample) parameter.get("fnic");
        
        BEGIN();
        UPDATE("user_role");
        
        if (record.getUserId() != null) {
            SET("user_id = #{record.userId,jdbcType=INTEGER}");
        }
        
        if (record.getRoleId() != null) {
            SET("role_id = #{record.roleId,jdbcType=INTEGER}");
        }
        
        applyWhere(example, true);
        return SQL();
    }

    public String updateByExample(Map<String, Object> parameter) {
        BEGIN();
        UPDATE("user_role");
        
        SET("user_id = #{record.userId,jdbcType=INTEGER}");
        SET("role_id = #{record.roleId,jdbcType=INTEGER}");
        
        UserRoleExample example = (UserRoleExample) parameter.get("fnic");
        applyWhere(example, true);
        return SQL();
    }

    protected void applyWhere(UserRoleExample example, boolean includeExamplePhrase) {
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
            parmPhrase1 = "%s #{fnic.oredCriteria[%d].allCriteria[%d].value}";
            parmPhrase1_th = "%s #{fnic.oredCriteria[%d].allCriteria[%d].value,typeHandler=%s}";
            parmPhrase2 = "%s #{fnic.oredCriteria[%d].allCriteria[%d].value} and #{fnic.oredCriteria[%d].criteria[%d].secondValue}";
            parmPhrase2_th = "%s #{fnic.oredCriteria[%d].allCriteria[%d].value,typeHandler=%s} and #{fnic.oredCriteria[%d].criteria[%d].secondValue,typeHandler=%s}";
            parmPhrase3 = "#{fnic.oredCriteria[%d].allCriteria[%d].value[%d]}";
            parmPhrase3_th = "#{fnic.oredCriteria[%d].allCriteria[%d].value[%d],typeHandler=%s}";
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