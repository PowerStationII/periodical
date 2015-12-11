package com.cn.periodical.controller;

import java.text.MessageFormat;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.cn.periodical.enums.ExceptionEnums;
import com.cn.periodical.enums.RoleIdEnums;
import com.cn.periodical.enums.SystemIdEnums;
import com.cn.periodical.pojo.EditorAreaInfos;
import com.cn.periodical.pojo.PeriodicalInfo;
import com.cn.periodical.pojo.UserInfo;
import com.cn.periodical.service.LoginService;

/**
 * 登录Controller
 */
@Controller
public class LoginController {

	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);

	@Autowired
	LoginService loginService;

	/**
	 * 跳转到登录页面
	 */
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView login(@RequestParam("systemId") String systemId, @RequestParam("roleId") String roleId,
			HttpServletRequest request) {
		logger.info("登录系统systemId:[" + systemId + "]");
		ModelAndView mav = null;
		
		if(SystemIdEnums.READER_SYS.getCode().equals(systemId)){
			mav = new ModelAndView("login_reader");
		}else if(SystemIdEnums.AUTHOR_SYS.getCode().equals(systemId)){
			mav = new ModelAndView("login_author");
		}else if(SystemIdEnums.EDIT_SYS.getCode().equals(systemId)){
			mav = new ModelAndView("login_editor");
		}else if(SystemIdEnums.EXPERT_SYS.getCode().equals(systemId)){
			mav = new ModelAndView("login_expert");
		}else{
			mav=new ModelAndView("error");
		}
		mav.addObject("systemId", systemId);
		mav.addObject("roleId", roleId);
		return mav;
	}

	/**
	 * 登录
	 */
	@RequestMapping(value = "/toLogin")
	public ModelAndView toLogin(@RequestParam(required = true, value = "email") String email,
			@RequestParam(required = true, value = "password") String password, HttpServletRequest request) {
		logger.info("登录名[" + email + "]&&登录密码[" + password + "]");
		ModelAndView mav = null;
		String systemId = request.getParameter("systemId");
		//查询userInfo信息
		UserInfo userInfo = null;
		try {
			userInfo = loginService.queryUserInfo(email, password, "", "");
			if (userInfo == null) {
				mav = new ModelAndView("error");
				mav.addObject("message", ExceptionEnums.USER_NOT_EXSITS.getName());
				return mav;
			}
			if(!systemId.equals(userInfo.getSystemId())){
				mav = new ModelAndView("error");
				int sysId = Integer.valueOf(systemId);
				switch (sysId){
					case 111:  
						mav.addObject("message", MessageFormat.format(ExceptionEnums.USER_SYSTEM_NOT_MATCH.getName(),SystemIdEnums.EDIT_SYS.getName()));
					case 222:
						mav.addObject("message", MessageFormat.format(ExceptionEnums.USER_SYSTEM_NOT_MATCH.getName(),SystemIdEnums.EXPERT_SYS.getName()));
					case 333:
						mav.addObject("message", MessageFormat.format(ExceptionEnums.USER_SYSTEM_NOT_MATCH.getName(),SystemIdEnums.AUTHOR_SYS.getName()));
					case 444:
						mav.addObject("message", MessageFormat.format(ExceptionEnums.USER_SYSTEM_NOT_MATCH.getName(),SystemIdEnums.READER_SYS.getName()));
				}
				return mav;
			}
			logger.info(JSON.toJSONString(userInfo));
			request.getSession().setAttribute("userInfo", userInfo);
		} catch (Exception e) {
			mav = new ModelAndView("error");
			mav.addObject("message", e.getMessage());
			return mav;
		}

		if (SystemIdEnums.EDIT_SYS.getCode().equals(systemId)) {
			// 编辑
			String roleId = userInfo.getRoleId();
			if (RoleIdEnums.ARTICLE_EDITOR.getCode().equals(roleId)) {
				logger.info("编辑...");
				mav = new ModelAndView("editor_area");
				List<EditorAreaInfos> list = loginService.queryArticleInfos("", "");
				mav.addObject("list", list);
				return mav;
			} else if (RoleIdEnums.SUBSCRIBE_EDITOR.getCode().equals(roleId)) {
				mav = new ModelAndView("editor_area");
				return mav;
			} else if (RoleIdEnums.AD_EDITOR.getCode().equals(roleId)) {
				mav = new ModelAndView("editor_area");
				return mav;
			} else if (RoleIdEnums.ISSUER.getCode().equals(roleId)) {
				mav = new ModelAndView("editor_area");
				return mav;
			}else if (RoleIdEnums.EDITOR.getCode().equals(roleId)) {
				mav = new ModelAndView("editor_area");
				return mav;
			}
		} else if (SystemIdEnums.EXPERT_SYS.getCode().equals(systemId)) {
			// 专家
			String role_id = userInfo.getRoleId();
			if (RoleIdEnums.EN_EXPERT.getCode().equals(role_id)) {
				mav = new ModelAndView("expert_area");
				return mav;
			} else if (RoleIdEnums.CN_EXPERT.getCode().equals(role_id)) {
				mav = new ModelAndView("expert_area");
				return mav;
			}
		} else if (SystemIdEnums.AUTHOR_SYS.getCode().equals(systemId)) {
			// 作者
			mav = new ModelAndView("author_area");
			return mav;
		} else if (SystemIdEnums.READER_SYS.getCode().equals(systemId)) {
			// 读者:需区分省所/个人登录
			String roleId = userInfo.getRoleId();
			if (RoleIdEnums.READER_P.getCode().equals(roleId)) {
				mav = new ModelAndView("reader_area");
				List<PeriodicalInfo> infos = loginService.queryPeriodicalInfos();
				mav.addObject("list", infos);
				return mav;
			} else if (RoleIdEnums.READER_E.getCode().equals(roleId)) {
				mav = new ModelAndView("reader_area");
				return mav;
			}
		}
		mav = new ModelAndView("error");
		mav.addObject("message", ExceptionEnums.ENTER_NOT_EXSITS.getName());
		return mav;
	}
}
