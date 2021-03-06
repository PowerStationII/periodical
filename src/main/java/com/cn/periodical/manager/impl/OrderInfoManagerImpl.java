/*
 * Powered By code-generator
 * Since 2015 - 2015
 */

package com.cn.periodical.manager.impl;

import java.util.List;

import com.cn.periodical.pojo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.cn.periodical.dao.OrderInfoDao;
import com.cn.periodical.manager.OrderInfoManager;
import com.cn.periodical.utils.Pagenation;

@Component("orderInfoManager")
public class OrderInfoManagerImpl implements OrderInfoManager {
	
	@Autowired
	@Qualifier("orderInfoDao")
	private OrderInfoDao orderInfoDao;
	
	
	public void saveOrderInfo(OrderInfo orderInfo) {
		if (orderInfo.getId() == null) {
			orderInfoDao.insertSelective(orderInfo);
		} else {
			orderInfoDao.updateByPrimaryKeySelective(orderInfo);
		}
	}
	public void updateByOrderNo(OrderInfo orderInfo) {
        orderInfoDao.updateByOrderNo(orderInfo);
	}

	
	public OrderInfo findOrderInfoById(Long id) {
		return orderInfoDao.selectByPrimaryKey(id);
	}
	
	
	public List<OrderInfo> queryList(OrderInfoQuery query) {
		return orderInfoDao.selectByExample(query);
	}
	
	
	public void deleteOrderInfoById(Long id) {
		orderInfoDao.deleteByPrimaryKey(id);
	}
	
	
	public void deleteOrderInfo(OrderInfoQuery query) {
		orderInfoDao.deleteByExample(query);
	}
	
	
	public OrderInfoPage queryPageList(OrderInfoQuery query) {
		OrderInfoPage orderInfoPage = new OrderInfoPage();
		Integer itemCount = orderInfoDao.countByExample(query);
		query.setItemCount(itemCount);
		
		if (itemCount == 0) {
			orderInfoPage.setValues(null);
		} else {
			orderInfoPage.setValues(orderInfoDao.selectPageByExample(query));
		}
		
		orderInfoPage.setPagenation(new Pagenation(query.getPageNo(),query.getPageSize(),query.getItemCount()));
		return orderInfoPage;
	}


	public List<BizOrder> queryOrderList(BizOrder bizOrder) {
		// TODO Auto-generated method stub
		return orderInfoDao.queryOrderList(bizOrder);
	}
	public int queryOrderListQueryCount(BizOrderQuery bizOrder) {
		// TODO Auto-generated method stub
		return orderInfoDao.queryOrderListQueryCount(bizOrder);
	}
	public BizOrderPage queryOrderListQuery(BizOrderQuery query , int itemCount) {

        BizOrderPage bizAdPage = new BizOrderPage();
        query.setItemCount(itemCount);

        if (itemCount == 0) {
            bizAdPage.setValues(null);
        } else {
            bizAdPage.setValues(orderInfoDao.queryOrderListQuery(query));
        }

        bizAdPage.setPagenation(new Pagenation(query.getPageNo(),query.getPageSize(),query.getItemCount()));
        return bizAdPage;
	}


	public List<BizOrder> queryPayInfoLists(BizOrder bizOrder) {
		// TODO Auto-generated method stub
		return orderInfoDao.queryPayInfoLists(bizOrder);
	}


	public BizOrder queryOrderInfoDetail(BizOrder bizOrder) {
		// TODO Auto-generated method stub
		return orderInfoDao.queryOrderInfoDetail(bizOrder);
	}


	public List<BizOrder> editorQryOrderInfos(BizOrder bizOrder) {
		// TODO Auto-generated method stub
		return orderInfoDao.editorQryOrderInfos(bizOrder);
	}
	public FaXingOrderPage editorQryOrderInfosPage(BizOrderQuery query , int itemCount) {
        FaXingOrderPage faXingOrderPage = new FaXingOrderPage();
        query.setItemCount(itemCount);

        if (itemCount == 0) {
            faXingOrderPage.setValues(null);
        } else {
            faXingOrderPage.setValues(orderInfoDao.editorQryOrderInfosPage(query));
        }

        faXingOrderPage.setPagenation(new Pagenation(query.getPageNo(),query.getPageSize(),query.getItemCount()));
        return faXingOrderPage;
	}
	public int editorQryOrderInfosPageCount(BizOrderQuery query) {
        return  orderInfoDao.editorQryOrderInfosPageCount(query);
	}
}

