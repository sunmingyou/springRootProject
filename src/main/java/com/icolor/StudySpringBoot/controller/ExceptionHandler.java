package com.icolor.StudySpringBoot.controller;

import com.icolor.StudySpringBoot.interceptor.UnAuthenticationException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.Map;

/**
 * Created by admin on 2017/9/30.
 */
@ControllerAdvice
public class ExceptionHandler {

    @org.springframework.web.bind.annotation.ExceptionHandler(UnAuthenticationException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public Map<String,Object> handleException(UnAuthenticationException unAuthenException){
        Map map=unAuthenException.getClient();
        map.put("msg",unAuthenException.getMessage());
        return  map;
    }

}
