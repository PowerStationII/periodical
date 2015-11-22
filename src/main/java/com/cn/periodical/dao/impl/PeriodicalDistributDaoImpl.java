/*
 * Powered By code-generator
 * Since 2015 - 2015
 */

package com.cn.periodical.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.cn.periodical.dao.PeriodicalDistributDao;
import com.cn.periodical.pojo.PeriodicalDistribut;
import com.cn.periodical.pojo.PeriodicalDistributQuery;
import com.cn.periodical.dao.BaseDao;

@Repository("periodicalDistributDao")
public class PeriodicalDistributDaoImpl extends BaseDao implements PeriodicalDistributDao {
	
	
	public int countByExample(PeriodicalDistributQuery example) {
		return super.getSqlSession().selectOne("PeriodicalDistributMapper.countByExample", example);
	}
	
	
	public int deleteByExample(PeriodicalDistributQuery example) {
		return super.getSqlSession().delete("PeriodicalDistributMapper.deleteByExample", example);
	}
	
	
	public int deleteByPrimaryKey(Long id) {
		return super.getSqlSession().delete("PeriodicalDistributMapper.deleteByPrimaryKey", id);
	}
	
	
	public int insert(PeriodicalDistribut record) {
		return super.getSqlSession().insert("PeriodicalDistributMapper.insert", record);
	}
	
	
	public int insertSelective(PeriodicalDistribut record) {
		return super.getSqlSession().insert("PeriodicalDistributMapper.insertSelective", record);
	}
	
	
	public List<PeriodicalDistribut> selectByExample(PeriodicalDistributQuery example) {
		return super.getSqlSession().selectList("PeriodicalDistributMapper.selectByExample", example);
	}
	
	
	public List<PeriodicalDistribut> selectPageByExample(PeriodicalDistributQuery example) {
		return super.getSqlSession().selectList("PeriodicalDistributMapper.selectPageByExample", example);
	}
	
	
	public PeriodicalDistribut selectByPrimaryKey(Long id) {
		return super.getSqlSession().selectOne("PeriodicalDistributMapper.selectByPrimaryKey", id);
	}
	
	
	public int updateByPrimaryKeySelective(PeriodicalDistribut record) {
		return super.getSqlSession().update("PeriodicalDistributMapper.updateByPrimaryKeySelective", record);
	}
	
	
	public int updateByPrimaryKey(PeriodicalDistribut record) {
		return super.getSqlSession().update("PeriodicalDistributMapper.updateByPrimaryKey", record);
	}
	
}
