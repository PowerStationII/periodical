package com.cn.periodical.controller.expert;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cn.periodical.pojo.UserInfo;

@Controller
@RequestMapping("/expert")
public class ExpertController {
	public UserInfo userInfo=null;
	
	public UserInfo getUserInfo(HttpServletRequest request){
		userInfo = (UserInfo)request.getSession().getAttribute("userInfo");
		return userInfo;
	}
}
