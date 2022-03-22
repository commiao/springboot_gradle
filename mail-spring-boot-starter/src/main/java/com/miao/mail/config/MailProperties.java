package com.miao.mail.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
@ConfigurationProperties(prefix = "spring.mail")
@EnableConfigurationProperties(MailFreemarkerProperties.class)
public class MailProperties {
    private String host;
    private String username;
    private String password;
    /**
     * 发件人邮箱
     */
    @Value("${mail.sender}")
    private String mailSender;
    /**
     * 发件人昵称
     */
    @Value("${mail.personal:miao}")
    private String mailPersonal;
}
