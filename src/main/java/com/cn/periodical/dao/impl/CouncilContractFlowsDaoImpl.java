/*
 * Powered By code-generator
 * Since 2015 - 2015
 */

package com.cn.periodical.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.cn.periodical.dao.CouncilContractFlowsDao;
import com.cn.periodical.pojo.CouncilContractFlows;
import com.cn.periodical.pojo.CouncilContractFlowsQuery;
import com.cn.periodical.dao.BaseDao;

@Repository("councilContractFlowsDao")
public class CouncilContractFlowsDaoImpl extends BaseDao implements CouncilContractFlowsDao {
	
	
	public int countByExample(CouncilContractFlowsQuery example) {
		return super.getSqlSession().selectOne("CouncilContractFlowsMapper.countByExample", example);
	}
	
	
	public int deleteByExample(CouncilContractFlowsQuery example) {
		return super.getSqlSession().delete("CouncilContractFlowsMapper.deleteByExample", example);
	}
	
	
	public int deleteByPrimaryKey(Long id) {
		return super.getSqlSession().delete("CouncilContractFlowsMapper.deleteByPrimaryKey", id);
	}
	
	
	public int insert(CouncilContractFlows record) {
		return super.getSqlSession().insert("CouncilContractFlowsMapper.insert", record);
	}
	
	
	public int insertSelective(CouncilContractFlows record) {
		return super.getSqlSession().insert("CouncilContractFlowsMapper.insertSelective", record);
	}
	
	
	public List<CouncilContractFlows> selectByExample(CouncilContractFlowsQuery example) {
		return super.getSqlSession().selectList("CouncilContractFlowsMapper.selectByExample", example);
	}
	
	
	public List<CouncilContractFlows> selectPageByExample(CouncilContractFlowsQuery example) {
		return super.getSqlSession().selectList("CouncilContractFlowsMapper.selectPageByExample", example);
	}
	
	
	public CouncilContractFlows selectByPrimaryKey(Long id) {
		return super.getSqlSession().selectOne("CouncilContractFlowsMapper.selectByPrimaryKey", id);
	}
	
	
	public int updateByPrimaryKeySelective(CouncilContractFlows record) {
		return super.getSqlSession().update("CouncilContractFlowsMapper.updateByPrimaryKeySelective", record);
	}
	
	
	public int updateByPrimaryKey(CouncilContractFlows record) {
		return super.getSqlSession().update("CouncilContractFlowsMapper.updateByPrimaryKey", record);
	}
	
}
