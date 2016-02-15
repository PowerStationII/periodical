package com.cn.periodical.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.cn.periodical.enums.RoleIdEnums;
import com.cn.periodical.manager.ArticleAttachmentInfoManager;
import com.cn.periodical.pojo.*;
import com.cn.periodical.utils.Pagenation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cn.periodical.manager.ArticleQueryManager;
import com.cn.periodical.request.ArticleQueryReqDto;
import com.cn.periodical.response.ArticleQueryRespDto;
import com.cn.periodical.service.ArticleQueryService;


@Service
public class ArticleQueryServiceImpl implements ArticleQueryService {

	@Autowired
	ArticleQueryManager articleQueryManager;
    @Autowired
    ArticleAttachmentInfoManager articleAttachmentInfoManager ;
	
	public ArticleQueryServiceImpl() {
		// TODO Auto-generated constructor stub
	}

	public List<ArticleQueryRespDto> queryArticleInfos(ArticleQueryReqDto reqDto) {
		// TODO Auto-generated method stub
		return articleQueryManager.queryArticleInfos(reqDto);
	}
	public ZuoZheGaoJianPage queryArticleInfos(ArticleQueryReqDto query , int itemCount) {
        ZuoZheGaoJianPage bizAdPage = new ZuoZheGaoJianPage();
        query.setItemCount(itemCount);

        if (itemCount == 0) {
            bizAdPage.setValues(null);
        } else {
            bizAdPage.setValues(articleQueryManager.queryArticleInfosPage(query));
        }

        bizAdPage.setPagenation(new Pagenation(query.getPageNo(),query.getPageSize(),query.getItemCount()));
        return bizAdPage;
	}
	public int queryArticleInfosCount(ArticleQueryReqDto query) {
        return articleQueryManager.queryArticleInfosPageCount(query);
	}

	public ArticleQueryRespDto queryArticleInfoDetail(ArticleQueryReqDto reqDto) {
		// TODO Auto-generated method stub
		return articleQueryManager.queryArticleInfoDetail(reqDto);
	}

	public AuthorQueryDetail queryAuthorQueryDetail(String articleId) {
		// TODO Auto-generated method stub
		return articleQueryManager.queryAuthorQueryDetail(articleId);
	}

	public List<AuthorQueryDetail> queryArticleFee(AuthorQueryDetail authorQueryDetail) {
		// TODO Auto-generated method stub
		return articleQueryManager.queryArticleFee(authorQueryDetail);
	}

	public List<EditorQueryArtilces> editorQueryArticles(EditorQueryArtilces reqDto) {
		// TODO Auto-generated method stub
		return articleQueryManager.editorQueryArticles(reqDto);
	}
	public ZuoZheGaoJianPageChaxun editorQueryArticlesPage(EditorQueryArtilces query , int itemCount) {
        ZuoZheGaoJianPageChaxun bizAdPage = new ZuoZheGaoJianPageChaxun();
        query.setItemCount(itemCount);

        if (itemCount == 0) {
            bizAdPage.setValues(null);
        } else {
            bizAdPage.setValues(articleQueryManager.editorQueryArticlesPage(query));
        }

        bizAdPage.setPagenation(new Pagenation(query.getPageNo(),query.getPageSize(),query.getItemCount()));
        return bizAdPage;


	}
	public int editorQueryArticlesPageCount(EditorQueryArtilces reqDto ) {
		// TODO Auto-generated method stub
		return articleQueryManager.editorQueryArticlesPageCount(reqDto);
	}

	public List<ArticleQueryRespDto> expertQryArticleInfos(ArticleQueryReqDto reqDto) {
		// TODO Auto-generated method stub
		return articleQueryManager.expertQryArticleInfos(reqDto);
	}
	public ZuoZheGaoJianPage expertQryArticleInfos(ArticleQueryReqDto query,int itemCount) {
        ZuoZheGaoJianPage bizAdPage = new ZuoZheGaoJianPage();
        query.setItemCount(itemCount);

        if (itemCount == 0) {
            bizAdPage.setValues(null);
        } else {
            bizAdPage.setValues(articleQueryManager.expertQryArticleInfosPage(query));
        }

        bizAdPage.setPagenation(new Pagenation(query.getPageNo(),query.getPageSize(),query.getItemCount()));
        return bizAdPage;

	}
	public int expertQryArticleInfosPageCount(ArticleQueryReqDto query) {
		// TODO Auto-generated method stub
		return articleQueryManager.expertQryArticleInfosPageCount(query);
	}


    /**
     * 查询文章的附件
     * @param article
     * @param set 需要过滤附件的类型
     * @return
     */
    public List<ArticleAttachmentInfo>  queryAttByArtcicle(String article,Set<String> set){
        List<ArticleAttachmentInfo> temp_list = articleAttachmentInfoManager.queryAttByArtcicle(article);
        List<ArticleAttachmentInfo> list = new ArrayList<ArticleAttachmentInfo>();
        for(ArticleAttachmentInfo articleAttachmentInfo : temp_list){
             if(set.contains(articleAttachmentInfo.getType())){
                 if(RoleIdEnums.AUTHOR.getCode().equals(articleAttachmentInfo.getType())){//
                     articleAttachmentInfo.setExtend1(RoleIdEnums.AUTHOR_ATTR.getName());
                 } else if(RoleIdEnums.ARTICLE_EDITOR.getCode().equals(articleAttachmentInfo.getType())){
                     articleAttachmentInfo.setExtend1(RoleIdEnums.ARTICLE_EDITOR_ATTR.getName());
                 } else if(RoleIdEnums.CN_EXPERT_ATTR.getCode().equals(articleAttachmentInfo.getType())){
                     articleAttachmentInfo.setExtend1(RoleIdEnums.CN_EXPERT_ATTR.getName());
                 }
                 list.add(articleAttachmentInfo);
             }
        }
        return list ;
    }

}
