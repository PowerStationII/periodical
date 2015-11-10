/*
 * Powered By code-generator
 * Since 2015 - 2015
 */

package com.cn.periodical.manager;

import java.util.List;

import com.cn.periodical.pojo.ArticleFlowsExtend;
import com.cn.periodical.pojo.ArticleFlowsExtendPage;
import com.cn.periodical.pojo.ArticleFlowsExtendQuery;

public interface ArticleFlowsExtendManager {
	void saveArticleFlowsExtend(ArticleFlowsExtend articleFlowsExtend);

	ArticleFlowsExtend findArticleFlowsExtendById(Long id);
	
	List<ArticleFlowsExtend> queryList(ArticleFlowsExtendQuery query);
	
	void deleteArticleFlowsExtendById(Long id);
	
	void deleteArticleFlowsExtend(ArticleFlowsExtendQuery query);
	
	ArticleFlowsExtendPage queryPageList(ArticleFlowsExtendQuery query);
}
