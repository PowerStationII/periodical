package com.cn.periodical.controller.expert;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.cn.periodical.response.EditorArticleDealRespDto;
import com.cn.periodical.service.ExpertArticleAuditeService;

@Controller
public class ArticleAuditeController extends ExpertController{
	
	private static final Logger logger = LoggerFactory.getLogger(ArticleAuditeController.class);
	
	@Autowired
	ExpertArticleAuditeService articleAuditeService;
	
	/**
	 * toArticleAuditePage
	 * 去审稿页面
	 */
	@RequestMapping(value="/toArticleAuditePage",method = RequestMethod.GET)
	public ModelAndView toArticleAuditePage(@RequestParam("userId") String userId) {
		logger.info("审稿Page:["+userId+"]");
		ModelAndView mav = new ModelAndView("expert_articleAuditPage");
		mav.addObject("userId", userId);
		List<EditorArticleDealRespDto> articleDealRespDtos=articleAuditeService.qryArticleInfo("zhangsan");
		mav.addObject("list", articleDealRespDtos);
		
		
		return mav;
	}
}
