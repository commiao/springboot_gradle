package com.miao.oss_demo.ali;

import java.io.Serializable;

/**
 * 阿里云OSS
 * 
 * @author huangf
 * 
 */
public class AliyunOSS implements Serializable {

	private static final long serialVersionUID = 4687392862528854828L;

	private String ACCESS_ID;
	private String ACCESS_KEY;
	private String OSS_ENDPOINT;
	private String bucketName;

	public String getACCESS_ID() {
		return ACCESS_ID;
	}

	public void setACCESS_ID(String aCCESS_ID) {
		ACCESS_ID = aCCESS_ID;
	}

	public String getACCESS_KEY() {
		return ACCESS_KEY;
	}

	public void setACCESS_KEY(String aCCESS_KEY) {
		ACCESS_KEY = aCCESS_KEY;
	}

	public String getOSS_ENDPOINT() {
		return OSS_ENDPOINT;
	}

	public void setOSS_ENDPOINT(String oSS_ENDPOINT) {
		OSS_ENDPOINT = oSS_ENDPOINT;
	}

	public String getBucketName() {
		return bucketName;
	}

	public void setBucketName(String bucketName) {
		this.bucketName = bucketName;
	}

	public void clear() {
		ACCESS_ID = null;
		ACCESS_KEY = null;
		OSS_ENDPOINT = null;
		bucketName = null;
	}

	@Override
	public String toString() {
		return "AliyunOSS [ACCESS_ID=" + ACCESS_ID + ", ACCESS_KEY="
				+ ACCESS_KEY + ", OSS_ENDPOINT=" + OSS_ENDPOINT
				+ ", bucketName=" + bucketName + "]";
	}

}
