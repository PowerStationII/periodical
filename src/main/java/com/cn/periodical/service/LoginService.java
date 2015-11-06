package com.cn.periodical.service;

import com.cn.periodical.pojo.UserInfo;

public interface LoginService {

	public UserInfo queryUserInfo(String email,String password,String systmeId,String roleId) throws Exception;
	
	 
}
