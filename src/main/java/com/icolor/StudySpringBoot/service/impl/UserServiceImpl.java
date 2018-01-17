package com.icolor.StudySpringBoot.service.impl;

import com.icolor.StudySpringBoot.repository.domain.user;
import com.icolor.StudySpringBoot.repository.mapper.UserMapper;
import com.icolor.StudySpringBoot.service.UserService;
import groovy.util.logging.Log4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by admin on 2017/9/5.
 */
@Service
public class UserServiceImpl implements UserService {

    Logger log= LoggerFactory.getLogger(this.getClass());

    @Autowired
    UserMapper userMapper;

    @Override
    public List<user> getUsers(){
        try {
            return userMapper.getUsers();
        } catch (Exception e) {
            log.error("eror:"+e.getMessage());
           e.printStackTrace();
            return null;
        }
    }

    @Override
    public user getOne(String id) {
        return userMapper.getOne(id);
    }

    @Override
    public boolean createUser(user user) {
        try {
             userMapper.createUser(user);
            return  true;
        } catch (Exception e) {
            e.printStackTrace();
            log.error("添加用户失败:"+e.getMessage());
            return false;
        }
    }

    @Override
    public boolean updateUser(user user) throws Exception {
        try {
            userMapper.updateUser(user);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean deleteUser(String id) throws Exception {
        try {
             userMapper.deleteUser(id);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

}
