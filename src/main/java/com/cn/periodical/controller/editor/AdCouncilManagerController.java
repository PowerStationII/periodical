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
 * 广告编辑-广告管理Controller
 * */
@Controller
public class AdCouncilManagerController extends EditorController{
	
	private static final Logger logger = LoggerFactory.getLogger(AdCouncilManagerController.class);
	/**
	 * toCouncilManagerPage
	 * 会员管理
	 */
	@RequestMapping(value="/toCouncilManagerPage",method = RequestMethod.GET)
	public ModelAndView toCouncilManagerPage(@RequestParam("userId") String userId,
			HttpServletRequest request) {
		logger.info("会员管理Page:["+userId+"]");
		ModelAndView mav = new ModelAndView("editor_councilManagerPage");
		mav.addObject("userId", userId);
		
		
		return mav;
	}
}
