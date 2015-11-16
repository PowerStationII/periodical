package com.cn.periodical.response;

import java.util.List;

import com.cn.periodical.pojo.AccountInfo;
import com.cn.periodical.pojo.AddressInfo;
import com.cn.periodical.pojo.ArticleAttachmentInfo;
import com.cn.periodical.pojo.ArticleFlows;
import com.cn.periodical.pojo.ArticleInfo;
import com.cn.periodical.pojo.AuthorInfo;

/**
 * 稿件查询接口出参
 * */
public class ArticleQueryRespDto extends ResponseDto {

	public ArticleQueryRespDto() {
		// TODO Auto-generated constructor stub
	}
	
	private ArticleInfo articleInfo;
	private ArticleAttachmentInfo attachmentInfo;
	private List<AuthorInfo> authorInfos;
	private List<AddressInfo> addressInfo;
	
	private ArticleFlows articleFlows;
	private AccountInfo accountInfo;
	
	private String authorName;
	private String contriTime;
	private String articleId;
	private String title;
	
	private String enTitle;
	private String fNums;
	private String section;
	private String cnKeywords;
	private String enKeywords;
	private String cnSummary;
	private String enSummary;
	private String attachName;
	private String attachPath;
	
	private String authorState;
	private String editorState;
	private String expertState;
	
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
	public ArticleInfo getArticleInfo() {
		return articleInfo;
	}
	public void setArticleInfo(ArticleInfo articleInfo) {
		this.articleInfo = articleInfo;
	}
	public ArticleAttachmentInfo getAttachmentInfo() {
		return attachmentInfo;
	}
	public void setAttachmentInfo(ArticleAttachmentInfo attachmentInfo) {
		this.attachmentInfo = attachmentInfo;
	}
	public List<AuthorInfo> getAuthorInfos() {
		return authorInfos;
	}
	public void setAuthorInfos(List<AuthorInfo> authorInfos) {
		this.authorInfos = authorInfos;
	}
	public List<AddressInfo> getAddressInfo() {
		return addressInfo;
	}
	public void setAddressInfo(List<AddressInfo> addressInfo) {
		this.addressInfo = addressInfo;
	}
	public String getAuthorName() {
		return authorName;
	}
	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}
	public ArticleFlows getArticleFlows() {
		return articleFlows;
	}
	public void setArticleFlows(ArticleFlows articleFlows) {
		this.articleFlows = articleFlows;
	}
	public AccountInfo getAccountInfo() {
		return accountInfo;
	}
	public void setAccountInfo(AccountInfo accountInfo) {
		this.accountInfo = accountInfo;
	}
	public String getContriTime() {
		return contriTime;
	}
	public void setContriTime(String contriTime) {
		this.contriTime = contriTime;
	}
	public String getArticleId() {
		return articleId;
	}
	public void setArticleId(String articleId) {
		this.articleId = articleId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getEnTitle() {
		return enTitle;
	}
	public void setEnTitle(String enTitle) {
		this.enTitle = enTitle;
	}
	public String getfNums() {
		return fNums;
	}
	public void setfNums(String fNums) {
		this.fNums = fNums;
	}
	public String getSection() {
		return section;
	}
	public void setSection(String section) {
		this.section = section;
	}
	public String getCnKeywords() {
		return cnKeywords;
	}
	public void setCnKeywords(String cnKeywords) {
		this.cnKeywords = cnKeywords;
	}
	public String getEnKeywords() {
		return enKeywords;
	}
	public void setEnKeywords(String enKeywords) {
		this.enKeywords = enKeywords;
	}
	public String getCnSummary() {
		return cnSummary;
	}
	public void setCnSummary(String cnSummary) {
		this.cnSummary = cnSummary;
	}
	public String getEnSummary() {
		return enSummary;
	}
	public void setEnSummary(String enSummary) {
		this.enSummary = enSummary;
	}
	public String getAttachName() {
		return attachName;
	}
	public void setAttachName(String attachName) {
		this.attachName = attachName;
	}
	public String getAttachPath() {
		return attachPath;
	}
	public void setAttachPath(String attachPath) {
		this.attachPath = attachPath;
	}
	
	
}
