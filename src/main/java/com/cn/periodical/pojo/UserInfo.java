/*
 * Powered By chanjetpay-code-generator
 * Web Site: http://www.chanjetpay.com
 * Since 2014 - 2015
 */

package com.cn.periodical.pojo;

import java.io.Serializable;

/**
 * UserInfo
 * @author code-generator
 *
 */
public class UserInfo implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private java.lang.Long id;
	private java.lang.String userId;
	private java.lang.String logonName;
	private java.lang.String logonPwd;
	private java.lang.String refId;
	private java.lang.String roleId;
	private java.lang.String systemId;
	private java.lang.Integer retryTimes;
	private java.lang.String status;
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
	 * 系统生成用户id号
	 * @param userId
	 */
	public void setUserId(java.lang.String userId) {
		this.userId = userId;
	}
	
	/**
	 * 系统生成用户id号
	 * @return
	 */
	public java.lang.String getUserId() {
		return this.userId;
	}
	/**
	 * 登录名
	 * @param logonName
	 */
	public void setLogonName(java.lang.String logonName) {
		this.logonName = logonName;
	}
	
	/**
	 * 登录名
	 * @return
	 */
	public java.lang.String getLogonName() {
		return this.logonName;
	}
	/**
	 * 登录密码
	 * @param logonPwd
	 */
	public void setLogonPwd(java.lang.String logonPwd) {
		this.logonPwd = logonPwd;
	}
	
	/**
	 * 登录密码
	 * @return
	 */
	public java.lang.String getLogonPwd() {
		return this.logonPwd;
	}
	/**
	 * 关联id(根据role_id决定该值ref_id为哪个表的关联id)
	 * @param refId
	 */
	public void setRefId(java.lang.String refId) {
		this.refId = refId;
	}
	
	/**
	 * 关联id(根据role_id决定该值ref_id为哪个表的关联id)
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
	 * 系统id
	 * @param systemId
	 */
	public void setSystemId(java.lang.String systemId) {
		this.systemId = systemId;
	}
	
	/**
	 * 系统id
	 * @return
	 */
	public java.lang.String getSystemId() {
		return this.systemId;
	}
	/**
	 * 密码重置次数(5次上限)
	 * @param retryTimes
	 */
	public void setRetryTimes(java.lang.Integer retryTimes) {
		this.retryTimes = retryTimes;
	}
	
	/**
	 * 密码重置次数(5次上限)
	 * @return
	 */
	public java.lang.Integer getRetryTimes() {
		return this.retryTimes;
	}
	/**
	 * 用户状态0:可用;1:不可用
	 * @param status
	 */
	public void setStatus(java.lang.String status) {
		this.status = status;
	}
	
	/**
	 * 用户状态0:可用;1:不可用
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