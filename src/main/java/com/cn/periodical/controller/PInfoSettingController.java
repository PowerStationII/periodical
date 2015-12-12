package com.cn.periodical.controller;

import java.beans.PropertyEditorSupport;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.cn.periodical.enums.SystemIdEnums;
import com.cn.periodical.pojo.AuthorInfo;
import com.cn.periodical.pojo.EditorInfo;
import com.cn.periodical.pojo.ExpertInfo;
import com.cn.periodical.pojo.ReaderInfo;
import com.cn.periodical.pojo.UserInfo;
import com.cn.periodical.service.PInfoSettingService;

/**
 * 个人信息设置 修改个人信息 修改密码
 */
@Controller
@RequestMapping("/setting")
public class PInfoSettingController {

	private static final Logger logger = LoggerFactory.getLogger(PInfoSettingController.class);

	@Autowired
	PInfoSettingService pInfoSettingService;

	/**
	 * 跳转到修改个人信息页面
	 */
	@RequestMapping(value = "/toUpdateSettingPage", method = RequestMethod.GET)
	public ModelAndView toUpdateSettingPage(HttpServletRequest request, HttpServletResponse response) {
		UserInfo userInfo = (UserInfo) request.getSession().getAttribute("userInfo");
		logger.info("userId:[" + userInfo.getUserId() + "]修改个人信息");
		ModelAndView mav = new ModelAndView("updateSettingPage");
		Object obj = pInfoSettingService.queryObject(userInfo.getUserId());
		if (SystemIdEnums.AUTHOR_SYS.getCode().equals(userInfo.getSystemId())) {
			AuthorInfo authorInfo = (AuthorInfo) obj;
			mav.addObject("authorInfo", authorInfo);
		} else if (SystemIdEnums.EXPERT_SYS.getCode().equals(userInfo.getSystemId())) {
			ExpertInfo expertInfo = (ExpertInfo) obj;
			mav.addObject("expertInfo", expertInfo);
		} else if (SystemIdEnums.READER_SYS.getCode().equals(userInfo.getSystemId())) {
			 ReaderInfo readerInfo = (ReaderInfo)obj;
			 logger.info(JSON.toJSONString(readerInfo));
			 mav.addObject("readerInfo", readerInfo);
		} else if (SystemIdEnums.EDIT_SYS.getCode().equals(userInfo.getSystemId())) {
			EditorInfo editorInfo = (EditorInfo) obj;
			mav.addObject("editorInfo", editorInfo);
		} else {
			logger.info("系统不存在");
		}
		return mav;
	}

	/**
	 * 修改个人信息 //@ModelAttribute ReaderInfo readerInfo
	 */
	@RequestMapping(value = "/toUpdateSetting", method = RequestMethod.POST)
	public ModelAndView toUpdateSettingPage(@ModelAttribute AuthorInfo authorInfo,
			@ModelAttribute ExpertInfo expertInfo, 
			@ModelAttribute EditorInfo editorInfo, 
			@ModelAttribute ReaderInfo readerInfo,
			HttpServletRequest request) {
		UserInfo userInfo = (UserInfo) request.getSession().getAttribute("userInfo");
		logger.info("userId:[" + userInfo.getUserId() + "]修改个人信息");
		ModelAndView mav = new ModelAndView("updateSettingPage");
		if (SystemIdEnums.AUTHOR_SYS.getCode().equals(userInfo.getSystemId())) {
			pInfoSettingService.updateSetting(userInfo, authorInfo);
		} else if (SystemIdEnums.EXPERT_SYS.getCode().equals(userInfo.getSystemId())) {
			pInfoSettingService.updateSetting(userInfo, expertInfo);
		} else if (SystemIdEnums.READER_SYS.getCode().equals(userInfo.getSystemId())) {
			logger.info("readerInfo.............."+JSON.toJSONString(readerInfo));
			pInfoSettingService.updateSetting(userInfo, readerInfo);
		} else if (SystemIdEnums.EDIT_SYS.getCode().equals(userInfo.getSystemId())) {
			pInfoSettingService.updateSetting(userInfo, editorInfo);
		} else {
			logger.info("系统不存在,你修改啥");
		}
		return mav;
	}

	/**
	 * 跳转到修改密码页面
	 */
	@RequestMapping(value = "/toUpdatePWPage", method = RequestMethod.GET)
	public ModelAndView toUpdatePWPage(HttpServletRequest request) {
		UserInfo userInfo = (UserInfo) request.getSession().getAttribute("userInfo");
		logger.info("userId:[" + userInfo.getUserId() + "]要重置密码");
		ModelAndView mav = new ModelAndView("updatePWPage");
		return mav;
	}

	/**
	 * 修改密码
	 */
	@RequestMapping(value = "/toUpdatePw", method = RequestMethod.POST)
	public ModelAndView toUpdatePw(HttpServletRequest request, HttpServletResponse response,@RequestParam("newPw") String newPw) {
		UserInfo userInfo = (UserInfo) request.getSession().getAttribute("userInfo");
		ModelAndView mav = new ModelAndView("updatePWPage");
		int i = pInfoSettingService.updatePw(userInfo, newPw);
		logger.info(i+"");
		if(i==1){
			try{
				response.setContentType("text/html; charset=utf-8");
			    PrintWriter out = response.getWriter();  
			    out.println("<html>");  
			    out.println("<script>");  
			    out.println("alert('密码重置成功,请重新登录');"); 
			    out.println("window.open ('/periodical-web/portal','_top')");  
			    out.println("</script>");  
			    out.println("</html>");  
			}catch(Exception e){
				e.printStackTrace();
			}
		}else{
			try{
				response.setContentType("text/html; charset=utf-8");
			    PrintWriter out = response.getWriter();  
			    out.println("<html>");  
			    out.println("<script>");  
			    out.println("alert('密码重置失败');"); 
			    out.println("window.open ('/periodical-web/portal','_top')");  
			    out.println("</script>");  
			    out.println("</html>");  
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		return mav;
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
