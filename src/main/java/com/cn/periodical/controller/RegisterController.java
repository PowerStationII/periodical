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
		ModelAndView mav = new ModelAndView("editor_area");
//		mav.addObject("systemId", systemId);
		return mav;
	}

	/**
	 * 登录
	 */
	@RequestMapping(value="/toLogin",method = RequestMethod.POST)
	public ModelAndView toLogin(@RequestParam("email") String email,@RequestParam("password") String password, 
			HttpServletRequest request) {
		logger.info("登录名["+email+"]&&登录密码["+password+"]");
		ModelAndView mav =null;
		String systemId = request.getParameter("systemId");
		/**
		 * 1,验证用户名是否存在[USER_INFO]
		 * 2,验证用户密码是否正确
		 * 3,判断传入systemId与用户的systemId是否相等
		 * 4,根据role_id跳转不同的vm页面
		 * ps:待优化,页面左侧功能列表先写死.会多写等同于角色数量的vm页面!
		 * */
		if(SystemIdEnums.EDIT_SYS.getCode().equals(systemId)){
			//编辑
			String roleId="1007";
			if(RoleIdEnums.ARTICLE_EDITOR.getCode().equals(roleId)){
				mav = new ModelAndView("editor_area");
				mav.addObject("roleId",roleId);
				return mav;
			}else if(RoleIdEnums.SUBSCRIBE_EDITOR.getCode().equals(roleId)){
				mav = new ModelAndView("editor_area");
				mav.addObject("roleId",roleId);

				return mav;
			}else if(RoleIdEnums.AD_EDITOR.getCode().equals(roleId)){
				mav = new ModelAndView("editor_area");
				mav.addObject("roleId",roleId);
				return mav;
			}
		}else if(SystemIdEnums.EXPERT_SYS.getCode().equals(systemId)){
			//专家
			String role_id="1004";
			if(RoleIdEnums.EN_EXPERT.getCode().equals(role_id)){
				mav = new ModelAndView("expert_en_area");
				return mav;
			}else if(RoleIdEnums.CN_EXPERT.getCode().equals(role_id)){
				mav = new ModelAndView("expert_cn_area");
				return mav;
			}
		}else if(SystemIdEnums.AUTHOR_SYS.getCode().equals(systemId)){
			//作者
			mav = new ModelAndView("author_area");
//			mav.addObject("userId", attributeValue);
			return mav;
		}else if(SystemIdEnums.READER_SYS.getCode().equals(systemId)){
			//读者
			/**
			 * 需区分省所/个人登录
			 * */
			String role_id="1002";
			if(RoleIdEnums.READER_P.getCode().equals(role_id)){
				mav = new ModelAndView("reader_p_area");
				return mav;
			}else if(RoleIdEnums.READER_E.getCode().equals(role_id)){
				mav = new ModelAndView("author_area");
				return mav;
			}
		}else{
			/**
			 * 跳转首页
			 * */
			mav = new ModelAndView("portal");
			return mav;
		}
		return mav;
	}
}
