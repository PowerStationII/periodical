/*
 * Powered By code-generator
 * Since 2015 - 2015
 */

package com.cn.periodical.dao;

import java.util.List;

import com.cn.periodical.pojo.ResetPassword;
import com.cn.periodical.pojo.ResetPasswordQuery;

public interface ResetPasswordDao {
	int countByExample(ResetPasswordQuery example);
	
	int deleteByExample(ResetPasswordQuery example);
	
	int deleteByPrimaryKey(Long id);
	
	int insert(ResetPassword record);
	
	int insertSelective(ResetPassword record);
	
	List<ResetPassword> selectByExample(ResetPasswordQuery example);
	
	List<ResetPassword> selectPageByExample(ResetPasswordQuery example);
	
	ResetPassword selectByPrimaryKey(Long id);
	
	int updateByPrimaryKeySelective(ResetPassword record);
	
	int updateByPrimaryKey(ResetPassword record);
}
