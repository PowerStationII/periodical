package com.cn.periodical.request;

public class AdManageReqDto extends RequestDto {

	public AdManageReqDto() {
		// TODO Auto-generated constructor stub
	}
	private String registeredTime;
	private String councilType;
	private String adPosition;
	private String councilName;
	private String trialNo;
	private String createTime;
	public String getRegisteredTime() {
		return registeredTime;
	}
	public void setRegisteredTime(String registeredTime) {
		this.registeredTime = registeredTime;
	}
	public String getCouncilType() {
		return councilType;
	}
	public void setCouncilType(String councilType) {
		this.councilType = councilType;
	}
	public String getAdPosition() {
		return adPosition;
	}
	public void setAdPosition(String adPosition) {
		this.adPosition = adPosition;
	}
	public String getCouncilName() {
		return councilName;
	}
	public void setCouncilName(String councilName) {
		this.councilName = councilName;
	}
	public String getTrialNo() {
		return trialNo;
	}
	public void setTrialNo(String trialNo) {
		this.trialNo = trialNo;
	}
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	
	

}
