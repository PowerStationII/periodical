/*
 * Powered By code-generator
 * Since 2015 - 2015
 */

package com.cn.periodical.manager;

import java.util.List;

import com.cn.periodical.pojo.Periodical;
import com.cn.periodical.pojo.PeriodicalPage;
import com.cn.periodical.pojo.PeriodicalQuery;

public interface PeriodicalManager {
	void savePeriodical(Periodical periodical);

	Periodical findPeriodicalById(Long id);
	
	List<Periodical> queryList(PeriodicalQuery query);
	
	void deletePeriodicalById(Long id);
	
	void deletePeriodical(PeriodicalQuery query);
	
	PeriodicalPage queryPageList(PeriodicalQuery query);
}
