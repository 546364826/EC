package com.zwj.controller;

import com.zwj.base.Result;
import com.zwj.base.StatusCode;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class ProjectExceptionHandler {

    @ExceptionHandler(Exception.class)
    @ResponseBody //对象->json     ; json->对象
    public Result projectException(Exception e){
        e.printStackTrace();
        return new Result(false, StatusCode.ERROR,e.getMessage() );
    }
}
