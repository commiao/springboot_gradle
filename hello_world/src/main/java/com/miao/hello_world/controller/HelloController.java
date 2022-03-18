package com.miao.hello_world.controller;

import com.miao.hello_core.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
// service包路径的原因-》需要指定扫包路径
@ComponentScan("com.miao.hello_core")
public class HelloController {

    @Autowired
    HelloService helloService;

    @RequestMapping("/say")
    public String say() {
        return helloService.say();
    }

}
