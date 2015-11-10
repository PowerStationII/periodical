package com.cn.periodical.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cn.periodical.manager.ArticleAttachmentInfoManager;
import com.cn.periodical.manager.ArticleFlowsExtendManager;
import com.cn.periodical.manager.ArticleFlowsManager;
import com.cn.periodical.manager.ArticleInfoExtendManager;
import com.cn.periodical.manager.ArticleInfoManager;
import com.cn.periodical.manager.AuthorInfoManager;
import com.cn.periodical.pojo.ArticleFlows;
import com.cn.periodical.pojo.ArticleFlowsExtend;
import com.cn.periodical.pojo.ArticleFlowsExtendQuery;
import com.cn.periodical.pojo.ArticleInfo;
import com.cn.periodical.pojo.ArticleInfoQuery;
import com.cn.periodical.pojo.AuthorInfo;
import com.cn.periodical.pojo.AuthorInfoQuery;
import com.cn.periodical.request.EditorArticleDealReqDto;
import com.cn.periodical.response.EditorArticleDealRespDto;
import com.cn.periodical.service.EditorArticleDealService;


@Service
public class EditorArticleDealServiceImpl implements EditorArticleDealService {

	@Autowired
	AuthorInfoManager authorInfoManager;
	
	@Autowired
	ArticleInfoManager articleInfoManager;
	
	@Autowired
	ArticleAttachmentInfoManager articleAttachmentInfoManager;
	
	@Autowired
	ArticleFlowsManager articleFlowsManager;
	
	@Autowired
	ArticleFlowsExtendManager articleFlowsExtendManager;
	
	@Autowired
	ArticleInfoExtendManager articleInfoExtendManager;
	
	
	
	public EditorArticleDealServiceImpl() {
		// TODO Auto-generated constructor stub
	}

	public List<EditorArticleDealRespDto> articleDeal(String status) {
		// TODO Auto-generated method stub
		List<EditorArticleDealRespDto> list = new ArrayList<EditorArticleDealRespDto>();
		
		ArticleInfoQuery articleInfoQuery = new ArticleInfoQuery();
		articleInfoQuery.setState(status);
		List<ArticleInfo> articleInfos = articleInfoManager.queryList(articleInfoQuery);
		Iterator<ArticleInfo> iters = articleInfos.iterator();
		while(iters.hasNext()){
			EditorArticleDealRespDto editorArticleDealRespDto = new EditorArticleDealRespDto();
			ArticleInfo articleInfo = iters.next();
			AuthorInfoQuery authorInfoQuery = new AuthorInfoQuery();
			authorInfoQuery.setArticleId(articleInfo.getArticleId());
			List<AuthorInfo> authorInfos = authorInfoManager.queryList(authorInfoQuery);
			editorArticleDealRespDto.setArticleInfo(articleInfo);
			editorArticleDealRespDto.setAuthorInfos(authorInfos);
//			editorArticleDealRespDto.setArticleAttachmentInfo(articleAttachmentInfo);
			list.add(editorArticleDealRespDto);
		}
		return list;
	}

	public ArticleInfo qryArticleInfo(String articleId) {
		// TODO Auto-generated method stub
		ArticleInfoQuery articleInfoQuery = new ArticleInfoQuery();
		articleInfoQuery.setArticleId(articleId);
		List<ArticleInfo> articleInfos = articleInfoManager.queryList(articleInfoQuery);
		return articleInfos.get(0);
	}

	public int updateArticleInfo(String articleId,String articleState) {
		// TODO Auto-generated method stub
		ArticleInfoQuery articleInfoQuery = new ArticleInfoQuery();
		articleInfoQuery.setArticleId(articleId);
		List<ArticleInfo> articleInfos = articleInfoManager.queryList(articleInfoQuery);
		ArticleInfo articleInfo = articleInfos.get(0);
		articleInfo.setId(articleInfo.getId());
		articleInfo.setState(articleState);
		
		articleInfoManager.saveArticleInfo(articleInfo);
		return 0;
	}

	/**
	 * 稿件处理流程流水
	 * */
	public int registeOperationFlows(EditorArticleDealReqDto obj) {
		/**
		 * 1,article_info_extend role_id和userId是唯一索引,使用articleId关联articleInfo
		 *  此表来控制articleInfo数据的访问权限.
		 *  主编默认可以访问所有articleInfo数据.
		 * 2,article_flows_extend 存储articleId一条最新的article_flows的id 
		 * 	articleId是唯一,article_flows每变动一次更新此表的lately_flows_id一次.
		 *  以最新的lately_flows_id做为article_flows表的pid
		 * 3,article_flows表的id与pid是父子关系
		 * */
		
		
		
		ArticleFlowsExtendQuery articleFlowsExtendQuery =  new ArticleFlowsExtendQuery();
		articleFlowsExtendQuery.setArticleId(obj.getArticleId());
		List<ArticleFlowsExtend> articleFlowsExtends = articleFlowsExtendManager.queryList(articleFlowsExtendQuery);
		ArticleFlowsExtend articleFlowsExtend= articleFlowsExtends.get(0);
		
		ArticleFlows articleFlows = new ArticleFlows();
		
		articleFlows.setPid(articleFlowsExtend.getLatelyFlowsId());
		articleFlows.setArticleId(obj.getArticleId());
		articleFlows.setDealState(obj.getDealState());
		articleFlows.setDealOpinion(obj.getDealOpinion());
		articleFlows.setUserId(obj.getUserId());
		articleFlows.setRoleId(obj.getRoleId());
		articleFlows.setRefId("");
		
		
		
		
		
		return 0;
	}

}
