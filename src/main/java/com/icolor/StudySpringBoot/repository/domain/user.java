package com.icolor.StudySpringBoot.repository.domain;

import com.fasterxml.jackson.annotation.JsonView;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Past;
import java.util.Date;

/**
 * Created by admin on 2017/9/5.
 */
public class user {
    public interface UserSimpleView{}
    public interface UserDetailView extends UserSimpleView{}

    int id;
   private String name;
   private String email;
   private String mobile;
    private Date birthDay;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public Date getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(Date birthDay) {
        this.birthDay = birthDay;
    }
}
