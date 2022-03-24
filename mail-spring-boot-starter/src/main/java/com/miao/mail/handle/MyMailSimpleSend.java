package com.miao.mail.handle;

import com.miao.mail.config.MailProperties;
import com.miao.mail.entry.MailBean;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

@Slf4j
public class MyMailSimpleSend {
    @Autowired
    MailProperties mailProperties;

    @Autowired
    JavaMailSender javaMailSender;

    /**
     * 发送简单的邮件
     *
     * @param mailBean
     * @param content
     */
    public void sendSimpleMail(MailBean mailBean, String content) {
        try {
            SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
            //邮件发送人
            simpleMailMessage.setFrom(mailProperties.getUsername());
            //邮件接收人
            simpleMailMessage.setTo(mailBean.getRecipientArr());
            //邮件主题
            simpleMailMessage.setSubject(mailBean.getSubject());
            //邮件内容
            simpleMailMessage.setText(content);
            javaMailSender.send(simpleMailMessage);
        } catch (Exception e) {
            log.error("邮件发送失败", e);
        }
    }
}
