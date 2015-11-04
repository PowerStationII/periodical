package com.cn.periodical.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/portal")
public class PortalController {
	
	private static final Logger logger = LoggerFactory.getLogger(PortalController.class);
	/**
	 * 跳转到添加页面
	 */
	@RequestMapping(method = RequestMethod.GET)
	public String toPortalPage() {
		
		return "portal";
	}
}
