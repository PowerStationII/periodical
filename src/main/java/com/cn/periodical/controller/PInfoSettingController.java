package com.cn.periodical.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.cn.periodical.enums.SystemIdEnums;
import com.cn.periodical.pojo.AuthorInfo;
import com.cn.periodical.pojo.UserInfo;
import com.cn.periodical.service.PInfoSettingService;
/**
 * 个人信息设置
 * 修改个人信息
 * 修改密码
 * */
@Controller
@RequestMapping("/setting")
public class PInfoSettingController {

	private static final Logger logger = LoggerFactory.getLogger(PInfoSettingController.class);

	@Autowired
	PInfoSettingService pInfoSettingService;
	/**
	 * 跳转到修改个人信息页面
	 */
	@RequestMapping(value = "/toUpdateSettingPage", method = RequestMethod.GET)
	public ModelAndView toUpdateSettingPage(@RequestParam("userId") String userId,
			@RequestParam(required =true,value="roleId") String roleId) {
		logger.info("userId:[" + userId + "]修改个人信息");
		ModelAndView mav = new ModelAndView("updateSettingPage");
		mav.addObject("userId", userId);
		Object obj =pInfoSettingService.queryObject(userId);
		if(SystemIdEnums.AUTHOR_SYS.getCode().equals("333")){
			AuthorInfo authorInfo = (AuthorInfo)obj;
			mav.addObject("authorInfo", authorInfo);
		}
		
		
		return mav;
	}
	
	/**
	 * 修改个人信息
	 */
	@RequestMapping(value = "/toUpdateSetting", method = RequestMethod.GET)
	public ModelAndView toUpdateSettingPage(@RequestParam("userId") String userId, @ModelAttribute AuthorInfo authorInfo) {
		logger.info("userId:[" + userId + "]修改个人信息");
		ModelAndView mav = new ModelAndView("updateSettingPage");
		mav.addObject("userId", userId);
		pInfoSettingService.updateSetting(userId, "", authorInfo);
		return mav;
	}
	
	
	/**
	 * 跳转到修改密码页面
	 */
	@RequestMapping(value = "/toUpdatePWPage", method = RequestMethod.GET)
	public ModelAndView toUpdatePWPage(@RequestParam(required =true,value="userId") String userId) {
		logger.info("userId:[" + userId + "]要重置密码");
		ModelAndView mav = new ModelAndView("updatePWPage");
		UserInfo userInfo=pInfoSettingService.queryUserInfo(userId);
		mav.addObject("userInfo", userInfo);
		return mav;
	}
	
	
	/**
	 * 修改密码
	 */
	@RequestMapping(value = "/toUpdatePw", method = RequestMethod.POST)
	public ModelAndView toUpdatePw(@RequestParam("userId") String userId, 
			@RequestParam("id") String id,
			@RequestParam("newPw") String newPw,
			RedirectAttributes redirectAttributes) {
		ModelAndView mav = new ModelAndView("updatePWPage");
		mav.addObject("userId", userId);
		int i = pInfoSettingService.updatePw(id,newPw);
		return mav;
	}

}
