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
public class ContributeController extends AuthorController{
	
	private static final Logger logger = LoggerFactory.getLogger(ContributeController.class);
	/**
	 * toContributePage
	 * author/toContributePage
	 * 去投稿页面
	 */
	@RequestMapping(value="/toContributePage",method = RequestMethod.GET)
	public ModelAndView toContributePage(@RequestParam("userId") String userId,
			HttpServletRequest request) {
		logger.info("投稿Page:["+userId+"]");
		ModelAndView mav = new ModelAndView("contributePage");
		mav.addObject("userId", userId);
		
		
		return mav;
	}
}
