/*
 * Powered By code-generator
 * Since 2015 - 2015
 */

package com.cn.periodical.dao;

import java.util.List;
import java.util.Map;

import com.cn.periodical.pojo.Periodical;
import com.cn.periodical.pojo.PeriodicalInfoQuery;
import com.cn.periodical.pojo.PeriodicalQuery;

public interface PeriodicalDao {
	int countByExample(PeriodicalQuery example);
	
	int deleteByExample(PeriodicalQuery example);
	
	int deleteByPrimaryKey(Long id);
	
	int insert(Periodical record);
	
	int insertSelective(Periodical record);
	
	List<Periodical> selectByExample(PeriodicalQuery example);
	
	List<Periodical> selectPageByExample(PeriodicalQuery example);
	
	Periodical selectByPrimaryKey(Long id);
	
	int updateByPrimaryKeySelective(Periodical record);
	
	int updateByPrimaryKey(Periodical record);

    public PeriodicalInfoQuery selectPeridicalByperiodicalId(Periodical periodicalInfoQuery) ;
}
