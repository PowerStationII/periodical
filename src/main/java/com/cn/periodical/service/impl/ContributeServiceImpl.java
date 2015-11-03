package com.cn.periodical.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cn.periodical.manager.ArticleAttachmentInfoManager;
import com.cn.periodical.manager.ArticleInfoManager;
import com.cn.periodical.manager.AuthorInfoManager;
import com.cn.periodical.request.ContributeRequestDto;
import com.cn.periodical.service.ContributeService;
@Service
public class ContributeServiceImpl implements ContributeService {
	private static final Logger logger = LoggerFactory.getLogger(ContributeServiceImpl.class);

	@Autowired
	AuthorInfoManager authorInfoManager;
	
	@Autowired
	ArticleInfoManager articleInfoManager;
	
	@Autowired
	ArticleAttachmentInfoManager articleAttachmentInfoManager;
	
	public ContributeServiceImpl() {
		// TODO Auto-generated constructor stub
	}

	public void saveArticle(ContributeRequestDto contributeRequestDto) throws Exception {
		// TODO Auto-generated method stub
		
	}
}
