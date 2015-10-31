package com.cn.periodical.controller;

import java.util.Random;

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
public class LoginController {

	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);

	/**
	 * 跳转到登录页面
	 */
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView login(@RequestParam("systemId") String systemId, HttpServletRequest request) {
		logger.info("登录系统systemId:[" + systemId + "]");
		ModelAndView mav = new ModelAndView("login");
		mav.addObject("systemId", systemId);
		return mav;
	}

	/**
	 * 登录
	 * ,method = RequestMethod.POST
	 * 注册过来的时候,
	 * Spring MVC我还不知道怎么模拟post方式重定向到另一个controller中
	 * 暂时这样写!登录时前台页面必须校验密码是否已存在
	 */
	@RequestMapping(value="/toLogin")
	public ModelAndView toLogin(@RequestParam("email") String email,String password, 
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
