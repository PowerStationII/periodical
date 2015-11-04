/*
 * Powered By code-generator
 * Since 2015 - 2015
 */

package com.cn.periodical.pojo;

import java.io.Serializable;

/**
 * AddressInfo
 * @author code-generator
 *
 */
public class AddressInfo implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private java.lang.Long id;
	private java.lang.String refId;
	private java.lang.String refRoleId;
	private java.lang.String addressId;
	private java.lang.String contacterName;
	private java.lang.String contacterTelephone;
	private java.lang.String contacterMobile;
	private java.lang.String receiveAddress;
	private java.lang.String receivePostcode;
	private java.lang.String receiveContacter;
	private java.lang.String status;
	private java.lang.String extend1;
	private java.lang.String extend2;
	private java.lang.String extend3;
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
	 * authorInfo+expertInfo+editorInfo+readerInfo中的*_id编号
	 * @param refId
	 */
	public void setRefId(java.lang.String refId) {
		this.refId = refId;
	}
	
	/**
	 * authorInfo+expertInfo+editorInfo+readerInfo中的*_id编号
	 * @return
	 */
	public java.lang.String getRefId() {
		return this.refId;
	}
	/**
	 * ref_id所属表 1001:authorInfo;1002:readerInfo等
	 * @param refRoleId
	 */
	public void setRefRoleId(java.lang.String refRoleId) {
		this.refRoleId = refRoleId;
	}
	
	/**
	 * ref_id所属表 1001:authorInfo;1002:readerInfo等
	 * @return
	 */
	public java.lang.String getRefRoleId() {
		return this.refRoleId;
	}
	/**
	 * 
	 * @param addressId
	 */
	public void setAddressId(java.lang.String addressId) {
		this.addressId = addressId;
	}
	
	/**
	 * 
	 * @return
	 */
	public java.lang.String getAddressId() {
		return this.addressId;
	}
	/**
	 * 
	 * @param contacterName
	 */
	public void setContacterName(java.lang.String contacterName) {
		this.contacterName = contacterName;
	}
	
	/**
	 * 
	 * @return
	 */
	public java.lang.String getContacterName() {
		return this.contacterName;
	}
	/**
	 * 
	 * @param contacterTelephone
	 */
	public void setContacterTelephone(java.lang.String contacterTelephone) {
		this.contacterTelephone = contacterTelephone;
	}
	
	/**
	 * 
	 * @return
	 */
	public java.lang.String getContacterTelephone() {
		return this.contacterTelephone;
	}
	/**
	 * 
	 * @param contacterMobile
	 */
	public void setContacterMobile(java.lang.String contacterMobile) {
		this.contacterMobile = contacterMobile;
	}
	
	/**
	 * 
	 * @return
	 */
	public java.lang.String getContacterMobile() {
		return this.contacterMobile;
	}
	/**
	 * 
	 * @param receiveAddress
	 */
	public void setReceiveAddress(java.lang.String receiveAddress) {
		this.receiveAddress = receiveAddress;
	}
	
	/**
	 * 
	 * @return
	 */
	public java.lang.String getReceiveAddress() {
		return this.receiveAddress;
	}
	/**
	 * 
	 * @param receivePostcode
	 */
	public void setReceivePostcode(java.lang.String receivePostcode) {
		this.receivePostcode = receivePostcode;
	}
	
	/**
	 * 
	 * @return
	 */
	public java.lang.String getReceivePostcode() {
		return this.receivePostcode;
	}
	/**
	 * 
	 * @param receiveContacter
	 */
	public void setReceiveContacter(java.lang.String receiveContacter) {
		this.receiveContacter = receiveContacter;
	}
	
	/**
	 * 
	 * @return
	 */
	public java.lang.String getReceiveContacter() {
		return this.receiveContacter;
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
}