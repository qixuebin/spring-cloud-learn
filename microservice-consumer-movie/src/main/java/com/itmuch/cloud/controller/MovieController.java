package com.itmuch.cloud.controller;



import com.itmuch.cloud.entity.User;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class MovieController {

	@Autowired
	private RestTemplate restTemplate;
	
	@Value("${user.userServicePath}")
	private String userServicePath;
	
	
//	@GetMapping("/movie/{id}")
	@RequestMapping(value = "/movie/{id}",method = RequestMethod.GET)
	@ApiOperation(value = "查询用户信息",notes = "根据id查询用户信息")
	@ApiImplicitParam(name = "id",value = "用户Id",required = true,dataType = "Long")
	public User findById(@PathVariable Long id){
		
		return this.restTemplate.getForObject(userServicePath+id, User.class);
	}
}
