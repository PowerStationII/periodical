/*
 * Powered By code-generator
 * Since 2015 - 2015
 */

package com.cn.periodical.dao.impl;

import java.util.List;

import com.cn.periodical.pojo.BizOrderQuery;
import org.springframework.stereotype.Repository;

import com.cn.periodical.dao.OrderInfoDao;
import com.cn.periodical.pojo.BizOrder;
import com.cn.periodical.pojo.OrderInfo;
import com.cn.periodical.pojo.OrderInfoQuery;
import com.cn.periodical.dao.BaseDao;

@Repository("orderInfoDao")
public class OrderInfoDaoImpl extends BaseDao implements OrderInfoDao {
	
	
	public int countByExample(OrderInfoQuery example) {
		return super.getSqlSession().selectOne("OrderInfoMapper.countByExample", example);
	}
	
	
	public int deleteByExample(OrderInfoQuery example) {
		return super.getSqlSession().delete("OrderInfoMapper.deleteByExample", example);
	}
	
	
	public int deleteByPrimaryKey(Long id) {
		return super.getSqlSession().delete("OrderInfoMapper.deleteByPrimaryKey", id);
	}
	
	
	public int insert(OrderInfo record) {
		return super.getSqlSession().insert("OrderInfoMapper.insert", record);
	}
	
	
	public int insertSelective(OrderInfo record) {
		return super.getSqlSession().insert("OrderInfoMapper.insertSelective", record);
	}
	
	
	public List<OrderInfo> selectByExample(OrderInfoQuery example) {
		return super.getSqlSession().selectList("OrderInfoMapper.selectByExample", example);
	}
	
	
	public List<OrderInfo> selectPageByExample(OrderInfoQuery example) {
		return super.getSqlSession().selectList("OrderInfoMapper.selectPageByExample", example);
	}
	
	
	public OrderInfo selectByPrimaryKey(Long id) {
		return super.getSqlSession().selectOne("OrderInfoMapper.selectByPrimaryKey", id);
	}
	
	
	public int updateByPrimaryKeySelective(OrderInfo record) {
		return super.getSqlSession().update("OrderInfoMapper.updateByPrimaryKeySelective", record);
	}
	
	
	public int updateByPrimaryKey(OrderInfo record) {
		return super.getSqlSession().update("OrderInfoMapper.updateByPrimaryKey", record);
	}
	public int updateByOrderNo(OrderInfo record) {
		return super.getSqlSession().update("OrderInfoMapper.updateByOrderNo", record);
	}


	public List<BizOrder> queryOrderList(BizOrder bizOrder) {
		// TODO Auto-generated method stub
		return super.getSqlSession().selectList("OrderInfoMapper.queryOrderList", bizOrder);
	}
	public int queryOrderListQueryCount(BizOrderQuery bizOrder) {
		return super.getSqlSession().selectOne("OrderInfoMapper.queryOrderListQueryCount", bizOrder);
	}
	public List<BizOrder> queryOrderListQuery(BizOrderQuery bizOrder) {
		return super.getSqlSession().selectList("OrderInfoMapper.queryOrderListQuery", bizOrder);
	}


	public List<BizOrder> queryPayInfoLists(BizOrder bizOrder) {
		// TODO Auto-generated method stub
		return super.getSqlSession().selectList("OrderInfoMapper.queryOrderAndPayList", bizOrder);
	}


	public BizOrder queryOrderInfoDetail(BizOrder bizOrder) {
		// TODO Auto-generated method stub
		return super.getSqlSession().selectOne("OrderInfoMapper.queryOrderDetail", bizOrder);
	}


	public List<BizOrder> editorQryOrderInfos(BizOrder bizOrder) {
		// TODO Auto-generated method stub
		return super.getSqlSession().selectList("OrderInfoMapper.editorQueryOrderInfos", bizOrder);
	}
	public List<BizOrder> editorQryOrderInfosPage(BizOrderQuery bizOrder) {
		// TODO Auto-generated method stub
		return super.getSqlSession().selectList("OrderInfoMapper.editorQueryOrderInfosPage", bizOrder);
	}
	public int editorQryOrderInfosPageCount(BizOrderQuery bizOrder) {
		return super.getSqlSession().selectOne("OrderInfoMapper.editorQueryOrderInfosPageCount", bizOrder);
	}

}
