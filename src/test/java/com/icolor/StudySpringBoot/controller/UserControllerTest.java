package com.icolor.StudySpringBoot.controller;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.results.ResultMatchers;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.concurrent.atomic.AtomicInteger;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by admin on 2017/10/24.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserControllerTest {

    @Autowired
    WebApplicationContext applicationContext;

    MockMvc mvc;
    @Before
    public void setup(){
        mvc= MockMvcBuilders.webAppContextSetup(applicationContext).build();
    }

    @Test
    public void testGetOne() throws  Exception{
        MvcResult result= mvc.perform(MockMvcRequestBuilders.get("/user/all").accept(MediaType.APPLICATION_JSON)).andReturn();
       System.out.print(result.getResponse().getContentAsString());
    }

    @Test
    public void testGetAll() throws  Exception{
        MvcResult result= mvc.perform(MockMvcRequestBuilders.get("/user/getall").accept(MediaType.APPLICATION_JSON)).andReturn();
        System.out.print(result.getResponse().getContentAsString());
    }

    @Test
    public void testCreateOne() throws  Exception{
        MvcResult result= mvc.perform(MockMvcRequestBuilders.post("/user/create").contentType(MediaType.APPLICATION_JSON_UTF8)
        .content("{\"id\":2,\"name\":\"sunmingyou2\",\"email\":\"77108887@qq.com\",\"mobile\":\"15800701847\"}"))
                .andReturn();
        System.out.print(result.getResponse().getContentAsString());
    }
    @Test
    public void testUpdate() throws  Exception{
        LocalDate birthDay= LocalDateTime.now().plusSeconds(30).atZone(ZoneId.systemDefault()).toLocalDate();
        String result= mvc.perform(MockMvcRequestBuilders.put("/user/update").contentType(MediaType.APPLICATION_JSON_UTF8)
                .content("{\"id\":2,\"name\":\"sunmingyou\",\"email\":\"77108887@c\",\"mobile\":\"15800701847\",\"birthDay\":\""+birthDay+"\"}"))
                .andExpect(status().isOk())
                .andReturn().getResponse().getContentAsString();
        System.out.print(result);
    }
}
