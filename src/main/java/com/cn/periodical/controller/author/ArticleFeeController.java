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
import com.cn.periodical.pojo.ArticleInfo;
import com.cn.periodical.pojo.UserInfo;
import com.cn.periodical.response.AuthorArticleQueryRespDto;
import com.cn.periodical.service.AuthorArticleQueryService;
/**
 * 作者工作区-稿费查询 
 * */
@Controller
public class ArticleFeeController extends AuthorController{
	
	private static final Logger logger = LoggerFactory.getLogger(ArticleFeeController.class);
	@Autowired
	AuthorArticleQueryService articleQueryService;
	/**
	 * toArticleFeePage
	 * 去稿费查询页面
	 */
	@RequestMapping(value="/toArticleFeePage")
	public ModelAndView toArticleFeePage(HttpServletRequest request,HttpServletResponse response) {
		UserInfo userInfo = (UserInfo)request.getSession().getAttribute("userInfo");
		logger.info("稿费查询Page:["+JSON.toJSONString(userInfo)+"]");
		ModelAndView mav = new ModelAndView("articleFeePage");
		mav.addObject("userId", userInfo.getUserId());
		List<AuthorArticleQueryRespDto> list = articleQueryService.queryArticleFee(userInfo.getUserId());
		logger.info("稿费查询出参:["+JSON.toJSONString(list)+"]");
		mav.addObject("list", list);
		return mav;
	}
	
	/**
	 * toArticleFeeDetailPage
	 * 去稿费明细页面
	 */
	@RequestMapping(value="/toArticleFeeDetailPage",method = RequestMethod.GET)
	public ModelAndView toArticleFeeDetailPage(@RequestParam("articleId") String articleId ,@RequestParam("userId") String userId) {
		logger.info("稿费明细Page:["+articleId+"]");
		ModelAndView mav = new ModelAndView("articleFeeDetailPage");
		ArticleInfo articleInfo = articleQueryService.queryArticleDetailInfo(articleId);
		mav.addObject("articleInfo", articleInfo);
		/**
		 * 这个查询需要修改
		 * */
		List<AuthorArticleQueryRespDto> list = articleQueryService.queryArticleFee(userId);
		mav.addObject("respDto", list.get(0));
		logger.info("稿费明细出参:["+JSON.toJSONString(list.get(0))+"]");
		return mav;
	}
}
