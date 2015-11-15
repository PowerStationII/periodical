/*
 * Powered By code-generator
 * Since 2015 - 2015
 */

package com.cn.periodical.dao;

import java.util.List;

import com.cn.periodical.pojo.PayeeInfo;
import com.cn.periodical.pojo.PayeeInfoQuery;

public interface PayeeInfoDao {
	int countByExample(PayeeInfoQuery example);
	
	int deleteByExample(PayeeInfoQuery example);
	
	int deleteByPrimaryKey(Long id);
	
	int insert(PayeeInfo record);
	
	int insertSelective(PayeeInfo record);
	
	List<PayeeInfo> selectByExample(PayeeInfoQuery example);
	
	List<PayeeInfo> selectPageByExample(PayeeInfoQuery example);
	
	PayeeInfo selectByPrimaryKey(Long id);
	
	int updateByPrimaryKeySelective(PayeeInfo record);
	
	int updateByPrimaryKey(PayeeInfo record);
}
