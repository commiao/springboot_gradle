package com.miao.mail.controller;

import com.miao.mail.entry.FreeMarkerMailBean;
import com.miao.mail.entry.MailBean;
import com.miao.mail.entry.MimeMailBean;
import com.miao.mail.handle.MyMailFreeMarkerSend;
import com.miao.mail.handle.MyMailMimeSend;
import com.miao.mail.handle.MyMailSimpleSend;
import lombok.extern.slf4j.Slf4j;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/test")
@Slf4j
public class TestController {

    @Autowired
    MyMailSimpleSend myMailSimpleSend;
    @Autowired
    MyMailMimeSend myMailMimeSend;
    @Autowired
    MyMailFreeMarkerSend myMailFreeMarkerSend;
    @Autowired
    ResourceLoader resourceLoader;

    private final String RECIPIENT = "jingmiao@chtwm.com,commiao@163.com";

    @RequestMapping("/sendSimpleMail")
    public String sendSimpleMail() {
        MailBean mailBean = new MailBean();
        mailBean.setRecipient(RECIPIENT);
        mailBean.setSubject("test_subject");
        myMailSimpleSend.sendSimpleMail(mailBean, "test_content");
        return "ok";
    }

    @RequestMapping("/sendHTMLMail")
    public String sendHTMLMail() {
        MimeMailBean mimeMailBean = new MimeMailBean();
        mimeMailBean.setRecipient(RECIPIENT);
        mimeMailBean.setSubject("test_subject");
        mimeMailBean.setHtml(true);
        StringBuilder sb = new StringBuilder();
        sb.append("<h1>SpirngBoot测试邮件HTML</h1>")
                .append("\"<p style='color:#F00'>你是真的太棒了！</p>")
                .append("<p style='text-align:right'>右对齐</p>");
        mimeMailBean.setText(sb.toString());
        myMailMimeSend.sendHTMLMail(mimeMailBean);
        return "ok";
    }

    @RequestMapping("/sendAttachmentMail")
    public String sendAttachmentMail() {
        MimeMailBean mimeMailBean = new MimeMailBean();
        mimeMailBean.setRecipient(RECIPIENT);
        mimeMailBean.setSubject("test_subject");
        mimeMailBean.setText("test_content");
        Map<String, File> attachmentMap = new HashMap<>();
        try {
            Resource resource = resourceLoader.getResource("classpath:static/attachment/001.jpg");
            InputStream is = resource.getInputStream();
            File file = asFile(is);
            attachmentMap.put("马斯洛五层需求.jpg", file);
            is.close();
            Resource resource2 = resourceLoader.getResource("classpath:static/attachment/002.zip");
            InputStream is2 = resource2.getInputStream();
            File file2 = asFile(is2);
            attachmentMap.put("压缩文件.zip", file2);
            is.close();
        } catch (Exception e) {
            log.error("获取文件失败", e);
        }
        mimeMailBean.setAttachmentMap(attachmentMap);
        myMailMimeSend.sendAttachmentMail(mimeMailBean);
        return "ok";
    }

    @RequestMapping("/sendInlineMail")
    public String sendInlineMail() {
        MimeMailBean mimeMailBean = new MimeMailBean();
        mimeMailBean.setRecipient(RECIPIENT);
        mimeMailBean.setSubject("test_subject");
        StringBuilder sb = new StringBuilder("<html><body>");
        sb.append("带静态资源的邮件内容，这个一张IDEA配置的照片:<img src='cid:picture' />")
                .append("测试多张图片的静态资源文件:<img src='cid:picture2' />")
                .append("</body></html>");
        mimeMailBean.setHtml(true);
        mimeMailBean.setText(sb.toString());
        Map<String, File> contentFileMap = new HashMap<>();
        try {
            Resource resource = resourceLoader.getResource("classpath:static/image/image01.jpg");
            InputStream is = resource.getInputStream();
            File file = asFile(is);
            contentFileMap.put("picture", file);
            is.close();
            Resource resource2 = resourceLoader.getResource("classpath:static/image/image02.jpeg");
            InputStream is2 = resource2.getInputStream();
            File file2 = asFile(is2);
            contentFileMap.put("picture2", file2);
            is2.close();
        } catch (Exception e) {
            log.error("获取文件失败", e);
        }
        mimeMailBean.setContentFileMap(contentFileMap);
        myMailMimeSend.sendInlineMail(mimeMailBean);
        return "ok";
    }

    @RequestMapping("/sendTemplateMail")
    public String sendTemplateMail() {
        FreeMarkerMailBean mailBean = new FreeMarkerMailBean();
        mailBean.setRecipient(RECIPIENT);
        mailBean.setSubject("test_subject");
        mailBean.setFileName("mail.ftl");
        Map<String, Object> model = new HashMap<String, Object>();
        model.put("content", "test_content");
        model.put("title", "标题Mail中使用了FreeMarker");
        mailBean.setModelMap(model);
        myMailFreeMarkerSend.sendTemplateMail(mailBean);
        return "ok";
    }

    private File asFile(InputStream in) throws IOException {
        File tempFile = File.createTempFile("whitelist", ".tmp");
        tempFile.deleteOnExit();
        FileOutputStream out = new FileOutputStream(tempFile);
        IOUtils.copy(in, out);
        return tempFile;
    }

}
