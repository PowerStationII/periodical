package com.cn.periodical.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;

import com.cn.periodical.request.AuthorContributeReqDto;

public interface AuthorContributeService {

	public void saveArticle(AuthorContributeReqDto contributeRequestDto,MultipartFile[] files,HttpServletRequest request) throws Exception;

    public void saveAtricalAtt(String articleId , String attName , String attPath , String type) throws Exception;

    public void saveChongTouArticle(final AuthorContributeReqDto contributeRequestDto,MultipartFile[] files,HttpServletRequest request) throws Exception ;

}
