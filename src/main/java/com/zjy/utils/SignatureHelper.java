package com.zjy.utils;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.SortedMap;
import java.util.TimeZone;
import java.util.TreeMap;
import java.util.regex.Pattern;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 验证签名
 * @author JH  2015
 */
public class SignatureHelper {
	private static Logger logger = LoggerFactory.getLogger(SignatureHelper.class);
	
	
	/**
	 * 统一字符编码 UTF-8
	 */
	private static final String UTF8_CHARSET = "UTF-8";

	/**
	 * HMAC算法
	 */
	private static final String HMAC_SHA256_ALGORITHM = "HmacSHA256";


	private String requestURI = null;
	private String requestMethod = null;
	private String endpoint = null; //必需小写
	@SuppressWarnings("unused")
	private String appKey = null;
	private String secretKey = null;
	@SuppressWarnings("unused")
	private String digest = null; //摘要

	private SecretKeySpec secretKeySpec = null;
	private Mac mac = null;
	
	
	
	/**
	 * 私有化构造方法,禁止直接创建实例
	 */
	private SignatureHelper() {
	}

	
	/**
	 * 初始化必需提供的三个参数
	 * 
	 * @param endpoint  请求目的地
	 * @param appKey  app Key
	 * @param secretKey  Secret Key
	 */
	public static SignatureHelper getInstance(String requestMethod,String endpoint, String requestURI, String appKey, String secretKey, String digest)
			throws IllegalArgumentException, UnsupportedEncodingException, NoSuchAlgorithmException, InvalidKeyException {
		//System.out.println("{{{{{{" +requestMethod+","+endpoint+","+requestURI+","+appKey+","+secretKey+","+digest + "}}}}}}");
		if (null == requestMethod || requestMethod.length() == 0) {
			throw new IllegalArgumentException("requestMethod is null or empty");
		}
		if (null == endpoint || endpoint.length() == 0) {
			throw new IllegalArgumentException("endpoint is null or empty");
		}
		if (null == requestURI || requestURI.length() == 0) {
			throw new IllegalArgumentException("requestURI is null or empty");
		}
		if (null == appKey || appKey.length() == 0) {
			throw new IllegalArgumentException("appKey is null or empty");
		}
		if (null == secretKey || secretKey.length() == 0) {
			throw new IllegalArgumentException("secretKey is null or empty");
		}
		if (null == digest || digest.length() == 0) {
			throw new IllegalArgumentException("digest is null or empty");
		}

		SignatureHelper instance = new SignatureHelper();
		instance.requestMethod = requestMethod;
		instance.requestURI = requestURI;
		instance.endpoint = endpoint.toLowerCase();
		instance.appKey = appKey;
		instance.secretKey = secretKey;
		instance.digest = digest;

		byte[] secretyKeyBytes = instance.secretKey.getBytes(UTF8_CHARSET);
		instance.secretKeySpec = new SecretKeySpec(secretyKeyBytes,HMAC_SHA256_ALGORITHM);
		instance.mac = Mac.getInstance(HMAC_SHA256_ALGORITHM);
		instance.mac.init(instance.secretKeySpec);

		return instance;
	}

	/**
	 * 生成获取签名的URL
	 */
	public String sign(String queryString) {
		
		Map<String, String> params = this.createParameterMap(queryString);
		
		return this.sign(params);
	}

	/**
	 * 解析参数,获取URL
	 */
	public String sign(Map<String, String> params) {
		
		//参数排序,获取参数字符串
		SortedMap<String, String> sortedParamMap = new TreeMap<String, String>(params);
		String canonicalQS = this.canonicalize(sortedParamMap);

		// 创建签名需要计算的字符串
		String toSign = requestMethod + "\n" + this.endpoint + "\n" + requestURI + "\n" + canonicalQS;

		if(logger.isDebugEnabled()){
			System.out.println("================================");
			System.out.println("AMP toSign == " + toSign);
			System.out.println("================================");
		}
		
		// 获取签名
		String hmac = this.hmac(toSign);
		String sig = this.percentEncodeRfc3986(hmac);
		if(logger.isDebugEnabled())
			System.out.println("AMP Signature == " + sig);
		
		return sig;
	}

	/**
	 * 计算获取 HMAC (哈希运算消息认证码)
	 * 
	 * @param stringToSign 需要计算的字符串
	 * @return base64-encoded hmac value.
	 */
	private String hmac(String stringToSign) {
		String signature = null;
		byte[] data;
		byte[] rawHmac;
		try {
			data = stringToSign.getBytes(UTF8_CHARSET);
			rawHmac = mac.doFinal(data);
			Base64 encoder = new Base64();
			signature = new String(encoder.encode(rawHmac));
		} catch (UnsupportedEncodingException e) {
			throw new RuntimeException(UTF8_CHARSET + " is unsupported!", e);
		}
		signature = Pattern.compile("\\s*|\t|\r|\n").matcher(signature).replaceAll("");
		return signature;
	}

	/**
	 * @return ISO-8601 格式的timestamp.
	 */
	@SuppressWarnings("unused")
	private String timestamp() {
		String timestamp = null;
		Calendar cal = Calendar.getInstance();
		DateFormat dfm = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
		dfm.setTimeZone(TimeZone.getTimeZone("GMT"));
		timestamp = dfm.format(cal.getTime());
		return timestamp;
	}

	/**
	 * 组装排序的查询参数
	 * 
	 * @param sortedParamMap 
	 * @return query string.
	 */
	private String canonicalize(SortedMap<String, String> sortedParamMap) {
		if (sortedParamMap.isEmpty()) {
			return "";
		}

		StringBuffer buffer = new StringBuffer();
		Iterator<Map.Entry<String, String>> iter = sortedParamMap.entrySet().iterator();

		while (iter.hasNext()) {
			Map.Entry<String, String> kvpair = iter.next();
			buffer.append(percentEncodeRfc3986(kvpair.getKey()));
			buffer.append("=");
			buffer.append(percentEncodeRfc3986(kvpair.getValue()));
			if (iter.hasNext()) {
				buffer.append("&");
			}
		}
		String cannoical = buffer.toString();
		return cannoical;
	}

	/**
	 * 模拟生成Rfc3986标准编码
	 * 
	 * @param s 
	 * @return 
	 */
	public String percentEncodeRfc3986(String s) {
		String out;
		try {
			//out = URLEncoder.encode(s, UTF8_CHARSET).replace("+", "%20").replace("*", "%2A").replace("%7E", "~");
			out = URLEncoder.encode(s, UTF8_CHARSET).replace("%", "").replace(" ", "");
		} catch (UnsupportedEncodingException e) {
			out = s;
		}
		return out;
	}

	/**
	 * 解析字符串参数
	 * 
	 * @param queryString
	 * @return
	 */
	private Map<String, String> createParameterMap(String queryString) {
		Map<String, String> map = new HashMap<String, String>();
		String[] pairs = queryString.split("&");

		for (String pair : pairs) {
			if (pair.length() < 1) {
				continue;
			}

			String[] tokens = pair.split("=", 2);
			for (int j = 0; j < tokens.length; j++) {
				try {
					tokens[j] = URLDecoder.decode(tokens[j], UTF8_CHARSET);
				} catch (UnsupportedEncodingException e) {
				}
			}
			switch (tokens.length) {
			case 1: {
				if (pair.charAt(0) == '=') {
					map.put("", tokens[0]);
				} else {
					map.put(tokens[0], "");
				}
				break;
			}
			case 2: {
				map.put(tokens[0], tokens[1]);
				break;
			}
			}
		}
		return map;
	}
}

/**
 * 	 生成签名示例
 *
 * 	 SignatureHelper helper = null;
 * 	 try {
 * 		 helper = SignatureHelper.getInstance(REQUEST_METHOD, END_POINT, REQUEST_URI, APP_KEY, SECRET_KEY, digest);
 * 	 } catch (Exception e) {
 * 		 e.printStackTrace();
 * 	 }
 * 	
 *  String sign = helper.sign(strParamsMap);
 *
 */
