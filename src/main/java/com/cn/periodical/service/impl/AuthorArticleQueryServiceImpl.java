package com.cn.periodical.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cn.periodical.enums.ArticleStateEnums;
import com.cn.periodical.manager.AccountInfoManager;
import com.cn.periodical.manager.ArticleInfoManager;
import com.cn.periodical.pojo.AccountInfo;
import com.cn.periodical.pojo.AccountInfoQuery;
import com.cn.periodical.pojo.ArticleInfo;
import com.cn.periodical.pojo.ArticleInfoQuery;
import com.cn.periodical.response.AuthorArticleQueryRespDto;
import com.cn.periodical.service.AuthorArticleQueryService;
@Service
public class AuthorArticleQueryServiceImpl implements AuthorArticleQueryService {

	public AuthorArticleQueryServiceImpl() {
		// TODO Auto-generated constructor stub
	}

	@Autowired
	ArticleInfoManager articleInfoManager;
	
	@Autowired
	AccountInfoManager accountInfoManager;
	
	
	public List<AuthorArticleQueryRespDto> queryArticleInfo(String userId) {
		// TODO Auto-generated method stub
		Map<String,String> reqMap = new HashMap<String,String>();
		reqMap.put("userId", userId);
		List<ArticleInfo> ArticleInfoList = articleInfoManager.queryListByUserId(reqMap);
		
		List<AuthorArticleQueryRespDto> list = new ArrayList<AuthorArticleQueryRespDto>();
		Iterator<ArticleInfo> artileInfos = ArticleInfoList.iterator();
		while(artileInfos.hasNext()){
			AuthorArticleQueryRespDto articleQueryRespDto = new AuthorArticleQueryRespDto();
			ArticleInfo articleInfo = artileInfos.next();
			articleQueryRespDto.setArticleId(articleInfo.getArticleId());
			articleQueryRespDto.setId(articleInfo.getId());
			articleQueryRespDto.setArticleCnTitle(articleInfo.getArticleCnTitle());
			articleQueryRespDto.setAuthorState(articleInfo.getAuthorState());
			articleQueryRespDto.setCreateTime(new DateTime(articleInfo.getCreateTime()).toString("yyyy-MM-dd"));
			articleQueryRespDto.setRemark(articleInfo.getRemark());
			list.add(articleQueryRespDto);
		}
		
		return list;
	}
	
	
	public ArticleInfo queryArticleDetailInfo(String articleId) {
		// TODO Auto-generated method stub
		ArticleInfoQuery articleInfoQuery = new ArticleInfoQuery();
		articleInfoQuery.setArticleId(articleId);
		List<ArticleInfo> articleInfoList = articleInfoManager.queryList(articleInfoQuery);
		return articleInfoList.get(0);
	}


	public List<AuthorArticleQueryRespDto> queryArticleFee(String userId) {
		// TODO Auto-generated method stub
		Map<String,String> reqMap = new HashMap<String,String>();
		reqMap.put("userId", userId);
		reqMap.put("authorState", ArticleStateEnums.PUBLISH_ARTICLE.getCode());
		
		List<ArticleInfo> articleInfos = articleInfoManager.queryListByUserId(reqMap);
		Iterator<ArticleInfo> iter = articleInfos.iterator();
		
		List<AuthorArticleQueryRespDto> list = new ArrayList<AuthorArticleQueryRespDto>();
		while(iter.hasNext()){
			AuthorArticleQueryRespDto articleQueryRespDto = new AuthorArticleQueryRespDto();
			ArticleInfo articleInfo = iter.next();
			articleQueryRespDto.setArticleId(articleInfo.getArticleId());
			articleQueryRespDto.setId(articleInfo.getId());
			articleQueryRespDto.setArticleCnTitle(articleInfo.getArticleCnTitle());
			AccountInfoQuery accountInfoQuery = new AccountInfoQuery();
			accountInfoQuery.setArticleId(articleInfo.getArticleId());
			List<AccountInfo> accountInfos = accountInfoManager.queryList(accountInfoQuery);
			articleQueryRespDto.setAccountInfo(accountInfos.get(0));
			list.add(articleQueryRespDto);
		}
		return list;
	}
}
