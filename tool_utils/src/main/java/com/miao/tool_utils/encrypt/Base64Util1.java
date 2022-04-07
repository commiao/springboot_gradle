package com.miao.tool_utils.encrypt;

public class Base64Util1 {
    //定义要加密的字符串
    private static String src = "imooc security base64";

    public static void main(String[] args) {
        String jdkStrEn = Base64JdkUtil.encrypt(src);
        String jdkStr = Base64JdkUtil.decodeToString(jdkStrEn);
        System.out.println("jdkStrEn:" + jdkStrEn);
        System.out.println("jdkStr:" + jdkStr);

        String bouncyStrEn = Base64BouncycastleUtil.encrypt(src);
        String bouncyStr = Base64BouncycastleUtil.decodeToString(bouncyStrEn);
        System.out.println("bouncyStrEn:" + bouncyStrEn);
        System.out.println("bouncyStr" + bouncyStr);

        String apacheStrEn = Base64ApacheUtil.encrypt(src);
        String apacheStr = Base64ApacheUtil.decodeToString(apacheStrEn);
        System.out.println("apacheStrEn:" + apacheStrEn);
        System.out.println("apacheStr" + apacheStr);

    }

}
