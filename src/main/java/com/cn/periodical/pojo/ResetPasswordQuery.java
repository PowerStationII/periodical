/*
 * Powered By code-generator
 * Since 2015 - 2015
 */

package com.cn.periodical.pojo;

import com.cn.periodical.utils.PagingQuery;

/**
 * ResetPasswordQuery
 * @author code-generator
 *
 */
public class ResetPasswordQuery extends PagingQuery {
	private static final long serialVersionUID = 1L;
	
	public  ResetPasswordQuery(){
		super(1, 10);
	}
	
	public  ResetPasswordQuery(int pageNo, int pageSize){
		super(pageNo, pageSize);
	}
	
	private java.lang.String logonName;
	private java.lang.String randomStr;
	private java.lang.String isClick;
	private java.util.Date startTime;
	private java.util.Date endTime;
	private java.lang.String extend1;
	private java.lang.String extend2;
	private java.lang.String extend3;
	private java.lang.String extend4;
	private java.util.Date createTime;
	private java.util.Date updateTime;

	/**
	 * 
	 * @param logonName
	 */
	public void setLogonName(java.lang.String logonName) {
		this.logonName = logonName;
	}
	
	/**
	 * 
	 * @return
	 */
	public java.lang.String getLogonName() {
		return this.logonName;
	}
	/**
	 * 
	 * @param randomStr
	 */
	public void setRandomStr(java.lang.String randomStr) {
		this.randomStr = randomStr;
	}
	
	/**
	 * 
	 * @return
	 */
	public java.lang.String getRandomStr() {
		return this.randomStr;
	}
	/**
	 * 
	 * @param isClick
	 */
	public void setIsClick(java.lang.String isClick) {
		this.isClick = isClick;
	}
	
	/**
	 * 
	 * @return
	 */
	public java.lang.String getIsClick() {
		return this.isClick;
	}
	/**
	 * 生效时间
	 * @param startTime
	 */
	public void setStartTime(java.util.Date startTime) {
		this.startTime = startTime;
	}
	
	/**
	 * 生效时间
	 * @return
	 */
	public java.util.Date getStartTime() {
		return this.startTime;
	}
	/**
	 * 失效时间
	 * @param endTime
	 */
	public void setEndTime(java.util.Date endTime) {
		this.endTime = endTime;
	}
	
	/**
	 * 失效时间
	 * @return
	 */
	public java.util.Date getEndTime() {
		return this.endTime;
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