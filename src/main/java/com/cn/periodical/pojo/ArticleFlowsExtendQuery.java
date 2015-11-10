/*
 * Powered By code-generator
 * Since 2015 - 2015
 */

package com.cn.periodical.pojo;

import com.cn.periodical.utils.PagingQuery;

/**
 * ArticleFlowsExtendQuery
 * @author code-generator
 *
 */
public class ArticleFlowsExtendQuery extends PagingQuery {
	private static final long serialVersionUID = 1L;
	
	public  ArticleFlowsExtendQuery(){
		super(1, 10);
	}
	
	public  ArticleFlowsExtendQuery(int pageNo, int pageSize){
		super(pageNo, pageSize);
	}
	
	private java.lang.String articleId;
	private java.lang.Long latelyFlowsId;

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