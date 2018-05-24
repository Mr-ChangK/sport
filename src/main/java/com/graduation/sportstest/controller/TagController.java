package com.graduation.sportstest.controller;

import com.google.common.collect.Maps;
import com.graduation.sportstest.biz.ConvertBiz;
import com.graduation.sportstest.biz.StudentBiz;
import com.graduation.sportstest.mapper.StudentMapper;
import com.graduation.sportstest.mapper.TeacherMapper;
import com.graduation.sportstest.param.StudentResponse;
import com.graduation.sportstest.param.Studentranking;
import com.graduation.sportstest.param.TeacherResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RequestMapping("/sports")
@Slf4j
@Controller
public class TagController {
    @Resource
    private TeacherMapper teacherMapper;
    @Resource
    private StudentMapper studentMapper;
    @Resource
    private ConvertBiz convertBiz;
    @Resource
    private StudentBiz studentBiz;
    @RequestMapping("/teacher")
    public ModelAndView teacherManager(@RequestParam(name = "path") String path,
                                       HttpServletRequest request){
        log.info("teacher{}",path);
        Map<String,Object> map= Maps.newHashMap();
        map.put("role",request.getSession().getAttribute("user"));
        ModelAndView modelAndView = new ModelAndView(path, map);
        List<TeacherResponse> list=teacherMapper.listTeacher().stream().map(convertBiz::converetTeacherResponse).collect(Collectors.toList());
        modelAndView.addObject("teacherList",list);
        return modelAndView;
    }

    @RequestMapping("/student")
    public ModelAndView studentManager(@RequestParam(name = "path") String path,
                                       HttpServletRequest request){
        log.info("student{}",path);
        Map<String,Object> map= Maps.newHashMap();
        map.put("role",request.getSession().getAttribute("user"));
        ModelAndView modelAndView = new ModelAndView(path, map);
        List<StudentResponse> list=studentMapper.listStudent().
                stream().
                map(convertBiz::convertStudentResponse).
                collect(Collectors.toList());
        modelAndView.addObject("studentList",list);
        return modelAndView;
    }
    @RequestMapping("/tranking")
    public ModelAndView studentTranking(@RequestParam(name = "path") String path,HttpServletRequest request){
        Integer id=(Integer)request.getSession().getAttribute("id");
        Map<String,Object> map= Maps.newHashMap();
        map.put("role",request.getSession().getAttribute("user"));
        Studentranking studentranking = studentBiz.queryTrankint(id);
        studentranking.setId(id);
        ModelAndView modelAndView=new ModelAndView(path,map);
        modelAndView.addObject("result",studentranking);
        return modelAndView;
    }
    @RequestMapping("/insertGrade")
    public ModelAndView insertGrade(@RequestParam(name = "path") String path,
                                    HttpServletRequest request){
        Map<String,Object> map= Maps.newHashMap();
        map.put("role",request.getSession().getAttribute("user"));
        return new ModelAndView(path,map);
    }
    @RequestMapping("/charts")
    public ModelAndView charts(@RequestParam(name = "path") String path,
                               HttpServletRequest request){
        Map<String,Object> map= Maps.newHashMap();
        map.put("role",request.getSession().getAttribute("user"));
        return new ModelAndView(path,map);
    }
}
