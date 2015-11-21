package com.cn.periodical.controller.editor;

import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.cn.periodical.manager.PeriodicalInfoManager;
import com.cn.periodical.pojo.PeriodicalInfo;
import com.cn.periodical.pojo.PeriodicalInfoQuery;
import com.cn.periodical.pojo.UserInfo;

/**
 * 主编-期刊管理
 * */
@Controller
public class PeriodicalManagerController extends EditorController {

	public PeriodicalManagerController() {
		// TODO Auto-generated constructor stub
	}
	
	@Autowired
	PeriodicalInfoManager periodicalInfoManager;
	private static final Logger logger = LoggerFactory.getLogger(PeriodicalManagerController.class);
	/**
	 * toPeriodicalManagerPage
	 * 期刊管理
	 */
	@RequestMapping(value="/toPeriodicalManagerPage")
	public ModelAndView toPeriodicalManagerPage(HttpServletRequest request,@ModelAttribute PeriodicalInfoQuery query) {
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
		List<PeriodicalInfo> lists = periodicalInfoManager.queryList(query);
		mav.addObject("list", lists);
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
	public ModelAndView toSavePeriodicalInfo(@ModelAttribute PeriodicalInfo periodicalInfo) {
		ModelAndView mav = new ModelAndView("redirect:../editor/toPeriodicalManagerPage");
		logger.info("新增期刊信息 in:["+JSON.toJSONString(periodicalInfo)+"]");
		try {
			/**
			 * 1,保存PeriodicalInfo到Periodical_info表
			 * */
			String periodicalId = UUID.randomUUID().toString().replaceAll("-", "");
			periodicalInfo.setPeriodicalId(periodicalId);
			periodicalInfoManager.savePeriodicalInfo(periodicalInfo);
		} catch (Exception e) {
			//记录错误日志
			logger.error("新增期刊信息异常!", e);
			return new ModelAndView("error");
		}
		return mav;
	}
}
