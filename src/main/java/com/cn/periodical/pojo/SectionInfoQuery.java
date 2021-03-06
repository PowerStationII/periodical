/*
 * Powered By code-generator
 * Since 2015 - 2015
 */

package com.cn.periodical.pojo;

import com.cn.periodical.utils.PagingQuery;

/**
 * SectionInfoQuery
 * @author code-generator
 *
 */
public class SectionInfoQuery extends PagingQuery {
	private static final long serialVersionUID = 1L;
	
	public  SectionInfoQuery(){
		super(1, 10);
	}
	
	public  SectionInfoQuery(int pageNo, int pageSize){
		super(pageNo, pageSize);
	}
	
	private java.lang.String periodicalId;
	private java.lang.String periodicalIssueNo;
	private java.lang.String sectionId;
	private java.lang.String sectionName;
	private java.lang.String sectionSummary;
	private java.lang.String state;
	private java.lang.String extend1;
	private java.lang.String extend2;
	private java.util.Date createTime;
	private java.util.Date updateTime;

	
	
	public java.lang.String getPeriodicalIssueNo() {
		return periodicalIssueNo;
	}

	public void setPeriodicalIssueNo(java.lang.String periodicalIssueNo) {
		this.periodicalIssueNo = periodicalIssueNo;
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
	 * @param sectionId
	 */
	public void setSectionId(java.lang.String sectionId) {
		this.sectionId = sectionId;
	}
	
	/**
	 * 
	 * @return
	 */
	public java.lang.String getSectionId() {
		return this.sectionId;
	}
	/**
	 * 
	 * @param sectionName
	 */
	public void setSectionName(java.lang.String sectionName) {
		this.sectionName = sectionName;
	}
	
	/**
	 * 
	 * @return
	 */
	public java.lang.String getSectionName() {
		return this.sectionName;
	}
	/**
	 * 栏目简介
	 * @param sectionSummary
	 */
	public void setSectionSummary(java.lang.String sectionSummary) {
		this.sectionSummary = sectionSummary;
	}
	
	/**
	 * 栏目简介
	 * @return
	 */
	public java.lang.String getSectionSummary() {
		return this.sectionSummary;
	}
	/**
	 * 是否可用Y可用N不可用
	 * @param state
	 */
	public void setState(java.lang.String state) {
		this.state = state;
	}
	
	/**
	 * 是否可用Y可用N不可用
	 * @return
	 */
	public java.lang.String getState() {
		return this.state;
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