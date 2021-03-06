/*
 * Powered By code-generator
 * Since 2015 - 2015
 */

package com.cn.periodical.manager;

import java.util.List;

import com.cn.periodical.pojo.*;

public interface OrderInfoManager {
	void saveOrderInfo(OrderInfo orderInfo);
	void updateByOrderNo(OrderInfo orderInfo);

	OrderInfo findOrderInfoById(Long id);
	
	List<OrderInfo> queryList(OrderInfoQuery query);
	
	void deleteOrderInfoById(Long id);
	
	void deleteOrderInfo(OrderInfoQuery query);
	
	OrderInfoPage queryPageList(OrderInfoQuery query);
	
	List<BizOrder> queryOrderList(BizOrder bizOrder);

    public int queryOrderListQueryCount(BizOrderQuery bizOrder);
    public BizOrderPage queryOrderListQuery(BizOrderQuery query , int itemCount);
	
	
	List<BizOrder> queryPayInfoLists(BizOrder bizOrder);
	public List<BizOrder> editorQryOrderInfos(BizOrder bizOrder);
	public FaXingOrderPage editorQryOrderInfosPage(BizOrderQuery bizOrder , int count);
	public int editorQryOrderInfosPageCount(BizOrderQuery bizOrder );
	BizOrder queryOrderInfoDetail(BizOrder bizOrder);
	
}
