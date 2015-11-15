package com.cn.periodical.service;

import java.util.List;

import com.cn.periodical.pojo.ArticleInfo;
import com.cn.periodical.response.AuthorArticleQueryRespDto;

public interface AuthorArticleQueryService {
	public List<AuthorArticleQueryRespDto> queryArticleInfo(String userId);
	public ArticleInfo queryArticleDetailInfo(String articleId) ;
	public List<AuthorArticleQueryRespDto> queryArticleFee(String userId);
	
}
