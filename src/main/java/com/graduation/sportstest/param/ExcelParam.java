package com.graduation.sportstest.param;

import cn.afterturn.easypoi.excel.annotation.Excel;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class ExcelParam {
    @Excel(name = "学号", orderNum = "0")
    private int id;
    @Excel(name = "系统用户名", orderNum = "1")
    private String userName;
    @Excel(name = "成绩", orderNum = "2")
    private int grade;
}
