package com.zjy.sys;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

/**
 * 
 * @author JH  2015
 */
public class SysConfig {

	private Map<String,Object> config = new HashMap<String,Object>();
	
	private SysConfig(){}
	
	
	public String getString(String code){
		if(config==null || StringUtils.isBlank(code))
			return null;
		Object obj = config.get(code);
		return String.valueOf(obj);
	}
	
	public int getInt(String code){
		if(config==null || StringUtils.isBlank(code))
			return -1;
		Object obj = config.get(code);
		if(obj==null)
			return -1;
		return Integer.valueOf(obj.toString());
	}
	
	public long getLong(String code){
		if(config==null || StringUtils.isBlank(code))
			return -1;
		Object obj = config.get(code);
		if(obj==null)
			return -1;
		return Long.valueOf(obj.toString());
	}
	
	public void set(String code, Object obj ){
		if(code==null || StringUtils.isBlank(code))
			throw new ExceptionInInitializerError("SysConfig code is NULL or is Blank.");
		config.put(code, obj);
	}
	
}
