package com.cn.periodical.pojo;

import java.io.Serializable;

public class BizArticleFee implements Serializable {

	public BizArticleFee() {
		// TODO Auto-generated constructor stub
	}
	private String periodicalId;
	private String sectionId;
	private String sectionName;
	private String articleId;
	private String articleCnTitle;
	private String periodicalIssueNo;
	private String periodicalCnName;
	private String authorId;
	private String authorName;
	private String expertId;
	private String expertName;
	private String authorPayeeId;
	private String authorAmount;
	
	private String authorRealAmount;
	private String authorTaxAmount;
	private String expertPayeeId;
	private String expertAmount;
	private String expertRealAmount;
	private String expertTaxAmount;
	
	public String getAuthorPayeeId() {
		return authorPayeeId;
	}
	public void setAuthorPayeeId(String authorPayeeId) {
		this.authorPayeeId = authorPayeeId;
	}
	public String getAuthorAmount() {
		return authorAmount;
	}
	public void setAuthorAmount(String authorAmount) {
		this.authorAmount = authorAmount;
	}
	public String getAuthorRealAmount() {
		return authorRealAmount;
	}
	public void setAuthorRealAmount(String authorRealAmount) {
		this.authorRealAmount = authorRealAmount;
	}
	public String getAuthorTaxAmount() {
		return authorTaxAmount;
	}
	public void setAuthorTaxAmount(String authorTaxAmount) {
		this.authorTaxAmount = authorTaxAmount;
	}
	public String getExpertPayeeId() {
		return expertPayeeId;
	}
	public void setExpertPayeeId(String expertPayeeId) {
		this.expertPayeeId = expertPayeeId;
	}
	public String getExpertAmount() {
		return expertAmount;
	}
	public void setExpertAmount(String expertAmount) {
		this.expertAmount = expertAmount;
	}
	public String getExpertRealAmount() {
		return expertRealAmount;
	}
	public void setExpertRealAmount(String expertRealAmount) {
		this.expertRealAmount = expertRealAmount;
	}
	public String getExpertTaxAmount() {
		return expertTaxAmount;
	}
	public void setExpertTaxAmount(String expertTaxAmount) {
		this.expertTaxAmount = expertTaxAmount;
	}
	
	
	
	
	
	
	
	
	public String getPeriodicalId() {
		return periodicalId;
	}
	public void setPeriodicalId(String periodicalId) {
		this.periodicalId = periodicalId;
	}
	public String getSectionId() {
		return sectionId;
	}
	public void setSectionId(String sectionId) {
		this.sectionId = sectionId;
	}
	public String getSectionName() {
		return sectionName;
	}
	public void setSectionName(String sectionName) {
		this.sectionName = sectionName;
	}
	public String getArticleId() {
		return articleId;
	}
	public void setArticleId(String articleId) {
		this.articleId = articleId;
	}
	public String getArticleCnTitle() {
		return articleCnTitle;
	}
	public void setArticleCnTitle(String articleCnTitle) {
		this.articleCnTitle = articleCnTitle;
	}
	public String getPeriodicalIssueNo() {
		return periodicalIssueNo;
	}
	public void setPeriodicalIssueNo(String periodicalIssueNo) {
		this.periodicalIssueNo = periodicalIssueNo;
	}
	public String getPeriodicalCnName() {
		return periodicalCnName;
	}
	public void setPeriodicalCnName(String periodicalCnName) {
		this.periodicalCnName = periodicalCnName;
	}
	public String getAuthorId() {
		return authorId;
	}
	public void setAuthorId(String authorId) {
		this.authorId = authorId;
	}
	public String getAuthorName() {
		return authorName;
	}
	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}
	public String getExpertId() {
		return expertId;
	}
	public void setExpertId(String expertId) {
		this.expertId = expertId;
	}
	public String getExpertName() {
		return expertName;
	}
	public void setExpertName(String expertName) {
		this.expertName = expertName;
	}
}
