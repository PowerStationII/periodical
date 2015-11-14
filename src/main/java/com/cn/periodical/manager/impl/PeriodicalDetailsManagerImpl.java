/*
 * Powered By code-generator
 * Since 2015 - 2015
 */

package com.cn.periodical.manager.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.cn.periodical.dao.PeriodicalDetailsDao;
import com.cn.periodical.manager.PeriodicalDetailsManager;
import com.cn.periodical.pojo.PeriodicalDetails;
import com.cn.periodical.pojo.PeriodicalDetailsPage;
import com.cn.periodical.pojo.PeriodicalDetailsQuery;
import com.cn.periodical.utils.Pagenation;

@Component("periodicalDetailsManager")
public class PeriodicalDetailsManagerImpl implements PeriodicalDetailsManager {
	
	@Autowired
	@Qualifier("periodicalDetailsDao")
	private PeriodicalDetailsDao periodicalDetailsDao;
	
	
	public void savePeriodicalDetails(PeriodicalDetails periodicalDetails) {
		if (periodicalDetails.getId() == null) {
			periodicalDetailsDao.insertSelective(periodicalDetails);
		} else {
			periodicalDetailsDao.updateByPrimaryKeySelective(periodicalDetails);
		}
	}
	
	
	public PeriodicalDetails findPeriodicalDetailsById(Long id) {
		return periodicalDetailsDao.selectByPrimaryKey(id);
	}
	
	
	public List<PeriodicalDetails> queryList(PeriodicalDetailsQuery query) {
		return periodicalDetailsDao.selectByExample(query);
	}
	
	
	public void deletePeriodicalDetailsById(Long id) {
		periodicalDetailsDao.deleteByPrimaryKey(id);
	}
	
	
	public void deletePeriodicalDetails(PeriodicalDetailsQuery query) {
		periodicalDetailsDao.deleteByExample(query);
	}
	
	
	public PeriodicalDetailsPage queryPageList(PeriodicalDetailsQuery query) {
		PeriodicalDetailsPage periodicalDetailsPage = new PeriodicalDetailsPage();
		Integer itemCount = periodicalDetailsDao.countByExample(query);
		query.setItemCount(itemCount);
		
		if (itemCount == 0) {
			periodicalDetailsPage.setValues(null);
		} else {
			periodicalDetailsPage.setValues(periodicalDetailsDao.selectPageByExample(query));
		}
		
		periodicalDetailsPage.setPagenation(new Pagenation(query.getPageNo(),query.getPageSize(),query.getItemCount()));
		return periodicalDetailsPage;
	}
}

