package com.icolor.StudySpringBoot.security.validate.code;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import org.thymeleaf.util.StringUtils;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by admin on 2017/11/7.
 */
public class ValidateCodeFilter extends OncePerRequestFilter {


    AuthenticationFailureHandler authenticationFailureHandler;
    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {
        if(StringUtils.equals(httpServletRequest.getRequestURI(),"/authentication/form")&&
                StringUtils.equalsIgnoreCase("post",httpServletRequest.getMethod())){
            try {
                validate(httpServletRequest);
                filterChain.doFilter(httpServletRequest,httpServletResponse);
            } catch (ValidateCodeException e) {
                authenticationFailureHandler.onAuthenticationFailure(httpServletRequest,httpServletResponse,e);
            }
        }
        else {
            filterChain.doFilter(httpServletRequest,httpServletResponse);
        }
    }

    private void validate(HttpServletRequest request) throws ValidateCodeException{
         ImageCode codeInSession =(ImageCode) request.getSession().getAttribute(ValidateController.SESSION_KEY);
        String codeInRequest=request.getParameter("imageCode");
        if(StringUtils.isEmpty(codeInRequest)){
            throw new ValidateCodeException("图形验证码不能为空");
        }
        else if(codeInSession.isExpire()){
            throw new ValidateCodeException("图形验证码已過期");
        }
       else if(!StringUtils.equalsIgnoreCase(codeInSession.getCode(),codeInRequest)){
            throw new ValidateCodeException("图形验证码不正确");
        }
        else{

        }
        request.getSession().removeAttribute(ValidateController.SESSION_KEY);
    }

    public AuthenticationFailureHandler getAuthenticationFailureHandler() {
        return authenticationFailureHandler;
    }

    public void setAuthenticationFailureHandler(AuthenticationFailureHandler authenticationFailureHandler) {
        this.authenticationFailureHandler = authenticationFailureHandler;
    }
}
