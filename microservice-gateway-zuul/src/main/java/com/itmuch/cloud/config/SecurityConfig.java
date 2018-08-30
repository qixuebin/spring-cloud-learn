package com.itmuch.cloud.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 * Description
 * ${DESCRIPTION}
 * DATE 2018/3/21.
 *
 * @author qixuebin.
 */
@Configuration
public class SecurityConfig {

    @Value("${security.name}")
    private String name;

    @Value("${security.password}")
    private String password;

    @Value("${security.role}")
    private String role;

    @Value("${security.url}")
    private String securityUrl;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getSecurityUrl() {
        return securityUrl;
    }

    public void setSecurityUrl(String securityUrl) {
        this.securityUrl = securityUrl;
    }
}
