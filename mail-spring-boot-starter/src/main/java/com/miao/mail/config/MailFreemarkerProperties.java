package com.miao.mail.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Getter
@Setter
@ConfigurationProperties(prefix = "spring.freemarker")
public class MailFreemarkerProperties {
    private String contentType;
    private String suffix;
    private String templateLoaderPath;
    private String charset;
    private String checkTemplateLocation;
}
