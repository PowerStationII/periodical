/*
 * Powered By code-generator
 * Since 2015 - 2015
 */

package com.cn.periodical.pojo;

import java.io.Serializable;

/**
 * Periodical
 * @author code-generator
 *
 */
public class Periodical implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private java.lang.Long id;
	private java.lang.String userId;
	private java.lang.Integer cycleNums;
	private java.lang.String periodicalId;
	private java.lang.String periodicalIssueNo;
	private java.lang.String periodicalState;
	private java.lang.String periodicalYear;
	private java.util.Date publishTime;
	private java.lang.Integer publishNums;
	private java.lang.String clipPage;
	private java.lang.String issueOpinion;
	private java.lang.String issueState;
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
	 * @param cycleNums
	 */
	public void setCycleNums(java.lang.Integer cycleNums) {
		this.cycleNums = cycleNums;
	}
	
	/**
	 * 
	 * @return
	 */
	public java.lang.Integer getCycleNums() {
		return this.cycleNums;
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
	 * @param periodicalIssueNo
	 */
	public void setPeriodicalIssueNo(java.lang.String periodicalIssueNo) {
		this.periodicalIssueNo = periodicalIssueNo;
	}
	
	/**
	 * 
	 * @return
	 */
	public java.lang.String getPeriodicalIssueNo() {
		return this.periodicalIssueNo;
	}
	/**
	 * 
	 * @param periodicalState
	 */
	public void setPeriodicalState(java.lang.String periodicalState) {
		this.periodicalState = periodicalState;
	}
	
	/**
	 * 
	 * @return
	 */
	public java.lang.String getPeriodicalState() {
		return this.periodicalState;
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
	 * 发行时间
	 * @param publishTime
	 */
	public void setPublishTime(java.util.Date publishTime) {
		this.publishTime = publishTime;
	}
	
	/**
	 * 发行时间
	 * @return
	 */
	public java.util.Date getPublishTime() {
		return this.publishTime;
	}
	/**
	 * 发行数量
	 * @param publishNums
	 */
	public void setPublishNums(java.lang.Integer publishNums) {
		this.publishNums = publishNums;
	}
	
	/**
	 * 发行数量
	 * @return
	 */
	public java.lang.Integer getPublishNums() {
		return this.publishNums;
	}
	/**
	 * 夹页
	 * @param clipPage
	 */
	public void setClipPage(java.lang.String clipPage) {
		this.clipPage = clipPage;
	}
	
	/**
	 * 夹页
	 * @return
	 */
	public java.lang.String getClipPage() {
		return this.clipPage;
	}
	/**
	 * 签发人意见
	 * @param issueOpinion
	 */
	public void setIssueOpinion(java.lang.String issueOpinion) {
		this.issueOpinion = issueOpinion;
	}
	
	/**
	 * 签发人意见
	 * @return
	 */
	public java.lang.String getIssueOpinion() {
		return this.issueOpinion;
	}
	/**
	 * 是否签发
	 * @param issueState
	 */
	public void setIssueState(java.lang.String issueState) {
		this.issueState = issueState;
	}
	
	/**
	 * 是否签发
	 * @return
	 */
	public java.lang.String getIssueState() {
		return this.issueState;
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