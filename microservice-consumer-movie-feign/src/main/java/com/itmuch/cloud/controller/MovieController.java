package com.itmuch.cloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.itmuch.cloud.entity.User;
import com.itmuch.cloud.feign.UserFeignClient;

@RestController
public class MovieController {	
	
	@Autowired
	private UserFeignClient userFeignClient;
	
	@GetMapping("/movie/{id}")
	public User findById(@PathVariable Long id){
		
		return this.userFeignClient.findById(id);
	}
	
	@GetMapping("/test-post")
	public User postUser(User user){
		
		
		return this.userFeignClient.postUser(user);
	}
	
	@GetMapping("/test-get")
	public User getUser(User user){
		
		
		return this.userFeignClient.getUser(user.getId(),user.getName(),user.getUsername());
	}
}
