package com.cn.periodical.service.impl;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cn.periodical.manager.UserInfoManager;
import com.cn.periodical.pojo.UserInfo;
import com.cn.periodical.request.RegisteRequestDto;
import com.cn.periodical.service.RegisterService;

@Service
public class RegisterServiceImpl implements RegisterService {
	private static final Logger logger = LoggerFactory.getLogger(RegisterServiceImpl.class);

	
	@Autowired
	UserInfoManager userInfoManager;
	
	public RegisterServiceImpl() {
		// TODO Auto-generated constructor stub
	}

	public int addAuthor(RegisteRequestDto registeRequestDto) {
		// TODO Auto-generated method stub
		UserInfo userInfo = new UserInfo();
		userInfo.setExtend1("");
		userInfo.setLogonName(registeRequestDto.getEmail());
		userInfo.setLogonPwd(registeRequestDto.getPassword());
//		userInfo.setId(id);
		userInfo.setExtend2("");
		userInfo.setExtend3("");
		userInfo.setExtend4("");
		userInfo.setCreateTime(new Date());
		userInfo.setUpdateTime(new Date());
		userInfo.setRefId("");
		userInfo.setRetryTimes(0);
		userInfo.setRoleId("");
		userInfo.setStatus("0");
		userInfo.setSystemId("");
		userInfo.setUserId("333333");
		
		
		userInfoManager.saveUserInfo(userInfo);
		return 0;
	}

	@Override
	public int addEditor(RegisteRequestDto registeRequestDto) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int addExpert(RegisteRequestDto registeRequestDto) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int addReader(RegisteRequestDto registeRequestDto) {
		// TODO Auto-generated method stub
		return 0;
	}

}
