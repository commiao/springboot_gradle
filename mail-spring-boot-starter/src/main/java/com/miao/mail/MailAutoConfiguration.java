package com.miao.mail;

import com.miao.mail.config.MailProperties;
import com.miao.mail.handle.MyMailFreeMarkerSend;
import com.miao.mail.handle.MyMailMimeSend;
import com.miao.mail.handle.MyMailSimpleSend;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(MailProperties.class)
public class MailAutoConfiguration {

    @Bean
    public MyMailSimpleSend myMailSimpleSend() {
        return new MyMailSimpleSend();
    }

    @Bean
    public MyMailMimeSend myMailMimeSend() {
        return new MyMailMimeSend();
    }

    @Bean
    public MyMailFreeMarkerSend myMailFreeMarkerSend() {
        return new MyMailFreeMarkerSend();
    }

}
