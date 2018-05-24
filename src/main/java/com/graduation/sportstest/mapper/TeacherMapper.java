package com.graduation.sportstest.mapper;

import com.graduation.sportstest.model.Admin;
import com.graduation.sportstest.model.Teacher;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface TeacherMapper {
    @Insert("insert into teacher(username,name,college,major) values (#{userName},#{name},#{college},#{major})")
    int insert(Teacher teacher);
    @Results({
            @Result(column = "modify_time",property = "modifyTime"),
            @Result(column = "create_time",property = "createTime"),
    })
    @Select("select * from major where id= #{id}")
    Teacher queryTeacherById(@Param("id") Integer id);

    @Results({
            @Result(column = "modify_time",property = "modifyTime"),
            @Result(column = "create_time",property = "createTime"),
    })
    @Select("select * from teacher where status=1")
    List<Teacher> listTeacher();

    @Results({
            @Result(column = "modify_time",property = "modifyTime"),
            @Result(column = "create_time",property = "createTime"),
    })
    @Select("select * from teacher where username=#{username} and password=#{password}")
    Admin queryByUserNameAndPassword(@Param("username")String userName,
                                     @Param("password") String password);
    @Update("update teacher set status=0 where id=#{id}")
    int modifyTeacher(@Param("id") int id);

    @Select("select * from teacher where name=#{name}")
    List<Teacher> queryByName(@Param("name")String name);
}

