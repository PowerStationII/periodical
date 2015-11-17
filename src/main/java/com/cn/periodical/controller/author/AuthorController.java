package com.cn.periodical.controller.author;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cn.periodical.pojo.UserInfo;

@Controller
@RequestMapping("/author")
public class AuthorController {
	
	public UserInfo userInfo=null;
	
	public UserInfo getUserInfo(HttpServletRequest request){
		userInfo = (UserInfo)request.getSession().getAttribute("userInfo");
		return userInfo;
	}
	
	

}
