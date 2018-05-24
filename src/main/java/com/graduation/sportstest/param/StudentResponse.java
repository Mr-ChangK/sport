package com.graduation.sportstest.param;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentResponse {
    private String name;
    private String userName;
    private String sex;
    private String college;
    private String major;
    private String teacherName;
    private int grade;
    private String age;
    private int id;

}
