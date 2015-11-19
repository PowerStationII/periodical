/*
 * Powered By code-generator
 * Since 2015 - 2015
 */

package com.cn.periodical.pojo;

import java.io.Serializable;

/**
 * AdFlows
 * @author code-generator
 *
 */
public class AdFlows implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private java.lang.Long id;
	private java.lang.String councilId;
	private java.lang.String adId;
	private java.lang.String periodicalId;
	private java.lang.String periodicalIssueNo;
	private java.lang.String extend1;
	private java.lang.String extend2;
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
	 * 理事会id
	 * @param councilId
	 */
	public void setCouncilId(java.lang.String councilId) {
		this.councilId = councilId;
	}
	
	/**
	 * 理事会id
	 * @return
	 */
	public java.lang.String getCouncilId() {
		return this.councilId;
	}
	/**
	 * 广告id
	 * @param adId
	 */
	public void setAdId(java.lang.String adId) {
		this.adId = adId;
	}
	
	/**
	 * 广告id
	 * @return
	 */
	public java.lang.String getAdId() {
		return this.adId;
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
	 * 期数id
	 * @param periodicalIssueNo
	 */
	public void setPeriodicalIssueNo(java.lang.String periodicalIssueNo) {
		this.periodicalIssueNo = periodicalIssueNo;
	}
	
	/**
	 * 期数id
	 * @return
	 */
	public java.lang.String getPeriodicalIssueNo() {
		return this.periodicalIssueNo;
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