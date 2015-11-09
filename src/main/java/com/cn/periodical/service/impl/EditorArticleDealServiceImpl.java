package com.cn.periodical.service.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cn.periodical.manager.ArticleAttachmentInfoManager;
import com.cn.periodical.manager.ArticleInfoManager;
import com.cn.periodical.manager.AuthorInfoManager;
import com.cn.periodical.pojo.ArticleInfo;
import com.cn.periodical.pojo.ArticleInfoQuery;
import com.cn.periodical.pojo.AuthorInfo;
import com.cn.periodical.pojo.AuthorInfoQuery;
import com.cn.periodical.response.EditorArticleDealRespDto;
import com.cn.periodical.service.EditorArticleDealService;


@Service
public class EditorArticleDealServiceImpl implements EditorArticleDealService {

	@Autowired
	AuthorInfoManager authorInfoManager;
	
	@Autowired
	ArticleInfoManager articleInfoManager;
	
	@Autowired
	ArticleAttachmentInfoManager articleAttachmentInfoManager;
	
	
	
	public EditorArticleDealServiceImpl() {
		// TODO Auto-generated constructor stub
	}

	public List<EditorArticleDealRespDto> articleDeal(String status) {
		// TODO Auto-generated method stub
		List<EditorArticleDealRespDto> list = new ArrayList<EditorArticleDealRespDto>();
		
		ArticleInfoQuery articleInfoQuery = new ArticleInfoQuery();
		articleInfoQuery.setState(status);
		List<ArticleInfo> articleInfos = articleInfoManager.queryList(articleInfoQuery);
		Iterator<ArticleInfo> iters = articleInfos.iterator();
		while(iters.hasNext()){
			EditorArticleDealRespDto editorArticleDealRespDto = new EditorArticleDealRespDto();
			ArticleInfo articleInfo = iters.next();
			AuthorInfoQuery authorInfoQuery = new AuthorInfoQuery();
			authorInfoQuery.setArticleId(articleInfo.getArticleId());
			List<AuthorInfo> authorInfos = authorInfoManager.queryList(authorInfoQuery);
			editorArticleDealRespDto.setArticleInfo(articleInfo);
			editorArticleDealRespDto.setAuthorInfos(authorInfos);
//			editorArticleDealRespDto.setArticleAttachmentInfo(articleAttachmentInfo);
			list.add(editorArticleDealRespDto);
		}
		return list;
	}

	public ArticleInfo qryArticleInfo(String articleId) {
		// TODO Auto-generated method stub
		ArticleInfoQuery articleInfoQuery = new ArticleInfoQuery();
		articleInfoQuery.setArticleId(articleId);
		List<ArticleInfo> articleInfos = articleInfoManager.queryList(articleInfoQuery);
		return articleInfos.get(0);
	}

	public int updateArticleInfo(String articleId,String articleState) {
		// TODO Auto-generated method stub
		ArticleInfoQuery articleInfoQuery = new ArticleInfoQuery();
		articleInfoQuery.setArticleId(articleId);
		List<ArticleInfo> articleInfos = articleInfoManager.queryList(articleInfoQuery);
		ArticleInfo articleInfo = articleInfos.get(0);
		articleInfo.setId(articleInfo.getId());
		articleInfo.setState(articleState);
		
		articleInfoManager.saveArticleInfo(articleInfo);
		return 0;
	}

	/**
	 * 登记稿件处理流水
	 * */
	public int registeOperationFlows(Object obj) {
		// TODO Auto-generated method stub
		/**
		 * article_info_extend 记录最新的article_flow id
		 * article_flow 记录操作人对稿件所做的动作及建议并记录上次谁做了什么操作
		 * */
		
		return 0;
	}

}
