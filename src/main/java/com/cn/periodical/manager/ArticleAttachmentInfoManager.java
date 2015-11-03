/*
 * Powered By code-generator
 * Since 2015 - 2015
 */

package com.cn.periodical.manager;

import java.util.List;

import com.cn.periodical.pojo.ArticleAttachmentInfo;
import com.cn.periodical.pojo.ArticleAttachmentInfoPage;
import com.cn.periodical.pojo.ArticleAttachmentInfoQuery;

public interface ArticleAttachmentInfoManager {
	void saveArticleAttachmentInfo(ArticleAttachmentInfo articleAttachmentInfo);

	ArticleAttachmentInfo findArticleAttachmentInfoById(Long id);
	
	List<ArticleAttachmentInfo> queryList(ArticleAttachmentInfoQuery query);
	
	void deleteArticleAttachmentInfoById(Long id);
	
	void deleteArticleAttachmentInfo(ArticleAttachmentInfoQuery query);
	
	ArticleAttachmentInfoPage queryPageList(ArticleAttachmentInfoQuery query);
}
