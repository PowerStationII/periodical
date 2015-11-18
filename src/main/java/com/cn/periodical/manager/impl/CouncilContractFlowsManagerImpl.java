/*
 * Powered By code-generator
 * Since 2015 - 2015
 */

package com.cn.periodical.manager.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.cn.periodical.dao.CouncilContractFlowsDao;
import com.cn.periodical.manager.CouncilContractFlowsManager;
import com.cn.periodical.pojo.CouncilContractFlows;
import com.cn.periodical.pojo.CouncilContractFlowsPage;
import com.cn.periodical.pojo.CouncilContractFlowsQuery;
import com.cn.periodical.utils.Pagenation;

@Component("councilContractFlowsManager")
public class CouncilContractFlowsManagerImpl implements CouncilContractFlowsManager {
	
	@Autowired
	@Qualifier("councilContractFlowsDao")
	private CouncilContractFlowsDao councilContractFlowsDao;
	
	
	public void saveCouncilContractFlows(CouncilContractFlows councilContractFlows) {
		if (councilContractFlows.getId() == null) {
			councilContractFlowsDao.insertSelective(councilContractFlows);
		} else {
			councilContractFlowsDao.updateByPrimaryKeySelective(councilContractFlows);
		}
	}
	
	
	public CouncilContractFlows findCouncilContractFlowsById(Long id) {
		return councilContractFlowsDao.selectByPrimaryKey(id);
	}
	
	
	public List<CouncilContractFlows> queryList(CouncilContractFlowsQuery query) {
		return councilContractFlowsDao.selectByExample(query);
	}
	
	
	public void deleteCouncilContractFlowsById(Long id) {
		councilContractFlowsDao.deleteByPrimaryKey(id);
	}
	
	
	public void deleteCouncilContractFlows(CouncilContractFlowsQuery query) {
		councilContractFlowsDao.deleteByExample(query);
	}
	
	
	public CouncilContractFlowsPage queryPageList(CouncilContractFlowsQuery query) {
		CouncilContractFlowsPage councilContractFlowsPage = new CouncilContractFlowsPage();
		Integer itemCount = councilContractFlowsDao.countByExample(query);
		query.setItemCount(itemCount);
		
		if (itemCount == 0) {
			councilContractFlowsPage.setValues(null);
		} else {
			councilContractFlowsPage.setValues(councilContractFlowsDao.selectPageByExample(query));
		}
		
		councilContractFlowsPage.setPagenation(new Pagenation(query.getPageNo(),query.getPageSize(),query.getItemCount()));
		return councilContractFlowsPage;
	}
}

