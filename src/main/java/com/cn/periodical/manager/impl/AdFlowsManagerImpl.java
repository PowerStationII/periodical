/*
 * Powered By code-generator
 * Since 2015 - 2015
 */

package com.cn.periodical.manager.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.cn.periodical.dao.AdFlowsDao;
import com.cn.periodical.manager.AdFlowsManager;
import com.cn.periodical.pojo.AdFlows;
import com.cn.periodical.pojo.AdFlowsPage;
import com.cn.periodical.pojo.AdFlowsQuery;
import com.cn.periodical.utils.Pagenation;

@Component("adFlowsManager")
public class AdFlowsManagerImpl implements AdFlowsManager {
	
	@Autowired
	@Qualifier("adFlowsDao")
	private AdFlowsDao adFlowsDao;
	
	
	public void saveAdFlows(AdFlows adFlows) {
		if (adFlows.getId() == null) {
			adFlowsDao.insertSelective(adFlows);
		} else {
			adFlowsDao.updateByPrimaryKeySelective(adFlows);
		}
	}
	
	
	public AdFlows findAdFlowsById(Long id) {
		return adFlowsDao.selectByPrimaryKey(id);
	}
	
	
	public List<AdFlows> queryList(AdFlowsQuery query) {
		return adFlowsDao.selectByExample(query);
	}
	
	
	public void deleteAdFlowsById(Long id) {
		adFlowsDao.deleteByPrimaryKey(id);
	}
	
	
	public void deleteAdFlows(AdFlowsQuery query) {
		adFlowsDao.deleteByExample(query);
	}
	
	
	public AdFlowsPage queryPageList(AdFlowsQuery query) {
		AdFlowsPage adFlowsPage = new AdFlowsPage();
		Integer itemCount = adFlowsDao.countByExample(query);
		query.setItemCount(itemCount);
		
		if (itemCount == 0) {
			adFlowsPage.setValues(null);
		} else {
			adFlowsPage.setValues(adFlowsDao.selectPageByExample(query));
		}
		
		adFlowsPage.setPagenation(new Pagenation(query.getPageNo(),query.getPageSize(),query.getItemCount()));
		return adFlowsPage;
	}
}

