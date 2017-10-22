package com.icolor.StudySpringBoot.service.impl;

import com.icolor.StudySpringBoot.repository.domain.user;
import com.icolor.StudySpringBoot.repository.mapper.UserMapper;
import com.icolor.StudySpringBoot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by admin on 2017/9/5.
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;

    @Override
    public List<user> getUsers(){
       return userMapper.getUsers();
    }

    @Override
    public user getOne(String id) {
        return userMapper.getOne(id);
    }

    @Override
    public boolean createUser(user user) {
        return userMapper.createUser(user);
    }

    @Override
    public boolean updateUser(user user) throws Exception {
        userMapper.updateUser(user);
        throw new Exception("aa");
    }

    @Override
    public boolean deleteUser(String id) throws Exception {
        return userMapper.deleteUser(id);
    }

}
