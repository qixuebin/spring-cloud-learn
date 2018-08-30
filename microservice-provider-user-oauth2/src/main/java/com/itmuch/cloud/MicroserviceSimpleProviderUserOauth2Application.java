package com.itmuch.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
//@EnableDiscoveryClient
class MicroserviceSimpleProviderUserOauth2Application {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviceSimpleProviderUserOauth2Application.class, args);
	}
}
