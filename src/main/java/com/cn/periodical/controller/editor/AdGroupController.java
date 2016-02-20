package com.cn.periodical.controller.editor;

import java.io.*;
import java.util.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cn.periodical.pojo.*;
import com.cn.periodical.utils.PropertiesInitManager;
import com.cn.periodical.utils.UtilLoad;
import org.codehaus.plexus.archiver.zip.ZipEntry;
import org.codehaus.plexus.archiver.zip.ZipOutputStream;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.cn.periodical.enums.PeriodicalStateEnums;
import com.cn.periodical.manager.AdInfoManager;
import com.cn.periodical.manager.ArticleInfoManager;
import com.cn.periodical.manager.PeriodicalDetailsManager;
import com.cn.periodical.manager.PeriodicalInfoManager;
import com.cn.periodical.manager.PeriodicalManager;
import com.cn.periodical.manager.SectionInfoManager;
import com.cn.periodical.service.EditorArticleDealService;
/**
 * 广告-组刊Controller
 * */
@Controller
public class AdGroupController extends EditorController{
	
	private static final Logger logger = LoggerFactory.getLogger(AdGroupController.class);
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
	@Autowired
	ArticleInfoManager articleInfoManager;
	@Autowired
	AdInfoManager adInfoManager;
	
	/**
	 * toAdGroupPage
	 * 广告排刊
	 */
	@RequestMapping(value="/toAdGroupPage",method = RequestMethod.GET)
	public ModelAndView toAdGroupPage(HttpServletRequest request) {
		logger.info("广告排刊Page:[ ]");
		ModelAndView mav = new ModelAndView("editor_adGroupPage");
		List<PeriodicalInfo> periodicalInfos = periodicalInfoManager.queryList(null);
		mav.addObject("list", periodicalInfos);
		return mav;
	}
	/**
	 * toAdGroupDetailPage
	 * 广告组刊-
	 */
	@RequestMapping(value="/toAdGroupDetailPage")
	public ModelAndView toAdGroupDetailPage(HttpServletRequest request,String periodicalId,String periodicalIssueNo) {
		logger.info("广告组刊Page:[ "+periodicalId+" ]");
		ModelAndView mav = new ModelAndView("editor_adGroupDetailPage");
		PeriodicalInfo periodicalInfo = periodicalInfoManager.selectByPeriodicalId(periodicalId);
		PeriodicalQuery query = new PeriodicalQuery();
		query.setPeriodicalId(periodicalId);
		query.setPeriodicalIssueNo(periodicalIssueNo);
		List<Periodical> periodicals = periodicalManager.queryList(query);
		mav.addObject("list", periodicals);
		mav.addObject("p", periodicalInfo);
		return mav;
	}
	
	
	/**
	 * toAdGroupInfosPage
	 * 广告刊登详情页
	 */
	@RequestMapping(value="/toAdGroupInfosPage")
	public ModelAndView toAdGroupInfosPage(
			@RequestParam("periodicalId") String periodicalId,
			@RequestParam("periodicalIssueNo") String periodicalIssueNo,
			HttpServletRequest request) {
		logger.info("广告组刊左右Page:[ "+periodicalId+"]&["+periodicalIssueNo+"]");
		ModelAndView mav = new ModelAndView("editor_adGroupInfosPage");
		/**
		 * 查询广告信息
		 * */
		List<AdInfo> adInfos = adInfoManager.queryList(null);
		mav.addObject("list", adInfos);
		
		/**
		 * 循环广告可以刊登的位置
		 * 等同于栏目信息
		 * */
		SectionInfoQuery query =new SectionInfoQuery();
		query.setPeriodicalId(periodicalId);
		query.setPeriodicalIssueNo(periodicalIssueNo);
		query.setExtend1("Y");
		List<SectionInfo> sectionInfos = sectionInfoManager.selectByExampleForAd(query);
		logger.info("+++++++++++++++");
		logger.info(JSON.toJSONString(sectionInfos));
		logger.info("+++++++++++++++");
		mav.addObject("sList", sectionInfos);

		mav.addObject("periodicalIssueNo", periodicalIssueNo);
		mav.addObject("periodicalId", periodicalId);
		return mav;
		
	}
	
	
	/**
	 * toSaveAdGroup
	 * 确认广告
	 */
	@RequestMapping(value="/toSaveAdGroup")
	@ResponseBody
	public ModelAndView toSaveAdGroup(
			@RequestParam("str") String str,
			@RequestParam("periodicalIssueNo") String periodicalIssueNo,
			String leftArray,
			String periodicalId,HttpServletRequest request,String type) {
		logger.info("广告 广告进来的左右提交进来的:leftArray:["+leftArray+"]"
				+ "&periodicalIssueNo:["+periodicalIssueNo+"]"
						+ "&str["+str+"]&periodicalId:["+periodicalId+"]");
		ModelAndView mav = new ModelAndView("redirect:../editor/toAdGroupDetailPage");
		mav.addObject("periodicalId", periodicalId);
		
		
		UserInfo userInfo = getUserInfo(request);
		/*
		 * 每点击一次提交periodical_details,表中的数据会根据条件删除
		 * periodical_details根据periodicalId&periodicalIssueNo&sectionId先删后插入
		 * */
		PeriodicalDetailsQuery dQuery = new PeriodicalDetailsQuery();
		dQuery.setPeriodicalId(periodicalId);
		dQuery.setPeriodicalIssueNo(periodicalIssueNo);
		dQuery.setType("0001");
		logger.info("删除details表中已存在的数据......"+JSON.toJSONString(dQuery));
		periodicalDetailsManager.deletePeriodicalDetails(dQuery);
		logger.info("删除details表中已存在的数据......");
		
		JSONArray array = (JSONArray) JSONArray.parse(str);
		for(int i=0;i<array.size();i++){
			System.out.println(array.getJSONObject(i));
			PeriodicalDetails periodicalDetails = new PeriodicalDetails();
			periodicalDetails.setPeriodicalId(periodicalId);
			periodicalDetails.setRefId(array.getJSONObject(i).getString("id"));
			periodicalDetails.setType("0001");//0000是稿件的意思
			periodicalDetails.setCreateTime(new Date());
			periodicalDetails.setPeriodicalIssueNo(periodicalIssueNo);
			periodicalDetails.setUserId(userInfo.getUserId());
			periodicalDetails.setSectionId(array.getJSONObject(i).getString("id"));
			JSONArray jsonArray = array.getJSONObject(i).getJSONArray("data");
			
			for(int k=0;k<jsonArray.size();k++){
				periodicalDetails.setAdId(jsonArray.getString(k));
				periodicalDetailsManager.savePeriodicalDetails(periodicalDetails);
				/**
				 * 将已经在栏目下的稿件artcileInfo.extend_3字段变更为Y
				 * 如果广告在这一期已经存在,实际是不应该查出来的
				 * 为了让左边不在查出这条数据
				 * */
			}
		}
        // 广告期刊的状态用extends2表示
		PeriodicalQuery query =new PeriodicalQuery();
		query.setPeriodicalId(periodicalId);
		query.setPeriodicalIssueNo(periodicalIssueNo);
		List<Periodical> pList = periodicalManager.queryList(query);
		Periodical p = pList.get(0);
		p.setId(p.getId());
		if("Y".equals(type)){
			p.setExtend2(PeriodicalStateEnums.AD_PART_OVER.getCode());
		}else{
			p.setExtend2(PeriodicalStateEnums.AD_PART_DEALING.getCode());
		}
		periodicalManager.savePeriodical(p);
		return mav;
	}


    /**
     * editor_toADGroupPage
     * 广告刊登详情页
     */
    @RequestMapping(value="/editor_toADGroupPage")
    public ModelAndView editor_toADGroupPage(
            @RequestParam("periodicalId") String periodicalId,
            @RequestParam("periodicalIssueNo") String periodicalIssueNo,
            HttpServletRequest request) {
        logger.info("广告组刊左右Page:[ "+periodicalId+"]&["+periodicalIssueNo+"]");
        ModelAndView mav = new ModelAndView("editor_toADGroupPage");
        /**
         * 查询广告信息
         * */
        List<AdInfo> adInfos = adInfoManager.queryList(null);
        mav.addObject("list", adInfos);

        /**
         * 循环广告可以刊登的位置
         * 等同于栏目信息
         * */
        SectionInfoQuery query =new SectionInfoQuery();
        query.setPeriodicalId(periodicalId);
        query.setPeriodicalIssueNo(periodicalIssueNo);
        query.setExtend1("Y");
        List<SectionInfo> sectionInfos = sectionInfoManager.selectByExampleForAd(query);
        logger.info("+++++++++++++++");
        logger.info(JSON.toJSONString(sectionInfos));
        logger.info("+++++++++++++++");
        mav.addObject("sList", sectionInfos);

        mav.addObject("periodicalIssueNo", periodicalIssueNo);
        mav.addObject("periodicalId", periodicalId);
        return mav;



    }



}
