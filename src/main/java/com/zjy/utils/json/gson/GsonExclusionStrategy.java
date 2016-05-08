package com.zjy.utils.json.gson;

import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;
import com.zjy.utils.json.gson.filter.CustomFilter;

/**
 * @author JH  2014
 */
public class GsonExclusionStrategy implements ExclusionStrategy {
	private CustomFilter exclusionFilter;

	public GsonExclusionStrategy(CustomFilter exclusionFilter) {
		this.exclusionFilter = exclusionFilter;
	}

	@Override
	public boolean shouldSkipClass(Class<?> clz) {
		return exclusionFilter.filterClass(clz);
	}

	@Override
	public boolean shouldSkipField(FieldAttributes fa) {
		String name = fa.getName();
		return exclusionFilter.filterField(name);
	}

}
