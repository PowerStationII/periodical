/*
 * Powered By code-generator
 * Since 2015 - 2015
 */

package com.cn.periodical.manager;

import java.util.List;

import com.cn.periodical.pojo.SupplementInfo;
import com.cn.periodical.pojo.SupplementInfoPage;
import com.cn.periodical.pojo.SupplementInfoQuery;

public interface SupplementInfoManager {
	void saveSupplementInfo(SupplementInfo supplementInfo);

	SupplementInfo findSupplementInfoById(Long id);
	
	List<SupplementInfo> queryList(SupplementInfoQuery query);
	
	void deleteSupplementInfoById(Long id);
	
	void deleteSupplementInfo(SupplementInfoQuery query);
	
	SupplementInfoPage queryPageList(SupplementInfoQuery query);
}
