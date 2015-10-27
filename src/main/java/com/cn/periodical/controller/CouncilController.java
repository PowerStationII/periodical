package com.cn.periodical.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/council")
public class CouncilController {
	
	private static final Logger logger = LoggerFactory.getLogger(CouncilController.class);
	/**
	 * 理事图片
	 */
	@RequestMapping(value="/toCouncilPic",method = RequestMethod.GET)
	public String toUserInfoAdd() {
		/**
		 * 查询理事会信息
		 * 制作理事会信息图片
		 * */
		
		
		return "login";
	}
	/**
	 * 登录
	 */
	@RequestMapping(value="/toLogin",method = RequestMethod.POST)
	public String toLogin() {
		/**
		 * 根据用户名和密码查询用户角色
		 * 根据角色不同,跳转到不同工作区页面
		 * */
		
		
		
		
		
		
		
		return "login";
	}
	
}
