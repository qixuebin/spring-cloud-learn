package com.itmuch.cloud.config;

import com.itmuch.cloud.service.SecurityUserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 * Description
 * ${DESCRIPTION}
 * DATE 2018/3/21.
 *
 * @author qixuebin.
 */
@Configuration
public class WebSecurityConfigurer extends WebSecurityConfigurerAdapter{


    @Autowired
    private SecurityConfig securityConfig;

    @Bean
    public UserDetailsService userDetailsService(){
        return new SecurityUserDetailsServiceImpl();
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {

        String[] url = securityConfig.getSecurityUrl().split("\\.");
        for (String string : url) {
            System.out.println(string);
        }
        http
                .authorizeRequests()
                .antMatchers(url).hasRole("ADMIN")//"/user-path/simple/**","/user-path/test/get/**"
                .anyRequest().permitAll()
                .and()
                .httpBasic();
        /*        .authorizeRequests()
                        .antMatchers("/auth").authenticated()       // 需携带有效 token
                        .antMatchers("/admin").hasAuthority("admin")   // 需拥有 admin 这个权限
                        .antMatchers("/ADMIN").hasRole("ADMIN")     // 需拥有 ADMIN 这个身份
                        .anyRequest().permitAll()       // 允许所有请求通过
                        .and()
                        .csrf()
                        .disable()                      // 禁用 Spring Security 自带的跨域处理
                        .sessionManagement()                        // 定制我们自己的 session 策略
                        .sessionCreationPolicy(SessionCreationPolicy.STATELESS); // 调整为让 Spring Security 不创建和使用 session*/

    }


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .userDetailsService(userDetailsService());

    }
}
