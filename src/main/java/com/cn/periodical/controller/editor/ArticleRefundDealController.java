package com.cn.periodical.controller.editor;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSONObject;
import com.cn.periodical.pojo.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.cn.periodical.enums.ArticleStateEnums;
import com.cn.periodical.enums.RoleIdEnums;
import com.cn.periodical.enums.SystemIdEnums;
import com.cn.periodical.manager.ArticleFlowsManager;
import com.cn.periodical.manager.ArticleInfoManager;
import com.cn.periodical.manager.UserInfoManager;
import com.cn.periodical.manager.UserQueryManager;
import com.cn.periodical.request.AritcleWorkFlowReqDto;
import com.cn.periodical.request.ArticleQueryReqDto;
import com.cn.periodical.request.UserQueryReqDto;
import com.cn.periodical.response.ArticleQueryRespDto;
import com.cn.periodical.response.EditorArticleDealRespDto;
import com.cn.periodical.service.ArticleQueryService;
import com.cn.periodical.service.ArticleWorkFlowService;
import com.cn.periodical.service.EditorArticleDealService;
/**
 * 稿件编辑-稿件处理Controller
 * */
@Controller
public class ArticleRefundDealController extends EditorController{
	
	private static final Logger logger = LoggerFactory.getLogger(ArticleRefundDealController.class);
	
	@Autowired
	EditorArticleDealService articleDealService;/**作废*/
	
	@Autowired
	ArticleQueryService articleQueryService;
	
	@Autowired
	ArticleWorkFlowService articleWorkFlowService;
	
	@Autowired
	ArticleInfoManager articleInfoManager;
	
	@Autowired
	ArticleFlowsManager articleFlowsManager;
	
	@Autowired
	UserInfoManager userInfoManager;
	
	@Autowired 
	UserQueryManager userQueryManager;
	
//	/**
//	 * toReturnedArticlePage
//	 * 退稿
//	 */
//	@RequestMapping(value="/toReturnedArticlePage",method = RequestMethod.GET)
//	public ModelAndView toReturnedArticlePage(HttpServletRequest request) {
//		logger.info("退稿PageList in:[]");
//		UserInfo userInfo = getUserInfo(request);
//		ModelAndView mav = new ModelAndView("editor_returnedArticlePage");
//		ArticleQueryReqDto reqDto= new ArticleQueryReqDto();
//		reqDto.setEditorState(ArticleStateEnums.END_ARTICLE.getCode());
//		reqDto.setExpertState(ArticleStateEnums.RETURNED_ARTICLE.getCode());
//		reqDto.setRoleId(userInfo.getRoleId());
//		List<ArticleQueryRespDto> list =articleQueryService.queryArticleInfos(reqDto);
//		mav.addObject("list", list);
//		logger.info("退稿PageList out:["+JSON.toJSONString(list)+"]");
//		return mav;
//	}
	/**
	 * toReturnedArticlePage
	 * 退稿
	 */
	@RequestMapping(value="/toReturnedArticlePage",method = RequestMethod.GET)
	public ModelAndView toReturnedArticlePage(HttpServletRequest request) {
		logger.info("退稿PageList in:[]");
		ModelAndView mav = new ModelAndView("editor_returnedArticlePage");
		return mav;
	}
	/**
	 * toReturnedArticlePage
	 * 退稿
	 */
	@RequestMapping(value="/toReturnedArticlePageSet")
    @ResponseBody
    public JSONObject toReturnedArticlePageSet(HttpServletRequest request,HttpServletResponse response,
                                               @ModelAttribute ArticleQueryReqDto query,
                                               @RequestParam(required = false, value = "page", defaultValue = "1") int page,
                                               @RequestParam(required = false, value = "rows", defaultValue = "10") int rows) {
		logger.info("退稿PageList in:[]");
		UserInfo userInfo = getUserInfo(request);

        JSONObject json = new JSONObject();
        query.setEditorState(ArticleStateEnums.SUBMITED_ARTICLE.getCode());
//        query.setEditorState(ArticleStateEnums.END_ARTICLE.getCode());
        query.setExpertState(ArticleStateEnums.RETURNED_ARTICLE.getCode());
        query.setRoleId(userInfo.getRoleId());
        /**
         * 查询总数
         */
        int count = articleQueryService.queryArticleInfosCount(query);
        json.put("total", count);
        logger.info("+++++++++"+count);

        query.setPageSize((page-1)*rows);//开始
        query.setPageNo(rows);//截止

        logger.info("已登记Page出参 in:["+JSON.toJSONString(query)+"]");

        ZuoZheGaoJianPage zuoZheGaoJianPage =articleQueryService.queryArticleInfos(query,count);
        json.put("rows", zuoZheGaoJianPage.getValues());

        logger.info("已登记Page出参 out:[]");
        return json;
	}

    /**
     * 退稿
     * @param articleId
     * @param flag 区分是作者直接退稿还是专家退稿
     * @param request
     * @return
     */
	@RequestMapping(value="/toRefundPage")
	public ModelAndView toRefundPage(@RequestParam("articleId") String articleId,String flag ,HttpServletRequest request) {
		logger.info("退稿Page in :["+articleId+"]");
		ModelAndView mav = new ModelAndView("editor_artilce_refundedPage");
		
		ArticleQueryReqDto reqDto= new ArticleQueryReqDto();
		reqDto.setArticleId(articleId);
        if("gaoJian".equals(flag)){
            reqDto.setRoleId(RoleIdEnums.AUTHOR.getCode());
        }else{
            reqDto.setRoleId(RoleIdEnums.ARTICLE_EDITOR.getCode());/**编辑和专家共用一个稿件目录*/
        }
		ArticleQueryRespDto articleQueryRespDto =articleQueryService.queryArticleInfoDetail(reqDto);
        Opinion opinion = articleFlowsManager.queryOpinion2(articleId);
		mav.addObject("respDto", articleQueryRespDto);
		mav.addObject("opinion", opinion);

		logger.info("退稿Page out :["+JSON.toJSONString(articleQueryRespDto)+"]");
		return mav;
	}
	
	
	/**
	 * toPublishModify
	 * 待刊-Action
	 */
	@RequestMapping(value="/toRefundModify")
	public ModelAndView toPublishArticleDetailPage(@RequestParam("articleId") String articleId,
			HttpServletRequest request,@ModelAttribute AritcleWorkFlowReqDto aritcleWorkFlowReqDto) {
		logger.info("退稿Action in:articleId:["+articleId+"]&aritcleWorkFlowReqDto:["+JSON.toJSONString(aritcleWorkFlowReqDto)+"]");
		ModelAndView mav = new ModelAndView("redirect:../editor/toReturnedArticlePage");

		ArticleInfoQuery query= new ArticleInfoQuery();
		query.setArticleId(articleId);
		List<ArticleInfo> articleInfos = articleInfoManager.queryList(query);
		ArticleInfo	articleInfo = articleInfos.get(0);
		
		/**
		 * 记录稿件开始处理流水
		 * refId谁把articleId稿件送给dtoResult.getUserId审
		 * userId对articleId稿件做了dealState/dealOpinion什么
		 * */
		AritcleWorkFlowReqDto reqDto = new AritcleWorkFlowReqDto();
		reqDto.setUserId(getUserInfo(request).getUserId());
		reqDto.setArticleId(articleId);
		reqDto.setRoleId(RoleIdEnums.ARTICLE_EDITOR.getCode());
		reqDto.setDealState(ArticleStateEnums.RETURNED_ARTICLE.getCode());
		reqDto.setToRoleId(RoleIdEnums.ARTICLE_EDITOR.getCode());
		reqDto.setDealOpinion(aritcleWorkFlowReqDto.getDealOpinion());
		reqDto.setDealStartTime(new Date());
		articleWorkFlowService.registArticleWorkFlow(reqDto);
		
		/**
		 * 变更稿件状态
		 * */
		articleInfo.setId(articleInfo.getId());
		articleInfo.setAuthorState(ArticleStateEnums.RETURNED_ARTICLE.getCode());
		articleInfo.setEditorState(ArticleStateEnums.RETURNED_ARTICLE.getCode());
		articleInfoManager.saveArticleInfo(articleInfo);
		
		logger.info("退稿Action out:["+JSON.toJSONString(articleInfo)+"]");
		return mav;
	}
	
}
