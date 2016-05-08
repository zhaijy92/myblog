package com.zjy.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

/**
 * 
 * @author JH  2014
 */
public class DateUtil {
	
	public static String DATE_DEFAULT_FORMAT = "yyyy-MM-dd HH:mm:ss";
	
	/**
	 * 指定时间,指定格式
	 * @param fmt
	 * @return
	 */
	public static String dateFormat(Date date, String fmt){
		SimpleDateFormat sdf = new SimpleDateFormat(fmt);
		return sdf.format(date);
	}
	/**
	 * 指定时间,默认格式
	 * @param fmt
	 * @return
	 */
	public static String dateFormat(Date date){
		return dateFormat(date, DATE_DEFAULT_FORMAT);
	}
	
	/**
	 * 当前时间,指定格式
	 * @param fmt
	 * @return
	 */
	public static String currentDateFormat(String fmt){
		return dateFormat(new Date(), fmt);
	}
	/**
	 * 当前时间,默认格式
	 * @param fmt
	 * @return
	 */
	public static String currentDateFormat(){
		return dateFormat(new Date());
	}
	
	/**
	 * 字符串转日期
	 * @param strDate
	 * @param fmt
	 * @return
	 */
	public static Date strToDate(String strDate, String fmt){
		SimpleDateFormat sdf = new SimpleDateFormat(fmt);
		Date date = null;
		try {
			date = sdf.parse(strDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}
	/**
	 * 字符串转日期
	 * @param strDate
	 * @return
	 */
	public static Date strToDate(String strDate){
		return strToDate(strDate, DATE_DEFAULT_FORMAT);
	}
	
	/**
	 * 日期数字+随机数组成
	 * @param strDate
	 * @return
	 */
	public static long longDate(){
		String strDate = DateUtil.currentDateFormat("yyMMddHHmmssSSS");
		int ranNum = new Random().nextInt(10000);
		return Long.valueOf(strDate+ranNum);
	}
	
	public static long currentUTCTime(){
		//本地时间：
		Calendar cal = Calendar.getInstance();
		//时间偏移量：
		int zoneOffset = cal.get(Calendar.ZONE_OFFSET);
		//夏令时差
		int dstOffset = cal.get(Calendar.DST_OFFSET);
		cal.add(Calendar.MILLISECOND, -(zoneOffset + dstOffset));
		return new Date(cal.getTimeInMillis()).getTime();
	}
	
	public static String currentUTCTimestamp(){
		/*
		//本地时间：
		Calendar cal = Calendar.getInstance();
		//时间偏移量：
		int zoneOffset = cal.get(Calendar.ZONE_OFFSET);
		//夏令时差
		int dstOffset = cal.get(Calendar.DST_OFFSET);
		cal.add(Calendar.MILLISECOND, -(zoneOffset + dstOffset));
		Date date = new Date(cal.getTimeInMillis());
		
		String timestamp = dateFormat(date, "yyyy-MM-dd HH:mm:ss");
		timestamp = timestamp.replace(" ", "T");
		
		return timestamp + "+0800";
		*/
		
		return currentDateFormat("yyyy-MM-dd'T'HH:mm:ssZ");
		
	}
	
	
	public static void main(String[] args) {
		String strDate = DateUtil.currentDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
		System.out.println(strDate);
		Date date = DateUtil.strToDate(strDate, "yyyy-MM-dd HH:mm:ss.SSS");
		System.out.println(date);
		
		/*for(;;)
			System.out.println(longDate());*/
		
		System.out.println(currentUTCTimestamp());
		
	}
	
}
