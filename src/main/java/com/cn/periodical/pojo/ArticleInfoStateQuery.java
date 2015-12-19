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
	private java.lang.String periodicalId;
	private java.lang.String periodicalName;
	private java.util.Date editorDjTime;
	private java.util.Date editorSsTime;
	private java.util.Date cnExpertShTime;
	private java.util.Date enExpertShTime;
	private java.lang.String enExpertUpload;

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
	/**
	 * 
	 * @param periodicalId
	 */
	public void setPeriodicalId(java.lang.String periodicalId) {
		this.periodicalId = periodicalId;
	}
	
	/**
	 * 
	 * @return
	 */
	public java.lang.String getPeriodicalId() {
		return this.periodicalId;
	}
	/**
	 * 
	 * @param periodicalName
	 */
	public void setPeriodicalName(java.lang.String periodicalName) {
		this.periodicalName = periodicalName;
	}
	
	/**
	 * 
	 * @return
	 */
	public java.lang.String getPeriodicalName() {
		return this.periodicalName;
	}
	/**
	 * 登记日期
	 * @param editorDjTime
	 */
	public void setEditorDjTime(java.util.Date editorDjTime) {
		this.editorDjTime = editorDjTime;
	}
	
	/**
	 * 登记日期
	 * @return
	 */
	public java.util.Date getEditorDjTime() {
		return this.editorDjTime;
	}
	/**
	 * 送审日期
	 * @param editorSsTime
	 */
	public void setEditorSsTime(java.util.Date editorSsTime) {
		this.editorSsTime = editorSsTime;
	}
	
	/**
	 * 送审日期
	 * @return
	 */
	public java.util.Date getEditorSsTime() {
		return this.editorSsTime;
	}
	/**
	 * 中文专家审核日期
	 * @param cnExpertShTime
	 */
	public void setCnExpertShTime(java.util.Date cnExpertShTime) {
		this.cnExpertShTime = cnExpertShTime;
	}
	
	/**
	 * 中文专家审核日期
	 * @return
	 */
	public java.util.Date getCnExpertShTime() {
		return this.cnExpertShTime;
	}
	/**
	 * 英文专家审核日期
	 * @param enExpertShTime
	 */
	public void setEnExpertShTime(java.util.Date enExpertShTime) {
		this.enExpertShTime = enExpertShTime;
	}
	
	/**
	 * 英文专家审核日期
	 * @return
	 */
	public java.util.Date getEnExpertShTime() {
		return this.enExpertShTime;
	}
	/**
	 * 英文专家是否已上传稿件
	 * @param enExpertUpload
	 */
	public void setEnExpertUpload(java.lang.String enExpertUpload) {
		this.enExpertUpload = enExpertUpload;
	}
	
	/**
	 * 英文专家是否已上传稿件
	 * @return
	 */
	public java.lang.String getEnExpertUpload() {
		return this.enExpertUpload;
	}
}