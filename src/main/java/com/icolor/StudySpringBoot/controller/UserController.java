package com.icolor.StudySpringBoot.controller;

import com.fasterxml.jackson.annotation.JsonView;
import com.icolor.StudySpringBoot.repository.domain.user;
import com.icolor.StudySpringBoot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

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

    @RequestMapping("")
    public ModelAndView userManage(){
        ModelAndView mv=new ModelAndView("UserList");
        List<user> users=userService.getUsers();
        mv.addObject("users",users);
        return mv;
    }

    @GetMapping("/getall")
    @JsonView(user.UserSimpleView.class)
    public List<user> getAll(){
       return userService.getUsers();
    }

    @GetMapping("/getone/{uid:\\d+}")
    @JsonView(user.UserDetailView.class)
    public user getOne(@PathVariable String uid){
       return userService.getOne(uid);
    }

    @PostMapping("/create")
    public void createUser(user user){
            userService.createUser(user);
    }

    @PutMapping("/update")
    public void updateUser(@Valid @RequestBody user user, BindingResult errors){
        try {
            if(errors.hasErrors()){
                errors.getAllErrors().forEach(error->{System.out.println(error.getDefaultMessage());});
                return;
            }
            userService.updateUser(user);
        }
        catch (Exception e){

        }
    }

    @DeleteMapping("/del")
    public void deleteUser(String id){
        try {
            userService.deleteUser(id);
        }
        catch (Exception e){

        }
    }

}
