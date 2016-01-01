/*
 * Powered By code-generator
 * Since 2015 - 2015
 */

package com.cn.periodical.pojo;

import java.io.Serializable;

/**
 * ArticleAttachmentInfo
 * @author code-generator
 *文章附件，存放的是作者上传的文章和附件
 */
public class ArticleAttachmentInfo implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private java.lang.Long id;
	private java.lang.String articleId;
	private java.lang.String attachmentName;
	private java.lang.String attachmentPath;
	private java.lang.String cxcnsAttachmentName;
	private java.lang.String cxcnsAttachmentPath;
	private java.lang.String sjtztsjAttachmentName;
	private java.lang.String sjtztsjAttachmentPath;
	private java.lang.String yjspzpAttachmentName;
	private java.lang.String yjspzpAttachmentPath;
	private java.lang.String bdjcbgAttachmentName;
	private java.lang.String bdjcbgAttachmentPath;
	private java.lang.String status;
	private java.lang.String type;
	private java.lang.Integer editTimes;
	private java.lang.String extend1;
	private java.lang.String extend2;
	private java.lang.String extend3;
	private java.lang.String extend4;
	private java.util.Date createTime;
	private java.util.Date updateTime;

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
	 * @param attachmentName
	 */
	public void setAttachmentName(java.lang.String attachmentName) {
		this.attachmentName = attachmentName;
	}
	
	/**
	 * 
	 * @return
	 */
	public java.lang.String getAttachmentName() {
		return this.attachmentName;
	}
	/**
	 * 
	 * @param attachmentPath
	 */
	public void setAttachmentPath(java.lang.String attachmentPath) {
		this.attachmentPath = attachmentPath;
	}
	
	/**
	 * 
	 * @return
	 */
	public java.lang.String getAttachmentPath() {
		return this.attachmentPath;
	}
	/**
	 * 
	 * @param cxcnsAttachmentName
	 */
	public void setCxcnsAttachmentName(java.lang.String cxcnsAttachmentName) {
		this.cxcnsAttachmentName = cxcnsAttachmentName;
	}
	
	/**
	 * 
	 * @return
	 */
	public java.lang.String getCxcnsAttachmentName() {
		return this.cxcnsAttachmentName;
	}
	/**
	 * 
	 * @param cxcnsAttachmentPath
	 */
	public void setCxcnsAttachmentPath(java.lang.String cxcnsAttachmentPath) {
		this.cxcnsAttachmentPath = cxcnsAttachmentPath;
	}
	
	/**
	 * 
	 * @return
	 */
	public java.lang.String getCxcnsAttachmentPath() {
		return this.cxcnsAttachmentPath;
	}
	/**
	 * 
	 * @param sjtztsjAttachmentName
	 */
	public void setSjtztsjAttachmentName(java.lang.String sjtztsjAttachmentName) {
		this.sjtztsjAttachmentName = sjtztsjAttachmentName;
	}
	
	/**
	 * 
	 * @return
	 */
	public java.lang.String getSjtztsjAttachmentName() {
		return this.sjtztsjAttachmentName;
	}
	/**
	 * 
	 * @param sjtztsjAttachmentPath
	 */
	public void setSjtztsjAttachmentPath(java.lang.String sjtztsjAttachmentPath) {
		this.sjtztsjAttachmentPath = sjtztsjAttachmentPath;
	}
	
	/**
	 * 
	 * @return
	 */
	public java.lang.String getSjtztsjAttachmentPath() {
		return this.sjtztsjAttachmentPath;
	}
	/**
	 * 
	 * @param yjspzpAttachmentName
	 */
	public void setYjspzpAttachmentName(java.lang.String yjspzpAttachmentName) {
		this.yjspzpAttachmentName = yjspzpAttachmentName;
	}
	
	/**
	 * 
	 * @return
	 */
	public java.lang.String getYjspzpAttachmentName() {
		return this.yjspzpAttachmentName;
	}
	/**
	 * 
	 * @param yjspzpAttachmentPath
	 */
	public void setYjspzpAttachmentPath(java.lang.String yjspzpAttachmentPath) {
		this.yjspzpAttachmentPath = yjspzpAttachmentPath;
	}
	
	/**
	 * 
	 * @return
	 */
	public java.lang.String getYjspzpAttachmentPath() {
		return this.yjspzpAttachmentPath;
	}
	/**
	 * 
	 * @param bdjcbgAttachmentName
	 */
	public void setBdjcbgAttachmentName(java.lang.String bdjcbgAttachmentName) {
		this.bdjcbgAttachmentName = bdjcbgAttachmentName;
	}
	
	/**
	 * 
	 * @return
	 */
	public java.lang.String getBdjcbgAttachmentName() {
		return this.bdjcbgAttachmentName;
	}
	/**
	 * 
	 * @param bdjcbgAttachmentPath
	 */
	public void setBdjcbgAttachmentPath(java.lang.String bdjcbgAttachmentPath) {
		this.bdjcbgAttachmentPath = bdjcbgAttachmentPath;
	}
	
	/**
	 * 
	 * @return
	 */
	public java.lang.String getBdjcbgAttachmentPath() {
		return this.bdjcbgAttachmentPath;
	}
	/**
	 * 
	 * @param status
	 */
	public void setStatus(java.lang.String status) {
		this.status = status;
	}
	
	/**
	 * 
	 * @return
	 */
	public java.lang.String getStatus() {
		return this.status;
	}
	/**
	 * 稿件类型:原稿 被编辑稿等
	 * @param type
	 */
	public void setType(java.lang.String type) {
		this.type = type;
	}
	
	/**
	 * 稿件类型:原稿 被编辑稿等
	 * @return
	 */
	public java.lang.String getType() {
		return this.type;
	}
	/**
	 * 编辑次数
	 * @param editTimes
	 */
	public void setEditTimes(java.lang.Integer editTimes) {
		this.editTimes = editTimes;
	}
	
	/**
	 * 编辑次数
	 * @return
	 */
	public java.lang.Integer getEditTimes() {
		return this.editTimes;
	}
	/**
	 * 
	 * @param extend1
	 */
	public void setExtend1(java.lang.String extend1) {
		this.extend1 = extend1;
	}
	
	/**
	 * 
	 * @return
	 */
	public java.lang.String getExtend1() {
		return this.extend1;
	}
	/**
	 * 
	 * @param extend2
	 */
	public void setExtend2(java.lang.String extend2) {
		this.extend2 = extend2;
	}
	
	/**
	 * 
	 * @return
	 */
	public java.lang.String getExtend2() {
		return this.extend2;
	}
	/**
	 * 
	 * @param extend3
	 */
	public void setExtend3(java.lang.String extend3) {
		this.extend3 = extend3;
	}
	
	/**
	 * 
	 * @return
	 */
	public java.lang.String getExtend3() {
		return this.extend3;
	}
	/**
	 * 
	 * @param extend4
	 */
	public void setExtend4(java.lang.String extend4) {
		this.extend4 = extend4;
	}
	
	/**
	 * 
	 * @return
	 */
	public java.lang.String getExtend4() {
		return this.extend4;
	}
	/**
	 * 
	 * @param createTime
	 */
	public void setCreateTime(java.util.Date createTime) {
		this.createTime = createTime;
	}
	
	/**
	 * 
	 * @return
	 */
	public java.util.Date getCreateTime() {
		return this.createTime;
	}
	/**
	 * 
	 * @param updateTime
	 */
	public void setUpdateTime(java.util.Date updateTime) {
		this.updateTime = updateTime;
	}
	
	/**
	 * 
	 * @return
	 */
	public java.util.Date getUpdateTime() {
		return this.updateTime;
	}
}