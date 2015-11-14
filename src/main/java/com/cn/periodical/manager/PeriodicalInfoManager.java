/*
 * Powered By code-generator
 * Since 2015 - 2015
 */

package com.cn.periodical.manager;

import java.util.List;

import com.cn.periodical.pojo.PeriodicalInfo;
import com.cn.periodical.pojo.PeriodicalInfoPage;
import com.cn.periodical.pojo.PeriodicalInfoQuery;

public interface PeriodicalInfoManager {
	void savePeriodicalInfo(PeriodicalInfo periodicalInfo);

	PeriodicalInfo findPeriodicalInfoById(Long id);
	
	List<PeriodicalInfo> queryList(PeriodicalInfoQuery query);
	
	void deletePeriodicalInfoById(Long id);
	
	void deletePeriodicalInfo(PeriodicalInfoQuery query);
	
	PeriodicalInfoPage queryPageList(PeriodicalInfoQuery query);
}
