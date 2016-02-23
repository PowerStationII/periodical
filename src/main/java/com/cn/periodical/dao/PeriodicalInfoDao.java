/*
 * Powered By code-generator
 * Since 2015 - 2015
 */

package com.cn.periodical.dao;

import java.util.List;

import com.cn.periodical.pojo.PeriodicalInfo;
import com.cn.periodical.pojo.PeriodicalInfoQuery;

public interface PeriodicalInfoDao {
	int countByExample(PeriodicalInfoQuery example);
	
	int deleteByExample(PeriodicalInfoQuery example);
	
	int deleteByPrimaryKey(Long id);
	
	int insert(PeriodicalInfo record);
	
	int insertSelective(PeriodicalInfo record);
	
	List<PeriodicalInfo> selectByExample(PeriodicalInfoQuery example);
	
	List<PeriodicalInfo> selectPageByExample(PeriodicalInfoQuery example);
	
	PeriodicalInfo selectByPrimaryKey(Long id);
	
	int updateByPrimaryKeySelective(PeriodicalInfo record);
	
	int updateByPrimaryKey(PeriodicalInfo record);
	
	public PeriodicalInfo selectByPeriodicalId(PeriodicalInfoQuery periodicalInfoQuery);
}
