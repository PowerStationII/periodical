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
	private java.lang.String roleId;
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
	 * 
	 * @param roleId
	 */
	public void setRoleId(java.lang.String roleId) {
		this.roleId = roleId;
	}
	
	/**
	 * 
	 * @return
	 */
	public java.lang.String getRoleId() {
		return this.roleId;
	}
	/**
	 * 
	 * @param retryTimes
	 */
	public void setRetryTimes(java.lang.Integer retryTimes) {
		this.retryTimes = retryTimes;
	}
	
	/**
	 * 
	 * @return
	 */
	public java.lang.Integer getRetryTimes() {
		return this.retryTimes;
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