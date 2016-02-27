package com.cn.periodical.pojo;

import java.io.Serializable;

public class Opinion implements Serializable {

	public Opinion() {
		// TODO Auto-generated constructor stub
	}
	private String articleId;
	private String opinion;
	private String status;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
