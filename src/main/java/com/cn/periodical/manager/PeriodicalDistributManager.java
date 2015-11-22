/*
 * Powered By code-generator
 * Since 2015 - 2015
 */

package com.cn.periodical.manager;

import java.util.List;

import com.cn.periodical.pojo.PeriodicalDistribut;
import com.cn.periodical.pojo.PeriodicalDistributPage;
import com.cn.periodical.pojo.PeriodicalDistributQuery;

public interface PeriodicalDistributManager {
	void savePeriodicalDistribut(PeriodicalDistribut periodicalDistribut);

	PeriodicalDistribut findPeriodicalDistributById(Long id);
	
	List<PeriodicalDistribut> queryList(PeriodicalDistributQuery query);
	
	void deletePeriodicalDistributById(Long id);
	
	void deletePeriodicalDistribut(PeriodicalDistributQuery query);
	
	PeriodicalDistributPage queryPageList(PeriodicalDistributQuery query);
}
