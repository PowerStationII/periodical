package com.cn.periodical.service;

import java.util.List;

import com.cn.periodical.pojo.AuthorQueryDetail;
import com.cn.periodical.pojo.EditorQueryArtilces;
import com.cn.periodical.pojo.UserInfo;
import com.cn.periodical.request.ArticleQueryReqDto;
import com.cn.periodical.response.ArticleQueryRespDto;

/**
 * 稿件查询
 * */
public interface ArticleQueryService {
	public List<ArticleQueryRespDto> queryArticleInfos(ArticleQueryReqDto reqDto);
	public List<ArticleQueryRespDto> expertQryArticleInfos(ArticleQueryReqDto reqDto);
	
	
	public ArticleQueryRespDto queryArticleInfoDetail(ArticleQueryReqDto reqDto);
	
	public AuthorQueryDetail queryAuthorQueryDetail(String articleId);
	public List<AuthorQueryDetail> queryArticleFee(AuthorQueryDetail authorQueryDetail);
	
	public List<EditorQueryArtilces> editorQueryArticles(EditorQueryArtilces reqDto);
	
}
