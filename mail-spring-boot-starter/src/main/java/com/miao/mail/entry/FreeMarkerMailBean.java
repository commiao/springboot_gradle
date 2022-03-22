package com.miao.mail.entry;

import lombok.Data;

import java.util.Map;

@Data
public class FreeMarkerMailBean extends MailBean {
    /**
     * freeMarker文件（带文件后缀：mail.flt）
     */
    private String fileName;
    /**
     * 对应模板文件中的占位符
     * key->占位符
     * value->替换的内容
     */
    private Map<String, Object> modelMap;
}
