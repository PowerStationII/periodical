package com.cn.periodical.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cn.periodical.enums.RoleIdEnums;
import com.cn.periodical.manager.AuthorInfoManager;
import com.cn.periodical.manager.UserInfoManager;
import com.cn.periodical.pojo.AuthorInfo;
import com.cn.periodical.pojo.AuthorInfoQuery;
import com.cn.periodical.pojo.UserInfo;
import com.cn.periodical.pojo.UserInfoQuery;
import com.cn.periodical.service.PInfoSettingService;

@Service
public class PInfoSettingServiceImpl implements PInfoSettingService {

	@Autowired
	UserInfoManager userInfoManager;
	
	@Autowired 
	AuthorInfoManager authorInfoManager;
	
	
	
	public PInfoSettingServiceImpl() {
		// TODO Auto-generated constructor stub
	}

	public int updateSetting(String userId,String roleId, Object obj) {
		// TODO Auto-generated method stub
		AuthorInfo authorInfo = (AuthorInfo)obj;
		authorInfoManager.saveAuthorInfo(authorInfo);
		return 0;
	}

	public int updatePw(String id,String password) {
		// TODO Auto-generated method stub
		UserInfo userInfo = userInfoManager.findUserInfoById(Long.valueOf(id));
		userInfo.setId(userInfo.getId());
		userInfo.setLogonPwd(password);
		userInfoManager.saveUserInfo(userInfo);
		return 0;
	}

	public Object queryObject(String userId) {
		// TODO Auto-generated method stub
		UserInfoQuery userInfoQuery = new UserInfoQuery();
		userInfoQuery.setUserId(userId);
		List<UserInfo> userInfos = userInfoManager.queryList(userInfoQuery);
		UserInfo userInfo = userInfos.get(0);
		if(RoleIdEnums.AUTHOR.getCode().equals(userInfo.getRoleId())){
			AuthorInfoQuery authorInfoQuery= new AuthorInfoQuery();
			authorInfoQuery.setAuthorId(userInfo.getRefId());
			List<AuthorInfo> authorInfos= authorInfoManager.queryList(authorInfoQuery);
			AuthorInfo authorInfo = authorInfos.get(0);
			return authorInfo;
		}else if(RoleIdEnums.READER_P.getCode().equals(userInfo.getRoleId())){
			//TODO:
		}
		return null;
	}

	public UserInfo queryUserInfo(String userId) {
		// TODO Auto-generated method stub
		UserInfoQuery userInfoQuery = new UserInfoQuery();
		userInfoQuery.setUserId(userId);
		List<UserInfo> userInfos = userInfoManager.queryList(userInfoQuery);
		UserInfo userInfo = userInfos.get(0);
		return userInfo;
	}

}
