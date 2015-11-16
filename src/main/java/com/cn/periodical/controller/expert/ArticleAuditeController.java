package com.cn.periodical.controller.expert;

import java.util.Date;
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
import com.cn.periodical.enums.RoleIdEnums;
import com.cn.periodical.enums.SystemIdEnums;
import com.cn.periodical.manager.ArticleFlowsManager;
import com.cn.periodical.manager.ArticleInfoManager;
import com.cn.periodical.manager.UserInfoManager;
import com.cn.periodical.manager.UserQueryManager;
import com.cn.periodical.pojo.ArticleFlows;
import com.cn.periodical.pojo.ArticleFlowsQuery;
import com.cn.periodical.pojo.ArticleInfo;
import com.cn.periodical.pojo.ArticleInfoQuery;
import com.cn.periodical.pojo.UserInfo;
import com.cn.periodical.request.AritcleWorkFlowReqDto;
import com.cn.periodical.request.ArticleQueryReqDto;
import com.cn.periodical.request.UserQueryReqDto;
import com.cn.periodical.response.ArticleQueryRespDto;
import com.cn.periodical.service.ArticleQueryService;
import com.cn.periodical.service.ArticleWorkFlowService;
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
	
	@Autowired
	UserInfoManager userInfoManager;
	
	@Autowired 
	UserQueryManager userQueryManager;
	
	@Autowired
	ArticleWorkFlowService articleWorkFlowService;
	
	@Autowired
	ArticleInfoManager articleInfoManager;
	
	@Autowired
	ArticleFlowsManager articleFlowsManager;
	
	/**
	 * toArticleAuditePage
	 * 去审稿页面
	 */
	@RequestMapping(value="/toArticleAuditePage")
	public ModelAndView toArticleAuditePage(HttpServletRequest request,@ModelAttribute ArticleQueryReqDto reqDto) {
		UserInfo userInfo = getUserInfo(request);
		logger.info("审稿Page:["+JSON.toJSONString(reqDto)+"]");
		ModelAndView mav = new ModelAndView("expert_articleAuditPage");
		reqDto.setUserId(userInfo.getUserId());
		List<ArticleQueryRespDto> list =articleQueryService.queryArticleInfos(reqDto);
		mav.addObject("list", list);
		return mav;
	}
	
	/**
	 * toAuditeDetailPage
	 * 去审稿明细页面
	 */
	@RequestMapping(value="/toAuditeDetailPage")
	public ModelAndView toArticleAuditeDetailPage(@RequestParam("articleId") String articleId) {
		logger.info("审稿明细Page:["+articleId+"]");
		ModelAndView mav = new ModelAndView("expertArticleAuditeDetailPage");
		ArticleQueryReqDto reqDto= new ArticleQueryReqDto();
		reqDto.setArticleId(articleId);
		reqDto.setRoleId(RoleIdEnums.ARTICLE_EDITOR.getCode());/**专家下载编辑的稿件*/
		ArticleQueryRespDto articleQueryRespDto =articleQueryService.queryArticleInfoDetail(reqDto);
		mav.addObject("respDto", articleQueryRespDto);
		logger.info("审稿明细出参:["+JSON.toJSONString(articleQueryRespDto)+"]");
		return mav;
	}
	
	/**
	 * toExpertUpdateState
	 * 稿件状态变更为待刊
	 */
	@RequestMapping(value="/toPublishStateModify")
	public ModelAndView toPublishStateModify(@RequestParam("articleId") String articleId,
			HttpServletRequest request) {
		logger.info("待刊稿件状态入参:artilceId:["+articleId+"]");
		ModelAndView mav = new ModelAndView("redirect:/expert/toArticleAuditePage");
		
		/**
		 * 变更稿件状态
		 * */
		ArticleInfoQuery query= new ArticleInfoQuery();
		query.setArticleId(articleId);
		List<ArticleInfo> articleInfos = articleInfoManager.queryList(query);
		ArticleInfo	articleInfo = articleInfos.get(0);
		articleInfo.setId(articleInfo.getId());
		articleInfo.setAuthorState(ArticleStateEnums.SUBMITED_ARTICLE.getCode());
		articleInfo.setEditorState(ArticleStateEnums.PUBLISH_ARTICLE.getCode());
		articleInfo.setExpertState(ArticleStateEnums.PUBLISH_ARTICLE.getCode());
		articleInfoManager.saveArticleInfo(articleInfo);
		
		/**
		 * 查询稿件的当前流水
		 * */
		ArticleFlowsQuery queryFlows = new ArticleFlowsQuery();
		queryFlows.setArticleId(articleId);
		queryFlows.setUserId(getUserInfo(request).getUserId());
		queryFlows.setRoleId(getUserInfo(request).getRoleId());
		queryFlows.setId(articleInfo.getLatelyFlowsId());
		ArticleFlows articleFlows = articleFlowsManager.queryFlowsDetail(queryFlows);
		
		/**
		 * 记录稿件开始处理流水
		 * refId谁把articleId稿件送给dtoResult.getUserId审
		 * */
		AritcleWorkFlowReqDto reqDto = new AritcleWorkFlowReqDto();
		reqDto.setUserId(articleFlows.getRefId());
		reqDto.setArticleId(articleId);
		reqDto.setRefId(getUserInfo(request).getUserId());
		reqDto.setRoleId(articleFlows.getRoleId());
		reqDto.setDealStartTime(new Date());
		reqDto.setRefId(getUserInfo(request).getUserId());
		articleWorkFlowService.registArticleWorkFlow(reqDto);
		
		logger.info("待刊稿件状态出参:[]");
		return mav;
	}
	
	
	/**
	 * toExpertRepairedPage
	 * 去专家返修页面
	 */
	@RequestMapping(value="/toExpertRepairedPage")
	public ModelAndView toExpertRepairedPage(@RequestParam("articleId") String articleId,
			@ModelAttribute AritcleWorkFlowReqDto aritcleWorkFlowReqDto) {
		logger.info("专家返修Page:["+articleId+"]");
		ModelAndView mav = new ModelAndView("expert_artilce_repairedPage");
		
		ArticleQueryReqDto reqDto= new ArticleQueryReqDto();
		reqDto.setArticleId(articleId);
		reqDto.setRoleId(RoleIdEnums.ARTICLE_EDITOR.getCode());
		ArticleQueryRespDto articleQueryRespDto =articleQueryService.queryArticleInfoDetail(reqDto);
		mav.addObject("respDto", articleQueryRespDto);
		logger.info("专家返修Page:["+JSON.toJSONString(articleQueryRespDto)+"]");
		return mav;
	}
	
	
	/**
	 * toExpertRepairedModify
	 * 专家返修
	 */
	@RequestMapping(value="/toExpertRepairedModify")
	public ModelAndView toExpertRepairedModify(@RequestParam("articleId") String articleId,
			@ModelAttribute AritcleWorkFlowReqDto aritcleWorkFlowReqDto) {
		logger.info("专家返修Action:["+articleId+"]&aritcleWorkFlowReqDto:["+JSON.toJSONString(aritcleWorkFlowReqDto)+"]");
		ModelAndView mav = new ModelAndView("redirect:/expert/toArticleAuditePage");
		
		/**
		 * 记录稿件处理流水
		 * */
		
		
//		ArticleQueryReqDto reqDto= new ArticleQueryReqDto();
//		reqDto.setArticleId(articleId);
//		reqDto.setRoleId(RoleIdEnums.ARTICLE_EDITOR.getCode());
//		ArticleQueryRespDto articleQueryRespDto =articleQueryService.queryArticleInfoDetail(reqDto);
//		mav.addObject("respDto", articleQueryRespDto);
		
		
		
		
		
		
//		logger.info("专家返修Action:["+JSON.toJSONString(articleQueryRespDto)+"]");
		return mav;
	}
	

	
	
	
	
	
	/**
	 * toExpertRefundPage
	 * 去专家退稿页面
	 */
	@RequestMapping(value="/toExpertRefundPage")
	public ModelAndView toExpertRefundPage(@RequestParam("articleId") String articleId,
			@ModelAttribute AritcleWorkFlowReqDto aritcleWorkFlowReqDto) {
		logger.info("专家返修Page:["+articleId+"]");
		ModelAndView mav = new ModelAndView("expert_artilce_repairedPage");
		
		ArticleQueryReqDto reqDto= new ArticleQueryReqDto();
		reqDto.setArticleId(articleId);
		reqDto.setRoleId(RoleIdEnums.ARTICLE_EDITOR.getCode());
		ArticleQueryRespDto articleQueryRespDto =articleQueryService.queryArticleInfoDetail(reqDto);
		mav.addObject("respDto", articleQueryRespDto);
		logger.info("专家返修Page:["+JSON.toJSONString(articleQueryRespDto)+"]");
		return mav;
	}
	
	
}
