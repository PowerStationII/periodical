package com.cn.periodical.controller.editor;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.cn.periodical.request.EditorAdCouncilManagerReqDto;
/**
 * 广告编辑-广告管理Controller
 * */
@Controller
public class AdManageController extends EditorController{
	
	private static final Logger logger = LoggerFactory.getLogger(AdManageController.class);
	/**
	 * toAdManagerPage
	 * 广告管理
	 */
	@RequestMapping(value="/toAdManagerPage",method = RequestMethod.GET)
	public ModelAndView toAdManagerPage(@RequestParam("userId") String userId,
			HttpServletRequest request) {
		logger.info("广告管理Page:["+userId+"]");
		ModelAndView mav = new ModelAndView("editor_adManagerPage");
		mav.addObject("userId", userId);
		
		
		return mav;
	}
	
	
	@RequestMapping(value = "/toAdInfoAdd", method = RequestMethod.GET)
	public ModelAndView toAdInfoAdd() {
		ModelAndView mav = new ModelAndView("editor_adManagerDetailPage");

		return mav;
	}
	
	/**
	 * 保存数据
	 */
	@RequestMapping(value = "/toSaveAdInfo", method = { RequestMethod.POST })
	public ModelAndView saveAdInfo(@ModelAttribute EditorAdCouncilManagerReqDto councilInfo) {
		ModelAndView mav = new ModelAndView("redirect:../editor/toAdManagerPage");
		mav.addObject("userId", "ad");
		logger.info("保存广告信息入参:["+JSON.toJSONString(councilInfo)+"]");
		try {
//			adCouncilManagerService.saveCouncilInfo(councilInfo);
			return mav;
		} catch (Exception e) {
			//记录错误日志
			logger.error("保存广告信息异常!", e);
			return new ModelAndView("error");
		}
		
	}
}
