package com.zjy.utils.json.gson.filter;

/**
 * @author JH  2014
 */
public interface CustomFilter {
	public boolean filterClass(Class<?> clz);
	
	public boolean filterField(String field);
	
	public void revertExclusionField(Class<?> clz);

}
