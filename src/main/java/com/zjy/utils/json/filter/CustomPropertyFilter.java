package com.zjy.utils.json.filter;

/**
 * @author JH  2014
 */
public interface CustomPropertyFilter {
	/**
	 * 返回true或者false来决定是否需要把某个属性过滤掉
	 * @param bean
	 * @param fieldName
	 * @return false则表示把该属性过滤掉
	 */
	boolean filter(Object bean, String fieldName, Object fieldValue);

}
