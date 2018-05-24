package com.graduation.sportstest.mapper;

import com.graduation.sportstest.model.Student;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface StudentMapper {
    @Insert("insert into student(username,password,name,college,major,sex,age,teacherId) values(#{userName},#{password},#{name},#{college},#{major},#{sex},#{age},#{teacherId})")
    int insert(Student student);
    @Results({
            @Result(column = "modify_time",property = "modifyTime"),
            @Result(column = "create_time",property = "createTime"),
    })
    @Select("select * from student where id= #{id}")
    Student queryStudentById(@Param("id") Integer id);

    @Select("select * from student where status=1 order by id asc")
    List<Student> listStudent();

    @Results({
            @Result(column = "modify_time",property = "modifyTime"),
            @Result(column = "create_time",property = "createTime"),
    })
    @Select("select * from student where username=#{username} and password=#{password}")
    Student queryByUserNameAndPassword(@Param("username")String userName,
                                     @Param("password") String password);

    @Update("update student set status=0 where id=#{id}")
    int modifyStudent(@Param("id") int id);

    @Update("update student set grade=#{grade} where id=#{id}")
    int modifyGrade(@Param("id") int id,@Param("grade") int grade);
}
