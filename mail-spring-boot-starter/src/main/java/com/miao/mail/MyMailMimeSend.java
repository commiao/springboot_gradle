package com.miao.mail;

import com.miao.mail.config.MailProperties;
import com.miao.mail.entry.MimeMailBean;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import javax.mail.internet.MimeMessage;
import java.io.File;
import java.util.Map;

@Slf4j
@Component
public class MyMailMimeSend {
    @Autowired
    MailProperties mailProperties;
    @Autowired
    JavaMailSender javaMailSender;

    /**
     * 发送HTML格式的邮件
     *
     * @param mimeMailBean
     */
    public void sendHTMLMail(MimeMailBean mimeMailBean) {
        MimeMessage mimeMailMessage = null;
        try {
            mimeMailMessage = javaMailSender.createMimeMessage();
            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMailMessage, true);
            mimeMessageHelper.setFrom(mailProperties.getMailSender(), mailProperties.getMailPersonal());
            mimeMessageHelper.setTo(mimeMailBean.getRecipientArr());
            mimeMessageHelper.setSubject(mimeMailBean.getSubject());
            mimeMessageHelper.setText(mimeMailBean.getText(), mimeMailBean.isHtml());
            javaMailSender.send(mimeMailMessage);
        } catch (Exception e) {
            log.error("发送HTML格式的邮件失败", e);
        }
    }

    /**
     * 发送带附件格式的邮件
     *
     * @param mimeMailBean
     */
    public void sendAttachmentMail(MimeMailBean mimeMailBean) {
        MimeMessage mimeMailMessage = null;
        try {
            mimeMailMessage = javaMailSender.createMimeMessage();
            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMailMessage, true);
            mimeMessageHelper.setFrom(mailProperties.getMailSender(), mailProperties.getMailPersonal());
            mimeMessageHelper.setTo(mimeMailBean.getRecipientArr());
            mimeMessageHelper.setSubject(mimeMailBean.getSubject());
            mimeMessageHelper.setText(mimeMailBean.getText());
            for (Map.Entry<String, File> entry : mimeMailBean.getAttachmentMap().entrySet()) {
                FileSystemResource file = new FileSystemResource(entry.getValue());
                mimeMessageHelper.addAttachment(entry.getKey(), file);
            }
            javaMailSender.send(mimeMailMessage);
        } catch (Exception e) {
            log.error("发送带附件格式的邮件失败", e);
        }
    }

    /**
     * 发送带静态资源的邮件
     *
     * @param mimeMailBean
     */
    public void sendInlineMail(MimeMailBean mimeMailBean) {
        MimeMessage mimeMailMessage = null;
        try {
            mimeMailMessage = javaMailSender.createMimeMessage();
            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMailMessage, true);
            mimeMessageHelper.setFrom(mailProperties.getMailSender(), mailProperties.getMailPersonal());
            mimeMessageHelper.setTo(mimeMailBean.getRecipientArr());
            mimeMessageHelper.setSubject(mimeMailBean.getSubject());
            mimeMessageHelper.setText(mimeMailBean.getText(), mimeMailBean.isHtml());
            for (Map.Entry<String, File> entry : mimeMailBean.getContentFileMap().entrySet()) {
                FileSystemResource file = new FileSystemResource(entry.getValue());
                mimeMessageHelper.addInline(entry.getKey(), file);
            }
            javaMailSender.send(mimeMailMessage);
        } catch (Exception e) {
            log.error("发送带静态资源的邮件失败", e);
        }
    }
}
