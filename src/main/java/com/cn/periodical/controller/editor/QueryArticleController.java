package com.cn.periodical.controller.editor;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.cn.periodical.pojo.UserInfo;
/**
 * 稿件编辑-稿件查询Controller for editor
 * */
@Controller
public class QueryArticleController extends EditorController{
	
	private static final Logger logger = LoggerFactory.getLogger(QueryArticleController.class);
	/**
	 * toQueryArticlePage
	 * 编辑稿件查询
	 */
	@RequestMapping(value="/toQueryArticlePage",method = RequestMethod.GET)
	public ModelAndView toQueryArticlePage(HttpServletRequest request) {
		UserInfo userInfo = getUserInfo(request);
		logger.info("稿件查询Page:["+userInfo.getUserId()+"]");
		ModelAndView mav = new ModelAndView("editor_queryArticlePage");

		
		
		
		
		return mav;
	}
}
