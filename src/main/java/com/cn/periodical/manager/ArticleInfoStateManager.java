/*
 * Powered By code-generator
 * Since 2015 - 2015
 */

package com.cn.periodical.manager;

import java.util.List;

import com.cn.periodical.pojo.ArticleInfoState;
import com.cn.periodical.pojo.ArticleInfoStatePage;
import com.cn.periodical.pojo.ArticleInfoStateQuery;

public interface ArticleInfoStateManager {
	void saveArticleInfoState(ArticleInfoState articleInfoState);

	ArticleInfoState findArticleInfoStateById(Long id);
	
	List<ArticleInfoState> queryList(ArticleInfoStateQuery query);
	
	void deleteArticleInfoStateById(Long id);
	
	void deleteArticleInfoState(ArticleInfoStateQuery query);
	
	ArticleInfoStatePage queryPageList(ArticleInfoStateQuery query);
}
