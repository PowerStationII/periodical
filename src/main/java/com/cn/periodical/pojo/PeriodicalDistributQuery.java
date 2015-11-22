/*
 * Powered By code-generator
 * Since 2015 - 2015
 */

package com.cn.periodical.pojo;

import com.cn.periodical.utils.PagingQuery;

/**
 * PeriodicalDistributQuery
 * @author code-generator
 *
 */
public class PeriodicalDistributQuery extends PagingQuery {
	private static final long serialVersionUID = 1L;
	
	public  PeriodicalDistributQuery(){
		super(1, 10);
	}
	
	public  PeriodicalDistributQuery(int pageNo, int pageSize){
		super(pageNo, pageSize);
	}
	
	private java.lang.String refId;
	private java.lang.String roleId;
	private java.lang.String addressId;
	private java.lang.String periodicalId;
	private java.lang.Integer distributeNums;
	private java.lang.String extend1;
	private java.lang.String extend2;
	private java.lang.String extend3;
	private java.util.Date createTime;
	private java.util.Date updateTime;
	private java.lang.String supplementId1;
	private java.lang.String supplementId2;
	private java.lang.String supplementId3;
	private java.lang.String supplementId4;
	private java.lang.String supplementId5;
	private java.lang.String supplementId7;
	private java.lang.Integer supplementId1Nums;
	private java.lang.Integer supplementId2Nums;
	private java.lang.Integer supplementId3Nums;
	private java.lang.Integer supplementId4Nums;
	private java.lang.Integer supplementId5Nums;
	private java.lang.Integer supplementId6Nums;
	private java.lang.Integer supplementId7Nums;

	/**
	 * 读者id
	 * @param refId
	 */
	public void setRefId(java.lang.String refId) {
		this.refId = refId;
	}
	
	/**
	 * 读者id
	 * @return
	 */
	public java.lang.String getRefId() {
		return this.refId;
	}
	/**
	 * 角色id
	 * @param roleId
	 */
	public void setRoleId(java.lang.String roleId) {
		this.roleId = roleId;
	}
	
	/**
	 * 角色id
	 * @return
	 */
	public java.lang.String getRoleId() {
		return this.roleId;
	}
	/**
	 * 地址id
	 * @param addressId
	 */
	public void setAddressId(java.lang.String addressId) {
		this.addressId = addressId;
	}
	
	/**
	 * 地址id
	 * @return
	 */
	public java.lang.String getAddressId() {
		return this.addressId;
	}
	/**
	 * 期刊id
	 * @param periodicalId
	 */
	public void setPeriodicalId(java.lang.String periodicalId) {
		this.periodicalId = periodicalId;
	}
	
	/**
	 * 期刊id
	 * @return
	 */
	public java.lang.String getPeriodicalId() {
		return this.periodicalId;
	}
	/**
	 * 邮寄本数
	 * @param distributeNums
	 */
	public void setDistributeNums(java.lang.Integer distributeNums) {
		this.distributeNums = distributeNums;
	}
	
	/**
	 * 邮寄本数
	 * @return
	 */
	public java.lang.Integer getDistributeNums() {
		return this.distributeNums;
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
}