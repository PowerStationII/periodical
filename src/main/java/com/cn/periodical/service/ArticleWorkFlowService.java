package com.cn.periodical.service;

import com.cn.periodical.pojo.ArticleFlows;
import com.cn.periodical.pojo.ArticleInfo;
import com.cn.periodical.request.AritcleWorkFlowReqDto;

public interface ArticleWorkFlowService {

	public int registArticleWorkFlow(AritcleWorkFlowReqDto reqDto);
	
//	public int updateArticleState(ArticleInfo articleInfo,ArticleFlows articleFlows);
}
