package com.zjy.utils;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author JH
 * 2014年10月20日
 */
public class SupperController {
	
	protected static String NULL = "null";
	protected static String SUCCESS = "success";
	protected static String TRUE = "true";
	protected static String FALSE = "false";
	
	
	protected void jsonResponse(String jsonStr, HttpServletResponse response) {
		response.setContentType("text/plain;charset=UTF-8");
		PrintWriter out = null;
		try {
			out = response.getWriter();
			out.write(jsonStr);
			out.flush();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if(out!=null){
				out.close();
			}
		}
	}
	
	protected String extractRequestPath(HttpServletRequest request) {
		String servletPath = request.getServletPath();
		String pathInfo = request.getPathInfo();
		String query = request.getQueryString();
		return (servletPath == null ? "" : servletPath) + (pathInfo == null ? "" : pathInfo)
				+ (query == null ? "" : ("?" + query));
	}

}
