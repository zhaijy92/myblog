/*
 *  This is a part of the Galaxy Workflow Platform.
 *  Copyright (C) 1998-2006 JH Corporation
 *  All rights reserved.
 *
 *  Licensed under the JH private License.
 *  Created on 2006-3-30
 * 
 */
package com.zjy.sys.io;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


public class UnsupportedURLProtocolException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	
	private static Log logger = LogFactory
            .getLog(UnsupportedURLProtocolException.class);

    public UnsupportedURLProtocolException() {
        super();
    }

    /**
     * @param message
     */
    public UnsupportedURLProtocolException(String message) {
        super(message);
        logger.error(message);
    }

    /**
     * @param message
     * @param cause
     */
    public UnsupportedURLProtocolException(String message, Throwable cause) {
        super(message, cause);
        logger.error(message,cause);
    }

    /**
     * @param cause
     */
    public UnsupportedURLProtocolException(Throwable cause) {
        this("��֧�ֵ�URL���ͣ�",cause);
    }
}