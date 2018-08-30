package com.itmuch.cloud.controller;

import com.itmuch.cloud.entity.User;
import com.itmuch.cloud.repository.UserRepository;
import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

/**
 * @author qixuebin
 * @create 2017-12-18 14:26
 **/
@RestController
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @Qualifier("eurekaClient")
    @Autowired
    private EurekaClient eurekaClient;

    @Autowired
    private DiscoveryClient discoveryClient;

    @GetMapping("/simple/{id}")
    //@RequestMapping(value = "/xxx",method = RequestMethod.GET)
    public User findById(@PathVariable Long id){

        return userRepository.findOne(id);
    }
    
    @GetMapping("/eureka-instance")
    public String serviceUrl(){
    	InstanceInfo instance = eurekaClient.getNextServerFromEureka("MICROSERVICE-PROVIDER-USER", false);
    	return instance.getHomePageUrl();
    }
    
    @GetMapping("instance-info")
    public ServiceInstance showInfo(){
    	ServiceInstance localServiceInstance = discoveryClient.getLocalServiceInstance();
    	return localServiceInstance;
    }
    
    @PostMapping("/user")
    public User postUser(@RequestBody User user){
    	
    	return user;
    }
    
    @GetMapping("/getUser")
    public User getUser(User user){
    	
    	return user;
    }
    @GetMapping("/test/get")
    @ResponseBody
    public String getString(){
        return "hello world";
    }
    @GetMapping("/test2/get2")
    @ResponseBody
    public String getString2(){
        return "hello world2";
    }

}
