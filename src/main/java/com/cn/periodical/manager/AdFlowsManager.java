/*
 * Powered By code-generator
 * Since 2015 - 2015
 */

package com.cn.periodical.manager;

import java.util.List;

import com.cn.periodical.pojo.AdFlows;
import com.cn.periodical.pojo.AdFlowsPage;
import com.cn.periodical.pojo.AdFlowsQuery;

public interface AdFlowsManager {
	void saveAdFlows(AdFlows adFlows);

	AdFlows findAdFlowsById(Long id);
	
	List<AdFlows> queryList(AdFlowsQuery query);
	
	void deleteAdFlowsById(Long id);
	
	void deleteAdFlows(AdFlowsQuery query);
	
	AdFlowsPage queryPageList(AdFlowsQuery query);
}
