package com.cn.periodical.controller.editor;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.cn.periodical.manager.ArticleInfoManager;
import com.cn.periodical.pojo.ArticleInfo;
import com.cn.periodical.pojo.ArticleInfoQuery;
import com.cn.periodical.pojo.BizAuthorAddressInfo;
/**
 * 系统稿件信息Controller
 * */
@Controller
public class QuerySysArticleInfosController extends EditorController{
	
	private static final Logger logger = LoggerFactory.getLogger(QuerySysArticleInfosController.class);
	@Autowired
	ArticleInfoManager articleInfoManager;
	
	/**
	 * toQuerySysArticleInfosPage
	 * 查看系统稿件信息
	 */
	@RequestMapping(value="/toQuerySysArticleInfosPage")
	public ModelAndView toQuerySysArticleInfosPage(HttpServletRequest request,@ModelAttribute ArticleInfoQuery articleInfoQuery) {
		ModelAndView mav = new ModelAndView("editor_sys_articleInfosPage");
		List<ArticleInfo> articleInfos = articleInfoManager.querySysArticleInfosList(articleInfoQuery);
		mav.addObject("list", articleInfos);
		logger.info(JSON.toJSONString(articleInfos));
		return mav;
	}
	
	
	@RequestMapping(value="/toQuerySysArticleInfoDetailPage")
	public ModelAndView toQueryAuthorInfoDetailPage(HttpServletRequest request,String articleId) {
		ModelAndView mav = new ModelAndView("editor_sys_articleInfosDetailPage");
		ArticleInfoQuery articleInfoQuery =new ArticleInfoQuery();
		articleInfoQuery.setArticleId(articleId);
		List<ArticleInfo> articleInfos = articleInfoManager.querySysArticleInfosList(articleInfoQuery);
		mav.addObject("articleInfo", articleInfos.get(0));
		logger.info("++++++++++++++++++++++");
		logger.info(JSON.toJSONString(articleInfos.get(0)));
		logger.info("++++++++++++++++++++++");
		logger.info(JSON.toJSONString(articleInfos.get(0).getBizAuthorAddressInfos()));
		return mav;
	}

}
