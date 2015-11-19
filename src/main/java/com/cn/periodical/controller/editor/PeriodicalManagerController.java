package com.cn.periodical.controller.editor;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.cn.periodical.pojo.BizEditor;
import com.cn.periodical.pojo.PeriodicalInfo;
import com.cn.periodical.pojo.UserInfo;

/**
 * 主编-期刊管理
 * */
@Controller
public class PeriodicalManagerController extends EditorController {

	public PeriodicalManagerController() {
		// TODO Auto-generated constructor stub
	}
	private static final Logger logger = LoggerFactory.getLogger(PeriodicalManagerController.class);
	/**
	 * toPeriodicalManagerPage
	 * 期刊管理
	 */
	@RequestMapping(value="/toPeriodicalManagerPage",method = RequestMethod.GET)
	public ModelAndView toPeriodicalManagerPage(HttpServletRequest request,@ModelAttribute BizEditor be) {
		UserInfo userInfo = getUserInfo(request);
		logger.info("期刊管理首页Page in:[]");
		ModelAndView mav = new ModelAndView("editor_periodicalManagerPage");
		/**
		 * 期刊管理首页查询
		 * 查询条件:
		 * periodicalName=期刊名称;
		 * 
		 * 查询一个list列表,页面展示用
		 * */
		
		
		
		logger.info("期刊管理管理首页Page out:[]");
		return mav;
	}
	
	@RequestMapping(value = "/toPeriodicalInfoAdd", method = RequestMethod.GET)
	public ModelAndView toPeriodicalInfoAdd(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView("editor_periodicalInfoDetailPage");

		return mav;
	}
	
	/**
	 * 保存编辑信息
	 */
	@RequestMapping(value = "/toSavePeriodicalInfo", method = { RequestMethod.POST })
	public ModelAndView toSavePeriodicalInfo(@ModelAttribute PeriodicalInfo eriodicalInfo) {
		ModelAndView mav = new ModelAndView("redirect:../editor/toEditorManagerPage");
		logger.info("新增期刊信息 in:["+JSON.toJSONString(eriodicalInfo)+"]");
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
}
