package com.cn.periodical.service;

import com.cn.periodical.pojo.UserInfo;

public interface PInfoSettingService {

	public int updateSetting(UserInfo userInfo, Object obj);
	
	public int updatePw(UserInfo userInfo,String password);
	
	public Object queryObject(String userId);
	
	public UserInfo queryUserInfo(String userId);
}
