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
import com.cn.periodical.enums.ArticleStateEnums;
import com.cn.periodical.manager.PeriodicalDetailsManager;
import com.cn.periodical.manager.PeriodicalInfoManager;
import com.cn.periodical.manager.PeriodicalManager;
import com.cn.periodical.manager.SectionInfoManager;
import com.cn.periodical.pojo.Periodical;
import com.cn.periodical.pojo.PeriodicalDetails;
import com.cn.periodical.pojo.PeriodicalQuery;
import com.cn.periodical.pojo.SectionInfo;
import com.cn.periodical.pojo.SectionInfoQuery;
import com.cn.periodical.pojo.UserInfo;
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
			@RequestParam("str") String str,@RequestParam("periodicalIssueNo") String periodicalIssueNo,String periodicalId,
			HttpServletRequest request) {
		logger.info("组稿左右提交进来的:[]&["+periodicalIssueNo+"]");
		UserInfo userInfo = getUserInfo(request);
		ModelAndView mav = new ModelAndView("editor_articleGroupPage");
		JSONArray array = (JSONArray) JSONArray.parse(str);
		for(int i=0;i<array.size();i++){
			System.out.println(array.getJSONObject(i));
			PeriodicalDetails periodicalDetails = new PeriodicalDetails();
			periodicalDetails.setPeriodicalId(periodicalId);
			periodicalDetails.setRefId(array.getJSONObject(i).getString("id"));
			periodicalDetails.setType("0000");
			periodicalDetails.setCreateTime(new Date());
			periodicalDetails.setPeriodicalIssueNo(periodicalIssueNo);
			periodicalDetails.setUserId(userInfo.getUserId());
			periodicalDetails.setSectionId(array.getJSONObject(i).getString("id"));
			JSONArray jsonArray = array.getJSONObject(i).getJSONArray("data");
			
			/**
			 * periodical_details根据periodicalId&periodicalIssueNo&sectionId先删后插入
			 * */
			
			
			for(int k=0;k<jsonArray.size();k++){
				periodicalDetails.setArticleId(jsonArray.getString(k));
				
				periodicalDetailsManager.savePeriodicalDetails(periodicalDetails);
			}
		}
		PeriodicalQuery query =new PeriodicalQuery();
		query.setPeriodicalId(periodicalId);
		query.setPeriodicalIssueNo(periodicalIssueNo);
		List<Periodical> pList = periodicalManager.queryList(query);
		Periodical p = pList.get(0);
		p.setId(p.getId());
		p.setPeriodicalState("0001");/**0000未制作;0001稿件制作中;0002广告制作中;0003制作完成;*/
		periodicalManager.savePeriodical(p);
		return mav;
	}
}
