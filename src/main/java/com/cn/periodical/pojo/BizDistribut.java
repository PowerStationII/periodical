package com.cn.periodical.pojo;

import java.io.Serializable;

public class BizDistribut implements Serializable {

	public BizDistribut() {
		// TODO Auto-generated constructor stub
	}
	
	private String aId;
	private String cName;
	private String cMobile;
	private String rAddress;
	private String rPostCode;
	private String rContacter;
	private String status;
	private String userId;
	public String getaId() {
		return aId;
	}
	public void setaId(String aId) {
		this.aId = aId;
	}
	public String getcName() {
		return cName;
	}
	public void setcName(String cName) {
		this.cName = cName;
	}
	public String getcMobile() {
		return cMobile;
	}
	public void setcMobile(String cMobile) {
		this.cMobile = cMobile;
	}
	public String getrAddress() {
		return rAddress;
	}
	public void setrAddress(String rAddress) {
		this.rAddress = rAddress;
	}
	public String getrPostCode() {
		return rPostCode;
	}
	public void setrPostCode(String rPostCode) {
		this.rPostCode = rPostCode;
	}
	public String getrContacter() {
		return rContacter;
	}
	public void setrContacter(String rContacter) {
		this.rContacter = rContacter;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
}
