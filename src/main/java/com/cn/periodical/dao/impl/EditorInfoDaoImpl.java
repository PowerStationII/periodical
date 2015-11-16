/*
 * Powered By code-generator
 * Since 2015 - 2015
 */

package com.cn.periodical.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.cn.periodical.dao.EditorInfoDao;
import com.cn.periodical.pojo.EditorInfo;
import com.cn.periodical.pojo.EditorInfoQuery;
import com.cn.periodical.dao.BaseDao;

@Repository("editorInfoDao")
public class EditorInfoDaoImpl extends BaseDao implements EditorInfoDao {
	
	
	public int countByExample(EditorInfoQuery example) {
		return super.getSqlSession().selectOne("EditorInfoMapper.countByExample", example);
	}
	
	
	public int deleteByExample(EditorInfoQuery example) {
		return super.getSqlSession().delete("EditorInfoMapper.deleteByExample", example);
	}
	
	
	public int deleteByPrimaryKey(Long id) {
		return super.getSqlSession().delete("EditorInfoMapper.deleteByPrimaryKey", id);
	}
	
	
	public int insert(EditorInfo record) {
		return super.getSqlSession().insert("EditorInfoMapper.insert", record);
	}
	
	
	public int insertSelective(EditorInfo record) {
		return super.getSqlSession().insert("EditorInfoMapper.insertSelective", record);
	}
	
	
	public List<EditorInfo> selectByExample(EditorInfoQuery example) {
		return super.getSqlSession().selectList("EditorInfoMapper.selectByExample", example);
	}
	
	
	public List<EditorInfo> selectPageByExample(EditorInfoQuery example) {
		return super.getSqlSession().selectList("EditorInfoMapper.selectPageByExample", example);
	}
	
	
	public EditorInfo selectByPrimaryKey(Long id) {
		return super.getSqlSession().selectOne("EditorInfoMapper.selectByPrimaryKey", id);
	}
	
	
	public int updateByPrimaryKeySelective(EditorInfo record) {
		return super.getSqlSession().update("EditorInfoMapper.updateByPrimaryKeySelective", record);
	}
	
	
	public int updateByPrimaryKey(EditorInfo record) {
		return super.getSqlSession().update("EditorInfoMapper.updateByPrimaryKey", record);
	}
	
}
