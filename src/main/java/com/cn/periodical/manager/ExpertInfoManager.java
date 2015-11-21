/*
 * Powered By code-generator
 * Since 2015 - 2015
 */

package com.cn.periodical.manager;

import java.util.List;

import com.cn.periodical.pojo.BizEditor;
import com.cn.periodical.pojo.ExpertInfo;
import com.cn.periodical.pojo.ExpertInfoPage;
import com.cn.periodical.pojo.ExpertInfoQuery;

public interface ExpertInfoManager {
	void saveExpertInfo(ExpertInfo expertInfo);

	ExpertInfo findExpertInfoById(Long id);
	
	List<ExpertInfo> queryList(ExpertInfoQuery query);
	
	void deleteExpertInfoById(Long id);
	
	void deleteExpertInfo(ExpertInfoQuery query);
	
	ExpertInfoPage queryPageList(ExpertInfoQuery query);
	
	List<BizEditor> queryExperts(BizEditor be);
}
