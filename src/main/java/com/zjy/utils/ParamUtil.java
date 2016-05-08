package com.zjy.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.apache.commons.lang.StringUtils;

/**
 * 参数处理工具类
 * @author JH  2014
 */
public class ParamUtil {
	
	/** String[] 去重
	 * return Set
	 */
	public static Set<String> removeRepetition(String[] strArr){
		Set<String> strSet = new HashSet<String>();
		if(strArr!=null && strArr.length>0){
			for(String str : strArr){
				if(StringUtils.isNotBlank((str))){
					strSet.add(str);
				}
			}
		}
		return strSet;
	}
	
	/**
	 * 去重 返回已逗号分隔的字符串
	 * return param1,param2,param3
	 */
	public static String toSimpleSplit(String[] strArr){
		String result = "";
		Set<String> strSet = removeRepetition(strArr);
		for(String str : strSet){
			if(StringUtils.isNotBlank(str)){
				result += ","+ str;
			}
		}
		return result.length()>0?result.substring(1):result;
	}
	
	
	/** string to int */
	public static int toInt(String str, int defaultV){
		int n = defaultV;
		if(StringUtils.isNotBlank(str)){
			n = Integer.valueOf(str);
		}
		return n;
	}
	
	public static int toInt(String str){
		return toInt(str,0);
	}
	
	
	/** string to long */
	public static long toLong(String str, long defaultV){
		long n = defaultV;
		if(StringUtils.isNotBlank(str)){
			n = Long.valueOf(str);
		}
		return n;
	}
	
	public static long toLong(String str){
		return toLong(str,0);
	}
	
	public static long toLong(Object obj){
		String str = obj==null?"0":obj.toString();
		return toLong(str,0);
	}
	
	
	/** string to date */
	public static Date toDate(String str, String format) throws ParseException{
		if(StringUtils.isBlank(str))
			return null;
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		return sdf.parse(str);
	}
	
	public static Date toDate(String str) throws ParseException {
		return toDate(str,"yyy-MM-dd HH:mm:ss");
	}
	
	/** null to "" */
	public static String null2BlankStr(String str){
		if(StringUtils.isBlank(str))
			return "";
		return str;
	}
	
	/** (数字)不等式参数范围判断  
	 * num：'8'
	 * scope参数类型：>1,>=1; 1<num<10; num>1&num<10; num<10|num>100;
	 */
	public static boolean inScope(String num, String scope){
		if(StringUtils.isBlank(scope))
			return false;
		
		if(num.equalsIgnoreCase(scope))
			return true;
		
		if(!StringUtils.isNumeric(num))
			return false;
		
		//大于
		if(scope.contains(":get;")){
			String param = scope.substring(5);
			return Long.valueOf(num)>=Long.valueOf(param);
		} else if(scope.contains(">")){
			String param = scope.substring(1);
			return Long.valueOf(num)>Long.valueOf(param);
		}
		
		//小于
		if(scope.contains(":let;")){
			String param = scope.substring(5);
			return Long.valueOf(num)<=Long.valueOf(param);
		} else if(scope.contains("<")){
			String param = scope.substring(1);
			return Long.valueOf(num)<Long.valueOf(param);
		}
		
		return false;
		
	}
	
	
	/** 判读int数据长度 */
	private final static int[] sizeTable = { 9, 99, 999, 9999, 99999, 999999, 9999999, 99999999, 999999999, Integer.MAX_VALUE };    
	/**
	 * @param x
	 */
	private static int sizeOfInt(int x) {
		for(int i = 0; ; i++)    
			if (x <= sizeTable[i])    
				return i + 1;    
	} 
	
	public static void main(String[] args) {
		System.out.println(ParamUtil.inScope("5","<=1"));
		System.out.println(ParamUtil.inScope("5","<=10"));
		
		System.out.println(ParamUtil.sizeOfInt(1));
		System.out.println(ParamUtil.sizeOfInt(23));
	}
	
}
