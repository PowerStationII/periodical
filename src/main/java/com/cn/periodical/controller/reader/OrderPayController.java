package com.cn.periodical.controller.reader;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.cn.periodical.pojo.UserInfo;
/**
 * 读者工作区-订费登记Controller
 * */
@Controller
public class OrderPayController extends ReaderController{
	
	private static final Logger logger = LoggerFactory.getLogger(OrderPayController.class);
	/**
	 * toOrderPayPage
	 * 征订费登记
	 */
	@RequestMapping(value="/toOrderPayPage",method = RequestMethod.GET)
	public ModelAndView toCreatOrderPage(HttpServletRequest request,@RequestParam("orderNo") String orderNo) {
		UserInfo userInfo = getUserInfo(request);
		logger.info("征订费登记Page:["+userInfo.getUserId()+"]");
		ModelAndView mav = new ModelAndView("reader_orderPayPage");
		
		
		return mav;
	}
}
