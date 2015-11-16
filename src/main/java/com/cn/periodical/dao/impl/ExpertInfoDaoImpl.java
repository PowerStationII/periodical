/*
 * Powered By code-generator
 * Since 2015 - 2015
 */

package com.cn.periodical.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.cn.periodical.dao.ExpertInfoDao;
import com.cn.periodical.pojo.ExpertInfo;
import com.cn.periodical.pojo.ExpertInfoQuery;
import com.cn.periodical.dao.BaseDao;

@Repository("expertInfoDao")
public class ExpertInfoDaoImpl extends BaseDao implements ExpertInfoDao {
	
	
	public int countByExample(ExpertInfoQuery example) {
		return super.getSqlSession().selectOne("ExpertInfoMapper.countByExample", example);
	}
	
	
	public int deleteByExample(ExpertInfoQuery example) {
		return super.getSqlSession().delete("ExpertInfoMapper.deleteByExample", example);
	}
	
	
	public int deleteByPrimaryKey(Long id) {
		return super.getSqlSession().delete("ExpertInfoMapper.deleteByPrimaryKey", id);
	}
	
	
	public int insert(ExpertInfo record) {
		return super.getSqlSession().insert("ExpertInfoMapper.insert", record);
	}
	
	
	public int insertSelective(ExpertInfo record) {
		return super.getSqlSession().insert("ExpertInfoMapper.insertSelective", record);
	}
	
	
	public List<ExpertInfo> selectByExample(ExpertInfoQuery example) {
		return super.getSqlSession().selectList("ExpertInfoMapper.selectByExample", example);
	}
	
	
	public List<ExpertInfo> selectPageByExample(ExpertInfoQuery example) {
		return super.getSqlSession().selectList("ExpertInfoMapper.selectPageByExample", example);
	}
	
	
	public ExpertInfo selectByPrimaryKey(Long id) {
		return super.getSqlSession().selectOne("ExpertInfoMapper.selectByPrimaryKey", id);
	}
	
	
	public int updateByPrimaryKeySelective(ExpertInfo record) {
		return super.getSqlSession().update("ExpertInfoMapper.updateByPrimaryKeySelective", record);
	}
	
	
	public int updateByPrimaryKey(ExpertInfo record) {
		return super.getSqlSession().update("ExpertInfoMapper.updateByPrimaryKey", record);
	}
	
}
