package com.miao.demospringbootstarter;

import com.miao.demospringbootstarter.config.CustomProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(CustomProperties.class)
@ComponentScan
public class CustomAutoConfiguration {

    @Bean
    public CustomService customService() {
        return new CustomService();
    }

}
