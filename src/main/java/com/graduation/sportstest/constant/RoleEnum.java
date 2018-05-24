package com.graduation.sportstest.constant;

import lombok.Getter;

@Getter
public enum RoleEnum {
    TEACHER(1),
    STUDENT(2),
    ADMIN(3);
    private int code;
    RoleEnum(int code){
        this.code=code;
    }

}
