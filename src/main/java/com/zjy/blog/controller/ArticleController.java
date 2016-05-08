package com.zjy.blog.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.zjy.blog.bean.Article;
import com.zjy.blog.service.ArticleService;
import com.zjy.utils.SupperController;
import com.zjy.utils.json.gson.GsonUtils;

@Controller
@RequestMapping("/live/article")
public class ArticleController extends SupperController{
	@Autowired
	private ArticleService articleService;
	
	@RequestMapping("/toAdd")
	public ModelAndView preAdd(HttpServletRequest request,HttpServletResponse response) {
		
		return new ModelAndView("jsp/article/add.jsp");
	}
	
	@RequestMapping("/add")
	public ModelAndView register(HttpServletRequest request,HttpServletResponse response) {
		String title = request.getParameter("title");
		String sorted = request.getParameter("sorted");
		String content = request.getParameter("content");
		System.out.println("title="+title+"content="+content);
		Article article = new Article();
		article.setArticle_name(title);
		article.setArticle_sorted(sorted);    //分类
		article.setContent(content);
		long id = articleService.add(article);
		ModelAndView model = new ModelAndView();
		if(id>0){
//			model.addObject("result", SUCCESS);
//			model.setViewName("forward:jsp/article/index.jsp");
			Map<String,Object> resultMap = new HashMap<String,Object>();
			resultMap.put("result", SUCCESS);
			jsonResponse(GsonUtils.toJson(resultMap), response);
		}
	    return null;
	}
	
	@RequestMapping("/findAll")
	public ModelAndView jsonList(HttpServletRequest request, HttpServletResponse response) {
		int startRow = 0;
		int count = 10;
//		if(StringUtils.isNotBlank(page) && StringUtils.isNotBlank(rows)){
//			page = ("0".equals(page)?"1":page);
//			count = Integer.valueOf(rows);
//			startRow = (Integer.valueOf(page)-1)*count;
//		}
		
		Map<String,Object> srchMap = new HashMap<String,Object>();
		int total = articleService.queryCount(srchMap);
		srchMap.put("startRow", startRow);
		srchMap.put("count", count);
		List<Map<String,Object>> dataList = articleService.query(srchMap);
		Map<String,Object> resultMap = new HashMap<String,Object>();
		resultMap.put("total", total);
		resultMap.put("data", dataList);
		jsonResponse(GsonUtils.toJson(resultMap), response);
		return null;
	}
	
	
	@RequestMapping("/findById")
	public ModelAndView findById(HttpServletRequest request, HttpServletResponse response) {
		long id = Long.parseLong(request.getParameter("id"));
		
		Map<String, Object> articleMap = articleService.queryById(id);
		Article article = new Article();
		article.setArticle_name(articleMap.get("article_name").toString());
		article.setArticle_sorted(articleMap.get("article_sorted").toString());
		article.setContent(articleMap.get("content").toString());
//		Map<String,Object> resultMap = new HashMap<String,Object>();
//		resultMap.put("result", SUCCESS);
//		resultMap.put("data", articleMap);
//		jsonResponse(GsonUtils.toJson(resultMap), response);
		ModelAndView model = new ModelAndView("jsp/article/content.jsp");
		model.addObject(article);
		return model;
	}
	
	
	
	
	
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
