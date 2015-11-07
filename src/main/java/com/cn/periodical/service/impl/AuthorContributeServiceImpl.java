package com.cn.periodical.service.impl;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.support.TransactionTemplate;

import com.cn.periodical.enums.ArticleStateEnums;
import com.cn.periodical.manager.AddressInfoManager;
import com.cn.periodical.manager.ArticleAttachmentInfoManager;
import com.cn.periodical.manager.ArticleInfoManager;
import com.cn.periodical.manager.AuthorInfoManager;
import com.cn.periodical.manager.UserInfoManager;
import com.cn.periodical.pojo.AddressInfo;
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
	AddressInfoManager addressInfoManager;
	
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
		articleInfo.setTotalPages(contributeRequestDto.getTotalPages());
		articleInfo.setTotalPics(contributeRequestDto.getTotalPics());
		articleInfo.setTotalTabs(contributeRequestDto.getTotalTabs());
		articleInfo.setFundTitle(contributeRequestDto.getFundTitle());
		articleInfo.setExtends1("0");
		articleInfo.setExtends2("");
		articleInfo.setExtends3("");
		articleInfo.setExtends4("");
		articleInfo.setInvestSection(contributeRequestDto.getInvestSection());
		articleInfo.setUserId(contributeRequestDto.getUserId());
		articleInfo.setState(ArticleStateEnums.NEW_ARTICLE.getCode());
		articleInfo.setRemark(contributeRequestDto.getRemark());
		articleInfo.setReferenceDoc(contributeRequestDto.getReferenceDoc());
		articleInfo.setReceiveArticleTime(new Date());
		articleInfo.setPublishTime(null);
		articleInfo.setIsfund(contributeRequestDto.getIsfund());
		
		List<AuthorInfo> authorInfos = contributeRequestDto.getAuthorList();
		List<AddressInfo> addressInfos = contributeRequestDto.getAddressInfos();
		for(int i=0;i<authorInfos.size()-1;i++){
			AuthorInfo authorInfo = authorInfos.get(i);
			AddressInfo addressInfo = addressInfos.get(i);
			String authorId= UUID.randomUUID().toString().replaceAll("-", "");
			String addressId= UUID.randomUUID().toString().replaceAll("-", "");
			
			authorInfo.setArticleId(articleId);
			authorInfo.setAuthorId(authorId);
			addressInfo.setRefId(authorId);
			addressInfo.setAddressId(addressId);
			authorInfoManager.saveAuthorInfo(authorInfo);
			addressInfoManager.saveAddressInfo(addressInfo);
		}
		articleInfoManager.saveArticleInfo(articleInfo);
	}
}
