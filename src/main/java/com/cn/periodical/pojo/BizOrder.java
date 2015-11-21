package com.cn.periodical.pojo;

import java.io.Serializable;

public class BizOrder implements Serializable {

	public BizOrder() {
		// TODO Auto-generated constructor stub
	}
	
	private String orderNo;
	private String pYear;
	private String subNums;
	private String amount;
	private String submitTime;
	private String auditTime;
	public String getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}
	public String getpYear() {
		return pYear;
	}
	public void setpYear(String pYear) {
		this.pYear = pYear;
	}
	public String getSubNums() {
		return subNums;
	}
	public void setSubNums(String subNums) {
		this.subNums = subNums;
	}
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
	public String getSubmitTime() {
		return submitTime;
	}
	public void setSubmitTime(String submitTime) {
		this.submitTime = submitTime;
	}
	public String getAuditTime() {
		return auditTime;
	}
	public void setAuditTime(String auditTime) {
		this.auditTime = auditTime;
	}
	
	
	

}
