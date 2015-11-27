/*
 * Powered By code-generator
 * Since 2015 - 2015
 */

package com.cn.periodical.pojo;

import java.io.Serializable;

/**
 * AccountInfo
 * @author code-generator
 *
 */
public class AccountInfo implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private java.lang.Long id;
	private java.lang.String refId;
	private java.lang.Long authorAmount;
	private java.util.Date payTime;
	private java.lang.String type;
	private java.lang.String userId;
	private java.lang.String articleId;
	private java.lang.Long authorTaxAmount;
	private java.lang.Long authorRealAmount;
	private java.lang.Long expertTaxAmount;
	private java.lang.Long expertRealAmount;
	private java.lang.Long expertAmount;
	private java.lang.String expertPayeeId;
	private java.lang.String authorPayeeId;
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
	 * 给谁的
	 * @param refId
	 */
	public void setRefId(java.lang.String refId) {
		this.refId = refId;
	}
	
	/**
	 * 给谁的
	 * @return
	 */
	public java.lang.String getRefId() {
		return this.refId;
	}
	/**
	 * 稿费
	 * @param authorAmount
	 */
	public void setAuthorAmount(java.lang.Long authorAmount) {
		this.authorAmount = authorAmount;
	}
	
	/**
	 * 稿费
	 * @return
	 */
	public java.lang.Long getAuthorAmount() {
		return this.authorAmount;
	}
	/**
	 * 付款时间
	 * @param payTime
	 */
	public void setPayTime(java.util.Date payTime) {
		this.payTime = payTime;
	}
	
	/**
	 * 付款时间
	 * @return
	 */
	public java.util.Date getPayTime() {
		return this.payTime;
	}
	/**
	 * in:理事会缴费+订购缴费;out:付稿费
	 * @param type
	 */
	public void setType(java.lang.String type) {
		this.type = type;
	}
	
	/**
	 * in:理事会缴费+订购缴费;out:付稿费
	 * @return
	 */
	public java.lang.String getType() {
		return this.type;
	}
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
	 * 扣税
	 * @param authorTaxAmount
	 */
	public void setAuthorTaxAmount(java.lang.Long authorTaxAmount) {
		this.authorTaxAmount = authorTaxAmount;
	}
	
	/**
	 * 扣税
	 * @return
	 */
	public java.lang.Long getAuthorTaxAmount() {
		return this.authorTaxAmount;
	}
	/**
	 * 实发
	 * @param authorRealAmount
	 */
	public void setAuthorRealAmount(java.lang.Long authorRealAmount) {
		this.authorRealAmount = authorRealAmount;
	}
	
	/**
	 * 实发
	 * @return
	 */
	public java.lang.Long getAuthorRealAmount() {
		return this.authorRealAmount;
	}
	/**
	 * 
	 * @param expertTaxAmount
	 */
	public void setExpertTaxAmount(java.lang.Long expertTaxAmount) {
		this.expertTaxAmount = expertTaxAmount;
	}
	
	/**
	 * 
	 * @return
	 */
	public java.lang.Long getExpertTaxAmount() {
		return this.expertTaxAmount;
	}
	/**
	 * 专家实发
	 * @param expertRealAmount
	 */
	public void setExpertRealAmount(java.lang.Long expertRealAmount) {
		this.expertRealAmount = expertRealAmount;
	}
	
	/**
	 * 专家实发
	 * @return
	 */
	public java.lang.Long getExpertRealAmount() {
		return this.expertRealAmount;
	}
	/**
	 * 
	 * @param expertAmount
	 */
	public void setExpertAmount(java.lang.Long expertAmount) {
		this.expertAmount = expertAmount;
	}
	
	/**
	 * 
	 * @return
	 */
	public java.lang.Long getExpertAmount() {
		return this.expertAmount;
	}
	/**
	 * 专家收款账号id
	 * @param expertPayeeId
	 */
	public void setExpertPayeeId(java.lang.String expertPayeeId) {
		this.expertPayeeId = expertPayeeId;
	}
	
	/**
	 * 专家收款账号id
	 * @return
	 */
	public java.lang.String getExpertPayeeId() {
		return this.expertPayeeId;
	}
	/**
	 * 作者收款信息id
	 * @param authorPayeeId
	 */
	public void setAuthorPayeeId(java.lang.String authorPayeeId) {
		this.authorPayeeId = authorPayeeId;
	}
	
	/**
	 * 作者收款信息id
	 * @return
	 */
	public java.lang.String getAuthorPayeeId() {
		return this.authorPayeeId;
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