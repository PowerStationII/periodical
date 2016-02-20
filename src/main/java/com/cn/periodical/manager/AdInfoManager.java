/*
 * Powered By code-generator
 * Since 2015 - 2015
 */

package com.cn.periodical.manager;

import java.util.List;

import com.cn.periodical.pojo.AdInfo;
import com.cn.periodical.pojo.AdInfoPage;
import com.cn.periodical.pojo.AdInfoQuery;
import com.cn.periodical.pojo.BizAd;
import com.cn.periodical.pojo.BizAdPage;
import com.cn.periodical.pojo.BizAdQuery;

public interface AdInfoManager {
	void saveAdInfo(AdInfo adInfo);

	AdInfo findAdInfoById(Long id);
	
	List<AdInfo> queryList(AdInfoQuery query);
	
	void deleteAdInfoById(Long id);
	
	void deleteAdInfo(AdInfoQuery query);
	
	AdInfoPage queryPageList(AdInfoQuery query);
	
	List<BizAd> selectAdsForEditor(BizAd bizAd);
	
	public BizAdPage queryBizAdPageList(BizAdQuery query);

    public List<AdInfo> selectByadids(List<String> query);
	
	public int queryBizAdCount(BizAdQuery query);
}
