package com.cn.periodical.service;

import java.util.List;

import com.cn.periodical.pojo.AddressInfo;
import com.cn.periodical.pojo.ArticleInfo;
import com.cn.periodical.pojo.PeriodicalDistribut;
import com.cn.periodical.request.EditorArticleDealReqDto;
import com.cn.periodical.response.EditorArticleDealRespDto;

public interface EditorArticleDealService {
	
	public List<EditorArticleDealRespDto> articleDeal(String status);
	public ArticleInfo qryArticleInfo(String articleId);
	public int updateArticleInfo(String expertUserId,String userId,ArticleInfo articleInfo,String artilceState);
	public int registeOperationFlows(EditorArticleDealReqDto obj);

    public void toUploadAddressPage( String orderNo , String periodicalId, List<AddressInfo> list);

    public void toUploadAddressPageOne(AddressInfo addressInfo, String orderNo , String periodicalId);
}
