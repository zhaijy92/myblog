package com.zjy.utils.json.gson.filter.impl;

import java.lang.reflect.Field;

import com.zjy.utils.json.gson.filter.CustomFilter;

/**
 * @author JH  2014
 */
public class DefaultCustomFilter implements CustomFilter {
	private Class<?>[] classes;
	private String[] fields;

	public Class<?>[] getClasses() {
		return classes;
	}

	public void setClasses(Class<?>[] classes) {
		this.classes = classes;
	}

	public String[] getFields() {
		return fields;
	}

	public void setFields(String[] fields) {
		this.fields = fields;
	}

	@Override
	public void revertExclusionField(Class<?> bean) {
		if (bean != null) {
			Field[] fields = bean.getFields();
			if (fields.length > this.fields.length) {
				String[] newFields = new String[fields.length - this.fields.length];
				for (int i = 0, j = 0; i < fields.length; i++) {
					Field f = fields[i];
					for (String s : this.fields) {
						if (!f.getName().equals(s)) {
							newFields[j] = f.getName();
							j++;
						}
					}
				}

				setFields(newFields);
			}

		}
	}

	@Override
	public boolean filterClass(Class<?> clz) {
		if (classes != null) {
			for (Class<?> c : classes) {
				if (c == clz)
					return true;
			}
		}
		return false;
	}

	@Override
	public boolean filterField(String field) {
		if (fields != null) {
			for (String str : fields) {
				if (str.equals(field))
					return true;
			}
		}

		return false;
	}
}
