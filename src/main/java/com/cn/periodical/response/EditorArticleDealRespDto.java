package com.cn.periodical.response;

import java.util.List;

import com.cn.periodical.pojo.ArticleAttachmentInfo;
import com.cn.periodical.pojo.ArticleInfo;
import com.cn.periodical.pojo.AuthorInfo;

public class EditorArticleDealRespDto extends ResponseDto {

	public EditorArticleDealRespDto() {
		// TODO Auto-generated constructor stub
	}

	private ArticleInfo articleInfo;
	private List<AuthorInfo> authorInfos;
	private ArticleAttachmentInfo articleAttachmentInfo;
	
	public ArticleInfo getArticleInfo() {
		return articleInfo;
	}
	public void setArticleInfo(ArticleInfo articleInfo) {
		this.articleInfo = articleInfo;
	}
	public List<AuthorInfo> getAuthorInfos() {
		return authorInfos;
	}
	public void setAuthorInfos(List<AuthorInfo> authorInfos) {
		this.authorInfos = authorInfos;
	}
	public ArticleAttachmentInfo getArticleAttachmentInfo() {
		return articleAttachmentInfo;
	}
	public void setArticleAttachmentInfo(ArticleAttachmentInfo articleAttachmentInfo) {
		this.articleAttachmentInfo = articleAttachmentInfo;
	}
}
