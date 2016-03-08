package com.cn.periodical.controller.author;

import java.util.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSONObject;
import com.cn.periodical.enums.ArticleStateEnums;
import com.cn.periodical.enums.RoleIdEnums;
import com.cn.periodical.manager.*;
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
	@Autowired
    PeriodicalChongtouLogManager periodicalChongtouLogManager;


    /**
     * toArticleQueryPage
     * author/toArticleQueryPage
     * 去稿件查询页面
     */
    @RequestMapping(value="/toArticleQueryPage")
    public ModelAndView toArticleQueryPage() {
        ModelAndView mav = new ModelAndView("articleQueryPage");
        return mav;
    }
	/**
	 * toArticleQueryPage
	 * author/toArticleQueryPage
	 * 稿件分页查询
	 */
	@RequestMapping(value="/toArticleQueryPageSet")
    @ResponseBody
    public JSONObject toArticleQueryPage(HttpServletRequest request,HttpServletResponse response,
                                           @ModelAttribute ArticleQueryReqDto query,
                                           @RequestParam(required = false, value = "page", defaultValue = "1") int page,
                                           @RequestParam(required = false, value = "rows", defaultValue = "10") int rows) {
		logger.info("稿分页件查询Page:[]");
        // 返回给页面的一个json
        JSONObject json = new JSONObject();
        query.setUserId(getUserInfo(request).getUserId());
        /**
         * 查询总数
         */
        int count = articleQueryService.queryArticleInfosCount(query);
        json.put("total", count);
        logger.info("+++++++++"+count);

        query.setPageSize((page-1)*rows);//开始
        query.setPageNo(rows);//截止

        logger.info("稿分页件查询首页*****Page in:["+JSON.toJSONString(query)+"]");
        ZuoZheGaoJianPage zuoZheGaoJianPage =articleQueryService.queryArticleInfos(query,count);
        json.put("rows", zuoZheGaoJianPage.getValues());

        logger.info("稿分页件查询Page out:[]");
        return json;




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
        PeriodicalChongtouLog periodicalChongtouLog = new PeriodicalChongtouLog () ;
        periodicalChongtouLog.setArticleNo(articleId);
        List<PeriodicalChongtouLog> listFanxiu = periodicalChongtouLogManager.selectByCondition(periodicalChongtouLog);
        if(null!=listFanxiu && !listFanxiu.isEmpty()){
            detail.setOriArticleId(listFanxiu.get(0).getGroupFlag());
        }else{
            detail.setOriArticleId(articleId);
        }

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
	 * toArticleQueryDetailPage
	 * 作者去稿件重投页面
	 */
	@RequestMapping(value="/toArticleQueryChongTouPage",method = RequestMethod.GET)
	public ModelAndView toArticleQueryChongTouPage(@RequestParam("articleId") String articleId) {
		logger.info("稿件明细Page:["+articleId+"]");
		ModelAndView mav = new ModelAndView("articleQueryChongTouPage");
		AuthorQueryDetail detail = articleQueryService.queryAuthorQueryDetail(articleId);
        PeriodicalChongtouLog periodicalChongtouLog = new PeriodicalChongtouLog () ;
        periodicalChongtouLog.setArticleNo(articleId);
        List<PeriodicalChongtouLog> listFanxiu = periodicalChongtouLogManager.selectByCondition(periodicalChongtouLog);
        if(null!=listFanxiu && !listFanxiu.isEmpty()){
            detail.setOriArticleId(articleId);
            detail.setArticleId(listFanxiu.get(0).getGroupFlag());
        }else{
            detail.setOriArticleId(articleId);
            detail.setArticleId(articleId);
        }


        Set<String> set = new HashSet<String>();
        set.add(RoleIdEnums.AUTHOR_ATTR.getCode());
        if(ArticleStateEnums.REPAIR_ARTICLE.getCode().equals(detail.getEditorState())){ // 稿件处理完成了， 作者才可以看审核之后的附件,返修了也是处理完了
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
	public String toOpinionQueryPage(@RequestParam("articleId") String articleId,
                                     HttpServletRequest request, String status,
			HttpServletResponse response) {
		UserInfo userInfo = getUserInfo(request);
		logger.info("查询审稿意见Page in:["+JSON.toJSONString(userInfo)+"]");
		//ModelAndView mav = new ModelAndView("redirect:../author/toArticleQueryPage");
        Opinion opinionQuery = new Opinion () ;
        opinionQuery.setArticleId(articleId);
        if("".equals(status) || null==status){
            status = "0003" ;
        }
        opinionQuery.setStatus(status);
		Opinion opinion = articleFlowsManager.queryOpinion(opinionQuery);
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
        PeriodicalChongtouLog periodicalChongtouLog = new PeriodicalChongtouLog () ;
        periodicalChongtouLog.setArticleNo(articleId);
        List<PeriodicalChongtouLog> listFanxiu = periodicalChongtouLogManager.selectByCondition(periodicalChongtouLog);
        if(null!=listFanxiu && !listFanxiu.isEmpty()){
            detail.setArticleId(listFanxiu.get(0).getGroupFlag());
        }

        Set<String> set = new HashSet<String>();// 设置可以下载谁的稿件
        set.add(RoleIdEnums.AUTHOR_ATTR.getCode());
        set.add(RoleIdEnums.ARTICLE_EDITOR_ATTR.getCode());
        set.add(RoleIdEnums.CN_EXPERT_ATTR.getCode());
        set.add(RoleIdEnums.EN_EXPERT_ATTR.getCode());
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

        PeriodicalChongtouLog periodicalChongtouLog = new PeriodicalChongtouLog () ;
        periodicalChongtouLog.setArticleNo(articleId);
        List<PeriodicalChongtouLog> listFanxiu = periodicalChongtouLogManager.selectByCondition(periodicalChongtouLog);
        if(null!=listFanxiu && !listFanxiu.isEmpty()){
            detail.setArticleId(listFanxiu.get(0).getGroupFlag());
        }else{
            detail.setArticleId(articleId);
        }
        detail.setOriArticleId(articleId);

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
