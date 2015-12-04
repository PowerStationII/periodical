/*
 * Powered By code-generator
 * Since 2015 - 2015
 */

package com.cn.periodical.manager.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.cn.periodical.dao.AdInfoDao;
import com.cn.periodical.manager.AdInfoManager;
import com.cn.periodical.pojo.AdInfo;
import com.cn.periodical.pojo.AdInfoPage;
import com.cn.periodical.pojo.AdInfoQuery;
import com.cn.periodical.pojo.BizAd;
import com.cn.periodical.utils.Pagenation;

@Component("adInfoManager")
public class AdInfoManagerImpl implements AdInfoManager {
	
	@Autowired
	@Qualifier("adInfoDao")
	public AdInfoDao adInfoDao;
	
	
	public void saveAdInfo(AdInfo adInfo) {
		if (adInfo.getId() == null) {
			adInfoDao.insertSelective(adInfo);
		} else {
			adInfoDao.updateByPrimaryKeySelective(adInfo);
		}
	}
	
	
	public AdInfo findAdInfoById(Long id) {
		return adInfoDao.selectByPrimaryKey(id);
	}
	
	
	public List<AdInfo> queryList(AdInfoQuery query) {
		return adInfoDao.selectByExample(query);
	}
	
	
	public void deleteAdInfoById(Long id) {
		adInfoDao.deleteByPrimaryKey(id);
	}
	
	
	public void deleteAdInfo(AdInfoQuery query) {
		adInfoDao.deleteByExample(query);
	}
	
	
	public AdInfoPage queryPageList(AdInfoQuery query) {
		AdInfoPage adInfoPage = new AdInfoPage();
		Integer itemCount = adInfoDao.countByExample(query);
		query.setItemCount(itemCount);
		
		if (itemCount == 0) {
			adInfoPage.setValues(null);
		} else {
			adInfoPage.setValues(adInfoDao.selectPageByExample(query));
		}
		
		adInfoPage.setPagenation(new Pagenation(query.getPageNo(),query.getPageSize(),query.getItemCount()));
		return adInfoPage;
	}


	public List<BizAd> selectAdsForEditor(BizAd bizAd) {
		// TODO Auto-generated method stub
		return adInfoDao.selectAdsForEditor(bizAd);
	}
}

