package com.cn.periodical.controller.author;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.cn.periodical.manager.AuthorInfoManager;
import com.cn.periodical.manager.PeriodicalDetailsManager;
import com.cn.periodical.manager.PeriodicalManager;
import com.cn.periodical.pojo.AuthorInfo;
import com.cn.periodical.pojo.AuthorInfoQuery;
import com.cn.periodical.pojo.AuthorQueryDetail;
import com.cn.periodical.pojo.Periodical;
import com.cn.periodical.pojo.PeriodicalDetails;
import com.cn.periodical.pojo.PeriodicalDetailsQuery;
import com.cn.periodical.pojo.PeriodicalQuery;
import com.cn.periodical.service.ArticleQueryService;
/**
 * 作者工作区-稿费查询 
 * */
@Controller
public class ArticleFeeController extends AuthorController{
	
	private static final Logger logger = LoggerFactory.getLogger(ArticleFeeController.class);
	@Autowired
	ArticleQueryService articleQueryService;
	
	@Autowired
	AuthorInfoManager authorInfoManager;
	
	@Autowired
	PeriodicalDetailsManager periodicalDetailsManager;
	
	@Autowired
	PeriodicalManager periodicalManager;
	/**
	 * toArticleFeePage
	 * 去稿费查询页面
	 */
	@RequestMapping(value="/toArticleFeePage")
	public ModelAndView toArticleFeePage(HttpServletRequest request,HttpServletResponse response) {
		logger.info("稿费查询Page:["+JSON.toJSONString(userInfo)+"]");
		ModelAndView mav = new ModelAndView("articleFeePage");
		AuthorQueryDetail authorQueryDetail = new AuthorQueryDetail();
		authorQueryDetail.setUserId(getUserInfo(request).getUserId());
		List<AuthorQueryDetail> authorQueryDetails =articleQueryService.queryArticleFee(authorQueryDetail);		
		logger.info("稿费查询出参:["+JSON.toJSONString(authorQueryDetails)+"]");
		mav.addObject("list", authorQueryDetails);
		return mav;
	}
	
	/**
	 * toArticleFeeDetailPage
	 * 去稿费明细页面
	 */
	@RequestMapping(value="/toArticleFeeDetailPage",method = RequestMethod.GET)
	public ModelAndView toArticleFeeDetailPage(@RequestParam("articleId") String articleId,HttpServletRequest request) {
		logger.info("稿费明细Page in:["+articleId+"]");
		ModelAndView mav = new ModelAndView("articleFeeDetailPage");
		AuthorQueryDetail authorQueryDetail = new AuthorQueryDetail();
		authorQueryDetail.setUserId(getUserInfo(request).getUserId());
		authorQueryDetail.setArticleCnKeywords(articleId);
		List<AuthorQueryDetail> authorQueryDetails= articleQueryService.queryArticleFee(authorQueryDetail);
		AuthorQueryDetail feeDetail =authorQueryDetails.get(0);
		mav.addObject("obj", feeDetail);
		
		mav.addObject("roleId", getUserInfo(request).getRoleId());
		
		AuthorInfoQuery query = new AuthorInfoQuery();
		query.setArticleId(articleId);
		query.setIsfirstauthor("Y");
		List<AuthorInfo> authorInfos = authorInfoManager.queryList(query);
		mav.addObject("author",authorInfos.get(0));
		
//		PeriodicalDetailsQuery pdQuery = new PeriodicalDetailsQuery();
//		pdQuery.setArticleId(articleId);
//		List<PeriodicalDetails> periodicalDetails = periodicalDetailsManager.queryList(pdQuery);
//		
//		PeriodicalQuery pQuery = new PeriodicalQuery();
//		pQuery.setPeriodicalIssueNo(periodicalDetails.get(0).getPeriodicalIssueNo());
//		List<Periodical> ps = periodicalManager.queryList(pQuery);
//		mav.addObject("p",ps.get(0));
		
		logger.info("稿费明细Page out:["+JSON.toJSONString(feeDetail)+"]");
		return mav;
	}
}
