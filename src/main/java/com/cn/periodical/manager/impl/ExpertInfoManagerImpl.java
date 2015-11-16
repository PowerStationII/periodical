/*
 * Powered By code-generator
 * Since 2015 - 2015
 */

package com.cn.periodical.manager.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.cn.periodical.dao.ExpertInfoDao;
import com.cn.periodical.manager.ExpertInfoManager;
import com.cn.periodical.pojo.ExpertInfo;
import com.cn.periodical.pojo.ExpertInfoPage;
import com.cn.periodical.pojo.ExpertInfoQuery;
import com.cn.periodical.utils.Pagenation;

@Component("expertInfoManager")
public class ExpertInfoManagerImpl implements ExpertInfoManager {
	
	@Autowired
	@Qualifier("expertInfoDao")
	private ExpertInfoDao expertInfoDao;
	
	
	public void saveExpertInfo(ExpertInfo expertInfo) {
		if (expertInfo.getId() == null) {
			expertInfoDao.insertSelective(expertInfo);
		} else {
			expertInfoDao.updateByPrimaryKeySelective(expertInfo);
		}
	}
	
	
	public ExpertInfo findExpertInfoById(Long id) {
		return expertInfoDao.selectByPrimaryKey(id);
	}
	
	
	public List<ExpertInfo> queryList(ExpertInfoQuery query) {
		return expertInfoDao.selectByExample(query);
	}
	
	
	public void deleteExpertInfoById(Long id) {
		expertInfoDao.deleteByPrimaryKey(id);
	}
	
	
	public void deleteExpertInfo(ExpertInfoQuery query) {
		expertInfoDao.deleteByExample(query);
	}
	
	
	public ExpertInfoPage queryPageList(ExpertInfoQuery query) {
		ExpertInfoPage expertInfoPage = new ExpertInfoPage();
		Integer itemCount = expertInfoDao.countByExample(query);
		query.setItemCount(itemCount);
		
		if (itemCount == 0) {
			expertInfoPage.setValues(null);
		} else {
			expertInfoPage.setValues(expertInfoDao.selectPageByExample(query));
		}
		
		expertInfoPage.setPagenation(new Pagenation(query.getPageNo(),query.getPageSize(),query.getItemCount()));
		return expertInfoPage;
	}
}

