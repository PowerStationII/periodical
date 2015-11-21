/*
 * Powered By code-generator
 * Since 2015 - 2015
 */

package com.cn.periodical.pojo;

import java.io.Serializable;

/**
 * PayerInfo
 * @author code-generator
 *
 */
public class PayerInfo implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private java.lang.Long id;
	private java.lang.String orderNo;
	private java.lang.String userId;
	private java.lang.String payerId;
	private java.lang.String payeeId;
	private java.lang.String draftName;
	private java.lang.String draftUrl;
	private java.lang.String payNo;
	private java.lang.String payerName;
	private java.lang.Long payAmount;
	private java.lang.Long payFee;
	private java.lang.String payerAddress;
	private java.lang.String payerPhone;
	private java.lang.String payerAccount;
	private java.lang.String payerRemark;
	private java.lang.String operaterNum;
	private java.lang.String remitOrgan;
	private java.lang.String remitCity;
	private java.lang.String remitPro;
	private java.lang.String invoiceTile;
	private java.util.Date receiveRemitDay;
	private java.util.Date payTime;
	private java.lang.String payType;
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
	 * 订单号
	 * @param orderNo
	 */
	public void setOrderNo(java.lang.String orderNo) {
		this.orderNo = orderNo;
	}
	
	/**
	 * 订单号
	 * @return
	 */
	public java.lang.String getOrderNo() {
		return this.orderNo;
	}
	/**
	 * 用户id
	 * @param userId
	 */
	public void setUserId(java.lang.String userId) {
		this.userId = userId;
	}
	
	/**
	 * 用户id
	 * @return
	 */
	public java.lang.String getUserId() {
		return this.userId;
	}
	/**
	 * 付款人id
	 * @param payerId
	 */
	public void setPayerId(java.lang.String payerId) {
		this.payerId = payerId;
	}
	
	/**
	 * 付款人id
	 * @return
	 */
	public java.lang.String getPayerId() {
		return this.payerId;
	}
	/**
	 * 收款人id
	 * @param payeeId
	 */
	public void setPayeeId(java.lang.String payeeId) {
		this.payeeId = payeeId;
	}
	
	/**
	 * 收款人id
	 * @return
	 */
	public java.lang.String getPayeeId() {
		return this.payeeId;
	}
	/**
	 * 汇款截图id
	 * @param draftName
	 */
	public void setDraftName(java.lang.String draftName) {
		this.draftName = draftName;
	}
	
	/**
	 * 汇款截图id
	 * @return
	 */
	public java.lang.String getDraftName() {
		return this.draftName;
	}
	/**
	 * 汇款截图保存路径
	 * @param draftUrl
	 */
	public void setDraftUrl(java.lang.String draftUrl) {
		this.draftUrl = draftUrl;
	}
	
	/**
	 * 汇款截图保存路径
	 * @return
	 */
	public java.lang.String getDraftUrl() {
		return this.draftUrl;
	}
	/**
	 * 汇票账号
	 * @param payNo
	 */
	public void setPayNo(java.lang.String payNo) {
		this.payNo = payNo;
	}
	
	/**
	 * 汇票账号
	 * @return
	 */
	public java.lang.String getPayNo() {
		return this.payNo;
	}
	/**
	 * 汇款人姓名
	 * @param payerName
	 */
	public void setPayerName(java.lang.String payerName) {
		this.payerName = payerName;
	}
	
	/**
	 * 汇款人姓名
	 * @return
	 */
	public java.lang.String getPayerName() {
		return this.payerName;
	}
	/**
	 * 汇费
	 * @param payAmount
	 */
	public void setPayAmount(java.lang.Long payAmount) {
		this.payAmount = payAmount;
	}
	
	/**
	 * 汇费
	 * @return
	 */
	public java.lang.Long getPayAmount() {
		return this.payAmount;
	}
	/**
	 * 手续费
	 * @param payFee
	 */
	public void setPayFee(java.lang.Long payFee) {
		this.payFee = payFee;
	}
	
	/**
	 * 手续费
	 * @return
	 */
	public java.lang.Long getPayFee() {
		return this.payFee;
	}
	/**
	 * 汇款人地址
	 * @param payerAddress
	 */
	public void setPayerAddress(java.lang.String payerAddress) {
		this.payerAddress = payerAddress;
	}
	
	/**
	 * 汇款人地址
	 * @return
	 */
	public java.lang.String getPayerAddress() {
		return this.payerAddress;
	}
	/**
	 * 汇款人手机号
	 * @param payerPhone
	 */
	public void setPayerPhone(java.lang.String payerPhone) {
		this.payerPhone = payerPhone;
	}
	
	/**
	 * 汇款人手机号
	 * @return
	 */
	public java.lang.String getPayerPhone() {
		return this.payerPhone;
	}
	/**
	 * 汇款人账号
	 * @param payerAccount
	 */
	public void setPayerAccount(java.lang.String payerAccount) {
		this.payerAccount = payerAccount;
	}
	
	/**
	 * 汇款人账号
	 * @return
	 */
	public java.lang.String getPayerAccount() {
		return this.payerAccount;
	}
	/**
	 * 附言
	 * @param payerRemark
	 */
	public void setPayerRemark(java.lang.String payerRemark) {
		this.payerRemark = payerRemark;
	}
	
	/**
	 * 附言
	 * @return
	 */
	public java.lang.String getPayerRemark() {
		return this.payerRemark;
	}
	/**
	 * 操作员号
	 * @param operaterNum
	 */
	public void setOperaterNum(java.lang.String operaterNum) {
		this.operaterNum = operaterNum;
	}
	
	/**
	 * 操作员号
	 * @return
	 */
	public java.lang.String getOperaterNum() {
		return this.operaterNum;
	}
	/**
	 * 汇款机构
	 * @param remitOrgan
	 */
	public void setRemitOrgan(java.lang.String remitOrgan) {
		this.remitOrgan = remitOrgan;
	}
	
	/**
	 * 汇款机构
	 * @return
	 */
	public java.lang.String getRemitOrgan() {
		return this.remitOrgan;
	}
	/**
	 * 汇款人城市
	 * @param remitCity
	 */
	public void setRemitCity(java.lang.String remitCity) {
		this.remitCity = remitCity;
	}
	
	/**
	 * 汇款人城市
	 * @return
	 */
	public java.lang.String getRemitCity() {
		return this.remitCity;
	}
	/**
	 * 汇款人省
	 * @param remitPro
	 */
	public void setRemitPro(java.lang.String remitPro) {
		this.remitPro = remitPro;
	}
	
	/**
	 * 汇款人省
	 * @return
	 */
	public java.lang.String getRemitPro() {
		return this.remitPro;
	}
	/**
	 * 发票抬头
	 * @param invoiceTile
	 */
	public void setInvoiceTile(java.lang.String invoiceTile) {
		this.invoiceTile = invoiceTile;
	}
	
	/**
	 * 发票抬头
	 * @return
	 */
	public java.lang.String getInvoiceTile() {
		return this.invoiceTile;
	}
	/**
	 * 收汇日期
	 * @param receiveRemitDay
	 */
	public void setReceiveRemitDay(java.util.Date receiveRemitDay) {
		this.receiveRemitDay = receiveRemitDay;
	}
	
	/**
	 * 收汇日期
	 * @return
	 */
	public java.util.Date getReceiveRemitDay() {
		return this.receiveRemitDay;
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
	 * 支付方式
	 * @param payType
	 */
	public void setPayType(java.lang.String payType) {
		this.payType = payType;
	}
	
	/**
	 * 支付方式
	 * @return
	 */
	public java.lang.String getPayType() {
		return this.payType;
	}
	/**
	 * Y:全部付款N:部分付款
	 * @param extend1
	 */
	public void setExtend1(java.lang.String extend1) {
		this.extend1 = extend1;
	}
	
	/**
	 * Y:全部付款N:部分付款
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