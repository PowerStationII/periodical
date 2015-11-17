package com.cn.periodical.service.impl;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.cn.periodical.manager.ArticleFlowsManager;
import com.cn.periodical.manager.ArticleInfoExtendManager;
import com.cn.periodical.manager.ArticleInfoManager;
import com.cn.periodical.pojo.ArticleFlows;
import com.cn.periodical.pojo.ArticleInfo;
import com.cn.periodical.pojo.ArticleInfoExtend;
import com.cn.periodical.pojo.ArticleInfoExtendQuery;
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
	
	@Autowired
	ArticleInfoExtendManager  articleInfoExtendManager;
	
	
	
	public int registArticleWorkFlow(AritcleWorkFlowReqDto reqDto) {
		// TODO Auto-generated method stub
		ArticleFlows articleFlows = new ArticleFlows();
		
		long maxId = articleFlowsManager.selectMaxId(reqDto.getArticleId());
		logger.info("+++++++++++++++++++");
		logger.info(JSON.toJSONString(maxId));
		logger.info("+++++++++++++++++++");
		articleFlows.setId(maxId+1);
		articleFlows.setPid(maxId);
		articleFlows.setUserId(reqDto.getUserId());
		articleFlows.setCreateTime(new Date());
		articleFlows.setRefId(reqDto.getRefId());
		articleFlows.setRoleId(reqDto.getRoleId());/**当前流水是谁产生的*/
		articleFlows.setDealState(reqDto.getDealState());
		articleFlows.setArticleId(reqDto.getArticleId());
		articleFlows.setDealStartTime(reqDto.getDealStartTime());
		articleFlows.setDealEndTime(reqDto.getDealEndTime());
		articleFlows.setDealOpinion(reqDto.getDealOpinion());
		articleFlows.setExtend2("N");/**为了审批意见是否作者可见而改*/
		/**专家操作三个按钮时,需要将流水的userId和refId互换,所以设立此字段,记录专家的userId,更新流水时作为其中一个唯一条件*/
		articleFlows.setExtend1(reqDto.getExtend());
		articleFlowsManager.saveArticleFlows(articleFlows);
		
		ArticleInfoQuery articleInfoQuery=new ArticleInfoQuery();
		articleInfoQuery.setArticleId(reqDto.getArticleId());
		List<ArticleInfo> articleInfos = articleInfoManager.queryList(articleInfoQuery);
		ArticleInfo articleInfo = articleInfos.get(0);
		articleInfo.setId(articleInfo.getId());
		articleInfo.setLatelyFlowsId(maxId+1);
		
		articleInfoManager.saveArticleInfo(articleInfo);
		
		/**
		 * 谁 能看 稿件
		 * 通常是三个人 作者 编辑 专家
		 * 只需要稿件正向流水即可完成记录
		 * */
		ArticleInfoExtendQuery query = new ArticleInfoExtendQuery();
		query.setArticleId(reqDto.getArticleId());
		query.setRoleId(reqDto.getToRoleId());
		query.setUserId(reqDto.getUserId());
		List<ArticleInfoExtend> articleInfoExtends =articleInfoExtendManager.queryList(query);
		if(articleInfoExtends!=null && articleInfoExtends.size()==0){
			ArticleInfoExtend articleInfoExtend = new ArticleInfoExtend();
			articleInfoExtend.setArticleId(reqDto.getArticleId());
			articleInfoExtend.setUserId(reqDto.getUserId());
			articleInfoExtend.setRoleId(reqDto.getToRoleId());
			articleInfoExtendManager.saveArticleInfoExtend(articleInfoExtend);
		}
		return 0;
	}



//	public int updateArticleState(ArticleInfo articleInfo, ArticleFlows articleFlows) {
//		// TODO Auto-generated method stub
//		
//		if(RoleIdEnums.ARTICLE_EDITOR.getCode().equals(articleFlows.getRoleId())){
//			articleInfo.setAuthorState(reqDto.getDealState());
//			articleInfo.setEditorState(reqDto.getDealState());
//		}else if(RoleIdEnums.CN_EXPERT.getCode().equals(articleFlows.getRoleId())){
//			
//		}else if(RoleIdEnums.EN_EXPERT.getCode().equals(articleFlows.getRoleId())){
//			
//		}else if(RoleIdEnums.ISSUER.getCode().equals(articleFlows.getRoleId())){
//			
//		}else{
//			
//		}
//		return 0;
//	}

}
