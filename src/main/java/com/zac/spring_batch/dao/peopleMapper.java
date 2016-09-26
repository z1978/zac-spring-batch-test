package com.zac.spring_batch.dao;

import com.zac.spring_batch.entity.People;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

public interface peopleMapper {
    @Delete({
        "delete from people",
        "where person_id = #{personId,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer personId);

    @Insert({
        "insert into people (person_id, first_name, ",
        "last_name)",
        "values (#{personId,jdbcType=INTEGER}, #{first_name,jdbcType=VARCHAR}, ",
        "#{last_name,jdbcType=VARCHAR})"
    })
    int insert(People record);

    @InsertProvider(type=peopleSqlProvider.class, method="insertSelective")
    int insertSelective(People record);

    @Select({
        "select",
        "person_id, first_name, last_name",
        "from people",
        "where person_id = #{personId,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="person_id", property="personId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="first_name", property="first_name", jdbcType=JdbcType.VARCHAR),
        @Result(column="last_name", property="last_name", jdbcType=JdbcType.VARCHAR)
    })
    People selectByPrimaryKey(Integer personId);

    @UpdateProvider(type=peopleSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(People record);

    @Update({
        "update people",
        "set first_name = #{first_name,jdbcType=VARCHAR},",
          "last_name = #{last_name,jdbcType=VARCHAR}",
        "where person_id = #{personId,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(People record);
}