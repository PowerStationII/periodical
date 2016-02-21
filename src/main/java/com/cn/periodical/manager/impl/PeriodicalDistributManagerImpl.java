/*
 * Powered By code-generator
 * Since 2015 - 2015
 */

package com.cn.periodical.manager.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.cn.periodical.dao.PeriodicalDistributDao;
import com.cn.periodical.manager.PeriodicalDistributManager;
import com.cn.periodical.pojo.PeriodicalDistribut;
import com.cn.periodical.pojo.PeriodicalDistributPage;
import com.cn.periodical.pojo.PeriodicalDistributQuery;
import com.cn.periodical.utils.Pagenation;

@Component("periodicalDistributManager")
public class PeriodicalDistributManagerImpl implements PeriodicalDistributManager {
	
	@Autowired
	@Qualifier("periodicalDistributDao")
	private PeriodicalDistributDao periodicalDistributDao;
	
	
	public void savePeriodicalDistribut(PeriodicalDistribut periodicalDistribut) {
		if (periodicalDistribut.getId() == null) {
			periodicalDistributDao.insertSelective(periodicalDistribut);
		} else {
			periodicalDistributDao.updateByPrimaryKeySelective(periodicalDistribut);
		}
	}
	
	
	public PeriodicalDistribut findPeriodicalDistributById(Long id) {
		return periodicalDistributDao.selectByPrimaryKey(id);
	}
	
	
	public List<PeriodicalDistribut> queryList(PeriodicalDistributQuery query) {
		return periodicalDistributDao.selectByExample(query);
	}
	
	
	public void deletePeriodicalDistributById(Long id) {
		periodicalDistributDao.deleteByPrimaryKey(id);
	}
	public void deletePeriodicalDistributByOrderNo(String orderNo) {
		periodicalDistributDao.deletePeriodicalDistributByOrderNo(orderNo);
	}

	
	public void deletePeriodicalDistribut(PeriodicalDistributQuery query) {
		periodicalDistributDao.deleteByExample(query);
	}
	
	
	public PeriodicalDistributPage queryPageList(PeriodicalDistributQuery query) {
		PeriodicalDistributPage periodicalDistributPage = new PeriodicalDistributPage();
		Integer itemCount = periodicalDistributDao.countByExample(query);
		query.setItemCount(itemCount);
		
		if (itemCount == 0) {
			periodicalDistributPage.setValues(null);
		} else {
			periodicalDistributPage.setValues(periodicalDistributDao.selectPageByExample(query));
		}
		
		periodicalDistributPage.setPagenation(new Pagenation(query.getPageNo(),query.getPageSize(),query.getItemCount()));
		return periodicalDistributPage;
	}
}

