package com.icolor.StudySpringBoot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by admin on 2017/10/16.
 */
@Controller
@RequestMapping("/login")
public class LoginController {

    @RequestMapping("")
    public ModelAndView showPage(HttpServletRequest request){
        ModelAndView modelAndView=new ModelAndView("login");
        request.getSession().setAttribute("uid","user");
        return modelAndView;
    }
}
