/**
 * Copyright (c) 2011-2014, hubin (243194995@qq.com).
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package com.miao.tool_utils.encrypt;

import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.util.encoders.Base64;
import org.bouncycastle.util.encoders.UrlBase64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.security.Security;


/**
 * <p>
 * BASE64编码解码工具包
 * </p>
 * <p>
 * 依赖bcprov-jdk14-1.48.jar
 * </p>
 * <p>
 *
 * @author hubin
 * @Date 2014-6-17
 */
public class Base64BouncycastleUtil {

	private static final Logger logger = LoggerFactory.getLogger(Base64BouncycastleUtil.class);

	/**
	 * 文件读取缓冲区大小
	 */
	private static final int CACHE_SIZE = 1024;

	private static final String ENCODING = "UTF-8";

	public static String decodeToString(String encryptData) {
		return new String(decode(encryptData));
	}


	/**
	 * <p>
	 * BASE64字符串解码为二进制数据
	 * </p>
	 *
	 * @param base64
	 * @return
	 * @throws Exception
	 */
	public static byte[] decode(String base64) {
		return Base64.decode(base64.getBytes());
	}

	public static String encrypt(String data) {
		return encode(data.getBytes());
	}


	/**
	 * <p>
	 * 二进制数据编码为BASE64字符串
	 * </p>
	 *
	 * @param bytes
	 * @return
	 * @throws Exception
	 */
	public static String encode(byte[] bytes) {
		return new String(Base64.encode(bytes));
	}


	/**
	 * BASE64 encrypt
	 *
	 * @param key
	 * @return
	 * @throws Exception
	 */
	public static String encryptBASE64(byte[] key) throws Exception {
		/* 设置加密提供者，解决不同容器加密不一致问题 */
		Security.addProvider(new BouncyCastleProvider());
		byte[] b = UrlBase64.encode(key);
		return new String(b, ENCODING);
	}


	/**
	 * BASE64 decrypt
	 *
	 * @param key
	 * @return
	 * @throws Exception
	 */
	public static byte[] decryptBASE64(String key) throws Exception {
		Security.addProvider(new BouncyCastleProvider());
		return UrlBase64.decode(key.getBytes(ENCODING));
	}


	/**
	 * <p>
	 * 将文件编码为BASE64字符串
	 * </p>
	 * <p>
	 * 大文件慎用，可能会导致内存溢出
	 * </p>
	 *
	 * @param filePath 文件绝对路径
	 * @return
	 * @throws Exception
	 */
	public static String encodeFile(String filePath) throws Exception {
		byte[] bytes = fileToByte(filePath);
		return encode(bytes);
	}


	/**
	 * <p>
	 * BASE64字符串转回文件
	 * </p>
	 *
	 * @param filePath 文件绝对路径
	 * @param base64   编码字符串
	 * @throws Exception
	 */
	public static void decodeToFile(String filePath, String base64) throws Exception {
		byte[] bytes = decode(base64);
		byteArrayToFile(bytes, filePath);
	}


	/**
	 * 文件绝对路径
	 * <p>
	 *
	 * @param linuxDir linux存放目录
	 * @param winDir   win存放目录
	 * @param fileName 文件名
	 * @return String
	 */
	public static String filePath(String linuxDir, String winDir, String fileName) {
		StringBuffer bf = new StringBuffer();
		if ("\\".equals(File.separator)) {
			//windows
			bf.append(winDir);
		} else if ( "/".equals(File.separator)) {
			//Linux
			bf.append(linuxDir);
		}
		bf.append(File.separator);
		bf.append(fileName);
		return bf.toString();
	}


	/**
	 * <p>
	 * 文件转换为二进制数组
	 * </p>
	 *
	 * @param filePath 文件路径
	 * @return
	 * @throws Exception
	 */
	public static byte[] fileToByte(String filePath) throws Exception {
		byte[] data = new byte[0];
		File file = new File(filePath);
		if (file.exists()) {
			FileInputStream in = new FileInputStream(file);
			ByteArrayOutputStream out = new ByteArrayOutputStream(2048);
			try {
				byte[] cache = new byte[CACHE_SIZE];
				int nRead = 0;
				while ((nRead = in.read(cache)) != -1) {
					out.write(cache, 0, nRead);
					out.flush();
				}
				data = out.toByteArray();
			} catch (Exception e) {
				logger.error("fileToByte error: ", e);
			} finally {
				out.close();
				in.close();
			}
		}
		return data;
	}


	/**
	 * <p>
	 * 二进制数据写文件
	 * </p>
	 *
	 * @param bytes    二进制数据
	 * @param filePath 文件生成目录
	 */
	public static void byteArrayToFile(byte[] bytes, String filePath) throws Exception {
		InputStream in = new ByteArrayInputStream(bytes);
		File destFile = new File(filePath);
		if (!destFile.getParentFile().exists()) {
			destFile.getParentFile().mkdirs();
		}
		destFile.createNewFile();
		OutputStream out = new FileOutputStream(destFile);
		try {
			byte[] cache = new byte[CACHE_SIZE];
			int nRead = 0;
			while ((nRead = in.read(cache)) != -1) {
				out.write(cache, 0, nRead);
				out.flush();
			}
		} catch ( Exception e ) {
			logger.error("byteArrayToFile error: ", e);
		} finally {
			out.close();
			in.close();
		}
	}

}
