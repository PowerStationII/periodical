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
	public ModelAndView login(@RequestParam("systemId") String systemId,
			HttpServletRequest request) {
		logger.info("登录系统systemId:["+systemId+"]");
		ModelAndView mav = new ModelAndView("login");
		mav.addObject("systemId", systemId);
		return mav;
	}
	/**
	 * 登录
	 */
	@RequestMapping(value="/toLogin",method = RequestMethod.POST)
	public ModelAndView toLogin(@RequestParam("email") String email,@RequestParam("password") String password, 
			HttpServletRequest request) {
		logger.info("登录名["+email+"]&&登录密码["+password+"]");
		ModelAndView mav =null;
		String systemId = request.getParameter("systemId");
		/**
		 * 1,验证用户名是否存在[USER_INFO]
		 * 2,验证用户密码是否正确
		 * 3,判断传入systemId与用户的systemId是否相等
		 * 4,根据role_id跳转不同的vm页面
		 * ps:待优化,页面左侧功能列表先写死.会多写等同于角色数量的vm页面!
		 * */
		if("111".equals(systemId)){
			//编辑
//			if("".equals(anObject)){
//				
//			}else if(){
//				
//			}else{
//				
//			}
		}else if("222".equals(systemId)){
			//专家
//			if(){
//				
//			}else if(){
//				
//			}else{
//				
//			}
		}else if("333".equals(systemId)){
			//作者
			mav = new ModelAndView("author_area");
		}else if("444".equals(systemId)){
			//读者
			
		}else{
			
		}
		return mav;
	}
}
