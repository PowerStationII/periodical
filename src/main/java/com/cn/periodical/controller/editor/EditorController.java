package com.cn.periodical.controller.editor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cn.periodical.pojo.UserInfo;

@Controller
@RequestMapping("/editor")
public class EditorController {
	
	public UserInfo userInfo=null;
	
	public UserInfo getUserInfo(HttpServletRequest request){
		userInfo = (UserInfo)request.getSession().getAttribute("userInfo");
		return userInfo;
	}
	
}
