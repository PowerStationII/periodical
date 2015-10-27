package com.cn.periodical.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {
	
	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);
	/**
	 * 跳转到登录页面
	 */
	@RequestMapping(value="/login",method = RequestMethod.GET)
	public String toUserInfoAdd() {
		return "login";
	}
	/**
	 * 登录
	 */
	@RequestMapping(value="/toLogin",method = RequestMethod.POST)
	public ModelAndView toLogin(@RequestParam("email") String email,@RequestParam("password") String password, 
			HttpServletRequest request) {
		logger.info("登录名["+email+"]&&登录密码["+password+"]");
		/**
		 * 根据用户名和密码查询用户角色
		 * 根据角色不同,跳转到不同工作区页面
		 * */
		ModelAndView mav = new ModelAndView("author_area");
		
		
		
		return mav;
	}
	
}
