package com.zjy.utils;


import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.commons.logging.LogFactory;

/**
 * 
 */
public class SystemProp {
	private static final Properties prop = new Properties();

	static {
		InputStream inputStream = SystemProp.class.getResourceAsStream("/config.properties");
		try {
			prop.load(inputStream);
		} catch (IOException e1) {
			System.out.println(e1);
			LogFactory.getLog("unicomepay").error("SystemProp:初始化错误.");
		}
	}

	public static String getPropertyByName(String propName) {
		return prop.getProperty(propName);
	}
}
