/*
 * Powered By code-generator
 * Since 2015 - 2015
 */

package com.cn.periodical.pojo;

import java.io.Serializable;

/**
 * ArticleFlowsExtend
 * @author code-generator
 *
 */
public class ArticleFlowsExtend implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private java.lang.Long id;
	private java.lang.String articleId;
	private java.lang.Long latelyFlowsId;

	/**
	 * @param id
	 */
	public void setId(Long id) {
		this.id = id;
	}
	
	/**
	 * @return
	 */
	public Long getId() {
		return this.id;
	}
	/**
	 * 
	 * @param articleId
	 */
	public void setArticleId(java.lang.String articleId) {
		this.articleId = articleId;
	}
	
	/**
	 * 
	 * @return
	 */
	public java.lang.String getArticleId() {
		return this.articleId;
	}
	/**
	 * 
	 * @param latelyFlowsId
	 */
	public void setLatelyFlowsId(java.lang.Long latelyFlowsId) {
		this.latelyFlowsId = latelyFlowsId;
	}
	
	/**
	 * 
	 * @return
	 */
	public java.lang.Long getLatelyFlowsId() {
		return this.latelyFlowsId;
	}
}