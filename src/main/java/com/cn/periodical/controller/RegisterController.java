package com.cn.periodical.controller;

import java.io.InputStream;
import java.net.URL;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.httpclient.util.HttpURLConnection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.alibaba.fastjson.JSON;
import com.cn.periodical.enums.SystemIdEnums;
import com.cn.periodical.request.RegisteRequestDto;
import com.cn.periodical.service.RegisterService;

@Controller
@RequestMapping("/register")
public class RegisterController {

	private static final Logger logger = LoggerFactory.getLogger(RegisterController.class);
	@Autowired
	RegisterService registerService;
	
	/**
	 * 跳转到注册页面
	 */
	@RequestMapping(value = "/toRegister", method = RequestMethod.GET)
	public ModelAndView toRegister(@RequestParam("systemId") String systemId, HttpServletRequest request) {
		logger.info("跳转去注册页面systemId:[" + systemId + "]");
		ModelAndView mav = new ModelAndView("registered");
		mav.addObject("systemId", systemId);
		return mav;
	}

	/**
	 * 注册
	 */
	@RequestMapping(value="/register",method = RequestMethod.POST)
	public ModelAndView register(RegisteRequestDto registeRequestDto,
			RedirectAttributes attr) {
		logger.info("++++++++++++++++++++");
		logger.info(JSON.toJSONString(registeRequestDto));
		logger.info("++++++++++++++++++++");
		ModelAndView mav =null;
		String systemId = registeRequestDto.getSystemId();
		logger.info(systemId);
		
		if(SystemIdEnums.EDIT_SYS.getCode().equals(systemId)){
//			//编辑
//			String roleId="1007";
//			if(RoleIdEnums.ARTICLE_EDITOR.getCode().equals(roleId)){
//				mav = new ModelAndView("editor_area");
//				mav.addObject("roleId",roleId);
////				return mav;
//			}else if(RoleIdEnums.SUBSCRIBE_EDITOR.getCode().equals(roleId)){
//				mav = new ModelAndView("editor_area");
//				mav.addObject("roleId",roleId);
//
////				return mav;
//			}else if(RoleIdEnums.AD_EDITOR.getCode().equals(roleId)){
//				mav = new ModelAndView("editor_area");
//				mav.addObject("roleId",roleId);
////				return mav;
//			}
		}else if(SystemIdEnums.EXPERT_SYS.getCode().equals(systemId)){
//			//专家
//			String role_id="1004";
//			if(RoleIdEnums.EN_EXPERT.getCode().equals(role_id)){
//				mav = new ModelAndView("expert_en_area");
////				return mav;
//			}else if(RoleIdEnums.CN_EXPERT.getCode().equals(role_id)){
//				mav = new ModelAndView("expert_cn_area");
////				return mav;
//			}
		}else if(SystemIdEnums.AUTHOR_SYS.getCode().equals(systemId)){//作者
			/**
			 * 保存注册信息
			 * */
			registerService.add(registeRequestDto);
			
//			mav = new ModelAndView("redirect:/toLogin?email=" + registeRequestDto.getEmail() + "&password="
//					+ registeRequestDto.getPassword());
			mav = new ModelAndView("redirect:/toLogin");
			mav.addObject("email",registeRequestDto.getEmail());
//			mav.addObject("password",registeRequestDto.getPassword());
			mav.addObject("systemId", systemId);
			return mav;
		}else if(SystemIdEnums.READER_SYS.getCode().equals(systemId)){
//			//读者
//			/**
//			 * 需区分省所/个人登录
//			 * */
//			String role_id="1002";
//			if(RoleIdEnums.READER_P.getCode().equals(role_id)){
//				mav = new ModelAndView("reader_p_area");
////				return mav;
//			}else if(RoleIdEnums.READER_E.getCode().equals(role_id)){
//				mav = new ModelAndView("author_area");
////				return mav;
//			}
		}else{
//			/**
//			 * 跳转首页
//			 * */
//			mav = new ModelAndView("portal");
////			return mav;
		}
//		return new ModelAndView("error");
		return null;
	}
}
