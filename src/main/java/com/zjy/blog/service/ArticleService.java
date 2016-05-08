package com.zjy.blog.service;

import java.util.List;
import java.util.Map;

import com.zjy.blog.bean.Article;

public interface ArticleService {

	public long add(Article article);
	
    public int queryCount(Map<String,Object> srchMap);
	
	public List<Map<String, Object>> query(Map<String,Object> srchMap);
	
	public Map<String, Object> queryById(long id);
}
