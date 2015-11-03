/*
 * Powered By code-generator
 * Since 2015 - 2015
 */

package com.cn.periodical.dao;

import java.util.List;

import com.cn.periodical.pojo.ArticleInfo;
import com.cn.periodical.pojo.ArticleInfoQuery;

public interface ArticleInfoDao {
	int countByExample(ArticleInfoQuery example);
	
	int deleteByExample(ArticleInfoQuery example);
	
	int deleteByPrimaryKey(Long id);
	
	int insert(ArticleInfo record);
	
	int insertSelective(ArticleInfo record);
	
	List<ArticleInfo> selectByExample(ArticleInfoQuery example);
	
	List<ArticleInfo> selectPageByExample(ArticleInfoQuery example);
	
	ArticleInfo selectByPrimaryKey(Long id);
	
	int updateByPrimaryKeySelective(ArticleInfo record);
	
	int updateByPrimaryKey(ArticleInfo record);
}
