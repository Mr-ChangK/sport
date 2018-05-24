package com.graduation.sportstest.mapper;

import org.apache.ibatis.annotations.Results;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
public class AdminMapperTest {
    @Resource
    private AdminMapper adminMapper;
    @Test
    public void queryByUserNameAndPassword() {
        adminMapper.queryByUserNameAndPassword("aaa","bbb");
    }
}