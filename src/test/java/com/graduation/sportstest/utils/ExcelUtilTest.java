package com.graduation.sportstest.utils;

import com.graduation.sportstest.param.ExcelParam;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.List;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
public class ExcelUtilTest {

    @Test
    public void importExcel() throws Exception{
        InputStream inputStream=new FileInputStream("/Users/maoyan/Desktop/学生成绩.xls");
        List<ExcelParam> list=ExcelUtil.importExcel(inputStream,ExcelParam.class);
        System.out.println(list);
    }
}