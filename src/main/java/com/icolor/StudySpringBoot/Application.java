package com.icolor.StudySpringBoot;

import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * Created by admin on 2017/8/23.
 */
@SpringBootApplication
@MapperScan("com.icolor.StudySpringBoot.repository.mapper")
@EnableScheduling
public class Application extends SpringBootServletInitializer {
    private static final Logger logger = LoggerFactory.getLogger(Application.class);

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        // TODO Auto-generated method stub
        return builder.sources(Application.class);
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(Application.class, args);
    }

}

