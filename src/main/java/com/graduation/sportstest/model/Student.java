package com.graduation.sportstest.model;

import lombok.Data;


@Data
public class Student extends BaseModel{
    private String userName;
    private String password;
    private int sex;
    private int college;
    private int major;
    private int teacherId;
    private int grade;
    private int age;
}
