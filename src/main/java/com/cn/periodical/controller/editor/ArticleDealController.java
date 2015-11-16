package com.cn.periodical.controller.editor;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
import com.cn.periodical.pojo.ArticleInfo;
import com.cn.periodical.pojo.UserInfo;
import com.cn.periodical.request.ArticleQueryReqDto;
import com.cn.periodical.response.ArticleQueryRespDto;
import com.cn.periodical.response.EditorArticleDealRespDto;
import com.cn.periodical.service.ArticleQueryService;
import com.cn.periodical.service.EditorArticleDealService;
/**
 * 稿件编辑-稿件处理Controller
 * */
@Controller
public class ArticleDealController extends EditorController{
	
	private static final Logger logger = LoggerFactory.getLogger(ArticleDealController.class);
	
	@Autowired
	EditorArticleDealService articleDealService;/**作废*/
	
	@Autowired
	ArticleQueryService articleQueryService;
	
	/**
	 * toNewArticlePage
	 * 新稿
	 */
	@RequestMapping(value="/toNewArticlePage")
	public ModelAndView toNewArticlePage(HttpServletRequest request,HttpServletResponse response) {
		UserInfo userInfo = (UserInfo)request.getSession().getAttribute("userInfo");
		logger.info("新稿Page入参:["+JSON.toJSONString(userInfo)+"]");
		ModelAndView mav = new ModelAndView("editor_newArticlePage");
		ArticleQueryReqDto reqDto= new ArticleQueryReqDto();
		reqDto.setEditorState(ArticleStateEnums.NEW_ARTICLE.getCode());
		List<ArticleQueryRespDto> list =articleQueryService.queryArticleInfos(reqDto);
		mav.addObject("list", list);
		logger.info("新稿Page出参:["+JSON.toJSONString(list)+"]");
		return mav;
	}
	
	/**
	 * toNewArticleDetailPage
	 * 新稿-详情页
	 */
	@RequestMapping(value="/toNewArticleDetailPage",method = RequestMethod.GET)
	public ModelAndView toNewArticleDetailPage(@RequestParam("artilceId") String artilceId,
			HttpServletRequest request) {
		logger.info("新稿详情页Page入参:artilceId:["+artilceId+"]");
		ModelAndView mav = new ModelAndView("editor_newArticleDetailPage");
		ArticleQueryReqDto reqDto= new ArticleQueryReqDto();
		reqDto.setArticleId(artilceId);
		reqDto.setRoleId(RoleIdEnums.AUTHOR.getCode());
		ArticleQueryRespDto articleQueryRespDto =articleQueryService.queryArticleInfoDetail(reqDto);
		mav.addObject("respDto", articleQueryRespDto);
		logger.info("新稿详情页Page出参:["+JSON.toJSONString(articleQueryRespDto)+"]");
		return mav;
	}
	
	/**
	 * toEditorUpdateStatePage
	 * 登记
	 * 稿件状态变更
	 */
	@RequestMapping(value="/toEnlistedPage",method = RequestMethod.GET)
	public ModelAndView toEditorUpdateStatePage(@RequestParam("userId") String userId,
			@RequestParam("articleId") String articleId,
			HttpServletRequest request) {
		logger.info("修改稿件状态Page入参:["+userId+"]&artilceId:["+articleId+"]");
		ModelAndView mav = new ModelAndView("editor_artilce_enlistedPage");
		mav.addObject("userId", userId);
		ArticleInfo articleInfo =articleDealService.qryArticleInfo(articleId);
		mav.addObject("articleInfo", articleInfo);
		logger.info("修改稿件状态Page出参:[]");
		return mav;
	}
	
	/**
	 * toUpdateArticleState
	 * 
	 * 稿件状态变更为已登记
	 */
	@RequestMapping(value="/toEditorUpdateState",method = RequestMethod.POST)
	public ModelAndView toUpdateArticleState(@RequestParam("userId") String userId,
			@ModelAttribute ArticleInfo articleInfo,
			HttpServletRequest request) {
		logger.info("修改稿件状态入参:["+userId+"]&artilceId:["+JSON.toJSONString(articleInfo)+"]");
		ModelAndView mav = new ModelAndView("redirect:/editor/toEnlistedArticlePage");
		mav.addObject("userId", userId);
		/**
		 * 变更状态的时候要记录流水哦!
		 * */
		int i =articleDealService.updateArticleInfo("",userId,articleInfo, ArticleStateEnums.SUBMITED_ARTICLE.getCode());

		logger.info("修改稿件状态出参:[]");
		return mav;
	}
	
	/**
	 * toEnlistedArticlePage
	 * 已登记
	 */
	@RequestMapping(value="/toEnlistedArticlePage",method = RequestMethod.GET)
	public ModelAndView toEnlistedArticlePage(@RequestParam("userId") String userId,
			HttpServletRequest request) {
		logger.info("已登记Page:["+userId+"]");
		ModelAndView mav = new ModelAndView("editor_enlistedArticlePage");
		mav.addObject("userId", userId);
		List<EditorArticleDealRespDto> list =articleDealService.articleDeal(ArticleStateEnums.SUBMITED_ARTICLE.getCode());
		mav.addObject("list", list);
		
		return mav;
	}
	
	/**
	 * toEnlistedArticleDetailPage
	 * 已登记-详情页
	 */
	@RequestMapping(value="/toEnlistedArticleDetailPage",method = RequestMethod.GET)
	public ModelAndView toEnlistedArticleDetailPage(@RequestParam("userId") String userId,
			@RequestParam("artilceId") String artilceId,
			HttpServletRequest request) {
		logger.info("已登记稿件详情页Page入参:["+userId+"]&artilceId:["+artilceId+"]");
		ModelAndView mav = new ModelAndView("editor_enlistedArticleDetailPage");
		mav.addObject("userId", userId);
		
		ArticleInfo articleInfo =articleDealService.qryArticleInfo(artilceId);
		mav.addObject("articleInfo", articleInfo);
		
		logger.info("已登记稿件详情页Page出参:["+JSON.toJSONString(articleInfo)+"]");
		return mav;
	}
	
	/**
	 * toSubmitPage
	 * 登记
	 * 稿件状态变更
	 */
	@RequestMapping(value="/toSubmitPage",method = RequestMethod.GET)
	public ModelAndView toSubmitPage(@RequestParam("userId") String userId,
			@RequestParam("articleId") String articleId,
			HttpServletRequest request) {
		logger.info("送审Page入参:["+userId+"]&artilceId:["+articleId+"]");
		ModelAndView mav = new ModelAndView("editor_artilce_submitedPage");
		mav.addObject("userId", userId);
		ArticleInfo articleInfo =articleDealService.qryArticleInfo(articleId);
		mav.addObject("articleInfo", articleInfo);
		logger.info("送审Page出参:[]");
		return mav;
	}
	
	/**
	 * toSubmitState
	 * 
	 * 稿件状态变更
	 */
	@RequestMapping(value="/toSubmitState",method = RequestMethod.POST)
	public ModelAndView toSubmitState(@RequestParam("userId") String userId,
			@ModelAttribute ArticleInfo articleInfo,String expertId,
			HttpServletRequest request) {
		logger.info("修改稿件送审入参:["+userId+"]&artilceId:["+JSON.toJSONString(articleInfo)+"]&expertId:["+expertId+"]");
		ModelAndView mav = new ModelAndView("editor_artilce_submitedPage");
		mav.addObject("userId", userId);
		/**
		 * 变更状态的时候要记录流水哦!
		 * 要记录给哪个专家了
		 * */
		int i =articleDealService.updateArticleInfo(expertId,userId,articleInfo, ArticleStateEnums.ENLISTED_ARTICLE.getCode());

		logger.info("修改稿件状态出参:[]");
		return mav;
	}
	
	/**
	 * toRepairArticlePage
	 * 返修
	 */
	@RequestMapping(value="/toRepairArticlePage",method = RequestMethod.GET)
	public ModelAndView toRepairArticlePage(@RequestParam("userId") String userId,
			HttpServletRequest request) {
		logger.info("返修Page:["+userId+"]");
		ModelAndView mav = new ModelAndView("editor_repairArticlePage");
		mav.addObject("userId", userId);
		List<EditorArticleDealRespDto> list =articleDealService.articleDeal(ArticleStateEnums.REPAIR_ARTICLE.getCode());
		mav.addObject("list", list);
		
		return mav;
	}
	
	/**
	 * toReturnedArticlePage
	 * 退稿
	 */
	@RequestMapping(value="/toReturnedArticlePage",method = RequestMethod.GET)
	public ModelAndView toReturnedArticlePage(@RequestParam("userId") String userId,
			HttpServletRequest request) {
		logger.info("退稿Page:["+userId+"]");
		ModelAndView mav = new ModelAndView("editor_returnedArticlePage");
		mav.addObject("userId", userId);
		List<EditorArticleDealRespDto> list =articleDealService.articleDeal(ArticleStateEnums.RETURNED_ARTICLE.getCode());
		mav.addObject("list", list);
		
		return mav;
	}
	
	/**
	 * toPublishArticlePage
	 * 待刊
	 */
	@RequestMapping(value="/toPublishArticlePage",method = RequestMethod.GET)
	public ModelAndView toPublishArticlePage(@RequestParam("userId") String userId,
			HttpServletRequest request) {
		logger.info("待刊Page:["+userId+"]");
		ModelAndView mav = new ModelAndView("editor_publishArticlePage");
		mav.addObject("userId", userId);
		List<EditorArticleDealRespDto> list =articleDealService.articleDeal(ArticleStateEnums.PUBLISH_ARTICLE.getCode());
		mav.addObject("list", list);
		
		return mav;
	}
	
	
	/**
	 * toPublishArticleDetailPage
	 * 待刊
	 */
	@RequestMapping(value="/toPublishArticleDetailPage",method = RequestMethod.GET)
	public ModelAndView toPublishArticleDetailPage(@RequestParam("userId") String userId,
			@RequestParam("articleId") String articleId,
			HttpServletRequest request) {
		logger.info("待刊详情Page入参:["+userId+"]");
		ModelAndView mav = new ModelAndView("editor_publishArticleDetailPage");
		mav.addObject("userId", userId);
		ArticleInfo articleInfo =articleDealService.qryArticleInfo(articleId);
		mav.addObject("articleInfo", articleInfo);
		logger.info("待刊详情Page出参:["+JSON.toJSONString(articleInfo)+"]");
		return mav;
	}
}
