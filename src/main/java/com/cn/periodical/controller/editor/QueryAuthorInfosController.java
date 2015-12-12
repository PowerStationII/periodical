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

import com.cn.periodical.manager.AddressInfoManager;
import com.cn.periodical.manager.AuthorInfoManager;
import com.cn.periodical.pojo.AddressInfo;
import com.cn.periodical.pojo.AddressInfoQuery;
import com.cn.periodical.pojo.AuthorInfo;
import com.cn.periodical.pojo.AuthorInfoQuery;
/**
 * 系统作者信息Controller
 * */
@Controller
public class QueryAuthorInfosController extends EditorController{
	
	private static final Logger logger = LoggerFactory.getLogger(QueryAuthorInfosController.class);
	@Autowired
	AuthorInfoManager authorInfoManager;
	
	@Autowired
	AddressInfoManager addressInfoManager;
	
	/**
	 * toQueryAuthorInfosPage
	 * 查看系统作者信息
	 */
	@RequestMapping(value="/toQueryAuthorInfosPage")
	public ModelAndView toQueryAuthorInfosPage(HttpServletRequest request,@ModelAttribute AuthorInfoQuery authorInfoQuery) {
		ModelAndView mav = new ModelAndView("editor_authorInfosPage");
		
		List<AuthorInfo> authorInfos = authorInfoManager.queryList(authorInfoQuery);
		
		mav.addObject("list", authorInfos);
		return mav;
	}
	
	
	@RequestMapping(value="/toQueryAuthorInfoDetailPage")
	public ModelAndView toQueryAuthorInfoDetailPage(HttpServletRequest request,String authorId) {
		ModelAndView mav = new ModelAndView("editor_authorInfoDetailPage");
		AuthorInfoQuery authorInfoQuery = new AuthorInfoQuery();
		authorInfoQuery.setAuthorId(authorId);
		List<AuthorInfo> authorInfos = authorInfoManager.queryList(authorInfoQuery);
		AuthorInfo authorInfo = authorInfos.get(0);
		mav.addObject("authorInfo", authorInfo);
		AddressInfoQuery addressInfQuery = new AddressInfoQuery();
		addressInfQuery.setRefId(authorId);
		List<AddressInfo> addressInfos = addressInfoManager.queryList(addressInfQuery);
		AddressInfo addressInfo = addressInfos.get(0);
		mav.addObject("addressInfo", addressInfo);
		return mav;
	}

}
