package com.cn.periodical.controller.expert;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.cn.periodical.manager.ArticleFlowsManager;
import com.cn.periodical.manager.ArticleInfoManager;
import com.cn.periodical.manager.UserInfoManager;
import com.cn.periodical.manager.UserQueryManager;
import com.cn.periodical.pojo.BizPeriodical;
import com.cn.periodical.pojo.UserInfo;
import com.cn.periodical.response.ArticleQueryRespDto;
import com.cn.periodical.service.ArticleQueryService;
import com.cn.periodical.service.ArticleWorkFlowService;
import com.cn.periodical.service.EditorArticleDealService;
import com.cn.periodical.service.ExpertArticleAuditeService;

/**
 * 英文审刊
 * */
@Controller
public class EnExpertAuditePeriodicalController extends ExpertController{
	
	private static final Logger logger = LoggerFactory.getLogger(EnExpertAuditePeriodicalController.class);
	
	@Autowired
	ExpertArticleAuditeService articleAuditeService;
	
	@Autowired
	ArticleQueryService articleQueryService;
	
	@Autowired
	EditorArticleDealService articleDealService;
	
	@Autowired
	UserInfoManager userInfoManager;
	
	@Autowired 
	UserQueryManager userQueryManager;
	
	@Autowired
	ArticleWorkFlowService articleWorkFlowService;
	
	@Autowired
	ArticleInfoManager articleInfoManager;
	
	@Autowired
	ArticleFlowsManager articleFlowsManager;
	
	/**
	 * toEnAuditePeriodicalPage
	 * 去英文审刊页面
	 */
	@RequestMapping(value="/toEnAuditePeriodicalPage")
	public ModelAndView toEnAuditePeriodicalPage(HttpServletRequest request,
			@ModelAttribute BizPeriodical reqDto) {
		UserInfo userInfo = getUserInfo(request);
		logger.info("英文审刊Page:["+JSON.toJSONString(reqDto)+"]");
		ModelAndView mav = new ModelAndView("expert_enAuditPeriodicalPage");
		logger.info(JSON.toJSONString(reqDto));
		/**
		 * 
		 * */
//		List<ArticleQueryRespDto> list =articleQueryService.expertQryArticleInfos(reqDto);
//		mav.addObject("list", list);
		return mav;
	}
	
	
	
	
	/**
	 * auditPeriodicalDetailPage
	 * 点击审核
	 */
	@RequestMapping(value="/auditPeriodicalDetailPage")
	public ModelAndView auditPeriodicalDetailPage(HttpServletRequest request,
			@ModelAttribute BizPeriodical reqDto) {
		UserInfo userInfo = getUserInfo(request);
		logger.info("英文审刊-待审稿件明细Page:["+JSON.toJSONString(reqDto)+"]");
		ModelAndView mav = new ModelAndView("expert_enAuditPeriodicalDetailPage");
		logger.info(JSON.toJSONString(reqDto));
		/**
		 * 查询期刊下所有稿件明细
		 * */
		

		return mav;
	}
	
	/**
	 * auditArticleEnDetailPage
	 * 审核稿件打开稿件明细页
	 */
	@RequestMapping(value="/auditArticleEnDetailPage")
	public ModelAndView auditArticleEnPage(HttpServletRequest request,
			@ModelAttribute BizPeriodical reqDto) {
		UserInfo userInfo = getUserInfo(request);
		logger.info("英文审刊-稿件Page:["+JSON.toJSONString(reqDto)+"]");
		ModelAndView mav = new ModelAndView("expert_auditArticleEnDetailPage");
		logger.info(JSON.toJSONString(reqDto));
		/**
		 * 查询稿件明细/需要下载稿件
		 * periodical_details&article_info&article_attachment_info
		 * */
		

		return mav;
	}
	
	/**
	 * toDownLoadArticlePage
	 * 下载
	 */
	@RequestMapping(value="/toDownLoadArticlePage")
	public ModelAndView toDownLoadArticlePage(HttpServletRequest request,
			@ModelAttribute BizPeriodical reqDto) {
		UserInfo userInfo = getUserInfo(request);
		logger.info("英文审刊-稿件审核:["+JSON.toJSONString(reqDto)+"]");
		ModelAndView mav = new ModelAndView("redirect:../expert/auditArticleEnDetailPage");
		logger.info(JSON.toJSONString(reqDto));
		/**
		 * 下载编辑&专家文件夹下稿件
		 * */
		

		return mav;
	}
	
	/**
	 * toEnAuditAgreePage
	 * 审核通过
	 */
	@RequestMapping(value="/toEnAuditAgreePage")
	public ModelAndView toEnAuditAgreePage(HttpServletRequest request,
			@ModelAttribute BizPeriodical reqDto) {
		UserInfo userInfo = getUserInfo(request);
		logger.info("英文审刊-稿件审核:["+JSON.toJSONString(reqDto)+"]");
		ModelAndView mav = new ModelAndView("redirect:../expert/auditPeriodicalDetailPage");
		logger.info(JSON.toJSONString(reqDto));
		/**
		 * 审核通过
		 * 
		 * 复制一份信息attachment_info
		 * */
		

		return mav;
	}
	
	
	/**
	 * toEnAuditDisagreePage
	 * 审核不通过
	 */
	@RequestMapping(value="/toEnAuditDisagreePage")
	public ModelAndView toEnAuditDisagreePage(HttpServletRequest request,
			@ModelAttribute BizPeriodical reqDto) {
		UserInfo userInfo = getUserInfo(request);
		logger.info("英文审刊-稿件审核不通过:["+JSON.toJSONString(reqDto)+"]");
		ModelAndView mav = new ModelAndView("redirect:../expert/auditPeriodicalDetailPage");
		logger.info(JSON.toJSONString(reqDto));
		/**
		 * 审核不通过
		 * */
		
		/**
		 * 向英文专家显示上传按钮
		 * 将英文专家上传的附件保存到attachment_info
		 * */

		return mav;
	}
}
