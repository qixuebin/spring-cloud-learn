package com.itmuch.cloud.domain;

import java.util.List;

/**
 * Description
 * ${DESCRIPTION}
 * DATE 2018/3/21.
 *
 * @author qixuebin.
 */

public class UserInfo {
    //用户名
    private String name;
    //密码
    private String password;
    //权限
    private List<String> role;

    public UserInfo(String name, String password, List<String> role) {
        this.name = name;
        this.password = password;
        this.role=role;
    }


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

    public List<String> getRole() {
        return role;
    }

    public void setRole(List<String> role) {
        this.role = role;
    }
}
