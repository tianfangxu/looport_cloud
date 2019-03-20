package com.yollweb.looport.utils;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public final class DateUnit {
	/**
	 * 获取当前年份
	 * 
	 * @return
	 */
	public static int getYear() {
		return Calendar.getInstance().get(Calendar.YEAR);
	}
	public static String getMonth() {
		return getTime("yyyyMM").substring(4, 6);
	}
	
	public static String getDay() {
		return getTime("yyyyMMdd").substring(6, 8);
	}
	

	/**
	 * 根据输入的日期时间格式获取日期时间数值，如果格式为空，默认为yyyyMMdd格式
	 * 
	 * @param str
	 *            获取的日期时间格式 例如 yyyyMMddHHmmss等
	 * @return 日期时间格式的字符串
	 */
	public static String getTime(String str) {
		if (!StringUnit.isNullOrEmpty(str)) {
			return new SimpleDateFormat(str).format(new Date());
		} else {
			return new SimpleDateFormat("yyyyMMdd").format(new Date());
		}
	}

	/**
	 * 获取5位无符号当前时分
	 * 
	 * @return HH:mm
	 */
	public static String getTime5() {
		return getTime("HH:mm");
	}
	/**
	 * 获取6位无符号当前年月
	 * 
	 * @return yyyyMM
	 */
	public static String getTime6() {
		return getTime("yyyyMM");
	}
	/**
	 * 获取8位无符号当前日期
	 * 
	 * @return yyyyMMdd
	 */
	public static String getTime8() {
		return getTime(null);
	}
	/**
	 * 获取8位无符号当前日期(int类型)
	 * @return yyyyMMdd
	 */
	public static int getIntTime8(){
		return Integer.parseInt(getTime("yyyyMMdd"),10);
	}
	
	/**
	 * 获取12位无符号当前日期
	 * 
	 * @return yyyyMMddHHmm
	 */
	public static String getTime12() {
		return getTime("yyyyMMddHHmm");
	}

	/**
	 * 获取14位无符号当前日期
	 * 
	 * @return yyyyMMddHHmmss
	 */
	public static String getTime14() {
		return getTime("yyyyMMddHHmmss");
	}

	/**
	 * 获取17位无符号当前日期
	 * 
	 * @return yyyyMMddHHmmssSSS
	 */
	public static String getTime17() {
		return getTime("yyyyMMddHHmmssSSS");
	}

	/**
	 * 获取有符号的10位当前日期
	 * 
	 * @return yyyy-MM-dd
	 */
	public static String getTimeFomat10() {
		return getTime("yyyy-MM-dd");
	}

	/**
	 * 获取有符号的16位当前日期
	 * 
	 * @return yyyy-MM-dd HH:mm
	 */
	public static String getTimeFomat16() {
		return getTime("yyyy-MM-dd HH:mm");
	}
	
	/***
	 * 获取有符号的6为当前日期
	 * @return
	 */
	public static String getTimeFomat6(){
		return getTime("yyyy-MM");
	}

	/**
	 * 获取有符号的19位当前日期
	 * 
	 * @return yyyy-MM-dd HH:mm:ss
	 */
	public static String getTimeFomat19() {
		return getTime("yyyy-MM-dd HH:mm:ss");
	}

	/**
	 * 将传送过来的数字字符串 根据 传过来的要转化的格式 转化为需要的格式
	 * 
	 * @param timeStr
	 *            ：数字字符串
	 * @param strFormateBack
	 *            ：需要转化的格式
	 * @return
	 */
	public static String getTimeByStr(String timeStr, String strFormateBack) {
		if (!StringUnit.isNullOrEmpty(timeStr)) {
			if (strFormateBack.equals("yyyyMMdd") && timeStr.length() >= 8) {
				return timeStr.substring(0, 4) + "" + timeStr.substring(4, 6)
						+ "" + timeStr.substring(6, 8);
			} else if (strFormateBack.equals("yyyy-MM-dd")
					&& timeStr.length() >= 8) {
				return timeStr.substring(0, 4) + "-" + timeStr.substring(4, 6)
						+ "-" + timeStr.substring(6, 8);
			} else if (strFormateBack.equals("yyyy/MM/dd")
					&& timeStr.length() >= 8) {
				return timeStr.substring(0, 4) + "/" + timeStr.substring(4, 6)
						+ "/" + timeStr.substring(6, 8);
			} else if (strFormateBack.equals("yyyy年MM月dd日")
					&& timeStr.length() >= 8) {
				return timeStr.substring(0, 4) + "年" + timeStr.substring(4, 6)
						+ "月" + timeStr.substring(6, 8) + "日";
			} else if (strFormateBack.equals("yyyy-MM-dd HH:mm")
					&& timeStr.length() >= 12) {
				return timeStr.substring(0, 4) + "-" + timeStr.substring(4, 6)
						+ "-" + timeStr.substring(6, 8) + " "
						+ timeStr.substring(8, 10) + ":"
						+ timeStr.substring(10, 12);
			} else if (strFormateBack.equals("yyyy-MM-dd HH:mm:ss")
					&& timeStr.length() >= 14) {
				return timeStr.substring(0, 4) + "-" + timeStr.substring(4, 6)
						+ "-" + timeStr.substring(6, 8) + " "
						+ timeStr.substring(8, 10) + ":"
						+ timeStr.substring(10, 12) + ":"
						+ timeStr.substring(12, 14);
			}
		}
		return timeStr==null?"":timeStr;
	}

	/**
	 * 将传送来的数字字符串转化为无符号的八位日期时间格式
	 * 
	 * @param timeStr
	 *            数字字符串
	 * @return yyyyMMdd
	 */
	public static String getTime8(String timeStr) {
		return getTimeByStr(timeStr, "yyyyMMdd");
	}

	/**
	 * 将传送来的数字字符串转化为有符号的10位日期时间格式
	 * 
	 * @param timeStr
	 *            数字字符串
	 * @return yyyy-MM-dd
	 */
	public static String getTimeFomat10(String timeStr) {
		return getTimeByStr(timeStr, "yyyy-MM-dd");
	}

	/**
	 * 将传送来的数字字符串转化为有符号的16位日期时间格式
	 * 
	 * @param timeStr
	 *            数字字符串
	 * @return yyyy-MM-dd HH:mm
	 */
	public static String getTimeFomat16(String timeStr) {
		return getTimeByStr(timeStr, "yyyy-MM-dd HH:mm");
	}

	/**
	 * 将传送来的数字字符串转化为有符号的19位日期时间格式
	 * 
	 * @param timeStr
	 *            数字字符串
	 * @return yyyy-MM-dd HH:mm:ss
	 */
	public static String getTimeFomat19(String timeStr) {
		return getTimeByStr(timeStr, "yyyy-MM-dd HH:mm:ss");
	}

	/**
	 * 将当前时间或者指定的时间 转化为指定格式的对象
	 * 
	 * @param dt
	 * @param formatStr
	 * @param times
	 * @return
	 */
	public static Object getDateFormat(Date dt, String formatStr, String times) {
		Object obj = null;
		if (formatStr != null) {
			try {
				SimpleDateFormat sdf = new SimpleDateFormat(formatStr);
				if (dt != null) {
					/** 将日期转化为某一格式字符串* */
					obj = sdf.format(dt);
				} else if (times != null) {
					/** 将某一格式字符串转化为日期* */
					obj = sdf.parse(times);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return obj;
	}

	/**
	 * 
	 * 获取两个日期字符串差距
	 * 
	 * @param date1
	 *            ：第一个日期字符串
	 * @param date2
	 *            ：第二个日期字符串
	 * @param dateType2
	 *            ：第一个日子字符串的格式
	 * @param lx
	 *            :返回两个日期字符串的相差类型 day：天；hour：小时；......
	 * @return date2-date1的差
	 */
	public static String getGapBetweenTwoDates(String date1, String date2,
                                               String dateType, String lx) {
		String nowDate = DateUnit.getTime14();
		if (StringUnit.isNullOrEmpty(date1)) {
			date1 = nowDate;
		}
		if (StringUnit.isNullOrEmpty(date2)) {
			date2 = nowDate;
		}
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		if ("yyyyMMddHHmmss".equals(dateType)) {
			sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		} else if ("yyyyMMddHHmm".equals(dateType)) {
			sdf = new SimpleDateFormat("yyyyMMddHHmm");
		} else if ("yyyy-MM-dd".equals(dateType)) {
			sdf = new SimpleDateFormat("yyyy-MM-dd");
		} else if ("yyyy-MM-dd HH:mm:ss".equals(dateType)) {
			sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		}
		Calendar cal = Calendar.getInstance();
		try {
			cal.setTime(sdf.parse(date1));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		long time1 = cal.getTimeInMillis();

		try {
			cal.setTime(sdf.parse(date2));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		long time2 = cal.getTimeInMillis();
		long between_days = 0l;
		if ("day".equals(lx)) {
			between_days = (time2 - time1) / (1000 * 3600 * 24);
		} else if ("hour".equals(lx)) {
			between_days = (time2 - time1) / (1000 * 3600);
		} else if ("minute".equals(lx)) {
			between_days = (time2 - time1) / (1000 * 60);
		} else if ("second".equals(lx)) {
			between_days = (time2 - time1) / (1000);
		}
		return "" + between_days;
	}

	/**
	 * 返回当前日期增减后的字符串
	 * 
	 * @param fh
	 *            运算符号 （+、-）
	 * @param day
	 *            数字 (1,2,30,45......)
	 * @param formate
	 *            字符串格式(yyyyMMdd,yyyy-MM-dd......)
	 * @return
	 */
	public static String getAddOrDecreaseDateStr(String fh, int day, String formate) {
		return getAddOrDecreaseDateStr(fh, day, formate, "", Calendar.DATE);
	}
	/**
	 * 返回指定日期增减后的字符串
	 * @param fh 运算符号 （+、-）
	 * @param day  数字 (1,2,30,45......)
	 * @param formate 字符串格式(yyyyMMdd,yyyy-MM-dd......)
	 * @param date 指定的日期
	 * @param dateType 处理日期的类型   日：Calendar.DATE；月：Calendar.MONTH；年：Calendar.YEAR
	 * @return
	 */
	public static String getAddOrDecreaseDateStr(String fh, int day, String formate, String date, int dateType) {
		Calendar calendar = Calendar.getInstance();// 此时打印它获取的是系统当前时间
		String result = "";
		if(!StringUnit.isNullOrEmpty(date)&&date.length()==8){
			result = date;
		}else{
		    result = new SimpleDateFormat("yyyyMMdd").format(calendar.getTime());
		}
		if (isNotNull(fh) && isNotNull(day + "") && isNotNull(formate)) {
			if (fh.equals("+")) {
				day = +day;
			} else if (fh.equals("-")) {
				day = -day;
			}
			calendar.add(dateType, day);
			result = new SimpleDateFormat(formate).format(calendar.getTime());
		}
		return result;
	}

	/**
	 * 判断当前字符串是否为空
	 * 
	 * @author yangxl
	 * @param str
	 *            需要判断的字符串
	 * @return boolean 如果不为空 则返回true，否则返回 false
	 */
	public static boolean isNotNull(String str) {
		if (null != str && !"undefined".equals(str.trim())
				&& !"".equals(str.trim())) {
			return true;
		}
		return false;
	}
	
	/**
	 * 将传送过来的数字字符串 根据 传过来的要转化的格式 转化为需要的格式
	 * 源格式化为：yyyy-MM-dd
	 * @param timeStr
	 *            ：数字字符串
	 * @param strFormateBack
	 *            ：需要转化的格式
	 * @return
	 */
	public static String getTimeByJS(String timeStr, String strFormateBack) {
		if (!StringUnit.isNullOrEmpty(timeStr)) {
			if (strFormateBack.equals("yyyyMMdd") && timeStr.length() >= 10) {
				return timeStr.substring(0, 4) + "" + timeStr.substring(5, 7)
						+ "" + timeStr.substring(8, 10);
			} else if (strFormateBack.equals("yyyy-MM-dd")
					&& timeStr.length() >= 10) {
				return timeStr.substring(0, 4) + "-" + timeStr.substring(5, 7)
						+ "-" + timeStr.substring(8, 10);
			} else if (strFormateBack.equals("yyyy/MM/dd")
					&& timeStr.length() >= 10) {
				return timeStr.substring(0, 4) + "/" + timeStr.substring(5, 7)
						+ "/" + timeStr.substring(8, 10);
			} else if (strFormateBack.equals("yyyy年MM月dd日")
					&& timeStr.length() >= 10) {
				return timeStr.substring(0, 4) + "年" + timeStr.substring(5, 7)
						+ "月" + timeStr.substring(8, 10) + "日";
			}
		}
		return timeStr==null?"":timeStr;
	}
	public final static java.sql.Timestamp string2Time(String dateString){
		   DateFormat dateFormat;
		  dateFormat = new SimpleDateFormat("yyyyMMddHHmmss", Locale.ENGLISH);//设定格式
		  dateFormat.setLenient(false);
		  java.util.Date timeDate=null;
		try {
			timeDate = dateFormat.parse(dateString);
		} catch (Exception e) {
			e.printStackTrace();
		}
		  java.sql.Timestamp dateTime = new java.sql.Timestamp(timeDate.getTime());//Timestamp类型,timeDate.getTime()返回一个long型
		  return dateTime;
		}

	/**
	 * 获取14位的Timestamp
	 *
	 * @return yyyyMMddHHmmss
	 */
	public static Timestamp getTimeTimestamp() {
		 Date date = new Date();
	     Timestamp ts = new Timestamp(date.getTime());
		return ts;
	}
	/**
	 * 字符串时间8位转  8位 Timestamp
	 * @param dateString
	 * @return
	 */
	public final static java.sql.Timestamp string8imestamp(String dateString){
		   DateFormat dateFormat;
		  dateFormat = new SimpleDateFormat("yyyyMMdd", Locale.ENGLISH);//设定格式
		  dateFormat.setLenient(false);
		  java.util.Date timeDate=null;
		try {
			timeDate = dateFormat.parse(dateString);
		} catch (Exception e) {
			e.printStackTrace();
		}
		  java.sql.Timestamp dateTime = new java.sql.Timestamp(timeDate.getTime());//Timestamp类型,timeDate.getTime()返回一个long型
		  return dateTime;
		}
	/**
	 * 字符串时间14位转  14位 Timestamp
	 * @param dateString
	 * @return
	 */
	public final static java.sql.Timestamp string14imestamp(String dateString){
		DateFormat dateFormat;
		dateFormat = new SimpleDateFormat("yyyyMMddHHmmss", Locale.ENGLISH);//设定格式
		dateFormat.setLenient(false);
		java.util.Date timeDate=null;
		try {
			timeDate = dateFormat.parse(dateString);
		} catch (Exception e) {
			e.printStackTrace();
		}
		java.sql.Timestamp dateTime = new java.sql.Timestamp(timeDate.getTime());//Timestamp类型,timeDate.getTime()返回一个long型
		return dateTime; 
	} 
}
