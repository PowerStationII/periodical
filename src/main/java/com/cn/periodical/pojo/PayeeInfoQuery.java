/*
 * Powered By code-generator
 * Since 2015 - 2015
 */

package com.cn.periodical.pojo;

import com.cn.periodical.utils.PagingQuery;

/**
 * PayeeInfoQuery
 * @author code-generator
 *
 */
public class PayeeInfoQuery extends PagingQuery {
	private static final long serialVersionUID = 1L;
	
	public  PayeeInfoQuery(){
		super(1, 10);
	}
	
	public  PayeeInfoQuery(int pageNo, int pageSize){
		super(pageNo, pageSize);
	}
	
	private java.lang.String refId;
	private java.lang.String payeeId;
	private java.lang.String type;
	private java.lang.String payeeAccountNo;
	private java.lang.String payeeAccountName;
	private java.lang.String payeeAccountOpen;
	private java.lang.String payeeAccountAddress;
	private java.lang.String payeeAccountPost;
	private java.lang.String payeeAccountPostCode;
	private java.lang.String payeeIdcardNo;
	private java.lang.String extend1;
	private java.util.Date createTime;
	private java.util.Date updateTime;

	/**
	 * 
	 * @param refId
	 */
	public void setRefId(java.lang.String refId) {
		this.refId = refId;
	}
	
	/**
	 * 
	 * @return
	 */
	public java.lang.String getRefId() {
		return this.refId;
	}
	/**
	 * 收款信息id
	 * @param payeeId
	 */
	public void setPayeeId(java.lang.String payeeId) {
		this.payeeId = payeeId;
	}
	
	/**
	 * 收款信息id
	 * @return
	 */
	public java.lang.String getPayeeId() {
		return this.payeeId;
	}
	/**
	 * 期刊:000(periodical_info.periodical_id);作者:001(author_info.author_id);专家:002(expert_info.expert_id)
	 * @param type
	 */
	public void setType(java.lang.String type) {
		this.type = type;
	}
	
	/**
	 * 期刊:000(periodical_info.periodical_id);作者:001(author_info.author_id);专家:002(expert_info.expert_id)
	 * @return
	 */
	public java.lang.String getType() {
		return this.type;
	}
	/**
	 * 收款账号
	 * @param payeeAccountNo
	 */
	public void setPayeeAccountNo(java.lang.String payeeAccountNo) {
		this.payeeAccountNo = payeeAccountNo;
	}
	
	/**
	 * 收款账号
	 * @return
	 */
	public java.lang.String getPayeeAccountNo() {
		return this.payeeAccountNo;
	}
	/**
	 * 收款账户名
	 * @param payeeAccountName
	 */
	public void setPayeeAccountName(java.lang.String payeeAccountName) {
		this.payeeAccountName = payeeAccountName;
	}
	
	/**
	 * 收款账户名
	 * @return
	 */
	public java.lang.String getPayeeAccountName() {
		return this.payeeAccountName;
	}
	/**
	 * 开户行
	 * @param payeeAccountOpen
	 */
	public void setPayeeAccountOpen(java.lang.String payeeAccountOpen) {
		this.payeeAccountOpen = payeeAccountOpen;
	}
	
	/**
	 * 开户行
	 * @return
	 */
	public java.lang.String getPayeeAccountOpen() {
		return this.payeeAccountOpen;
	}
	/**
	 * 邮局汇款地址
	 * @param payeeAccountAddress
	 */
	public void setPayeeAccountAddress(java.lang.String payeeAccountAddress) {
		this.payeeAccountAddress = payeeAccountAddress;
	}
	
	/**
	 * 邮局汇款地址
	 * @return
	 */
	public java.lang.String getPayeeAccountAddress() {
		return this.payeeAccountAddress;
	}
	/**
	 * 邮局汇款收款单位
	 * @param payeeAccountPost
	 */
	public void setPayeeAccountPost(java.lang.String payeeAccountPost) {
		this.payeeAccountPost = payeeAccountPost;
	}
	
	/**
	 * 邮局汇款收款单位
	 * @return
	 */
	public java.lang.String getPayeeAccountPost() {
		return this.payeeAccountPost;
	}
	/**
	 * 邮政编码
	 * @param payeeAccountPostCode
	 */
	public void setPayeeAccountPostCode(java.lang.String payeeAccountPostCode) {
		this.payeeAccountPostCode = payeeAccountPostCode;
	}
	
	/**
	 * 邮政编码
	 * @return
	 */
	public java.lang.String getPayeeAccountPostCode() {
		return this.payeeAccountPostCode;
	}
	/**
	 * 收款人身份证号(如果是作者或者专家,需要确认）
	 * @param payeeIdcardNo
	 */
	public void setPayeeIdcardNo(java.lang.String payeeIdcardNo) {
		this.payeeIdcardNo = payeeIdcardNo;
	}
	
	/**
	 * 收款人身份证号(如果是作者或者专家,需要确认）
	 * @return
	 */
	public java.lang.String getPayeeIdcardNo() {
		return this.payeeIdcardNo;
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