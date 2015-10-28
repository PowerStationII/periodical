/*
 * Powered By chanjetpay-code-generator
 * Web Site: http://www.chanjetpay.com
 * Since 2014 - 2015
 */

package com.cn.periodical.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.cn.periodical.dao.BaseDao;
import com.cn.periodical.dao.UserInfoDao;
import com.cn.periodical.pojo.UserInfo;
import com.cn.periodical.pojo.UserInfoQuery;

@Repository("userInfoDao")
public class UserInfoDaoImpl extends BaseDao implements UserInfoDao {
	
	@Override
	public int countByExample(UserInfoQuery example) {
		return super.getSqlSession().selectOne("UserInfoMapper.countByExample", example);
	}
	
	@Override
	public int deleteByExample(UserInfoQuery example) {
		return super.getSqlSession().delete("UserInfoMapper.deleteByExample", example);
	}
	
	@Override
	public int deleteByPrimaryKey(Long id) {
		return super.getSqlSession().delete("UserInfoMapper.deleteByPrimaryKey", id);
	}
	
	@Override
	public int insert(UserInfo record) {
		return super.getSqlSession().insert("UserInfoMapper.insert", record);
	}
	
	@Override
	public int insertSelective(UserInfo record) {
		return super.getSqlSession().insert("UserInfoMapper.insertSelective", record);
	}
	
	@Override
	public List<UserInfo> selectByExample(UserInfoQuery example) {
		return super.getSqlSession().selectList("UserInfoMapper.selectByExample", example);
	}
	
	@Override
	public List<UserInfo> selectPageByExample(UserInfoQuery example) {
		return super.getSqlSession().selectList("UserInfoMapper.selectPageByExample", example);
	}
	
	@Override
	public UserInfo selectByPrimaryKey(Long id) {
		return super.getSqlSession().selectOne("UserInfoMapper.selectByPrimaryKey", id);
	}
	
	@Override
	public int updateByPrimaryKeySelective(UserInfo record) {
		return super.getSqlSession().update("UserInfoMapper.updateByPrimaryKeySelective", record);
	}
	
	@Override
	public int updateByPrimaryKey(UserInfo record) {
		return super.getSqlSession().update("UserInfoMapper.updateByPrimaryKey", record);
	}
	
}
