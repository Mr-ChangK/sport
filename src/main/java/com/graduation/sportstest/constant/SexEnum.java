package com.graduation.sportstest.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum SexEnum {
    GIRL(1,"女"),
    BOY(2,"男");
    private int code;
    private String sex;

    public static SexEnum getNameByCode(int code){
        if(code==1){
            return GIRL;
        }else{
            return BOY;
        }
    }

    public static SexEnum getCodeByName(String name){
        if(name.equals("女")){
            return GIRL;
        }else{
            return BOY;
        }
    }
}
