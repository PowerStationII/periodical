/*
 * Powered By code-generator
 * Since 2015 - 2015
 */

package com.cn.periodical.manager.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.cn.periodical.dao.PeriodicalInfoDao;
import com.cn.periodical.manager.PeriodicalInfoManager;
import com.cn.periodical.pojo.PeriodicalInfo;
import com.cn.periodical.pojo.PeriodicalInfoPage;
import com.cn.periodical.pojo.PeriodicalInfoQuery;
import com.cn.periodical.utils.Pagenation;

@Component("periodicalInfoManager")
public class PeriodicalInfoManagerImpl implements PeriodicalInfoManager {
	
	@Autowired
	@Qualifier("periodicalInfoDao")
	private PeriodicalInfoDao periodicalInfoDao;
	
	
	public void savePeriodicalInfo(PeriodicalInfo periodicalInfo) {
		if (periodicalInfo.getId() == null) {
			periodicalInfoDao.insertSelective(periodicalInfo);
		} else {
			periodicalInfoDao.updateByPrimaryKeySelective(periodicalInfo);
		}
	}
	
	
	public PeriodicalInfo findPeriodicalInfoById(Long id) {
		return periodicalInfoDao.selectByPrimaryKey(id);
	}
	
	
	public List<PeriodicalInfo> queryList(PeriodicalInfoQuery query) {
		return periodicalInfoDao.selectByExample(query);
	}
	
	
	public void deletePeriodicalInfoById(Long id) {
		periodicalInfoDao.deleteByPrimaryKey(id);
	}
	
	
	public void deletePeriodicalInfo(PeriodicalInfoQuery query) {
		periodicalInfoDao.deleteByExample(query);
	}
	
	
	public PeriodicalInfoPage queryPageList(PeriodicalInfoQuery query) {
		PeriodicalInfoPage periodicalInfoPage = new PeriodicalInfoPage();
		Integer itemCount = periodicalInfoDao.countByExample(query);
		query.setItemCount(itemCount);
		
		if (itemCount == 0) {
			periodicalInfoPage.setValues(null);
		} else {
			periodicalInfoPage.setValues(periodicalInfoDao.selectPageByExample(query));
		}
		
		periodicalInfoPage.setPagenation(new Pagenation(query.getPageNo(),query.getPageSize(),query.getItemCount()));
		return periodicalInfoPage;
	}
}

