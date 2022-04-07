package com.miao.tool_utils.encrypt;

import org.apache.commons.codec.binary.Base64;

import java.io.UnsupportedEncodingException;

/**
 * CreateDate:2016年11月30日下午2:33:30
 *
 * @version V1.0
 * @Description: base64编码工具类，使用commons-codec实现
 * @author:yuzhao
 */
public class Base64ApacheUtil {

    //默认编码集
    private static final String ENCODING_DEFAULT = "UTF-8";

    public static String encrypt(String data) {
        byte[] bytes = Base64.encodeBase64(data.getBytes());
        return new String(bytes);
    }

    public static String decodeToString(String encryData) {
        byte[] bytes = Base64.decodeBase64(encryData.getBytes());
        return new String(bytes);
    }

    /**
     * @param s
     * @param encoding
     * @return
     * @throws UnsupportedEncodingException
     * @Description::base64编码. <br/>
     */
    public static String encode(String s, String encoding) throws UnsupportedEncodingException {
        return Base64.encodeBase64String(s.getBytes(encoding));
    }

    /**
     * @param s
     * @return
     * @throws UnsupportedEncodingException
     * @Description::base64编码. <br/>
     * @author yuzhao
     */
    public static String encoding(String s) throws UnsupportedEncodingException {
        return encode(s, ENCODING_DEFAULT);
    }

    /**
     * @param s
     * @param encoding
     * @return
     * @throws UnsupportedEncodingException
     * @Description::base64解码. <br/>
     * @author yuzhao
     */
    public static String decode(String s, String encoding) throws UnsupportedEncodingException {
        byte[] bytes = Base64.decodeBase64(s);
        return new String(bytes, encoding);
    }

    /**
     * @param s
     * @return
     * @throws UnsupportedEncodingException
     * @Description::base64解码. <br/>
     * @author yuzhao
     */
    public static String decode(String s) throws UnsupportedEncodingException {
        return decode(s, ENCODING_DEFAULT);
    }

    public static void main(String[] args) throws UnsupportedEncodingException {
//		String s = "src=http://www.chtfund.com/fundDetail.do?tradeFundCode=000001&str=恒天明泽公募产品交易网站";
//		String s1 = encoding(s);
//		System.out.println(s1);
//		String s2 = decode(s1);
//		System.out.println(s2);
        String str1 = "c3JjPWh0dHA6Ly93d3cuY2h0ZnVuZC5jb20vZnVuZERldGFpbC5kbz90cmFkZUZ1bmRDb2RlPTAwMDAwMSZzdHI95oGS5aSp5piO5rO95YWs5Yuf5Lqn5ZOB5Lqk5piT572R56uZJnRpY2tldD02Y2FlN2NhZGRkYzRhZjFmMmY1YWUxY2ZiMzA2Yjc5MDZlMGEzMWVkNzMwZGI0OTZmNjcxZDA3Mjk1NGI3ZDRjNjFhYmY4MjYyZTRkNjVkOWIwOGU5NTdiNWVjZjZhZjMmaHNpZD1jOTI2ZGQ3MzI3MDkzMDY4NTZjZWEyZDhlN2QxNTJjMw==";
//		String str = "c3JjPWh0dHA6Ly93d3cuY2h0ZnVuZC5jb20vZnVuZERldGFpbC5kbz90cmFkZUZ1bmRDb2RlPTAwMDAwMSZzdHI95oGS5aSp5piO5rO95YWs5Yuf5Lqn5ZOB5Lqk5piT572R56uZ";
        System.out.println(decode(str1));
    }

}
