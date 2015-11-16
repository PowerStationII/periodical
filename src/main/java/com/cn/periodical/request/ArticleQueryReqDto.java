package com.cn.periodical.request;
/**
 * 稿件查询接口入参
 * */
public class ArticleQueryReqDto extends RequestDto{

	public ArticleQueryReqDto() {
		// TODO Auto-generated constructor stub
	}
	
	private String id;
	private String articleId;
	private String authorName;
	private String articleCnTitle;
	private String creatTime;
	private String authorState;
	private String editorState;
	private String expertState;
	private String roleId;
	private String userId;
	private String section;
	
	
	
	
	
	
	public String getSection() {
		return section;
	}
	public void setSection(String section) {
		this.section = section;
	}
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
	
	public String getAuthorName() {
		return authorName;
	}
	public void setAuthorName(String authorName) {
		this.authorName = authorName;
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

	public String getEditorState() {
		return editorState;
	}
	public void setEditorState(String editorState) {
		this.editorState = editorState;
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
