package com.cn.periodical.service.impl;

import com.cn.periodical.manager.*;
import com.cn.periodical.pojo.*;
import com.cn.periodical.request.EditorArticleDealReqDto;
import com.cn.periodical.response.EditorArticleDealRespDto;
import com.cn.periodical.service.EditorArticleDealService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;


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
	ArticleInfoExtendManager articleInfoExtendManager;

    @Autowired
    AddressInfoManager addressInfoManager;
    @Autowired
    PeriodicalDistributManager periodicalDistributManager;
	
	
	
	public EditorArticleDealServiceImpl() {
		// TODO Auto-generated constructor stub
	}

	public List<EditorArticleDealRespDto> articleDeal(String status) {
		// TODO Auto-generated method stub
		List<EditorArticleDealRespDto> list = new ArrayList<EditorArticleDealRespDto>();
		
		ArticleInfoQuery articleInfoQuery = new ArticleInfoQuery();
		articleInfoQuery.setEditorState(status);
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

	public int updateArticleInfo(String expertUserId,String userId,ArticleInfo articleInfo,String articleState) {
		// TODO Auto-generated method stub
		ArticleInfo articleInfoQry =articleInfoManager.findArticleInfoById(articleInfo.getId());
		articleInfoQry.setId(articleInfoQry.getId());
		articleInfoQry.setEditorState(articleState);		
		articleInfoManager.saveArticleInfo(articleInfoQry);
		
		EditorArticleDealReqDto obj = new EditorArticleDealReqDto();
		obj.setRoleId("");
		obj.setUserId(userId);
		obj.setDealState(articleState);
		obj.setDealOpinion("同意");
		obj.setSystemId("");
		obj.setArticleId(articleInfoQry.getArticleId());
		
		registeOperationFlows(obj);
		
		
		if(!"".equals(expertUserId)){
			ArticleInfoExtend articleInfoExtend = new ArticleInfoExtend();
			articleInfoExtend.setUserId(expertUserId);
			articleInfoExtend.setArticleId(obj.getArticleId());
			articleInfoExtend.setRoleId("9999");
			articleInfoExtendManager.saveArticleInfoExtend(articleInfoExtend);
		}
		
		return 0;
	}

	/**
	 * 稿件处理流程流水
	 * */
	public int registeOperationFlows(EditorArticleDealReqDto obj) {
		return 0;
	}


    @Transactional(propagation= Propagation.REQUIRED)
    public void toUploadAddressPage( String orderNo , String periodicalId, List<AddressInfo> list){
        /**
         * 导入之前首先删除 ，都是按照订单号  orderNo
         * periodical_distribut  address_info
         * delete FROM periodical_distribut WHERE ref_id = 'orderNo'
         * delete FROM address_info WHERE extend_1 = 'orderNo'
          */
        addressInfoManager.deleteByOrderNo(orderNo);
        periodicalDistributManager.deletePeriodicalDistributByOrderNo(orderNo);

        for(AddressInfo addressInfo:list){
           this.toUploadAddressPageOne(addressInfo, orderNo , periodicalId);
        }
    }
    @Transactional(propagation= Propagation.REQUIRED)
    public void toUploadAddressPageOne(AddressInfo addressInfo, String orderNo , String periodicalId){
            addressInfo.setExtend1(orderNo);
//            addressInfo.setExtend2("");//excel名称
            addressInfo.setExtend3("");//excel全路径
            addressInfo.setAddressId(UUID.randomUUID().toString().replaceAll("-", ""));
            addressInfo.setCreateTime(new Date());
            addressInfoManager.saveAddressInfo(addressInfo);

            PeriodicalDistribut p = new PeriodicalDistribut();
            p.setPeriodicalId(periodicalId);
            p.setRefId(orderNo);

            p.setAddressId(addressInfo.getAddressId());

            p.setDistributeNums(addressInfo.getSubscribeNums());
            periodicalDistributManager.savePeriodicalDistribut(p);

    }

}
