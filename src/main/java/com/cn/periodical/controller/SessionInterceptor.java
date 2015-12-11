package com.cn.periodical.controller;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;


import com.cn.periodical.pojo.UserInfo;


public class SessionInterceptor extends HandlerInterceptorAdapter{

	public SessionInterceptor() {
		// TODO Auto-generated constructor stub
	}

	@Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		System.out.println("------------hahahahahhaah进来啦！！！");
		UserInfo session = (UserInfo) request.getSession().getAttribute("userInfo");
		if(session != null) {
			System.out.println("------------不为null 不用跳");
			return true;
		}
		else {
				response.setContentType("text/html; charset=utf-8");
			    PrintWriter out = response.getWriter();  
			    out.println("<html>");  
			    out.println("<script>");  
			    out.println("alert('会话已过期，请重新登录！');"); 
			    out.println("window.open ('/periodical-web/portal','_top')");  
			    out.println("</script>");  
			    out.println("</html>");  
		}
		return false;
     }
	

}
