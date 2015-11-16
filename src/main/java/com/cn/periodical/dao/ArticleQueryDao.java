/*
 * Powered By code-generator
 * Since 2015 - 2015
 */

package com.cn.periodical.dao;

import java.util.List;

import com.cn.periodical.request.ArticleQueryReqDto;
import com.cn.periodical.response.ArticleQueryRespDto;

public interface ArticleQueryDao {
	public List<ArticleQueryRespDto> queryArticleInfos(ArticleQueryReqDto reqDto);
	public ArticleQueryRespDto queryArticleInfoDetail(ArticleQueryReqDto reqDto);
}
