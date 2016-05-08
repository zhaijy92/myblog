package com.zjy.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class ReflectUtils {
	final static String FIELD_TYPE_STRING = "STRING";
	final static String FIELD_TYPE_INT = "INT";
	final static String FIELD_TYPE_FLOAT = "FLOAT";
	final static String FIELD_TYPE_DATE = "DATE";
	
	private static Logger logger = LoggerFactory.getLogger(ReflectUtils.class);
	
	/**
	 * 返回"String", "number", "date"
	 * @param fieldClz
	 * @return
	 */
	public static String getFieldType(Class<?> fieldClz) {

		if (String.class.equals(fieldClz)) {
			return FIELD_TYPE_STRING;
		} else if (int.class.equals(fieldClz) || Integer.class.equals(fieldClz) || long.class.equals(fieldClz)
				|| Long.class.equals(fieldClz) || short.class.equals(fieldClz) || Short.class.equals(fieldClz)
				|| byte.class.equals(fieldClz) || Byte.class.equals(fieldClz)) {

			return FIELD_TYPE_INT;
		} else if (float.class.equals(fieldClz) || Float.class.equals(fieldClz) || double.class.equals(fieldClz)
				|| Double.class.equals(fieldClz)) {
			return FIELD_TYPE_FLOAT;
		} else if (java.util.Date.class.equals(fieldClz) || java.sql.Date.class.equals(fieldClz)
				|| java.sql.Time.class.equals(fieldClz) || java.sql.Timestamp.class.equals(fieldClz)) {
			return FIELD_TYPE_DATE;
		} else {
			logger.error("未定义的 java bean 字段类型：" + fieldClz.getName());
			return null;
		}
	}

	public static boolean isPrimitive(Class<?> clz) {
		clz.isPrimitive();

		if (String.class.equals(clz) || int.class.equals(clz) || Integer.class.equals(clz) || long.class.equals(clz)
				|| Long.class.equals(clz) || short.class.equals(clz) || Short.class.equals(clz)
				|| float.class.equals(clz) || Float.class.equals(clz) || double.class.equals(clz)
				|| Double.class.equals(clz) || byte.class.equals(clz) || Byte.class.equals(clz)
				|| boolean.class.equals(clz) || Boolean.class.equals(clz) || java.util.Date.class.equals(clz)
				|| java.sql.Date.class.equals(clz) || java.sql.Time.class.equals(clz)
				|| java.sql.Timestamp.class.equals(clz)

		) {
			return true;
		} else {
			return false;
		}
	}

	public static String convertToGetMethodName(String fieldname) {

		if (fieldname != null) {
			char[] chars = fieldname.toCharArray();
			if (chars.length > 0) {
				chars[0] = Character.toUpperCase(chars[0]);
			}
			return "get" + new String(chars);
		} else {
			return fieldname;
		}
	}

	public static void main(String[] args) {
		System.out.println(convertToGetMethodName("a"));
	}

}
