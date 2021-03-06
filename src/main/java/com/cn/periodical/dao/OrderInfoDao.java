/*
 * Powered By code-generator
 * Since 2015 - 2015
 */

package com.cn.periodical.dao;

import java.util.List;

import com.cn.periodical.pojo.BizOrder;
import com.cn.periodical.pojo.BizOrderQuery;
import com.cn.periodical.pojo.OrderInfo;
import com.cn.periodical.pojo.OrderInfoQuery;

public interface OrderInfoDao {
	int countByExample(OrderInfoQuery example);
	
	int deleteByExample(OrderInfoQuery example);
	
	int deleteByPrimaryKey(Long id);
	
	int insert(OrderInfo record);
	
	int insertSelective(OrderInfo record);
	
	List<OrderInfo> selectByExample(OrderInfoQuery example);
	
	List<OrderInfo> selectPageByExample(OrderInfoQuery example);
	List<BizOrder> queryOrderList(BizOrder bizOrder);

    public int queryOrderListQueryCount(BizOrderQuery bizOrder) ;
    public List<BizOrder> queryOrderListQuery(BizOrderQuery bizOrder) ;
	
	OrderInfo selectByPrimaryKey(Long id);
	
	int updateByPrimaryKeySelective(OrderInfo record);
	
	int updateByPrimaryKey(OrderInfo record);
	int updateByOrderNo(OrderInfo record);

	List<BizOrder> queryPayInfoLists(BizOrder bizOrder);
	List<BizOrder> editorQryOrderInfos(BizOrder bizOrder);
	List<BizOrder> editorQryOrderInfosPage(BizOrderQuery bizOrder);
	int editorQryOrderInfosPageCount(BizOrderQuery bizOrder);
	BizOrder queryOrderInfoDetail(BizOrder bizOrder);
}
