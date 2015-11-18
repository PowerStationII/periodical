/*
 * Powered By code-generator
 * Since 2015 - 2015
 */

package com.cn.periodical.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.cn.periodical.dao.ReaderInfoDao;
import com.cn.periodical.pojo.ReaderInfo;
import com.cn.periodical.pojo.ReaderInfoQuery;
import com.cn.periodical.dao.BaseDao;

@Repository("readerInfoDao")
public class ReaderInfoDaoImpl extends BaseDao implements ReaderInfoDao {
	
	
	public int countByExample(ReaderInfoQuery example) {
		return super.getSqlSession().selectOne("ReaderInfoMapper.countByExample", example);
	}
	
	
	public int deleteByExample(ReaderInfoQuery example) {
		return super.getSqlSession().delete("ReaderInfoMapper.deleteByExample", example);
	}
	
	
	public int deleteByPrimaryKey(Long id) {
		return super.getSqlSession().delete("ReaderInfoMapper.deleteByPrimaryKey", id);
	}
	
	
	public int insert(ReaderInfo record) {
		return super.getSqlSession().insert("ReaderInfoMapper.insert", record);
	}
	
	
	public int insertSelective(ReaderInfo record) {
		return super.getSqlSession().insert("ReaderInfoMapper.insertSelective", record);
	}
	
	
	public List<ReaderInfo> selectByExample(ReaderInfoQuery example) {
		return super.getSqlSession().selectList("ReaderInfoMapper.selectByExample", example);
	}
	
	
	public List<ReaderInfo> selectPageByExample(ReaderInfoQuery example) {
		return super.getSqlSession().selectList("ReaderInfoMapper.selectPageByExample", example);
	}
	
	
	public ReaderInfo selectByPrimaryKey(Long id) {
		return super.getSqlSession().selectOne("ReaderInfoMapper.selectByPrimaryKey", id);
	}
	
	
	public int updateByPrimaryKeySelective(ReaderInfo record) {
		return super.getSqlSession().update("ReaderInfoMapper.updateByPrimaryKeySelective", record);
	}
	
	
	public int updateByPrimaryKey(ReaderInfo record) {
		return super.getSqlSession().update("ReaderInfoMapper.updateByPrimaryKey", record);
	}
	
}
