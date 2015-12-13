package com.cn.periodical.controller.editor;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
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
import com.alibaba.fastjson.JSONArray;
import com.cn.periodical.enums.ArticleStateEnums;
import com.cn.periodical.enums.PeriodicalStateEnums;
import com.cn.periodical.manager.ArticleInfoManager;
import com.cn.periodical.manager.AuthorInfoManager;
import com.cn.periodical.manager.PeriodicalDetailsManager;
import com.cn.periodical.manager.PeriodicalInfoManager;
import com.cn.periodical.manager.PeriodicalManager;
import com.cn.periodical.manager.SectionInfoManager;
import com.cn.periodical.pojo.ArticleInfo;
import com.cn.periodical.pojo.ArticleInfoQuery;
import com.cn.periodical.pojo.AuthorInfo;
import com.cn.periodical.pojo.AuthorInfoQuery;
import com.cn.periodical.pojo.Periodical;
import com.cn.periodical.pojo.PeriodicalDetails;
import com.cn.periodical.pojo.PeriodicalDetailsQuery;
import com.cn.periodical.pojo.PeriodicalInfo;
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
	@Autowired
	ArticleInfoManager articleInfoManager;
	@Autowired
	AuthorInfoManager authorInfoManager;
	
	/**
	 * toArticleGroupPage
	 * 排刊
	 */
	@RequestMapping(value="/toArticleGroupPage",method = RequestMethod.GET)
	public ModelAndView toArticleGroupPage(HttpServletRequest request) {
		logger.info("排刊组稿Page:[ ]");
		ModelAndView mav = new ModelAndView("editor_articleGroupPage");
		List<PeriodicalInfo> periodicalInfos = periodicalInfoManager.queryList(null);
		mav.addObject("list", periodicalInfos);
		return mav;
	}
	/**
	 * toGroupPage
	 * 组稿
	 */
	@RequestMapping(value="/toGroupPage")
	public ModelAndView toGroupPage(HttpServletRequest request,String periodicalId,String periodicalIssueNo) {
		logger.info("组稿Page:[ "+periodicalId+" ]");
		ModelAndView mav = new ModelAndView("editor_groupPage");
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
	 * toArticleGroupDetailPage
	 * 组稿详情页
	 */
	@RequestMapping(value="/toArticleGroupDetailPage",method = RequestMethod.GET)
	public ModelAndView toArticleGroupDetailPage(
			@RequestParam("periodicalId") String periodicalId,
			@RequestParam("periodicalIssueNo") String periodicalIssueNo,
			HttpServletRequest request) {
		logger.info("组稿左右Page:[ "+periodicalId+"]&["+periodicalIssueNo+"]");
		ModelAndView mav = new ModelAndView("editor_articleGroupDetailPage");
		
		List<EditorArticleDealRespDto> list = new ArrayList<EditorArticleDealRespDto>();
		ArticleInfoQuery articleInfoQuery = new ArticleInfoQuery();
		/**
		 * 取编辑处理完成(点击待刊按钮后)且专家是待刊的状态的稿件进行组刊
		 * */
		articleInfoQuery.setEditorState(ArticleStateEnums.END_ARTICLE.getCode());
		articleInfoQuery.setExpertState(ArticleStateEnums.PUBLISH_ARTICLE.getCode());
		articleInfoQuery.setExtends3("N");
		List<ArticleInfo> articleInfos = articleInfoManager.queryList(articleInfoQuery);
		Iterator<ArticleInfo> iters = articleInfos.iterator();
		while(iters.hasNext()){
			EditorArticleDealRespDto editorArticleDealRespDto = new EditorArticleDealRespDto();
			ArticleInfo articleInfo = iters.next();
			AuthorInfoQuery authorInfoQuery = new AuthorInfoQuery();
			authorInfoQuery.setArticleId(articleInfo.getArticleId());
			List<AuthorInfo> authorInfos = authorInfoManager.queryList(authorInfoQuery);
			editorArticleDealRespDto.setArticleInfo(articleInfo);
			editorArticleDealRespDto.setAuthorInfos(authorInfos);
//			editorArticleDealRespDto.setArticleAttachmentInfo(articleAttachmentInfo);
			list.add(editorArticleDealRespDto);
		}
		
		mav.addObject("list", list);
		
		
		SectionInfoQuery query =new SectionInfoQuery();
		query.setPeriodicalId(periodicalId);
		query.setPeriodicalIssueNo(periodicalIssueNo);
		query.setExtend1("N");
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
			@RequestParam("periodicalIssueNo") String periodicalIssueNo,
			String leftArray,
			String periodicalId,HttpServletRequest request,String type) {
		logger.info("组稿左右提交进来的:leftArray:["+leftArray+"]"
				+ "&periodicalIssueNo:["+periodicalIssueNo+"]"
						+ "&str["+str+"]&periodicalId:["+periodicalId+"]");
		UserInfo userInfo = getUserInfo(request);
		ModelAndView mav = new ModelAndView("redirect:../editor/toGroupPage");
		mav.addObject("periodicalId", periodicalId);
		/*
		 * 每点击一次提交periodical_details,表中的数据会根据条件删除
		 * periodical_details根据periodicalId&periodicalIssueNo&sectionId先删后插入
		 * */
		PeriodicalDetailsQuery dQuery = new PeriodicalDetailsQuery();
		dQuery.setPeriodicalId(periodicalId);
		dQuery.setPeriodicalIssueNo(periodicalIssueNo);
		dQuery.setType("0000");
		logger.info("删除details表中已存在的数据......"+JSON.toJSONString(dQuery));
		periodicalDetailsManager.deletePeriodicalDetails(dQuery);
		logger.info("删除details表中已存在的数据......");
		
		JSONArray array = (JSONArray) JSONArray.parse(str);
		for(int i=0;i<array.size();i++){
			System.out.println(array.getJSONObject(i));
			PeriodicalDetails periodicalDetails = new PeriodicalDetails();
			periodicalDetails.setPeriodicalId(periodicalId);
			periodicalDetails.setRefId(array.getJSONObject(i).getString("id"));
			periodicalDetails.setType("0000");//0000是稿件的意思
			periodicalDetails.setCreateTime(new Date());
			periodicalDetails.setPeriodicalIssueNo(periodicalIssueNo);
			periodicalDetails.setUserId(userInfo.getUserId());
			periodicalDetails.setSectionId(array.getJSONObject(i).getString("id"));
			JSONArray jsonArray = array.getJSONObject(i).getJSONArray("data");
			
			/**
			 * 页面如何将左边里存在的值传入后台,如果左边有值,需要将articleInfo.extend_3的状态变回N
			 * */
			if(!"".equals(leftArray)){
				String[] leftStrs = leftArray.split(",");
				for(int l=0;l<leftStrs.length;l++){
					Map map = new HashMap();
					map.put("articleId", leftStrs[l]);
					ArticleInfo a = articleInfoManager.qryInfoByArticleId(map);
					a.setId(a.getId());
					a.setExtends3("N");
					articleInfoManager.saveArticleInfo(a);
				}
			}
			
			for(int k=0;k<jsonArray.size();k++){
				periodicalDetails.setArticleId(jsonArray.getString(k));
				periodicalDetailsManager.savePeriodicalDetails(periodicalDetails);
				/**
				 * 将已经在栏目下的稿件artcileInfo.extend_3字段变更为Y
				 * 为了让左边不在查出这条数据
				 * */
				Map map = new HashMap();
				map.put("articleId", jsonArray.getString(k));
				ArticleInfo a = articleInfoManager.qryInfoByArticleId(map);
				a.setId(a.getId());
				a.setExtends3("Y");
				articleInfoManager.saveArticleInfo(a);
			}
		}
		PeriodicalQuery query =new PeriodicalQuery();
		query.setPeriodicalId(periodicalId);
		query.setPeriodicalIssueNo(periodicalIssueNo);
		List<Periodical> pList = periodicalManager.queryList(query);
		Periodical p = pList.get(0);
		p.setId(p.getId());
		if("Y".equals(type)){
			p.setPeriodicalState(PeriodicalStateEnums.ARTICLE_PART_OVER.getCode());
		}else{
			p.setPeriodicalState(PeriodicalStateEnums.ARTICLE_PART_DEALING.getCode());
		}
		periodicalManager.savePeriodical(p);
		return mav;
	}
}
