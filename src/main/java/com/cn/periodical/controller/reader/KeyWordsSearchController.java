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
 * 读者工作区-关键词检索Controller
 * */
@Controller
public class KeyWordsSearchController extends ReaderController{
	
	private static final Logger logger = LoggerFactory.getLogger(KeyWordsSearchController.class);
	/**
	 * toKeyWordsSearchPage
	 * 去关键词检索页面
	 */
	@RequestMapping(value="/toKeyWordsSearchPage",method = RequestMethod.GET)
	public ModelAndView toKeyWordsSearchPage(@RequestParam("userId") String userId) {
		logger.info("关键词检索Page:["+userId+"]");
		ModelAndView mav = new ModelAndView("reader_keyWordsSearchPage");
		mav.addObject("userId", userId);
		
		
		
		
		
		return mav;
	}
}
