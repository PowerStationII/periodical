package com.cn.periodical.controller.expert;

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

import com.alibaba.fastjson.JSON;
import com.cn.periodical.manager.ExpertInfoManager;
import com.cn.periodical.manager.PeriodicalDetailsManager;
import com.cn.periodical.manager.PeriodicalManager;
import com.cn.periodical.pojo.AuthorQueryDetail;
import com.cn.periodical.pojo.ExpertInfo;
import com.cn.periodical.pojo.ExpertInfoQuery;
import com.cn.periodical.pojo.Periodical;
import com.cn.periodical.pojo.PeriodicalDetails;
import com.cn.periodical.pojo.PeriodicalDetailsQuery;
import com.cn.periodical.pojo.PeriodicalQuery;
import com.cn.periodical.pojo.UserInfo;
import com.cn.periodical.service.ArticleQueryService;

@Controller
public class AuditeFeeController extends ExpertController{
	
	private static final Logger logger = LoggerFactory.getLogger(AuditeFeeController.class);
	@Autowired
	ArticleQueryService articleQueryService;
	
	@Autowired
	ExpertInfoManager expertInfoManager;
	
	@Autowired
	PeriodicalDetailsManager periodicalDetailsManager;
	
	@Autowired
	PeriodicalManager periodicalManager;
	
	/**
	 * toArticleAuditePage
	 * 去审稿费查询页面
	 */
	@RequestMapping(value="/toAuditeFeePage",method = RequestMethod.GET)
	public ModelAndView toAuditeFeePage(HttpServletRequest request) {
		UserInfo userInfo = getUserInfo(request);
		logger.info("expert稿费查询Page:["+userInfo.getUserId()+"]");
		ModelAndView mav = new ModelAndView("expert_auditeFeePage");
		AuthorQueryDetail authorQueryDetail = new AuthorQueryDetail();
		authorQueryDetail.setUserId(getUserInfo(request).getUserId());
		List<AuthorQueryDetail> authorQueryDetails =articleQueryService.queryArticleFee(authorQueryDetail);		
		logger.info("expert稿费查询出参:["+JSON.toJSONString(authorQueryDetails)+"]");
		mav.addObject("list", authorQueryDetails);
		return mav;
	}
	
	/**
	 * toArticleFeeDetailPage
	 * 去稿费明细页面
	 */
	@RequestMapping(value="/toArticleFeeDetailPage",method = RequestMethod.GET)
	public ModelAndView toArticleFeeDetailPage(@RequestParam("articleId") String articleId,HttpServletRequest request) {
		logger.info("expert稿费明细Page in:["+articleId+"]");
		ModelAndView mav = new ModelAndView("articleFeeDetailPage");
		AuthorQueryDetail authorQueryDetail = new AuthorQueryDetail();
		authorQueryDetail.setUserId(getUserInfo(request).getUserId());
		authorQueryDetail.setArticleId(articleId);
		List<AuthorQueryDetail> authorQueryDetails= articleQueryService.queryArticleFee(authorQueryDetail);
		AuthorQueryDetail feeDetail =authorQueryDetails.get(0);
		mav.addObject("obj", feeDetail);
		
		mav.addObject("roleId", getUserInfo(request).getRoleId());
		
		ExpertInfoQuery query = new ExpertInfoQuery();
		query.setExpertId(getUserInfo(request).getRefId());
		List<ExpertInfo> expertInfos = expertInfoManager.queryList(query);
		mav.addObject("expert",expertInfos.get(0));
		
//		PeriodicalDetailsQuery pdQuery = new PeriodicalDetailsQuery();
//		pdQuery.setArticleId(articleId);
//		List<PeriodicalDetails> periodicalDetails = periodicalDetailsManager.queryList(pdQuery);
//		
//		PeriodicalQuery pQuery = new PeriodicalQuery();
//		pQuery.setPeriodicalIssueNo(periodicalDetails.get(0).getPeriodicalIssueNo());
//		List<Periodical> ps = periodicalManager.queryList(pQuery);
//		mav.addObject("p",ps.get(0));
		
		logger.info("expert稿费明细Page out:["+JSON.toJSONString(feeDetail)+"]");
		return mav;
	}
}
