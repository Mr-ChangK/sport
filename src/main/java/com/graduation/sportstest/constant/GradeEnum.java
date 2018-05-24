package com.graduation.sportstest.constant;

import lombok.Getter;
import lombok.ToString;

@Getter
public enum GradeEnum {
    SIX("60分以下"),
    SEVEN("60分到70分"),
    EIGHT("70分到80分"),
    NINE("80分到90分"),
    TEN("90分到100分");
    private String value;
    GradeEnum(String value){
        this.value=value;
    }
    public static String getValue(GradeEnum gradeEnum){
        return gradeEnum.getValue();
    }

    @Override
    public String toString() {
        return getValue();
    }
}
