package com.icolor.StudySpringBoot.config;

import com.icolor.StudySpringBoot.security.validate.code.ValidateCodeFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.annotation.Resource;

/**
 * Created by admin on 2017/10/29.
 */
@Configuration
public class BrowserSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private AuthenticationSuccessHandler successHandler;
    @Autowired
    private AuthenticationFailureHandler failureHandler;

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();//可以添加自己的加密类（实现PasswordEncoder接口）
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

      /*  ValidateCodeFilter validateCodeFilter=new ValidateCodeFilter();
        validateCodeFilter.setAuthenticationFailureHandler(failureHandler);
        http.addFilterBefore(validateCodeFilter, UsernamePasswordAuthenticationFilter.class)
                .formLogin()
                .loginPage("/login/page")//登录页
                .loginProcessingUrl("/authentication/form")//登录处理url
                .successHandler(successHandler)
                .failureHandler(failureHandler)
                .and()
                .authorizeRequests()
                .antMatchers("/login/page","/login/require","/code*//*","/user*//*").permitAll()//例外的url
                .anyRequest()
                .authenticated()
                .and()
                .csrf().disable()*/;//禁用csrf
       // super.configure(http);
        http.csrf().disable();
    }
}
