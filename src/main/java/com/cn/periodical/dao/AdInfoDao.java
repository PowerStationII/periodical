/*
 * Powered By code-generator
 * Since 2015 - 2015
 */

package com.cn.periodical.dao;

import java.util.List;

import com.cn.periodical.pojo.AdInfo;
import com.cn.periodical.pojo.AdInfoQuery;

public interface AdInfoDao {
	int countByExample(AdInfoQuery example);
	
	int deleteByExample(AdInfoQuery example);
	
	int deleteByPrimaryKey(Long id);
	
	int insert(AdInfo record);
	
	int insertSelective(AdInfo record);
	
	List<AdInfo> selectByExample(AdInfoQuery example);
	
	List<AdInfo> selectPageByExample(AdInfoQuery example);
	
	AdInfo selectByPrimaryKey(Long id);
	
	int updateByPrimaryKeySelective(AdInfo record);
	
	int updateByPrimaryKey(AdInfo record);
}