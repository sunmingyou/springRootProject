package com.icolor.StudySpringBoot.controller;

import com.fasterxml.jackson.annotation.JsonView;
import com.icolor.StudySpringBoot.repository.domain.user;
import com.icolor.StudySpringBoot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.List;

/**
 * Created by admin on 2017/9/5.
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping("/all")
    public ModelAndView userManage(){
        System.out.println("usermanage info");
        ModelAndView mv=new ModelAndView("UserList");
       List<user> users=userService.getUsers();
     /*  user u=userService.getOne("1");*/
        mv.addObject("users",users);
        return mv;
    }

    @GetMapping("/getall")
    @JsonView(user.UserSimpleView.class)
    public List<user> getAll(){
        return userService.getUsers();

    }

    @GetMapping("/getOne/{uid}")
    public user getOne(@PathVariable String uid){
       return userService.getOne(uid);
    }

    @PostMapping(value = "/create")
    public boolean createUser(@ModelAttribute user myuser){
         return userService.createUser(myuser);
    }

    @PostMapping("/update")
    public void updateUser(@RequestBody user user){

        try {
            userService.updateUser(user);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @PostMapping("/del")
    public void deleteUser(String id){
        try {
            userService.deleteUser(id);
        }
        catch (Exception e){

        }
    }

}
