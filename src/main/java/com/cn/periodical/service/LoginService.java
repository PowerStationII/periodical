package com.cn.periodical.service;

import java.util.List;

import com.cn.periodical.pojo.EditorAreaInfos;
import com.cn.periodical.pojo.UserInfo;

public interface LoginService {

	public UserInfo queryUserInfo(String email,String password,String systmeId,String roleId) throws Exception;
	
	public List<EditorAreaInfos> queryArticleInfos(String userId,String roleId);
	 
}
