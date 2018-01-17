package com.icolor.StudySpringBoot.repository.mapper;

import com.icolor.StudySpringBoot.repository.domain.user;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by admin on 2017/9/5.
 **/
public interface UserMapper {

    public List<user> getUsers();

    public user getOne(String uid);

    @Insert(value = "insert into users(name,email,mobile) values(#{name},#{email},#{mobile})")
    public void createUser(user user);

    @Update(value = "update users set name=#{name},email=#{email},mobile=#{mobile} where id=#{id}")
    public void updateUser(user user);

    @Delete(value = "delete from users where id=#{id}")
    public void deleteUser(String id);

}
