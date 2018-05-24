package com.graduation.sportstest.biz.impl;

import com.graduation.sportstest.biz.LoginService;
import com.graduation.sportstest.mapper.AdminMapper;
import com.graduation.sportstest.mapper.StudentMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Objects;
@Service("student")
public class StudentLoginService implements LoginService {
    @Resource
    private StudentMapper studentMapper;
    public Boolean userLogin(String userName, String password) {
        if(Objects.isNull(studentMapper.queryByUserNameAndPassword(userName,password))){
            return false;
        }
        return true;
    }
}
