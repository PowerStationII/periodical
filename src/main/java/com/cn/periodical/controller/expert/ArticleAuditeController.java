package com.cn.periodical.controller.expert;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ArticleAuditeController extends ExpertController{
	
	private static final Logger logger = LoggerFactory.getLogger(ArticleAuditeController.class);
	/**
	 * toArticleAuditePage
	 * 去审稿页面
	 */
	@RequestMapping(value="/toArticleAuditePage",method = RequestMethod.GET)
	public ModelAndView toArticleAuditePage(@RequestParam("userId") String userId,
			HttpServletRequest request) {
		logger.info("审稿Page:["+userId+"]");
		ModelAndView mav = new ModelAndView("contributePage");
		mav.addObject("userId", userId);
		
		
		return mav;
	}
}
