/*
 * Powered By code-generator
 * Since 2015 - 2015
 */

package com.cn.periodical.dao;

import java.util.List;

import com.cn.periodical.pojo.ArticleInfoState;
import com.cn.periodical.pojo.ArticleInfoStateQuery;

public interface ArticleInfoStateDao {
	int countByExample(ArticleInfoStateQuery example);
	
	int deleteByExample(ArticleInfoStateQuery example);
	
	int deleteByPrimaryKey(Long id);
	
	int insert(ArticleInfoState record);
	
	int insertSelective(ArticleInfoState record);
	
	List<ArticleInfoState> selectByExample(ArticleInfoStateQuery example);
	
	List<ArticleInfoState> selectPageByExample(ArticleInfoStateQuery example);
	
	ArticleInfoState selectByPrimaryKey(Long id);
	
	int updateByPrimaryKeySelective(ArticleInfoState record);
	
	int updateByPrimaryKey(ArticleInfoState record);
}
