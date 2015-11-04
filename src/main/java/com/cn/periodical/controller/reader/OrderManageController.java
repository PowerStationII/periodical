package com.cn.periodical.controller.reader;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
/**
 * 读者工作区-期刊征订-订单管理Controller
 * */
@Controller
public class OrderManageController extends ReaderController{
	
	private static final Logger logger = LoggerFactory.getLogger(OrderManageController.class);
	/**
	 * toOrderManagePage
	 * 订单管理页面
	 */
	@RequestMapping(value="/toOrderManagePage",method = RequestMethod.GET)
	public ModelAndView toKeyWordsSearchPage(@RequestParam("userId") String userId) {
		logger.info("订单管理Page:["+userId+"]");
		ModelAndView mav = new ModelAndView("reader_orderManagePage");
		mav.addObject("userId", userId);
		
		
		
		
		
		return mav;
	}
	
	/**
	 * toCreatOrderPage
	 * 新建订单页面
	 */
	@RequestMapping(value="/toCreatOrderPage",method = RequestMethod.GET)
	public ModelAndView toCreatOrderPage(@RequestParam("userId") String userId) {
		logger.info("新建订单Page:["+userId+"]");
		ModelAndView mav = new ModelAndView("reader_creatOrderPage");
		mav.addObject("userId", userId);
		
		
		
		
		
		return mav;
	}
}
