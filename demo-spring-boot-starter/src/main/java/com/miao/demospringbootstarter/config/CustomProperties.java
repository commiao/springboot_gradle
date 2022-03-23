package com.miao.demospringbootstarter.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Getter
@Setter
@ConfigurationProperties(prefix = "demo.springboot.starter")
public class CustomProperties {
    private String herb = "test_herb";
}
