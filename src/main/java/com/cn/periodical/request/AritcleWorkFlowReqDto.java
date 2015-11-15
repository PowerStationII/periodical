package com.cn.periodical.request;

import java.util.Date;

public class AritcleWorkFlowReqDto extends RequestDto {

	public AritcleWorkFlowReqDto() {
		// TODO Auto-generated constructor stub
	}
	private String userId;
	private String articleId;
	private String dealState;
	private String dealOpinion;
	private Date dealStartTime;
	private Date dealEndTime;
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getArticleId() {
		return articleId;
	}
	public void setArticleId(String articleId) {
		this.articleId = articleId;
	}
	public String getDealState() {
		return dealState;
	}
	public void setDealState(String dealState) {
		this.dealState = dealState;
	}
	public String getDealOpinion() {
		return dealOpinion;
	}
	public void setDealOpinion(String dealOpinion) {
		this.dealOpinion = dealOpinion;
	}
	public Date getDealStartTime() {
		return dealStartTime;
	}
	public void setDealStartTime(Date dealStartTime) {
		this.dealStartTime = dealStartTime;
	}
	public Date getDealEndTime() {
		return dealEndTime;
	}
	public void setDealEndTime(Date dealEndTime) {
		this.dealEndTime = dealEndTime;
	}
}
