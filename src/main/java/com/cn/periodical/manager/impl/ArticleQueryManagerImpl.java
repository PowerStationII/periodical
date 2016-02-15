package com.cn.periodical.manager.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.cn.periodical.dao.ArticleQueryDao;
import com.cn.periodical.manager.ArticleQueryManager;
import com.cn.periodical.pojo.AuthorQueryDetail;
import com.cn.periodical.pojo.EditorQueryArtilces;
import com.cn.periodical.request.ArticleQueryReqDto;
import com.cn.periodical.response.ArticleQueryRespDto;
@Component("articleQueryManager")
public class ArticleQueryManagerImpl implements ArticleQueryManager {

	@Autowired
	@Qualifier("articleQueryDao")
	private ArticleQueryDao articleQueryDao;
	
	public ArticleQueryManagerImpl() {
		// TODO Auto-generated constructor stub
	}

	public List<ArticleQueryRespDto> queryArticleInfos(ArticleQueryReqDto reqDto) {
		// TODO Auto-generated method stub
		return articleQueryDao.queryArticleInfos(reqDto);
	}
	public List<ArticleQueryRespDto> queryArticleInfosPage(ArticleQueryReqDto reqDto) {
		// TODO Auto-generated method stub
		return articleQueryDao.queryArticleInfosPage(reqDto);
	}
	public int queryArticleInfosPageCount(ArticleQueryReqDto reqDto) {
		// TODO Auto-generated method stub
		return articleQueryDao.queryArticleInfosPageCount(reqDto);
	}

	public ArticleQueryRespDto queryArticleInfoDetail(ArticleQueryReqDto reqDto) {
		// TODO Auto-generated method stub
		return articleQueryDao.queryArticleInfoDetail(reqDto);
	}

	public AuthorQueryDetail queryAuthorQueryDetail(String articleId) {
		// TODO Auto-generated method stub
		return articleQueryDao.queryAuthorQueryDetail(articleId);
	}

	public List<AuthorQueryDetail> queryArticleFee(AuthorQueryDetail authorQueryDetail) {
		// TODO Auto-generated method stub
		return articleQueryDao.queryArticleFee(authorQueryDetail);
	}

	public List<EditorQueryArtilces> editorQueryArticles(EditorQueryArtilces reqDto) {
		// TODO Auto-generated method stub
		return articleQueryDao.editorQueryArticles(reqDto);
	}
	public List<EditorQueryArtilces> editorQueryArticlesPage(EditorQueryArtilces reqDto) {
		// TODO Auto-generated method stub
		return articleQueryDao.editorQueryArticlesPage(reqDto);
	}
	public int editorQueryArticlesPageCount(EditorQueryArtilces reqDto) {
		// TODO Auto-generated method stub
		return articleQueryDao.editorQueryArticlesPageCount(reqDto);
	}

	public List<ArticleQueryRespDto> expertQryArticleInfos(ArticleQueryReqDto reqDto) {
		// TODO Auto-generated method stub
		return articleQueryDao.expertQryArticleInfos(reqDto);
	}
	public List<ArticleQueryRespDto> expertQryArticleInfosPage(ArticleQueryReqDto reqDto) {
		// TODO Auto-generated method stub
		return articleQueryDao.expertQryArticleInfosPage(reqDto);
	}
	public int expertQryArticleInfosPageCount(ArticleQueryReqDto reqDto) {
		// TODO Auto-generated method stub
		return articleQueryDao.expertQryArticleInfosPageCount(reqDto);
	}

	public AuthorQueryDetail articleDetailForEnExpert(AuthorQueryDetail articleId) {
		// TODO Auto-generated method stub
		return articleQueryDao.articleDetailForEnExpert(articleId);
	}

	public List<ArticleQueryRespDto> editorDKMXPage(ArticleQueryReqDto articleQueryReqDto) {
		// TODO Auto-generated method stub
		return articleQueryDao.editorDKMXPage(articleQueryReqDto);
	}

}
