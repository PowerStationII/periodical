/*
 * Powered By code-generator
 * Since 2015 - 2015
 */

package com.cn.periodical.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.cn.periodical.dao.SupplementInfoDao;
import com.cn.periodical.pojo.SupplementInfo;
import com.cn.periodical.pojo.SupplementInfoQuery;
import com.cn.periodical.dao.BaseDao;

@Repository("supplementInfoDao")
public class SupplementInfoDaoImpl extends BaseDao implements SupplementInfoDao {
	
	
	public int countByExample(SupplementInfoQuery example) {
		return super.getSqlSession().selectOne("SupplementInfoMapper.countByExample", example);
	}
	
	
	public int deleteByExample(SupplementInfoQuery example) {
		return super.getSqlSession().delete("SupplementInfoMapper.deleteByExample", example);
	}
	
	
	public int deleteByPrimaryKey(Long id) {
		return super.getSqlSession().delete("SupplementInfoMapper.deleteByPrimaryKey", id);
	}
	
	
	public int insert(SupplementInfo record) {
		return super.getSqlSession().insert("SupplementInfoMapper.insert", record);
	}
	
	
	public int insertSelective(SupplementInfo record) {
		return super.getSqlSession().insert("SupplementInfoMapper.insertSelective", record);
	}
	
	
	public List<SupplementInfo> selectByExample(SupplementInfoQuery example) {
		return super.getSqlSession().selectList("SupplementInfoMapper.selectByExample", example);
	}
	
	
	public List<SupplementInfo> selectPageByExample(SupplementInfoQuery example) {
		return super.getSqlSession().selectList("SupplementInfoMapper.selectPageByExample", example);
	}
	
	
	public SupplementInfo selectByPrimaryKey(Long id) {
		return super.getSqlSession().selectOne("SupplementInfoMapper.selectByPrimaryKey", id);
	}
	
	
	public int updateByPrimaryKeySelective(SupplementInfo record) {
		return super.getSqlSession().update("SupplementInfoMapper.updateByPrimaryKeySelective", record);
	}
	
	
	public int updateByPrimaryKey(SupplementInfo record) {
		return super.getSqlSession().update("SupplementInfoMapper.updateByPrimaryKey", record);
	}
	
}
