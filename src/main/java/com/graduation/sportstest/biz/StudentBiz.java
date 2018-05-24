package com.graduation.sportstest.biz;

import com.graduation.sportstest.constant.GradeEnum;
import com.graduation.sportstest.param.ExcelParam;
import com.graduation.sportstest.param.Studentranking;

import java.util.List;
import java.util.Map;

public interface StudentBiz {
    Studentranking queryTrankint(Integer id);

    void modifyGrade(List<ExcelParam> excelParams);

    Map<GradeEnum,Integer> mapGrade(Integer type,String typeName);
}
