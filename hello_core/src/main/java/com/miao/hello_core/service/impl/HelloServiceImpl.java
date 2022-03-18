package com.miao.hello_core.service.impl;

import com.miao.hello_core.service.HelloService;
import org.springframework.stereotype.Service;

@Service
public class HelloServiceImpl implements HelloService {

    @Override
    public String say() {
        return "Hello world!";
    }

}
