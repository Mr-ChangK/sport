package com.graduation.sportstest.model;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;
@Data
public class BaseModel implements Serializable {
    private int id;
    private String name;
    private Date createTime;
    private Date modifyTime;
    private char status;
}
