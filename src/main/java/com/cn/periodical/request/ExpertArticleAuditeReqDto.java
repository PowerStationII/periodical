package com.cn.periodical.request;

public class ExpertArticleAuditeReqDto extends RequestDto {

	public ExpertArticleAuditeReqDto() {
		// TODO Auto-generated constructor stub
	}

	private String userId;
	private String title;
	private String authorName;
	private String articleId;
	private String articleState;
	private String sectionName;
	private String submitTime;
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthorName() {
		return authorName;
	}
	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}
	public String getArticleId() {
		return articleId;
	}
	public void setArticleId(String articleId) {
		this.articleId = articleId;
	}
	public String getArticleState() {
		return articleState;
	}
	public void setArticleState(String articleState) {
		this.articleState = articleState;
	}
	public String getSectionName() {
		return sectionName;
	}
	public void setSectionName(String sectionName) {
		this.sectionName = sectionName;
	}
	public String getSubmitTime() {
		return submitTime;
	}
	public void setSubmitTime(String submitTime) {
		this.submitTime = submitTime;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
}
