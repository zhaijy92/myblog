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

public class RuntimeCachingPropertySet extends CachingPropertySet {
	private static final long serialVersionUID = 1L;

	private static Log logger = LogFactory.getLog(RuntimeCachingPropertySet.class);
    
    private PropertySet rjps;
    
    public void setJdbcPropertySet(PropertySet rjps){
        this.rjps = rjps;
    }
    
    public PropertySet getJdbcPropertySet(){
        return rjps;
    }
    
    public void init(){        
        PropertySetConfig psc = PropertySetConfig.getConfig();        
        Map<?, ?> cacheConfig = psc.getArgs("cached");
        Map<String, Object> cacheArgs = new HashMap<String, Object>();
        cacheArgs.put("PropertySet",rjps);
        cacheArgs.put("bulkload",new Boolean("true"));        
        
        logger.info("init complete");
        super.init(cacheConfig,cacheArgs);  
         
    }
}
