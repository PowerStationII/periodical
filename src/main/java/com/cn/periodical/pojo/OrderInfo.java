/*
 * Powered By code-generator
 * Since 2015 - 2015
 */

package com.cn.periodical.pojo;

import java.io.Serializable;

/**
 * OrderInfo
 * @author code-generator
 *
 */
public class OrderInfo implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private java.lang.Long id;
	private java.lang.String userId;
	private java.lang.String orderNo;
	private java.lang.String periodicalId;
	private java.lang.String periodicalYear;
	private java.lang.Long amount;
	private java.lang.String payId;
	private java.lang.Integer subscribeNums;
	private java.lang.String supplementId1;
	private java.lang.String supplementId2;
	private java.lang.String supplementId3;
	private java.lang.String supplementId4;
	private java.lang.String supplementId5;
	private java.lang.String supplementId6;
	private java.lang.String supplementId7;
	private java.lang.Integer supplementId1Nums;
	private java.lang.Integer supplementId2Nums;
	private java.lang.Integer supplementId3Nums;
	private java.lang.Integer supplementId4Nums;
	private java.lang.Integer supplementId5Nums;
	private java.lang.Integer supplementId6Nums;
	private java.lang.Integer supplementId7Nums;
	private java.lang.String orderStatus;
	private java.util.Date auditTime;
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
	 * @param orderNo
	 */
	public void setOrderNo(java.lang.String orderNo) {
		this.orderNo = orderNo;
	}
	
	/**
	 * 
	 * @return
	 */
	public java.lang.String getOrderNo() {
		return this.orderNo;
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
	 * @param periodicalYear
	 */
	public void setPeriodicalYear(java.lang.String periodicalYear) {
		this.periodicalYear = periodicalYear;
	}
	
	/**
	 * 
	 * @return
	 */
	public java.lang.String getPeriodicalYear() {
		return this.periodicalYear;
	}
	/**
	 * 
	 * @param amount
	 */
	public void setAmount(java.lang.Long amount) {
		this.amount = amount;
	}
	
	/**
	 * 
	 * @return
	 */
	public java.lang.Long getAmount() {
		return this.amount;
	}
	/**
	 * 支付记录
	 * @param payId
	 */
	public void setPayId(java.lang.String payId) {
		this.payId = payId;
	}
	
	/**
	 * 支付记录
	 * @return
	 */
	public java.lang.String getPayId() {
		return this.payId;
	}
	/**
	 * 订阅数量
	 * @param subscribeNums
	 */
	public void setSubscribeNums(java.lang.Integer subscribeNums) {
		this.subscribeNums = subscribeNums;
	}
	
	/**
	 * 订阅数量
	 * @return
	 */
	public java.lang.Integer getSubscribeNums() {
		return this.subscribeNums;
	}
	/**
	 * 
	 * @param supplementId1
	 */
	public void setSupplementId1(java.lang.String supplementId1) {
		this.supplementId1 = supplementId1;
	}
	
	/**
	 * 
	 * @return
	 */
	public java.lang.String getSupplementId1() {
		return this.supplementId1;
	}
	/**
	 * 
	 * @param supplementId2
	 */
	public void setSupplementId2(java.lang.String supplementId2) {
		this.supplementId2 = supplementId2;
	}
	
	/**
	 * 
	 * @return
	 */
	public java.lang.String getSupplementId2() {
		return this.supplementId2;
	}
	/**
	 * 
	 * @param supplementId3
	 */
	public void setSupplementId3(java.lang.String supplementId3) {
		this.supplementId3 = supplementId3;
	}
	
	/**
	 * 
	 * @return
	 */
	public java.lang.String getSupplementId3() {
		return this.supplementId3;
	}
	/**
	 * 
	 * @param supplementId4
	 */
	public void setSupplementId4(java.lang.String supplementId4) {
		this.supplementId4 = supplementId4;
	}
	
	/**
	 * 
	 * @return
	 */
	public java.lang.String getSupplementId4() {
		return this.supplementId4;
	}
	/**
	 * 
	 * @param supplementId5
	 */
	public void setSupplementId5(java.lang.String supplementId5) {
		this.supplementId5 = supplementId5;
	}
	
	/**
	 * 
	 * @return
	 */
	public java.lang.String getSupplementId5() {
		return this.supplementId5;
	}
	/**
	 * 
	 * @param supplementId6
	 */
	public void setSupplementId6(java.lang.String supplementId6) {
		this.supplementId6 = supplementId6;
	}
	
	/**
	 * 
	 * @return
	 */
	public java.lang.String getSupplementId6() {
		return this.supplementId6;
	}
	/**
	 * 
	 * @param supplementId7
	 */
	public void setSupplementId7(java.lang.String supplementId7) {
		this.supplementId7 = supplementId7;
	}
	
	/**
	 * 
	 * @return
	 */
	public java.lang.String getSupplementId7() {
		return this.supplementId7;
	}
	/**
	 * 
	 * @param supplementId1Nums
	 */
	public void setSupplementId1Nums(java.lang.Integer supplementId1Nums) {
		this.supplementId1Nums = supplementId1Nums;
	}
	
	/**
	 * 
	 * @return
	 */
	public java.lang.Integer getSupplementId1Nums() {
		return this.supplementId1Nums;
	}
	/**
	 * 
	 * @param supplementId2Nums
	 */
	public void setSupplementId2Nums(java.lang.Integer supplementId2Nums) {
		this.supplementId2Nums = supplementId2Nums;
	}
	
	/**
	 * 
	 * @return
	 */
	public java.lang.Integer getSupplementId2Nums() {
		return this.supplementId2Nums;
	}
	/**
	 * 
	 * @param supplementId3Nums
	 */
	public void setSupplementId3Nums(java.lang.Integer supplementId3Nums) {
		this.supplementId3Nums = supplementId3Nums;
	}
	
	/**
	 * 
	 * @return
	 */
	public java.lang.Integer getSupplementId3Nums() {
		return this.supplementId3Nums;
	}
	/**
	 * 
	 * @param supplementId4Nums
	 */
	public void setSupplementId4Nums(java.lang.Integer supplementId4Nums) {
		this.supplementId4Nums = supplementId4Nums;
	}
	
	/**
	 * 
	 * @return
	 */
	public java.lang.Integer getSupplementId4Nums() {
		return this.supplementId4Nums;
	}
	/**
	 * 
	 * @param supplementId5Nums
	 */
	public void setSupplementId5Nums(java.lang.Integer supplementId5Nums) {
		this.supplementId5Nums = supplementId5Nums;
	}
	
	/**
	 * 
	 * @return
	 */
	public java.lang.Integer getSupplementId5Nums() {
		return this.supplementId5Nums;
	}
	/**
	 * 
	 * @param supplementId6Nums
	 */
	public void setSupplementId6Nums(java.lang.Integer supplementId6Nums) {
		this.supplementId6Nums = supplementId6Nums;
	}
	
	/**
	 * 
	 * @return
	 */
	public java.lang.Integer getSupplementId6Nums() {
		return this.supplementId6Nums;
	}
	/**
	 * 
	 * @param supplementId7Nums
	 */
	public void setSupplementId7Nums(java.lang.Integer supplementId7Nums) {
		this.supplementId7Nums = supplementId7Nums;
	}
	
	/**
	 * 
	 * @return
	 */
	public java.lang.Integer getSupplementId7Nums() {
		return this.supplementId7Nums;
	}
	/**
	 * 订单状态
	 * @param orderStatus
	 */
	public void setOrderStatus(java.lang.String orderStatus) {
		this.orderStatus = orderStatus;
	}
	
	/**
	 * 订单状态
	 * @return
	 */
	public java.lang.String getOrderStatus() {
		return this.orderStatus;
	}
	/**
	 * 
	 * @param auditTime
	 */
	public void setAuditTime(java.util.Date auditTime) {
		this.auditTime = auditTime;
	}
	
	/**
	 * 
	 * @return
	 */
	public java.util.Date getAuditTime() {
		return this.auditTime;
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