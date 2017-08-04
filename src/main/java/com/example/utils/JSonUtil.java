/**
 * 
 */
package com.example.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.serializer.SimplePropertyPreFilter;

/**
 * JSon 工具类
 * 
 * @author 	alanwei
 * @since	2016-07-11
 */
public class JSonUtil {

	/**
	 * java转JSon
	 * 
	 * @param obj	java对象
	 * @return		JSon串
	 */
	public static String toJson(Object obj) {
		return JSON.toJSONString(obj);
	}
	
	/**
	 * java转JSon
	 * 
	 * @param obj		java对象
	 * @param feature	序列化时的特性
	 * @return			JSon串
	 */
	public static String toJson(Object obj, SerializerFeature feature) {
		return JSON.toJSONString(obj, feature);
	}
	
	/**
	 * java转JSon
	 * 
	 * @param obj		java对象
	 * @param filter	过滤属性
	 * @return			JSon串
	 */
	public static String toJson(Object obj, SimplePropertyPreFilter filter) {
		return JSON.toJSONString(obj, filter);
	}
	
	/**
	 * JSon转java
	 * 
	 * @param str	JSon串
	 * @param cls	java类
	 * @return		java类的实例
	 */
	@SuppressWarnings("unchecked")
	public static <T> T fromJson(String str, Class<?> cls) {
		return (T) JSON.parseObject(str, cls);
	}
}
