package com.graduation.sportstest.Common;

import lombok.Data;

@Data
public class BaseResponse <T>{
    private Boolean success;
    private T data;
    private int role;
    private String message;
    private BaseResponse(){

    }
    public static <T>BaseResponse success(T data,int role){
        BaseResponse<T> baseResponse = new BaseResponse<>();
        baseResponse.data=data;
        baseResponse.role=role;
        baseResponse.success=true;
        return baseResponse;
    }

    public static <T>BaseResponse fail(int role){
        BaseResponse<T> baseResponse = new BaseResponse<>();
        baseResponse.role=role;
        baseResponse.success=false;
        return baseResponse;
    }
    public static <T>BaseResponse fail(int role,String message){
        BaseResponse<T> baseResponse = new BaseResponse<>();
        baseResponse.role=role;
        baseResponse.success=false;
        baseResponse.message=message;
        return baseResponse;
    }
}
