package com.miao.oss_demo.common;

import com.miao.oss_demo.ali.AliyunOSS;

public class SystemManager {
	
	public static SystemManager getInstance(){
		return new SystemManager();
	}
	
	public AliyunOSS getAliyunOSS(){
		AliyunOSS oss = new AliyunOSS();
		oss.setACCESS_ID("");
		oss.setACCESS_KEY("");
		oss.setBucketName("");
		oss.setOSS_ENDPOINT("");
		return oss;
	}
}
