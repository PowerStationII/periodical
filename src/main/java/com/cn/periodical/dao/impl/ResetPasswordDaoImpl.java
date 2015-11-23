/*
 * Powered By code-generator
 * Since 2015 - 2015
 */

package com.cn.periodical.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.cn.periodical.dao.ResetPasswordDao;
import com.cn.periodical.pojo.ResetPassword;
import com.cn.periodical.pojo.ResetPasswordQuery;
import com.cn.periodical.dao.BaseDao;

@Repository("resetPasswordDao")
public class ResetPasswordDaoImpl extends BaseDao implements ResetPasswordDao {
	
	
	public int countByExample(ResetPasswordQuery example) {
		return super.getSqlSession().selectOne("ResetPasswordMapper.countByExample", example);
	}
	
	
	public int deleteByExample(ResetPasswordQuery example) {
		return super.getSqlSession().delete("ResetPasswordMapper.deleteByExample", example);
	}
	
	
	public int deleteByPrimaryKey(Long id) {
		return super.getSqlSession().delete("ResetPasswordMapper.deleteByPrimaryKey", id);
	}
	
	
	public int insert(ResetPassword record) {
		return super.getSqlSession().insert("ResetPasswordMapper.insert", record);
	}
	
	
	public int insertSelective(ResetPassword record) {
		return super.getSqlSession().insert("ResetPasswordMapper.insertSelective", record);
	}
	
	
	public List<ResetPassword> selectByExample(ResetPasswordQuery example) {
		return super.getSqlSession().selectList("ResetPasswordMapper.selectByExample", example);
	}
	
	
	public List<ResetPassword> selectPageByExample(ResetPasswordQuery example) {
		return super.getSqlSession().selectList("ResetPasswordMapper.selectPageByExample", example);
	}
	
	
	public ResetPassword selectByPrimaryKey(Long id) {
		return super.getSqlSession().selectOne("ResetPasswordMapper.selectByPrimaryKey", id);
	}
	
	
	public int updateByPrimaryKeySelective(ResetPassword record) {
		return super.getSqlSession().update("ResetPasswordMapper.updateByPrimaryKeySelective", record);
	}
	
	
	public int updateByPrimaryKey(ResetPassword record) {
		return super.getSqlSession().update("ResetPasswordMapper.updateByPrimaryKey", record);
	}
	
}
