/*
 * Powered By code-generator
 * Since 2015 - 2015
 */

package com.cn.periodical.dao.impl;

import java.util.List;

import com.cn.periodical.pojo.BizOrderQuery;
import org.springframework.stereotype.Repository;

import com.cn.periodical.dao.BaseDao;
import com.cn.periodical.dao.BizOrderDao;
import com.cn.periodical.pojo.BizArticleFee;
import com.cn.periodical.pojo.BizOrder;

@Repository("bizOrderDao")
public class BizOrderDaoImpl extends BaseDao implements BizOrderDao {

	public List<BizOrder> queryDistributeOrderInfos(BizOrder example) {
		// TODO Auto-generated method stub
		return super.getSqlSession().selectList("BizOrderMapper.queryDistributeOrderInfos", example);
	}

	public List<BizOrder> queryOrderInfosForSubEditor(BizOrder example) {
		// TODO Auto-generated method stub
		return super.getSqlSession().selectList("BizOrderMapper.queryOrderInfosForSubEditor", example);
	}
	public List<BizOrder> queryOrderInfosForSubEditorPage(BizOrderQuery example) {
		// TODO Auto-generated method stub
		return super.getSqlSession().selectList("BizOrderMapper.queryOrderInfosForSubEditorQuery", example);
	}
	public int queryOrderInfosForSubEditorPageCount(BizOrderQuery example) {
		// TODO Auto-generated method stub
		return super.getSqlSession().selectOne("BizOrderMapper.queryOrderInfosForSubEditorQueryCount", example);
	}

	public List<BizOrder> queryOrderInfosForSubEditorDetails(BizOrder example) {
		// TODO Auto-generated method stub
		return super.getSqlSession().selectList("BizOrderMapper.queryOrderInfosForSubEditorDetails", example);
	}
	
}
