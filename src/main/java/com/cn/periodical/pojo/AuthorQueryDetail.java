package com.cn.periodical.pojo;

import java.io.Serializable;

public class AuthorQueryDetail implements Serializable {

	public AuthorQueryDetail() {
		// TODO Auto-generated constructor stub
	}

	private String userId;
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}

	private String articleId;
	private String authorState;
	private String articleCnTitle;
	private String articleEnTile;
	private String articleCnKeywords;
	private String articleEnKeywords;
	private String articleCnSummary;
	private String articleEnSummary;
	private String attachmentName;
	private String attachmentPath;
	private String refId;
	private String dealStartTime;
	private String expertName;
	private String cNums;
	private String section;
	
	private String aRealAmount;
	private String aAmount;
	private String aTaxAmount;
	
	private String eRealAmount;
	private String eAmount;
	private String eTaxAmount;
	
	
	public String geteRealAmount() {
		return eRealAmount;
	}
	public void seteRealAmount(String eRealAmount) {
		this.eRealAmount = eRealAmount;
	}
	public String geteAmount() {
		return eAmount;
	}
	public void seteAmount(String eAmount) {
		this.eAmount = eAmount;
	}
	public String geteTaxAmount() {
		return eTaxAmount;
	}
	public void seteTaxAmount(String eTaxAmount) {
		this.eTaxAmount = eTaxAmount;
	}
	public String getaRealAmount() {
		return aRealAmount;
	}
	public void setaRealAmount(String aRealAmount) {
		this.aRealAmount = aRealAmount;
	}
	public String getaAmount() {
		return aAmount;
	}
	public void setaAmount(String aAmount) {
		this.aAmount = aAmount;
	}
	public String getaTaxAmount() {
		return aTaxAmount;
	}
	public void setaTaxAmount(String aTaxAmount) {
		this.aTaxAmount = aTaxAmount;
	}
	public String getcNums() {
		return cNums;
	}
	public void setcNums(String cNums) {
		this.cNums = cNums;
	}
	public String getSection() {
		return section;
	}
	public void setSection(String section) {
		this.section = section;
	}
	public String getArticleId() {
		return articleId;
	}
	public void setArticleId(String articleId) {
		this.articleId = articleId;
	}
	public String getAuthorState() {
		return authorState;
	}
	public void setAuthorState(String authorState) {
		this.authorState = authorState;
	}
	public String getArticleCnTitle() {
		return articleCnTitle;
	}
	public void setArticleCnTitle(String articleCnTitle) {
		this.articleCnTitle = articleCnTitle;
	}
	public String getArticleEnTile() {
		return articleEnTile;
	}
	public void setArticleEnTile(String articleEnTile) {
		this.articleEnTile = articleEnTile;
	}
	public String getArticleCnKeywords() {
		return articleCnKeywords;
	}
	public void setArticleCnKeywords(String articleCnKeywords) {
		this.articleCnKeywords = articleCnKeywords;
	}
	public String getArticleEnKeywords() {
		return articleEnKeywords;
	}
	public void setArticleEnKeywords(String articleEnKeywords) {
		this.articleEnKeywords = articleEnKeywords;
	}
	public String getArticleCnSummary() {
		return articleCnSummary;
	}
	public void setArticleCnSummary(String articleCnSummary) {
		this.articleCnSummary = articleCnSummary;
	}
	public String getArticleEnSummary() {
		return articleEnSummary;
	}
	public void setArticleEnSummary(String articleEnSummary) {
		this.articleEnSummary = articleEnSummary;
	}
	public String getAttachmentName() {
		return attachmentName;
	}
	public void setAttachmentName(String attachmentName) {
		this.attachmentName = attachmentName;
	}
	public String getAttachmentPath() {
		return attachmentPath;
	}
	public void setAttachmentPath(String attachmentPath) {
		this.attachmentPath = attachmentPath;
	}
	public String getRefId() {
		return refId;
	}
	public void setRefId(String refId) {
		this.refId = refId;
	}
	public String getDealStartTime() {
		return dealStartTime;
	}
	public void setDealStartTime(String dealStartTime) {
		this.dealStartTime = dealStartTime;
	}
	public String getExpertName() {
		return expertName;
	}
	public void setExpertName(String expertName) {
		this.expertName = expertName;
	}
	
	
	
}
