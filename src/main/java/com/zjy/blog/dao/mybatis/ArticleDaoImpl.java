package com.zjy.blog.dao.mybatis;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import com.zjy.blog.bean.Article;
import com.zjy.blog.dao.ArticleDao;

/**
 * 
 * @author JH  2015
 */
@Repository
public class ArticleDaoImpl extends SqlSessionDaoSupport implements ArticleDao{

	@Override
	public long save(Article article) {
		this.getSqlSession().insert("article_ns.insert", article);
		return article.getId();
	}

	@Override
	public int findCount(Map<String, Object> srchMap) {
		return this.getSqlSession().selectOne("article_ns.queryCount", srchMap);
	}

	@Override
	public List<Map<String, Object>> query(Map<String, Object> srchMap) {
		return this.getSqlSession().selectList("article_ns.query", srchMap);
	}

	@Override
	public Map<String, Object> findById(long id) {
		return this.getSqlSession().selectOne("article_ns.queryById", id);
	}
}
