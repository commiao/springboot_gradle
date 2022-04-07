package com.miao.tool_utils.encrypt;

import java.util.Base64;

public class Base64JdkUtil {

    public static String encrypt(String encryptData) {
        return encrypt(encryptData.getBytes());
    }

    private static String encrypt(byte[] bytes) {
        Base64.Encoder encoder = Base64.getEncoder();
        return encoder.encodeToString(bytes);
    }

    public static String decodeToString(String encryptData) {
        Base64.Decoder decoder = Base64.getDecoder();
        return new String(decoder.decode(encryptData));
    }

    public static String decode(byte[] bytes) {
        Base64.Decoder decoder = Base64.getDecoder();
        return new String(decoder.decode(bytes));
    }

    public static void main(String[] args) {
        String src = "imooc security base64";
        String encryptStr = encrypt(src);
        System.out.println("加密后：" + encryptStr);
        System.out.println("解密后：" + decodeToString(encryptStr));
    }

}
