/*
 * Powered By code-generator
 * Since 2015 - 2015
 */

package com.cn.periodical.manager;

import java.util.List;

import com.cn.periodical.pojo.CouncilContractFlows;
import com.cn.periodical.pojo.CouncilContractFlowsPage;
import com.cn.periodical.pojo.CouncilContractFlowsQuery;

public interface CouncilContractFlowsManager {
	void saveCouncilContractFlows(CouncilContractFlows councilContractFlows);

	CouncilContractFlows findCouncilContractFlowsById(Long id);
	
	List<CouncilContractFlows> queryList(CouncilContractFlowsQuery query);
	
	void deleteCouncilContractFlowsById(Long id);
	
	void deleteCouncilContractFlows(CouncilContractFlowsQuery query);
	
	CouncilContractFlowsPage queryPageList(CouncilContractFlowsQuery query);
}
