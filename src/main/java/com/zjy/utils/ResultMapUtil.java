package com.zjy.utils;

import java.util.HashMap;
import java.util.Map;

import com.zjy.utils.json.gson.GsonUtils;

/**
 * 
 * @author JH  2015
 */
public class ResultMapUtil {
	
	/**
	 * ResultMap结构参数
	 * @param key
	 * @param value
	 * @return
	 */
	public static Map<String,Object> put(String key, Object value){
		Map<String,Object> resultMap = new HashMap<String,Object>();
		resultMap.put(key, value);
		return resultMap;
	}

	public static void main(String[] args) {
		System.out.println(put("result","success"));
		System.out.println(GsonUtils.toJson(put("result","success").put("data", "Date List ...")));
	}
	
}
