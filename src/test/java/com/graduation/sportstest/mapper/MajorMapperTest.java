package com.graduation.sportstest.mapper;

import com.graduation.sportstest.model.Major;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
public class MajorMapperTest {
    @Resource
    private MajorMapper majorMapper;
    @Test
    public void queryMajorById() {
        Major major = majorMapper.queryMajorById(1);
        Assert.assertNotNull(major);
        Assert.assertEquals("计算机",major.getName());
    }
}