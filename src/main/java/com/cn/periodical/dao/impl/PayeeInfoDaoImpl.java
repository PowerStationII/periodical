/*
 * Powered By code-generator
 * Since 2015 - 2015
 */

package com.cn.periodical.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.cn.periodical.dao.PayeeInfoDao;
import com.cn.periodical.pojo.PayeeInfo;
import com.cn.periodical.pojo.PayeeInfoQuery;
import com.cn.periodical.dao.BaseDao;

@Repository("payeeInfoDao")
public class PayeeInfoDaoImpl extends BaseDao implements PayeeInfoDao {
	
	
	public int countByExample(PayeeInfoQuery example) {
		return super.getSqlSession().selectOne("PayeeInfoMapper.countByExample", example);
	}
	
	
	public int deleteByExample(PayeeInfoQuery example) {
		return super.getSqlSession().delete("PayeeInfoMapper.deleteByExample", example);
	}
	
	
	public int deleteByPrimaryKey(Long id) {
		return super.getSqlSession().delete("PayeeInfoMapper.deleteByPrimaryKey", id);
	}
	
	
	public int insert(PayeeInfo record) {
		return super.getSqlSession().insert("PayeeInfoMapper.insert", record);
	}
	
	
	public int insertSelective(PayeeInfo record) {
		return super.getSqlSession().insert("PayeeInfoMapper.insertSelective", record);
	}
	
	
	public List<PayeeInfo> selectByExample(PayeeInfoQuery example) {
		return super.getSqlSession().selectList("PayeeInfoMapper.selectByExample", example);
	}
	
	
	public List<PayeeInfo> selectPageByExample(PayeeInfoQuery example) {
		return super.getSqlSession().selectList("PayeeInfoMapper.selectPageByExample", example);
	}
	
	
	public PayeeInfo selectByPrimaryKey(Long id) {
		return super.getSqlSession().selectOne("PayeeInfoMapper.selectByPrimaryKey", id);
	}
	
	
	public int updateByPrimaryKeySelective(PayeeInfo record) {
		return super.getSqlSession().update("PayeeInfoMapper.updateByPrimaryKeySelective", record);
	}
	
	
	public int updateByPrimaryKey(PayeeInfo record) {
		return super.getSqlSession().update("PayeeInfoMapper.updateByPrimaryKey", record);
	}
	
}
