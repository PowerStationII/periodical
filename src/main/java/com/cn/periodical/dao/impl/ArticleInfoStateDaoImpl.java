/*
 * Powered By code-generator
 * Since 2015 - 2015
 */

package com.cn.periodical.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.cn.periodical.dao.ArticleInfoStateDao;
import com.cn.periodical.pojo.ArticleInfoState;
import com.cn.periodical.pojo.ArticleInfoStateQuery;
import com.cn.periodical.dao.BaseDao;

@Repository("articleInfoStateDao")
public class ArticleInfoStateDaoImpl extends BaseDao implements ArticleInfoStateDao {
	
	
	public int countByExample(ArticleInfoStateQuery example) {
		return super.getSqlSession().selectOne("ArticleInfoStateMapper.countByExample", example);
	}
	
	
	public int deleteByExample(ArticleInfoStateQuery example) {
		return super.getSqlSession().delete("ArticleInfoStateMapper.deleteByExample", example);
	}
	
	
	public int deleteByPrimaryKey(Long id) {
		return super.getSqlSession().delete("ArticleInfoStateMapper.deleteByPrimaryKey", id);
	}
	
	
	public int insert(ArticleInfoState record) {
		return super.getSqlSession().insert("ArticleInfoStateMapper.insert", record);
	}
	
	
	public int insertSelective(ArticleInfoState record) {
		return super.getSqlSession().insert("ArticleInfoStateMapper.insertSelective", record);
	}
	
	
	public List<ArticleInfoState> selectByExample(ArticleInfoStateQuery example) {
		return super.getSqlSession().selectList("ArticleInfoStateMapper.selectByExample", example);
	}
	
	
	public List<ArticleInfoState> selectPageByExample(ArticleInfoStateQuery example) {
		return super.getSqlSession().selectList("ArticleInfoStateMapper.selectPageByExample", example);
	}
	
	
	public ArticleInfoState selectByPrimaryKey(Long id) {
		return super.getSqlSession().selectOne("ArticleInfoStateMapper.selectByPrimaryKey", id);
	}
	
	
	public int updateByPrimaryKeySelective(ArticleInfoState record) {
		return super.getSqlSession().update("ArticleInfoStateMapper.updateByPrimaryKeySelective", record);
	}
	
	
	public int updateByPrimaryKey(ArticleInfoState record) {
		return super.getSqlSession().update("ArticleInfoStateMapper.updateByPrimaryKey", record);
	}
	
}
