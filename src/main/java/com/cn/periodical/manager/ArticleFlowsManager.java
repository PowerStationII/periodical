/*
 * Powered By code-generator
 * Since 2015 - 2015
 */

package com.cn.periodical.manager;

import java.util.List;

import com.cn.periodical.pojo.ArticleFlows;
import com.cn.periodical.pojo.ArticleFlowsPage;
import com.cn.periodical.pojo.ArticleFlowsQuery;
import com.cn.periodical.pojo.Opinion;

public interface ArticleFlowsManager {
	void saveArticleFlows(ArticleFlows articleFlows);

	ArticleFlows findArticleFlowsById(Long id);
	
	List<ArticleFlows> queryList(ArticleFlowsQuery query);
	
	void deleteArticleFlowsById(Long id);
	
	void deleteArticleFlows(ArticleFlowsQuery query);
	
	ArticleFlowsPage queryPageList(ArticleFlowsQuery query);
	
	long selectMaxId(String articleId);
	ArticleFlows queryFlowsDetail(ArticleFlowsQuery query);
	int updateFlows(ArticleFlows record);
	int updateExpertFlows(ArticleFlows record);
	
	public Opinion queryOpinion(String articleId);
}
