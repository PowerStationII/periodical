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
import com.cn.periodical.pojo.ArticleInfo;
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
	 * toNewArticleDetailPage
	 * 新稿-详情页
	 */
	@RequestMapping(value="/toNewArticleDetailPage",method = RequestMethod.GET)
	public ModelAndView toNewArticleDetailPage(@RequestParam("userId") String userId,
			@RequestParam("artilceId") String artilceId,
			HttpServletRequest request) {
		logger.info("新稿详情页Page入参:["+userId+"]&artilceId:["+artilceId+"]");
		ModelAndView mav = new ModelAndView("editor_newArticleDetailPage");
		mav.addObject("userId", userId);
		
		ArticleInfo articleInfo =articleDealService.qryArticleInfo(artilceId);
		mav.addObject("articleInfo", articleInfo);
		
		logger.info("新稿详情页Page出参:["+JSON.toJSONString(articleInfo)+"]");
		return mav;
	}
	
	/**
	 * toUpdateArticleState
	 * 登记
	 * 稿件状态变更
	 */
	@RequestMapping(value="/toUpdateArticleState",method = RequestMethod.POST)
	public ModelAndView toUpdateArticleState(@RequestParam("userId") String userId,
			
			@RequestParam("artilceId") String artilceId,
			HttpServletRequest request) {
		logger.info("修改稿件状态Page入参:["+userId+"]&artilceId:["+artilceId+"]");
		ModelAndView mav = new ModelAndView("editor_newArticleDetailPage");
		mav.addObject("userId", userId);
		
		int i =articleDealService.updateArticleInfo("", "");
		
		logger.info("修改稿件状态Page出参:[]");
		return null;
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
		List<EditorArticleDealRespDto> list =articleDealService.articleDeal(ArticleStateEnums.ENLISTED_ARTICLE.getCode());
		mav.addObject("list", list);
		
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
		List<EditorArticleDealRespDto> list =articleDealService.articleDeal(ArticleStateEnums.REPAIR_ARTICLE.getCode());
		mav.addObject("list", list);
		
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
		List<EditorArticleDealRespDto> list =articleDealService.articleDeal(ArticleStateEnums.RETURNED_ARTICLE.getCode());
		mav.addObject("list", list);
		
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
		List<EditorArticleDealRespDto> list =articleDealService.articleDeal(ArticleStateEnums.PUBLISH_ARTICLE.getCode());
		mav.addObject("list", list);
		
		return mav;
	}
}
