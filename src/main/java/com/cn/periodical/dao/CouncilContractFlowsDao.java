/*
 * Powered By code-generator
 * Since 2015 - 2015
 */

package com.cn.periodical.dao;

import java.util.List;

import com.cn.periodical.pojo.CouncilContractFlows;
import com.cn.periodical.pojo.CouncilContractFlowsQuery;

public interface CouncilContractFlowsDao {
	int countByExample(CouncilContractFlowsQuery example);
	
	int deleteByExample(CouncilContractFlowsQuery example);
	
	int deleteByPrimaryKey(Long id);
	
	int insert(CouncilContractFlows record);
	
	int insertSelective(CouncilContractFlows record);
	
	List<CouncilContractFlows> selectByExample(CouncilContractFlowsQuery example);
	
	List<CouncilContractFlows> selectPageByExample(CouncilContractFlowsQuery example);
	
	CouncilContractFlows selectByPrimaryKey(Long id);
	
	int updateByPrimaryKeySelective(CouncilContractFlows record);
	
	int updateByPrimaryKey(CouncilContractFlows record);
}
