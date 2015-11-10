/*
 * Powered By code-generator
 * Since 2015 - 2015
 */

package com.cn.periodical.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.cn.periodical.dao.ArticleFlowsExtendDao;
import com.cn.periodical.pojo.ArticleFlowsExtend;
import com.cn.periodical.pojo.ArticleFlowsExtendQuery;
import com.cn.periodical.dao.BaseDao;

@Repository("articleFlowsExtendDao")
public class ArticleFlowsExtendDaoImpl extends BaseDao implements ArticleFlowsExtendDao {
	
	
	public int countByExample(ArticleFlowsExtendQuery example) {
		return super.getSqlSession().selectOne("ArticleFlowsExtendMapper.countByExample", example);
	}
	
	
	public int deleteByExample(ArticleFlowsExtendQuery example) {
		return super.getSqlSession().delete("ArticleFlowsExtendMapper.deleteByExample", example);
	}
	
	
	public int deleteByPrimaryKey(Long id) {
		return super.getSqlSession().delete("ArticleFlowsExtendMapper.deleteByPrimaryKey", id);
	}
	
	
	public int insert(ArticleFlowsExtend record) {
		return super.getSqlSession().insert("ArticleFlowsExtendMapper.insert", record);
	}
	
	
	public int insertSelective(ArticleFlowsExtend record) {
		return super.getSqlSession().insert("ArticleFlowsExtendMapper.insertSelective", record);
	}
	
	
	public List<ArticleFlowsExtend> selectByExample(ArticleFlowsExtendQuery example) {
		return super.getSqlSession().selectList("ArticleFlowsExtendMapper.selectByExample", example);
	}
	
	
	public List<ArticleFlowsExtend> selectPageByExample(ArticleFlowsExtendQuery example) {
		return super.getSqlSession().selectList("ArticleFlowsExtendMapper.selectPageByExample", example);
	}
	
	
	public ArticleFlowsExtend selectByPrimaryKey(Long id) {
		return super.getSqlSession().selectOne("ArticleFlowsExtendMapper.selectByPrimaryKey", id);
	}
	
	
	public int updateByPrimaryKeySelective(ArticleFlowsExtend record) {
		return super.getSqlSession().update("ArticleFlowsExtendMapper.updateByPrimaryKeySelective", record);
	}
	
	
	public int updateByPrimaryKey(ArticleFlowsExtend record) {
		return super.getSqlSession().update("ArticleFlowsExtendMapper.updateByPrimaryKey", record);
	}
	
}
