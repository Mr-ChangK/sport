package com.graduation.sportstest.controller;

import com.google.common.base.Strings;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.graduation.sportstest.Common.BaseResponse;
import com.graduation.sportstest.biz.StudentBiz;
import com.graduation.sportstest.constant.GradeEnum;
import com.graduation.sportstest.param.ChartResponse;
import com.graduation.sportstest.param.ExcelParam;
import com.graduation.sportstest.utils.ExcelUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RequestMapping("/sports")
@RestController
@Slf4j
public class GradeController {
    @Resource
    private StudentBiz studentBiz;
    @RequestMapping(path = "/upload")
    public void upload(@RequestParam("file") MultipartFile file,HttpServletResponse response){
        try {
            List<ExcelParam> studentParams = ExcelUtil.importExcel(file.getInputStream(), ExcelParam.class);
            studentBiz.modifyGrade(studentParams);
            response.sendRedirect("/sports/student?path=gradeinsert");
        } catch (Exception e) {
            log.error("解析失败");
        }
    }
    @PostMapping("/getGrade")
    public BaseResponse getGrade(@RequestParam("type")String type,@RequestParam("typeId")String typeName){
        if (Strings.isNullOrEmpty(type)) {
            return BaseResponse.fail(1);
        }
        Map<GradeEnum, Integer> gradeEnumIntegerMap = studentBiz.mapGrade(Integer.parseInt(type),typeName);
        ChartResponse chartResponse = new ChartResponse();
        chartResponse.setHistogram(new ArrayList<>(gradeEnumIntegerMap.values()));
        List<Map <String,Object>> list= Lists.newArrayList();
        for(GradeEnum gradeEnum:gradeEnumIntegerMap.keySet()){
            Map <String,Object> map= Maps.newHashMap();
            map.put("name",gradeEnum.getValue());
            map.put("value",gradeEnumIntegerMap.get(gradeEnum));
            list.add(map);
        }

        chartResponse.setPip(list);
        return BaseResponse.success(chartResponse,1);
    }
}
