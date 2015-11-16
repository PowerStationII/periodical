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
 * 作者工作区-稿件查询 
 * */
@Controller
public class ArticleQueryController extends AuthorController{
	
	private static final Logger logger = LoggerFactory.getLogger(ArticleQueryController.class);
	@Autowired
	AuthorArticleQueryService articleQueryService;
	
	
	/**
	 * toArticleQueryPage
	 * author/toArticleQueryPage
	 * 去稿件查询页面
	 */
	@RequestMapping(value="/toArticleQueryPage")
	public ModelAndView toArticleQueryPage(HttpServletRequest request,HttpServletResponse response) {
		UserInfo userInfo = (UserInfo)request.getSession().getAttribute("userInfo");
		logger.info("稿件查询Page:["+JSON.toJSONString(userInfo)+"]");
		ModelAndView mav = new ModelAndView("articleQueryPage");
		mav.addObject("userId", userInfo.getUserId());
		
		List<AuthorArticleQueryRespDto> list = articleQueryService.queryArticleInfo(userInfo.getUserId());
		
		logger.info("稿件查询出参:["+JSON.toJSONString(list)+"]");
		mav.addObject("list", list);
		return mav;
	}
	
	
	/**
	 * toArticleQueryDetailPage
	 * 去稿件明细页面
	 */
	@RequestMapping(value="/toArticleQueryDetailPage",method = RequestMethod.GET)
	public ModelAndView toArticleQueryDetailPage(@RequestParam("artilceId") String artilceId) {
		logger.info("稿件明细Page:["+artilceId+"]");
		ModelAndView mav = new ModelAndView("articleQueryDetailPage");
		
		ArticleInfo articleInfo = articleQueryService.queryArticleDetailInfo(artilceId);
		mav.addObject("articleInfo", articleInfo);
		logger.info("稿件明细出参:["+JSON.toJSONString(articleInfo)+"]");
		return mav;
	}
}
