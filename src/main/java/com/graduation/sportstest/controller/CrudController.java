package com.graduation.sportstest.controller;

import com.google.common.collect.Maps;
import com.graduation.sportstest.Common.BaseResponse;
import com.graduation.sportstest.biz.ConvertBiz;
import com.graduation.sportstest.mapper.CollegeMapper;
import com.graduation.sportstest.mapper.MajorMapper;
import com.graduation.sportstest.mapper.StudentMapper;
import com.graduation.sportstest.mapper.TeacherMapper;
import com.graduation.sportstest.model.BaseModel;
import com.graduation.sportstest.model.Student;
import com.graduation.sportstest.param.CollegeAndMajorResponse;
import com.graduation.sportstest.param.StudentParam;
import com.graduation.sportstest.param.TeacherParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/sports")
@Slf4j
public class CrudController {
    @Resource
    private TeacherMapper teacherMapper;
    @Resource
    private StudentMapper studentMapper;
    @Resource
    private ConvertBiz convertBiz;
    @Resource
    private CollegeMapper collegeMapper;
    @Resource
    private MajorMapper majorMapper;
    @PostMapping("/deleteTeacher")
    public BaseResponse deleteTeacher(@RequestParam(name="id")String id){
        BaseResponse baseResponse=null;
        try{
            int result = teacherMapper.modifyTeacher(Integer.parseInt(id));
            if(result>0){
                baseResponse=BaseResponse.success(result,3);
            }
        }catch (Exception e){
            baseResponse=BaseResponse.fail(3);
        }
        return baseResponse;
    }
    @PostMapping("/saveTeacher")
    public BaseResponse saveTeacher(TeacherParam teacher){
        log.info(teacher.toString());
        BaseResponse baseResponse=null;
        try{
            int result = teacherMapper.insert(convertBiz.toTeacher(teacher));
            if(result>0){
                baseResponse=BaseResponse.success(result,3);
            }
        }catch (Exception e){
            baseResponse=BaseResponse.fail(3);
        }
        return baseResponse;
    }

    @PostMapping("/deleteStudent")
    public BaseResponse deleteStudent(@RequestParam(name="id")String id){
        BaseResponse baseResponse=null;
        try{
            int result = studentMapper.modifyStudent(Integer.parseInt(id));
            if(result>0){
                baseResponse=BaseResponse.success(result,3);
            }
        }catch (Exception e){
            baseResponse=BaseResponse.fail(3);
        }
        return baseResponse;
    }

    @PostMapping("/saveStudent")
    public BaseResponse saveStudent(StudentParam studentParam) {
        try {
            Student student = convertBiz.toStudent(studentParam);
            int result = studentMapper.insert(student);
            if (result > 0) {
                return BaseResponse.success(result, 3);
            }
        } catch (Exception e) {
            log.info(e.getMessage());
            return BaseResponse.fail(1);
        }
        return BaseResponse.fail(1);
    }

    @PostMapping("/modifyGrade")
    public BaseResponse modifyGrade(@RequestParam(name="id")int id,@RequestParam("grade") int grade){
        BaseResponse baseResponse=null;
        try{
            int result = studentMapper.modifyGrade(id,grade);
            if(result>0){
                baseResponse=BaseResponse.success(result,3);
            }
        }catch (Exception e){
            baseResponse=BaseResponse.fail(3);
        }
        return baseResponse;
    }
    @PostMapping("/getCollegeAndMajor")
    public BaseResponse getCollegeAndMajor(){
        Map<String,List<BaseModel>> map= Maps.newHashMap();
        CollegeAndMajorResponse collegeAndMajorResponse = new CollegeAndMajorResponse();
        collegeAndMajorResponse.setCollegeList(collegeMapper.listCollege());
        collegeAndMajorResponse.setMajorList(majorMapper.listMajor());
        return BaseResponse.success(collegeAndMajorResponse,1);
    }
}
