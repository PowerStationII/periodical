package com.cn.periodical.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


/**
 * 登录Controller
 */
@Controller
public class RightController {

	private static final Logger logger = LoggerFactory.getLogger(RightController.class);

	/**
	 * 跳转到右上1写死页面
	 */
	@RequestMapping(value="/toRightTop1",method = RequestMethod.GET)
	public String toRightTop1Page() {
		return "link/right_top1";
	}
	
	/**
	 * 跳转到右上2写死页面
	 */
	@RequestMapping(value="/toRightTop2",method = RequestMethod.GET)
	public String toRightTop2Page() {
		return "link/right_top2";
	}
	
	/**
	 * 跳转到右上3写死页面
	 */
	@RequestMapping(value="/toRightTop3",method = RequestMethod.GET)
	public String toRightTop3Page() {
		return "link/right_top3";
	}
	
	/**
	 * 跳转到右中1写死页面
	 */
	@RequestMapping(value="/toRightMiddle1",method = RequestMethod.GET)
	public String toRightMiddle1Page() {
		return "link/right_middle1";
	}
	
	/**
	 * 跳转到右中2写死页面
	 */
	@RequestMapping(value="/toRightMiddle2",method = RequestMethod.GET)
	public String toRightMiddle2Page() {
		return "link/right_middle2";
	}
	
	/**
	 * 跳转到右中3写死页面
	 */
	@RequestMapping(value="/toRightMiddle3",method = RequestMethod.GET)
	public String toRightMiddle3Page() {
		return "link/right_middle3";
	}
	
	/**
	 * 跳转到右中4写死页面
	 */
	@RequestMapping(value="/toRightMiddle4",method = RequestMethod.GET)
	public String toRightMiddle4Page() {
		return "link/right_middle4";
	}
	
	/**
	 * 跳转到右中5写死页面
	 */
	@RequestMapping(value="/toRightMiddle5",method = RequestMethod.GET)
	public String toRightMiddle5Page() {
		return "link/right_middle5";
	}
	
	/**
	 * 跳转到右中6写死页面
	 */
	@RequestMapping(value="/toRightMiddle6",method = RequestMethod.GET)
	public String toRightMiddle6Page() {
		return "link/right_middle6";
	}
	
}
