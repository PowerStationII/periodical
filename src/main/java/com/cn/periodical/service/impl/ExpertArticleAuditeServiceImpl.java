package com.cn.periodical.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cn.periodical.manager.ArticleAttachmentInfoManager;
import com.cn.periodical.manager.ArticleInfoManager;
import com.cn.periodical.manager.AuthorInfoManager;
import com.cn.periodical.pojo.ArticleAttachmentInfo;
import com.cn.periodical.pojo.ArticleAttachmentInfoQuery;
import com.cn.periodical.pojo.ArticleInfo;
import com.cn.periodical.pojo.AuthorInfo;
import com.cn.periodical.pojo.AuthorInfoQuery;
import com.cn.periodical.request.ExpertArticleAuditeReqDto;
import com.cn.periodical.response.EditorArticleDealRespDto;
import com.cn.periodical.service.ExpertArticleAuditeService;
@Service
public class ExpertArticleAuditeServiceImpl implements ExpertArticleAuditeService {

	public ExpertArticleAuditeServiceImpl() {
		// TODO Auto-generated constructor stub
	}
	
	@Autowired
	ArticleInfoManager articleInfoManager;
	
	@Autowired
	ArticleAttachmentInfoManager articleAttachmentInfoManager;
	
	@Autowired
	AuthorInfoManager authorInfoManager;

	public List<EditorArticleDealRespDto> qryArticleInfo(ExpertArticleAuditeReqDto reqDto) {
		// TODO Auto-generated method stub
		Map reqMap= new HashMap();
		reqMap.put("userId", reqDto.getUserId());
		if(reqDto.getArticleId()!=null){
			reqMap.put("articleId", reqDto.getArticleId());
		}
		if(reqDto.getTitle()!=null){
			reqMap.put("title", reqDto.getTitle());
		}
		/*if(reqDto.getAuthorName()!=null){
			reqMap.put("authorName", reqDto.getAuthorName());
		}*/
		if(reqDto.getSectionName()!=null){
			reqMap.put("sectionName", reqDto.getSectionName());
		}
		if(reqDto.getSubmitTime()!=null){
			reqMap.put("submitTime", reqDto.getSubmitTime());
		}
		
		List<ArticleInfo> articleInfos = articleInfoManager.queryListByUserId(reqMap);

		Iterator<ArticleInfo> iter = articleInfos.iterator();
		ArticleInfo articleInfo=null;
		List<EditorArticleDealRespDto> list = new ArrayList<EditorArticleDealRespDto>();
		while(iter.hasNext()){
			EditorArticleDealRespDto editorArticleDealRespDto = new EditorArticleDealRespDto();
			
			articleInfo = iter.next();
			editorArticleDealRespDto.setArticleInfo(articleInfo);
			AuthorInfoQuery authorInfoQuery = new AuthorInfoQuery();
			authorInfoQuery.setArticleId(articleInfo.getArticleId());
			List<AuthorInfo> authorInfos = authorInfoManager.queryList(authorInfoQuery);
			editorArticleDealRespDto.setAuthorInfos(authorInfos);
			ArticleAttachmentInfoQuery articleAttachmentInfoQuery =  new ArticleAttachmentInfoQuery();
			articleAttachmentInfoQuery.setArticleId(articleInfo.getArticleId());
			ArticleAttachmentInfo articleAttachmentInfo = articleAttachmentInfoManager.queryList(articleAttachmentInfoQuery).get(0);
			editorArticleDealRespDto.setArticleAttachmentInfo(articleAttachmentInfo);
			list.add(editorArticleDealRespDto);
		}
		return list;
	}
}
