/*
 * Powered By code-generator
 * Since 2015 - 2015
 */

package com.cn.periodical.pojo;

import com.cn.periodical.utils.PagingQuery;

/**
 * ArticleInfoQuery
 * @author code-generator
 *
 */
public class ArticleInfoQuery extends PagingQuery {
	private static final long serialVersionUID = 1L;
	
	public  ArticleInfoQuery(){
		super(1, 10);
	}
	
	public  ArticleInfoQuery(int pageNo, int pageSize){
		super(pageNo, pageSize);
	}
	
	private java.lang.String userId;
	private java.lang.String articleName;
	private java.lang.String articleId;
	private java.lang.String articleType;
	private java.lang.String articleCnTitle;
	private java.lang.String articleEnTile;
	private java.lang.String articleCnSummary;
	private java.lang.String articleEnSummary;
	private byte[] artilce;
	private java.lang.String articleCnKeywords;
	private java.lang.String articleEnKeywords;
	private java.lang.String isfund;
	private java.lang.String investSection;
	private java.lang.String classificationNums;
	private java.lang.String documentCode;
	private java.lang.String remark;
	private java.lang.String referenceDoc;
	private java.util.Date receiveArticleTime;
	private java.util.Date publishTime;
	private java.lang.String state;
	private java.lang.String extends1;
	private java.lang.String extends2;
	private java.lang.String extends3;
	private java.lang.String extends4;
	private java.util.Date createTime;
	private java.util.Date updateTime;

	/**
	 * 
	 * @param userId
	 */
	public void setUserId(java.lang.String userId) {
		this.userId = userId;
	}
	
	/**
	 * 
	 * @return
	 */
	public java.lang.String getUserId() {
		return this.userId;
	}
	/**
	 * 
	 * @param articleName
	 */
	public void setArticleName(java.lang.String articleName) {
		this.articleName = articleName;
	}
	
	/**
	 * 
	 * @return
	 */
	public java.lang.String getArticleName() {
		return this.articleName;
	}
	/**
	 * 稿件编号
	 * @param articleId
	 */
	public void setArticleId(java.lang.String articleId) {
		this.articleId = articleId;
	}
	
	/**
	 * 稿件编号
	 * @return
	 */
	public java.lang.String getArticleId() {
		return this.articleId;
	}
	/**
	 * 稿件类型
	 * @param articleType
	 */
	public void setArticleType(java.lang.String articleType) {
		this.articleType = articleType;
	}
	
	/**
	 * 稿件类型
	 * @return
	 */
	public java.lang.String getArticleType() {
		return this.articleType;
	}
	/**
	 * 
	 * @param articleCnTitle
	 */
	public void setArticleCnTitle(java.lang.String articleCnTitle) {
		this.articleCnTitle = articleCnTitle;
	}
	
	/**
	 * 
	 * @return
	 */
	public java.lang.String getArticleCnTitle() {
		return this.articleCnTitle;
	}
	/**
	 * 
	 * @param articleEnTile
	 */
	public void setArticleEnTile(java.lang.String articleEnTile) {
		this.articleEnTile = articleEnTile;
	}
	
	/**
	 * 
	 * @return
	 */
	public java.lang.String getArticleEnTile() {
		return this.articleEnTile;
	}
	/**
	 * 
	 * @param articleCnSummary
	 */
	public void setArticleCnSummary(java.lang.String articleCnSummary) {
		this.articleCnSummary = articleCnSummary;
	}
	
	/**
	 * 
	 * @return
	 */
	public java.lang.String getArticleCnSummary() {
		return this.articleCnSummary;
	}
	/**
	 * 
	 * @param articleEnSummary
	 */
	public void setArticleEnSummary(java.lang.String articleEnSummary) {
		this.articleEnSummary = articleEnSummary;
	}
	
	/**
	 * 
	 * @return
	 */
	public java.lang.String getArticleEnSummary() {
		return this.articleEnSummary;
	}
	/**
	 * 
	 * @param artilce
	 */
	public void setArtilce(byte[] artilce) {
		this.artilce = artilce;
	}
	
	/**
	 * 
	 * @return
	 */
	public byte[] getArtilce() {
		return this.artilce;
	}
	/**
	 * 
	 * @param articleCnKeywords
	 */
	public void setArticleCnKeywords(java.lang.String articleCnKeywords) {
		this.articleCnKeywords = articleCnKeywords;
	}
	
	/**
	 * 
	 * @return
	 */
	public java.lang.String getArticleCnKeywords() {
		return this.articleCnKeywords;
	}
	/**
	 * 
	 * @param articleEnKeywords
	 */
	public void setArticleEnKeywords(java.lang.String articleEnKeywords) {
		this.articleEnKeywords = articleEnKeywords;
	}
	
	/**
	 * 
	 * @return
	 */
	public java.lang.String getArticleEnKeywords() {
		return this.articleEnKeywords;
	}
	/**
	 * 
	 * @param isfund
	 */
	public void setIsfund(java.lang.String isfund) {
		this.isfund = isfund;
	}
	
	/**
	 * 
	 * @return
	 */
	public java.lang.String getIsfund() {
		return this.isfund;
	}
	/**
	 * 
	 * @param investSection
	 */
	public void setInvestSection(java.lang.String investSection) {
		this.investSection = investSection;
	}
	
	/**
	 * 
	 * @return
	 */
	public java.lang.String getInvestSection() {
		return this.investSection;
	}
	/**
	 * 中国分类号
	 * @param classificationNums
	 */
	public void setClassificationNums(java.lang.String classificationNums) {
		this.classificationNums = classificationNums;
	}
	
	/**
	 * 中国分类号
	 * @return
	 */
	public java.lang.String getClassificationNums() {
		return this.classificationNums;
	}
	/**
	 * 文献标识码
	 * @param documentCode
	 */
	public void setDocumentCode(java.lang.String documentCode) {
		this.documentCode = documentCode;
	}
	
	/**
	 * 文献标识码
	 * @return
	 */
	public java.lang.String getDocumentCode() {
		return this.documentCode;
	}
	/**
	 * 
	 * @param remark
	 */
	public void setRemark(java.lang.String remark) {
		this.remark = remark;
	}
	
	/**
	 * 
	 * @return
	 */
	public java.lang.String getRemark() {
		return this.remark;
	}
	/**
	 * 参考文献
	 * @param referenceDoc
	 */
	public void setReferenceDoc(java.lang.String referenceDoc) {
		this.referenceDoc = referenceDoc;
	}
	
	/**
	 * 参考文献
	 * @return
	 */
	public java.lang.String getReferenceDoc() {
		return this.referenceDoc;
	}
	/**
	 * 收稿时间
	 * @param receiveArticleTime
	 */
	public void setReceiveArticleTime(java.util.Date receiveArticleTime) {
		this.receiveArticleTime = receiveArticleTime;
	}
	
	/**
	 * 收稿时间
	 * @return
	 */
	public java.util.Date getReceiveArticleTime() {
		return this.receiveArticleTime;
	}
	/**
	 * 发行时间
	 * @param publishTime
	 */
	public void setPublishTime(java.util.Date publishTime) {
		this.publishTime = publishTime;
	}
	
	/**
	 * 发行时间
	 * @return
	 */
	public java.util.Date getPublishTime() {
		return this.publishTime;
	}
	/**
	 * 
	 * @param state
	 */
	public void setState(java.lang.String state) {
		this.state = state;
	}
	
	/**
	 * 
	 * @return
	 */
	public java.lang.String getState() {
		return this.state;
	}
	/**
	 * 
	 * @param extends1
	 */
	public void setExtends1(java.lang.String extends1) {
		this.extends1 = extends1;
	}
	
	/**
	 * 
	 * @return
	 */
	public java.lang.String getExtends1() {
		return this.extends1;
	}
	/**
	 * 
	 * @param extends2
	 */
	public void setExtends2(java.lang.String extends2) {
		this.extends2 = extends2;
	}
	
	/**
	 * 
	 * @return
	 */
	public java.lang.String getExtends2() {
		return this.extends2;
	}
	/**
	 * 
	 * @param extends3
	 */
	public void setExtends3(java.lang.String extends3) {
		this.extends3 = extends3;
	}
	
	/**
	 * 
	 * @return
	 */
	public java.lang.String getExtends3() {
		return this.extends3;
	}
	/**
	 * 
	 * @param extends4
	 */
	public void setExtends4(java.lang.String extends4) {
		this.extends4 = extends4;
	}
	
	/**
	 * 
	 * @return
	 */
	public java.lang.String getExtends4() {
		return this.extends4;
	}
	/**
	 * 
	 * @param createTime
	 */
	public void setCreateTime(java.util.Date createTime) {
		this.createTime = createTime;
	}
	
	/**
	 * 
	 * @return
	 */
	public java.util.Date getCreateTime() {
		return this.createTime;
	}
	/**
	 * 
	 * @param updateTime
	 */
	public void setUpdateTime(java.util.Date updateTime) {
		this.updateTime = updateTime;
	}
	
	/**
	 * 
	 * @return
	 */
	public java.util.Date getUpdateTime() {
		return this.updateTime;
	}
}