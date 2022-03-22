package com.miao.mail.entry;

import lombok.Data;

import java.io.File;
import java.util.Map;

@Data
public class MimeMailBean extends MailBean {
    /**
     * 支持复杂格式（MimeMail）
     */
    private String text;
    private boolean isHtml;
    /**
     * 静态资源文件与文本标签对应关系
     * key->contentId  cid文本标签
     * value->File resource文件
     */
    private Map<String, File> contentFileMap;
    /**
     * 附件文件对应关系
     * key->attachmentFilename文件名
     * value->attachmentFile文件
     */
    private Map<String, File> attachmentMap;
}
