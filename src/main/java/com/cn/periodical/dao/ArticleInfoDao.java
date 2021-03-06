/*
 * Powered By code-generator
 * Since 2015 - 2015
 */

package com.cn.periodical.dao;

import java.util.List;
import java.util.Map;

import com.cn.periodical.pojo.ArticleInfo;
import com.cn.periodical.pojo.ArticleInfoQuery;
import com.cn.periodical.pojo.EditorAreaInfos;

public interface ArticleInfoDao {
	int countByExample(ArticleInfoQuery example);
	
	int deleteByExample(ArticleInfoQuery example);
	
	int deleteByPrimaryKey(Long id);
	
	int insert(ArticleInfo record);
	
	int insertSelective(ArticleInfo record);
	
	List<ArticleInfo> selectByExample(ArticleInfoQuery example);
	List<ArticleInfo> selectByExampleZuGao(ArticleInfoQuery example);

	List<ArticleInfo> selectPageByExample(ArticleInfoQuery example);
	
	ArticleInfo selectByPrimaryKey(Long id);

    public ArticleInfo selectByArticleId(String articleId);

	int updateByPrimaryKeySelective(ArticleInfo record);
	
	int updateByPrimaryKey(ArticleInfo record);
	
	public List<EditorAreaInfos> queryArticleTotalInfos(Map<String,String> map);
	public List<ArticleInfo> qryListByUserId(Map reqMap);
	ArticleInfo qryInfoByArticleId(Map reqMap);
	/**
	 * 主编查看系统稿件信息
	 * */
	List<ArticleInfo> querySysArticleInfosList(ArticleInfoQuery query);
}
