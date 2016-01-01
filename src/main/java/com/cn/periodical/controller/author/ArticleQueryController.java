package com.cn.periodical.controller.author;

import java.util.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cn.periodical.enums.ArticleStateEnums;
import com.cn.periodical.enums.RoleIdEnums;
import com.cn.periodical.pojo.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.cn.periodical.manager.ArticleFlowsManager;
import com.cn.periodical.manager.ArticleInfoManager;
import com.cn.periodical.manager.AuthorInfoManager;
import com.cn.periodical.manager.PayeeInfoManager;
import com.cn.periodical.request.ArticleQueryReqDto;
import com.cn.periodical.response.ArticleQueryRespDto;
import com.cn.periodical.service.ArticleQueryService;
/**
 * 作者工作区-稿件查询 
 * */
@Controller
public class ArticleQueryController extends AuthorController{
	
	private static final Logger logger = LoggerFactory.getLogger(ArticleQueryController.class);
	@Autowired
	ArticleQueryService articleQueryService;
	
	@Autowired
	ArticleFlowsManager articleFlowsManager;
	
	@Autowired
	AuthorInfoManager authorInfoManager;
	
	@Autowired
	ArticleInfoManager articleInfoManager;
	@Autowired
	PayeeInfoManager payeeInfoManager;
	
	/**
	 * toArticleQueryPage
	 * author/toArticleQueryPage
	 * 去稿件查询页面
	 */
	@RequestMapping(value="/toArticleQueryPage")
	public ModelAndView toArticleQueryPage(HttpServletRequest request,HttpServletResponse response) {
		logger.info("稿件查询Page:[]");
		ModelAndView mav = new ModelAndView("articleQueryPage");		
		ArticleQueryReqDto reqDto= new ArticleQueryReqDto();
		reqDto.setUserId(getUserInfo(request).getUserId());
		List<ArticleQueryRespDto> list =articleQueryService.queryArticleInfos(reqDto);
		mav.addObject("list", list);
		logger.info("稿件查询出参:["+JSON.toJSONString(list)+"]");
		return mav;
	}
	
	
	/**
	 * toArticleQueryDetailPage
	 * 作者去稿件明细页面
	 */
	@RequestMapping(value="/toArticleQueryDetailPage",method = RequestMethod.GET)
	public ModelAndView toArticleQueryDetailPage(@RequestParam("articleId") String articleId) {
		logger.info("稿件明细Page:["+articleId+"]");
		ModelAndView mav = new ModelAndView("articleQueryDetailPage");
		AuthorQueryDetail detail = articleQueryService.queryAuthorQueryDetail(articleId);
        Set<String> set = new HashSet<String>();
        set.add(RoleIdEnums.AUTHOR_ATTR.getCode());
        if(ArticleStateEnums.END_ARTICLE.getCode().equals(detail.getEditorState())){ // 稿件处理完成了， 作者才可以看审核之后的附件
            set.add(RoleIdEnums.ARTICLE_EDITOR_ATTR.getCode());
        }
        List<ArticleAttachmentInfo> listAttr = articleQueryService.queryAttByArtcicle(articleId, set);
		mav.addObject("detail", detail);
		mav.addObject("listAttr", listAttr);
		logger.info("稿件明细出参:["+JSON.toJSONString(detail)+"]");
		return mav;
	}
	
	
	/**
	 * toOpinionQueryPage
	 * 查询审核意见
	 */
	@RequestMapping(value="/toOpinionQueryPage",produces = "application/text; charset=utf-8")
	@ResponseBody
	public String toOpinionQueryPage(@RequestParam("articleId") String articleId,HttpServletRequest request,
			HttpServletResponse response) {
		UserInfo userInfo = getUserInfo(request);
		logger.info("查询审稿意见Page in:["+JSON.toJSONString(userInfo)+"]");
		//ModelAndView mav = new ModelAndView("redirect:../author/toArticleQueryPage");
		Opinion opinion = articleFlowsManager.queryOpinion(articleId);
		logger.info("查询审稿意见Page out:["+JSON.toJSONString(opinion)+"]");
		return JSON.toJSONString(opinion);
	}
	
	/**
	 * toEditAuthorPayeeInfoPage
	 * 编辑收款账户信息
	 */
	@RequestMapping(value="/toEditAuthorPayeeInfoPage")
	public ModelAndView toEditAuthorPayeeInfoPage(@RequestParam("articleId") String articleId,HttpServletRequest request,
			HttpServletResponse response) {
		UserInfo userInfo = getUserInfo(request);
		logger.info("编辑待刊稿件收款账户信息Page in:["+JSON.toJSONString(articleId)+"]");
		ModelAndView mav = new ModelAndView("payeeInfoPage");
		AuthorInfoQuery query = new AuthorInfoQuery();
		query.setArticleId(articleId);
		List<AuthorInfo> authorInfos = authorInfoManager.queryList(query);
		mav.addObject("list", authorInfos);
		Map reqMap = new HashMap();
		reqMap.put("userId", userInfo.getUserId());
		reqMap.put("articleId", articleId);
		ArticleInfo articleInfo = articleInfoManager.qryInfoByArticleId(reqMap);
		mav.addObject("articleInfo", articleInfo);
		logger.info("编辑待刊稿件收款账户信息Page out:["+JSON.toJSONString(authorInfos)+"]");
		return mav;
	}
	
	
	
	/**
	 * toAddAuthorPayeeInfoPage
	 * 收款账户信息新增页面
	 */
	@RequestMapping(value="/toAddAuthorPayeeInfoPage")
	public ModelAndView toAddAuthorPayeeInfoPage(String authorId,String articleId,HttpServletRequest request,
			HttpServletResponse response) {
		UserInfo userInfo = getUserInfo(request);
//		logger.info("编辑待刊稿件收款账户信息Page in:["+JSON.toJSONString(articleId)+"]");
		ModelAndView mav = new ModelAndView("addPayeeInfoPage");
		
		AuthorInfoQuery query = new AuthorInfoQuery();
		query.setArticleId(articleId);
		query.setAuthorId(authorId);
		List<AuthorInfo> authorInfos = authorInfoManager.queryList(query);
		AuthorInfo authorInfo =authorInfos.get(0);
		PayeeInfoQuery payInfoQuery = new PayeeInfoQuery();
		payInfoQuery.setExtend1(articleId);
		payInfoQuery.setRefId(authorInfo.getAuthorId());
		payInfoQuery.setType("001");
		List<PayeeInfo> payeeInfos = payeeInfoManager.queryList(payInfoQuery);
		if(payeeInfos==null || payeeInfos.size()==0){
			mav.addObject("payeeInfo", "");
		}else{
			mav.addObject("payeeInfo", payeeInfos.get(0));
		}
		mav.addObject("author", authorInfos.get(0));
		mav.addObject("articleId", articleId);
		return mav;
	}
	
	/**
	 * toSaveAuthorPayeeInfoPage
	 * 保存收款账户信息
	 */
	@RequestMapping(value="/toSaveAuthorPayeeInfoPage")
	public ModelAndView toSaveAuthorPayeeInfoPage(String articleId,String authorId,
			@ModelAttribute PayeeInfo payeeInfo ,HttpServletRequest request,
			HttpServletResponse response) {
		UserInfo userInfo = getUserInfo(request);
		logger.info("保存稿件收款账户信息Page in:["+JSON.toJSONString(payeeInfo)+"]");
		ModelAndView mav = new ModelAndView("redirect:../author/toArticleQueryPage");
		String uuid = UUID.randomUUID().toString().replaceAll("-", "");
		payeeInfo.setPayeeId(uuid);
		payeeInfo.setRefId(authorId);
		payeeInfo.setExtend1(articleId);
		payeeInfo.setType("001");
		payeeInfo.setId(payeeInfo.getId());
		payeeInfoManager.savePayeeInfo(payeeInfo);
		/**
		 * 将该作者状态修改为第一作者
		 * */
		AuthorInfoQuery query = new AuthorInfoQuery();
		query.setAuthorId(authorId);
		List<AuthorInfo> authorInfos = authorInfoManager.queryList(query);
		AuthorInfo authorInfo = authorInfos.get(0);
		authorInfo.setIsfirstauthor("Y");
		authorInfo.setId(authorInfo.getId());
		authorInfoManager.saveAuthorInfo(authorInfo);
		return mav;
	}


    // ===============以下是非作者这的模块==================

    /**
     * toArticleQueryDetailPage
     * 编辑初投稿去稿件明细页面
     */
    @RequestMapping(value="/toArticleQueryDetailPageNew",method = RequestMethod.GET)
    public ModelAndView toArticleQueryDetailPageNew(@RequestParam("articleId") String articleId) {
        logger.info("稿件明细Page:["+articleId+"]");
        ModelAndView mav = new ModelAndView("articleQueryDetailPage");
        AuthorQueryDetail detail = articleQueryService.queryAuthorQueryDetail(articleId);
        Set<String> set = new HashSet<String>();// 设置可以下载谁的稿件
        set.add(RoleIdEnums.AUTHOR_ATTR.getCode());
        set.add(RoleIdEnums.ARTICLE_EDITOR_ATTR.getCode());
        set.add(RoleIdEnums.CN_EXPERT_ATTR.getCode());
        List<ArticleAttachmentInfo> listAttr = articleQueryService.queryAttByArtcicle(articleId, set);
        mav.addObject("detail", detail);
        mav.addObject("listAttr", listAttr);
        logger.info("稿件明细出参:["+JSON.toJSONString(detail)+"]");
        return mav;
    }
    /**
     * toArticleQueryDetailPage
     * 专家审核去稿件明细页面
     */
    @RequestMapping(value="/toArticleQueryDetailPageZhuanJiaShenHe",method = RequestMethod.GET)
    public ModelAndView toArticleQueryDetailPageZhuanJiaShenHe(@RequestParam("articleId") String articleId) {
        logger.info("稿件明细Page:["+articleId+"]");
        ModelAndView mav = new ModelAndView("articleQueryDetailPage");
        AuthorQueryDetail detail = articleQueryService.queryAuthorQueryDetail(articleId);
        Set<String> set = new HashSet<String>();// 设置可以下载谁的稿件
        set.add(RoleIdEnums.ARTICLE_EDITOR_ATTR.getCode());
        set.add(RoleIdEnums.CN_EXPERT_ATTR.getCode());
        List<ArticleAttachmentInfo> listAttr = articleQueryService.queryAttByArtcicle(articleId, set);
        mav.addObject("detail", detail);
        mav.addObject("listAttr", listAttr);
        logger.info("稿件明细出参:["+JSON.toJSONString(detail)+"]");
        return mav;
    }
}
