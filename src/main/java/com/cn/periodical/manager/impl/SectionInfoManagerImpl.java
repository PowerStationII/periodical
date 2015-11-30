/*
 * Powered By code-generator
 * Since 2015 - 2015
 */

package com.cn.periodical.manager.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.cn.periodical.dao.SectionInfoDao;
import com.cn.periodical.manager.SectionInfoManager;
import com.cn.periodical.pojo.SectionInfo;
import com.cn.periodical.pojo.SectionInfoPage;
import com.cn.periodical.pojo.SectionInfoQuery;
import com.cn.periodical.utils.Pagenation;

@Component("sectionInfoManager")
public class SectionInfoManagerImpl implements SectionInfoManager {
	
	@Autowired
	@Qualifier("sectionInfoDao")
	private SectionInfoDao sectionInfoDao;
	
	
	public void saveSectionInfo(SectionInfo sectionInfo) {
		if (sectionInfo.getId() == null) {
			sectionInfoDao.insertSelective(sectionInfo);
		} else {
			sectionInfoDao.updateByPrimaryKeySelective(sectionInfo);
		}
	}
	
	
	public SectionInfo findSectionInfoById(Long id) {
		return sectionInfoDao.selectByPrimaryKey(id);
	}
	
	
	public List<SectionInfo> queryList(SectionInfoQuery query) {
		return sectionInfoDao.selectByExample(query);
	}
	
	
	public void deleteSectionInfoById(Long id) {
		sectionInfoDao.deleteByPrimaryKey(id);
	}
	
	
	public void deleteSectionInfo(SectionInfoQuery query) {
		sectionInfoDao.deleteByExample(query);
	}
	
	
	public SectionInfoPage queryPageList(SectionInfoQuery query) {
		SectionInfoPage sectionInfoPage = new SectionInfoPage();
		Integer itemCount = sectionInfoDao.countByExample(query);
		query.setItemCount(itemCount);
		
		if (itemCount == 0) {
			sectionInfoPage.setValues(null);
		} else {
			sectionInfoPage.setValues(sectionInfoDao.selectPageByExample(query));
		}
		
		sectionInfoPage.setPagenation(new Pagenation(query.getPageNo(),query.getPageSize(),query.getItemCount()));
		return sectionInfoPage;
	}


	public List<SectionInfo> selectByExampleForAd(SectionInfoQuery query) {
		// TODO Auto-generated method stub
		return sectionInfoDao.selectByExampleForAd(query);
	}
}

