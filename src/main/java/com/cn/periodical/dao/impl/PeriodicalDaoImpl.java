/*
 * Powered By code-generator
 * Since 2015 - 2015
 */

package com.cn.periodical.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.cn.periodical.dao.PeriodicalDao;
import com.cn.periodical.pojo.Periodical;
import com.cn.periodical.pojo.PeriodicalQuery;
import com.cn.periodical.dao.BaseDao;

@Repository("periodicalDao")
public class PeriodicalDaoImpl extends BaseDao implements PeriodicalDao {
	
	
	public int countByExample(PeriodicalQuery example) {
		return super.getSqlSession().selectOne("PeriodicalMapper.countByExample", example);
	}
	
	
	public int deleteByExample(PeriodicalQuery example) {
		return super.getSqlSession().delete("PeriodicalMapper.deleteByExample", example);
	}
	
	
	public int deleteByPrimaryKey(Long id) {
		return super.getSqlSession().delete("PeriodicalMapper.deleteByPrimaryKey", id);
	}
	
	
	public int insert(Periodical record) {
		return super.getSqlSession().insert("PeriodicalMapper.insert", record);
	}
	
	
	public int insertSelective(Periodical record) {
		return super.getSqlSession().insert("PeriodicalMapper.insertSelective", record);
	}
	
	
	public List<Periodical> selectByExample(PeriodicalQuery example) {
		return super.getSqlSession().selectList("PeriodicalMapper.selectByExample", example);
	}
	
	
	public List<Periodical> selectPageByExample(PeriodicalQuery example) {
		return super.getSqlSession().selectList("PeriodicalMapper.selectPageByExample", example);
	}
	
	
	public Periodical selectByPrimaryKey(Long id) {
		return super.getSqlSession().selectOne("PeriodicalMapper.selectByPrimaryKey", id);
	}
	
	
	public int updateByPrimaryKeySelective(Periodical record) {
		return super.getSqlSession().update("PeriodicalMapper.updateByPrimaryKeySelective", record);
	}
	
	
	public int updateByPrimaryKey(Periodical record) {
		return super.getSqlSession().update("PeriodicalMapper.updateByPrimaryKey", record);
	}
	
}
