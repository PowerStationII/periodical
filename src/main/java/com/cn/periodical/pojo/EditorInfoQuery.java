/*
 * Powered By code-generator
 * Since 2015 - 2015
 */

package com.cn.periodical.pojo;

import com.cn.periodical.utils.PagingQuery;

/**
 * EditorInfoQuery
 * @author code-generator
 *
 */
public class EditorInfoQuery extends PagingQuery {
	private static final long serialVersionUID = 1L;
	
	public  EditorInfoQuery(){
		super(1, 10);
	}
	
	public  EditorInfoQuery(int pageNo, int pageSize){
		super(pageNo, pageSize);
	}
	
	private java.lang.String editorId;
	private java.lang.String editorName;
	private java.lang.String state;
	private java.lang.String extend1;
	private java.lang.String extend2;
	private java.util.Date createTime;
	private java.util.Date updateTime;

	/**
	 * 专家编号
	 * @param editorId
	 */
	public void setEditorId(java.lang.String editorId) {
		this.editorId = editorId;
	}
	
	/**
	 * 专家编号
	 * @return
	 */
	public java.lang.String getEditorId() {
		return this.editorId;
	}
	/**
	 * 专家姓名
	 * @param editorName
	 */
	public void setEditorName(java.lang.String editorName) {
		this.editorName = editorName;
	}
	
	/**
	 * 专家姓名
	 * @return
	 */
	public java.lang.String getEditorName() {
		return this.editorName;
	}
	/**
	 * 是否可选：Y可选N不可选
	 * @param state
	 */
	public void setState(java.lang.String state) {
		this.state = state;
	}
	
	/**
	 * 是否可选：Y可选N不可选
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