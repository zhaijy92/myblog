/*
 *  This is a part of the Galaxy Workflow Platform.
 *  Copyright (C) 1998-2005 JH Corporation
 *  All rights reserved.
 *
 *  Licensed under the JH private License.
 *  Created on 2005-5-19
 * 
 */
package com.zjy.utils;

import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.configuration.Configuration;
import org.apache.commons.configuration.ConfigurationFactory;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.zjy.sys.io.URLPatternResolver;
import com.zjy.utils.propertyset.RuntimeCachingPropertySet;

/**
 * 用于获取相应整个系统内所用的配置属性。
 * 
 * 这里实际上调用的是apache common configuration。
 * 提供的方法基本上和Configuration保持一致。 使用过程为：
 * <li>定义相关的属性配置文件，可以是多个属性文件。
 * <li>属性配置文件根据出现的定义顺序，可以形成覆盖关系。
 * <li>调用PropertyGetter的相关方法，
 *   第一个参数为module名（对应与xml文件，不包含xml后缀），第二个参数为属性的key，
 *   第三个参数为缺省值，如果找不到指定的xml文件，或者找不到相关的属性，会抛出异常。
 *   
 * 缺省情况下，配置属性会先从数据库中获取，这一行为可以通过名为properties.storage.database
 * 的属性进行再配置，该属性位于common.txt中，取值为true/false。在不直接修改common.txt文件
 * 的前提下，你还可以通过定义一个名为overriden-setting.txt的文件中，对该属性进行覆盖。其他属性 
 * 也可以在该配置文件中定义，以覆盖缺省值。
 * 
 * @author
 */
public class PropertyGetter {
    
    private static Map<String, Configuration> confMap = new HashMap<String, Configuration>();

    private static Log logger = LogFactory.getLog(PropertyGetter.class);

    private static final String prefix = "properties"; // 属性文件的前置路径
    
    private static final String MSG_ILLEGAL_ARGUMENT = 
        "you must be crazy. no module or no key, then nothing.";
    private static final String MSG_CONFIGURATION_NOT_FOUND = 
        "could not find the configuration named ";

    private static RuntimeCachingPropertySet rcps;
    
    public void setCachingPropertySet(RuntimeCachingPropertySet rcps){
        if (getBoolean("common", "properties.storage.database"))
            PropertyGetter.rcps = rcps;
    }
    
    private static Configuration getConfiguration(String moduleName) {
        Configuration configuration = (Configuration) confMap.get(moduleName);
        
        // 这里的double check 方法应该是管用的
        if (configuration == null) {
        	synchronized(PropertyGetter.class) {
	        	if (configuration == null){
                    try {
    		            ConfigurationFactory factory = new ConfigurationFactory();
    		            String modulePath = prefix + "/" + moduleName + ".xml";
    		            URL url = URLPatternResolver.getStandardURL(
    		                    PropertyGetter.class.getClassLoader().getResource( modulePath ).toString()
    		                );
    		            factory.setConfigurationURL(url);
		            
		                configuration = factory.getConfiguration();
		                if (configuration != null) {
		                    confMap.put(moduleName, configuration);
		                } else {
		                    throw new BapConfigurationException();
		                }
		            } catch (Exception e) {
		                logger.error(MSG_CONFIGURATION_NOT_FOUND + moduleName, e);
		                throw new BapConfigurationException(
		                        MSG_CONFIGURATION_NOT_FOUND + moduleName);
		            }
		            
        		}
        	}
        }
        return configuration;
    }

    public static boolean getBoolean(String module, String key) {
        if (module == null || key == null)
            throw new IllegalArgumentException(MSG_ILLEGAL_ARGUMENT);

        if(rcps != null){
            if (rcps.exists(key))
                return rcps.getBoolean(key);        
        }
        
        return getConfiguration(module).getBoolean(key);
    }

    public static boolean getBoolean(String module, String key, boolean defaultValue) {
        if (module == null || key == null)
            throw new IllegalArgumentException(MSG_ILLEGAL_ARGUMENT);

        if(rcps != null){
            if (rcps.exists(key))
                return rcps.getBoolean(key);        
        }
        
        return getConfiguration(module).getBoolean(key, defaultValue);
    }

    public static double getDouble(String module, String key) {
        if (module == null || key == null)
            throw new IllegalArgumentException(MSG_ILLEGAL_ARGUMENT);

        if(rcps != null){
            if (rcps.exists(key))
                return rcps.getDouble(key);        
        }
        
        return getConfiguration(module).getDouble(key);
    }

    public static double getDouble(String module, String key, double defaultValue) {
        if (module == null || key == null)
            throw new IllegalArgumentException(MSG_ILLEGAL_ARGUMENT);

        if(rcps != null){
            if (rcps.exists(key))
                return rcps.getDouble(key);        
        }
         
        return getConfiguration(module).getDouble(key, defaultValue);
    }

    public static int getInt(String module, String key) {
        if (module == null || key == null)
            throw new IllegalArgumentException(MSG_ILLEGAL_ARGUMENT);

        if(rcps != null){        
            if (rcps.exists(key))
                return rcps.getInt(key);        
        }
                
        return getConfiguration(module).getInt(key);
    }

    public static int getInt(String module, String key, int defaultValue) {
        if (module == null || key == null)
            throw new IllegalArgumentException(MSG_ILLEGAL_ARGUMENT);

        if(rcps != null){
            if (rcps.exists(key))
                return rcps.getInt(key);        
        }
         
        return getConfiguration(module).getInt(key, defaultValue);
    }

    public static long getLong(String module, String key) {
        if (module == null || key == null)
            throw new IllegalArgumentException(MSG_ILLEGAL_ARGUMENT);

        if(rcps != null){
            if (rcps.exists(key))
                return rcps.getLong(key);        
        }
         
        return getConfiguration(module).getLong(key);
    }

    public static long getLong(String module, String key, long defaultValue) {
        if (module == null || key == null)
            throw new IllegalArgumentException(MSG_ILLEGAL_ARGUMENT);

        if(rcps != null){
            if (rcps.exists(key))
                return rcps.getLong(key);        
        }
         
        return getConfiguration(module).getLong(key, defaultValue);
    }

    public static String getString(String module, String key) {
        if (module == null || key == null)
            throw new IllegalArgumentException(MSG_ILLEGAL_ARGUMENT);
        
        if(rcps != null){
            if (rcps.exists(key))
                return rcps.getString(key);        
        }

        return getConfiguration(module).getString(key);
    }

    public static String getString(String module, String key, String defaultValue) {
        if (module == null || key == null)
            throw new IllegalArgumentException(MSG_ILLEGAL_ARGUMENT);
        
        if(rcps != null){
            if (rcps.exists(key))
                return rcps.getString(key);        
        }
        
        return getConfiguration(module).getString(key, defaultValue);
    }

    public static String getLiteralString(String module, String key){
        return getLiteralString(module, key, null);
    }
    
    public static String getLiteralString(String module, String  key, String defaultValue){
        String[] StringArr = getStringArray(module, key);
        StringBuffer res = new StringBuffer();
        if (StringArr != null){                            
            for (int i = 0; i < StringArr.length; i++) {
                res.append(StringArr[i]);
                if (i != StringArr.length - 1)
                    res.append(",");
            }
            if(res != null){
                return res.toString();
            }
        }                        
        return defaultValue;
    }

    public static String[] getStringArray(String module, String key) {
        if (module == null || key == null)
            throw new IllegalArgumentException(MSG_ILLEGAL_ARGUMENT);
        
        return getConfiguration(module).getStringArray(key);
    }

    public static List<?> getList(String module, String key) {
        if (module == null || key == null)
            throw new IllegalArgumentException(MSG_ILLEGAL_ARGUMENT);

        return getConfiguration(module).getList(key);
    }

    public static List<?> getList(String module, String key, List<?> defaultValues) {
        if (module == null || key == null)
            throw new IllegalArgumentException(MSG_ILLEGAL_ARGUMENT);

        return getConfiguration(module).getList(key, defaultValues);
    }
}

class BapConfigurationException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public BapConfigurationException() {
        super();
    }

    public BapConfigurationException(String msg) {
        super(msg);
    }

    public BapConfigurationException(String msg, Throwable e) {
        super(msg, e);
    }

    public BapConfigurationException(Throwable e) {
        super(e);
    }
}