package com.miao.mailspringbootstarter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    MyMailSend myMailSend;

    @RequestMapping("/say")
    public String say() {
        MailBean mailBean = new MailBean();
        mailBean.setRecipient("jingmiao@chtwm.com");
        mailBean.setSubject("test_subject");
        mailBean.setContent("test_content");
        myMailSend.sendSimpleMail(mailBean);
        return "ok";
    }
}
