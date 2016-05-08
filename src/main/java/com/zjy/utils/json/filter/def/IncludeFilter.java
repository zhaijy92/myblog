package com.zjy.utils.json.filter.def;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import com.zjy.utils.json.filter.CustomPropertyFilter;

public class IncludeFilter implements CustomPropertyFilter{
	
	private Set<String> fields;
	
	public IncludeFilter(String[] fieldnames){
		fields = new HashSet<String>((int)(fieldnames.length * 1.25));
		Collections.addAll(fields, fieldnames);
	}
	
	public boolean filter(Object bean, String fieldName, Object fieldValue) {
		if(fields.contains(fieldName)){
			return true;
		}
		return false;
	}

	public Set<String> getFields() {
		return fields;
	}

	public void setFields(Set<String> fields) {
		this.fields = fields;
	}
}
