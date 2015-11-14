/*
 * Powered By code-generator
 * Since 2015 - 2015
 */

package com.cn.periodical.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.cn.periodical.dao.PeriodicalInfoDao;
import com.cn.periodical.pojo.PeriodicalInfo;
import com.cn.periodical.pojo.PeriodicalInfoQuery;
import com.cn.periodical.dao.BaseDao;

@Repository("periodicalInfoDao")
public class PeriodicalInfoDaoImpl extends BaseDao implements PeriodicalInfoDao {
	
	
	public int countByExample(PeriodicalInfoQuery example) {
		return super.getSqlSession().selectOne("PeriodicalInfoMapper.countByExample", example);
	}
	
	
	public int deleteByExample(PeriodicalInfoQuery example) {
		return super.getSqlSession().delete("PeriodicalInfoMapper.deleteByExample", example);
	}
	
	
	public int deleteByPrimaryKey(Long id) {
		return super.getSqlSession().delete("PeriodicalInfoMapper.deleteByPrimaryKey", id);
	}
	
	
	public int insert(PeriodicalInfo record) {
		return super.getSqlSession().insert("PeriodicalInfoMapper.insert", record);
	}
	
	
	public int insertSelective(PeriodicalInfo record) {
		return super.getSqlSession().insert("PeriodicalInfoMapper.insertSelective", record);
	}
	
	
	public List<PeriodicalInfo> selectByExample(PeriodicalInfoQuery example) {
		return super.getSqlSession().selectList("PeriodicalInfoMapper.selectByExample", example);
	}
	
	
	public List<PeriodicalInfo> selectPageByExample(PeriodicalInfoQuery example) {
		return super.getSqlSession().selectList("PeriodicalInfoMapper.selectPageByExample", example);
	}
	
	
	public PeriodicalInfo selectByPrimaryKey(Long id) {
		return super.getSqlSession().selectOne("PeriodicalInfoMapper.selectByPrimaryKey", id);
	}
	
	
	public int updateByPrimaryKeySelective(PeriodicalInfo record) {
		return super.getSqlSession().update("PeriodicalInfoMapper.updateByPrimaryKeySelective", record);
	}
	
	
	public int updateByPrimaryKey(PeriodicalInfo record) {
		return super.getSqlSession().update("PeriodicalInfoMapper.updateByPrimaryKey", record);
	}
	
}
