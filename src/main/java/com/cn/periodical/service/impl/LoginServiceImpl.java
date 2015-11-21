package com.cn.periodical.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cn.periodical.manager.ArticleInfoManager;
import com.cn.periodical.manager.AuthorInfoManager;
import com.cn.periodical.manager.PeriodicalInfoManager;
import com.cn.periodical.manager.UserInfoManager;
import com.cn.periodical.pojo.EditorAreaInfos;
import com.cn.periodical.pojo.PeriodicalInfo;
import com.cn.periodical.pojo.UserInfo;
import com.cn.periodical.pojo.UserInfoQuery;
import com.cn.periodical.service.LoginService;

@Service
public class LoginServiceImpl implements LoginService {

	@Autowired
	UserInfoManager userInfoManager;
	
	
	@Autowired 
	AuthorInfoManager authorInfoManager;
	
	@Autowired
	ArticleInfoManager articleInfoManager;
	
	@Autowired
	PeriodicalInfoManager periodicalInfoManager;
	
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

	public List<EditorAreaInfos> queryArticleInfos(String userId, String roleId) {
		// TODO Auto-generated method stub
		return articleInfoManager.queryArticleTotalInfos(null);
	}

	public List<PeriodicalInfo> queryPeriodicalInfos() {
		// TODO Auto-generated method stub
		List<PeriodicalInfo> periodicalInfos = periodicalInfoManager.queryList(null);
		return periodicalInfos;
	}
}
