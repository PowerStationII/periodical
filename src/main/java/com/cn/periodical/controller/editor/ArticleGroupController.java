package com.cn.periodical.controller.editor;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.cn.periodical.enums.ArticleStateEnums;
import com.cn.periodical.manager.PeriodicalDetailsManager;
import com.cn.periodical.manager.PeriodicalInfoManager;
import com.cn.periodical.manager.PeriodicalManager;
import com.cn.periodical.manager.SectionInfoManager;
import com.cn.periodical.pojo.Periodical;
import com.cn.periodical.pojo.PeriodicalDetails;
import com.cn.periodical.pojo.SectionInfo;
import com.cn.periodical.pojo.SectionInfoQuery;
import com.cn.periodical.response.EditorArticleDealRespDto;
import com.cn.periodical.service.EditorArticleDealService;
/**
 * 稿件编辑-组刊Controller
 * */
@Controller
public class ArticleGroupController extends EditorController{
	
	private static final Logger logger = LoggerFactory.getLogger(ArticleGroupController.class);
	@Autowired
	PeriodicalInfoManager periodicalInfoManager;
	
	@Autowired
	PeriodicalManager periodicalManager;
	
	@Autowired
	SectionInfoManager sectionInfoManager;
	
	@Autowired
	EditorArticleDealService articleDealService;
	
	@Autowired
	PeriodicalDetailsManager periodicalDetailsManager;
	
	/**
	 * toArticleGroupPage
	 * 组稿
	 */
	@RequestMapping(value="/toArticleGroupPage",method = RequestMethod.GET)
	public ModelAndView toArticleGroupPage(HttpServletRequest request) {
		logger.info("排刊组稿Page:[ ]");
		ModelAndView mav = new ModelAndView("editor_articleGroupPage");
		List<Periodical> periodicals = periodicalManager.queryList(null);
		mav.addObject("list", periodicals);
		return mav;
	}
	
	
	/**
	 * toArticleGroupDetailPage
	 * 组稿详情页
	 */
	@RequestMapping(value="/toArticleGroupDetailPage",method = RequestMethod.GET)
	public ModelAndView toArticleGroupDetailPage(
			@RequestParam("periodicalId") String periodicalId,
			@RequestParam("periodicalIssueNo") String periodicalIssueNo,
			HttpServletRequest request) {
		logger.info("组稿左右Page:[ ]&["+periodicalIssueNo+"]");
		ModelAndView mav = new ModelAndView("editor_articleGroupDetailPage");
		
		List<EditorArticleDealRespDto> list =articleDealService.articleDeal(ArticleStateEnums.PUBLISH_ARTICLE.getCode());
		mav.addObject("list", list);
		SectionInfoQuery query =new SectionInfoQuery();
		query.setPeriodicalId(periodicalId);
		List<SectionInfo> sectionInfos = sectionInfoManager.queryList(query);
		mav.addObject("sList", sectionInfos);

		mav.addObject("periodicalIssueNo", periodicalIssueNo);
		mav.addObject("periodicalId", periodicalId);
		return mav;
	}
	
	
	/**
	 * toArticleGroup
	 * 组稿
	 */
	@RequestMapping(value="/toArticleGroup")
	public ModelAndView toArticleGroup(
			@RequestParam("str") String str,
			HttpServletRequest request) {
//		logger.info("组稿左右提交进来的:[]&["+periodicalIssueNo+"]");
//		logger.info("----------------");
		ModelAndView mav = new ModelAndView("editor_articleGroupPage");
		JSONArray array = (JSONArray) JSONArray.parse(str);
		for(int i=0;i<array.size();i++){
			System.out.println(array.getJSONObject(i));
		}
//		logger.info(request.getParameter("selectTest"));
//		String sectionInfos=request.getParameter("sectionA");
//		String[] strs = sectionInfos.split(",");
//		for(int i=0;i<strs.length;i++){
//			PeriodicalDetails periodicalDetails = new PeriodicalDetails();
//			periodicalDetails.setPeriodicalId(periodicalId);
//			periodicalDetails.setRefId(strs[i]);
//			periodicalDetails.setType("0000");
//			periodicalDetails.setCreateTime(new Date());
//			periodicalDetails.setPeriodicalIssueNo(periodicalIssueNo);
////			periodicalDetails.setUserId(userId);
//			periodicalDetails.setSectionId("sectionA");
//			periodicalDetailsManager.savePeriodicalDetails(periodicalDetails);
//		}
		
		return mav;
	}
}
