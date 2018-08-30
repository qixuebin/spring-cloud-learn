package com.itmuch.cloud;/**
 * Description
 * <p>
 * </p>
 * DATE 2017/12/28.
 *
 * @author qixuebin.
 */

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Swagger2的基础类
 * @author qixuebin
 * @create 2017-12-28 15:30
 **/
@Configuration
@EnableSwagger2
@Profile("dev")
public class Swagger2 {
    /**
     * Create rest api docket.
     *
     * @return the docket
     */
    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.itmuch.cloud"))
                .paths(PathSelectors.any())
                .build();
    }

    /**
     * generate basic api info
     * @return api info
     */
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("API Document for Inventory")
                .description("Inventory/Timeslot Management Service.")
                .contact(new Contact("GuoJing",
                        "https://www.sayabc.com", "guojing@vipkid.com.cn"))
                .build();
    }
}
