/*
 * Powered By code-generator
 * Since 2015 - 2015
 */

package com.cn.periodical.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.cn.periodical.dao.PayerInfoDao;
import com.cn.periodical.pojo.PayerInfo;
import com.cn.periodical.pojo.PayerInfoQuery;
import com.cn.periodical.dao.BaseDao;

@Repository("payerInfoDao")
public class PayerInfoDaoImpl extends BaseDao implements PayerInfoDao {
	
	
	public int countByExample(PayerInfoQuery example) {
		return super.getSqlSession().selectOne("PayerInfoMapper.countByExample", example);
	}
	
	
	public int deleteByExample(PayerInfoQuery example) {
		return super.getSqlSession().delete("PayerInfoMapper.deleteByExample", example);
	}
	
	
	public int deleteByPrimaryKey(Long id) {
		return super.getSqlSession().delete("PayerInfoMapper.deleteByPrimaryKey", id);
	}
	
	
	public int insert(PayerInfo record) {
		return super.getSqlSession().insert("PayerInfoMapper.insert", record);
	}
	
	
	public int insertSelective(PayerInfo record) {
		return super.getSqlSession().insert("PayerInfoMapper.insertSelective", record);
	}
	
	
	public List<PayerInfo> selectByExample(PayerInfoQuery example) {
		return super.getSqlSession().selectList("PayerInfoMapper.selectByExample", example);
	}
	
	
	public List<PayerInfo> selectPageByExample(PayerInfoQuery example) {
		return super.getSqlSession().selectList("PayerInfoMapper.selectPageByExample", example);
	}
	
	
	public PayerInfo selectByPrimaryKey(Long id) {
		return super.getSqlSession().selectOne("PayerInfoMapper.selectByPrimaryKey", id);
	}
	
	
	public int updateByPrimaryKeySelective(PayerInfo record) {
		return super.getSqlSession().update("PayerInfoMapper.updateByPrimaryKeySelective", record);
	}
	
	
	public int updateByPrimaryKey(PayerInfo record) {
		return super.getSqlSession().update("PayerInfoMapper.updateByPrimaryKey", record);
	}
	
}
