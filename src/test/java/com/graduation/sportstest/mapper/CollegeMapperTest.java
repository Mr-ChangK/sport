package com.graduation.sportstest.mapper;

import com.graduation.sportstest.model.College;
import com.graduation.sportstest.model.Student;
import com.graduation.sportstest.model.Teacher;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
public class CollegeMapperTest {
    @Resource
    private CollegeMapper collegeMapper;
    @Test
    public void insert() {

        Assert.assertNotNull(collegeMapper.queryCollegeById(1));
        Assert.assertEquals("计科学院",collegeMapper.queryCollegeById(1).getName());
    }
}