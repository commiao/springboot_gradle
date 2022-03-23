package com.miao.demospringbootstarter.Service;

import com.miao.demospringbootstarter.config.CustomProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MyDemoStarterServiceImpl implements MyDemoStarterService {
    @Autowired
    CustomProperties customProperties;

    @Override
    public String sayHello() {
        return customProperties.getHerb();
    }
}
