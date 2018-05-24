package com.graduation.sportstest.mapper;

import com.graduation.sportstest.model.Message;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface MessageMapper {
    @Insert("insert into message(studentId,message) values(#{studentId},#{message})")
    int insert(Message message);
    @Results({
            @Result(column = "modify_time",property = "modifyTime"),
            @Result(column = "create_time",property = "createTime"),
    })
    @Select("select * from message where studentId= #{studentId}")
    Message queryMessageById(@Param("studentId") Integer studentId);
}
