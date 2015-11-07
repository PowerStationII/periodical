package com.cn.periodical.service.impl;

import java.util.Iterator;
import java.util.List;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.support.TransactionTemplate;

import com.cn.periodical.enums.ArticleStateEnums;
import com.cn.periodical.manager.ArticleAttachmentInfoManager;
import com.cn.periodical.manager.ArticleInfoManager;
import com.cn.periodical.manager.AuthorInfoManager;
import com.cn.periodical.manager.UserInfoManager;
import com.cn.periodical.pojo.ArticleInfo;
import com.cn.periodical.pojo.AuthorInfo;
import com.cn.periodical.request.AuthorContributeReqDto;
import com.cn.periodical.service.AuthorContributeService;
@Service
public class AuthorContributeServiceImpl implements AuthorContributeService {
	private static final Logger logger = LoggerFactory.getLogger(AuthorContributeServiceImpl.class);

	@Autowired
	AuthorInfoManager authorInfoManager;
	
	@Autowired
	UserInfoManager userInfoManager;
	
	@Autowired
	ArticleInfoManager articleInfoManager;
	
	@Autowired
	ArticleAttachmentInfoManager articleAttachmentInfoManager;
	
	@Autowired
	TransactionTemplate transactionTemplate;
	
	public AuthorContributeServiceImpl() {
		// TODO Auto-generated constructor stub
	}

	public void saveArticle(AuthorContributeReqDto contributeRequestDto) throws Exception {
		// TODO Auto-generated method stub
		String articleId= UUID.randomUUID().toString().replaceAll("-", "");
		final ArticleInfo articleInfo =new ArticleInfo();
		articleInfo.setArticleCnKeywords(contributeRequestDto.getArticleCnKeywords());
		articleInfo.setArticleCnSummary(contributeRequestDto.getArticleCnSummary());
		articleInfo.setArticleCnTitle(contributeRequestDto.getArticleCnTitle());
		articleInfo.setArticleEnKeywords(contributeRequestDto.getArticleEnKeywords());
		articleInfo.setArticleEnSummary(contributeRequestDto.getArticleEnSummary());
		articleInfo.setArticleEnTile(contributeRequestDto.getArticleEnTile());
		articleInfo.setArticleId(articleId);
		articleInfo.setArticleName(contributeRequestDto.getArticleName());
		articleInfo.setArticleType(contributeRequestDto.getArticleType().getCode());
		articleInfo.setArtilce(null);
		articleInfo.setClassificationNums(contributeRequestDto.getClassificationNums());
		articleInfo.setDocumentCode(contributeRequestDto.getDocumentCode());
		articleInfo.setExtends1("0");
		articleInfo.setExtends2("");
		articleInfo.setExtends3("");
		articleInfo.setExtends4("");
		articleInfo.setInvestSection(contributeRequestDto.getInvestSection());
		articleInfo.setUserId(contributeRequestDto.getUserId());
		articleInfo.setState(ArticleStateEnums.NEW_ARTICLE.getCode());
		articleInfo.setRemark("");
		articleInfo.setReferenceDoc("");
		articleInfo.setReceiveArticleTime(null);
		articleInfo.setPublishTime(null);
		articleInfo.setIsfund("0");
		
		List<AuthorInfo> authorInfos = contributeRequestDto.getAuthorList();
		Iterator<AuthorInfo> iters = authorInfos.iterator();
		while(iters.hasNext()){
			AuthorInfo authorInfo = iters.next();
			authorInfo.setArticleId(articleId);
			String authorId= UUID.randomUUID().toString().replaceAll("-", "");
			authorInfo.setAuthorId(authorId);
			authorInfoManager.saveAuthorInfo(authorInfo);
		}
		
		articleInfoManager.saveArticleInfo(articleInfo);
	}
}
