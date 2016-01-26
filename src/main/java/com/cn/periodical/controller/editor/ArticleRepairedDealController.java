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
import com.cn.periodical.response.EditorArticleDealRespDto;
import com.cn.periodical.service.ArticleQueryService;
import com.cn.periodical.service.ArticleWorkFlowService;
import com.cn.periodical.service.EditorArticleDealService;
/**
 * 稿件编辑-稿件处理Controller
 * */
@Controller
public class ArticleRepairedDealController extends EditorController{
	
	private static final Logger logger = LoggerFactory.getLogger(ArticleRepairedDealController.class);
	
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
	 * toRepairedArticlePage
	 * 退稿
	 */
	@RequestMapping(value="/toRepaireArticlePage",method = RequestMethod.GET)
	public ModelAndView toRepairedArticlePage(HttpServletRequest request) {
		logger.info("返修PageList in:[]");
		UserInfo userInfo = getUserInfo(request);
		ModelAndView mav = new ModelAndView("editor_repaireArticlePage");
		ArticleQueryReqDto reqDto= new ArticleQueryReqDto();
		reqDto.setEditorState(ArticleStateEnums.END_ARTICLE.getCode());
		reqDto.setExpertState(ArticleStateEnums.REPAIR_ARTICLE.getCode());
		reqDto.setRoleId(userInfo.getRoleId());
		List<ArticleQueryRespDto> list =articleQueryService.queryArticleInfos(reqDto);
		mav.addObject("list", list);
		logger.info("返修PageList out:["+JSON.toJSONString(list)+"]");
		return mav;
	}
	
	/**
	 * toRepairedPage
	 * 返修-Page
	 */
	@RequestMapping(value="/toRepairePage")
	public ModelAndView toRepairedPage(@RequestParam("articleId") String articleId,String flag ,HttpServletRequest request) {
		logger.info("返修Page in :["+articleId+"]");
		ModelAndView mav = new ModelAndView("editor_artilce_repairedPage");
		
		ArticleQueryReqDto reqDto= new ArticleQueryReqDto();
		reqDto.setArticleId(articleId);
        if("gaoJian".equals(flag)){
            reqDto.setRoleId(RoleIdEnums.AUTHOR.getCode());
        }else{
            reqDto.setRoleId(RoleIdEnums.ARTICLE_EDITOR.getCode());/**编辑和专家共用一个稿件目录*/
        }
		ArticleQueryRespDto articleQueryRespDto =articleQueryService.queryArticleInfoDetail(reqDto);
		mav.addObject("respDto", articleQueryRespDto);
		
		logger.info("返修Page out :["+JSON.toJSONString(articleQueryRespDto)+"]");
		return mav;
	}
	
	
	/**
	 * toRepairedModify
	 * 返修-Action
	 */
	@RequestMapping(value="/toRepaireModify")
	public ModelAndView toPublishArticleDetailPage(@RequestParam("articleId") String articleId,
			HttpServletRequest request,@ModelAttribute AritcleWorkFlowReqDto aritcleWorkFlowReqDto) {
		logger.info("返修Action in:articleId:["+articleId+"]&aritcleWorkFlowReqDto:["+JSON.toJSONString(aritcleWorkFlowReqDto)+"]");
		ModelAndView mav = new ModelAndView("redirect:../editor/toRepaireArticlePage");

		ArticleInfoQuery query= new ArticleInfoQuery();
		query.setArticleId(articleId);
		List<ArticleInfo> articleInfos = articleInfoManager.queryList(query);
		ArticleInfo	articleInfo = articleInfos.get(0);
		
		/**
		 * 记录稿件开始处理流水
		 * refId谁把articleId稿件送给dtoResult.getUserId审
		 * userId对articleId稿件做了dealState/dealOpinion什么
		 * */
		AritcleWorkFlowReqDto reqDto = new AritcleWorkFlowReqDto();
		reqDto.setUserId(getUserInfo(request).getUserId());
		reqDto.setArticleId(articleId);
		reqDto.setRoleId(RoleIdEnums.ARTICLE_EDITOR.getCode());
		reqDto.setDealState(ArticleStateEnums.REPAIR_ARTICLE.getCode());
		reqDto.setToRoleId(RoleIdEnums.ARTICLE_EDITOR.getCode());
		reqDto.setDealOpinion(aritcleWorkFlowReqDto.getDealOpinion());
		reqDto.setDealStartTime(new Date());
		articleWorkFlowService.registArticleWorkFlow(reqDto);
		
		/**
		 * 变更稿件状态
		 * */
		articleInfo.setId(articleInfo.getId());
		articleInfo.setAuthorState(ArticleStateEnums.REPAIR_ARTICLE.getCode());
		articleInfo.setEditorState(ArticleStateEnums.REPAIR_ARTICLE.getCode());
		articleInfoManager.saveArticleInfo(articleInfo);
		
		logger.info("返修Action out:["+JSON.toJSONString(articleInfo)+"]");
		return mav;
	}
}
