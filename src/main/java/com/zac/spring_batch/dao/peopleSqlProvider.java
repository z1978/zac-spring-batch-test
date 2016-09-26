package com.zac.spring_batch.dao;

import com.zac.spring_batch.entity.People;
import org.apache.ibatis.jdbc.SQL;

public class peopleSqlProvider {

    public String insertSelective(People record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("people");
        
        if (record.getPersonId() != null) {
            sql.VALUES("person_id", "#{personId,jdbcType=INTEGER}");
        }
        
        if (record.getFirst_name() != null) {
            sql.VALUES("first_name", "#{first_name,jdbcType=VARCHAR}");
        }
        
        if (record.getLast_name() != null) {
            sql.VALUES("last_name", "#{last_name,jdbcType=VARCHAR}");
        }
        
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(People record) {
        SQL sql = new SQL();
        sql.UPDATE("people");
        
        if (record.getFirst_name() != null) {
            sql.SET("first_name = #{first_name,jdbcType=VARCHAR}");
        }
        
        if (record.getLast_name() != null) {
            sql.SET("last_name = #{last_name,jdbcType=VARCHAR}");
        }
        
        sql.WHERE("person_id = #{personId,jdbcType=INTEGER}");
        
        return sql.toString();
    }
}