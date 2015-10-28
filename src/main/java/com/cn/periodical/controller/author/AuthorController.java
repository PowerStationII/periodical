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
@RequestMapping("/author")
public class AuthorController {
	
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
}
