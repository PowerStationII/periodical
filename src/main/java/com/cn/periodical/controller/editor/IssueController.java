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
 * 签发人-签发管理Controller
 * */
@Controller
public class IssueController extends EditorController{
	
	private static final Logger logger = LoggerFactory.getLogger(IssueController.class);
	/**
	 * toIssueManagerPage
	 * 签发管理
	 */
	@RequestMapping(value="/toIssueManagerPage",method = RequestMethod.GET)
	public ModelAndView toIssueManagerPage(@RequestParam("userId") String userId,
			HttpServletRequest request) {
		logger.info("签发管理Page:["+userId+"]");
		ModelAndView mav = new ModelAndView("editor_issueManagerPage");
		mav.addObject("userId", userId);
		
		
		return mav;
	}
}
