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

import com.cn.periodical.manager.PeriodicalInfoManager;
import com.cn.periodical.manager.PeriodicalManager;
import com.cn.periodical.pojo.Periodical;
import com.cn.periodical.pojo.PeriodicalQuery;
/**
 * 稿件编辑-组刊Controller
 * */
@Controller
public class ArticleGroupController extends EditorController{
	
	private static final Logger logger = LoggerFactory.getLogger(ArticleGroupController.class);
	@Autowired
	PeriodicalInfoManager periodicalInfoManager;
	
	@Autowired
	PeriodicalManager periodicalManager;
	
	/**
	 * toArticleGroupPage
	 * 组稿
	 */
	@RequestMapping(value="/toArticleGroupPage",method = RequestMethod.GET)
	public ModelAndView toArticleGroupPage(@RequestParam("userId") String userId,
			HttpServletRequest request) {
		logger.info("排刊组稿Page:["+userId+"]");
		ModelAndView mav = new ModelAndView("editor_articleGroupPage");
		mav.addObject("userId", userId);
		List<Periodical> periodicals = periodicalManager.queryList(null);
		mav.addObject("list", periodicals);
		return mav;
	}
	
	
	/**
	 * toArticleGroupDetailPage
	 * 组稿详情页
	 */
	@RequestMapping(value="/toArticleGroupDetailPage",method = RequestMethod.GET)
	public ModelAndView toArticleGroupDetailPage(@RequestParam("periodicalIssueNo") String periodicalIssueNo,
			@RequestParam("userId") String userId,
			HttpServletRequest request) {
		logger.info("组稿左右互博Page:["+userId+"]&["+periodicalIssueNo+"]");
		ModelAndView mav = new ModelAndView("editor_articleGroupDetailPage");
		mav.addObject("userId", userId);
		mav.addObject("periodicalIssueNo", periodicalIssueNo);
		return mav;
	}
	
	
	/**
	 * toArticleGroup
	 * 组稿
	 */
	@RequestMapping(value="/toArticleGroup")
	public ModelAndView toArticleGroup(@RequestParam("periodicalIssueNo") String periodicalIssueNo,
			@RequestParam("userId") String userId,
			HttpServletRequest request) {
		logger.info("组稿左右互博提交进来的:["+userId+"]&["+periodicalIssueNo+"]");
		logger.info("----------------");
		logger.info(request.getParameter("selectTest"));
		logger.info("----------------");
		logger.info(request.getParameter("rightSelect"));
		ModelAndView mav = new ModelAndView("editor_articleGroupPage");
		mav.addObject("userId", userId);
		
		return mav;
	}
}
