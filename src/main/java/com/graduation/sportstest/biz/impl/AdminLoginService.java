package com.graduation.sportstest.biz.impl;

import com.graduation.sportstest.biz.LoginService;
import com.graduation.sportstest.mapper.AdminMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Objects;
@Service("admin")
public class AdminLoginService implements LoginService {
    @Resource
    private AdminMapper adminMapper;
    public Boolean userLogin(String userName, String password) {
        if(Objects.isNull(adminMapper.queryByUserNameAndPassword(userName,password))){
            return false;
        }
        return true;
    }
}
