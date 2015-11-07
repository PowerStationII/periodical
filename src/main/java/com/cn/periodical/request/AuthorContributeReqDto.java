package com.cn.periodical.request;

import java.util.ArrayList;
import java.util.List;

import com.cn.periodical.enums.ArticleTypeEnums;
import com.cn.periodical.pojo.AddressInfo;
import com.cn.periodical.pojo.AuthorInfo;

/**
 * 投稿请求参数
 * */
public class AuthorContributeReqDto extends RequestDto {

	public AuthorContributeReqDto() {
		// TODO Auto-generated constructor stub
	}
	/**
	 * article_info ari
	 * ari.articleId=aai.articleId
	 * aui.authorId=adi.refId
	 * 一篇文章(ari) 对应 多个附件(aai) 关联使用article_id
	 * 一篇文章(ari) 对应 多个作者(aui) 关联使用article_id
	 * 一个作者(aui) 对应 一个地址信息(adi) 关联使用author_id
	 * */
	private java.lang.String userId;
	private java.lang.String articleName;
	private java.lang.String articleId;
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
	private java.lang.String remark;
	private java.lang.String referenceDoc;
	private java.lang.Integer totalPics;
	private java.lang.Integer totalTabs;
	private java.lang.Integer totalPages;
	private java.lang.String fundTitle;
	private ArticleTypeEnums articleType;

	/**
	 * article_attachment_info aai
	 * */
	private String attachmentPath;
	private String attachmentName;
	private String cxcnsAttachmentPath;
	private String cxcnsAttachmentName;
	private String sjtztsjAttachmentPath;
	private String sjtztsjAttachmentName;
	private String yjspzpAttachmentPath;
	private String yjspzpAttachmentName;
	private String bdjcbgAttachmentPath;
	private String bdjcbgAttachmentName;
	
	/**
	 * author_info
	 * */
	List<AuthorInfo> authorList = new ArrayList<AuthorInfo>();
	
	/**
	 * address_info
	 * */
	List<AddressInfo> addressInfos=new ArrayList<AddressInfo>();

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

	public ArticleTypeEnums getArticleType() {
		return articleType;
	}

	public void setArticleType(ArticleTypeEnums articleType) {
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

	public String getAttachmentPath() {
		return attachmentPath;
	}

	public void setAttachmentPath(String attachmentPath) {
		this.attachmentPath = attachmentPath;
	}

	public String getAttachmentName() {
		return attachmentName;
	}

	public void setAttachmentName(String attachmentName) {
		this.attachmentName = attachmentName;
	}

	public String getCxcnsAttachmentPath() {
		return cxcnsAttachmentPath;
	}

	public void setCxcnsAttachmentPath(String cxcnsAttachmentPath) {
		this.cxcnsAttachmentPath = cxcnsAttachmentPath;
	}

	public String getCxcnsAttachmentName() {
		return cxcnsAttachmentName;
	}

	public void setCxcnsAttachmentName(String cxcnsAttachmentName) {
		this.cxcnsAttachmentName = cxcnsAttachmentName;
	}

	public String getSjtztsjAttachmentPath() {
		return sjtztsjAttachmentPath;
	}

	public void setSjtztsjAttachmentPath(String sjtztsjAttachmentPath) {
		this.sjtztsjAttachmentPath = sjtztsjAttachmentPath;
	}

	public String getSjtztsjAttachmentName() {
		return sjtztsjAttachmentName;
	}

	public void setSjtztsjAttachmentName(String sjtztsjAttachmentName) {
		this.sjtztsjAttachmentName = sjtztsjAttachmentName;
	}

	public String getYjspzpAttachmentPath() {
		return yjspzpAttachmentPath;
	}

	public void setYjspzpAttachmentPath(String yjspzpAttachmentPath) {
		this.yjspzpAttachmentPath = yjspzpAttachmentPath;
	}

	public String getYjspzpAttachmentName() {
		return yjspzpAttachmentName;
	}

	public void setYjspzpAttachmentName(String yjspzpAttachmentName) {
		this.yjspzpAttachmentName = yjspzpAttachmentName;
	}

	public String getBdjcbgAttachmentPath() {
		return bdjcbgAttachmentPath;
	}

	public void setBdjcbgAttachmentPath(String bdjcbgAttachmentPath) {
		this.bdjcbgAttachmentPath = bdjcbgAttachmentPath;
	}

	public String getBdjcbgAttachmentName() {
		return bdjcbgAttachmentName;
	}

	public void setBdjcbgAttachmentName(String bdjcbgAttachmentName) {
		this.bdjcbgAttachmentName = bdjcbgAttachmentName;
	}

	public List<AuthorInfo> getAuthorList() {
		return authorList;
	}

	public void setAuthorList(List<AuthorInfo> authorList) {
		this.authorList = authorList;
	}

	public List<AddressInfo> getAddressInfos() {
		return addressInfos;
	}

	public void setAddressInfos(List<AddressInfo> addressInfos) {
		this.addressInfos = addressInfos;
	}

	public java.lang.String getRemark() {
		return remark;
	}

	public void setRemark(java.lang.String remark) {
		this.remark = remark;
	}

	public java.lang.String getReferenceDoc() {
		return referenceDoc;
	}

	public void setReferenceDoc(java.lang.String referenceDoc) {
		this.referenceDoc = referenceDoc;
	}

	public java.lang.Integer getTotalPics() {
		return totalPics;
	}

	public void setTotalPics(java.lang.Integer totalPics) {
		this.totalPics = totalPics;
	}

	public java.lang.Integer getTotalTabs() {
		return totalTabs;
	}

	public void setTotalTabs(java.lang.Integer totalTabs) {
		this.totalTabs = totalTabs;
	}

	public java.lang.Integer getTotalPages() {
		return totalPages;
	}

	public void setTotalPages(java.lang.Integer totalPages) {
		this.totalPages = totalPages;
	}

	public java.lang.String getFundTitle() {
		return fundTitle;
	}

	public void setFundTitle(java.lang.String fundTitle) {
		this.fundTitle = fundTitle;
	}
}
