/*
 * Powered By code-generator
 * Since 2015 - 2015
 */

package com.cn.periodical.dao;

import java.util.List;

import com.cn.periodical.pojo.AccountInfo;
import com.cn.periodical.pojo.AccountInfoQuery;

public interface AccountInfoDao {
	int countByExample(AccountInfoQuery example);
	
	int deleteByExample(AccountInfoQuery example);
	
	int deleteByPrimaryKey(Long id);
	
	int insert(AccountInfo record);
	
	int insertSelective(AccountInfo record);
	
	List<AccountInfo> selectByExample(AccountInfoQuery example);
	
	List<AccountInfo> selectPageByExample(AccountInfoQuery example);
	
	AccountInfo selectByPrimaryKey(Long id);
	
	int updateByPrimaryKeySelective(AccountInfo record);
	
	int updateByPrimaryKey(AccountInfo record);
}
