/*
 * Powered By code-generator
 * Since 2015 - 2015
 */

package com.cn.periodical.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.cn.periodical.dao.CouncilInfoDao;
import com.cn.periodical.pojo.BizCouncil;
import com.cn.periodical.pojo.CouncilInfo;
import com.cn.periodical.pojo.CouncilInfoQuery;
import com.cn.periodical.dao.BaseDao;

@Repository("councilInfoDao")
public class CouncilInfoDaoImpl extends BaseDao implements CouncilInfoDao {
	
	
	public int countByExample(CouncilInfoQuery example) {
		return super.getSqlSession().selectOne("CouncilInfoMapper.countByExample", example);
	}
	
	
	public int deleteByExample(CouncilInfoQuery example) {
		return super.getSqlSession().delete("CouncilInfoMapper.deleteByExample", example);
	}
	
	
	public int deleteByPrimaryKey(Long id) {
		return super.getSqlSession().delete("CouncilInfoMapper.deleteByPrimaryKey", id);
	}
	
	
	public int insert(CouncilInfo record) {
		return super.getSqlSession().insert("CouncilInfoMapper.insert", record);
	}
	
	
	public int insertSelective(CouncilInfo record) {
		return super.getSqlSession().insert("CouncilInfoMapper.insertSelective", record);
	}
	
	
	public List<CouncilInfo> selectByExample(CouncilInfoQuery example) {
		return super.getSqlSession().selectList("CouncilInfoMapper.selectByExample", example);
	}
	
	
	public List<CouncilInfo> selectPageByExample(CouncilInfoQuery example) {
		return super.getSqlSession().selectList("CouncilInfoMapper.selectPageByExample", example);
	}
	
	
	public CouncilInfo selectByPrimaryKey(Long id) {
		return super.getSqlSession().selectOne("CouncilInfoMapper.selectByPrimaryKey", id);
	}
	
	
	public int updateByPrimaryKeySelective(CouncilInfo record) {
		return super.getSqlSession().update("CouncilInfoMapper.updateByPrimaryKeySelective", record);
	}
	
	
	public int updateByPrimaryKey(CouncilInfo record) {
		return super.getSqlSession().update("CouncilInfoMapper.updateByPrimaryKey", record);
	}


	public List<BizCouncil> queryBizCouncil(BizCouncil reqDto) {
		// TODO Auto-generated method stub
		return super.getSqlSession().selectList("CouncilInfoMapper.qryBizCouncil", reqDto);
	}
	
}
