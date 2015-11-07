package com.cn.periodical.service;

import com.cn.periodical.pojo.UserInfo;

public interface PInfoSettingService {

	public int updateSetting(String userId,String roleId,Object obj);
	
	public int updatePw(String id,String password);
	
	public Object queryObject(String userId);
	
	public UserInfo queryUserInfo(String userId);
}
