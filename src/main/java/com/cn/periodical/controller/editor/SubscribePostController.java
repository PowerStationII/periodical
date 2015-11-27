package com.cn.periodical.controller.editor;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.cn.periodical.pojo.UserInfo;
/**
 * 发行编辑-期刊邮寄Controller
 * */
@Controller
public class SubscribePostController extends EditorController{
	
	private static final Logger logger = LoggerFactory.getLogger(SubscribePostController.class);
	/**
	 * toSubscribePostPage
	 * 邮寄管理
	 */
	@RequestMapping(value="/toSubscribePostPage",method = RequestMethod.GET)
	public ModelAndView toSubscribePostPage(HttpServletRequest request) {
		UserInfo userInfo = getUserInfo(request);
		logger.info("发行编辑-邮寄管理Page:["+userInfo.getUserId()+"]");
		ModelAndView mav = new ModelAndView("editor_subscribePostPage");
		
		
		return mav;
	}
	
	/**
	 * toExportReaderAddressInfo
	 * 导出读者订阅地址及信息
	 * periodical_distribute表
	 */
	@RequestMapping(value="/toExportReaderAddressInfo")
	public ModelAndView toExportReaderAddressInfo(HttpServletRequest request) {
		UserInfo userInfo = getUserInfo(request);
		logger.info("发行编辑-导出读者订阅地址信息Page:["+userInfo.getUserId()+"]");
		ModelAndView mav = new ModelAndView("editor_subscribePostPage");
		
		
		return mav;
	}
	
	/**
	 * toExportAuthorAddressInfo
	 * 导出作者订阅地址及信息
	 * author_info&address_info表
	 */
	@RequestMapping(value="/toExportAuthorAddressInfo")
	public ModelAndView toExportAuthorAddressInfo(HttpServletRequest request) {
		UserInfo userInfo = getUserInfo(request);
		logger.info("发行编辑-导出作者订阅信息Page:["+userInfo.getUserId()+"]");
		ModelAndView mav = new ModelAndView("editor_subscribePostPage");
		
		
		return mav;
	}
}
