/*
 * Powered By code-generator
 * Since 2015 - 2015
 */

package com.cn.periodical.manager.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.cn.periodical.dao.SupplementInfoDao;
import com.cn.periodical.manager.SupplementInfoManager;
import com.cn.periodical.pojo.SupplementInfo;
import com.cn.periodical.pojo.SupplementInfoPage;
import com.cn.periodical.pojo.SupplementInfoQuery;
import com.cn.periodical.utils.Pagenation;

@Component("supplementInfoManager")
public class SupplementInfoManagerImpl implements SupplementInfoManager {
	
	@Autowired
	@Qualifier("supplementInfoDao")
	private SupplementInfoDao supplementInfoDao;
	
	
	public void saveSupplementInfo(SupplementInfo supplementInfo) {
		if (supplementInfo.getId() == null) {
			supplementInfoDao.insertSelective(supplementInfo);
		} else {
			supplementInfoDao.updateByPrimaryKeySelective(supplementInfo);
		}
	}
	
	
	public SupplementInfo findSupplementInfoById(Long id) {
		return supplementInfoDao.selectByPrimaryKey(id);
	}
	
	
	public List<SupplementInfo> queryList(SupplementInfoQuery query) {
		return supplementInfoDao.selectByExample(query);
	}
	
	
	public void deleteSupplementInfoById(Long id) {
		supplementInfoDao.deleteByPrimaryKey(id);
	}
	
	
	public void deleteSupplementInfo(SupplementInfoQuery query) {
		supplementInfoDao.deleteByExample(query);
	}
	
	
	public SupplementInfoPage queryPageList(SupplementInfoQuery query) {
		SupplementInfoPage supplementInfoPage = new SupplementInfoPage();
		Integer itemCount = supplementInfoDao.countByExample(query);
		query.setItemCount(itemCount);
		
		if (itemCount == 0) {
			supplementInfoPage.setValues(null);
		} else {
			supplementInfoPage.setValues(supplementInfoDao.selectPageByExample(query));
		}
		
		supplementInfoPage.setPagenation(new Pagenation(query.getPageNo(),query.getPageSize(),query.getItemCount()));
		return supplementInfoPage;
	}
}

