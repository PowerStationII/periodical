/*
 * Powered By code-generator
 * Since 2015 - 2015
 */

package com.cn.periodical.dao;

import java.util.List;

import com.cn.periodical.pojo.AuthorQueryDetail;
import com.cn.periodical.pojo.EditorQueryArtilces;
import com.cn.periodical.request.ArticleQueryReqDto;
import com.cn.periodical.response.ArticleQueryRespDto;

public interface ArticleQueryDao {
	public List<ArticleQueryRespDto> queryArticleInfos(ArticleQueryReqDto reqDto);
	public List<ArticleQueryRespDto> expertQryArticleInfos(ArticleQueryReqDto reqDto);
	public ArticleQueryRespDto queryArticleInfoDetail(ArticleQueryReqDto reqDto);
	public AuthorQueryDetail queryAuthorQueryDetail(String articleId);
	public AuthorQueryDetail articleDetailForEnExpert(AuthorQueryDetail articleId);
	public List<AuthorQueryDetail> queryArticleFee(AuthorQueryDetail authorQueryDetail);
	/**
	 * 稿件编辑-稿件查询
	 * */
	public List<EditorQueryArtilces> editorQueryArticles(EditorQueryArtilces reqDto);
	
	
}
