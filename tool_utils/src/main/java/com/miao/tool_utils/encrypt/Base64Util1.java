package com.miao.tool_utils.encrypt;

import java.util.Base64;

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

    //jdk方式加密
    public static void jdkBase64() {

        Base64.Encoder encoder = Base64.getEncoder();
        String s = encoder.encodeToString(src.getBytes());
        System.out.println("加密：" + s);
        Base64.Decoder decoder = Base64.getDecoder();
        System.out.println("解密" + new String(decoder.decode(s)));
    }

    //commons codec
    public static void commonsCodesBase64() {
        byte[] bytes = org.apache.commons.codec.binary.Base64.encodeBase64(src.getBytes());
        System.out.println("加密：" + new String(bytes));
        byte[] bytes1 = org.apache.commons.codec.binary.Base64.decodeBase64(bytes);
        System.out.println("解密:" + new String(bytes1));

    }

    //bouncyCastleBase64
    public static void bouncyCastleBase64() {
        byte[] encode = org.bouncycastle.util.encoders.Base64.encode(src.getBytes());
        System.out.println("加密1：" + new String(encode));
        byte[] decode = org.bouncycastle.util.encoders.Base64.decode(encode);
        System.out.println("解密1:" + new String(decode));


    }
}
