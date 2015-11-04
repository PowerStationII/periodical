package com.cn.periodical.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/council")
public class CouncilController {
	
	private static final Logger logger = LoggerFactory.getLogger(CouncilController.class);
	/**
	 * 理事图片
	 */
	@RequestMapping(value="/toCouncilPic",method = RequestMethod.GET)
	public String toCouncilPic() {
		/**
		 * 查询理事会信息
		 * 制作理事会信息图片
		 * */
		
		
		return "login";
	}
	
	/**
	 * 理事会形象展示
	 */
	@RequestMapping(value="/toCouncilShow",method = RequestMethod.GET)
	public String toCouncilShow() {
		/**
		 * 查询理事会信息
		 * 理事会形象展示
		 * */
		
		
		return "login";
	}
}
