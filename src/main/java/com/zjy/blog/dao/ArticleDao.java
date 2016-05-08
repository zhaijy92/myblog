package com.zjy.blog.dao;

import java.util.List;
import java.util.Map;

import com.zjy.blog.bean.Article;

public interface ArticleDao {

	public long save(Article article);

    public int findCount(Map<String,Object> srchMap);
	
	public List<Map<String, Object>> query(Map<String,Object> srchMap);
	
	public Map<String, Object> findById(long id);
}
