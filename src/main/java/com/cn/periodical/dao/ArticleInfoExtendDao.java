/*
 * Powered By code-generator
 * Since 2015 - 2015
 */

package com.cn.periodical.dao;

import java.util.List;

import com.cn.periodical.pojo.ArticleInfoExtend;
import com.cn.periodical.pojo.ArticleInfoExtendQuery;

public interface ArticleInfoExtendDao {
	int countByExample(ArticleInfoExtendQuery example);
	
	int deleteByExample(ArticleInfoExtendQuery example);
	
	int deleteByPrimaryKey(Long id);
	
	int insert(ArticleInfoExtend record);
	
	int insertSelective(ArticleInfoExtend record);
	
	List<ArticleInfoExtend> selectByExample(ArticleInfoExtendQuery example);
	
	List<ArticleInfoExtend> selectPageByExample(ArticleInfoExtendQuery example);
	
	ArticleInfoExtend selectByPrimaryKey(Long id);
	
	int updateByPrimaryKeySelective(ArticleInfoExtend record);
	
	int updateByPrimaryKey(ArticleInfoExtend record);
}
