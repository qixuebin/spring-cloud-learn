package com.itmuch.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * Hello world!
 *
 */
@SpringBootApplication
@EnableEurekaServer
public class MicroserviceEurekaOauth2Application
{
    public static void main( String[] args )
    {
        SpringApplication.run(MicroserviceEurekaOauth2Application.class, args);
    }
}
