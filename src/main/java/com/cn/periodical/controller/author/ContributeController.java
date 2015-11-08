package com.cn.periodical.controller.author;

import java.io.File;

import javax.servlet.http.HttpServletRequest;

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
import com.cn.periodical.request.AuthorContributeReqDto;
import com.cn.periodical.service.AuthorContributeService;
import com.cn.periodical.service.LoginService;
/**
 * 作者工作区-投稿
 * */
@Controller
public class ContributeController extends AuthorController{
	
	private static final Logger logger = LoggerFactory.getLogger(ContributeController.class);
	
	@Autowired
	AuthorContributeService contributeService;
	
	/**
	 * toContributePage
	 * author/toContributePage
	 * 去投稿页面
	 */
	@RequestMapping(value="/toContributePage",method = RequestMethod.GET)
	public ModelAndView toContributePage(@RequestParam("userId") String userId,
			@RequestParam("roleId") String roleId,
			HttpServletRequest request) {
		logger.info("投稿Page:["+userId+"]");
		ModelAndView mav = new ModelAndView("contributePage");
		mav.addObject("userId", userId);
		mav.addObject("roleId", roleId);
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
		logger.info("提交投稿信息入参:["+JSON.toJSONString(contributeRequestDto)+"]&上传附件数量["+files.length+"]");
		ModelAndView mav = null;
		try{
	        mav=new ModelAndView("author_area");//不能去这个页面
			mav.addObject("userId", contributeRequestDto.getUserId());
			mav.addObject("roleId", contributeRequestDto.getRoleId());
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
