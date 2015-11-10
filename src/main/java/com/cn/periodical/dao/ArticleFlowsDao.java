/*
 * Powered By code-generator
 * Since 2015 - 2015
 */

package com.cn.periodical.dao;

import java.util.List;

import com.cn.periodical.pojo.ArticleFlows;
import com.cn.periodical.pojo.ArticleFlowsQuery;

public interface ArticleFlowsDao {
	int countByExample(ArticleFlowsQuery example);
	
	int deleteByExample(ArticleFlowsQuery example);
	
	int deleteByPrimaryKey(Long id);
	
	int insert(ArticleFlows record);
	
	int insertSelective(ArticleFlows record);
	
	List<ArticleFlows> selectByExample(ArticleFlowsQuery example);
	
	List<ArticleFlows> selectPageByExample(ArticleFlowsQuery example);
	
	ArticleFlows selectByPrimaryKey(Long id);
	
	int updateByPrimaryKeySelective(ArticleFlows record);
	
	int updateByPrimaryKey(ArticleFlows record);
	
	long selectMaxId(String articleId);
}
