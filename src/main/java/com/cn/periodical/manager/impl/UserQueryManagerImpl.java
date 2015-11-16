package com.cn.periodical.manager.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.cn.periodical.dao.UserQueryDao;
import com.cn.periodical.manager.UserQueryManager;
import com.cn.periodical.request.UserQueryReqDto;

@Component("userQueryManager")
public class UserQueryManagerImpl implements UserQueryManager {
	
	@Autowired
	@Qualifier("userQueryDao")
	private UserQueryDao userQueryDao;

	public UserQueryReqDto queryUserRef(UserQueryReqDto dto) {
		// TODO Auto-generated method stub
		return userQueryDao.queryUserRef(dto);
	}
}

