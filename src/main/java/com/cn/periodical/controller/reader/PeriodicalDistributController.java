package com.cn.periodical.controller.reader;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.cn.periodical.enums.OrderStatusEnums;
import com.cn.periodical.manager.OrderInfoManager;
import com.cn.periodical.manager.PayerInfoManager;
import com.cn.periodical.pojo.BizOrder;
import com.cn.periodical.pojo.OrderInfo;
import com.cn.periodical.pojo.OrderInfoQuery;
import com.cn.periodical.pojo.PayerInfo;
import com.cn.periodical.pojo.UserInfo;
/**
 * 读者工作区-邮寄地址管理Controller
 * */
@Controller
public class PeriodicalDistributController extends ReaderController{
	
	
	private static final Logger logger = LoggerFactory.getLogger(PeriodicalDistributController.class);
	/**
	 * toDistributPage
	 * 邮寄地址管理
	 */
	@RequestMapping(value="/toDistributPage")
	public ModelAndView toDistributPage(HttpServletRequest request) {
		UserInfo userInfo = getUserInfo(request);
		logger.info("邮寄地址管理 Page in:["+userInfo.getUserId()+"]");
		ModelAndView mav = new ModelAndView("reader_distributAddressInfoPage");
		BizOrder bizOrder = new BizOrder();
		bizOrder.setUserId(userInfo.getUserId());
//		bizOrder.setOrderNo(orderNo);
//		List<BizOrder> bizOrders = orderInfoManager.queryPayInfoLists(bizOrder);
//		mav.addObject("list", bizOrders);
//		mav.addObject("orderNo", orderNo);
		return mav;
	}
}
