package com.miao.hello_world.service;

import com.miao.hello_core.service.HelloService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class HelloServiceTest {

    @Autowired
    HelloService helloService;

    @DisplayName("service单元测试demo")
    @Test
    public void testMyDemo() {
        String str = helloService.say();
        System.out.println("==============" + str);
    }

}
