/*
 * Powered By code-generator
 * Since 2015 - 2015
 */

package com.cn.periodical.pojo;

import com.cn.periodical.utils.PagingQuery;

/**
 * ExpertInfoQuery
 * @author code-generator
 *
 */
public class ExpertInfoQuery extends PagingQuery {
	private static final long serialVersionUID = 1L;
	
	public  ExpertInfoQuery(){
		super(1, 10);
	}
	
	public  ExpertInfoQuery(int pageNo, int pageSize){
		super(pageNo, pageSize);
	}
	
	private java.lang.String expertId;
	private java.lang.String expertName;
	private java.lang.String state;
	private java.lang.String extend1;
	private java.lang.String extend2;
	private java.util.Date createTime;
	private java.util.Date updateTime;

	/**
	 * 
	 * @param expertId
	 */
	public void setExpertId(java.lang.String expertId) {
		this.expertId = expertId;
	}
	
	/**
	 * 
	 * @return
	 */
	public java.lang.String getExpertId() {
		return this.expertId;
	}
	/**
	 * 
	 * @param expertName
	 */
	public void setExpertName(java.lang.String expertName) {
		this.expertName = expertName;
	}
	
	/**
	 * 
	 * @return
	 */
	public java.lang.String getExpertName() {
		return this.expertName;
	}
	/**
	 * 
	 * @param state
	 */
	public void setState(java.lang.String state) {
		this.state = state;
	}
	
	/**
	 * 
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