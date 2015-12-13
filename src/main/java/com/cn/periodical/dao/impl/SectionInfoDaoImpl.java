/*
 * Powered By code-generator
 * Since 2015 - 2015
 */

package com.cn.periodical.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.cn.periodical.dao.SectionInfoDao;
import com.cn.periodical.pojo.SectionInfo;
import com.cn.periodical.pojo.SectionInfoQuery;
import com.cn.periodical.dao.BaseDao;

@Repository("sectionInfoDao")
public class SectionInfoDaoImpl extends BaseDao implements SectionInfoDao {
	
	
	public int countByExample(SectionInfoQuery example) {
		return super.getSqlSession().selectOne("SectionInfoMapper.countByExample", example);
	}
	
	
	public int deleteByExample(SectionInfoQuery example) {
		return super.getSqlSession().delete("SectionInfoMapper.deleteByExample", example);
	}
	
	
	public int deleteByPrimaryKey(Long id) {
		return super.getSqlSession().delete("SectionInfoMapper.deleteByPrimaryKey", id);
	}
	
	
	public int insert(SectionInfo record) {
		return super.getSqlSession().insert("SectionInfoMapper.insert", record);
	}
	
	
	public int insertSelective(SectionInfo record) {
		return super.getSqlSession().insert("SectionInfoMapper.insertSelective", record);
	}
	
	
	public List<SectionInfo> selectByExample(SectionInfoQuery example) {
		return super.getSqlSession().selectList("SectionInfoMapper.selectByExample", example);
	}
	public List<SectionInfo> selectByExampleForAd(SectionInfoQuery example) {
		return super.getSqlSession().selectList("SectionInfoMapper.selectByExampleForAd", example);
	}
	
	
	public List<SectionInfo> selectPageByExample(SectionInfoQuery example) {
		return super.getSqlSession().selectList("SectionInfoMapper.selectPageByExample", example);
	}
	
	
	public SectionInfo selectByPrimaryKey(Long id) {
		return super.getSqlSession().selectOne("SectionInfoMapper.selectByPrimaryKey", id);
	}
	
	
	public int updateByPrimaryKeySelective(SectionInfo record) {
		return super.getSqlSession().update("SectionInfoMapper.updateByPrimaryKeySelective", record);
	}
	
	
	public int updateByPrimaryKey(SectionInfo record) {
		return super.getSqlSession().update("SectionInfoMapper.updateByPrimaryKey", record);
	}


	public List<SectionInfo> queryListForGroupAticle(SectionInfoQuery query) {
		// TODO Auto-generated method stub
		return super.getSqlSession().selectList("SectionInfoMapper.queryListForGroupAticle", query);
	}
	
}
