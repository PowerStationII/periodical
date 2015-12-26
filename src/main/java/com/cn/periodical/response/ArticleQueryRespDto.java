package com.cn.periodical.response;

import java.util.List;

import com.cn.periodical.pojo.AccountInfo;
import com.cn.periodical.pojo.AddressInfo;
import com.cn.periodical.pojo.ArticleAttachmentInfo;
import com.cn.periodical.pojo.ArticleFlows;
import com.cn.periodical.pojo.ArticleInfo;
import com.cn.periodical.pojo.AuthorInfo;
import com.cn.periodical.pojo.BizAuthorAddressInfo;

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
	
	private List<BizAuthorAddressInfo> bizAuthorAddressInfos;

	public List<BizAuthorAddressInfo> getBizAuthorAddressInfos() {
		return bizAuthorAddressInfos;
	}
	public void setBizAuthorAddressInfos(List<BizAuthorAddressInfo> bizAuthorAddressInfos) {
		this.bizAuthorAddressInfos = bizAuthorAddressInfos;
	}

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
	private String extend1;
	
	private String editorDownload;
	private String expertDownload;
	
	
	private String authorAttachementPath;
	private String editorAttachementPath;
	private String editorDKSJ;
	private String expertDKSJ;
	private String epxertDKYJ;
	private String expertId;

    private String authorAttachementName;
    private String editorAttachementName;
	
	
	
	public String getExpertId() {
		return expertId;
	}
	public void setExpertId(String expertId) {
		this.expertId = expertId;
	}
	public String getAuthorAttachementPath() {
		return authorAttachementPath;
	}
	public void setAuthorAttachementPath(String authorAttachementPath) {
		this.authorAttachementPath = authorAttachementPath;
	}
	public String getEditorAttachementPath() {
		return editorAttachementPath;
	}
	public void setEditorAttachementPath(String editorAttachementPath) {
		this.editorAttachementPath = editorAttachementPath;
	}
	public String getEditorDKSJ() {
		return editorDKSJ;
	}
	public void setEditorDKSJ(String editorDKSJ) {
		this.editorDKSJ = editorDKSJ;
	}
	public String getExpertDKSJ() {
		return expertDKSJ;
	}
	public void setExpertDKSJ(String expertDKSJ) {
		this.expertDKSJ = expertDKSJ;
	}
	public String getEpxertDKYJ() {
		return epxertDKYJ;
	}
	public void setEpxertDKYJ(String epxertDKYJ) {
		this.epxertDKYJ = epxertDKYJ;
	}
	public String getExpertDownload() {
		return expertDownload;
	}
	public void setExpertDownload(String expertDownload) {
		this.expertDownload = expertDownload;
	}
	public String getEditorDownload() {
		return editorDownload;
	}
	public void setEditorDownload(String editorDownload) {
		this.editorDownload = editorDownload;
	}
	public String getExtend1() {
		return extend1;
	}
	public void setExtend1(String extend1) {
		this.extend1 = extend1;
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

    public String getAuthorAttachementName() {
        return authorAttachementName;
    }

    public void setAuthorAttachementName(String authorAttachementName) {
        this.authorAttachementName = authorAttachementName;
    }

    public String getEditorAttachementName() {
        return editorAttachementName;
    }

    public void setEditorAttachementName(String editorAttachementName) {
        this.editorAttachementName = editorAttachementName;
    }
}
