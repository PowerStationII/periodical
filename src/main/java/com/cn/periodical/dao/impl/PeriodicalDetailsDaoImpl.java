/*
 * Powered By code-generator
 * Since 2015 - 2015
 */

package com.cn.periodical.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.cn.periodical.dao.PeriodicalDetailsDao;
import com.cn.periodical.pojo.PeriodicalDetails;
import com.cn.periodical.pojo.PeriodicalDetailsQuery;
import com.cn.periodical.dao.BaseDao;

@Repository("periodicalDetailsDao")
public class PeriodicalDetailsDaoImpl extends BaseDao implements PeriodicalDetailsDao {
	
	
	public int countByExample(PeriodicalDetailsQuery example) {
		return super.getSqlSession().selectOne("PeriodicalDetailsMapper.countByExample", example);
	}
	
	
	public int deleteByExample(PeriodicalDetailsQuery example) {
		return super.getSqlSession().delete("PeriodicalDetailsMapper.deleteByExample", example);
	}
	
	
	public int deleteByPrimaryKey(Long id) {
		return super.getSqlSession().delete("PeriodicalDetailsMapper.deleteByPrimaryKey", id);
	}
	
	
	public int insert(PeriodicalDetails record) {
		return super.getSqlSession().insert("PeriodicalDetailsMapper.insert", record);
	}
	
	
	public int insertSelective(PeriodicalDetails record) {
		return super.getSqlSession().insert("PeriodicalDetailsMapper.insertSelective", record);
	}
	
	
	public List<PeriodicalDetails> selectByExample(PeriodicalDetailsQuery example) {
		return super.getSqlSession().selectList("PeriodicalDetailsMapper.selectByExample", example);
	}
	
	
	public List<PeriodicalDetails> selectPageByExample(PeriodicalDetailsQuery example) {
		return super.getSqlSession().selectList("PeriodicalDetailsMapper.selectPageByExample", example);
	}
	
	
	public PeriodicalDetails selectByPrimaryKey(Long id) {
		return super.getSqlSession().selectOne("PeriodicalDetailsMapper.selectByPrimaryKey", id);
	}
	
	
	public int updateByPrimaryKeySelective(PeriodicalDetails record) {
		return super.getSqlSession().update("PeriodicalDetailsMapper.updateByPrimaryKeySelective", record);
	}
	
	
	public int updateByPrimaryKey(PeriodicalDetails record) {
		return super.getSqlSession().update("PeriodicalDetailsMapper.updateByPrimaryKey", record);
	}
	
}
