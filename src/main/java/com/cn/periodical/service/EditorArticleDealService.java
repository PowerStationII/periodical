package com.cn.periodical.service;

import java.util.List;

import com.cn.periodical.response.EditorArticleDealRespDto;

public interface EditorArticleDealService {
	
	public List<EditorArticleDealRespDto> articleDeal(String status);
}
