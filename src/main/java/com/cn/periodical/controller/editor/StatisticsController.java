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

}
