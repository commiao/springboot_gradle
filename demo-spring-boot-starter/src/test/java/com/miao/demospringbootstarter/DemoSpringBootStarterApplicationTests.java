package com.miao.demospringbootstarter;

import com.miao.demospringbootstarter.Service.MyDemoStarterService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

@SpringBootTest
class DemoSpringBootStarterApplicationTests {

    @Test
    void contextLoads() {
    }

    @Autowired
    MyDemoStarterService myDemoStarterService;

    @Test
    public void testMyDemo() {
        String str = myDemoStarterService.sayHello();
        System.out.println("==============" + str);
    }

}
