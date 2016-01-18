/*
 * Powered By code-generator
 * Since 2015 - 2015
 */

package com.cn.periodical.pojo;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.cn.periodical.response.EditorArticleDealRespDto;

/**
 * SectionInfo
 * @author code-generator
 *
 */
public class SectionInfo implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private java.lang.Long id;
	private java.lang.String periodicalId;
	private java.lang.String sectionId;
	private java.lang.String sectionName;
	private java.lang.String sectionSummary;
	private java.lang.String state;
	private java.lang.String extend1;
	private java.lang.String extend2;
	private java.util.Date createTime;
	private java.util.Date updateTime;
	private String periodicalIssueNo;
	
	
	
	public String getPeriodicalIssueNo() {
		return periodicalIssueNo;
	}

	public void setPeriodicalIssueNo(String periodicalIssueNo) {
		this.periodicalIssueNo = periodicalIssueNo;
	}

	private List<Map<String,Object>> list;
	private List<Map<String,Object>> listAd;
	private List<Map<String,Object>> listAuthor; // 作者

	
	
	
	public List<Map<String, Object>> getListAd() {
		return listAd;
	}

	public void setListAd(List<Map<String, Object>> listAd) {
		this.listAd = listAd;
	}

	public List<Map<String, Object>> getList() {
		return list;
	}

	public void setList(List<Map<String, Object>> list) {
		this.list = list;
	}

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

    public List<Map<String, Object>> getListAuthor() {
        return listAuthor;
    }

    public void setListAuthor(List<Map<String, Object>> listAuthor) {
        this.listAuthor = listAuthor;
    }
}