/*
 * Powered By code-generator
 * Since 2015 - 2015
 */

package com.cn.periodical.dao;

import java.util.List;

import com.cn.periodical.pojo.PayerInfo;
import com.cn.periodical.pojo.PayerInfoQuery;

public interface PayerInfoDao {
	int countByExample(PayerInfoQuery example);
	
	int deleteByExample(PayerInfoQuery example);
	
	int deleteByPrimaryKey(Long id);
	
	int insert(PayerInfo record);
	
	int insertSelective(PayerInfo record);
	
	List<PayerInfo> selectByExample(PayerInfoQuery example);
	
	List<PayerInfo> selectPageByExample(PayerInfoQuery example);
	
	PayerInfo selectByPrimaryKey(Long id);
	
	int updateByPrimaryKeySelective(PayerInfo record);
	
	int updateByPrimaryKey(PayerInfo record);
}
