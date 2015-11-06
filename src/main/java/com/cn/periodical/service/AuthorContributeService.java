package com.cn.periodical.service;

import com.cn.periodical.request.ContributeRequestDto;

public interface AuthorContributeService {

	public void saveArticle(ContributeRequestDto contributeRequestDto) throws Exception;
}
