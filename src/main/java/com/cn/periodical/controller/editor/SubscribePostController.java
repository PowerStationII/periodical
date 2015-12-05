package com.cn.periodical.controller.editor;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.cn.periodical.manager.AddressInfoManager;
import com.cn.periodical.manager.BizOrderManager;
import com.cn.periodical.manager.OrderInfoManager;
import com.cn.periodical.pojo.BizDistribut;
import com.cn.periodical.pojo.BizOrder;
import com.cn.periodical.pojo.UserInfo;
/**
 * 发行编辑-期刊邮寄Controller
 * */
@Controller
public class SubscribePostController extends EditorController{
	
	private static final Logger logger = LoggerFactory.getLogger(SubscribePostController.class);
	
	@Autowired
	AddressInfoManager addressInfoManager;
	
	@Autowired
	OrderInfoManager orderInfoManager;
	@Autowired
	BizOrderManager bizOrderManager;
	/**
	 * toSubscribePostPage
	 * 邮寄管理
	 */
	@RequestMapping(value="/toSubscribePostPage",method = RequestMethod.GET)
	public ModelAndView toSubscribePostPage(HttpServletRequest request) {
		UserInfo userInfo = getUserInfo(request);
		logger.info("发行编辑-邮寄管理Page:["+userInfo.getUserId()+"]");
		ModelAndView mav = new ModelAndView("editor_subscribePostPage");
		/**
		 * 订单信息
		 * */
		List<BizOrder> list = bizOrderManager.queryOrderInfosForSubEditor(null);
		mav.addObject("list", list);
		return mav;
	}
	
	
	/**
	 * toReaderAddressInfoDetails
	 * 读者订阅地址及信息明细
	 */
	@RequestMapping(value="/toReaderAddressInfoDetails")
	public ModelAndView toReaderAddressInfoDetails(HttpServletRequest request,
			String orderNo,String periodicalId,String periodicalIssueNo) {
		UserInfo userInfo = getUserInfo(request);
		logger.info("发行编辑-查看读者订阅地址信息Page:["+userInfo.getUserId()+"]orderNo:["+orderNo+"]"
				+ "periodicalId:["+periodicalId+"]"
				+ "periodicalIssueNo:["+periodicalIssueNo+"]");
		ModelAndView mav = new ModelAndView("editor_subscribePostDetailPage");
		
		BizDistribut distribut =  new BizDistribut();
		distribut.setOrderNo(orderNo);
		distribut.setpId(periodicalId);
		distribut.setpIsNo(periodicalIssueNo);
		List<BizDistribut> list = addressInfoManager.exportReaderAddressInfos(distribut);
		mav.addObject("list", list);
		
		return mav;
	}
	
	/**
	 * toExportReaderAddressInfo
	 * 导出读者订阅地址及信息
	 * periodical_distribute表
	 */
	@RequestMapping(value="/toExportReaderAddressInfo")
	public ModelAndView toExportReaderAddressInfo(HttpServletRequest request) {
		UserInfo userInfo = getUserInfo(request);
		logger.info("发行编辑-导出读者订阅地址信息Page:["+userInfo.getUserId()+"]");
		ModelAndView mav = new ModelAndView("editor_subscribePostPage");
		
//		BizDistribut distribut =  new BizDistribut();
//		distribut.setOrderNo(orderNo);
//		List<BizDistribut> list = addressInfoManager.exportReaderAddressInfos(distribut);
//		mav.addObject("list", list);
//		mav.addObject("orderNo", orderNo);
		
		return mav;
	}
	
	/**
	 * toExportAuthorAddressInfo
	 * 导出作者订阅地址及信息
	 * author_info&address_info表
	 */
	@RequestMapping(value="/toExportAuthorAddressInfo")
	public ModelAndView toExportAuthorAddressInfo(HttpServletRequest request) {
		UserInfo userInfo = getUserInfo(request);
		logger.info("发行编辑-导出作者订阅信息Page:["+userInfo.getUserId()+"]");
		ModelAndView mav = new ModelAndView("editor_subscribePostPage");
		
		
		return mav;
	}
}
