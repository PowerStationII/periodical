package com.cn.periodical.controller;

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

import com.cn.periodical.enums.RoleIdEnums;
import com.cn.periodical.enums.SystemIdEnums;
import com.cn.periodical.pojo.EditorAreaInfos;
import com.cn.periodical.pojo.UserInfo;
import com.cn.periodical.service.LoginService;
/**
 * 登录Controller
 * */
@Controller
public class LoginController {

	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);
	
	@Autowired
	LoginService loginService;
	
	/**
	 * 跳转到登录页面
	 */
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView login(@RequestParam("systemId") String systemId, @RequestParam("roleId") String roleId,HttpServletRequest request) {
		logger.info("登录系统systemId:[" + systemId + "]");
		ModelAndView mav = new ModelAndView("login");
		mav.addObject("systemId", systemId);
		mav.addObject("roleId", roleId);
		return mav;
	}

	/**
	 * 登录
	 * method = RequestMethod.POST
	 */
	@RequestMapping(value="/toLogin")
	public ModelAndView toLogin(@RequestParam(required = true, value="email") String email,
			@RequestParam(required = true, value="password") String password, 
			HttpServletRequest request) {
		logger.info("登录名["+email+"]&&登录密码["+password+"]");
		ModelAndView mav =null;
		String systemId = request.getParameter("systemId");
		/**
		 * 1,验证用户名是否存在[USER_INFO]
		 * 2,验证用户密码是否正确
		 * 3,判断传入systemId与用户的systemId是否相等
		 * 4,根据role_id跳转不同的4个vm页面
		 * */
		if(SystemIdEnums.EDIT_SYS.getCode().equals(systemId)){
			//编辑
			String roleId="1007";
			if(RoleIdEnums.ARTICLE_EDITOR.getCode().equals(roleId)){
				mav = new ModelAndView("editor_area");
				UserInfo userInfo=null;
				try{
//					userInfo =loginService.queryUserInfo(email, password, "", "");	
//					if(userInfo==null){
//						mav=new ModelAndView("error");
//						return mav;
//					}
//					mav.addObject("userId", userInfo.getUserId());
					mav.addObject("roleId",roleId);
					mav.addObject("userId","test");
					/**
					 * TODO:稿件编辑工作区需要展示稿件统计信息
					 * */
					List<EditorAreaInfos> list = loginService.queryArticleInfos("", "");
					mav.addObject("list", list);
					return mav;
				}catch(Exception e){
					// TODO Auto-generated catch block
					e.printStackTrace();
					mav=new ModelAndView("error");
					return mav;
				}
			}else if(RoleIdEnums.SUBSCRIBE_EDITOR.getCode().equals(roleId)){
				mav = new ModelAndView("editor_area");
				mav.addObject("roleId",roleId);
				mav.addObject("userId", "test");
				return mav;
			}else if(RoleIdEnums.AD_EDITOR.getCode().equals(roleId)){
				mav = new ModelAndView("editor_area");
				mav.addObject("roleId",roleId);
				mav.addObject("userId", "test");
				
				
				
				
				return mav;
			}else if(RoleIdEnums.ISSUER.getCode().equals(roleId)){
				mav = new ModelAndView("editor_area");
				mav.addObject("roleId",roleId);
				mav.addObject("userId", "test");
				return mav;
			}
		}else if(SystemIdEnums.EXPERT_SYS.getCode().equals(systemId)){
			//专家
			
			String role_id="1004";
			if(RoleIdEnums.EN_EXPERT.getCode().equals(role_id)){
				mav = new ModelAndView("expert_area");
				mav.addObject("userId", "test");
				return mav;
			}else if(RoleIdEnums.CN_EXPERT.getCode().equals(role_id)){
				mav = new ModelAndView("expert_cn_area");
				return mav;
			}
		}else if(SystemIdEnums.AUTHOR_SYS.getCode().equals(systemId)){
			//作者
			try {
				mav = new ModelAndView("author_area");
				UserInfo userInfo=null;
				userInfo =loginService.queryUserInfo(email, password, "", "");	
				if(userInfo==null){
					mav=new ModelAndView("error");
					return mav;
				}
				mav.addObject("userId", userInfo.getUserId());
				mav.addObject("roleId", RoleIdEnums.AUTHOR.getCode());
				return mav;
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				mav=new ModelAndView("error");
				return mav;
			}
		}else if(SystemIdEnums.READER_SYS.getCode().equals(systemId)){
			//读者
			/**
			 * 需区分省所/个人登录
			 * */
			String role_id="1002";
			if(RoleIdEnums.READER_P.getCode().equals(role_id)){
				mav = new ModelAndView("reader_area");
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
