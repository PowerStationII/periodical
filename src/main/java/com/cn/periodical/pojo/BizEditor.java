package com.cn.periodical.pojo;

import java.io.Serializable;

public class BizEditor implements Serializable {

	public BizEditor() {
		// TODO Auto-generated constructor stub
	}
	private String editorName;
	private String logonName;
	private String roleId;
	private String expertName;
	private String periodicalName;
	private String sectionName;
	
	
	public String getSectionName() {
		return sectionName;
	}
	public void setSectionName(String sectionName) {
		this.sectionName = sectionName;
	}
	public String getPeriodicalName() {
		return periodicalName;
	}
	public void setPeriodicalName(String periodicalName) {
		this.periodicalName = periodicalName;
	}
	public String getEditorName() {
		return editorName;
	}
	public void setEditorName(String editorName) {
		this.editorName = editorName;
	}
	public String getLogonName() {
		return logonName;
	}
	public void setLogonName(String logonName) {
		this.logonName = logonName;
	}
	public String getRoleId() {
		return roleId;
	}
	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}
	public String getExpertName() {
		return expertName;
	}
	public void setExpertName(String expertName) {
		this.expertName = expertName;
	}
}
