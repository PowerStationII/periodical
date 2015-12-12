package com.cn.periodical.controller;

import java.beans.PropertyEditorSupport;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import com.alibaba.fastjson.JSON;
import com.cn.periodical.enums.RoleIdEnums;
import com.cn.periodical.enums.SystemIdEnums;
import com.cn.periodical.request.RegisteRequestDto;
import com.cn.periodical.service.RegisterService;
/**
 * 系统注册Controller
 * */
@Controller
public class RegisterController {

	private static final Logger logger = LoggerFactory.getLogger(RegisterController.class);
	@Autowired
	RegisterService registerService;
	
	/**
	 * 跳转到注册页面
	 */
	@RequestMapping(value = "/toRegister", method = RequestMethod.GET)
	public ModelAndView toRegister(@RequestParam("systemId") String systemId, 
			@RequestParam("roleId") String roleId ,HttpServletRequest request) {
		logger.info("跳转去注册页面systemId:[" + systemId + "]&roleId["+roleId+"]");
		ModelAndView mav = new ModelAndView("registered");
		mav.addObject("systemId", systemId);
		mav.addObject("roleId", roleId);
		return mav;
	}
	
	@RequestMapping(value = "/toReaderRegister", method = RequestMethod.GET)
	public ModelAndView toReaderRegister(@RequestParam("systemId") String systemId, 
			@RequestParam("roleId") String roleId ,HttpServletRequest request) {
		logger.info("跳转去读者注册页面systemId:[" + systemId + "]&roleId["+roleId+"]");
		ModelAndView mav = new ModelAndView("readerRegistered");
		mav.addObject("systemId", systemId);
		mav.addObject("roleId", roleId);
		return mav;
	}

	/**
	 * 注册
	 */
	@RequestMapping(value="/register",method = RequestMethod.POST)
	public ModelAndView register(RegisteRequestDto registeRequestDto) {
		logger.info("系统注册入参:["+JSON.toJSONString(registeRequestDto)+"]");
		ModelAndView mav =null;
		String systemId = registeRequestDto.getSystemId();
		String roleId = registeRequestDto.getRoleId();
		
		
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
			int i = registerService.addAuthor(registeRequestDto);
			logger.info(i+"");
			if(i==0){
				mav = new ModelAndView("error");
				return mav;
			}
			mav = new ModelAndView("forward:/toLogin");
			mav.addObject("email",registeRequestDto.getEmail());
			mav.addObject("password",registeRequestDto.getPassword());
			mav.addObject("systemId", systemId);
			mav.addObject("roleId", roleId);
			return mav;
		}else if(SystemIdEnums.READER_SYS.getCode().equals(systemId)){
			/**
			 * 需区分省所/个人登录
			 * */
			if(RoleIdEnums.READER_P.getCode().equals(roleId)){
				int i = registerService.addReader(registeRequestDto);
				logger.info(i+"");
				if(i==0){
					mav = new ModelAndView("error");
					return mav;
				}
				mav = new ModelAndView("forward:/toLogin");
				mav.addObject("email",registeRequestDto.getEmail());
				mav.addObject("password",registeRequestDto.getPassword());
				return mav;
			}else if(RoleIdEnums.READER_E.getCode().equals(roleId)){
				int i = registerService.addAuthor(registeRequestDto);
				logger.info(i+"");
				if(i==0){
					mav = new ModelAndView("error");
					return mav;
				}
				mav = new ModelAndView("forward:/toLogin");
				mav.addObject("email",registeRequestDto.getEmail());
				mav.addObject("password",registeRequestDto.getPassword());
				return mav;
			}
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
	
	
	/**
	 * 注册
	 */
	@RequestMapping(value="/toVerifyLoginName")
	@ResponseBody
	public boolean toVerifyLoginName(@RequestParam("loginName") String loginName) {
		logger.info("校验用户名是否已存在:["+loginName+"]");
		return registerService.queryLoginName(loginName);
	}
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.registerCustomEditor(Date.class, new DateEditor());
		binder.registerCustomEditor(String.class, new StringEditor());
		binder.registerCustomEditor(Integer.class, new IntegerEditor());
		binder.registerCustomEditor(Long.class, new LongEditor());
		binder.registerCustomEditor(Float.class, new FloatEditor());
		binder.registerCustomEditor(Double.class, new DoubleEditor());
		binder.registerCustomEditor(BigDecimal.class, new BigDecimalEditor());
	}
	
	class DateEditor extends PropertyEditorSupport {
		@Override
		public void setAsText(String text) throws IllegalArgumentException {
			if (text != null && !"".equals(text)) {
				SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
				try {
					setValue(dateFormat.parse(text));
				} catch (ParseException e) {
					setValue(null);
				}
			} else {
				setValue(null);
			}
		}
	}
	
	class StringEditor extends PropertyEditorSupport {
		@Override
		public void setAsText(String text) throws IllegalArgumentException {
			if (text != null && !"".equals(text)) {
				setValue(text);
			} else {
				setValue(null);
			}
		}
	}
	
	class IntegerEditor extends PropertyEditorSupport {
		@Override
		public void setAsText(String text) throws IllegalArgumentException {
			if (text != null && !"".equals(text)) {
				setValue(Integer.valueOf(text));
			} else {
				setValue(null);
			}
		}
	}
	
	class LongEditor extends PropertyEditorSupport {
		@Override
		public void setAsText(String text) throws IllegalArgumentException {
			if (text != null && !"".equals(text)) {
				setValue(Long.valueOf(text));
			} else {
				setValue(null);
			}
		}
	}
	
	class FloatEditor extends PropertyEditorSupport {
		@Override
		public void setAsText(String text) throws IllegalArgumentException {
			if (text != null && !"".equals(text)) {
				setValue(Float.valueOf(text));
			} else {
				setValue(null);
			}
		}
	}
	
	class DoubleEditor extends PropertyEditorSupport {
		@Override
		public void setAsText(String text) throws IllegalArgumentException {
			if (text != null && !"".equals(text)) {
				setValue(Double.valueOf(text));
			} else {
				setValue(null);
			}
		}
	}
	
	class BigDecimalEditor extends PropertyEditorSupport {
		@Override
		public void setAsText(String text) throws IllegalArgumentException {
			if (text != null && !"".equals(text)) {
				setValue(BigDecimal.valueOf(Double.valueOf(text)));
			} else {
				setValue(null);
			}
		}
	}
	
	
}
