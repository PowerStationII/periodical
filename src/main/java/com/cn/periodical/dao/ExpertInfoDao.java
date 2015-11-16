/*
 * Powered By code-generator
 * Since 2015 - 2015
 */

package com.cn.periodical.dao;

import java.util.List;

import com.cn.periodical.pojo.ExpertInfo;
import com.cn.periodical.pojo.ExpertInfoQuery;

public interface ExpertInfoDao {
	int countByExample(ExpertInfoQuery example);
	
	int deleteByExample(ExpertInfoQuery example);
	
	int deleteByPrimaryKey(Long id);
	
	int insert(ExpertInfo record);
	
	int insertSelective(ExpertInfo record);
	
	List<ExpertInfo> selectByExample(ExpertInfoQuery example);
	
	List<ExpertInfo> selectPageByExample(ExpertInfoQuery example);
	
	ExpertInfo selectByPrimaryKey(Long id);
	
	int updateByPrimaryKeySelective(ExpertInfo record);
	
	int updateByPrimaryKey(ExpertInfo record);
}
