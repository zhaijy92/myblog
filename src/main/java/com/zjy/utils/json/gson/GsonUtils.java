package com.zjy.utils.json.gson;

import java.util.HashMap;

import org.apache.commons.lang.StringUtils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.zjy.utils.json.gson.filter.CustomFilter;
import com.zjy.utils.json.gson.filter.impl.DefaultCustomFilter;

/**
 * @author JH  2014
 */
public class GsonUtils {
	private CustomFilter customFilter;
	
	public CustomFilter getCustomFilter() {
		return customFilter;
	}

	public void setCustomFilter(CustomFilter customFilter) {
		this.customFilter = customFilter;
	}
	
	public static String toJson(Object object) {
		Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").serializeNulls().create();
		
		return gson.toJson(object);
	}
	
	public static String toJson(Object object, String dateFormat) {
		if(StringUtils.isBlank(dateFormat))
			dateFormat = "yyyy-MM-dd HH:mm:ss";
		
		Gson gson = new GsonBuilder().setDateFormat(dateFormat).serializeNulls().create();
		
		return gson.toJson(object);
	}

	public static String toJson(Object object, String[] exclusionFields) {
		DefaultCustomFilter df = new DefaultCustomFilter();
		df.setFields(exclusionFields);
		
		GsonExclusionStrategy ges = new GsonExclusionStrategy(df);
		
		Gson gson = new GsonBuilder().setExclusionStrategies(ges).serializeNulls().create();
		
		return gson.toJson(object);
	}
	
	public static String toJson(Object object, Class<?>[] exclusionClz) {
		DefaultCustomFilter df = new DefaultCustomFilter();
		df.setClasses(exclusionClz);
		
		GsonExclusionStrategy ges = new GsonExclusionStrategy(df);
		
		Gson gson = new GsonBuilder().setExclusionStrategies(ges).serializeNulls().create();
		
		return gson.toJson(object);
	}
	
	public static String toJson(Object object, CustomFilter filter) {		
		GsonExclusionStrategy ges = new GsonExclusionStrategy(filter);
		
		Gson gson = new GsonBuilder().setExclusionStrategies(ges).serializeNulls().create();
		
		return gson.toJson(object);
	}
	
	@SuppressWarnings("unchecked")
	public static HashMap<String,String> toHashMap(String json) {		
		Gson gson = new GsonBuilder().serializeNulls().create();
		HashMap<String,String> hashMap = gson.fromJson(json, HashMap.class);
		return hashMap;
	}
	

	
	public static void main(String[] args) {
		String[] str = {"code", "true", "ok"};
		System.out.println(GsonUtils.toJson(str));
	}
	
}
