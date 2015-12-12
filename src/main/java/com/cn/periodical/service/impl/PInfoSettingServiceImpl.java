package com.cn.periodical.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cn.periodical.controller.PInfoSettingController;
import com.cn.periodical.enums.RoleIdEnums;
import com.cn.periodical.enums.SystemIdEnums;
import com.cn.periodical.manager.AuthorInfoManager;
import com.cn.periodical.manager.EditorInfoManager;
import com.cn.periodical.manager.ExpertInfoManager;
import com.cn.periodical.manager.ReaderInfoManager;
import com.cn.periodical.manager.UserInfoManager;
import com.cn.periodical.pojo.AuthorInfo;
import com.cn.periodical.pojo.AuthorInfoQuery;
import com.cn.periodical.pojo.EditorInfo;
import com.cn.periodical.pojo.ExpertInfo;
import com.cn.periodical.pojo.ReaderInfo;
import com.cn.periodical.pojo.ReaderInfoQuery;
import com.cn.periodical.pojo.UserInfo;
import com.cn.periodical.pojo.UserInfoQuery;
import com.cn.periodical.service.PInfoSettingService;

@Service
public class PInfoSettingServiceImpl implements PInfoSettingService {
	private static final Logger logger = LoggerFactory.getLogger(PInfoSettingController.class);

	@Autowired
	UserInfoManager userInfoManager;
	
	@Autowired 
	AuthorInfoManager authorInfoManager;
	
	@Autowired 
	ReaderInfoManager readerInfoManager;
	
	@Autowired
	ExpertInfoManager expertInfoManager;
	
	@Autowired
	EditorInfoManager editorInfoManager;
	
	public PInfoSettingServiceImpl() {
		// TODO Auto-generated constructor stub
	}

	public int updateSetting(UserInfo userInfo, Object obj) {
		// TODO Auto-generated method stub
		if (SystemIdEnums.AUTHOR_SYS.getCode().equals(userInfo.getSystemId())) {
			AuthorInfo authorInfo = (AuthorInfo)obj;
			authorInfoManager.saveAuthorInfo(authorInfo);
		} else if (SystemIdEnums.EXPERT_SYS.getCode().equals(userInfo.getSystemId())) {
			ExpertInfo expertInfo = (ExpertInfo)obj;
			expertInfoManager.saveExpertInfo(expertInfo);
		} else if (SystemIdEnums.READER_SYS.getCode().equals(userInfo.getSystemId())) {
			ReaderInfo readerInfo = (ReaderInfo)obj;
			readerInfoManager.saveReaderInfo(readerInfo);
		} else if (SystemIdEnums.EDIT_SYS.getCode().equals(userInfo.getSystemId())) {
//			AuthorInfo authorInfo = (AuthorInfo)obj;
//			authorInfoManager.saveAuthorInfo(authorInfo);
		} else {
			logger.info("系统不存在,你修改啥");
		}
		return 0;
	}

	public int updatePw(UserInfo userInfo,String password) {
		// TODO Auto-generated method stub
		userInfo.setId(userInfo.getId());
		userInfo.setLogonPwd(password);
		try{
			userInfoManager.saveUserInfo(userInfo);
			return 1;
		}catch(Exception e){
			e.printStackTrace();
			return 0;
		}
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
			ReaderInfoQuery readerInfoQuery= new ReaderInfoQuery();
			readerInfoQuery.setReaderId(userInfo.getRefId());
			List<ReaderInfo> readerInfos= readerInfoManager.queryList(readerInfoQuery);
			ReaderInfo readerInfo = readerInfos.get(0);
			return readerInfo;
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
