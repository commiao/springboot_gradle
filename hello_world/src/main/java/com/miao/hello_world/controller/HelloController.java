package com.miao.hello_world.controller;

import com.miao.demospringbootstarter.CustomService;
import com.miao.demospringbootstarter.Service.MyDemoStarterService;
import com.miao.hello_core.service.HelloService;
import com.miao.mail.handle.MyMailSimpleSend;
import com.miao.mail.entry.MailBean;
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

    @Autowired
    MyMailSimpleSend myMailSimpleSend;

    @Autowired
    CustomService customService;

    @Autowired
    MyDemoStarterService myDemoStarterService;

    @RequestMapping("/say")
    public String say() {
        return helloService.say();
    }

    @RequestMapping("/sendMail")
    public String sendMail() {
        MailBean mailBean = new MailBean();
        mailBean.setRecipient("jingmiao@chtwm.com");
        mailBean.setSubject("starter-test");
        myMailSimpleSend.sendSimpleMail(mailBean, "hello world！");
        return "ok";
    }

    @RequestMapping("/sayCustom")
    public String sayCustom() {
        return customService.sayHello();
    }

    @RequestMapping("/sayMyDemo")
    public String sayMyDemo() {
        return myDemoStarterService.sayHello();
    }

}
