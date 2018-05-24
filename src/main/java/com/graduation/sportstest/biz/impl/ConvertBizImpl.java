package com.graduation.sportstest.biz.impl;

import com.graduation.sportstest.biz.ConvertBiz;
import com.graduation.sportstest.constant.SexEnum;
import com.graduation.sportstest.mapper.CollegeMapper;
import com.graduation.sportstest.mapper.MajorMapper;
import com.graduation.sportstest.mapper.TeacherMapper;
import com.graduation.sportstest.model.College;
import com.graduation.sportstest.model.Major;
import com.graduation.sportstest.model.Student;
import com.graduation.sportstest.model.Teacher;
import com.graduation.sportstest.param.StudentParam;
import com.graduation.sportstest.param.StudentResponse;
import com.graduation.sportstest.param.TeacherParam;
import com.graduation.sportstest.param.TeacherResponse;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
@Service
public class ConvertBizImpl implements ConvertBiz {
    @Resource
    private TeacherMapper teacherMapper;
    @Resource
    private MajorMapper majorMapper;
    @Resource
    private CollegeMapper collegeMapper;

    @Override
    public StudentResponse convertStudentResponse(Student student) {
        return toStudentResponse(student);
    }

    @Override
    public TeacherResponse converetTeacherResponse(Teacher teacher) {
        return toTeacherResponse(teacher);
    }

    @Override
    public Teacher toTeacher(TeacherParam teacherParam) {
        Teacher teacher=new Teacher();
        teacher.setName(teacherParam.getName());
        teacher.setUserName(teacherParam.getUserName());
        teacher.setPassword(teacherParam.getPassword());
        if(collegeMapper.queryCollegeByName(teacherParam.getCollege())==null){
            College college=new College();
            college.setName(teacherParam.getCollege());
            collegeMapper.insert(college);
        }
        teacher.setCollege(collegeMapper.queryCollegeByName(teacherParam.getCollege()).getId());
        if(majorMapper.queryMajorByName(teacherParam.getMajor())==null){
            Major major=new Major();
            major.setName(teacherParam.getMajor());
            majorMapper.insert(major);
        }
        teacher.setMajor(majorMapper.queryMajorByName(teacherParam.getMajor()).getId());
        return teacher;
    }

    @Override
    public Student toStudent(StudentParam studentParam) {
        Student student=new Student();
        student.setAge(Integer.parseInt(studentParam.getAge()));
        student.setName(studentParam.getName());
        student.setSex(SexEnum.getCodeByName(studentParam.getSex()).getCode());
        if(collegeMapper.queryCollegeByName(studentParam.getCollege())==null){
            College college=new College();
            college.setName(studentParam.getCollege());
            collegeMapper.insert(college);
        }
        student.setCollege(collegeMapper.queryCollegeByName(studentParam.getCollege()).getId());
        if(majorMapper.queryMajorByName(studentParam.getMajor())==null){
            Major major=new Major();
            major.setName(studentParam.getMajor());
            majorMapper.insert(major);
        }
        student.setMajor(majorMapper.queryMajorByName(studentParam.getMajor()).getId());
        student.setTeacherId(teacherMapper.queryByName(studentParam.getTeacherName()).get(0).getId());
        student.setPassword(studentParam.getPassword());
        student.setUserName(studentParam.getUserName());
        return student;
    }


    private StudentResponse toStudentResponse(Student student){
        StudentResponse studentResponse=new StudentResponse();
        studentResponse.setCollege(collegeMapper.queryCollegeById(student.getCollege()).getName());
        studentResponse.setGrade(student.getGrade());
        studentResponse.setSex(SexEnum.getNameByCode(student.getSex()).getSex());
        studentResponse.setName(student.getName());
        studentResponse.setUserName(student.getUserName());
        studentResponse.setTeacherName(teacherMapper.queryTeacherById(student.getTeacherId()).getName());
        studentResponse.setAge(String.valueOf(student.getAge()));
        studentResponse.setMajor(majorMapper.queryMajorById(student.getMajor()).getName());
        studentResponse.setId(student.getId());
        return studentResponse;
    }

    private TeacherResponse toTeacherResponse(Teacher teacher){
        TeacherResponse teacherResponse=new TeacherResponse();
        teacherResponse.setCollege(collegeMapper.queryCollegeById(teacher.getCollege()).getName());
        teacherResponse.setMajor(majorMapper.queryMajorById(teacher.getMajor()).getName());
        teacherResponse.setName(teacher.getName());
        teacherResponse.setUserName(teacher.getUserName());
        teacherResponse.setId(teacher.getId());
        return teacherResponse;
    }

}
