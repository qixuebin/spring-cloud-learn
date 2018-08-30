package com.itmuch.cloud.authorization;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author zhuwj
 * @version V1.0
 * @Description:  授权服务启动入口
 * @date 2018/1/21.
 */

@SpringBootApplication
@EnableEurekaClient
public class AuthoriaztionApplication {
    public static void main(String[] args) {
        SpringApplication.run(AuthoriaztionApplication.class, args);
    }
}
