/*
 * Powered By code-generator
 * Since 2015 - 2015
 */

package com.cn.periodical.manager;

import java.util.List;

import com.cn.periodical.pojo.PeriodicalDetails;
import com.cn.periodical.pojo.PeriodicalDetailsPage;
import com.cn.periodical.pojo.PeriodicalDetailsQuery;

public interface PeriodicalDetailsManager {
	void savePeriodicalDetails(PeriodicalDetails periodicalDetails);

	PeriodicalDetails findPeriodicalDetailsById(Long id);
	
	List<PeriodicalDetails> queryList(PeriodicalDetailsQuery query);
	
	void deletePeriodicalDetailsById(Long id);
	
	void deletePeriodicalDetails(PeriodicalDetailsQuery query);
	
	PeriodicalDetailsPage queryPageList(PeriodicalDetailsQuery query);
}
