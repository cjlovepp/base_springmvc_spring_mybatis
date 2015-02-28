package com.commons.utils;

import com.google.gson.Gson;

public class JsonUtils {

	/**
	 * 将传入的JAVA对象转换成JSON字符串
	 * @param Object
	 * @return String
	 */
	public static String obj2Json(Object oo) {
		Gson gson = new Gson();
		String ss = gson.toJson(oo);
		return ss;
	}
}
