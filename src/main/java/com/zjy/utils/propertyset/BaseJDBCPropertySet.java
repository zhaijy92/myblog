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

import com.opensymphony.module.propertyset.config.PropertySetConfig;
import com.opensymphony.module.propertyset.database.JDBCPropertySet;

public class BaseJDBCPropertySet extends JDBCPropertySet {
    private static Log logger = LogFactory.getLog(BaseJDBCPropertySet.class);
    public void init(){
        if(logger.isDebugEnabled()){
            logger.debug("BaseJDBCPropertySet.init......");
        }
        Map<String, String> args = new HashMap<String, String>();        
        args.put("globalKey","base");
        PropertySetConfig psc = PropertySetConfig.getConfig();
        Map<?, ?> configx = psc.getArgs("jdbc");        
        super.init(configx,args);          
    }

}
