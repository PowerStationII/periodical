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
 * 读者工作区-发送消息Controller
 * */
@Controller
public class SendMsgController extends ReaderController{
	
	private static final Logger logger = LoggerFactory.getLogger(SendMsgController.class);

}
