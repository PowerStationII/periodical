package com.cn.periodical.pojo;

import java.io.Serializable;

public class BizAd implements Serializable {

	public BizAd() {
		// TODO Auto-generated constructor stub
	}
	private String adName;
	private String concilName;
	private String concilType;
	private String registTime;
	private String adType;
	private String trialNo;
	private String contractStartTime;
	private String contractEndTime;
	public String getAdName() {
		return adName;
	}
	public void setAdName(String adName) {
		this.adName = adName;
	}
	public String getConcilName() {
		return concilName;
	}
	public void setConcilName(String concilName) {
		this.concilName = concilName;
	}
	public String getConcilType() {
		return concilType;
	}
	public void setConcilType(String concilType) {
		this.concilType = concilType;
	}
	public String getRegistTime() {
		return registTime;
	}
	public void setRegistTime(String registTime) {
		this.registTime = registTime;
	}
	public String getAdType() {
		return adType;
	}
	public void setAdType(String adType) {
		this.adType = adType;
	}
	public String getTrialNo() {
		return trialNo;
	}
	public void setTrialNo(String trialNo) {
		this.trialNo = trialNo;
	}
	public String getContractStartTime() {
		return contractStartTime;
	}
	public void setContractStartTime(String contractStartTime) {
		this.contractStartTime = contractStartTime;
	}
	public String getContractEndTime() {
		return contractEndTime;
	}
	public void setContractEndTime(String contractEndTime) {
		this.contractEndTime = contractEndTime;
	}
}
