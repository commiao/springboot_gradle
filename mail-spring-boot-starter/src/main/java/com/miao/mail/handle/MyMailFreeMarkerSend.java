package com.miao.mail.handle;

import com.miao.mail.config.MailProperties;
import com.miao.mail.entry.FreeMarkerMailBean;
import freemarker.template.Configuration;
import freemarker.template.Template;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@Slf4j
public class MyMailFreeMarkerSend {
    @Autowired
    MailProperties mailProperties;
    @Autowired
    Configuration configuration;
    @Autowired
    JavaMailSender javaMailSender;

    /**
     * 发送FreeMarker模板邮件
     *
     * @param freeMarkerMailBean
     * @throws MessagingException
     */
    public void sendTemplateMail(FreeMarkerMailBean freeMarkerMailBean) {
        MimeMessage mimeMailMessage = null;
        try {
            mimeMailMessage = javaMailSender.createMimeMessage();
            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMailMessage, true);
            mimeMessageHelper.setFrom(mailProperties.getMailSender(), mailProperties.getMailPersonal());
            mimeMessageHelper.setTo(freeMarkerMailBean.getRecipientArr());
            mimeMessageHelper.setSubject(freeMarkerMailBean.getSubject());
            Template template = configuration.getTemplate(freeMarkerMailBean.getFileName());
            String text = FreeMarkerTemplateUtils.processTemplateIntoString(template, freeMarkerMailBean.getModelMap());
            mimeMessageHelper.setText(text, true);

            javaMailSender.send(mimeMailMessage);
        } catch (Exception e) {
            log.error("邮件发送失败", e);
        }

    }

}
