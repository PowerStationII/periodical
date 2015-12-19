package com.cn.periodical.controller.editor;

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
import com.cn.periodical.manager.ArticleFlowsManager;
import com.cn.periodical.manager.ArticleInfoManager;
import com.cn.periodical.manager.ArticleQueryManager;
import com.cn.periodical.manager.ExpertInfoManager;
import com.cn.periodical.manager.SectionInfoManager;
import com.cn.periodical.manager.UserInfoManager;
import com.cn.periodical.manager.UserQueryManager;
import com.cn.periodical.pojo.ArticleInfo;
import com.cn.periodical.pojo.ArticleInfoQuery;
import com.cn.periodical.pojo.ExpertInfo;
import com.cn.periodical.pojo.ExpertInfoQuery;
import com.cn.periodical.pojo.SectionInfo;
import com.cn.periodical.pojo.SectionInfoQuery;
import com.cn.periodical.pojo.UserInfo;
import com.cn.periodical.pojo.UserInfoQuery;
import com.cn.periodical.request.AritcleWorkFlowReqDto;
import com.cn.periodical.request.ArticleQueryReqDto;
import com.cn.periodical.response.ArticleQueryRespDto;
import com.cn.periodical.service.ArticleQueryService;
import com.cn.periodical.service.ArticleWorkFlowService;
import com.cn.periodical.service.EditorArticleDealService;
/**
 * 稿件编辑-稿件处理Controller
 * */
@Controller
public class ArticlePublishDealController extends EditorController{
	
	private static final Logger logger = LoggerFactory.getLogger(ArticlePublishDealController.class);
	
	@Autowired
	EditorArticleDealService articleDealService;/**作废*/
	
	@Autowired
	ArticleQueryService articleQueryService;
	
	@Autowired
	ArticleWorkFlowService articleWorkFlowService;
	
	@Autowired
	ArticleQueryManager articleQueryManager;
	
	@Autowired
	ArticleInfoManager articleInfoManager;
	@Autowired
	SectionInfoManager sectionInfoManager;
	
	@Autowired
	ArticleFlowsManager articleFlowsManager;
	
	@Autowired
	UserInfoManager userInfoManager;
	@Autowired
	ExpertInfoManager expertInfoManager;
	
	@Autowired 
	UserQueryManager userQueryManager;

	/**
	 * toPublishArticlePage
	 * 待刊
	 */
	@RequestMapping(value="/toPublishArticlePage",method = RequestMethod.GET)
	public ModelAndView toPublishArticlePage(HttpServletRequest request) {
		logger.info("待刊Page in :[]");
		UserInfo userInfo = getUserInfo(request);
		ModelAndView mav = new ModelAndView("editor_publishArticlePage");
		ArticleQueryReqDto reqDto= new ArticleQueryReqDto();
		reqDto.setEditorState(ArticleStateEnums.END_ARTICLE.getCode());
		reqDto.setRoleId(userInfo.getRoleId());
		reqDto.setExpertState(ArticleStateEnums.PUBLISH_ARTICLE.getCode());
		List<ArticleQueryRespDto> list =articleQueryService.queryArticleInfos(reqDto);
		mav.addObject("list", list);
		logger.info("待刊Page out :["+JSON.toJSONString(list)+"]");
		return mav;
	}
	
	
	/**
	 * toPublishPage
	 * 待刊-Page
	 */
	@RequestMapping(value="/toPublishPage")
	public ModelAndView toPublishPage(@RequestParam("articleId") String articleId,HttpServletRequest request) {
		logger.info("待刊Page in :["+articleId+"]");
		ModelAndView mav = new ModelAndView("editor_artilce_publishPage");
		
		ArticleQueryReqDto reqDto= new ArticleQueryReqDto();
		reqDto.setArticleId(articleId);
		List<ArticleQueryRespDto> articleQueryRespDtos = articleQueryManager.editorDKMXPage(reqDto);
		
		
//		ArticleQueryReqDto reqDto= new ArticleQueryReqDto();
//		reqDto.setArticleId(articleId);
//		reqDto.setRoleId(RoleIdEnums.ARTICLE_EDITOR.getCode());/**编辑和专家共用一个稿件目录*/
//		ArticleQueryRespDto articleQueryRespDto =articleQueryService.queryArticleInfoDetail(reqDto);
		ArticleQueryRespDto articleQueryRespDto = articleQueryRespDtos.get(0);
		mav.addObject("respDto", articleQueryRespDto);
		
		String sectionId = articleQueryRespDto.getSection();
		SectionInfoQuery query = new SectionInfoQuery();
		query.setSectionId(sectionId);
		List<SectionInfo> sectionInfos = sectionInfoManager.queryList(query);
		mav.addObject("sectionInfo", sectionInfos.get(0));
		
		UserInfoQuery userInfoQuery = new UserInfoQuery();
		userInfoQuery.setUserId(articleQueryRespDto.getExpertId());
		List<UserInfo> userInfos = userInfoManager.queryList(userInfoQuery);
		UserInfo user = userInfos.get(0);

		ExpertInfoQuery expertInfoQuery = new ExpertInfoQuery();
		expertInfoQuery.setExpertId(user.getRefId());
		List<ExpertInfo> expertInfos = expertInfoManager.queryList(expertInfoQuery);
		mav.addObject("expertInfo", expertInfos.get(0));
		logger.info("待刊Page out :["+JSON.toJSONString(mav)+"]");
		return mav;
	}
	
	
	/**
	 * toPublishModify
	 * 待刊-Action
	 */
	@RequestMapping(value="/toPublishModify")
	public ModelAndView toPublishArticleDetailPage(@RequestParam("articleId") String articleId,
			HttpServletRequest request,@ModelAttribute AritcleWorkFlowReqDto aritcleWorkFlowReqDto) {
		logger.info("待刊Action in:articleId:["+articleId+"]&aritcleWorkFlowReqDto:["+JSON.toJSONString(aritcleWorkFlowReqDto)+"]");
		ModelAndView mav = new ModelAndView("redirect:../editor/toPublishArticlePage");

		ArticleInfoQuery query= new ArticleInfoQuery();
		query.setArticleId(articleId);
		List<ArticleInfo> articleInfos = articleInfoManager.queryList(query);
		ArticleInfo	articleInfo = articleInfos.get(0);
		
		/**
		 * 记录稿件开始处理流水
		 * refId谁把articleId稿件送给dtoResult.getUserId审
		 * */
		AritcleWorkFlowReqDto reqDto = new AritcleWorkFlowReqDto();
		reqDto.setUserId(getUserInfo(request).getUserId());
		reqDto.setArticleId(articleId);
		reqDto.setRoleId(RoleIdEnums.ARTICLE_EDITOR.getCode());
		reqDto.setDealState(ArticleStateEnums.PUBLISH_ARTICLE.getCode());
		reqDto.setToRoleId(RoleIdEnums.ARTICLE_EDITOR.getCode());
		reqDto.setDealOpinion(aritcleWorkFlowReqDto.getDealOpinion());
		reqDto.setDealStartTime(new Date());
		articleWorkFlowService.registArticleWorkFlow(reqDto);
		
		/**
		 * 变更稿件状态
		 * */
		articleInfo.setId(articleInfo.getId());
		articleInfo.setAuthorState(ArticleStateEnums.PUBLISH_ARTICLE.getCode());
		articleInfo.setEditorState(ArticleStateEnums.END_ARTICLE.getCode());
		articleInfoManager.saveArticleInfo(articleInfo);
		
		/**
		 * 向读者发送待刊确认邮件
		 * 
		 * ${作者名}，您好：
			您向${期刊名称}期刊投递的稿件${稿件名称}已被本刊采用.
			如不同意发表请点击不同意,否则视为同意发表!
			此致
			敬礼
			${编辑社名称}
			年月日
		 * */
		
		
		
		
		
		logger.info("待刊Action out:["+JSON.toJSONString(articleInfo)+"]");
		return mav;
	}
}
