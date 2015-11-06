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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.alibaba.fastjson.JSON;
import com.cn.periodical.request.EditorAdCouncilManagerReqDto;
/**
 * 广告编辑-会员管理Controller
 * */
@Controller
public class AdCouncilManagerController extends EditorController{
	
	private static final Logger logger = LoggerFactory.getLogger(AdCouncilManagerController.class);
	/**
	 * toCouncilManagerPage
	 * 会员管理
	 */
	@RequestMapping(value="/toCouncilManagerPage",method = RequestMethod.GET)
	public ModelAndView toCouncilManagerPage(@RequestParam("userId") String userId,
			HttpServletRequest request) {
		logger.info("会员管理Page:["+userId+"]");
		ModelAndView mav = new ModelAndView("editor_councilManagerPage");
		mav.addObject("userId", userId);
		/**
		 * TODO:调用该页面查询按钮所调用method执行查询,对页面列表数据进行填充
		 * */
		
		
		
		
		return mav;
	}
	
	/**
	 * 会员管理-查询按钮
	 */
	@RequestMapping(value="/toCouncilManagerQry",method = RequestMethod.GET)
	public ModelAndView toCouncilManagerQry(@RequestParam("userId") String userId,
			@RequestParam("adCouncilManagerReqDto") EditorAdCouncilManagerReqDto adCouncilManagerReqDto) {
		logger.info("会员管理-查询入参:["+JSON.toJSONString(adCouncilManagerReqDto)+"&userId="+userId+"]");
		ModelAndView mav = new ModelAndView("editor_councilManagerPage");
		mav.addObject("userId", userId);
		
		
		
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
	public ModelAndView saveCouncilInfo(@ModelAttribute EditorAdCouncilManagerReqDto councilInfo, RedirectAttributes redirectAttributes) {
		ModelAndView mav = new ModelAndView("redirect:../editor/toCouncilManagerPage");
		mav.addObject("userId", "哎呦");
		logger.info("保存理事会信息入参:["+JSON.toJSONString(councilInfo)+"]");
//		try {
//			councilInfoManager.saveCouncilInfo(councilInfo);
//			redirectAttributes.addFlashAttribute("message", "保存成功!");
//		} catch (Exception e) {
//			//记录错误日志
//			logger.error("", e);
//			
//			if(councilInfo.getId() == null){
//				mav.setViewName("params/CouncilInfoAdd");
//			}else{
//				mav.addObject("pageInfo", councilInfo);
//				mav.setViewName("params/CouncilInfoEdit");
//			}
//			
//			redirectAttributes.addFlashAttribute("message", "保存失败:" + e.getMessage());
//		}
		
		return mav;
	}
	
}
