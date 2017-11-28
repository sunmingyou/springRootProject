package com.icolor.StudySpringBoot.security;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

/**
 * Created by admin on 2017/10/31.
 */
@Component
public class MyUserService implements UserDetailsService {
    private Logger logger= LoggerFactory.getLogger(getClass());

    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {

        //从数据库查出用户信息
        return new User(userName,passwordEncoder.encode("123456"),true,true,true,true, AuthorityUtils.commaSeparatedStringToAuthorityList("admin"));
    }
}
