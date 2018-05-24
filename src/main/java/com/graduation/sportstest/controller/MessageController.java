package com.graduation.sportstest.controller;

import com.graduation.sportstest.Common.BaseResponse;
import com.graduation.sportstest.mapper.MessageMapper;
import com.graduation.sportstest.model.Message;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Objects;

@RestController
@RequestMapping("/sports")
public class MessageController {
    @Resource
    private MessageMapper messageMapper;
    @PostMapping("/insertMessage")
    public BaseResponse insertMessage(@RequestParam("studentId") int studentId, @RequestParam("message") String message){
        Message message1=new Message();
        message1.setMessage(message);
        message1.setStudentId(studentId);
        int i=messageMapper.insert(message1);
        if(i>0){
            return BaseResponse.success("success",1);
        }
        return BaseResponse.fail(1);
    }
    @PostMapping("/queryMessage")
    public BaseResponse queryMessage(@RequestParam("studentId") int studentId){
        Message message = messageMapper.queryMessageById(studentId);
        if(Objects.isNull(message)){
            return BaseResponse.fail(1);
        }
        return BaseResponse.success(message.getMessage(),1);
    }

}
