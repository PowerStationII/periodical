package com.cn.periodical.controller;

import java.io.PrintWriter;
import java.util.Date;
import java.util.List;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.cn.periodical.manager.ResetPasswordManager;
import com.cn.periodical.manager.UserInfoManager;
import com.cn.periodical.pojo.ResetPassword;
import com.cn.periodical.pojo.ResetPasswordQuery;
import com.cn.periodical.pojo.UserInfo;
import com.cn.periodical.pojo.UserInfoQuery;
import com.cn.periodical.utils.MailUtils;
import com.cn.periodical.utils.PropertiesInitManager;

/**
 * 忘记密码Controller
 */
@Controller
public class ResetPwdController {

	private static final Logger logger = LoggerFactory.getLogger(ResetPwdController.class);

	@Autowired
	ResetPasswordManager resetPasswordManager;
	@Autowired
	UserInfoManager userInfoManager;
	
	/**
	 * 重置密码
	 */
	@RequestMapping(value = "/resetPwd")
	public ModelAndView resetPwd(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView("resetPwd");
		return mav;
	}
	/**
	 * 发送重置密码邮件
	 * */
	@RequestMapping(value = "/toReset")
	public ModelAndView toReset(HttpServletRequest request,String email,HttpServletResponse response) {
		ModelAndView mav = new ModelAndView("portal");
		
		ResetPassword resetPassword = new ResetPassword();
		resetPassword.setLogonName(email);
		resetPassword.setCreateTime(new Date());
		String randomStr = getRandomString(10);
		resetPassword.setRandomStr(randomStr);
		PropertiesInitManager.dataInit();
		String url = (String)PropertiesInitManager.PROPERTIES.get("url");
		String content="农业科学与管理网站,请点击链接进行密码重置<br/><a href="+url+"reset?logonName="+email+"&randomStr="+randomStr+">重置密码</a>";
				
		if(MailUtils.sendMail(email,content)){
			//发送密码重置邮件成功
			resetPassword.setExtend1("Y");
		}else{
			resetPassword.setExtend1("N");
		}
		//reset?logonName=&randomStr=
		resetPasswordManager.saveResetPassword(resetPassword);
		try{
			response.setContentType("text/html; charset=utf-8");
		    PrintWriter out = response.getWriter();  
		    out.println("<html>");  
		    out.println("<script>");  
		    out.println("alert('密码重置邮件已发送,请登录邮箱进行密码重置');"); 
		    out.println("window.open ('/periodical-web/portal','_top')");  
		    out.println("</script>");  
		    out.println("</html>");  
		}catch(Exception e){
			e.printStackTrace();
		}
		return mav;
	}
	
	@RequestMapping(value = "/reset")
	public ModelAndView reset(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView("reInputPwd");
		
		String logonName = request.getParameter("logonName");
		String randomStr = request.getParameter("randomStr");
		ResetPasswordQuery query = new ResetPasswordQuery();
		query.setLogonName(logonName);
		query.setRandomStr(randomStr);
		List<ResetPassword> list = resetPasswordManager.queryList(query);
		if(list!=null && list.size()==1){
			mav.addObject("logonName", logonName);
			return mav;
		}else{
			return new ModelAndView("error");
		}
	}
	
	
	@RequestMapping(value = "/toUpdatePwd")
	public ModelAndView updatePwd(HttpServletRequest request,HttpServletResponse response,String logonName) {
		ModelAndView mav = new ModelAndView("portal");
		String password = request.getParameter("password");
		UserInfoQuery query = new UserInfoQuery();
		query.setLogonName(logonName);
		List<UserInfo> list = userInfoManager.queryList(query);
		UserInfo userInfo = list.get(0);
		userInfo.setId(userInfo.getId());
		userInfo.setLogonPwd(password);
		userInfoManager.saveUserInfo(userInfo);
		
		try{
			response.setContentType("text/html; charset=utf-8");
		    PrintWriter out = response.getWriter();  
		    out.println("<html>");  
		    out.println("<script>");  
		    out.println("alert('密码重置成功');"); 
		    out.println("window.open ('/periodical-web/portal','_top')");  
		    out.println("</script>");  
		    out.println("</html>");  
		}catch(Exception e){
			e.printStackTrace();
		}
		return mav;
	}
	
	
	
	public static String getRandomString(int length) { 
		//length表示生成字符串的长度
	    String base = "abcdefghijklmnopqrstuvwxyz0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";   
	    Random random = new Random();   
	    StringBuffer sb = new StringBuffer();   
	    for (int i = 0; i < length; i++) {   
	        int number = random.nextInt(base.length());   
	        sb.append(base.charAt(number));   
	    }   
	    return sb.toString();   
	 } 
	
	public static void main(String[] args){
		System.out.println(getRandomString(6));
	}
}
