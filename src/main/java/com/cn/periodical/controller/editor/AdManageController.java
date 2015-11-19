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
import com.cn.periodical.pojo.BizAd;
import com.cn.periodical.pojo.UserInfo;
/**
 * 广告编辑-广告管理Controller
 * */
@Controller
public class AdManageController extends EditorController{
	
	private static final Logger logger = LoggerFactory.getLogger(AdManageController.class);
	/**
	 * toAdManagerPage
	 * 广告管理
	 */
	@RequestMapping(value="/toAdManagerPage",method = RequestMethod.GET)
	public ModelAndView toAdManagerPage(HttpServletRequest request,@ModelAttribute BizAd ad) {
		UserInfo userInfo = getUserInfo(request);
		logger.info("广告管理首页Page in:[]");
		ModelAndView mav = new ModelAndView("editor_adManagerPage");
		/**
		 * 广告首页查询
		 * 查询条件:
		 * adName=广告名称;concilName=理事会名称;concilType=理事会类型
		 * registTime=注册时间;adType=广告类型;trialNo=广审号
		 * contractStartTime=合同开始日期;contractEndTime=合同结束日期
		 * 
		 * 查询一个list列表,页面展示用
		 * */
		
		
		
		logger.info("广告管理首页Page out:[]");
		return mav;
	}
	
	
	@RequestMapping(value = "/toAdInfoAdd", method = RequestMethod.GET)
	public ModelAndView toAdInfoAdd() {
		ModelAndView mav = new ModelAndView("editor_adManagerDetailPage");

		return mav;
	}
	
	/**
	 * 保存广告信息
	 */
	@RequestMapping(value = "/toSaveAdInfo", method = { RequestMethod.POST })
	public ModelAndView saveAdInfo() {
//		ModelAndView mav = new ModelAndView("redirect:../editor/toAdManagerPage");
//		mav.addObject("userId", "ad");
//		logger.info("保存广告信息入参:["+JSON.toJSONString(councilInfo)+"]");
//		try {
////			adCouncilManagerService.saveCouncilInfo(councilInfo);
//			return mav;
//		} catch (Exception e) {
//			//记录错误日志
//			logger.error("保存广告信息异常!", e);
//			return new ModelAndView("error");
//		}
		return null;
	}
	
	
	/**
	 * 广告单条记录查询
	 * */
	@RequestMapping(value = "/toQrySingleAdInfo")
	public ModelAndView toQrySingleAdInfo(@RequestParam("adId") String adId) {
		ModelAndView mav = new ModelAndView("redirect:../editor/toAdInfoEdit");

		
		return mav;
	}
	
	/**
	 * 广告编辑页面
	 * */
	@RequestMapping(value = "/toAdInfoEdit")
	public ModelAndView toAdInfoEdit() {
		ModelAndView mav = new ModelAndView("editor_adManagerEditPage");

		return mav;
	}
	
	/**
	 * 广告编辑保存Action
	 * */
	@RequestMapping(value = "/toSaveAdInfoEdit")
	public ModelAndView toSaveAdInfoEdit() {
		ModelAndView mav = new ModelAndView("redirect:../editor/toAdManagerPage");

		return mav;
	}
}
