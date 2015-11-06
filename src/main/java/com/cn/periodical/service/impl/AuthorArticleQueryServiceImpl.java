package com.cn.periodical.service.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cn.periodical.manager.ArticleInfoManager;
import com.cn.periodical.pojo.ArticleInfo;
import com.cn.periodical.pojo.ArticleInfoQuery;
import com.cn.periodical.response.ArticleQueryRespDto;
import com.cn.periodical.service.AuthorArticleQueryService;
@Service
public class AuthorArticleQueryServiceImpl implements AuthorArticleQueryService {

	public AuthorArticleQueryServiceImpl() {
		// TODO Auto-generated constructor stub
	}

	@Autowired
	ArticleInfoManager articleInfoManager;
	
	
	public List<ArticleQueryRespDto> queryArticleInfo(String userId) {
		// TODO Auto-generated method stub
		ArticleInfoQuery articleInfoQuery = new ArticleInfoQuery();
		articleInfoQuery.setUserId(userId);
		List<ArticleInfo> ArticleInfoList = articleInfoManager.queryList(articleInfoQuery);
		List<ArticleQueryRespDto> list = new ArrayList<ArticleQueryRespDto>();
		Iterator<ArticleInfo> artileInfos = ArticleInfoList.iterator();
		while(artileInfos.hasNext()){
			ArticleQueryRespDto articleQueryRespDto = new ArticleQueryRespDto();
			ArticleInfo articleInfo = artileInfos.next();
			articleQueryRespDto.setArticleId(articleInfo.getArticleId());
			articleQueryRespDto.setId(articleInfo.getId());
			articleQueryRespDto.setArticleCnTitle(articleInfo.getArticleCnTitle());
			list.add(articleQueryRespDto);
		}
		
		return list;
	}

}
