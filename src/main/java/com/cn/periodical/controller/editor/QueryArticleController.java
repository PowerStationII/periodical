package com.cn.periodical.controller.editor;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.cn.periodical.pojo.EditorQueryArtilces;
import com.cn.periodical.pojo.UserInfo;
import com.cn.periodical.service.ArticleQueryService;
/**
 * 稿件编辑-稿件查询Controller for editor
 * */
@Controller
public class QueryArticleController extends EditorController{
	
	private static final Logger logger = LoggerFactory.getLogger(QueryArticleController.class);
	
	@Autowired
	ArticleQueryService articleQueryService;
	/**
	 * toQueryArticlePage
	 * 编辑稿件查询
	 */
	@RequestMapping(value="/toQueryArticlePage")
	public ModelAndView toQueryArticlePage(HttpServletRequest request ,@ModelAttribute EditorQueryArtilces reqDto) {
		logger.info("稿件查询Page in :["+JSON.toJSONString(reqDto)+"]");
		ModelAndView mav = new ModelAndView("editor_queryArticlePage");
		List<EditorQueryArtilces> list = articleQueryService.editorQueryArticles(reqDto);
		mav.addObject("list", list);
		logger.info("稿件查询Page out :["+JSON.toJSONString(list)+"]");
		return mav;
	}
}
