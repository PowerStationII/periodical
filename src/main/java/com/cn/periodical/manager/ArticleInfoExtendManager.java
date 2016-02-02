/*
 * Powered By code-generator
 * Since 2015 - 2015
 */

package com.cn.periodical.manager;

import java.util.List;

import com.cn.periodical.pojo.ArticleInfoExtend;
import com.cn.periodical.pojo.ArticleInfoExtendPage;
import com.cn.periodical.pojo.ArticleInfoExtendQuery;

public interface ArticleInfoExtendManager {
	void saveArticleInfoExtend(ArticleInfoExtend articleInfoExtend);

	ArticleInfoExtend findArticleInfoExtendById(Long id);

    public ArticleInfoExtend selectByArticleIdKey(ArticleInfoExtendQuery example);
	
	List<ArticleInfoExtend> queryList(ArticleInfoExtendQuery query);
	
	void deleteArticleInfoExtendById(Long id);
	
	void deleteArticleInfoExtend(ArticleInfoExtendQuery query);
	
	ArticleInfoExtendPage queryPageList(ArticleInfoExtendQuery query);
}
