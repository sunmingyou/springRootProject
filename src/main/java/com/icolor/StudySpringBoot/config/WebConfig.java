package com.icolor.StudySpringBoot.config;

import com.icolor.StudySpringBoot.interceptor.TimeFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by admin on 2017/10/29.
 */
@Configuration
public class WebConfig {

    @Bean
    public FilterRegistrationBean timeFilter(){
        FilterRegistrationBean filterRegistrationBean=new FilterRegistrationBean();
        TimeFilter timeFilter=new TimeFilter();
        filterRegistrationBean.setFilter(timeFilter);
        List<String> urls=new ArrayList<String>();
        urls.add("/user/*");
        filterRegistrationBean.setUrlPatterns(urls);
        return filterRegistrationBean;
    }
}
