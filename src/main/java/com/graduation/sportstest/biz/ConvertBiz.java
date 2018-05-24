package com.graduation.sportstest.biz;

import com.graduation.sportstest.model.Student;
import com.graduation.sportstest.model.Teacher;
import com.graduation.sportstest.param.StudentParam;
import com.graduation.sportstest.param.StudentResponse;
import com.graduation.sportstest.param.TeacherParam;
import com.graduation.sportstest.param.TeacherResponse;

public interface ConvertBiz {
    StudentResponse convertStudentResponse(Student student);
    TeacherResponse converetTeacherResponse(Teacher teacher);

    Teacher toTeacher(TeacherParam teacherParam);
    Student toStudent(StudentParam studentParam);
}
