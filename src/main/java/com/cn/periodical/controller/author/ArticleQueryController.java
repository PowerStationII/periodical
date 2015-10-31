package com.cn.periodical.controller.author;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
/**
 * 作者工作区-稿件查询 
 * */
@Controller
public class ArticleQueryController extends AuthorController{
	
	private static final Logger logger = LoggerFactory.getLogger(ArticleQueryController.class);
	/**
	 * toArticleQueryPage
	 * author/toArticleQueryPage
	 * 去稿件查询页面
	 */
	@RequestMapping(value="/toArticleQueryPage",method = RequestMethod.GET)
	public ModelAndView toArticleQueryPage(@RequestParam("userId") String userId,
			HttpServletRequest request) {
		logger.info("稿件查询Page:["+userId+"]");
		ModelAndView mav = new ModelAndView("contributePage");
		mav.addObject("userId", userId);
		
		
		return mav;
	}
}
