package com.cn.periodical.controller.editor;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSONObject;
import com.cn.periodical.enums.ArticleStateEnums;
import com.cn.periodical.pojo.*;
import com.cn.periodical.request.ArticleQueryReqDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.cn.periodical.manager.AddressInfoManager;
import com.cn.periodical.manager.OrderInfoManager;
import com.cn.periodical.manager.PayerInfoManager;
import com.cn.periodical.manager.PeriodicalDistributManager;
import com.cn.periodical.utils.UtilLoad;
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
	@Autowired
	AddressInfoManager addressInfoManager;
	@Autowired
	PeriodicalDistributManager periodicalDistributManager;
	
	
//	/**
//	 * toSubOrderManagePage
//	 * 订单管理
//	 */
//	@RequestMapping(value="/toSubOrderManagePage",method = RequestMethod.GET)
//	public ModelAndView toSubOrderManagePage(HttpServletRequest request) {
//		logger.info("发行编辑-订单管理Page:[ ]");
//		ModelAndView mav = new ModelAndView("editor_subOrderManagePage");
//		/**
//		 * 发行编辑是不是只能审核已付清金额的订单
//		 * */
//		List<BizOrder> list = orderInfoManager.editorQryOrderInfos(null);
//		mav.addObject("list", list);
//		return mav;
//	}
	/**
	 * toSubOrderManagePage
	 * 订单管理
	 */
	@RequestMapping(value="/toSubOrderManagePage",method = RequestMethod.GET)
	public ModelAndView toSubOrderManagePage(HttpServletRequest request) {
		logger.info("发行编辑-订单管理Page:[ ]");
		ModelAndView mav = new ModelAndView("editor_subOrderManagePage");
		return mav;
	}
	/**
	 * toSubOrderManagePage
	 * 订单管理
	 */
	@RequestMapping(value="/toSubOrderManagePageSet")
    @ResponseBody
    public JSONObject toSubOrderManagePageSet(HttpServletRequest request,HttpServletResponse response,
                                              @ModelAttribute BizOrderQuery query,
                                              @RequestParam(required = false, value = "page", defaultValue = "1") int page,
                                              @RequestParam(required = false, value = "rows", defaultValue = "10") int rows) {
		logger.info("发行编辑-订单管理Page:[ ]");


        // 返回给页面的一个json
        JSONObject json = new JSONObject();
        /**
         * 查询总数
         */
        int count = orderInfoManager.editorQryOrderInfosPageCount(query);
        json.put("total", count);
        logger.info("+++++++++"+count);

        query.setPageSize((page-1)*rows);//开始
        query.setPageNo(rows);//截止

        logger.info("已登记Page出参 in:["+JSON.toJSONString(query)+"]");
        /**
         * 发行编辑是不是只能审核已付清金额的订单
         * */
        FaXingOrderPage faXingOrderPage = orderInfoManager.editorQryOrderInfosPage(query,count);
        json.put("rows", faXingOrderPage.getValues());

        logger.info("已登记Page出参 out:[]");
        return json;
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
		query.setOrderNo(orderNo);
		List<PayerInfo> payerInfos=payerInfoManager.queryList(query);
		mav.addObject("list", payerInfos);
		logger.info("----------------------");
		logger.info(JSON.toJSONString(payerInfos));
		return mav;
	}
	
	/**
	 * toAuditOrderManage
	 * 审核
	 */
	@RequestMapping(value="/toAuditOrderManagePage")
	public ModelAndView toAuditOrderManage(HttpServletRequest request) {
		logger.info("发行编辑-审核Page:[ ]");
		ModelAndView mav = new ModelAndView("redirect:../editor/toSubOrderManagePage");
		String orderNo = request.getParameter("orderNo");
		String opinion = request.getParameter("opinion");
		OrderInfoQuery query = new OrderInfoQuery();
		query.setOrderNo(orderNo);
		List<OrderInfo> orderInfos = orderInfoManager.queryList(query);
		OrderInfo orderInfo = orderInfos.get(0);
		orderInfo.setId(orderInfo.getId());
		orderInfo.setExtend1(opinion);
		orderInfo.setAuditTime(new Date());
        orderInfo.setOrderStatus("Y");
		orderInfoManager.saveOrderInfo(orderInfo);
		return mav;
	}
	
	/**
	 * toSubSupplementManagePage
	 * 发行编辑编辑订单赠刊信息
	 */
	@RequestMapping(value="/toSubSupplementManagePage")
	public ModelAndView toSubSupplementManagePage(HttpServletRequest request,String orderNo
            ,String periodicalId
            ,String year ) {
		logger.info("编辑订单赠刊信息 Page:orderNo:[ "+orderNo+" ]");
		ModelAndView mav = new ModelAndView("editor_toSubOrderDetailPage");
		/**
		 * 编辑读者订单的赠刊信息,编辑信息保存至
		 * periodical_distribute表
		 * */
		BizDistribut distribut =  new BizDistribut();
		distribut.setOrderNo(orderNo);
		List<BizDistribut> list = addressInfoManager.queryAddressListForSubEditor(distribut);
		mav.addObject("list", list);
		mav.addObject("orderNo", orderNo);
		mav.addObject("periodicalId", periodicalId);
		mav.addObject("year", year);
        if(null!=list && !list.isEmpty()){
            mav.addObject("pId",list.get(0).getpId()) ;
        }

		return mav;
	}
	
	
	/**
	 * toSubSupplement
	 * 保存增刊信息
	 */
	@RequestMapping(value="/toSubSupplement")
	public ModelAndView toSubSupplement(HttpServletRequest request,String array,String orderNo) {
		logger.info("---------------" + "array:" + array + "------orderNo:" + orderNo);
		ModelAndView mav = new ModelAndView("redirect:../editor/toSubOrderManagePage");
		/**
		 * 编辑读者订单的赠刊信息,编辑信息保存至
		 * periodical_distribute表
		 * */
		JSONArray arr = (JSONArray) JSONArray.parse(array);
		for(int i=0;i<arr.size();i++){
			PeriodicalDistributQuery query = new PeriodicalDistributQuery();
			query.setRefId(orderNo);
			query.setAddressId(arr.getJSONObject(i).getString("aId"));
			List<PeriodicalDistribut> pds = periodicalDistributManager.queryList(query);
			logger.info(pds.size()+"");
			PeriodicalDistribut pd = pds.get(0);
			pd.setId(pd.getId());
			pd.setDistributeNums(Integer.valueOf(arr.getJSONObject(i).getString("dNums")));
			pd.setSupplementId1("111");
			pd.setSupplementId1Nums(Integer.valueOf(arr.getJSONObject(i).getString("sIdNums1")));
			pd.setSupplementId2("222");
			pd.setSupplementId2Nums(Integer.valueOf(arr.getJSONObject(i).getString("sIdNums2")));
			pd.setSupplementId3("333");
			pd.setSupplementId3Nums(Integer.valueOf(arr.getJSONObject(i).getString("sIdNums3")));
			periodicalDistributManager.savePeriodicalDistribut(pd);
		}
		return mav;
	}

    /**
     * toSubSupplement
     * 保存赠刊信息
     */
    @RequestMapping(value="/toSaveZeng4Kan")
    public ModelAndView toSaveZeng4Kan(HttpServletRequest request,String array,String orderNo) {
        logger.info("---------------" + "array:" + array + "------orderNo:" + orderNo);
        ModelAndView mav = new ModelAndView("redirect:../editor/toSubOrderManagePage");
        /**
         * 编辑读者订单的赠刊信息,编辑信息保存至
         * periodical_distribute表
         * */
        JSONArray arr = (JSONArray) JSONArray.parse(array);
        for(int i=0;i<arr.size();i++){
            PeriodicalDistributQuery query = new PeriodicalDistributQuery();
            query.setRefId(orderNo);
            query.setAddressId(arr.getJSONObject(i).getString("aId"));
            List<PeriodicalDistribut> pds = periodicalDistributManager.queryList(query);
            logger.info(pds.size()+"");
            PeriodicalDistribut pd = pds.get(0);
            pd.setId(pd.getId());
            pd.setDistributeNums(Integer.valueOf(arr.getJSONObject(i).getString("dNums")));
            pd.setSupplementId1("111");
            pd.setSupplementId1Nums(Integer.valueOf(arr.getJSONObject(i).getString("sIdNums1")));
            pd.setSupplementId2("222");
            pd.setSupplementId2Nums(Integer.valueOf(arr.getJSONObject(i).getString("sIdNums2")));
            pd.setSupplementId3("333");
            pd.setSupplementId3Nums(Integer.valueOf(arr.getJSONObject(i).getString("sIdNums3")));
            periodicalDistributManager.savePeriodicalDistribut(pd);
        }
        return mav;
    }

	/**
	 * toPzDownloadPage
	 * 发行编辑编辑订单赠刊信息
	 */
	@RequestMapping(value="/toPzDownloadPage")
	@ResponseBody
	public String toPzDownloadPage(HttpServletRequest request,HttpServletResponse response,String filePath,String fileName) {
		logger.info("----" + filePath + "====" + fileName);
		
		UtilLoad.fileDownload(request, response, fileName, filePath.replace(fileName, ""));
		return "";
	}
	
}
