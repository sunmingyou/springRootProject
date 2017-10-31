package com.icolor.StudySpringBoot.interceptor;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by admin on 2017/10/16.
 */
public class UnAuthenticationException  extends RuntimeException {
    public UnAuthenticationException(String message) {
        super(message);
    }
    public Map<String,Object> getClient(){
        Map<String,Object> clientInfo=new HashMap<String,Object>();
        clientInfo.put("ip","127.0.0.1");
        clientInfo.put("role","role_user");
        return clientInfo;
    }
}
