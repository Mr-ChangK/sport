package com.graduation.sportstest.utils;


import cn.afterturn.easypoi.excel.ExcelImportUtil;
import cn.afterturn.easypoi.excel.entity.ImportParams;
import com.google.common.collect.Lists;

import java.io.InputStream;
import java.util.List;

public class ExcelUtil {
    public static <T> List<T> importExcel(InputStream inputStream, Class<T> pojoClass) throws Exception{
        if (inputStream == null){
            return Lists.newArrayList();
        }
        ImportParams params = new ImportParams();
        List<T> list = ExcelImportUtil.importExcel(inputStream, pojoClass, params);
        return list;
    }
    private ExcelUtil(){

    }
}
