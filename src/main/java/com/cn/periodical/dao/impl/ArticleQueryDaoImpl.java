package com.cn.periodical.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.cn.periodical.dao.ArticleQueryDao;
import com.cn.periodical.dao.BaseDao;
import com.cn.periodical.pojo.AuthorQueryDetail;
import com.cn.periodical.pojo.EditorQueryArtilces;
import com.cn.periodical.request.ArticleQueryReqDto;
import com.cn.periodical.response.ArticleQueryRespDto;

@Repository("articleQueryDao")
public class ArticleQueryDaoImpl extends BaseDao implements ArticleQueryDao {

	public ArticleQueryDaoImpl() {
		// TODO Auto-generated constructor stub
	}

	public List<ArticleQueryRespDto> queryArticleInfos(ArticleQueryReqDto reqDto) {
		// TODO Auto-generated method stub
		return super.getSqlSession().selectList("ArticleQueryMapper.selectArticleInfosForEditor", reqDto);
	}
	public List<ArticleQueryRespDto> queryArticleInfosPage(ArticleQueryReqDto reqDto) {
		// TODO Auto-generated method stub
		return super.getSqlSession().selectList("ArticleQueryMapper.selectArticleInfosForEditorPage", reqDto);
	}
	public int queryArticleInfosPageCount(ArticleQueryReqDto reqDto) {
        int count = 0 ;
        try{
            count = super.getSqlSession().selectList("ArticleQueryMapper.selectArticleInfosForEditorPageCount", reqDto).size();
        }catch (Exception e){
             e.printStackTrace();
        }
		return count ;
	}

	public ArticleQueryRespDto queryArticleInfoDetail(ArticleQueryReqDto reqDto) {
		// TODO Auto-generated method stub
		return super.getSqlSession().selectOne("ArticleQueryMapper.selectArticleInfoDetail", reqDto);
	}

	public AuthorQueryDetail queryAuthorQueryDetail(String articleId) {
		// TODO Auto-generated method stub
		return super.getSqlSession().selectOne("ArticleQueryMapper.authorQueryDetail", articleId);
	}

	public List<AuthorQueryDetail> queryArticleFee(AuthorQueryDetail authorQueryDetail) {
		// TODO Auto-generated method stub
		return super.getSqlSession().selectList("ArticleQueryMapper.articleFeeQuery", authorQueryDetail);
	}

	public List<EditorQueryArtilces> editorQueryArticles(EditorQueryArtilces reqDto) {
		// TODO Auto-generated method stub
		return super.getSqlSession().selectList("ArticleQueryMapper.editorQueryArticles", reqDto);
	}

	public List<ArticleQueryRespDto> expertQryArticleInfos(ArticleQueryReqDto reqDto) {
		// TODO Auto-generated method stub
		return super.getSqlSession().selectList("ArticleQueryMapper.selectArticleInfosForExpert", reqDto);
	}

	public AuthorQueryDetail articleDetailForEnExpert(AuthorQueryDetail articleId) {
		// TODO Auto-generated method stub
		return super.getSqlSession().selectOne("ArticleQueryMapper.articleDetailForEnExpert", articleId);
	}

	public List<ArticleQueryRespDto> editorDKMXPage(ArticleQueryReqDto articleQueryReqDto) {
		// TODO Auto-generated method stub
		return super.getSqlSession().selectList("ArticleQueryMapper.EditorDKMXPage", articleQueryReqDto);
	}

}
