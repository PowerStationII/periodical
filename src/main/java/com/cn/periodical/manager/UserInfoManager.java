package com.cn.periodical.manager;

import java.util.List;

import com.cn.periodical.pojo.UserInfo;
import com.cn.periodical.pojo.UserInfoPage;
import com.cn.periodical.pojo.UserInfoQuery;

public interface UserInfoManager {
	void saveUserInfo(UserInfo userInfo);

	UserInfo findUserInfoById(Long id);
	
	List<UserInfo> queryList(UserInfoQuery query);
	
	void deleteUserInfoById(Long id);
	
	void deleteUserInfo(UserInfoQuery query);
	
	UserInfoPage queryPageList(UserInfoQuery query);
}
