package com.cn.periodical.controller.reader;

import java.util.List;

import com.cn.periodical.request.AuthorContributeReqDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.cn.periodical.manager.OrderInfoManager;
import com.cn.periodical.manager.PayeeInfoManager;
import com.cn.periodical.manager.PeriodicalInfoManager;
import com.cn.periodical.pojo.OrderInfo;
import com.cn.periodical.pojo.OrderInfoQuery;
import com.cn.periodical.pojo.PayeeInfo;
import com.cn.periodical.pojo.PayeeInfoQuery;
import com.cn.periodical.pojo.PeriodicalInfo;
import com.cn.periodical.pojo.PeriodicalInfoQuery;
import com.cn.periodical.service.OrderInfoService;
import com.cn.periodical.utils.GenerateOrderNo;

import javax.servlet.http.HttpServletRequest;

/**
 * 读者工作区-期刊征订-订单管理Controller
 * */
@Controller
public class OrderManageController extends ReaderController{
	
	private static final Logger logger = LoggerFactory.getLogger(OrderManageController.class);

    @Autowired
    OrderInfoService orderInfoService ;
    @Autowired
    PeriodicalInfoManager periodicalInfoManager;
    
    @Autowired
    OrderInfoManager orderInfoManager;
    
    @Autowired
    PayeeInfoManager payeeInfoManager;
	/**
	 * toOrderManagePage
	 * 订单管理页面
	 */
	@RequestMapping(value="/toOrderManagePage",method =  { RequestMethod.POST ,RequestMethod.GET})
	public ModelAndView toKeyWordsSearchPage(@RequestParam("userId") String userId,@RequestParam("roleId") String roleId) {
		logger.info("订单管理Page:["+userId+"]&roleId["+roleId+"]");
//		OrderInfoQuery orderInfoQuery = new OrderInfoQuery();
//		orderInfoQuery.setUserId(userId);
		List<PeriodicalInfo> periodicalInfos = periodicalInfoManager.queryList(null);
		
//		List<OrderInfo> orderInfos = orderInfoManager.queryList(orderInfoQuery);
		ModelAndView mav = new ModelAndView("reader_orderManagePage");
		mav.addObject("userId", userId);
		mav.addObject("roleId", roleId);
		mav.addObject("list", periodicalInfos);
		return mav;
	}
	
	/**
	 * 创建完订单跳转至此页面
	 * */
	@RequestMapping(value="/toOrderListManagePage",method =  { RequestMethod.POST ,RequestMethod.GET})
	public ModelAndView toOrderListManagePage(@RequestParam("userId") String userId) {
		logger.info("订单管理Page:["+userId+"]");
		OrderInfoQuery orderInfoQuery = new OrderInfoQuery();
		orderInfoQuery.setUserId(userId);
		List<OrderInfo> orderInfos = orderInfoManager.queryList(orderInfoQuery);
		ModelAndView mav = new ModelAndView("reader_orderListManagePage");
		mav.addObject("userId", userId);
		mav.addObject("list", orderInfos);
		return mav;
	}
	
	
	/**
	 * toCreatOrderPage
	 * 新建订单页面
	 */
	@RequestMapping(value="/toCreatOrderPage",method ={ RequestMethod.POST ,RequestMethod.GET})
	public ModelAndView toCreatOrderPage(String userId ,String periodicalId) {
		logger.info("新建读者订单Page:["+userId+"]&["+periodicalId+"]");
		ModelAndView mav = new ModelAndView("reader_creatOrderPage");
		PeriodicalInfoQuery periodicalInfoQuery = new PeriodicalInfoQuery();
		periodicalInfoQuery.setPeriodicalId(periodicalId);
		List<PeriodicalInfo> periodicalInfos = periodicalInfoManager.queryList(periodicalInfoQuery);
		PeriodicalInfo periodicalInfo = periodicalInfos.get(0);
		PayeeInfoQuery payeeInfoQuery = new PayeeInfoQuery();
		payeeInfoQuery.setRefId(periodicalId);
		payeeInfoQuery.setType("000");
		List<PayeeInfo> payeeInfos = payeeInfoManager.queryList(payeeInfoQuery);
		PayeeInfo payeeInfo = payeeInfos.get(0);
		mav.addObject("periodicalInfo", periodicalInfo);
		mav.addObject("payeeInfo", payeeInfo);
		mav.addObject("userId", userId);
		return mav;
	}
	
	
	/**
	 * toCreatOrder
	 * 订阅
	 */
	@RequestMapping(value="/toCreatOrder",method ={ RequestMethod.POST ,RequestMethod.GET})
	public ModelAndView toCreatOrder(String userId ,String periodicalId,String periodicalYear,int orderNums) {
		logger.info("新建读者订单Page:["+userId+"]&["+periodicalId+"]");
		ModelAndView mav = new ModelAndView("redirect:../reader/toOrderListManagePage");
		OrderInfo orderInfo = new OrderInfo();
		orderInfo.setUserId(userId);
		orderInfo.setOrderNo(GenerateOrderNo.generateOrderNo());
		orderInfo.setPeriodicalYear(periodicalYear);
		orderInfo.setSubscribeNums(orderNums);
		orderInfo.setOrderStatus("000");/**订单状态:000原始订单*/
		orderInfo.setPeriodicalId(periodicalId);
//		orderInfo.setAmount(Long.orderNums*22);
		orderInfoManager.saveOrderInfo(orderInfo);
		
		mav.addObject("userId", userId);
		return mav;
	}
	/**
	 * 去订单编辑页
	 * 只能修改订阅数等信息
	 * */
	@RequestMapping(value="/toEditorOrderPage",method ={ RequestMethod.POST ,RequestMethod.GET})
	public ModelAndView toEditorOrderPage(String userId ,String orderId) {
		logger.info("读者修改订单Page:["+userId+"]&["+orderId+"]");
		ModelAndView mav = new ModelAndView("reader_orderEditorManagePage");
		OrderInfoQuery orderInfoQuery =  new OrderInfoQuery();
		orderInfoQuery.setUserId(userId);
		orderInfoQuery.setOrderNo(orderId);
		List<OrderInfo> orderInfos = orderInfoManager.queryList(orderInfoQuery);
		
		mav.addObject("userId", userId);
		mav.addObject("orderInfo", orderInfos.get(0));
		return mav;
	}
	
	/**
	 * 修改订单
	 * */
	@RequestMapping(value="/toEditorOrder",method ={ RequestMethod.POST ,RequestMethod.GET})
	public ModelAndView toEditorOrder(String userId ,@ModelAttribute OrderInfo orderInfo) {
		logger.info("读者修改订单Page:["+userId+"]&["+JSON.toJSONString(orderInfo)+"]");
		ModelAndView mav = new ModelAndView("redirect:../reader/toOrderListManagePage");
		
		orderInfoManager.saveOrderInfo(orderInfo);
		
		mav.addObject("userId", userId);
		return mav;
	}


    @RequestMapping(value="/readEditAddress",method = RequestMethod.POST)
    public ModelAndView readEditAddress(@RequestParam(value="files", required=true) MultipartFile[] files,HttpServletRequest request) {
        ModelAndView mav = null;
        try{
            orderInfoService.insertAddressInfo(files,"er","qwe");
            return mav;
        }catch(Exception e){
            logger.info("投稿功能异常!!!!!!",e);
            mav=new ModelAndView("error");
            return mav;
        }

    }
}
