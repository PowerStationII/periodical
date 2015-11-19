/*
 * Powered By code-generator
 * Since 2015 - 2015
 */

package com.cn.periodical.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.cn.periodical.dao.AdFlowsDao;
import com.cn.periodical.pojo.AdFlows;
import com.cn.periodical.pojo.AdFlowsQuery;
import com.cn.periodical.dao.BaseDao;

@Repository("adFlowsDao")
public class AdFlowsDaoImpl extends BaseDao implements AdFlowsDao {
	
	
	public int countByExample(AdFlowsQuery example) {
		return super.getSqlSession().selectOne("AdFlowsMapper.countByExample", example);
	}
	
	
	public int deleteByExample(AdFlowsQuery example) {
		return super.getSqlSession().delete("AdFlowsMapper.deleteByExample", example);
	}
	
	
	public int deleteByPrimaryKey(Long id) {
		return super.getSqlSession().delete("AdFlowsMapper.deleteByPrimaryKey", id);
	}
	
	
	public int insert(AdFlows record) {
		return super.getSqlSession().insert("AdFlowsMapper.insert", record);
	}
	
	
	public int insertSelective(AdFlows record) {
		return super.getSqlSession().insert("AdFlowsMapper.insertSelective", record);
	}
	
	
	public List<AdFlows> selectByExample(AdFlowsQuery example) {
		return super.getSqlSession().selectList("AdFlowsMapper.selectByExample", example);
	}
	
	
	public List<AdFlows> selectPageByExample(AdFlowsQuery example) {
		return super.getSqlSession().selectList("AdFlowsMapper.selectPageByExample", example);
	}
	
	
	public AdFlows selectByPrimaryKey(Long id) {
		return super.getSqlSession().selectOne("AdFlowsMapper.selectByPrimaryKey", id);
	}
	
	
	public int updateByPrimaryKeySelective(AdFlows record) {
		return super.getSqlSession().update("AdFlowsMapper.updateByPrimaryKeySelective", record);
	}
	
	
	public int updateByPrimaryKey(AdFlows record) {
		return super.getSqlSession().update("AdFlowsMapper.updateByPrimaryKey", record);
	}
	
}
