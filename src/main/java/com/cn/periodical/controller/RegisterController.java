package com.cn.periodical.controller;

import javax.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import com.cn.periodical.enums.RoleIdEnums;
import com.cn.periodical.enums.SystemIdEnums;
import com.cn.periodical.request.RegisteRequestDto;

@Controller
@RequestMapping("/register")
public class RegisterController {

	private static final Logger logger = LoggerFactory.getLogger(RegisterController.class);
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
			HttpServletRequest request) {
		logger.info("email["+registeRequestDto.getEmail()+"]");
		logger.info("证件类型：["+registeRequestDto.getCertifiType()+"]");
		ModelAndView mav =null;
		String systemId = request.getParameter("systemId");
//		if(SystemIdEnums.EDIT_SYS.getCode().equals(systemId)){
//			//编辑
//			String roleId="1007";
//			if(RoleIdEnums.ARTICLE_EDITOR.getCode().equals(roleId)){
//				mav = new ModelAndView("editor_area");
//				mav.addObject("roleId",roleId);
//				return mav;
//			}else if(RoleIdEnums.SUBSCRIBE_EDITOR.getCode().equals(roleId)){
//				mav = new ModelAndView("editor_area");
//				mav.addObject("roleId",roleId);
//
//				return mav;
//			}else if(RoleIdEnums.AD_EDITOR.getCode().equals(roleId)){
//				mav = new ModelAndView("editor_area");
//				mav.addObject("roleId",roleId);
//				return mav;
//			}
//		}else if(SystemIdEnums.EXPERT_SYS.getCode().equals(systemId)){
//			//专家
//			String role_id="1004";
//			if(RoleIdEnums.EN_EXPERT.getCode().equals(role_id)){
//				mav = new ModelAndView("expert_en_area");
//				return mav;
//			}else if(RoleIdEnums.CN_EXPERT.getCode().equals(role_id)){
//				mav = new ModelAndView("expert_cn_area");
//				return mav;
//			}
//		}else if(SystemIdEnums.AUTHOR_SYS.getCode().equals(systemId)){
//			//作者
//			mav = new ModelAndView("author_area");
////			mav.addObject("userId", attributeValue);
//			return mav;
//		}else if(SystemIdEnums.READER_SYS.getCode().equals(systemId)){
//			//读者
//			/**
//			 * 需区分省所/个人登录
//			 * */
//			String role_id="1002";
//			if(RoleIdEnums.READER_P.getCode().equals(role_id)){
//				mav = new ModelAndView("reader_p_area");
//				return mav;
//			}else if(RoleIdEnums.READER_E.getCode().equals(role_id)){
//				mav = new ModelAndView("author_area");
//				return mav;
//			}
//		}else{
			/**
			 * 跳转首页
			 * */
			mav = new ModelAndView("portal");
			return mav;
//		}
//		return mav;
	}
}
