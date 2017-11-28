package com.icolor.StudySpringBoot.controller;

import com.icolor.StudySpringBoot.config.SecurityConfigProperites;
import com.icolor.StudySpringBoot.security.LoginType;
import org.codehaus.groovy.runtime.metaclass.ConcurrentReaderHashMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.savedrequest.HttpSessionRequestCache;
import org.springframework.security.web.savedrequest.RequestCache;
import org.springframework.security.web.savedrequest.SavedRequest;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by admin on 2017/10/16.
 */
@RestController
@RequestMapping("/login")
public class LoginController {

    private Logger logger= LoggerFactory.getLogger(getClass());
    private RequestCache requestCache=new HttpSessionRequestCache();
    private RedirectStrategy redirectStrategy=new DefaultRedirectStrategy();

    @Autowired
    SecurityConfigProperites securityConfigProperites;

    @RequestMapping("/require")
    @ResponseStatus(code= HttpStatus.UNAUTHORIZED)
    public Map loginPage(HttpServletRequest request, HttpServletResponse response){
        SavedRequest savedRequest=requestCache.getRequest(request,response);
       if(LoginType.Redirect.equals(securityConfigProperites.getLoginType())) {
           try {
               redirectStrategy.sendRedirect(request, response, securityConfigProperites.getLoginPage());
           } catch (IOException e) {
               e.printStackTrace();
           }
           return null;
       }
        else {
           //restful请求 返回json
           Map<String,Object> result=new HashMap<String,Object>();
           result.put("content","权限不足,引导用户到登录页");
           return result;
       }

    }

    @RequestMapping("/page")
    public ModelAndView loginPage(){
        ModelAndView modelAndView=new ModelAndView("login");
        modelAndView.addObject("imgUrl","/code/image");
        return modelAndView;
    }
}
