/*
 * Powered By code-generator
 * Since 2015 - 2015
 */

package com.cn.periodical.dao;

import java.util.List;

import com.cn.periodical.pojo.PeriodicalDistribut;
import com.cn.periodical.pojo.PeriodicalDistributQuery;

public interface PeriodicalDistributDao {
	int countByExample(PeriodicalDistributQuery example);
	
	int deleteByExample(PeriodicalDistributQuery example);
	
	int deleteByPrimaryKey(Long id);
	int deletePeriodicalDistributByOrderNo(String orderNo);

	int insert(PeriodicalDistribut record);
	
	int insertSelective(PeriodicalDistribut record);
	
	List<PeriodicalDistribut> selectByExample(PeriodicalDistributQuery example);
	
	List<PeriodicalDistribut> selectPageByExample(PeriodicalDistributQuery example);
	
	PeriodicalDistribut selectByPrimaryKey(Long id);
	
	int updateByPrimaryKeySelective(PeriodicalDistribut record);
	
	int updateByPrimaryKey(PeriodicalDistribut record);
}
