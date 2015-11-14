/*
 * Powered By code-generator
 * Since 2015 - 2015
 */

package com.cn.periodical.manager.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.cn.periodical.dao.PeriodicalDao;
import com.cn.periodical.manager.PeriodicalManager;
import com.cn.periodical.pojo.Periodical;
import com.cn.periodical.pojo.PeriodicalPage;
import com.cn.periodical.pojo.PeriodicalQuery;
import com.cn.periodical.utils.Pagenation;

@Component("periodicalManager")
public class PeriodicalManagerImpl implements PeriodicalManager {
	
	@Autowired
	@Qualifier("periodicalDao")
	private PeriodicalDao periodicalDao;
	
	
	public void savePeriodical(Periodical periodical) {
		if (periodical.getId() == null) {
			periodicalDao.insertSelective(periodical);
		} else {
			periodicalDao.updateByPrimaryKeySelective(periodical);
		}
	}
	
	
	public Periodical findPeriodicalById(Long id) {
		return periodicalDao.selectByPrimaryKey(id);
	}
	
	
	public List<Periodical> queryList(PeriodicalQuery query) {
		return periodicalDao.selectByExample(query);
	}
	
	
	public void deletePeriodicalById(Long id) {
		periodicalDao.deleteByPrimaryKey(id);
	}
	
	
	public void deletePeriodical(PeriodicalQuery query) {
		periodicalDao.deleteByExample(query);
	}
	
	
	public PeriodicalPage queryPageList(PeriodicalQuery query) {
		PeriodicalPage periodicalPage = new PeriodicalPage();
		Integer itemCount = periodicalDao.countByExample(query);
		query.setItemCount(itemCount);
		
		if (itemCount == 0) {
			periodicalPage.setValues(null);
		} else {
			periodicalPage.setValues(periodicalDao.selectPageByExample(query));
		}
		
		periodicalPage.setPagenation(new Pagenation(query.getPageNo(),query.getPageSize(),query.getItemCount()));
		return periodicalPage;
	}
}

