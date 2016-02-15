package com.cn.periodical.pojo;

import com.cn.periodical.utils.PagingQuery;

import java.io.Serializable;

public class EditorQueryArtilces extends PagingQuery {

    public EditorQueryArtilces() {
        super(1, 10);
    }

    public  EditorQueryArtilces(int pageNo, int pageSize){
        super(pageNo, pageSize);
    }
	
	private String articleId;
	private String cnTitle;
	private String cnKeywords;
	private String state;
	private String section;
	private String authorNames;
	private String expertNames;
	private String createTime;
	private String expertState;
	
	public String getExpertState() {
		return expertState;
	}
	public void setExpertState(String expertState) {
		this.expertState = expertState;
	}
	public String getArticleId() {
		return articleId;
	}
	public void setArticleId(String articleId) {
		this.articleId = articleId;
	}
	public String getCnTitle() {
		return cnTitle;
	}
	public void setCnTitle(String cnTitle) {
		this.cnTitle = cnTitle;
	}
	public String getCnKeywords() {
		return cnKeywords;
	}
	public void setCnKeywords(String cnKeywords) {
		this.cnKeywords = cnKeywords;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getSection() {
		return section;
	}
	public void setSection(String section) {
		this.section = section;
	}
	public String getAuthorNames() {
		return authorNames;
	}
	public void setAuthorNames(String authorNames) {
		this.authorNames = authorNames;
	}
	public String getExpertNames() {
		return expertNames;
	}
	public void setExpertNames(String expertNames) {
		this.expertNames = expertNames;
	}
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
}
