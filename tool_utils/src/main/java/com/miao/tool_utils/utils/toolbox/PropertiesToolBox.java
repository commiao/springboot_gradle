package com.miao.tool_utils.utils.toolbox;

import com.miao.tool_utils.utils.common.PropertiesUtils;

/**
 * CreateDate:2016年9月28日下午2:44:03
 *
 * @version V1.0
 * @Description: velocity 获取properties值工具类
 * @author:yuzhao
 */
public class PropertiesToolBox {

	/**
	 * @param file properties文件名
	 * @param key  properties key
	 * @return
	 * @Description::获取站点url. <br/>
	 * @author yuzhao
	 */
	public static String getSiteUrl(String file, String key) {
		return getPropValue(file, key);
	}

	/**
	 * @param file properties文件名
	 * @param key  properties key
	 * @return
	 * @Description::获取properties值. <br/>
	 * @author yuzhao
	 */
	public static String getPropValue(String file, String key) {
		return PropertiesUtils.getValue(file, key);
	}

}
