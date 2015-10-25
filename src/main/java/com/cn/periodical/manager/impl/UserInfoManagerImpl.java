package com.cn.periodical.manager.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.cn.periodical.dao.UserInfoDao;
import com.cn.periodical.manager.UserInfoManager;
import com.cn.periodical.pojo.UserInfo;
import com.cn.periodical.pojo.UserInfoPage;
import com.cn.periodical.pojo.UserInfoQuery;
import com.cn.periodical.utils.Pagenation;

@Component("userInfoManager")
public class UserInfoManagerImpl implements UserInfoManager {
	
	@Autowired
	@Qualifier("userInfoDao")
	private UserInfoDao userInfoDao;
	
	
	public void saveUserInfo(UserInfo userInfo) {
		if (userInfo.getId() == null) {
			userInfoDao.insertSelective(userInfo);
		} else {
			userInfoDao.updateByPrimaryKeySelective(userInfo);
		}
	}
	
	
	public UserInfo findUserInfoById(Long id) {
		return userInfoDao.selectByPrimaryKey(id);
	}
	
	
	public List<UserInfo> queryList(UserInfoQuery query) {
		return userInfoDao.selectByExample(query);
	}
	
	
	public void deleteUserInfoById(Long id) {
		userInfoDao.deleteByPrimaryKey(id);
	}
	
	
	public void deleteUserInfo(UserInfoQuery query) {
		userInfoDao.deleteByExample(query);
	}
	
	
	public UserInfoPage queryPageList(UserInfoQuery query) {
		UserInfoPage userInfoPage = new UserInfoPage();
		Integer itemCount = userInfoDao.countByExample(query);
		query.setItemCount(itemCount);
		
		if (itemCount == 0) {
			userInfoPage.setValues(null);
		} else {
			userInfoPage.setValues(userInfoDao.selectPageByExample(query));
		}
		
		userInfoPage.setPagenation(new Pagenation(query.getPageNo(),query.getPageSize(),query.getItemCount()));
		return userInfoPage;
	}
}

