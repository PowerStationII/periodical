package com.cn.periodical.controller;

import java.util.Random;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.cn.periodical.enums.RoleIdEnums;
import com.cn.periodical.enums.SystemIdEnums;
/**
 * 个人信息设置
 * 修改个人信息
 * 修改密码
 * */
@Controller
@RequestMapping("/setting")
public class PInfoSettingController {

	private static final Logger logger = LoggerFactory.getLogger(PInfoSettingController.class);

	/**
	 * 跳转到修改个人信息页面
	 */
	@RequestMapping(value = "/toUpdateSettingPage", method = RequestMethod.GET)
	public ModelAndView toUpdateSettingPage(@RequestParam("systemId") String systemId, HttpServletRequest request) {
		logger.info("登录系统systemId:[" + systemId + "]");
		ModelAndView mav = new ModelAndView("login");
		mav.addObject("systemId", systemId);
		return mav;
	}
	
	
	
	/**
	 * 跳转到修改密码页面
	 */
	@RequestMapping(value = "/toUpdatePWPage", method = RequestMethod.GET)
	public ModelAndView toUpdatePWPage(@RequestParam("systemId") String systemId, HttpServletRequest request) {
		logger.info("登录系统systemId:[" + systemId + "]");
		ModelAndView mav = new ModelAndView("login");
		mav.addObject("systemId", systemId);
		return mav;
	}

}
