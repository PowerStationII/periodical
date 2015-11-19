package com.cn.periodical.controller.editor;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.cn.periodical.pojo.SectionInfo;
import com.cn.periodical.pojo.UserInfo;

/**
 * 主编-期刊栏目管理
 * */
@Controller
public class SectionManagerController extends EditorController {
	
	private static final Logger logger = LoggerFactory.getLogger(SectionManagerController.class);
	public SectionManagerController() {
		// TODO Auto-generated constructor stub
	}
	/**
	 * toSectionManagerPage
	 * 期刊栏目管理
	 */
	@RequestMapping(value="/toSectionManagerPage",method = RequestMethod.GET)
	public ModelAndView toSectionManagerPage(HttpServletRequest request,@RequestParam("periodicalId") String periodicalId) {
		UserInfo userInfo = getUserInfo(request);
		logger.info("期刊管理首页Page in:[]");
		ModelAndView mav = new ModelAndView("editor_sectionManagerPage");
		/**
		 * 期刊栏目管理首页查询
		 * 根据periodicalId查询该期刊下的所有栏目
		 * 
		 * 查询一个list列表,页面展示用
		 * */
		
		
		
		logger.info("期刊栏目管理首页Page out:[]");
		return mav;
	}
	
	@RequestMapping(value = "/toSectionInfoAdd", method = RequestMethod.GET)
	public ModelAndView toSectionInfoAdd(@RequestParam("periodicalId") String periodicalId) {
		ModelAndView mav = new ModelAndView("editor_SectionInfoDetailPage");

		return mav;
	}
	
	/**
	 * 保存栏目信息
	 */
	@RequestMapping(value = "/toSaveSectionInfo", method = { RequestMethod.POST })
	public ModelAndView toSaveSectionInfo(@ModelAttribute SectionInfo sectionInfo) {
		ModelAndView mav = new ModelAndView("redirect:../editor/toSectionManagerPage");
		logger.info("新增期刊下栏目信息 in:["+JSON.toJSONString(sectionInfo)+"]");
		try {
			/**
			 * 1,保存PeriodicalInfo到Periodical_info表
			 * */
			
			
		} catch (Exception e) {
			//记录错误日志
			logger.error("新增期刊信息异常!", e);
			return new ModelAndView("error");
		}
		return mav;
	}
	
	/**
	 * 删除栏目信息
	 */
	@RequestMapping(value = "/toDeleteSectionInfo")
	public ModelAndView toDeleteSectionInfo(@RequestParam("sectionId") String sectionId) {
		ModelAndView mav = new ModelAndView("redirect:../editor/toSectionManagerPage");
		logger.info("删除期刊下栏目信息 in:["+JSON.toJSONString(sectionId)+"]");
		try {
			/**
			 * 根据sectionId删除sectionInfo信息
			 * */
			
			
		} catch (Exception e) {
			//记录错误日志
			logger.error("删除期刊信息异常!", e);
			return new ModelAndView("error");
		}
		return mav;
	}
}
