package com.icolor.StudySpringBoot.controller;

import com.icolor.StudySpringBoot.repository.domain.user;
import com.icolor.StudySpringBoot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Created by admin on 2017/9/5.
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;

    @RequestMapping("")
    public ModelAndView userManage(){
        ModelAndView mv=new ModelAndView("UserList");
        List<user> users=userService.getUsers();
        mv.addObject("users",users);
        return mv;
    }

    @RequestMapping("/getall")
    public List<user> getUsers(){
        throw new RuntimeException("aaa");
       //return userService.getUsers();
    }

    @RequestMapping("/getOne")
    public user getOne(String uid){
       return userService.getOne(uid);
    }

    @RequestMapping("/create")
    public void createUser(user user){
            userService.createUser(user);
    }

    @RequestMapping("/update")
    public void updateUser(user user){
        try {
            userService.updateUser(user);
        }
        catch (Exception e){

        }
    }

    @RequestMapping("/del")
    public void deleteUser(String id){
        try {
            userService.deleteUser(id);
        }
        catch (Exception e){

        }
    }

}
