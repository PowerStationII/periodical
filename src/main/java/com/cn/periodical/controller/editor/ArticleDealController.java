package com.cn.periodical.controller.editor;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.cn.periodical.enums.ArticleStateEnums;
import com.cn.periodical.response.EditorArticleDealRespDto;
import com.cn.periodical.service.EditorArticleDealService;
/**
 * 稿件编辑-稿件处理Controller
 * */
@Controller
public class ArticleDealController extends EditorController{
	
	private static final Logger logger = LoggerFactory.getLogger(ArticleDealController.class);
	
	@Autowired
	EditorArticleDealService articleDealService;
	
	
	/**
	 * toNewArticlePage
	 * 新稿
	 */
	@RequestMapping(value="/toNewArticlePage",method = RequestMethod.GET)
	public ModelAndView toNewArticlePage(@RequestParam("userId") String userId,
			HttpServletRequest request) {
		logger.info("新稿Page入参:["+userId+"]");
		ModelAndView mav = new ModelAndView("editor_newArticlePage");
		mav.addObject("userId", userId);
		List<EditorArticleDealRespDto> list =articleDealService.articleDeal(ArticleStateEnums.NEW_ARTICLE.getCode());
		mav.addObject("list", list);
		logger.info("新稿Page出参:["+JSON.toJSONString(list)+"]");
		return mav;
	}
	
	/**
	 * toEnlistedArticlePage
	 * 已登记
	 */
	@RequestMapping(value="/toEnlistedArticlePage",method = RequestMethod.GET)
	public ModelAndView toEnlistedArticlePage(@RequestParam("userId") String userId,
			HttpServletRequest request) {
		logger.info("已登记Page:["+userId+"]");
		ModelAndView mav = new ModelAndView("editor_enlistedArticlePage");
		mav.addObject("userId", userId);
		
		
		return mav;
	}
	
	
	/**
	 * toRepairArticlePage
	 * 返修
	 */
	@RequestMapping(value="/toRepairArticlePage",method = RequestMethod.GET)
	public ModelAndView toRepairArticlePage(@RequestParam("userId") String userId,
			HttpServletRequest request) {
		logger.info("返修Page:["+userId+"]");
		ModelAndView mav = new ModelAndView("editor_repairArticlePage");
		mav.addObject("userId", userId);
		
		
		return mav;
	}
	
	/**
	 * toReturnedArticlePage
	 * 退稿
	 */
	@RequestMapping(value="/toReturnedArticlePage",method = RequestMethod.GET)
	public ModelAndView toReturnedArticlePage(@RequestParam("userId") String userId,
			HttpServletRequest request) {
		logger.info("退稿Page:["+userId+"]");
		ModelAndView mav = new ModelAndView("editor_returnedArticlePage");
		mav.addObject("userId", userId);
		
		
		return mav;
	}
	
	/**
	 * toPublishArticlePage
	 * 待刊
	 */
	@RequestMapping(value="/toPublishArticlePage",method = RequestMethod.GET)
	public ModelAndView toPublishArticlePage(@RequestParam("userId") String userId,
			HttpServletRequest request) {
		logger.info("待刊Page:["+userId+"]");
		ModelAndView mav = new ModelAndView("editor_publishArticlePage");
		mav.addObject("userId", userId);
		
		
		return mav;
	}
}
