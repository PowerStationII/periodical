/*
 * Powered By code-generator
 * Since 2015 - 2015
 */

package com.cn.periodical.pojo;

import com.cn.periodical.utils.PagingQuery;

/**
 * CouncilContractFlowsQuery
 * @author code-generator
 *
 */
public class CouncilContractFlowsQuery extends PagingQuery {
	private static final long serialVersionUID = 1L;
	
	public  CouncilContractFlowsQuery(){
		super(1, 10);
	}
	
	public  CouncilContractFlowsQuery(int pageNo, int pageSize){
		super(pageNo, pageSize);
	}
	
	private java.lang.String councilId;
	private java.lang.Long amount;
	private java.lang.String invoiceNo;
	private java.util.Date payTime;
	private java.lang.String payState;
	private java.util.Date startTime;
	private java.lang.String isLatelyRecord;
	private java.util.Date endTime;
	private java.lang.String contractContacterPhone;
	private java.lang.String contractContacter;
	private java.lang.String extend1;
	private java.lang.String extend2;
	private java.lang.String extend3;
	private java.lang.String extend4;
	private java.util.Date createTime;
	private java.util.Date updateTime;

	/**
	 * 理事会id=council_info.council_id
	 * @param councilId
	 */
	public void setCouncilId(java.lang.String councilId) {
		this.councilId = councilId;
	}
	
	/**
	 * 理事会id=council_info.council_id
	 * @return
	 */
	public java.lang.String getCouncilId() {
		return this.councilId;
	}
	/**
	 * 合同金额
	 * @param amount
	 */
	public void setAmount(java.lang.Long amount) {
		this.amount = amount;
	}
	
	/**
	 * 合同金额
	 * @return
	 */
	public java.lang.Long getAmount() {
		return this.amount;
	}
	/**
	 * 发票号
	 * @param invoiceNo
	 */
	public void setInvoiceNo(java.lang.String invoiceNo) {
		this.invoiceNo = invoiceNo;
	}
	
	/**
	 * 发票号
	 * @return
	 */
	public java.lang.String getInvoiceNo() {
		return this.invoiceNo;
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
	 * 是否付款Y已全额付N一分没付H付了部分
	 * @param payState
	 */
	public void setPayState(java.lang.String payState) {
		this.payState = payState;
	}
	
	/**
	 * 是否付款Y已全额付N一分没付H付了部分
	 * @return
	 */
	public java.lang.String getPayState() {
		return this.payState;
	}
	/**
	 * 合同开始时间
	 * @param startTime
	 */
	public void setStartTime(java.util.Date startTime) {
		this.startTime = startTime;
	}
	
	/**
	 * 合同开始时间
	 * @return
	 */
	public java.util.Date getStartTime() {
		return this.startTime;
	}
	/**
	 * 是否是最新记录.Y是,N不是.
	 * @param isLatelyRecord
	 */
	public void setIsLatelyRecord(java.lang.String isLatelyRecord) {
		this.isLatelyRecord = isLatelyRecord;
	}
	
	/**
	 * 是否是最新记录.Y是,N不是.
	 * @return
	 */
	public java.lang.String getIsLatelyRecord() {
		return this.isLatelyRecord;
	}
	/**
	 * 合同结束时间
	 * @param endTime
	 */
	public void setEndTime(java.util.Date endTime) {
		this.endTime = endTime;
	}
	
	/**
	 * 合同结束时间
	 * @return
	 */
	public java.util.Date getEndTime() {
		return this.endTime;
	}
	/**
	 * 合同联系电话
	 * @param contractContacterPhone
	 */
	public void setContractContacterPhone(java.lang.String contractContacterPhone) {
		this.contractContacterPhone = contractContacterPhone;
	}
	
	/**
	 * 合同联系电话
	 * @return
	 */
	public java.lang.String getContractContacterPhone() {
		return this.contractContacterPhone;
	}
	/**
	 * 合同联系人
	 * @param contractContacter
	 */
	public void setContractContacter(java.lang.String contractContacter) {
		this.contractContacter = contractContacter;
	}
	
	/**
	 * 合同联系人
	 * @return
	 */
	public java.lang.String getContractContacter() {
		return this.contractContacter;
	}
	/**
	 * 合同联系人
	 * @param extend1
	 */
	public void setExtend1(java.lang.String extend1) {
		this.extend1 = extend1;
	}
	
	/**
	 * 合同联系人
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