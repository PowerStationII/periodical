package com.cn.periodical.controller.author;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ArticleFeeController extends AuthorController{
	
	private static final Logger logger = LoggerFactory.getLogger(ArticleFeeController.class);
	/**
	 * toArticleFeePage
	 * 去稿费查询页面
	 */
	@RequestMapping(value="/toArticleFeePage",method = RequestMethod.GET)
	public ModelAndView toArticleFeePage(@RequestParam("userId") String userId,
			HttpServletRequest request) {
		logger.info("稿件查询Page:["+userId+"]");
		ModelAndView mav = new ModelAndView("contributePage");
		mav.addObject("userId", userId);
		
		
		return mav;
	}
}
