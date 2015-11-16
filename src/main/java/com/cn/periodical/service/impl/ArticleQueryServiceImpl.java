package com.cn.periodical.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cn.periodical.manager.ArticleQueryManager;
import com.cn.periodical.pojo.UserInfo;
import com.cn.periodical.request.ArticleQueryReqDto;
import com.cn.periodical.response.ArticleQueryRespDto;
import com.cn.periodical.service.ArticleQueryService;


@Service
public class ArticleQueryServiceImpl implements ArticleQueryService {

	@Autowired
	ArticleQueryManager articleQueryManager;
	
	public ArticleQueryServiceImpl() {
		// TODO Auto-generated constructor stub
	}

	public List<ArticleQueryRespDto> queryArticleInfos(ArticleQueryReqDto reqDto) {
		// TODO Auto-generated method stub
		return articleQueryManager.queryArticleInfos(reqDto);
	}

	public ArticleQueryRespDto queryArticleInfoDetail(ArticleQueryReqDto reqDto) {
		// TODO Auto-generated method stub
		return articleQueryManager.queryArticleInfoDetail(reqDto);
	}

}
