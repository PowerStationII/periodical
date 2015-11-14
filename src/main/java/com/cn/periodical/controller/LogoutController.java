package com.cn.periodical.controller;

import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LogoutController {
	/**
	 * 退出系统跳转到首页
	 */
	@RequestMapping(value="/logout",method = RequestMethod.GET)
	public String logout(HttpServletRequest request) {
		return "portal";
	}
}
