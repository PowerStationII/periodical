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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.cn.periodical.manager.ArticleFlowsManager;
import com.cn.periodical.pojo.AuthorQueryDetail;
import com.cn.periodical.pojo.Opinion;
import com.cn.periodical.pojo.UserInfo;
import com.cn.periodical.request.ArticleQueryReqDto;
import com.cn.periodical.response.ArticleQueryRespDto;
import com.cn.periodical.service.ArticleQueryService;
/**
 * 作者工作区-稿件查询 
 * */
@Controller
public class ArticleQueryController extends AuthorController{
	
	private static final Logger logger = LoggerFactory.getLogger(ArticleQueryController.class);
	@Autowired
	ArticleQueryService articleQueryService;
	
	@Autowired
	ArticleFlowsManager articleFlowsManager;
	
	/**
	 * toArticleQueryPage
	 * author/toArticleQueryPage
	 * 去稿件查询页面
	 */
	@RequestMapping(value="/toArticleQueryPage")
	public ModelAndView toArticleQueryPage(HttpServletRequest request,HttpServletResponse response) {
		logger.info("稿件查询Page:[]");
		ModelAndView mav = new ModelAndView("articleQueryPage");		
		ArticleQueryReqDto reqDto= new ArticleQueryReqDto();
		reqDto.setUserId(getUserInfo(request).getUserId());
		List<ArticleQueryRespDto> list =articleQueryService.queryArticleInfos(reqDto);
		mav.addObject("list", list);
		logger.info("稿件查询出参:["+JSON.toJSONString(list)+"]");
		return mav;
	}
	
	
	/**
	 * toArticleQueryDetailPage
	 * 去稿件明细页面
	 */
	@RequestMapping(value="/toArticleQueryDetailPage",method = RequestMethod.GET)
	public ModelAndView toArticleQueryDetailPage(@RequestParam("articleId") String articleId) {
		logger.info("稿件明细Page:["+articleId+"]");
		ModelAndView mav = new ModelAndView("articleQueryDetailPage");
		AuthorQueryDetail detail = articleQueryService.queryAuthorQueryDetail(articleId);
		mav.addObject("detail", detail);
		logger.info("稿件明细出参:["+JSON.toJSONString(detail)+"]");
		return mav;
	}
	
	
	/**
	 * toOpinionQueryPage
	 * 查询审核意见
	 */
	@RequestMapping(value="/toOpinionQueryPage",produces = "application/text; charset=utf-8")
	@ResponseBody
	public String toOpinionQueryPage(@RequestParam("articleId") String articleId,HttpServletRequest request,
			HttpServletResponse response) {
		UserInfo userInfo = getUserInfo(request);
		logger.info("查询审稿意见Page in:["+JSON.toJSONString(userInfo)+"]");
		//ModelAndView mav = new ModelAndView("redirect:../author/toArticleQueryPage");
		Opinion opinion = articleFlowsManager.queryOpinion(articleId);
		logger.info("查询审稿意见Page out:["+JSON.toJSONString(opinion)+"]");
		return JSON.toJSONString(opinion);
	}
}
