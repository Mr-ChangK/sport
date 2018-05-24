package com.graduation.sportstest.biz.impl;

import com.graduation.sportstest.biz.LoginService;
import com.graduation.sportstest.mapper.TeacherMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Objects;

@Service("teacher")
public class TeacherLoginService implements LoginService {
    @Resource
    private TeacherMapper teacherMapper;
    @Override
    public Boolean userLogin(String userName, String password) {
        if(Objects.isNull(teacherMapper.queryByUserNameAndPassword(userName,password))){
            return false;
        }
        return true;
    }
}
