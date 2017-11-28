package com.icolor.StudySpringBoot.security.validate.code;

import org.springframework.security.core.AuthenticationException;

/**
 * Created by admin on 2017/11/7.
 */
public class ValidateCodeException extends AuthenticationException {

    public ValidateCodeException(String msg) {
        super(msg);
    }
}

