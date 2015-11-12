package com.cn.periodical.service;

import java.util.List;

import com.cn.periodical.response.EditorArticleDealRespDto;

public interface ExpertArticleAuditeService {
	public List<EditorArticleDealRespDto> qryArticleInfo(String userId);
}
