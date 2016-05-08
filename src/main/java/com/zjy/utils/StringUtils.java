package com.zjy.utils;

/**
 * @author JH  2015
 */
public class StringUtils {
	public static String intToString(int inVal, int len) {
		int i;
		String inStr = new Integer(inVal).toString();
		StringBuffer newStr = new StringBuffer();

		for (i = 0; i < len - inStr.length(); i++) {
			newStr.append("0");
		}
		newStr.append(inStr);

		return (newStr.toString());
	}

}
