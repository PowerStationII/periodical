package com.cn.periodical.controller.editor;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.cn.periodical.manager.OrderInfoManager;
import com.cn.periodical.manager.PayerInfoManager;
import com.cn.periodical.pojo.BizOrder;
import com.cn.periodical.pojo.PayerInfo;
import com.cn.periodical.pojo.PayerInfoQuery;
/**
 * 发行编辑-订单管理Controller
 * */
@Controller
public class SubscribeOrderManageController extends EditorController{
	
	private static final Logger logger = LoggerFactory.getLogger(SubscribeOrderManageController.class);
	@Autowired
	OrderInfoManager orderInfoManager;
	@Autowired
	PayerInfoManager payerInfoManager;
	
	/**
	 * toSubOrderManagePage
	 * 订单管理
	 */
	@RequestMapping(value="/toSubOrderManagePage",method = RequestMethod.GET)
	public ModelAndView toSubOrderManagePage(HttpServletRequest request) {
		logger.info("发行编辑-订单管理Page:[ ]");
		ModelAndView mav = new ModelAndView("editor_subOrderManagePage");
		/**
		 * 发行编辑是不是只能审核已付清金额的订单
		 * */
		List<BizOrder> list = orderInfoManager.editorQryOrderInfos(null);
		mav.addObject("list", list);
		return mav;
	}
	
	/**
	 * toAuditOrderManagePage
	 * 订单审核
	 */
	@RequestMapping(value="/toAuditOrderManagePage",method = RequestMethod.GET)
	public ModelAndView toAuditOrderManagePage(HttpServletRequest request,@RequestParam("orderNo") String orderNo) {
		logger.info("发行编辑-订单审核Page:[ ]");
		ModelAndView mav = new ModelAndView("editor_auditOrderDetailPage");
		
		BizOrder bizOrder=new BizOrder();
		bizOrder.setOrderNo(orderNo);
		List<BizOrder> list = orderInfoManager.editorQryOrderInfos(bizOrder);
		mav.addObject("bo", list.get(0));
		
		PayerInfoQuery query = new PayerInfoQuery();
		List<PayerInfo> payerInfos=payerInfoManager.queryList(query);
		mav.addObject("list", payerInfos);
		
		return mav;
	}
}
