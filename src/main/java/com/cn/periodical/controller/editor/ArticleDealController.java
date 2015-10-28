package com.cn.periodical.controller.editor;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
/**
 * 稿件编辑-稿件处理Controller
 * */
@Controller
public class ArticleDealController extends EditorController{
	
	private static final Logger logger = LoggerFactory.getLogger(ArticleDealController.class);
	/**
	 * toNewArticlePage
	 * 新稿
	 */
	@RequestMapping(value="/toNewArticlePage",method = RequestMethod.GET)
	public ModelAndView toNewArticlePage(@RequestParam("userId") String userId,
			HttpServletRequest request) {
		logger.info("审稿费Page:["+userId+"]");
		ModelAndView mav = new ModelAndView("contributePage");
		mav.addObject("userId", userId);
		
		
		return mav;
	}
}
