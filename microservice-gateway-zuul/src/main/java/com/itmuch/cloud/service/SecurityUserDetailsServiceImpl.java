package com.itmuch.cloud.service;

import com.itmuch.cloud.config.SecurityConfig;
import com.itmuch.cloud.domain.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;

/**
 * @author qixuebin
 * @Description: oauth用户实现
 * @date 2018/1/16.
 */
public class SecurityUserDetailsServiceImpl implements UserDetailsService {


//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//
//        String lowcaseUsername = username.toLowerCase();
//        Collection<GrantedAuthority> grantedAuthorities = new HashSet<>();
//        grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_USER"));
//        grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
//        UserDetails user = new User("admin","password",grantedAuthorities);
//
//        //        auth
////                .inMemoryAuthentication()
////                    .withUser("user").password("password").roles("USER").and()
////                    .withUser("admin").password("password").roles("ADMIN","USER");
//        return user;
//    }
    @Autowired
    private SecurityConfig securityConfig;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        String[] roles = securityConfig.getRole().split("\\.");
        List<String> roleList = new ArrayList<>();
        for (String string : roles) {
            roleList.add(string);
        }
        //这里可以以后将用户信息存入数据库
        UserInfo userInfo= new UserInfo(securityConfig.getName(),securityConfig.getPassword(),roleList);

        Collection<GrantedAuthority> grantedAuthorities = new HashSet<>();
        for (String role : userInfo.getRole()) {
            grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_"+role));
        }

        UserDetails user = new User(userInfo.getName(),userInfo.getPassword(),grantedAuthorities);

        return user;
    }
}
