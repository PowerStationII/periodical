package com.cn.periodical.controller.editor;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.cn.periodical.pojo.CouncilInfo;
import com.cn.periodical.request.EditorAdCouncilManagerReqDto;
import com.cn.periodical.service.EditorAdCouncilManagerService;
/**
 * 广告编辑-会员管理Controller
 * */
@Controller
public class AdCouncilManagerController extends EditorController{
	
	private static final Logger logger = LoggerFactory.getLogger(AdCouncilManagerController.class);
	
	@Autowired
	EditorAdCouncilManagerService adCouncilManagerService;
	/**
	 * toCouncilManagerPage
	 * 会员管理
	 */
	@RequestMapping(value="/toCouncilManagerPage")
	public ModelAndView toCouncilManagerPage(@ModelAttribute EditorAdCouncilManagerReqDto reqDto) {
		logger.info("会员管理Page:["+JSON.toJSONString(reqDto)+"]");
		ModelAndView mav = new ModelAndView("editor_councilManagerPage");
		mav.addObject("userId", reqDto.getUserId());
		logger.info("++++++++++++");
		logger.info(reqDto.getCouncilType());
		logger.info("++++++++++++");
		/**
		 * TODO:调用该页面查询按钮所调用method执行查询,对页面列表数据进行填充
		 * */
		List<CouncilInfo> councilInfos = adCouncilManagerService.queryCouncilInfo(reqDto);
		mav.addObject("councilInfos", councilInfos);
		
		
		return mav;
	}
	
	/**
	 * 会员管理-查询按钮
	 */
	@RequestMapping(value="/toCouncilManagerQry",method = RequestMethod.GET)
	public ModelAndView toCouncilManagerQry(@RequestParam("userId") String userId,
			@ModelAttribute EditorAdCouncilManagerReqDto adCouncilManagerReqDto) {
		logger.info("会员管理-查询入参:["+JSON.toJSONString(adCouncilManagerReqDto)+"&userId="+userId+"]");
		ModelAndView mav = new ModelAndView("editor_councilManagerPage");
		mav.addObject("userId", userId);
		List<CouncilInfo> councilInfos = adCouncilManagerService.queryCouncilInfo(adCouncilManagerReqDto);
		mav.addObject("councilInfos", councilInfos);
		logger.info("会员管理-查询出参:["+userId+"]");
		return mav;
	}
	
	
	@RequestMapping(value = "/toCouncilInfoAdd", method = RequestMethod.GET)
	public ModelAndView toCouncilInfoAdd() {
		ModelAndView mav = new ModelAndView("editor_councilManagerDetailPage");

		return mav;
	}
	
	/**
	 * 保存数据
	 */
	@RequestMapping(value = "/toSaveCouncilInfo", method = { RequestMethod.POST })
	public ModelAndView saveCouncilInfo(@ModelAttribute EditorAdCouncilManagerReqDto councilInfo) {
		ModelAndView mav = new ModelAndView("redirect:../editor/toCouncilManagerPage");
		mav.addObject("userId", "哎呦");
		logger.info("保存理事会信息入参:["+JSON.toJSONString(councilInfo)+"]");
		try {
			adCouncilManagerService.saveCouncilInfo(councilInfo);
			return mav;
		} catch (Exception e) {
			//记录错误日志
			logger.error("保存理事会信息异常!", e);
			return new ModelAndView("error");
		}
		
	}
	
}
