package com.cn.periodical.controller.reader;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
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

import com.cn.periodical.enums.OrderStatusEnums;
import com.cn.periodical.manager.OrderInfoManager;
import com.cn.periodical.manager.PayerInfoManager;
import com.cn.periodical.pojo.BizOrder;
import com.cn.periodical.pojo.OrderInfo;
import com.cn.periodical.pojo.OrderInfoQuery;
import com.cn.periodical.pojo.PayerInfo;
import com.cn.periodical.pojo.UserInfo;
/**
 * 读者工作区-订费登记Controller
 * */
import com.cn.periodical.utils.PropertiesInitManager;
@Controller
public class OrderPayController extends ReaderController{
	
	@Autowired
	OrderInfoManager orderInfoManager;
	@Autowired
	PayerInfoManager payerInfoManager;
	
	private static final Logger logger = LoggerFactory.getLogger(OrderPayController.class);
	/**
	 * toOrderPayPage
	 * 征订费登记
	 */
	@RequestMapping(value="/toOrderPayPage",method = RequestMethod.GET)
	public ModelAndView toCreatOrderPage(HttpServletRequest request,@RequestParam("orderNo") String orderNo) {
		UserInfo userInfo = getUserInfo(request);
		logger.info("征订费登记Page:["+userInfo.getUserId()+"]&orderNo["+orderNo+"]");
		ModelAndView mav = new ModelAndView("reader_orderPayPage");
		BizOrder bizOrder = new BizOrder();
		bizOrder.setUserId(userInfo.getUserId());
		bizOrder.setOrderNo(orderNo);
		List<BizOrder> bizOrders = orderInfoManager.queryPayInfoLists(bizOrder);
		mav.addObject("list", bizOrders);
		mav.addObject("orderNo", orderNo);
		return mav;
	}
	
	/**
	 * toAddPayerInfoPage
	 * 订单付款信息页
	 */
	@RequestMapping(value="/toAddPayerInfoPage")
	public ModelAndView toAddPayerInfoPage(HttpServletRequest request,@RequestParam("orderNo") String orderNo) {
		UserInfo userInfo = getUserInfo(request);
		logger.info("订单付款信息 Page in:["+orderNo+"]");
		ModelAndView mav = new ModelAndView("reader_addPayerInfoPage");
		BizOrder bizOrder = new BizOrder();
		bizOrder.setUserId(userInfo.getUserId());
		bizOrder.setOrderNo(orderNo);
		BizOrder bo = orderInfoManager.queryOrderInfoDetail(bizOrder);
		mav.addObject("bo", bo);
		logger.info("订单付款信息 Page in:["+userInfo.getUserId()+"]");
		return mav;
	}
	
	/**
	 * toSaveOrderInfoPage
	 * 保存付款信息并更新订单信息
	 */
	@RequestMapping(value="/toSaveOrderInfoPage")
	public ModelAndView toSaveOrderInfoPage(HttpServletRequest request,
			@RequestParam("orderNo") String orderNo,MultipartFile file,
			@ModelAttribute PayerInfo payerInfo) {
		UserInfo userInfo = getUserInfo(request);
		logger.info("订单付款信息 Page in:["+orderNo+"]");
		ModelAndView mav = new ModelAndView("redirect:../reader/toOrderPayPage");
		mav.addObject("orderNo", orderNo);
		OrderInfoQuery query= new OrderInfoQuery();
		query.setOrderNo(orderNo);
		List<OrderInfo> orderInfos = orderInfoManager.queryList(query);
		/**
		 * 如果订单号能查出来两条要报错
		 * */
		OrderInfo orderInfo = orderInfos.get(0);
		if(payerInfo.getPayAmount()==orderInfo.getAmount()){
			orderInfo.setOrderStatus(OrderStatusEnums.ALL.getCode());
		}else if(orderInfo.getAmount()>payerInfo.getPayAmount()){
			orderInfo.setOrderStatus(OrderStatusEnums.PART.getCode());
		}
		long pay = orderInfo.getAlreadyPayAmount()==null?0:orderInfo.getAlreadyPayAmount();
		orderInfo.setAlreadyPayAmount(pay+payerInfo.getPayAmount());
		orderInfo.setId(orderInfo.getId());
		orderInfoManager.saveOrderInfo(orderInfo);
		String payerId=UUID.randomUUID().toString().replaceAll("-", "");
		/**
		 * 先上传
		 */
		PropertiesInitManager.dataInit();
    	String basePath = PropertiesInitManager.PROPERTIES.getProperty("pzUploadPath");
    	StringBuffer sbPath = new StringBuffer();
    	sbPath.append(basePath);
    	sbPath.append(File.separator);
    	sbPath.append(userInfo.getUserId());
    	sbPath.append(File.separator);
    	sbPath.append(orderNo);
    	sbPath.append(File.separator);
    	String filePath = sbPath.toString();
    	File headPath = new File(filePath);//获取文件夹路径       
    	if(!headPath.exists()){
    	//判断文件夹是否创建，没有创建则创建新文件夹        	
    		headPath.mkdirs();
    	}
    	String fileName = filePath + payerId + file.getOriginalFilename();
    	logger.info("上传路径为："+ fileName);
    	File uploadFile = new File(fileName); 
        // 转存文件  
        try {
			file.transferTo(uploadFile);
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
        logger.info(uploadFile.getAbsolutePath());
   
		
		payerInfo.setPayerId(payerId);
		payerInfo.setOrderNo(orderNo);
		payerInfo.setCreateTime(new Date());
		payerInfo.setDraftName(payerId + file.getOriginalFilename());
		payerInfo.setDraftUrl(uploadFile.getAbsolutePath());
		payerInfoManager.savePayerInfo(payerInfo);
		logger.info("订单付款信息 Page in:["+userInfo.getUserId()+"]");
		return mav;
	}
}
