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

import java.net.URL;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * -
 * 
 * @author JH
 * 
 * 主要是解决不同服务器对URL Protocol的格式不同而造成的解析错误。 <br>
 * 目前实现解决：某些开源技术对URL的解析，并未考虑到wsjar的情况，因此我们向它们传递 <br>
 * URL时，应该经过一定的转换才可以。 <br>
 * TODO Galaxy应该提供自己的ResourceLoader，在资源加载方面我们最好有自己的封装。
 */
public class URLPatternResolver {

    /** URL protocol for an entry from a jar file: "jar" */
    private static final String URL_PROTOCOL_JAR = "jar";

    /** URL protocol for an entry from a zip file: "zip" */
    //private static final String URL_PROTOCOL_ZIP = "zip";

    /** URL protocol for an entry from a WebSphere jar file: "wsjar" */
    private static final String URL_PROTOCOL_WSJAR = "wsjar";

    /** Separator between JAR URL and file path within the JAR */
    //private static final String JAR_URL_SEPARATOR = "!/";

    private static Log logger = LogFactory.getLog(URLPatternResolver.class);

    public URLPatternResolver() {
        super();
    }

    /**
     * 增加对zip的转换
     * 
     * @param url
     *            输入的url
     * @return
     */
    public static URL getStandardURL(String url) {
        if (url == null) {
            return null;
        }
        if (logger.isDebugEnabled()) {
            logger.debug("解析URL：" + url);
        }
        URL urlObj = null;
        if (url.startsWith(URL_PROTOCOL_WSJAR)) {
            if (logger.isDebugEnabled()) {
                logger.debug("当前使用的是WAS的classloader");
            }
            try {
                url = url.substring(2);
                urlObj = new URL(url);
            } catch (Exception e) {
                logger.error("URL转换出错！");
                return null;
            }
        } else if (url.startsWith(URL_PROTOCOL_JAR)) {
            if (logger.isDebugEnabled()) {
                logger.debug("当前使用的是普通的classloader");
            }
            try {
                urlObj = new URL(url);
            } catch (Exception e) {
                logger.error("URL转换出错！");
                return null;
            }
        } else {
            if (logger.isDebugEnabled()) {
                logger.debug("当前使用的是普通的classloader");
            }
            try {
                urlObj = new URL(url);
            } catch (Exception e) {
                logger.error("URL转换出错！");
                return null;
            }
        }
        return urlObj;
    }

}