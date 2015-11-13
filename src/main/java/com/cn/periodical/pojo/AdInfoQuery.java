/*
 * Powered By code-generator
 * Since 2015 - 2015
 */

package com.cn.periodical.pojo;

import com.cn.periodical.utils.PagingQuery;

/**
 * AdInfoQuery
 * @author code-generator
 *
 */
public class AdInfoQuery extends PagingQuery {
	private static final long serialVersionUID = 1L;
	
	public  AdInfoQuery(){
		super(1, 10);
	}
	
	public  AdInfoQuery(int pageNo, int pageSize){
		super(pageNo, pageSize);
	}
	
	private java.lang.String adId;
	private java.lang.String councilId;
	private java.lang.String adName;
	private java.lang.String adType;
	private java.lang.String adPosition;
	private java.lang.String trialNo;
	private java.lang.String extend1;
	private java.lang.String extend2;
	private java.lang.String extend3;
	private java.lang.String extend4;
	private java.util.Date createTime;
	private java.util.Date updateTime;

	/**
	 * 
	 * @param adId
	 */
	public void setAdId(java.lang.String adId) {
		this.adId = adId;
	}
	
	/**
	 * 
	 * @return
	 */
	public java.lang.String getAdId() {
		return this.adId;
	}
	/**
	 * 
	 * @param councilId
	 */
	public void setCouncilId(java.lang.String councilId) {
		this.councilId = councilId;
	}
	
	/**
	 * 
	 * @return
	 */
	public java.lang.String getCouncilId() {
		return this.councilId;
	}
	/**
	 * 
	 * @param adName
	 */
	public void setAdName(java.lang.String adName) {
		this.adName = adName;
	}
	
	/**
	 * 
	 * @return
	 */
	public java.lang.String getAdName() {
		return this.adName;
	}
	/**
	 * 
	 * @param adType
	 */
	public void setAdType(java.lang.String adType) {
		this.adType = adType;
	}
	
	/**
	 * 
	 * @return
	 */
	public java.lang.String getAdType() {
		return this.adType;
	}
	/**
	 * 刊登位置
	 * @param adPosition
	 */
	public void setAdPosition(java.lang.String adPosition) {
		this.adPosition = adPosition;
	}
	
	/**
	 * 刊登位置
	 * @return
	 */
	public java.lang.String getAdPosition() {
		return this.adPosition;
	}
	/**
	 * 广审号
	 * @param trialNo
	 */
	public void setTrialNo(java.lang.String trialNo) {
		this.trialNo = trialNo;
	}
	
	/**
	 * 广审号
	 * @return
	 */
	public java.lang.String getTrialNo() {
		return this.trialNo;
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