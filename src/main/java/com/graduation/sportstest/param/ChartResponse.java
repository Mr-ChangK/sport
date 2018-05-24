package com.graduation.sportstest.param;

import com.graduation.sportstest.constant.GradeEnum;
import lombok.Data;

import java.util.List;
import java.util.Map;
@Data
public class ChartResponse {
    List<Integer> histogram;
    List<Map<String,Object>> pip;
}
