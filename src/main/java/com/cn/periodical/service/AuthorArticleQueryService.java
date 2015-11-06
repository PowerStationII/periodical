package com.cn.periodical.service;

import java.util.List;

import com.cn.periodical.response.ArticleQueryRespDto;

public interface AuthorArticleQueryService {
	public List<ArticleQueryRespDto> queryArticleInfo(String userId);
}
