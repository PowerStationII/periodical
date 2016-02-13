package com.cn.periodical.pojo;

import java.io.Serializable;

import com.cn.periodical.utils.PagingQuery;

public class BizAdQuery extends PagingQuery {
	
	public  BizAdQuery(){
		super(1, 10);
	}
	
	public  BizAdQuery(int pageNo, int pageSize){
		super(pageNo, pageSize);
	}
	
	private String adName;
	private String councilName;
	private String councilType;
	private String registTime;
	private String adType;
	private String trialNo;
	private String contractStartTime;
	private String contractEndTime;
	private String adId;
	private String councilId;
	private String createTime;
	private String startTime;
	private String endTime;
	
	
	public String getCouncilName() {
		return councilName;
	}
	public void setCouncilName(String councilName) {
		this.councilName = councilName;
	}
	public String getCouncilType() {
		return councilType;
	}
	public void setCouncilType(String councilType) {
		this.councilType = councilType;
	}
	public String getAdId() {
		return adId;
	}
	public void setAdId(String adId) {
		this.adId = adId;
	}
	public String getCouncilId() {
		return councilId;
	}
	public void setCouncilId(String councilId) {
		this.councilId = councilId;
	}
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	public String getEndTime() {
		return endTime;
	}
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	public String getAdName() {
		return adName;
	}
	public void setAdName(String adName) {
		this.adName = adName;
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
