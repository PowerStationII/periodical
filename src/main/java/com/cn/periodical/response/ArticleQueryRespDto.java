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
	private String authorName;
	private ArticleFlows articleFlows;
	private AccountInfo accountInfo;
	
	
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
}
