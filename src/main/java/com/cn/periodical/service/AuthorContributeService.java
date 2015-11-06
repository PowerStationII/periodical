package com.cn.periodical.service;

import com.cn.periodical.request.AuthorContributeReqDto;

public interface AuthorContributeService {

	public void saveArticle(AuthorContributeReqDto contributeRequestDto) throws Exception;
}
