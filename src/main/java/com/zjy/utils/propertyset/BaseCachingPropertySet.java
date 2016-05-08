/*
 *  This is a part of the Galaxy Workflow Platform.
 *  Copyright (C) 1998-2006 JH Corporation
 *  All rights reserved.
 *
 *  Licensed under the JH private License.
 *  Created on 2006-7-15
 * 
 */
package com.zjy.utils.propertyset;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.opensymphony.module.propertyset.PropertySet;
import com.opensymphony.module.propertyset.cached.CachingPropertySet;
import com.opensymphony.module.propertyset.config.PropertySetConfig;

public class BaseCachingPropertySet extends CachingPropertySet {
	private static final long serialVersionUID = 1L;

	private static Log logger = LogFactory.getLog(BaseCachingPropertySet.class);
    
    private PropertySet bjps;
    
    public void setJdbcPropertySet(PropertySet bjps){
        this.bjps = bjps;
    }
    
    public PropertySet getJdbcPropertySet(){
        return bjps;
    }
    
    public void init(){
        if(logger.isDebugEnabled()){
            logger.debug("RuntimeCachingPropertySet.init......");        
        }
        PropertySetConfig psc = PropertySetConfig.getConfig();        
        Map<?, ?> cacheConfig = psc.getArgs("cached");
        Map<String, Object> cacheArgs = new HashMap<String, Object>();
        
            bjps.setString("dbhost","");
            bjps.setString("dbport","");
            bjps.setString("dbtype","");
            bjps.setString("dbname","");        
            bjps.setString("dbuser","");
            bjps.setString("dbpasswd","");
            
            bjps.setString("ldaphost","");
            bjps.setString("ldapport","");        
            bjps.setString("ldapdn","");
            bjps.setString("ldappasswd","");        
            
            bjps.setString("newdbhost","");
            bjps.setString("newdbport","");
            bjps.setString("newdbtype","");
            bjps.setString("newdbname","");        
            bjps.setString("newdbuser","");
            bjps.setString("newdbpasswd","");
            
            bjps.setString("newldaphost","");
            bjps.setString("newldapport","");        
            bjps.setString("newldapdn","");
            bjps.setString("newldappasswd","");
        
        cacheArgs.put("PropertySet",bjps);
        cacheArgs.put("bulkload",new Boolean("true"));        
        
        super.init(cacheConfig,cacheArgs);  
         
    }
    
    public void reload(){
            if(logger.isDebugEnabled()){
                logger.debug("RuntimeCachingPropertySet.init......");        
            }
            PropertySetConfig psc = PropertySetConfig.getConfig();        
            Map<?, ?> cacheConfig = psc.getArgs("cached");
            Map<String, Object> cacheArgs = new HashMap<String, Object>();
            
            cacheArgs.put("PropertySet",bjps);
            cacheArgs.put("bulkload",new Boolean("true"));        
            
            super.init(cacheConfig,cacheArgs);  
             
    }
}
