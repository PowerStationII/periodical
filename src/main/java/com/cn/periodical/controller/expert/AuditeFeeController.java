package com.cn.periodical.controller.expert;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AuditeFeeController extends ExpertController{
	
	private static final Logger logger = LoggerFactory.getLogger(AuditeFeeController.class);
	/**
	 * toArticleAuditePage
	 * 去审稿费查询页面
	 */
	@RequestMapping(value="/toAuditeFeePage",method = RequestMethod.GET)
	public ModelAndView toAuditeFeePage(@RequestParam("userId") String userId,
			HttpServletRequest request) {
		logger.info("稿费查询Page:["+userId+"]");
		ModelAndView mav = new ModelAndView("expert_auditeFeePage");
		mav.addObject("userId", userId);
		
		
		return mav;
	}
}
