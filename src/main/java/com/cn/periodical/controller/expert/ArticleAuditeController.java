package com.cn.periodical.controller.expert;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.cn.periodical.enums.ArticleStateEnums;
import com.cn.periodical.pojo.ArticleInfo;
import com.cn.periodical.pojo.UserInfo;
import com.cn.periodical.request.ArticleQueryReqDto;
import com.cn.periodical.response.ArticleQueryRespDto;
import com.cn.periodical.response.EditorArticleDealRespDto;
import com.cn.periodical.service.ArticleQueryService;
import com.cn.periodical.service.AuthorArticleQueryService;
import com.cn.periodical.service.EditorArticleDealService;
import com.cn.periodical.service.ExpertArticleAuditeService;

@Controller
public class ArticleAuditeController extends ExpertController{
	
	private static final Logger logger = LoggerFactory.getLogger(ArticleAuditeController.class);
	
	@Autowired
	ExpertArticleAuditeService articleAuditeService;
	
	@Autowired
	ArticleQueryService articleQueryService;
	
	@Autowired
	EditorArticleDealService articleDealService;
	
	/**
	 * toArticleAuditePage
	 * 去审稿页面
	 */
	@RequestMapping(value="/toArticleAuditePage")
	public ModelAndView toArticleAuditePage(HttpServletRequest request) {
		UserInfo userInfo = getUserInfo(request);
		logger.info("审稿Page:["+JSON.toJSONString(userInfo)+"]");
		ModelAndView mav = new ModelAndView("expert_articleAuditPage");
		ArticleQueryReqDto reqDto= new ArticleQueryReqDto();
		reqDto.setUserId(userInfo.getUserId());
		reqDto.setEditorState(ArticleStateEnums.SUBMITED_ARTICLE.getCode());
		List<ArticleQueryRespDto> list =articleQueryService.queryArticleInfos(reqDto);
		mav.addObject("list", list);
		return mav;
	}
	
	/**
	 * toArticleAuditeDetailPage
	 * 去审稿明细页面
	 */
	@RequestMapping(value="/toArticleAuditeDetailPage",method = RequestMethod.GET)
	public ModelAndView toArticleAuditeDetailPage(@RequestParam("artilceId") String artilceId) {
		logger.info("审稿明细Page:["+artilceId+"]");
//		ModelAndView mav = new ModelAndView("expertArticleAuditeDetailPage");
//		
//		ArticleInfo articleInfo = articleQueryService.queryArticleDetailInfo(artilceId);
//		mav.addObject("articleInfo", articleInfo);
//		logger.info("审稿明细出参:["+JSON.toJSONString(articleInfo)+"]");
//		return mav;
		return null;
	}
	
	
	/**
	 * toUpdateArticleState
	 * 
	 * 稿件状态变更为待刊
	 */
	@RequestMapping(value="/toExpertUpdateState",method = RequestMethod.POST)
	public ModelAndView toUpdateArticleState(@RequestParam("userId") String userId,
			@ModelAttribute ArticleInfo articleInfo,
			HttpServletRequest request) {
		logger.info("待刊稿件状态入参:["+userId+"]&artilceId:["+JSON.toJSONString(articleInfo)+"]");
		ModelAndView mav = new ModelAndView("redirect:/expert/toArticleAuditePage");
		mav.addObject("userId", userId);
		/**
		 * 变更状态的时候要记录流水哦!
		 * */
		int i =articleDealService.updateArticleInfo("",userId,articleInfo, ArticleStateEnums.PUBLISH_ARTICLE.getCode());

		logger.info("待刊稿件状态出参:[]");
		return mav;
	}
	
	
}
