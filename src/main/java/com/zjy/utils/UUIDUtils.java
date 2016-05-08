package com.zjy.utils;

import java.util.UUID;

/**
 * @author JH  2015
 */
public class UUIDUtils {
	
	public static String getUUID() {
		return UUID.randomUUID().toString();
	}
	
	
	public static String getTemplateId(){
		String templateId = UUID.randomUUID().toString().replace("-", "");
		return templateId.toUpperCase();
	}
	
	public static String getSecretKey(){
		return UUID.randomUUID().toString().replace("-", "");
	}
	
	
	public static void main(String[] args) {
		System.out.println(getTemplateId());
		System.out.println(getTemplateId());
		System.out.println(getTemplateId());
	}
	
}
