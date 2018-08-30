package com.itmuch.cloud;

import de.codecentric.boot.admin.config.EnableAdminServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
@EnableAdminServer
public class MicroserviceAdminApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviceAdminApplication.class, args);
	}
}
