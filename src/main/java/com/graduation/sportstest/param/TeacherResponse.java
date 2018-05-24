package com.graduation.sportstest.param;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TeacherResponse {
    private int id;
    private String userName;
    private String college;
    private String major;
    private String name;

}
