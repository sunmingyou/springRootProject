package com.icolor.StudySpringBoot.config;

import com.icolor.StudySpringBoot.security.LoginType;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * Created by admin on 2017/11/4.
 */
@ConfigurationProperties(prefix = "icolor.security")
@Component
public class SecurityConfigProperites {

    private String loginPage;
    private LoginType loginType= LoginType.JSON;

    public String getLoginPage() {
        return loginPage;
    }

    public void setLoginPage(String loginPage) {
        this.loginPage = loginPage;
    }

    public LoginType getLoginType() {
        return loginType;
    }

    public void setLoginType(LoginType loginType) {
        this.loginType = loginType;
    }
}
