package com.graduation.sportstest.controller;

import com.google.common.collect.Maps;
import com.graduation.sportstest.biz.LoginService;
import com.graduation.sportstest.constant.RoleEnum;
import com.graduation.sportstest.mapper.StudentMapper;
import com.graduation.sportstest.model.Student;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Controller
@Slf4j
public class LoginController {
    @Resource(name="admin")
    private LoginService adminService;
    @Resource(name = "teacher")
    private LoginService teacherService;
    @Resource(name="student")
    private LoginService studentService;
    @Resource
    private StudentMapper studentMapper;
    @GetMapping("/index")
    public ModelAndView index(){
        Map<String,String> map=Maps.newHashMap();
        map.put("result","true");
        return new ModelAndView("login",map);
    }
    @PostMapping("/login")
    public ModelAndView login(@RequestParam("username") String username,
                              @RequestParam("password") String password,
                              @RequestParam("role") String userRole,
                              HttpServletRequest request){
        log.info("登录{}",username);
        ModelAndView modelAndView;
        Boolean flag=true;

        if(RoleEnum.TEACHER.getCode()==Integer.parseInt(userRole)){
            flag=teacherService.userLogin(username,password);
        }else if(RoleEnum.STUDENT.getCode()==Integer.parseInt(userRole)){
            flag=studentService.userLogin(username,password);
            Student student=studentMapper.queryByUserNameAndPassword(username,password);
            request.getSession().setAttribute("id",student.getId());
        }else if(RoleEnum.ADMIN.getCode()==Integer.parseInt(userRole)){
            flag=adminService.userLogin(username,password);
        }
        Map<String,String> map=Maps.newHashMap();
        if(!flag){
            map.put("result","false");
            modelAndView = new ModelAndView("login",map);
            return modelAndView;
        }
        request.getSession().setAttribute("user",userRole);
        map.put("role",userRole);
        modelAndView = new ModelAndView("index",map);
        return modelAndView;
    }
    @GetMapping("/loginOut")
    public ModelAndView loginOut(HttpServletRequest request){
        request.getSession().removeAttribute("user");
        Map<String,String> map=Maps.newHashMap();
        map.put("result","true");
        return new ModelAndView("login",map);
    }
}
