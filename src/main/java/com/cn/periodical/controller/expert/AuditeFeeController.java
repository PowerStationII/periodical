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
import com.cn.periodical.pojo.AuthorQueryDetail;
import com.cn.periodical.pojo.UserInfo;
import com.cn.periodical.service.ArticleQueryService;

@Controller
public class AuditeFeeController extends ExpertController{
	
	private static final Logger logger = LoggerFactory.getLogger(AuditeFeeController.class);
	@Autowired
	ArticleQueryService articleQueryService;
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
		authorQueryDetail.setArticleCnKeywords(articleId);
		List<AuthorQueryDetail> authorQueryDetails= articleQueryService.queryArticleFee(authorQueryDetail);
		AuthorQueryDetail feeDetail =authorQueryDetails.get(0);
		mav.addObject("obj", feeDetail);
		logger.info("expert稿费明细Page out:["+JSON.toJSONString(feeDetail)+"]");
		return mav;
	}
}
