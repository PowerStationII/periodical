package com.cn.periodical.controller.reader;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.cn.periodical.enums.OrderStatusEnums;
import com.cn.periodical.manager.AddressInfoManager;
import com.cn.periodical.manager.OrderInfoManager;
import com.cn.periodical.manager.PayeeInfoManager;
import com.cn.periodical.manager.PeriodicalDistributManager;
import com.cn.periodical.manager.PeriodicalInfoManager;
import com.cn.periodical.manager.UserInfoManager;
import com.cn.periodical.pojo.AddressInfo;
import com.cn.periodical.pojo.AddressInfoQuery;
import com.cn.periodical.pojo.BizDistribut;
import com.cn.periodical.pojo.BizOrder;
import com.cn.periodical.pojo.OrderInfo;
import com.cn.periodical.pojo.OrderInfoQuery;
import com.cn.periodical.pojo.PayeeInfo;
import com.cn.periodical.pojo.PayeeInfoQuery;
import com.cn.periodical.pojo.PeriodicalDistribut;
import com.cn.periodical.pojo.PeriodicalInfo;
import com.cn.periodical.pojo.PeriodicalInfoQuery;
import com.cn.periodical.pojo.UserInfo;
import com.cn.periodical.service.OrderInfoService;
import com.cn.periodical.utils.GenerateOrderNo;

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
    
    @Autowired
    AddressInfoManager addressInfoManager;
    @Autowired
    UserInfoManager userInfoManager;
    @Autowired
    PeriodicalDistributManager periodicalDistributManager;
	/**
	 * toOrderManagePage
	 * 订单管理页面
	 */
	@RequestMapping(value="/toOrderManagePage")
	public ModelAndView toOrderManagePage(HttpServletRequest request,BizOrder bizOrder) {
		UserInfo userInfo = getUserInfo(request);
		logger.info("订单管理Page:[ ]");
		bizOrder.setUserId(userInfo.getUserId());
		List<BizOrder> list = orderInfoManager.queryOrderList(bizOrder);
		ModelAndView mav = new ModelAndView("reader_orderManagePage");
		mav.addObject("list", list);
		return mav;
	}
	
//	/**
//	 * 创建完订单跳转至此页面
//	 * */
//	@RequestMapping(value="/toOrderListManagePage",method =  { RequestMethod.POST ,RequestMethod.GET})
//	public ModelAndView toOrderListManagePage(@RequestParam("userId") String userId) {
//		logger.info("订单管理Page:["+userId+"]");
//		OrderInfoQuery orderInfoQuery = new OrderInfoQuery();
//		orderInfoQuery.setUserId(userId);
//		List<OrderInfo> orderInfos = orderInfoManager.queryList(orderInfoQuery);
//		ModelAndView mav = new ModelAndView("reader_orderListManagePage");
//		mav.addObject("userId", userId);
//		mav.addObject("list", orderInfos);
//		return mav;
//	}
	
	
	/**
	 * toCreatOrderPage
	 * 新建订单页面
	 */
	@RequestMapping(value="/toCreatOrderPage")
	public ModelAndView toCreatOrderPage(HttpServletRequest request,String periodicalId,String payeeId) {
		UserInfo userInfo = getUserInfo(request);
		logger.info("新建读者订单Page:["+userInfo.getUserId()+"]&["+periodicalId+"]");
		ModelAndView mav = new ModelAndView("reader_creatOrderPage");
		PeriodicalInfoQuery periodicalInfoQuery = new PeriodicalInfoQuery();
		periodicalInfoQuery.setPeriodicalId(periodicalId);
		List<PeriodicalInfo> periodicalInfos = periodicalInfoManager.queryList(periodicalInfoQuery);
		PeriodicalInfo periodicalInfo = periodicalInfos.get(0);
		PayeeInfoQuery payeeInfoQuery = new PayeeInfoQuery();
		payeeInfoQuery.setPayeeId(payeeId);
//		payeeInfoQuery.setType("000");
		List<PayeeInfo> payeeInfos = payeeInfoManager.queryList(payeeInfoQuery);
		PayeeInfo payeeInfo = payeeInfos.get(0);
		mav.addObject("periodicalInfo", periodicalInfo);
		mav.addObject("payeeInfo", payeeInfo);
		return mav;
	}
	
	/**
	 * toCreatOrder
	 * 订阅
	 */
	@RequestMapping(value="/toCreatOrder",method ={ RequestMethod.POST ,RequestMethod.GET})
	public ModelAndView toCreatOrder(HttpServletRequest request,String periodicalId,String singlPrice,String periodicalYear,int orderNums) {
		UserInfo userInfo = getUserInfo(request);
		logger.info("新建读者订单Page:["+userInfo.getUserId()+"]&["+periodicalId+"]");
		ModelAndView mav = new ModelAndView("redirect:../reader/toOrderManagePage");
		OrderInfo orderInfo = new OrderInfo();
		orderInfo.setUserId(userInfo.getUserId());
		orderInfo.setOrderNo(GenerateOrderNo.generateOrderNo());
		orderInfo.setPeriodicalYear(periodicalYear);
		orderInfo.setSubscribeNums(orderNums);
		orderInfo.setOrderStatus(OrderStatusEnums.NONE.getCode());/**订单状态:N未付款订单*/
		orderInfo.setPeriodicalId(periodicalId);
		orderInfo.setAmount(Long.valueOf(orderNums*Integer.valueOf(singlPrice)));
		orderInfo.setCreateTime(new Date());
		orderInfoManager.saveOrderInfo(orderInfo);
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
		ModelAndView mav = new ModelAndView("redirect:../reader/toOrderManagePage");
		
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
    /**
     * 查看订单审核意见
     * */
    @RequestMapping(value="/queryOpinion",produces = "application/text; charset=utf-8")
    @ResponseBody
    public String queryOpinion(String orderNo,HttpServletRequest request) {
    	/**
    	 * 根据orderNo查询order_info表
    	 * 表中extend_1字段为订单审核意见
    	 * */
    	OrderInfoQuery orderInfoQuery =  new OrderInfoQuery();
		orderInfoQuery.setUserId(getUserInfo(request).getUserId());
		orderInfoQuery.setOrderNo(orderNo);
		List<OrderInfo> orderInfos = orderInfoManager.queryList(orderInfoQuery);
		OrderInfo orderInfo = orderInfos.get(0);
        return orderInfo.getExtend1();
    }
    
	/**
	 * 跳转到期刊分配页面
	 */
	@RequestMapping(value="/toDistributionPage")
	public ModelAndView toDistributionPage(HttpServletRequest request,String orderNo ) {
		logger.info("读者编辑订单-订单号:["+orderNo+"]");
		UserInfo userInfo = getUserInfo(request);
		ModelAndView mav = new ModelAndView("reader_orderDistribution");
		OrderInfoQuery orderQuery=new OrderInfoQuery();
		orderQuery.setUserId(userInfo.getUserId());
		orderQuery.setOrderNo(orderNo);
		List<OrderInfo> orderInfos = orderInfoManager.queryList(orderQuery);
		OrderInfo orderInfo = orderInfos.get(0);
		mav.addObject("orderInfo", orderInfo);
		AddressInfoQuery query = new AddressInfoQuery();
		query.setRefId(userInfo.getRefId());
		query.setRefRoleId(userInfo.getRoleId());
		List<AddressInfo> list = addressInfoManager.queryList(query);
		mav.addObject("list", list);
		return mav;
	}
	
	
	/**
	 * 期刊分配
	 */
	@RequestMapping(value="/toDistribution")
	public ModelAndView toDistribution(HttpServletRequest request,String array,String periodicalId,String orderNo) {
		UserInfo userInfo = getUserInfo(request);
		logger.info("期刊分配入参:["+array+"]");
		logger.info("读者编辑订单-订单号:["+orderNo+"]&periodicalId["+periodicalId+"]");
		JSONArray str = (JSONArray) JSONArray.parse(array);
		for (int i=0;i<str.size();i++){
			PeriodicalDistribut p = new PeriodicalDistribut();
			p.setPeriodicalId(periodicalId);
			p.setRefId(orderNo);
			p.setAddressId(str.getJSONObject(i).getString("aId"));
			p.setDistributeNums(Integer.valueOf(str.getJSONObject(i).getString("nums")==""?"0":str.getJSONObject(i).getString("nums")));
			periodicalDistributManager.savePeriodicalDistribut(p);
		}
		ModelAndView mav = new ModelAndView("redirect:../reader/toOrderManagePage");
		return mav;
	}
    
}
