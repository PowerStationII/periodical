package com.cn.periodical.pojo;

import java.io.Serializable;

public class Opinion implements Serializable {

	public Opinion() {
		// TODO Auto-generated constructor stub
	}
	private String articleId;
	private String opinion;
	public String getArticleId() {
		return articleId;
	}
	public void setArticleId(String articleId) {
		this.articleId = articleId;
	}
	public String getOpinion() {
		return opinion;
	}
	public void setOpinion(String opinion) {
		this.opinion = opinion;
	}
	
	

}
