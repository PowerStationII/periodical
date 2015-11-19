/*
 * Powered By code-generator
 * Since 2015 - 2015
 */

package com.cn.periodical.dao;

import java.util.List;

import com.cn.periodical.pojo.AdFlows;
import com.cn.periodical.pojo.AdFlowsQuery;

public interface AdFlowsDao {
	int countByExample(AdFlowsQuery example);
	
	int deleteByExample(AdFlowsQuery example);
	
	int deleteByPrimaryKey(Long id);
	
	int insert(AdFlows record);
	
	int insertSelective(AdFlows record);
	
	List<AdFlows> selectByExample(AdFlowsQuery example);
	
	List<AdFlows> selectPageByExample(AdFlowsQuery example);
	
	AdFlows selectByPrimaryKey(Long id);
	
	int updateByPrimaryKeySelective(AdFlows record);
	
	int updateByPrimaryKey(AdFlows record);
}
