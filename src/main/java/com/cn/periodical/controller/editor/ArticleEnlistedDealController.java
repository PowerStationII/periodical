package com.cn.periodical.controller.editor;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
import com.cn.periodical.response.EditorArticleDealRespDto;
import com.cn.periodical.service.ArticleQueryService;
import com.cn.periodical.service.ArticleWorkFlowService;
import com.cn.periodical.service.EditorArticleDealService;
/**
 * 稿件编辑-稿件处理Controller
 * */
@Controller
public class ArticleEnlistedDealController extends EditorController{
	
	private static final Logger logger = LoggerFactory.getLogger(ArticleEnlistedDealController.class);
	
	@Autowired
	EditorArticleDealService articleDealService;/**作废*/
	
	@Autowired
	ArticleQueryService articleQueryService;
	
	@Autowired
	ArticleWorkFlowService articleWorkFlowService;
	
	@Autowired
	ArticleInfoManager articleInfoManager;
	
	@Autowired
	ArticleFlowsManager articleFlowsManager;
	
	@Autowired
	UserInfoManager userInfoManager;
	
	@Autowired 
	UserQueryManager userQueryManager;
	
	/**
	 * toEnlistedArticlePage
	 * 已登记 End
	 */
	@RequestMapping(value="/toEnlistedArticlePage",method = RequestMethod.GET)
	public ModelAndView toEnlistedArticlePage(HttpServletRequest request) {
		UserInfo userInfo = getUserInfo(request);
		logger.info("已登记Page入参:["+JSON.toJSONString(userInfo)+"]");
		ModelAndView mav = new ModelAndView("editor_enlistedArticlePage");
		ArticleQueryReqDto reqDto= new ArticleQueryReqDto();
		reqDto.setEditorState(ArticleStateEnums.ENLISTED_ARTICLE.getCode());
		List<ArticleQueryRespDto> list =articleQueryService.queryArticleInfos(reqDto);
		mav.addObject("list", list);
		logger.info("已登记Page出参:["+JSON.toJSONString(list)+"]");
		return mav;
		
	}
	
	/**
	 * toEnlistedArticleDetailPage
	 * 已登记-详情页 End
	 */
	@RequestMapping(value="/toEnlistedArticleDetailPage")
	public ModelAndView toEnlistedArticleDetailPage(@RequestParam("artilceId") String artilceId,
			HttpServletRequest request) {
		logger.info("已登记稿件详情页Page入参:artilceId:["+artilceId+"]");
		ModelAndView mav = new ModelAndView("editor_enlistedArticleDetailPage");
		ArticleQueryReqDto reqDto= new ArticleQueryReqDto();
		reqDto.setArticleId(artilceId);
		reqDto.setRoleId(RoleIdEnums.AUTHOR.getCode());/**编辑下载作者的稿件*/
		ArticleQueryRespDto articleQueryRespDto =articleQueryService.queryArticleInfoDetail(reqDto);
		mav.addObject("respDto", articleQueryRespDto);
		logger.info("已登记稿件详情页Page出参:["+JSON.toJSONString(articleQueryRespDto)+"]");
		return mav;
	}
	
	/**
	 * toSubmitPage
	 * 登记
	 * 稿件状态变更 End
	 */
	@RequestMapping(value="/toSubmitPage",method = RequestMethod.GET)
	public ModelAndView toSubmitPage(@RequestParam("articleId") String articleId,
			HttpServletRequest request) {
		logger.info("送审Page入参:artilceId:["+articleId+"]");
		ModelAndView mav = new ModelAndView("editor_artilce_submitedPage");
		ArticleQueryReqDto reqDto= new ArticleQueryReqDto();
		reqDto.setArticleId(articleId);
		reqDto.setRoleId(RoleIdEnums.AUTHOR.getCode());/**编辑下载作者的稿件*/
		ArticleQueryRespDto articleQueryRespDto =articleQueryService.queryArticleInfoDetail(reqDto);
		mav.addObject("respDto", articleQueryRespDto);
		logger.info("送审Page出参:["+JSON.toJSONString(articleQueryRespDto)+"]");
		return mav;
	}
	
	/**
	 * toSubmitState
	 *  
	 * 稿件状态变更 End
	 */
	@RequestMapping(value="/toSubmitState",method = RequestMethod.POST)
	public ModelAndView toSubmitState(@RequestParam("articleId") String articleId,String expertId,
			HttpServletRequest request) {
		logger.info("修改稿件送审入参:artilceId:["+articleId+"]&expertId:["+expertId+"]");
		ModelAndView mav = new ModelAndView("redirect:../editor/toEnlistedArticlePage");
		/**
		 * 编辑送审给哪个专家
		 * */
		UserQueryReqDto dto = new UserQueryReqDto();
		dto.setRoleId(RoleIdEnums.CN_EXPERT.getCode());
		dto.setRefId(expertId);
		dto.setSystemId(SystemIdEnums.EXPERT_SYS.getCode());
		logger.info("为毛多一个参数!!!!!"+JSON.toJSONString(dto));
		UserQueryReqDto dtoResult = userQueryManager.queryUserRef(dto);
		
		/**
		 * 记录稿件开始处理流水
		 * refId谁把articleId稿件送给dtoResult.getUserId审
		 * */
		AritcleWorkFlowReqDto reqDto = new AritcleWorkFlowReqDto();
		reqDto.setUserId(dtoResult.getUserId());
		reqDto.setArticleId(articleId);
		reqDto.setRoleId(RoleIdEnums.ARTICLE_EDITOR.getCode());
		reqDto.setDealState(ArticleStateEnums.SUBMITED_ARTICLE.getCode());
		reqDto.setToRoleId(RoleIdEnums.CN_EXPERT.getCode());
		reqDto.setDealStartTime(new Date());
		reqDto.setRefId(getUserInfo(request).getUserId());
		articleWorkFlowService.registArticleWorkFlow(reqDto);
		
		/**
		 * 变更稿件状态
		 * */
		ArticleInfoQuery query= new ArticleInfoQuery();
		query.setArticleId(articleId);
		List<ArticleInfo> articleInfos = articleInfoManager.queryList(query);
		ArticleInfo	articleInfo = articleInfos.get(0);
		articleInfo.setId(articleInfo.getId());
		articleInfo.setAuthorState(ArticleStateEnums.SUBMITED_ARTICLE.getCode());
		articleInfo.setEditorState(ArticleStateEnums.SUBMITED_ARTICLE.getCode());
		articleInfo.setExpertState(ArticleStateEnums.SUBMITED_ARTICLE.getCode());
		articleInfoManager.saveArticleInfo(articleInfo);
		
		logger.info("修改稿件状态出参:[]");
		return mav;
	}
}
