package com.cn.periodical.pojo;

import java.io.Serializable;

public class BizUserArticleExtendInfo implements Serializable {

	public BizUserArticleExtendInfo() {
		// TODO Auto-generated constructor stub
	}
	/**
	 * 用户信息
	 * */
	private java.lang.Long us_id;
	private java.lang.String us_userId;
	private java.lang.String us_logonName;
	private java.lang.String us_logonPwd;
	private java.lang.String us_refId;
	private java.lang.String us_roleId;
	private java.lang.String us_systemId;
	private java.lang.Integer us_retryTimes;
	private java.lang.String us_status;
	private java.lang.String us_extend1;
	private java.lang.String us_extend2;
	private java.lang.String us_extend3;
	private java.lang.String us_extend4;
	private java.util.Date us_createTime;
	private java.util.Date us_updateTime;

	/**
	 * 登录用户可以查看那些稿件
	 * */
	private java.lang.Long ar_ex_id;
	private java.lang.String ar_ex_userId;
	private java.lang.String ar_ex_roleId;
	private java.lang.String ar_ex_articleId;
	public java.lang.Long getUs_id() {
		return us_id;
	}
	public void setUs_id(java.lang.Long us_id) {
		this.us_id = us_id;
	}
	public java.lang.String getUs_userId() {
		return us_userId;
	}
	public void setUs_userId(java.lang.String us_userId) {
		this.us_userId = us_userId;
	}
	public java.lang.String getUs_logonName() {
		return us_logonName;
	}
	public void setUs_logonName(java.lang.String us_logonName) {
		this.us_logonName = us_logonName;
	}
	public java.lang.String getUs_logonPwd() {
		return us_logonPwd;
	}
	public void setUs_logonPwd(java.lang.String us_logonPwd) {
		this.us_logonPwd = us_logonPwd;
	}
	public java.lang.String getUs_refId() {
		return us_refId;
	}
	public void setUs_refId(java.lang.String us_refId) {
		this.us_refId = us_refId;
	}
	public java.lang.String getUs_roleId() {
		return us_roleId;
	}
	public void setUs_roleId(java.lang.String us_roleId) {
		this.us_roleId = us_roleId;
	}
	public java.lang.String getUs_systemId() {
		return us_systemId;
	}
	public void setUs_systemId(java.lang.String us_systemId) {
		this.us_systemId = us_systemId;
	}
	public java.lang.Integer getUs_retryTimes() {
		return us_retryTimes;
	}
	public void setUs_retryTimes(java.lang.Integer us_retryTimes) {
		this.us_retryTimes = us_retryTimes;
	}
	public java.lang.String getUs_status() {
		return us_status;
	}
	public void setUs_status(java.lang.String us_status) {
		this.us_status = us_status;
	}
	public java.lang.String getUs_extend1() {
		return us_extend1;
	}
	public void setUs_extend1(java.lang.String us_extend1) {
		this.us_extend1 = us_extend1;
	}
	public java.lang.String getUs_extend2() {
		return us_extend2;
	}
	public void setUs_extend2(java.lang.String us_extend2) {
		this.us_extend2 = us_extend2;
	}
	public java.lang.String getUs_extend3() {
		return us_extend3;
	}
	public void setUs_extend3(java.lang.String us_extend3) {
		this.us_extend3 = us_extend3;
	}
	public java.lang.String getUs_extend4() {
		return us_extend4;
	}
	public void setUs_extend4(java.lang.String us_extend4) {
		this.us_extend4 = us_extend4;
	}
	public java.util.Date getUs_createTime() {
		return us_createTime;
	}
	public void setUs_createTime(java.util.Date us_createTime) {
		this.us_createTime = us_createTime;
	}
	public java.util.Date getUs_updateTime() {
		return us_updateTime;
	}
	public void setUs_updateTime(java.util.Date us_updateTime) {
		this.us_updateTime = us_updateTime;
	}
	public java.lang.Long getAr_ex_id() {
		return ar_ex_id;
	}
	public void setAr_ex_id(java.lang.Long ar_ex_id) {
		this.ar_ex_id = ar_ex_id;
	}
	public java.lang.String getAr_ex_userId() {
		return ar_ex_userId;
	}
	public void setAr_ex_userId(java.lang.String ar_ex_userId) {
		this.ar_ex_userId = ar_ex_userId;
	}
	public java.lang.String getAr_ex_roleId() {
		return ar_ex_roleId;
	}
	public void setAr_ex_roleId(java.lang.String ar_ex_roleId) {
		this.ar_ex_roleId = ar_ex_roleId;
	}
	public java.lang.String getAr_ex_articleId() {
		return ar_ex_articleId;
	}
	public void setAr_ex_articleId(java.lang.String ar_ex_articleId) {
		this.ar_ex_articleId = ar_ex_articleId;
	}
}
