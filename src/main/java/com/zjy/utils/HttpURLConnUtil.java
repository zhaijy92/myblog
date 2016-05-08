package com.zjy.utils;

import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * 
 * @author JH 2014
 */
public class HttpURLConnUtil {
	
	/**
	 * 请求http url
	 * @param strUrl
	 * @return
	 */
	public static String getHttpResult(String strUrl) {
		String result = "";
		try {
			URL url = new URL(strUrl);
			HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
			httpURLConnection.setDoOutput(true);
			httpURLConnection.setDoInput(true);
			httpURLConnection.setConnectTimeout(10000);
			httpURLConnection.setRequestMethod("GET");
			httpURLConnection.connect();
			InputStreamReader bis = new InputStreamReader(httpURLConnection.getInputStream(), "UTF-8");
			int c = 0;
			while ((c = bis.read()) != -1) {
				result = result + (char) c;
			}
		} catch (Exception e) {
			// e.printStackTrace();
			System.out.println(strUrl + "  HTTP请求失败！");
			result = "http error";
		}

		return result;
	}
	
	
	public static void main(String[] args) {
		long t = System.currentTimeMillis();
		for(int i=0;i<1;i++)
			System.out.println(getHttpResult("http://hejia.magus-soft.com/amp/service/developer/verify?app_key=7293948d11eb41bca1e78414fb47652a&digest=23423dsfadfa&Timestamp=2015-04-23T07:11:04+0800&Signature=hJQU1FD2uGfXLNUT1hmbdXL4vxMsrmhUBfnoLi5zbvU%3D"));
		
		System.out.println(System.currentTimeMillis() - t);
	}
	

}
