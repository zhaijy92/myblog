package com.zjy.utils;

import javax.servlet.http.HttpServletRequest;

import java.io.InputStream;
import java.io.Writer;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.core.util.QuickWriter;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;
import com.thoughtworks.xstream.io.xml.PrettyPrintWriter;
import com.thoughtworks.xstream.io.xml.XppDriver;

public class XMLUtils {

	 /** 
     * 解析微信发来的请求（XML） 
     *  
     * @param request 
     * @return 
     * @throws Exception 
     */  
    public static Map<String, String> parseXml(HttpServletRequest request) throws Exception {  
        // 将解析结果存储在HashMap中  
        Map<String, String> map = new HashMap<String, String>();  
  
        // 从request中取得输入流  
        InputStream inputStream = request.getInputStream();  
        // 读取输入流  
        SAXReader reader = new SAXReader();  
        Document document = reader.read(inputStream);  
        // 得到xml根元素  
        Element root = document.getRootElement();  
        // 得到根元素的所有子节点  
        List<Element> elementList = root.elements();  
  
        // 遍历所有子节点  
        for (Element e : elementList)  
            map.put(e.getName(), e.getText());  
  
        // 释放资源  
        inputStream.close();  
        inputStream = null;  
  
        return map;  
    }  
  
    /** 
     * 文本消息对象转换成xml 
     *  
     * @param textMessage 文本消息对象 
     * @return xml 
     */  
    public static String textMessageToXml(Object textMessage) {  
        xstream.alias("xml", textMessage.getClass());  
        return xstream.toXML(textMessage);  
    }  
  
  
    /** 
     * 扩展xstream，使其支持CDATA块 
     *  
     * @date 2013-05-19 
     */  
    private static XStream xstream = new XStream(new XppDriver() {  
        public HierarchicalStreamWriter createWriter(Writer out) {  
            return new PrettyPrintWriter(out) {  
                // 对所有xml节点的转换都增加CDATA标记  
                boolean cdata = true;  
  
				public void startNode(String name, @SuppressWarnings("rawtypes") Class clazz) {  
                    super.startNode(name, clazz);  
                }  
  
                protected void writeText(QuickWriter writer, String text) {
                    if (cdata) {  
                        writer.write("<![CDATA[");  
                        writer.write(text);  
                        writer.write("]]>");  
                    } else {  
                        writer.write(text);  
                    }  
                }  
            };  
        }  
    });  
	
}
