package com.cn.periodical.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cn.periodical.manager.AuthorInfoManager;
import com.cn.periodical.manager.UserInfoManager;
import com.cn.periodical.pojo.UserInfo;
import com.cn.periodical.pojo.UserInfoQuery;
import com.cn.periodical.service.LoginService;

@Service
public class LoginServiceImpl implements LoginService {

	@Autowired
	UserInfoManager userInfoManager;
	
	
	@Autowired 
	AuthorInfoManager authorInfoManager;
	
	public LoginServiceImpl() {
		// TODO Auto-generated constructor stub
	}

	public UserInfo queryUserInfo(String email, String password, String systmeId, String roleId) throws Exception {
		// TODO Auto-generated method stub
		UserInfoQuery userInfoQuery =  new UserInfoQuery();
		userInfoQuery.setLogonName(email);
		userInfoQuery.setLogonPwd(password);
		List<UserInfo> list = userInfoManager.queryList(userInfoQuery);
		return list.get(0);
	}

}
