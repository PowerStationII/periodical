package com.cn.periodical.service.impl;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.cn.periodical.manager.ArticleFlowsManager;
import com.cn.periodical.manager.ArticleInfoManager;
import com.cn.periodical.pojo.ArticleFlows;
import com.cn.periodical.pojo.ArticleInfo;
import com.cn.periodical.pojo.ArticleInfoQuery;
import com.cn.periodical.request.AritcleWorkFlowReqDto;
import com.cn.periodical.service.ArticleWorkFlowService;

@Service
public class ArticleWorkFlowServiceImpl implements ArticleWorkFlowService {
	private static final Logger logger = LoggerFactory.getLogger(ArticleWorkFlowServiceImpl.class);

	public ArticleWorkFlowServiceImpl() {
		// TODO Auto-generated constructor stub
	}
	@Autowired
	ArticleFlowsManager articleFlowsManager;
	
	@Autowired
	ArticleInfoManager articleInfoManager;
	
	
	
	public int registArticleWorkFlow(AritcleWorkFlowReqDto reqDto) {
		// TODO Auto-generated method stub
		ArticleFlows articleFlows = new ArticleFlows();
		
		long maxId = articleFlowsManager.selectMaxId(reqDto.getArticleId());
		logger.info("+++++++++++++++++++");
		logger.info(JSON.toJSONString(maxId));
		logger.info("+++++++++++++++++++");
		if(maxId==1L){
			articleFlows.setId(1L);
			articleFlows.setPid(0L);
			articleFlows.setUserId(reqDto.getUserId());
			articleFlows.setCreateTime(new Date());
			articleFlows.setRoleId(reqDto.getRoleId());
			articleFlows.setDealState(reqDto.getDealState());
			articleFlows.setArticleId(reqDto.getArticleId());
			articleFlows.setDealStartTime(reqDto.getDealStartTime());
			articleFlows.setDealEndTime(reqDto.getDealEndTime());
			articleFlowsManager.saveArticleFlows(articleFlows);
		}else{
			articleFlows.setId(maxId+1);
			articleFlows.setPid(maxId);
			articleFlows.setUserId(reqDto.getUserId());
			articleFlows.setCreateTime(new Date());
			articleFlows.setRoleId(reqDto.getRoleId());
			articleFlows.setDealState(reqDto.getDealState());
			articleFlows.setArticleId(reqDto.getArticleId());
			articleFlows.setDealStartTime(reqDto.getDealStartTime());
			articleFlows.setDealEndTime(reqDto.getDealEndTime());
			articleFlowsManager.saveArticleFlows(articleFlows);
			
			ArticleInfoQuery articleInfoQuery=new ArticleInfoQuery();
			articleInfoQuery.setArticleId(reqDto.getArticleId());
			List<ArticleInfo> articleInfos = articleInfoManager.queryList(articleInfoQuery);
			ArticleInfo articleInfo = articleInfos.get(0);
			articleInfo.setId(articleInfo.getId());
			articleInfo.setLatelyFlowsId(maxId+1);
			articleInfoManager.saveArticleInfo(articleInfo);
		}
		
		return 0;
	}

}
