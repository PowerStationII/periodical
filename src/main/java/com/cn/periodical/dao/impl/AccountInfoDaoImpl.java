/*
 * Powered By code-generator
 * Since 2015 - 2015
 */

package com.cn.periodical.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.cn.periodical.dao.AccountInfoDao;
import com.cn.periodical.pojo.AccountInfo;
import com.cn.periodical.pojo.AccountInfoQuery;
import com.cn.periodical.dao.BaseDao;

@Repository("accountInfoDao")
public class AccountInfoDaoImpl extends BaseDao implements AccountInfoDao {
	
	
	public int countByExample(AccountInfoQuery example) {
		return super.getSqlSession().selectOne("AccountInfoMapper.countByExample", example);
	}
	
	
	public int deleteByExample(AccountInfoQuery example) {
		return super.getSqlSession().delete("AccountInfoMapper.deleteByExample", example);
	}
	
	
	public int deleteByPrimaryKey(Long id) {
		return super.getSqlSession().delete("AccountInfoMapper.deleteByPrimaryKey", id);
	}
	
	
	public int insert(AccountInfo record) {
		return super.getSqlSession().insert("AccountInfoMapper.insert", record);
	}
	
	
	public int insertSelective(AccountInfo record) {
		return super.getSqlSession().insert("AccountInfoMapper.insertSelective", record);
	}
	
	
	public List<AccountInfo> selectByExample(AccountInfoQuery example) {
		return super.getSqlSession().selectList("AccountInfoMapper.selectByExample", example);
	}
	
	
	public List<AccountInfo> selectPageByExample(AccountInfoQuery example) {
		return super.getSqlSession().selectList("AccountInfoMapper.selectPageByExample", example);
	}
	
	
	public AccountInfo selectByPrimaryKey(Long id) {
		return super.getSqlSession().selectOne("AccountInfoMapper.selectByPrimaryKey", id);
	}
	
	
	public int updateByPrimaryKeySelective(AccountInfo record) {
		return super.getSqlSession().update("AccountInfoMapper.updateByPrimaryKeySelective", record);
	}
	
	
	public int updateByPrimaryKey(AccountInfo record) {
		return super.getSqlSession().update("AccountInfoMapper.updateByPrimaryKey", record);
	}
	
}
