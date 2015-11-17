package com.cn.periodical.manager.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.cn.periodical.dao.ArticleQueryDao;
import com.cn.periodical.manager.ArticleQueryManager;
import com.cn.periodical.pojo.AuthorQueryDetail;
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

}
