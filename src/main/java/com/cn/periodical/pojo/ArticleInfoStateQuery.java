/*
 * Powered By code-generator
 * Since 2015 - 2015
 */

package com.cn.periodical.pojo;

import com.cn.periodical.utils.PagingQuery;

/**
 * ArticleInfoStateQuery
 * @author code-generator
 *
 */
public class ArticleInfoStateQuery extends PagingQuery {
	private static final long serialVersionUID = 1L;
	
	public  ArticleInfoStateQuery(){
		super(1, 10);
	}
	
	public  ArticleInfoStateQuery(int pageNo, int pageSize){
		super(pageNo, pageSize);
	}
	
	private java.lang.String articleId;
	private java.lang.String editorDownload;
	private java.lang.String expertDownload;
	private java.util.Date editorDownloadTime;
	private java.util.Date expertDownloadTime;

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
	 * @param editorDownload
	 */
	public void setEditorDownload(java.lang.String editorDownload) {
		this.editorDownload = editorDownload;
	}
	
	/**
	 * 
	 * @return
	 */
	public java.lang.String getEditorDownload() {
		return this.editorDownload;
	}
	/**
	 * 
	 * @param expertDownload
	 */
	public void setExpertDownload(java.lang.String expertDownload) {
		this.expertDownload = expertDownload;
	}
	
	/**
	 * 
	 * @return
	 */
	public java.lang.String getExpertDownload() {
		return this.expertDownload;
	}
	/**
	 * 
	 * @param editorDownloadTime
	 */
	public void setEditorDownloadTime(java.util.Date editorDownloadTime) {
		this.editorDownloadTime = editorDownloadTime;
	}
	
	/**
	 * 
	 * @return
	 */
	public java.util.Date getEditorDownloadTime() {
		return this.editorDownloadTime;
	}
	/**
	 * 
	 * @param expertDownloadTime
	 */
	public void setExpertDownloadTime(java.util.Date expertDownloadTime) {
		this.expertDownloadTime = expertDownloadTime;
	}
	
	/**
	 * 
	 * @return
	 */
	public java.util.Date getExpertDownloadTime() {
		return this.expertDownloadTime;
	}
}