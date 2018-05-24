package com.graduation.sportstest.model;

import lombok.Data;
import lombok.ToString;


@Data
@ToString
public class Teacher extends BaseModel{
    private String userName;
    private String password;
    private Integer college;
    private Integer major;
}
