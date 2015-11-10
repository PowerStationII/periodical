/*
 * Powered By code-generator
 * Since 2015 - 2015
 */

package com.cn.periodical.pojo;

import com.cn.periodical.utils.PagingQuery;

/**
 * ArticleInfoExtendQuery
 * @author code-generator
 *
 */
public class ArticleInfoExtendQuery extends PagingQuery {
	private static final long serialVersionUID = 1L;
	
	public  ArticleInfoExtendQuery(){
		super(1, 10);
	}
	
	public  ArticleInfoExtendQuery(int pageNo, int pageSize){
		super(pageNo, pageSize);
	}
	
	private java.lang.String userId;
	private java.lang.String roleId;
	private java.lang.String articleId;

	/**
	 * 
	 * @param userId
	 */
	public void setUserId(java.lang.String userId) {
		this.userId = userId;
	}
	
	/**
	 * 
	 * @return
	 */
	public java.lang.String getUserId() {
		return this.userId;
	}
	/**
	 * 
	 * @param roleId
	 */
	public void setRoleId(java.lang.String roleId) {
		this.roleId = roleId;
	}
	
	/**
	 * 
	 * @return
	 */
	public java.lang.String getRoleId() {
		return this.roleId;
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
}