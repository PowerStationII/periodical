/*
 * Powered By code-generator
 * Since 2015 - 2015
 */

package com.cn.periodical.dao;

import java.util.List;

import com.cn.periodical.pojo.ArticleFlowsExtend;
import com.cn.periodical.pojo.ArticleFlowsExtendQuery;

public interface ArticleFlowsExtendDao {
	int countByExample(ArticleFlowsExtendQuery example);
	
	int deleteByExample(ArticleFlowsExtendQuery example);
	
	int deleteByPrimaryKey(Long id);
	
	int insert(ArticleFlowsExtend record);
	
	int insertSelective(ArticleFlowsExtend record);
	
	List<ArticleFlowsExtend> selectByExample(ArticleFlowsExtendQuery example);
	
	List<ArticleFlowsExtend> selectPageByExample(ArticleFlowsExtendQuery example);
	
	ArticleFlowsExtend selectByPrimaryKey(Long id);
	
	int updateByPrimaryKeySelective(ArticleFlowsExtend record);
	
	int updateByPrimaryKey(ArticleFlowsExtend record);
}
