package com.graduation.sportstest.mapper;

import com.graduation.sportstest.model.Major;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface MajorMapper {
    @Insert("insert into major(name) values (#{name})")
    int insert(Major major);
    @Results({
            @Result(column = "modify_time",property = "modifyTime"),
            @Result(column = "create_time",property = "createTime"),
    })
    @Select("select * from major where id= #{id}")
    Major queryMajorById(@Param("id") Integer id);

    @Select("select * from major where name= #{name}")
    Major queryMajorByName(@Param("name") String name);

    @Select("select * from major")
    List<Major> listMajor();
}
