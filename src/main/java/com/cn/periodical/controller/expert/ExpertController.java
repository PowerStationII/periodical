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
public class ExpertController {
	
	private static final Logger logger = LoggerFactory.getLogger(ExpertController.class);
//	/**
//	 * toContributePage
//	 * 去投稿页面
//	 */
//	@RequestMapping(value="/toContributePage",method = RequestMethod.GET)
//	public ModelAndView toContributePage(@RequestParam("userId") String userId,
//			HttpServletRequest request) {
//		logger.info("投稿Page:["+userId+"]");
//		ModelAndView mav = new ModelAndView("contributePage");
//		mav.addObject("userId", userId);
//		
//		
//		return mav;
//	}
//	
//	/**
//	 * toArticleQueryPage
//	 * 去稿件查询页面
//	 */
//	@RequestMapping(value="/toArticleQueryPage",method = RequestMethod.GET)
//	public ModelAndView toArticleQueryPage(@RequestParam("userId") String userId,
//			HttpServletRequest request) {
//		logger.info("稿件查询Page:["+userId+"]");
//		ModelAndView mav = new ModelAndView("contributePage");
//		mav.addObject("userId", userId);
//		
//		
//		return mav;
//	}
//	
//	
//	/**
//	 * toArticleFeePage
//	 * 去稿费查询页面
//	 */
//	@RequestMapping(value="/toArticleFeePage",method = RequestMethod.GET)
//	public ModelAndView toArticleFeePage(@RequestParam("userId") String userId,
//			HttpServletRequest request) {
//		logger.info("稿件查询Page:["+userId+"]");
//		ModelAndView mav = new ModelAndView("contributePage");
//		mav.addObject("userId", userId);
//		
//		
//		return mav;
//	}
//	
//	/**
//	 * toUpdatePInfoPage
//	 * 去修改个人信息Page
//	 */
//	@RequestMapping(value="/toUpdatePInfoPage",method = RequestMethod.GET)
//	public ModelAndView toUpdatePInfoPage(@RequestParam("userId") String userId,
//			HttpServletRequest request) {
//		logger.info("修改个人信息Page:["+userId+"]");
//		ModelAndView mav = new ModelAndView("contributePage");
//		mav.addObject("userId", userId);
//		
//		
//		return mav;
//	}
//	
//	
//	/**
//	 * toUpdatePwdPage
//	 * 去修改个人信息Page
//	 */
//	@RequestMapping(value="/toUpdatePwdPage",method = RequestMethod.GET)
//	public ModelAndView toUpdatePwdPage(@RequestParam("userId") String userId,
//			HttpServletRequest request) {
//		logger.info("修改密码Page:["+userId+"]");
//		ModelAndView mav = new ModelAndView("contributePage");
//		mav.addObject("userId", userId);
//		
//		
//		return mav;
//	}
//	
//	/**
//	 * toRegisterPage
//	 * 去作者注册Page
//	 */
//	@RequestMapping(value="/toRegisterPage",method = RequestMethod.GET)
//	public ModelAndView toRegisterPage(@RequestParam("userId") String userId,
//			HttpServletRequest request) {
//		logger.info("修改密码Page:["+userId+"]");
//		ModelAndView mav = new ModelAndView("contributePage");
//		mav.addObject("userId", userId);
//		
//		
//		return mav;
//	}
}
