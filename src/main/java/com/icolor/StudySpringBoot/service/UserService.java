package com.icolor.StudySpringBoot.service;

import com.icolor.StudySpringBoot.repository.domain.user;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Created by admin on 2017/9/5.
 */

public interface UserService {
    public List<user> getUsers();
    public user getOne(String id);
    public boolean createUser(user user);
    public boolean updateUser(user user) throws Exception;
    public boolean deleteUser(String id) throws Exception;

}
