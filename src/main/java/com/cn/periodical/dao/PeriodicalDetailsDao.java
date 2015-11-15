/*
 * Powered By code-generator
 * Since 2015 - 2015
 */

package com.cn.periodical.dao;

import java.util.List;

import com.cn.periodical.pojo.PeriodicalDetails;
import com.cn.periodical.pojo.PeriodicalDetailsQuery;

public interface PeriodicalDetailsDao {
	int countByExample(PeriodicalDetailsQuery example);
	
	int deleteByExample(PeriodicalDetailsQuery example);
	
	int deleteByPrimaryKey(Long id);
	
	int insert(PeriodicalDetails record);
	
	int insertSelective(PeriodicalDetails record);
	
	List<PeriodicalDetails> selectByExample(PeriodicalDetailsQuery example);
	
	List<PeriodicalDetails> selectPageByExample(PeriodicalDetailsQuery example);
	
	PeriodicalDetails selectByPrimaryKey(Long id);
	
	int updateByPrimaryKeySelective(PeriodicalDetails record);
	
	int updateByPrimaryKey(PeriodicalDetails record);
}
