/*
 * Powered By code-generator
 * Since 2015 - 2015
 */

package com.cn.periodical.pojo;

import java.io.Serializable;

/**
 * 暂时不支持多个作者查询
 * */
public class EditorArticleInfo implements Serializable{
	
	private java.lang.String articleId;
	private java.lang.String articleCnTitle;
	private ArticleInfoExtend articleInfoExtend;
	
	public java.lang.String getArticleId() {
		return articleId;
	}
	public void setArticleId(java.lang.String articleId) {
		this.articleId = articleId;
	}
	public java.lang.String getArticleCnTitle() {
		return articleCnTitle;
	}
	public void setArticleCnTitle(java.lang.String articleCnTitle) {
		this.articleCnTitle = articleCnTitle;
	}
	public ArticleInfoExtend getArticleInfoExtend() {
		return articleInfoExtend;
	}
	public void setArticleInfoExtend(ArticleInfoExtend articleInfoExtend) {
		this.articleInfoExtend = articleInfoExtend;
	}
}