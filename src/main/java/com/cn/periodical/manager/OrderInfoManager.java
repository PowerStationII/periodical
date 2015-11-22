/*
 * Powered By code-generator
 * Since 2015 - 2015
 */

package com.cn.periodical.manager;

import java.util.List;

import com.cn.periodical.pojo.BizOrder;
import com.cn.periodical.pojo.OrderInfo;
import com.cn.periodical.pojo.OrderInfoPage;
import com.cn.periodical.pojo.OrderInfoQuery;

public interface OrderInfoManager {
	void saveOrderInfo(OrderInfo orderInfo);

	OrderInfo findOrderInfoById(Long id);
	
	List<OrderInfo> queryList(OrderInfoQuery query);
	
	void deleteOrderInfoById(Long id);
	
	void deleteOrderInfo(OrderInfoQuery query);
	
	OrderInfoPage queryPageList(OrderInfoQuery query);
	
	List<BizOrder> queryOrderList(BizOrder bizOrder);
	
	
	List<BizOrder> queryPayInfoLists(BizOrder bizOrder);
	public List<BizOrder> editorQryOrderInfos(BizOrder bizOrder);
	BizOrder queryOrderInfoDetail(BizOrder bizOrder);
	
}
