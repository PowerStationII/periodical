package com.cn.periodical.request;

public class ArticleQueryReqDto extends RequestDto{

	public ArticleQueryReqDto() {
		// TODO Auto-generated constructor stub
	}
	
	private String id;
	private String articleId;
	private String authroName;
	private String articleCnTitle;
	private String creatTime;
	private String authorState;
	private String editroState;
	private String expertState;
	private String roleId;
	private String userId;
	
	
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getArticleId() {
		return articleId;
	}
	public void setArticleId(String articleId) {
		this.articleId = articleId;
	}
	public String getAuthroName() {
		return authroName;
	}
	public void setAuthroName(String authroName) {
		this.authroName = authroName;
	}
	public String getArticleCnTitle() {
		return articleCnTitle;
	}
	public void setArticleCnTitle(String articleCnTitle) {
		this.articleCnTitle = articleCnTitle;
	}
	public String getCreatTime() {
		return creatTime;
	}
	public void setCreatTime(String creatTime) {
		this.creatTime = creatTime;
	}
	public String getAuthorState() {
		return authorState;
	}
	public void setAuthorState(String authorState) {
		this.authorState = authorState;
	}
	public String getEditroState() {
		return editroState;
	}
	public void setEditroState(String editroState) {
		this.editroState = editroState;
	}
	public String getExpertState() {
		return expertState;
	}
	public void setExpertState(String expertState) {
		this.expertState = expertState;
	}
	public String getRoleId() {
		return roleId;
	}
	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
}
