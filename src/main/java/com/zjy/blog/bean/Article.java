package com.zjy.blog.bean;

import java.io.Serializable;

public class Article implements Serializable{

	/**
	 * @param args
	 */
	private static final long serialVersionUID = -7562295633491126908L;
	
	private Long id;    //文章id
	private String article_name;    //文章名称
	private String article_sorted;    //文章分类
	private String content;         //文章内容
	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getArticle_name() {
		return article_name;
	}

	public void setArticle_name(String article_name) {
		this.article_name = article_name;
	}

	public String getArticle_sorted() {
		return article_sorted;
	}

	public void setArticle_sorted(String article_sorted) {
		this.article_sorted = article_sorted;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
