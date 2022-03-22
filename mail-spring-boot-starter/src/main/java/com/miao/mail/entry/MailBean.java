package com.miao.mail.entry;

import lombok.Data;

import java.io.Serializable;

/**
 * @author lance(ZYH)
 * @function 发送邮件-封装接受者信息
 * @date 2018-07-07 13:11
 */
@Data
public class MailBean implements Serializable {
    private String recipient; //邮件接收人
    private String subject; //邮件主题

    /**
     * 通过","区分多个收件人
     *
     * @return
     */
    public String[] getRecipientArr() {
        if (recipient != null) {
            return recipient.split(",");
        }
        return new String[]{};
    }
}
