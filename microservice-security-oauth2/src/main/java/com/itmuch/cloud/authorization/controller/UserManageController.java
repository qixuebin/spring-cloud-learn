package com.itmuch.cloud.authorization.controller;

import com.itmuch.cloud.authorization.domain.ClientDetailsDO;
import com.itmuch.cloud.authorization.service.UserManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

/**
 * Description
 * ${DESCRIPTION}
 * DATE 2018/3/16.
 *
 * @author qixuebin.
 */
@RestController
@RequestMapping("/user")
public class UserManageController {

    @Autowired
    private UserManageService userManageService;

    @GetMapping("/get")
    @ResponseBody
    public String get(){

        Object pricple =  SecurityContextHolder.getContext().getAuthentication();
        System.out.println(pricple.toString());
        return pricple.toString();
    }
    @GetMapping("/getClient")
    @ResponseBody
    public ClientDetailsDO getClient(){

        return userManageService.findByClientId("ios");
    }
    /**
     * 各个服务获取验证授权用户信息的接口
     * @param user
     * @return
     */
    @GetMapping("/userinfo")
    public Principal user(Principal user){
        return user;
    }

}
