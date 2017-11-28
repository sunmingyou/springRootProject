package com.icolor.StudySpringBoot.repository.mapper;

import com.icolor.StudySpringBoot.repository.domain.user;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by admin on 2017/9/5.
 **/
 @Repository
public interface UserMapper {

    @Select(value = "select * from users")
    public List<user> getUsers();

    @Select(value="select * from users where id=#{id}")
    public user getOne(String id);

    @Insert(value = "insert into users(name,email,mobile) values(#{name},#{email},#{mobile})")
    public boolean createUser(user user);

    @Update(value = "update users set name=#{name},email=#{email},mobile=#{mobile} where id=#{id}")
    public boolean updateUser(user user);

    @Delete(value = "delete from users where id=#{id}")
    public boolean deleteUser(String id);

}
