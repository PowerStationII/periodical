package com.cn.periodical.controller.author;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.cn.periodical.manager.SectionInfoManager;
import com.cn.periodical.pojo.SectionInfo;
import com.cn.periodical.pojo.SectionInfoQuery;
import com.cn.periodical.pojo.UserInfo;
import com.cn.periodical.request.AuthorContributeReqDto;
import com.cn.periodical.service.AuthorContributeService;
/**
 * 作者工作区-投稿
 * */
@Controller
public class ContributeController extends AuthorController{
	
	private static final Logger logger = LoggerFactory.getLogger(ContributeController.class);
	
	@Autowired
	AuthorContributeService contributeService;
	
	@Autowired
	SectionInfoManager sectionInfoManager;
	
	/**
	 * toContributePage
	 * author/toContributePage
	 * 去投稿页面
	 */
	@RequestMapping(value="/toContributePage")
	public ModelAndView toContributePage(HttpServletRequest request,HttpServletResponse response) {
		UserInfo userInfo = (UserInfo)request.getSession().getAttribute("userInfo");
		logger.info("投稿Page:["+JSON.toJSONString(userInfo)+"]");
		ModelAndView mav = new ModelAndView("contributePage");
		SectionInfoQuery query = new SectionInfoQuery();
		query.setPeriodicalId("20ea08451ad2405f9a833ba8644de463");
		query.setExtend1("N");
		List<SectionInfo> sectionInfos = sectionInfoManager.queryList(query);
		mav.addObject("infos", sectionInfos);
		return mav;
	}
	
	/**
	 * 投稿按钮
	 * HttpServletRequest request
	 * ,@RequestParam(value="files", required=true) MultipartFile[] files
	 * ,HttpServletRequest request
	 */
	@RequestMapping(value="/toContribute",method = RequestMethod.POST)
	public ModelAndView toContribute(@ModelAttribute(value="contributeRequestDto") AuthorContributeReqDto contributeRequestDto,
			@RequestParam(value="files", required=true) MultipartFile[] files,HttpServletRequest request) {
		logger.info("00000000000");
		logger.info(JSON.toJSONString(request.getSession().getAttribute("userInfo")));
		logger.info("00000000000");
		
		logger.info("提交投稿信息入参:["+JSON.toJSONString(contributeRequestDto)+"]&上传附件数量["+files.length+"]");
		ModelAndView mav = null;
		try{
	        mav=new ModelAndView("redirect:/author/toArticleQueryPage");
			contributeRequestDto.setUserId(getUserInfo(request).getUserId());
			contributeRequestDto.setRoleId(getUserInfo(request).getRoleId());
			/**
			 * 	保存投稿信息 
			 * */
			logger.info("保存新稿信息.....Start");
			contributeService.saveArticle(contributeRequestDto,files,request);
			logger.info("保存新稿信息.....end");
			return mav;
		}catch(Exception e){
			logger.info("投稿功能异常!!!!!!",e);
			mav=new ModelAndView("error");
			return mav;
		}
		
	}
}
