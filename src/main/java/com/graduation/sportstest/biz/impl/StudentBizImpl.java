package com.graduation.sportstest.biz.impl;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.graduation.sportstest.biz.StudentBiz;
import com.graduation.sportstest.constant.GradeEnum;
import com.graduation.sportstest.mapper.CollegeMapper;
import com.graduation.sportstest.mapper.MajorMapper;
import com.graduation.sportstest.mapper.StudentMapper;
import com.graduation.sportstest.model.Student;
import com.graduation.sportstest.param.ExcelParam;
import com.graduation.sportstest.param.Studentranking;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
@Service
public class StudentBizImpl implements StudentBiz{
    @Resource
    private StudentMapper studentMapper;
    @Resource
    private CollegeMapper collegeMapper;
    @Resource
    private MajorMapper majorMapper;
    @Override
    public Studentranking queryTrankint(Integer id) {
        Studentranking studentranking=new Studentranking();
        Student student=studentMapper.queryStudentById(id);
        studentranking.setGrade(student.getGrade());
        List<Student> collegeStudents=studentMapper.listStudent().stream().filter(a->a.getCollege()==student.getCollege()).collect(Collectors.toList());
        List<Student> majorStudents=studentMapper.listStudent().stream().filter(a->a.getMajor()==student.getMajor()).collect(Collectors.toList());
        for(int i=0;i<collegeStudents.size();i++){
            if(student.getId()==collegeStudents.get(i).getId()){
                studentranking.setCollege(i);
            }
        }
        for(int i=0;i<majorStudents.size();i++){
            if(student.getId()==majorStudents.get(i).getId()){
                studentranking.setMajor(i);
            }
        }
        if(studentranking.getCollege()==0){
            studentranking.setCollege(1);
        }
        if(studentranking.getMajor()==0){
            studentranking.setMajor(1);
        }
        return studentranking;
    }

    @Override
    public void modifyGrade(List<ExcelParam> excelParams) {
        excelParams.forEach(excelParam->studentMapper.modifyGrade(excelParam.getId(),excelParam.getGrade()));
    }

    @Override
    public Map<GradeEnum, Integer> mapGrade(Integer type,String typeName) {
        Map<GradeEnum, Integer> map= Maps.newHashMap();
        map.put(GradeEnum.SIX,0);
        map.put(GradeEnum.SEVEN,0);
        map.put(GradeEnum.EIGHT,0);
        map.put(GradeEnum.NINE,0);
        map.put(GradeEnum.TEN,0);
        List<Student> students= null;

        List<Student> temp=studentMapper.listStudent();
        if(type==1){
            int typeId=collegeMapper.queryCollegeByName(typeName).getId();
            students=temp.stream().filter(s->s.getCollege()==typeId).collect(Collectors.toList());
        }else{
            int typeId=majorMapper.queryMajorByName(typeName).getId();
            students=temp.stream().filter(s->s.getMajor()==typeId).collect(Collectors.toList());
        }
        for (Student student:students){
            map=mapGradeByGrade(student.getGrade(),map);
        }
        return map;
    }
    private Map<GradeEnum, Integer> mapGradeByGrade(int grade,Map<GradeEnum, Integer> map){
        if(grade<60){
            map.put(GradeEnum.SIX,map.get(GradeEnum.SIX)+1);
        }
        if(grade>=60&&grade<70){
            map.put(GradeEnum.SEVEN,map.get(GradeEnum.SEVEN)+1);
        }
        if(grade>=70&&grade<80){
            map.put(GradeEnum.EIGHT,map.get(GradeEnum.EIGHT)+1);
        }
        if(grade>=80&&grade<90){
            map.put(GradeEnum.NINE,map.get(GradeEnum.NINE)+1);
        }
        if(grade>=90&&grade<100){
            map.put(GradeEnum.TEN,map.get(GradeEnum.TEN)+1);
        }
        return map;
    }
}
