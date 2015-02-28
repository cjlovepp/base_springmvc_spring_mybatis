package com.commons.utils;

import java.util.regex.Pattern;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * 功能描述：验证类 ，提供常用的转型 <br>
 */
public class Validation {

	private static final Log log = LogFactory.getLog(Validation.class);

	/**
	 * 验证整数的正则式
	 */
	private static final String P_INT = "^\\d+$";
	/**
	 * 验证浮点数的正则式
	 */
	private static final String P_FLOAT = "^\\d+(\\.\\d+){0,1}$";
	/**
	 * 验证电话号码的正则式
	 */
	private static final String P_PHONE = "^\\d+(-\\d+)*$";
	/**
	 * 验证 e-mail 的正则式
	 */
	private static final String P_EMAIL = "^[a-zA-Z_]\\w*@\\w+(\\.\\w+)+$";

	/**
	 * 验证是否为整数
	 */
	public static final int INT = 1;
	/**
	 * 验证是否为浮点数
	 */
	public static final int FLOAT = 2;
	/**
	 * 验证是否为电话号码
	 */
	public static final int PHONE = 3;
	/**
	 * 验证是否为 e-mail
	 */
	public static final int EMAIL = 4;

	/**
	 * 对字符串进行验证
	 * @param input
	 * 需要验证的字符串
	 * @param matcher
	 * 验证规则
	 * @return 验证是否通过
	 */
	public static boolean validate(String input, int matcher) {
		if (isNULL(input)) {
			return false;
		}
		String regex = null;
		switch (matcher) {
			case INT:
				regex = P_INT;
				break;
			case FLOAT:
				regex = P_FLOAT;
				break;
			case PHONE:
				regex = P_PHONE;
				break;
			case EMAIL:
				regex = P_EMAIL;
				break;
			default:
				return false;
		}
		return Pattern.matches(regex, input);
	}

	public static Boolean isNULL(Object... value) {
		if (null == value || value.length < 1) {
			return true;
		} else {
			for (int i = 0; i < value.length; i++) {
				if (null == value[i] || "".equals(value[i].toString()) || "null".equals(value[i].toString().toLowerCase())) {
					return true;
				}
			}
		}
		return false;
	}

}