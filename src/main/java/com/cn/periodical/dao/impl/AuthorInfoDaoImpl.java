/*
 * Powered By code-generator
 * Since 2015 - 2015
 */

package com.cn.periodical.dao.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.cn.periodical.dao.AuthorInfoDao;
import com.cn.periodical.dao.BaseDao;
import com.cn.periodical.pojo.AuthorInfo;
import com.cn.periodical.pojo.AuthorInfoQuery;

@Repository("authorInfoDao")
public class AuthorInfoDaoImpl extends BaseDao implements AuthorInfoDao {
	
	
	public int countByExample(AuthorInfoQuery example) {
		return super.getSqlSession().selectOne("AuthorInfoMapper.countByExample", example);
	}
	
	
	public int deleteByExample(AuthorInfoQuery example) {
		return super.getSqlSession().delete("AuthorInfoMapper.deleteByExample", example);
	}
	
	
	public int deleteByPrimaryKey(Long id) {
		return super.getSqlSession().delete("AuthorInfoMapper.deleteByPrimaryKey", id);
	}
	
	
	public int insert(AuthorInfo record) {
		return super.getSqlSession().insert("AuthorInfoMapper.insert", record);
	}
	
	
	public int insertSelective(AuthorInfo record) {
		return super.getSqlSession().insert("AuthorInfoMapper.insertSelective", record);
	}

	
	public List<AuthorInfo> selectByExample(AuthorInfoQuery example) {
		return super.getSqlSession().selectList("AuthorInfoMapper.selectByExample", example);
	}
	
	
	public List<AuthorInfo> selectPageByExample(AuthorInfoQuery example) {
		return super.getSqlSession().selectList("AuthorInfoMapper.selectPageByExample", example);
	}
	
	
	public AuthorInfo selectByPrimaryKey(Long id) {
		return super.getSqlSession().selectOne("AuthorInfoMapper.selectByPrimaryKey", id);
	}
	public List<AuthorInfo> selectByArticleIdKey(String articleId) {
		return super.getSqlSession().selectList("AuthorInfoMapper.selectByArticleIdKey", articleId);
	}

	
	public int updateByPrimaryKeySelective(AuthorInfo record) {
		return super.getSqlSession().update("AuthorInfoMapper.updateByPrimaryKeySelective", record);
	}
	
	
	public int updateByPrimaryKey(AuthorInfo record) {
		return super.getSqlSession().update("AuthorInfoMapper.updateByPrimaryKey", record);
	}

    public List<Object> selectAuthorByArticl(String articleId){
        return super.getSqlSession().selectList("AuthorInfoMapper.selectAuthorByArticl", articleId);
    }
	
}
