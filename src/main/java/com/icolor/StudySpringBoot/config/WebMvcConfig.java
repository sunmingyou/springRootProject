package com.icolor.StudySpringBoot.config;

import com.icolor.StudySpringBoot.interceptor.AuthInterceptor;
import com.icolor.StudySpringBoot.interceptor.TimeInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.validation.MessageCodesResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.List;

/**
 * Created by admin on 2017/10/16.
 */
@Configuration
public class WebMvcConfig extends WebMvcConfigurerAdapter {


    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        super.configureDefaultServletHandling(configurer);
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
       //registry.addInterceptor(new LoginInterceptor()).addPathPatterns("/user").excludePathPatterns("/login");
        registry.addInterceptor(new TimeInterceptor()).addPathPatterns("/user/*");
        super.addInterceptors(registry);
    }

    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
        super.configureViewResolvers(registry);
    }

    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        super.configureMessageConverters(converters);
        // test git
    }

    @Override
    public MessageCodesResolver getMessageCodesResolver() {
        return super.getMessageCodesResolver();
    }
}
