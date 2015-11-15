package com.cn.periodical.response;

import java.util.Date;

import com.cn.periodical.pojo.AccountInfo;

public class AuthorArticleQueryRespDto extends ResponseDto {

	public AuthorArticleQueryRespDto() {
		// TODO Auto-generated constructor stub
	}
	
	private java.lang.Long id;
	private java.lang.String userId;
	private java.lang.String articleName;
	private java.lang.String articleId;
	private java.lang.String articleType;
	private java.lang.String articleCnTitle;
	private java.lang.String articleEnTile;
	private java.lang.String articleCnSummary;
	private java.lang.String articleEnSummary;
	private java.lang.String articleCnKeywords;
	private java.lang.String articleEnKeywords;
	private java.lang.String isfund;
	private java.lang.String investSection;
	private java.lang.String classificationNums;
	private java.lang.String documentCode;
	private String authorState;
	private String editorState;
	private String expertState;
	private String createTime;
	private String remark;
	
	private AccountInfo accountInfo;
	
	
	public AccountInfo getAccountInfo() {
		return accountInfo;
	}
	public void setAccountInfo(AccountInfo accountInfo) {
		this.accountInfo = accountInfo;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
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
	public java.lang.Long getId() {
		return id;
	}
	public void setId(java.lang.Long id) {
		this.id = id;
	}
	public java.lang.String getUserId() {
		return userId;
	}
	public void setUserId(java.lang.String userId) {
		this.userId = userId;
	}
	public java.lang.String getArticleName() {
		return articleName;
	}
	public void setArticleName(java.lang.String articleName) {
		this.articleName = articleName;
	}
	public java.lang.String getArticleId() {
		return articleId;
	}
	public void setArticleId(java.lang.String articleId) {
		this.articleId = articleId;
	}
	public java.lang.String getArticleType() {
		return articleType;
	}
	public void setArticleType(java.lang.String articleType) {
		this.articleType = articleType;
	}
	public java.lang.String getArticleCnTitle() {
		return articleCnTitle;
	}
	public void setArticleCnTitle(java.lang.String articleCnTitle) {
		this.articleCnTitle = articleCnTitle;
	}
	public java.lang.String getArticleEnTile() {
		return articleEnTile;
	}
	public void setArticleEnTile(java.lang.String articleEnTile) {
		this.articleEnTile = articleEnTile;
	}
	public java.lang.String getArticleCnSummary() {
		return articleCnSummary;
	}
	public void setArticleCnSummary(java.lang.String articleCnSummary) {
		this.articleCnSummary = articleCnSummary;
	}
	public java.lang.String getArticleEnSummary() {
		return articleEnSummary;
	}
	public void setArticleEnSummary(java.lang.String articleEnSummary) {
		this.articleEnSummary = articleEnSummary;
	}
	public java.lang.String getArticleCnKeywords() {
		return articleCnKeywords;
	}
	public void setArticleCnKeywords(java.lang.String articleCnKeywords) {
		this.articleCnKeywords = articleCnKeywords;
	}
	public java.lang.String getArticleEnKeywords() {
		return articleEnKeywords;
	}
	public void setArticleEnKeywords(java.lang.String articleEnKeywords) {
		this.articleEnKeywords = articleEnKeywords;
	}
	public java.lang.String getIsfund() {
		return isfund;
	}
	public void setIsfund(java.lang.String isfund) {
		this.isfund = isfund;
	}
	public java.lang.String getInvestSection() {
		return investSection;
	}
	public void setInvestSection(java.lang.String investSection) {
		this.investSection = investSection;
	}
	public java.lang.String getClassificationNums() {
		return classificationNums;
	}
	public void setClassificationNums(java.lang.String classificationNums) {
		this.classificationNums = classificationNums;
	}
	public java.lang.String getDocumentCode() {
		return documentCode;
	}
	public void setDocumentCode(java.lang.String documentCode) {
		this.documentCode = documentCode;
	}
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	
	
}
