/*
 * Powered By code-generator
 * Since 2015 - 2015
 */

package com.cn.periodical.dao;

import java.util.List;

import com.cn.periodical.pojo.SupplementInfo;
import com.cn.periodical.pojo.SupplementInfoQuery;

public interface SupplementInfoDao {
	int countByExample(SupplementInfoQuery example);
	
	int deleteByExample(SupplementInfoQuery example);
	
	int deleteByPrimaryKey(Long id);
	
	int insert(SupplementInfo record);
	
	int insertSelective(SupplementInfo record);
	
	List<SupplementInfo> selectByExample(SupplementInfoQuery example);
	
	List<SupplementInfo> selectPageByExample(SupplementInfoQuery example);
	
	SupplementInfo selectByPrimaryKey(Long id);
	
	int updateByPrimaryKeySelective(SupplementInfo record);
	
	int updateByPrimaryKey(SupplementInfo record);
}
