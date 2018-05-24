package com.graduation.sportstest.param;

import com.graduation.sportstest.model.College;
import com.graduation.sportstest.model.Major;
import lombok.Data;

import java.util.List;

@Data
public class CollegeAndMajorResponse {
    private List<College> collegeList;
    private List<Major> majorList;
}
