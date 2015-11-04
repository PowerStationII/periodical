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
 * 发行编辑-期刊邮寄Controller
 * */
@Controller
public class SubscribePostController extends EditorController{
	
	private static final Logger logger = LoggerFactory.getLogger(SubscribePostController.class);
	/**
	 * toSubscribePostPage
	 * 邮寄管理
	 */
	@RequestMapping(value="/toSubscribePostPage",method = RequestMethod.GET)
	public ModelAndView toSubscribePostPage(@RequestParam("userId") String userId,
			HttpServletRequest request) {
		logger.info("发行编辑-邮寄管理Page:["+userId+"]");
		ModelAndView mav = new ModelAndView("editor_subscribePostPage");
		mav.addObject("userId", userId);
		
		
		return mav;
	}
}
