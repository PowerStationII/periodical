/*
 * Powered By code-generator
 * Since 2015 - 2015
 */

package com.cn.periodical.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.cn.periodical.dao.ArticleInfoExtendDao;
import com.cn.periodical.pojo.ArticleInfoExtend;
import com.cn.periodical.pojo.ArticleInfoExtendQuery;
import com.cn.periodical.dao.BaseDao;

@Repository("articleInfoExtendDao")
public class ArticleInfoExtendDaoImpl extends BaseDao implements ArticleInfoExtendDao {
	
	
	public int countByExample(ArticleInfoExtendQuery example) {
		return super.getSqlSession().selectOne("ArticleInfoExtendMapper.countByExample", example);
	}
	
	
	public int deleteByExample(ArticleInfoExtendQuery example) {
		return super.getSqlSession().delete("ArticleInfoExtendMapper.deleteByExample", example);
	}
	
	
	public int deleteByPrimaryKey(Long id) {
		return super.getSqlSession().delete("ArticleInfoExtendMapper.deleteByPrimaryKey", id);
	}
	
	
	public int insert(ArticleInfoExtend record) {
		return super.getSqlSession().insert("ArticleInfoExtendMapper.insert", record);
	}
	
	
	public int insertSelective(ArticleInfoExtend record) {
		return super.getSqlSession().insert("ArticleInfoExtendMapper.insertSelective", record);
	}
	
	
	public List<ArticleInfoExtend> selectByExample(ArticleInfoExtendQuery example) {
		return super.getSqlSession().selectList("ArticleInfoExtendMapper.selectByExample", example);
	}
	
	
	public List<ArticleInfoExtend> selectPageByExample(ArticleInfoExtendQuery example) {
		return super.getSqlSession().selectList("ArticleInfoExtendMapper.selectPageByExample", example);
	}
	
	
	public ArticleInfoExtend selectByPrimaryKey(Long id) {
		return super.getSqlSession().selectOne("ArticleInfoExtendMapper.selectByPrimaryKey", id);
	}
	
	
	public int updateByPrimaryKeySelective(ArticleInfoExtend record) {
		return super.getSqlSession().update("ArticleInfoExtendMapper.updateByPrimaryKeySelective", record);
	}
	
	
	public int updateByPrimaryKey(ArticleInfoExtend record) {
		return super.getSqlSession().update("ArticleInfoExtendMapper.updateByPrimaryKey", record);
	}
	
}
