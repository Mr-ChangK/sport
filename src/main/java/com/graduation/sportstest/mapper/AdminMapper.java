package com.graduation.sportstest.mapper;

import com.graduation.sportstest.model.Admin;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface AdminMapper {
    @Results({
            @Result(column = "modify_time",property = "modifyTime"),
            @Result(column = "create_time",property = "createTime"),
    })
    @Select("select * from admin where username=#{username} and password=#{password}")
    Admin queryByUserNameAndPassword(@Param("username")String userName,
                                     @Param("password") String password);
}
