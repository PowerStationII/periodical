package com.cn.periodical.controller.expert;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.cn.periodical.enums.ArticleStateEnums;
import com.cn.periodical.enums.RoleIdEnums;
import com.cn.periodical.manager.ArticleFlowsManager;
import com.cn.periodical.manager.ArticleInfoManager;
import com.cn.periodical.manager.ArticleInfoStateManager;
import com.cn.periodical.manager.ExpertInfoManager;
import com.cn.periodical.manager.PayeeInfoManager;
import com.cn.periodical.manager.UserInfoManager;
import com.cn.periodical.manager.UserQueryManager;
import com.cn.periodical.pojo.ArticleFlows;
import com.cn.periodical.pojo.ArticleFlowsQuery;
import com.cn.periodical.pojo.ArticleInfo;
import com.cn.periodical.pojo.ArticleInfoQuery;
import com.cn.periodical.pojo.ArticleInfoState;
import com.cn.periodical.pojo.ArticleInfoStateQuery;
import com.cn.periodical.pojo.ExpertInfo;
import com.cn.periodical.pojo.ExpertInfoQuery;
import com.cn.periodical.pojo.PayeeInfo;
import com.cn.periodical.pojo.PayeeInfoQuery;
import com.cn.periodical.pojo.UserInfo;
import com.cn.periodical.request.AritcleWorkFlowReqDto;
import com.cn.periodical.request.ArticleQueryReqDto;
import com.cn.periodical.response.ArticleQueryRespDto;
import com.cn.periodical.service.ArticleQueryService;
import com.cn.periodical.service.ArticleWorkFlowService;
import com.cn.periodical.service.EditorArticleDealService;
import com.cn.periodical.service.ExpertArticleAuditeService;
import com.cn.periodical.utils.UtilLoad;

@Controller
public class ArticleAuditeController extends ExpertController{
	
	private static final Logger logger = LoggerFactory.getLogger(ArticleAuditeController.class);
	
	@Autowired
	ExpertArticleAuditeService articleAuditeService;
	
	@Autowired
	ArticleQueryService articleQueryService;
	
	@Autowired
	EditorArticleDealService articleDealService;
	
	@Autowired
	UserInfoManager userInfoManager;
	@Autowired
	ExpertInfoManager expertInfoManager;
	@Autowired
	PayeeInfoManager payeeInfoManager;
	
	@Autowired 
	UserQueryManager userQueryManager;
	
	@Autowired
	ArticleWorkFlowService articleWorkFlowService;
	
	@Autowired
	ArticleInfoManager articleInfoManager;
	
	@Autowired
	ArticleFlowsManager articleFlowsManager;
	
	@Autowired
	ArticleInfoStateManager articleInfoStateManager;
	
	/**
	 * toArticleAuditePage
	 * 去审稿页面
	 */
	@RequestMapping(value="/toArticleAuditePage")
	public ModelAndView toArticleAuditePage(HttpServletRequest request,@ModelAttribute ArticleQueryReqDto reqDto) {
		UserInfo userInfo = getUserInfo(request);
		logger.info("审稿Page:["+JSON.toJSONString(reqDto)+"]");
		ModelAndView mav = new ModelAndView("expert_articleAuditPage");
		reqDto.setUserId(userInfo.getUserId());
		logger.info("***********************");
		logger.info(JSON.toJSONString(reqDto));
		List<ArticleQueryRespDto> list =articleQueryService.expertQryArticleInfos(reqDto);
		mav.addObject("list", list);
		return mav;
	}
	
	/**
	 * toAuditeDetailPage
	 * 去审稿明细页面
	 */
	@RequestMapping(value="/toAuditeDetailPage")
	public ModelAndView toArticleAuditeDetailPage(@RequestParam("articleId") String articleId,String isDown) {
		logger.info("审稿明细Page:["+articleId+"]"+"isDown-----------" + isDown);
		ModelAndView mav = new ModelAndView("expert_ArticleAuditDetailPage");
		ArticleQueryReqDto reqDto= new ArticleQueryReqDto();
		reqDto.setArticleId(articleId);
		reqDto.setRoleId(RoleIdEnums.ARTICLE_EDITOR.getCode());/**专家下载编辑的稿件*/
		ArticleQueryRespDto articleQueryRespDto =articleQueryService.queryArticleInfoDetail(reqDto);
		mav.addObject("respDto", articleQueryRespDto);
		mav.addObject("isDown", isDown);
		logger.info("审稿明细出参:["+JSON.toJSONString(articleQueryRespDto)+"]");
		return mav;
	}
	
	/**
	 * toExpertUpdateState
	 * 专家变更稿件状态为待刊
	 */
	@RequestMapping(value="/toPublishStateModify")
	@ResponseBody
	public String toPublishStateModify(@RequestParam("articleId") String articleId,
			HttpServletRequest request) {
		logger.info("待刊稿件状态入参:artilceId:["+articleId+"]");
		//ModelAndView mav = new ModelAndView("redirect:/expert/toArticleAuditePage");
		
		ArticleInfoQuery query= new ArticleInfoQuery();
		query.setArticleId(articleId);
		List<ArticleInfo> articleInfos = articleInfoManager.queryList(query);
		ArticleInfo	articleInfo = articleInfos.get(0);
		
		/**
		 * 获取本次处理流水
		 * */
		ArticleFlowsQuery queryNowFlows = new ArticleFlowsQuery();
		queryNowFlows.setArticleId(articleId);
		queryNowFlows.setUserId(getUserInfo(request).getUserId());
		queryNowFlows.setRoleId(getUserInfo(request).getRoleId());
		queryNowFlows.setId(articleInfo.getLatelyFlowsId());
		ArticleFlows articleNowFlows = articleFlowsManager.queryFlowsDetail(queryNowFlows);
		logger.info("稿件本次流水变更前:["+JSON.toJSONString(articleNowFlows)+"]");
		
		/**
		 * 查询稿件的上次处理流水
		 * 为获取编辑id,让稿件原路回去
		 * */
		ArticleFlowsQuery queryLastFlows = new ArticleFlowsQuery();
		queryLastFlows.setArticleId(articleId);
		queryLastFlows.setUserId(getUserInfo(request).getUserId());
		queryLastFlows.setRoleId(RoleIdEnums.ARTICLE_EDITOR.getCode());
		queryLastFlows.setId(articleNowFlows.getPid());
		ArticleFlows articleLastFlows = articleFlowsManager.queryFlowsDetail(queryLastFlows);
		logger.info("稿件上一次流水:["+JSON.toJSONString(articleLastFlows)+"]");
		
		/**
		 * 变更本次稿件处理流水
		 * refId谁把articleId稿件送给articleLastFlows.getRefId()审
		 * */
		articleNowFlows.setId(articleNowFlows.getId());
		articleNowFlows.setArticleId(articleId);
		articleNowFlows.setRoleId(getUserInfo(request).getRoleId());
		articleNowFlows.setExtend1(getUserInfo(request).getUserId());
		
		articleNowFlows.setRefId(getUserInfo(request).getUserId());
		articleNowFlows.setUserId(articleLastFlows.getRefId());
		articleNowFlows.setDealState(ArticleStateEnums.PUBLISH_ARTICLE.getCode());
		articleNowFlows.setDealOpinion("");
		articleNowFlows.setDealEndTime(new Date());
		articleFlowsManager.updateExpertFlows(articleNowFlows);
		logger.info("稿件本次流水变更后:["+JSON.toJSONString(articleNowFlows)+"]");
		
		/**
		 * 变更稿件状态
		 * */
		articleInfo.setId(articleInfo.getId());
		articleInfo.setAuthorState(ArticleStateEnums.SUBMITED_ARTICLE.getCode());
//		articleInfo.setEditorState(ArticleStateEnums.END_ARTICLE.getCode());/**编辑需要确认待刊,确认返修,确认退稿,所以增加此状态.代表专家已处理完成*/
		articleInfo.setExpertState(ArticleStateEnums.PUBLISH_ARTICLE.getCode());
		articleInfoManager.saveArticleInfo(articleInfo);

		logger.info("待刊稿件状态出参:["+JSON.toJSONString(articleInfo)+"]");
		return "true";
	}
	
	
	/**
	 * toExpertRepairedPage
	 * 去专家返修页面
	 */
	@RequestMapping(value="/toExpertRepairedPage")
	public ModelAndView toExpertRepairedPage(@RequestParam("articleId") String articleId,
			@ModelAttribute AritcleWorkFlowReqDto aritcleWorkFlowReqDto) {
		logger.info("专家返修Page:["+articleId+"]");
		ModelAndView mav = new ModelAndView("expert_artilce_repairedPage");
		
		ArticleQueryReqDto reqDto= new ArticleQueryReqDto();
		reqDto.setArticleId(articleId);
		reqDto.setRoleId(RoleIdEnums.ARTICLE_EDITOR.getCode());
		ArticleQueryRespDto articleQueryRespDto =articleQueryService.queryArticleInfoDetail(reqDto);
		mav.addObject("respDto", articleQueryRespDto);
		logger.info("专家返修Page:["+JSON.toJSONString(articleQueryRespDto)+"]");
		return mav;
	}
	
	
	/**
	 * toExpertRepairedModify
	 * 专家返修
	 */
	@RequestMapping(value="/toExpertRepairedModify")
	public ModelAndView toExpertRepairedModify(@RequestParam("articleId") String articleId,
			@ModelAttribute AritcleWorkFlowReqDto aritcleWorkFlowReqDto,HttpServletRequest request) {
		logger.info("专家返修Action:["+articleId+"]&aritcleWorkFlowReqDto:["+JSON.toJSONString(aritcleWorkFlowReqDto)+"]");
		ModelAndView mav = new ModelAndView("redirect:/expert/toArticleAuditePage");
		
		ArticleInfoQuery query= new ArticleInfoQuery();
		query.setArticleId(articleId);
		List<ArticleInfo> articleInfos = articleInfoManager.queryList(query);
		ArticleInfo	articleInfo = articleInfos.get(0);
		
		/**
		 * 获取本次处理流水
		 * */
		ArticleFlowsQuery queryNowFlows = new ArticleFlowsQuery();
		queryNowFlows.setArticleId(articleId);
		queryNowFlows.setUserId(getUserInfo(request).getUserId());
		queryNowFlows.setRoleId(getUserInfo(request).getRoleId());
		queryNowFlows.setId(articleInfo.getLatelyFlowsId());
		ArticleFlows articleNowFlows = articleFlowsManager.queryFlowsDetail(queryNowFlows);
		logger.info("稿件本次流水变更前:["+JSON.toJSONString(articleNowFlows)+"]");
		
		/**
		 * 查询稿件的上次处理流水
		 * 为获取编辑id,让稿件原路回去
		 * */
		ArticleFlowsQuery queryLastFlows = new ArticleFlowsQuery();
		queryLastFlows.setArticleId(articleId);
		queryLastFlows.setUserId(getUserInfo(request).getUserId());
		queryLastFlows.setRoleId(RoleIdEnums.ARTICLE_EDITOR.getCode());
		queryLastFlows.setId(articleNowFlows.getPid());
		ArticleFlows articleLastFlows = articleFlowsManager.queryFlowsDetail(queryLastFlows);
		logger.info("稿件上一次流水:["+JSON.toJSONString(articleLastFlows)+"]");
		
		/**
		 * 变更本次稿件处理流水
		 * refId谁把articleId稿件送给articleLastFlows.getRefId()审
		 * */
		articleNowFlows.setId(articleNowFlows.getId());
		articleNowFlows.setArticleId(articleId);
		articleNowFlows.setRoleId(getUserInfo(request).getRoleId());
		articleNowFlows.setExtend1(getUserInfo(request).getUserId());
		
		articleNowFlows.setRefId(getUserInfo(request).getUserId());
		articleNowFlows.setUserId(articleLastFlows.getRefId());
		articleNowFlows.setDealState(ArticleStateEnums.REPAIR_ARTICLE.getCode());
		articleNowFlows.setDealOpinion(aritcleWorkFlowReqDto.getDealOpinion());
		articleNowFlows.setDealEndTime(new Date());
		articleFlowsManager.updateExpertFlows(articleNowFlows);
		logger.info("稿件本次流水变更后:["+JSON.toJSONString(articleNowFlows)+"]");
		
		/**
		 * 变更稿件状态
		 * */
		articleInfo.setId(articleInfo.getId());
		articleInfo.setAuthorState(ArticleStateEnums.SUBMITED_ARTICLE.getCode());
		articleInfo.setEditorState(ArticleStateEnums.END_ARTICLE.getCode());/**编辑需要确认待刊,确认返修,确认退稿,所以增加此状态.代表专家已处理完成*/
		articleInfo.setExpertState(ArticleStateEnums.REPAIR_ARTICLE.getCode());
		articleInfoManager.saveArticleInfo(articleInfo);

		logger.info("专家返修Action:["+JSON.toJSONString(articleInfo)+"]");
		return mav;
	}
	
	/**
	 * toExpertRefundPage
	 * 去专家退稿页面
	 */
	@RequestMapping(value="/toExpertRefundPage")
	public ModelAndView toExpertRefundPage(@RequestParam("articleId") String articleId,
			@ModelAttribute AritcleWorkFlowReqDto aritcleWorkFlowReqDto) {
		logger.info("专家退稿Page:["+articleId+"]");
		ModelAndView mav = new ModelAndView("expert_artilce_refundPage");
		
		ArticleQueryReqDto reqDto= new ArticleQueryReqDto();
		reqDto.setArticleId(articleId);
		reqDto.setRoleId(RoleIdEnums.ARTICLE_EDITOR.getCode());
		ArticleQueryRespDto articleQueryRespDto =articleQueryService.queryArticleInfoDetail(reqDto);
		mav.addObject("respDto", articleQueryRespDto);
		logger.info("专家退稿Page:["+JSON.toJSONString(articleQueryRespDto)+"]");
		return mav;
	}
	
	
	/**
	 * toExpertRefundModify
	 * 专家退稿
	 */
	@RequestMapping(value="/toExpertRefundModify")
	public ModelAndView toExpertRefundModify(@RequestParam("articleId") String articleId,
			@ModelAttribute AritcleWorkFlowReqDto aritcleWorkFlowReqDto,HttpServletRequest request) {
		logger.info("专家退稿Action:["+articleId+"]&aritcleWorkFlowReqDto:["+JSON.toJSONString(aritcleWorkFlowReqDto)+"]");
		ModelAndView mav = new ModelAndView("redirect:/expert/toArticleAuditePage");
		
		ArticleInfoQuery query= new ArticleInfoQuery();
		query.setArticleId(articleId);
		List<ArticleInfo> articleInfos = articleInfoManager.queryList(query);
		ArticleInfo	articleInfo = articleInfos.get(0);
		
		/**
		 * 获取本次处理流水
		 * */
		ArticleFlowsQuery queryNowFlows = new ArticleFlowsQuery();
		queryNowFlows.setArticleId(articleId);
		queryNowFlows.setUserId(getUserInfo(request).getUserId());
		queryNowFlows.setRoleId(getUserInfo(request).getRoleId());
		queryNowFlows.setId(articleInfo.getLatelyFlowsId());
		ArticleFlows articleNowFlows = articleFlowsManager.queryFlowsDetail(queryNowFlows);
		logger.info("稿件本次流水变更前:["+JSON.toJSONString(articleNowFlows)+"]");
		
		/**
		 * 查询稿件的上次处理流水
		 * 为获取编辑id,让稿件原路回去
		 * */
		ArticleFlowsQuery queryLastFlows = new ArticleFlowsQuery();
		queryLastFlows.setArticleId(articleId);
		queryLastFlows.setUserId(getUserInfo(request).getUserId());
		queryLastFlows.setRoleId(RoleIdEnums.ARTICLE_EDITOR.getCode());
		queryLastFlows.setId(articleNowFlows.getPid());
		ArticleFlows articleLastFlows = articleFlowsManager.queryFlowsDetail(queryLastFlows);
		logger.info("稿件上一次流水:["+JSON.toJSONString(articleLastFlows)+"]");
		
		/**
		 * 变更本次稿件处理流水
		 * refId谁把articleId稿件送给articleLastFlows.getRefId()审
		 * */
		articleNowFlows.setId(articleNowFlows.getId());
		articleNowFlows.setArticleId(articleId);
		articleNowFlows.setRoleId(getUserInfo(request).getRoleId());
		articleNowFlows.setExtend1(getUserInfo(request).getUserId());
		
		articleNowFlows.setRefId(getUserInfo(request).getUserId());
		articleNowFlows.setUserId(articleLastFlows.getRefId());
		articleNowFlows.setDealState(ArticleStateEnums.RETURNED_ARTICLE.getCode());
		articleNowFlows.setDealOpinion(aritcleWorkFlowReqDto.getDealOpinion());
		articleNowFlows.setDealEndTime(new Date());
		articleFlowsManager.updateExpertFlows(articleNowFlows);
		logger.info("稿件本次流水变更后:["+JSON.toJSONString(articleNowFlows)+"]");
		
		/**
		 * 变更稿件状态
		 * */
		articleInfo.setId(articleInfo.getId());
		articleInfo.setAuthorState(ArticleStateEnums.SUBMITED_ARTICLE.getCode());
		articleInfo.setEditorState(ArticleStateEnums.END_ARTICLE.getCode());/**编辑需要确认待刊,确认返修,确认退稿,所以增加此状态.代表专家已处理完成*/
		articleInfo.setExpertState(ArticleStateEnums.RETURNED_ARTICLE.getCode());
		articleInfoManager.saveArticleInfo(articleInfo);
		
		logger.info("专家退稿Action:["+JSON.toJSONString(articleInfo)+"]");
		return mav;
	}
	
	/**
	 * toDownLoadArticle
	 * 下载触发记录稿件流水 
	 * 停留在审核操作页面 End
	 */
	@RequestMapping(value="/toDownLoadArticle")
	public ModelAndView toDownLoadArticle(@RequestParam("articleId") String articleId,String expertDownload,
			String fileName,String filePath,String isDown,
			HttpServletRequest request) {
		logger.info("专家审核页-下载稿件Action入参:artilceId:["+articleId+"]");
		ModelAndView mav = new ModelAndView("redirect:../expert/toAuditeDetailPage");
		mav.addObject("articleId", articleId);
		mav.addObject("isDown", isDown);

		if ("N".equals(expertDownload)) {
			/**
			 * 记录稿件开始处理流水
			 * */
			AritcleWorkFlowReqDto reqDto = new AritcleWorkFlowReqDto();
			UserInfo userInfo = getUserInfo(request);
			reqDto.setUserId(userInfo.getUserId());
			reqDto.setArticleId(articleId);
			reqDto.setRoleId(userInfo.getRoleId());
			reqDto.setDealStartTime(new Date());
			reqDto.setExtend(userInfo.getUserId());
			articleWorkFlowService.registArticleWorkFlow(reqDto);
			
			ArticleInfoStateQuery stateQuery= new ArticleInfoStateQuery();
			stateQuery.setArticleId(articleId);
			List<ArticleInfoState> articleInfoStates = articleInfoStateManager.queryList(stateQuery);
			ArticleInfoState articleInfoState = articleInfoStates.get(0);
			articleInfoState.setId(articleInfoState.getId());
			articleInfoState.setExpertDownload("Y");
			articleInfoState.setExpertDownloadTime(new Date());
			articleInfoStateManager.saveArticleInfoState(articleInfoState);
			logger.info("稿件登记页-下载稿件Action出参:[]");
		}
		
		
		
		
		logger.info("专家审核页-下载稿件Action出参:[]");
		return mav;
	}
	
	@RequestMapping(value="/toExpertDownLoadNewArticle")
	public void download (HttpServletRequest request,HttpServletResponse response,
				String fileName,String filePath) {
		logger.info(filePath);
		UtilLoad.fileDownload(request, response,fileName,filePath.replace(fileName,""));
	}
	
	/**
	 * 编辑账户信息start
	 * */
	/**
	 * toAddExpertPayeeInfoPage
	 * 收款账户信息新增页面
	 */
	@RequestMapping(value="/toAddExpertPayeeInfoPage")
	public ModelAndView toAddExpertPayeeInfoPage(HttpServletRequest request,
			HttpServletResponse response) {
		UserInfo userInfo = getUserInfo(request);
		ModelAndView mav = new ModelAndView("expert_payeeInfoPage");
		ExpertInfoQuery query = new ExpertInfoQuery();
		query.setExpertId(userInfo.getRefId());
		List<ExpertInfo> expertInfos = expertInfoManager.queryList(query);
		mav.addObject("ei", expertInfos.get(0));
		
		PayeeInfoQuery pQry= new PayeeInfoQuery();
		pQry.setRefId(userInfo.getRefId());
		List<PayeeInfo> payeeInfos = payeeInfoManager.queryList(pQry);
		if(payeeInfos!=null && payeeInfos.size()==1){
			mav.addObject("payeeInfo", payeeInfos.get(0));
		}
		return mav;
	}
	
	/**
	 * toSaveExpertPayeeInfoPage
	 * 保存收款账户信息
	 */
	@RequestMapping(value="/toSaveExpertPayeeInfoPage")
	public ModelAndView toSaveExpertPayeeInfoPage(
			@ModelAttribute PayeeInfo payeeInfo ,HttpServletRequest request,
			HttpServletResponse response) {
		UserInfo userInfo = getUserInfo(request);
		logger.info("保存专家收款账户信息Page in:["+JSON.toJSONString(payeeInfo)+"]");
		ModelAndView mav = new ModelAndView("redirect:../expert/toArticleAuditePage");
		String uuid = UUID.randomUUID().toString().replaceAll("-", "");
		payeeInfo.setPayeeId(uuid);
		payeeInfo.setRefId(userInfo.getRefId());
		payeeInfo.setType("002");
		payeeInfoManager.savePayeeInfo(payeeInfo);
		return mav;
	}
}
