/*
 * Powered By chanjetpay-code-generator
 * Web Site: http://www.chanjetpay.com
 * Since 2014 - 2015
 */

package com.cn.periodical.dao;

import java.util.List;

import com.cn.periodical.pojo.UserInfo;
import com.cn.periodical.pojo.UserInfoQuery;

public interface UserInfoDao {
	int countByExample(UserInfoQuery example);
	
	int deleteByExample(UserInfoQuery example);
	
	int deleteByPrimaryKey(Long id);
	
	int insert(UserInfo record);
	
	int insertSelective(UserInfo record);
	
	List<UserInfo> selectByExample(UserInfoQuery example);
	
	List<UserInfo> selectPageByExample(UserInfoQuery example);
	
	UserInfo selectByPrimaryKey(Long id);
	
	int updateByPrimaryKeySelective(UserInfo record);
	
	int updateByPrimaryKey(UserInfo record);
}
