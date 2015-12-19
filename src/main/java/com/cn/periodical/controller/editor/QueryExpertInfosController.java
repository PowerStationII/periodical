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
import com.cn.periodical.manager.ExpertInfoManager;
import com.cn.periodical.manager.ExpertInfoManager;
import com.cn.periodical.pojo.AddressInfo;
import com.cn.periodical.pojo.AddressInfoQuery;
import com.cn.periodical.pojo.ExpertInfo;
import com.cn.periodical.pojo.ExpertInfoQuery;
/**
 * 系统专家信息Controller
 * */
@Controller
public class QueryExpertInfosController extends EditorController{
	
	private static final Logger logger = LoggerFactory.getLogger(QueryExpertInfosController.class);
	@Autowired
	ExpertInfoManager expertInfoManager;
	
	@Autowired
	AddressInfoManager addressInfoManager;
	
	/**
	 * toQueryExpertInfosPage
	 * 查看系统作者信息
	 */
	@RequestMapping(value="/toQuerySysExpertInfosPage")
	public ModelAndView toQueryExpertInfosPage(HttpServletRequest request,@ModelAttribute ExpertInfoQuery expertInfoQuery) {
		ModelAndView mav = new ModelAndView("editor_sys_expertInfosPage");
		
		List<ExpertInfo> expertInfos = expertInfoManager.queryList(expertInfoQuery);
		
		mav.addObject("list", expertInfos);
		return mav;
	}
	
	
	@RequestMapping(value="/toQuerySysExpertInfoDetailPage")
	public ModelAndView toQueryExpertInfoDetailPage(HttpServletRequest request,String expertId) {
		ModelAndView mav = new ModelAndView("editor_sys_expertInfosDetailPage");
		ExpertInfoQuery ExpertInfoQuery = new ExpertInfoQuery();
		ExpertInfoQuery.setExpertId(expertId);
		List<ExpertInfo> expertInfos = expertInfoManager.queryList(ExpertInfoQuery);
		ExpertInfo expertInfo = expertInfos.get(0);
		mav.addObject("expertInfo", expertInfo);
		AddressInfoQuery addressInfQuery = new AddressInfoQuery();
		addressInfQuery.setRefId(expertId);
		List<AddressInfo> addressInfos = addressInfoManager.queryList(addressInfQuery);
		if(addressInfos==null || addressInfos.size()==0){
			mav.addObject("addressInfo", "");
		}else{
			AddressInfo addressInfo = addressInfos.get(0);
			mav.addObject("addressInfo", addressInfo);
		}
		return mav;
	}

}
