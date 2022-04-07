package com.miao.demo.swagger;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.oas.annotations.EnableOpenApi;

@SpringBootApplication
@EnableOpenApi
public class DemoSwaggerApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoSwaggerApplication.class, args);
    }

}
