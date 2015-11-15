/*
 * Powered By code-generator
 * Since 2015 - 2015
 */

package com.cn.periodical.pojo;

import com.cn.periodical.utils.PagingQuery;

/**
 * AccountInfoQuery
 * @author code-generator
 *
 */
public class AccountInfoQuery extends PagingQuery {
	private static final long serialVersionUID = 1L;
	
	public  AccountInfoQuery(){
		super(1, 10);
	}
	
	public  AccountInfoQuery(int pageNo, int pageSize){
		super(pageNo, pageSize);
	}
	
	private java.lang.String refId;
	private java.lang.Long amount;
	private java.util.Date payTime;
	private java.lang.String type;
	private java.lang.String userId;
	private java.lang.String articleId;
	private java.lang.Long amountTax;
	private java.lang.Long realAmount;
	private java.lang.String payeeId;
	private java.lang.String extend1;
	private java.lang.String extend2;
	private java.util.Date createTime;
	private java.util.Date updateTime;

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
	 * @param amount
	 */
	public void setAmount(java.lang.Long amount) {
		this.amount = amount;
	}
	
	/**
	 * 稿费
	 * @return
	 */
	public java.lang.Long getAmount() {
		return this.amount;
	}
	/**
	 * 
	 * @param payTime
	 */
	public void setPayTime(java.util.Date payTime) {
		this.payTime = payTime;
	}
	
	/**
	 * 
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
	 * @param amountTax
	 */
	public void setAmountTax(java.lang.Long amountTax) {
		this.amountTax = amountTax;
	}
	
	/**
	 * 扣税
	 * @return
	 */
	public java.lang.Long getAmountTax() {
		return this.amountTax;
	}
	/**
	 * 实发
	 * @param realAmount
	 */
	public void setRealAmount(java.lang.Long realAmount) {
		this.realAmount = realAmount;
	}
	
	/**
	 * 实发
	 * @return
	 */
	public java.lang.Long getRealAmount() {
		return this.realAmount;
	}
	/**
	 * 收款人信息
	 * @param payeeId
	 */
	public void setPayeeId(java.lang.String payeeId) {
		this.payeeId = payeeId;
	}
	
	/**
	 * 收款人信息
	 * @return
	 */
	public java.lang.String getPayeeId() {
		return this.payeeId;
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