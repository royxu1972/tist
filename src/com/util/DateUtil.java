package com.util;

/**
 * 日期处理工具类
 */
import java.text.ParseException;
import java.util.Date;

public class DateUtil {

	/**
	 * 将Date类型转换为字符串
	 * 
	 * @param date
	 *            日期类型
	 * @return 日期字符串
	 */
	public static String format(Date date) {
//		return format(date, "yyyy-MM-dd HH:mm:ss");
		return format(date, "yyyy-MM-dd"); //modified with wangxz im 2014-5-4
	}
	
	public static String format2(Date date) {
//		return format(date, "yyyy-MM-dd HH:mm:ss");
		return format(date, "yyyy-MM-dd HH:mm:ss"); //modified with wangxz im 2014-5-4
	}

	/**
	 * 将Date类型转换为字符串
	 * 
	 * @param date
	 *            日期类型
	 * @param pattern
	 *            字符串格式
	 * @return 日期字符串
	 */
	public static String format(Date date, String pattern) {
		if (date == null) {
			return "null";
		}
		if (pattern == null || pattern.equals("") || pattern.equals("null")) {
//			pattern = "yyyy-MM-dd HH:mm:ss";
			pattern = "yyyy-MM-dd "; //modified with wangxz im 2014-5-4
		}
		return new java.text.SimpleDateFormat(pattern).format(date);
	}

	/**
	 * 将字符串转换为Date类型
	 * 
	 * @param date
	 *            字符串类型
	 * @return 日期类型
	 */
	public static Date format(String date) {
		return format(date, null);
	}

	/**
	 * 将字符串转换为Date类型
	 * 
	 * @param date
	 *            字符串类型
	 * @param pattern
	 *            格式
	 * @return 日期类型
	 */
	public static Date format(String date, String pattern) {
		if (pattern == null || pattern.equals("") || pattern.equals("null")) {
//			pattern = "yyyy-MM-dd HH:mm:ss";
			pattern = "yyyy-MM-dd "; //modified with wangxz im 2014-5-4
		}
		if (date == null || date.equals("") || date.equals("null")) {
			return new Date();
		}
		Date d = null;
		try {
			d = new java.text.SimpleDateFormat(pattern).parse(date);
		} catch (ParseException pe) {
		}
		return d;
	}

}