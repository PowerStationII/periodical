package com.cn.periodical.service;

import java.util.List;

import com.cn.periodical.pojo.ArticleInfo;
import com.cn.periodical.request.EditorArticleDealReqDto;
import com.cn.periodical.response.EditorArticleDealRespDto;

public interface EditorArticleDealService {
	
	public List<EditorArticleDealRespDto> articleDeal(String status);
	public ArticleInfo qryArticleInfo(String articleId);
	public int updateArticleInfo(String userId,String articleId,String artilceState);
	public int registeOperationFlows(EditorArticleDealReqDto obj);
	
	
}
