package com.cn.periodical.controller.editor;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
/**
 * 业务统计Controller
 * 稿件统计|发行统计|财务统计|理事会与广告
 * */
@Controller
public class StatisticsController extends EditorController{
	
	private static final Logger logger = LoggerFactory.getLogger(StatisticsController.class);
	/**
	 * toArtilceStatisticsPage
	 * 稿件统计
	 */
	@RequestMapping(value="/toArtilceStatisticsPage",method = RequestMethod.GET)
	public ModelAndView toArtilceStatisticsPage(@RequestParam("userId") String userId,
			HttpServletRequest request) {
		logger.info("稿件统计Page:["+userId+"]");
		ModelAndView mav = new ModelAndView("editor_artilceStatisticsPage");
		mav.addObject("userId", userId);
		
		
		return mav;
	}
	
	/**
	 * toSubscribeStatisticsPage
	 * 发行统计
	 */
	@RequestMapping(value="/toSubscribeStatisticsPage",method = RequestMethod.GET)
	public ModelAndView toSubscribeStatisticsPage(@RequestParam("userId") String userId,
			HttpServletRequest request) {
		logger.info("发行统计Page:["+userId+"]");
		ModelAndView mav = new ModelAndView("editor_subscribeStatisticsPage");
		mav.addObject("userId", userId);
		
		
		return mav;
	}
	
	/**
	 * toFinanceStatisticsPage
	 * 财务统计
	 */
	@RequestMapping(value="/toFinanceStatisticsPage",method = RequestMethod.GET)
	public ModelAndView toFinanceStatisticsPage(@RequestParam("userId") String userId,
			HttpServletRequest request) {
		logger.info("财务统计Page:["+userId+"]");
		ModelAndView mav = new ModelAndView("editor_financeStatisticsPage");
		mav.addObject("userId", userId);
		
		
		return mav;
	}
	
	/**
	 * toAdStatisticsPage
	 * 理事会与广告统计
	 */
	@RequestMapping(value="/toAdStatisticsPage",method = RequestMethod.GET)
	public ModelAndView toAdStatisticsPage(@RequestParam("userId") String userId,
			HttpServletRequest request) {
		logger.info("广告统计Page:["+userId+"]");
		ModelAndView mav = new ModelAndView("editor_adStatisticsPage");
		mav.addObject("userId", userId);
		
		
		return mav;
	}
}
