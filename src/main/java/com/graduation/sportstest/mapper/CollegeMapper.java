package com.graduation.sportstest.mapper;

import com.graduation.sportstest.model.College;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;


@Mapper
public interface CollegeMapper {
    @Insert("insert into college(name) values (#{name})")
    int insert(College college);
    @Results({
        @Result(column = "modify_time",property = "modifyTime"),
        @Result(column = "create_time",property = "createTime"),
    })
    @Select("select * from college where id= #{id}")
    College queryCollegeById(@Param("id") Integer id);

    @Select("select * from college where name= #{name}")
    College queryCollegeByName(@Param("name") String name);

    @Select("select * from college")
    List<College> listCollege();
}
