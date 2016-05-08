package com.zjy.blog.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zjy.blog.bean.Article;
import com.zjy.blog.dao.ArticleDao;
import com.zjy.blog.service.ArticleService;

/**
 * 
 * @author JH  2015
 */
@Service("articleService")
public class ArticleServiceImpl implements ArticleService{

	@Autowired
	private ArticleDao articleDao;

	@Override
	public long add(Article article) {
		return articleDao.save(article);
	}

	@Override
	public int queryCount(Map<String, Object> srchMap) {
		return articleDao.findCount(srchMap);
	}

	@Override
	public List<Map<String, Object>> query(Map<String, Object> srchMap) {
		return articleDao.query(srchMap);
	}

	@Override
	public Map<String, Object> queryById(long id) {
		return articleDao.findById(id);
	}
	
}
