/*
 * Powered By code-generator
 * Since 2015 - 2015
 */

package com.cn.periodical.manager;

import java.util.List;

import com.cn.periodical.pojo.AdInfo;
import com.cn.periodical.pojo.AdInfoPage;
import com.cn.periodical.pojo.AdInfoQuery;
import com.cn.periodical.pojo.AuthorQueryDetail;
import com.cn.periodical.pojo.EditorQueryArtilces;
import com.cn.periodical.request.ArticleQueryReqDto;
import com.cn.periodical.response.ArticleQueryRespDto;

public interface ArticleQueryManager {
	public List<ArticleQueryRespDto> queryArticleInfos(ArticleQueryReqDto reqDto);
	public List<ArticleQueryRespDto> queryArticleInfosPage(ArticleQueryReqDto reqDto);
	public int queryArticleInfosPageCount(ArticleQueryReqDto reqDto);
	public List<ArticleQueryRespDto> expertQryArticleInfos(ArticleQueryReqDto reqDto);
	public List<ArticleQueryRespDto> expertQryArticleInfosPage(ArticleQueryReqDto reqDto);
	public int expertQryArticleInfosPageCount(ArticleQueryReqDto reqDto);
	public ArticleQueryRespDto queryArticleInfoDetail(ArticleQueryReqDto reqDto);
	public AuthorQueryDetail queryAuthorQueryDetail(String articleId);
	public List<AuthorQueryDetail> queryArticleFee(AuthorQueryDetail authorQueryDetail);
	public List<EditorQueryArtilces> editorQueryArticles(EditorQueryArtilces reqDto);
	public List<EditorQueryArtilces> editorQueryArticlesPage(EditorQueryArtilces reqDto);
	public int editorQueryArticlesPageCount(EditorQueryArtilces reqDto);
	public AuthorQueryDetail articleDetailForEnExpert(AuthorQueryDetail articleId);
	
	/**
	 * 编辑人员,待刊明细页查询
	 * */
	public List<ArticleQueryRespDto> editorDKMXPage(ArticleQueryReqDto articleQueryReqDto);
}
