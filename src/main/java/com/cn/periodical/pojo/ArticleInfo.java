/*
 * Powered By code-generator
 * Since 2015 - 2015
 */

package com.cn.periodical.pojo;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * ArticleInfo
 * @author code-generator
 *
 */
public class ArticleInfo implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private java.lang.Long id;
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
	private java.lang.String inovationPoint;
	private java.lang.String referenceDoc;
	private java.util.Date receiveArticleTime;
	private java.util.Date publishTime;
	private java.lang.Integer totalPics;
	private java.lang.Integer totalTabs;
	private java.lang.Integer totalPages;
	private java.lang.String fundTitle;
	private java.lang.String editorState;
	private java.lang.String expertState;
	private java.lang.String authorState;
	private java.lang.String isAvaliable;
	private java.lang.Long latelyFlowsId;
	private java.lang.String extends2;
	private java.lang.String extends3;
	private java.lang.String extends4;
	private java.util.Date createTime;
	private java.util.Date updateTime;
	
	private List<BizAuthorAddressInfo> bizAuthorAddressInfos;
	private List<ArticleAttachmentInfo> articleAttachmentInfos;

	public List<BizAuthorAddressInfo> getBizAuthorAddressInfos() {
		return bizAuthorAddressInfos;
	}

	public void setBizAuthorAddressInfos(List<BizAuthorAddressInfo> bizAuthorAddressInfos) {
		this.bizAuthorAddressInfos = bizAuthorAddressInfos;
	}

	public List<ArticleAttachmentInfo> getArticleAttachmentInfos() {
		return articleAttachmentInfos;
	}

	public void setArticleAttachmentInfos(List<ArticleAttachmentInfo> articleAttachmentInfos) {
		this.articleAttachmentInfos = articleAttachmentInfos;
	}

	/**
	 * @param id
	 */
	public void setId(Long id) {
		this.id = id;
	}
	
	/**
	 * @return
	 */
	public Long getId() {
		return this.id;
	}
	/**
	 * 稿件名称
	 * @param articleName
	 */
	public void setArticleName(java.lang.String articleName) {
		this.articleName = articleName;
	}
	
	/**
	 * 稿件名称
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
	 * 中文标题
	 * @param articleCnTitle
	 */
	public void setArticleCnTitle(java.lang.String articleCnTitle) {
		this.articleCnTitle = articleCnTitle;
	}
	
	/**
	 * 中文标题
	 * @return
	 */
	public java.lang.String getArticleCnTitle() {
		return this.articleCnTitle;
	}
	/**
	 * 英文标题
	 * @param articleEnTile
	 */
	public void setArticleEnTile(java.lang.String articleEnTile) {
		this.articleEnTile = articleEnTile;
	}
	
	/**
	 * 英文标题
	 * @return
	 */
	public java.lang.String getArticleEnTile() {
		return this.articleEnTile;
	}
	/**
	 * 中文摘要
	 * @param articleCnSummary
	 */
	public void setArticleCnSummary(java.lang.String articleCnSummary) {
		this.articleCnSummary = articleCnSummary;
	}
	
	/**
	 * 中文摘要
	 * @return
	 */
	public java.lang.String getArticleCnSummary() {
		return this.articleCnSummary;
	}
	/**
	 * 英文摘要
	 * @param articleEnSummary
	 */
	public void setArticleEnSummary(java.lang.String articleEnSummary) {
		this.articleEnSummary = articleEnSummary;
	}
	
	/**
	 * 英文摘要
	 * @return
	 */
	public java.lang.String getArticleEnSummary() {
		return this.articleEnSummary;
	}
	/**
	 * 稿件明细
	 * @param artilce
	 */
	public void setArtilce(byte[] artilce) {
		this.artilce = artilce;
	}
	
	/**
	 * 稿件明细
	 * @return
	 */
	public byte[] getArtilce() {
		return this.artilce;
	}
	/**
	 * 中文关键字
	 * @param articleCnKeywords
	 */
	public void setArticleCnKeywords(java.lang.String articleCnKeywords) {
		this.articleCnKeywords = articleCnKeywords;
	}
	
	/**
	 * 中文关键字
	 * @return
	 */
	public java.lang.String getArticleCnKeywords() {
		return this.articleCnKeywords;
	}
	/**
	 * 英文关键字
	 * @param articleEnKeywords
	 */
	public void setArticleEnKeywords(java.lang.String articleEnKeywords) {
		this.articleEnKeywords = articleEnKeywords;
	}
	
	/**
	 * 英文关键字
	 * @return
	 */
	public java.lang.String getArticleEnKeywords() {
		return this.articleEnKeywords;
	}
	/**
	 * 是否基金项目:N否Y是
	 * @param isfund
	 */
	public void setIsfund(java.lang.String isfund) {
		this.isfund = isfund;
	}
	
	/**
	 * 是否基金项目:N否Y是
	 * @return
	 */
	public java.lang.String getIsfund() {
		return this.isfund;
	}
	/**
	 * 拟投栏目
	 * @param investSection
	 */
	public void setInvestSection(java.lang.String investSection) {
		this.investSection = investSection;
	}
	
	/**
	 * 拟投栏目
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
	 * 论文用途及要求备注
	 * @param remark
	 */
	public void setRemark(java.lang.String remark) {
		this.remark = remark;
	}
	
	/**
	 * 论文用途及要求备注
	 * @return
	 */
	public java.lang.String getRemark() {
		return this.remark;
	}
	/**
	 * 论文查新点、学术
	 * @param inovationPoint
	 */
	public void setInovationPoint(java.lang.String inovationPoint) {
		this.inovationPoint = inovationPoint;
	}
	
	/**
	 * 论文查新点、学术
	 * @return
	 */
	public java.lang.String getInovationPoint() {
		return this.inovationPoint;
	}
	/**
	 * 参考信息
	 * @param referenceDoc
	 */
	public void setReferenceDoc(java.lang.String referenceDoc) {
		this.referenceDoc = referenceDoc;
	}
	
	/**
	 * 参考信息
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
	 * 图片总数
	 * @param totalPics
	 */
	public void setTotalPics(java.lang.Integer totalPics) {
		this.totalPics = totalPics;
	}
	
	/**
	 * 图片总数
	 * @return
	 */
	public java.lang.Integer getTotalPics() {
		return this.totalPics;
	}
	/**
	 * 表格总数
	 * @param totalTabs
	 */
	public void setTotalTabs(java.lang.Integer totalTabs) {
		this.totalTabs = totalTabs;
	}
	
	/**
	 * 表格总数
	 * @return
	 */
	public java.lang.Integer getTotalTabs() {
		return this.totalTabs;
	}
	/**
	 * 稿件总页数
	 * @param totalPages
	 */
	public void setTotalPages(java.lang.Integer totalPages) {
		this.totalPages = totalPages;
	}
	
	/**
	 * 稿件总页数
	 * @return
	 */
	public java.lang.Integer getTotalPages() {
		return this.totalPages;
	}
	/**
	 * 基金项目名称
	 * @param fundTitle
	 */
	public void setFundTitle(java.lang.String fundTitle) {
		this.fundTitle = fundTitle;
	}
	
	/**
	 * 基金项目名称
	 * @return
	 */
	public java.lang.String getFundTitle() {
		return this.fundTitle;
	}
	/**
	 * 0004:处理中;0000:新稿;0006:返修;0007:退稿;0001:已登记;0002:已送审;0003:已待刊
	 * @param editorState
	 */
	public void setEditorState(java.lang.String editorState) {
		this.editorState = editorState;
	}
	
	/**
	 * 0004:处理中;0000:新稿;0006:返修;0007:退稿;0001:已登记;0002:已送审;0003:已待刊
	 * @return
	 */
	public java.lang.String getEditorState() {
		return this.editorState;
	}
	/**
	 * 0003:已待刊;0006:返修;0007:退稿;
	 * @param expertState
	 */
	public void setExpertState(java.lang.String expertState) {
		this.expertState = expertState;
	}
	
	/**
	 * 0003:已待刊;0006:返修;0007:退稿;
	 * @return
	 */
	public java.lang.String getExpertState() {
		return this.expertState;
	}
	/**
	 * 0000:新稿;0006:返修;0007:退稿;0001:已登记;0002:已送审;0003:已待刊
	 * @param authorState
	 */
	public void setAuthorState(java.lang.String authorState) {
		this.authorState = authorState;
	}
	
	/**
	 * 0000:新稿;0006:返修;0007:退稿;0001:已登记;0002:已送审;0003:已待刊
	 * @return
	 */
	public java.lang.String getAuthorState() {
		return this.authorState;
	}
	/**
	 * 稿件是否处于可编辑的状态:1不可编辑(作废)0可编辑
	 * @param isAvaliable
	 */
	public void setIsAvaliable(java.lang.String isAvaliable) {
		this.isAvaliable = isAvaliable;
	}
	
	/**
	 * 稿件是否处于可编辑的状态:1不可编辑(作废)0可编辑
	 * @return
	 */
	public java.lang.String getIsAvaliable() {
		return this.isAvaliable;
	}
	/**
	 * article_flow表中该稿件的最大id
	 * @param latelyFlowsId
	 */
	public void setLatelyFlowsId(java.lang.Long latelyFlowsId) {
		this.latelyFlowsId = latelyFlowsId;
	}
	
	/**
	 * article_flow表中该稿件的最大id
	 * @return
	 */
	public java.lang.Long getLatelyFlowsId() {
		return this.latelyFlowsId;
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