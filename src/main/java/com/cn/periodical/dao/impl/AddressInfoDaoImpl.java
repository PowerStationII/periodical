/*
 * Powered By code-generator
 * Since 2015 - 2015
 */

package com.cn.periodical.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.cn.periodical.dao.AddressInfoDao;
import com.cn.periodical.pojo.AddressInfo;
import com.cn.periodical.pojo.AddressInfoQuery;
import com.cn.periodical.dao.BaseDao;

@Repository("addressInfoDao")
public class AddressInfoDaoImpl extends BaseDao implements AddressInfoDao {
	
	
	public int countByExample(AddressInfoQuery example) {
		return super.getSqlSession().selectOne("AddressInfoMapper.countByExample", example);
	}
	
	
	public int deleteByExample(AddressInfoQuery example) {
		return super.getSqlSession().delete("AddressInfoMapper.deleteByExample", example);
	}
	
	
	public int deleteByPrimaryKey(Long id) {
		return super.getSqlSession().delete("AddressInfoMapper.deleteByPrimaryKey", id);
	}
	
	
	public int insert(AddressInfo record) {
		return super.getSqlSession().insert("AddressInfoMapper.insert", record);
	}
	
	
	public int insertSelective(AddressInfo record) {
		return super.getSqlSession().insert("AddressInfoMapper.insertSelective", record);
	}
	
	
	public List<AddressInfo> selectByExample(AddressInfoQuery example) {
		return super.getSqlSession().selectList("AddressInfoMapper.selectByExample", example);
	}
	
	
	public List<AddressInfo> selectPageByExample(AddressInfoQuery example) {
		return super.getSqlSession().selectList("AddressInfoMapper.selectPageByExample", example);
	}
	
	
	public AddressInfo selectByPrimaryKey(Long id) {
		return super.getSqlSession().selectOne("AddressInfoMapper.selectByPrimaryKey", id);
	}
	
	
	public int updateByPrimaryKeySelective(AddressInfo record) {
		return super.getSqlSession().update("AddressInfoMapper.updateByPrimaryKeySelective", record);
	}
	
	
	public int updateByPrimaryKey(AddressInfo record) {
		return super.getSqlSession().update("AddressInfoMapper.updateByPrimaryKey", record);
	}
	
}
