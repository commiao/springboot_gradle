package com.miao.demospringbootstarter;

import com.miao.demospringbootstarter.Service.MyDemoStarterService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MyDemoStarterServiceTest {

    @Autowired
    MyDemoStarterService myDemoStarterService;

    @DisplayName("根据部门名称，查询用户")
    @Test
    public void testMyDemo() {
        String str = myDemoStarterService.sayHello();
        System.out.println("==============" + str);
    }

}
