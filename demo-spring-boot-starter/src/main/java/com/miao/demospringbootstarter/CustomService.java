package com.miao.demospringbootstarter;

import com.miao.demospringbootstarter.config.CustomProperties;
import org.springframework.beans.factory.annotation.Autowired;

public class CustomService {
    @Autowired
    CustomProperties customProperties;

    public String sayHello() {
        return customProperties.getHerb();
    }
}
