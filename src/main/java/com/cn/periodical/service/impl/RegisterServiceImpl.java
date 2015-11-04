package com.cn.periodical.service.impl;

import java.util.Date;
import java.util.UUID;

import org.joda.time.DateTime;
import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;

import com.cn.periodical.manager.AddressInfoManager;
import com.cn.periodical.manager.AuthorInfoManager;
import com.cn.periodical.manager.UserInfoManager;
import com.cn.periodical.pojo.AddressInfo;
import com.cn.periodical.pojo.AuthorInfo;
import com.cn.periodical.pojo.UserInfo;
import com.cn.periodical.request.RegisteRequestDto;
import com.cn.periodical.service.RegisterService;

@Service
public class RegisterServiceImpl implements RegisterService {
	private static final Logger logger = LoggerFactory.getLogger(RegisterServiceImpl.class);

	
	@Autowired
	UserInfoManager userInfoManager;
	@Autowired 
	AuthorInfoManager authorInfoManager;
	
	@Autowired
	AddressInfoManager addressInfoManager;
	
	@Autowired
	TransactionTemplate transactionTemplate;
	
	public RegisterServiceImpl() {
		// TODO Auto-generated constructor stub
	}

	public int addAuthor(RegisteRequestDto registeRequestDto) {
		// TODO Auto-generated method stub
		
		String userId=UUID.randomUUID().toString().replace("-", "");
		String authorId=UUID.randomUUID().toString().replace("-", "");
		String addressId=UUID.randomUUID().toString().replace("-", "");
		
		final UserInfo userInfo = new UserInfo();
		userInfo.setLogonName(registeRequestDto.getEmail());
		userInfo.setLogonPwd(registeRequestDto.getPassword());
		userInfo.setRetryTimes(0);
		userInfo.setRoleId(registeRequestDto.getRoleId());
		userInfo.setStatus("0");
		userInfo.setSystemId(registeRequestDto.getSystemId());
		userInfo.setUserId(userId);
		userInfo.setRefId(authorId);
		userInfo.setExtend1("");
		userInfo.setExtend2("");
		userInfo.setExtend3("");
		userInfo.setExtend4("");
		userInfo.setCreateTime(new Date());
		userInfo.setUpdateTime(new Date());
		
		final AuthorInfo authorInfo = new AuthorInfo();
		authorInfo.setAuthorId(authorId);
		authorInfo.setAuthorName(registeRequestDto.getRealName());
		authorInfo.setAuthorNameSpell(registeRequestDto.getNameSpell());
		authorInfo.setBirthday(new DateTime(registeRequestDto.getBirthDay()).toDate());
		authorInfo.setCertificateType(registeRequestDto.getCertifiType().getCode());
		authorInfo.setCertificateNo(registeRequestDto.getCertifiNo());
		authorInfo.setCompanyDepartment(registeRequestDto.getCompanyDepartment());
		authorInfo.setCompanyName(registeRequestDto.getCompanyName());
		authorInfo.setCompayType(registeRequestDto.getCompanyType().getCode());
		authorInfo.setDegree(registeRequestDto.getDegree().getCode());
		authorInfo.setEmail(registeRequestDto.getEmail());
		authorInfo.setIsfirstauthor("");
		authorInfo.setResearchArea(registeRequestDto.getResearchArea());
		authorInfo.setSex(registeRequestDto.getSex());
		authorInfo.setExtend1("");
		authorInfo.setExtend2("");
		authorInfo.setExtend3("");
		authorInfo.setExtend4("");
		authorInfo.setCreateTime(new Date());
		authorInfo.setUpdateTime(new Date());
		
		
		
		final AddressInfo addressInfo = new AddressInfo();
		addressInfo.setReceiveAddress(registeRequestDto.getPostAddress());
		addressInfo.setReceiveContacter(registeRequestDto.getRealName());
		addressInfo.setContacterName(registeRequestDto.getRealName());
		addressInfo.setReceivePostcode(registeRequestDto.getPostCode());
		addressInfo.setContacterMobile("");
		addressInfo.setContacterTelephone(registeRequestDto.getContactPhone());
		addressInfo.setAddressId(addressId);
		addressInfo.setStatus("0");
		addressInfo.setRefRoleId(registeRequestDto.getRoleId());
		addressInfo.setRefId(authorId);
		addressInfo.setExtend1("");
		addressInfo.setExtend2("");
		addressInfo.setExtend3("");
		addressInfo.setCreateTime(new Date());
		addressInfo.setUpdateTime(new Date());
		
		int k =(Integer) transactionTemplate.execute(new TransactionCallback<Object> (){
			public Object doInTransaction(TransactionStatus status) {
				// TODO Auto-generated method stub
				try {
					addressInfoManager.saveAddressInfo(addressInfo);
					authorInfoManager.saveAuthorInfo(authorInfo);
					userInfoManager.saveUserInfo(userInfo);
				} catch (Exception e) {
					logger.error("保存注册数据异常:"+e);
					status.setRollbackOnly();
					return 0;
				}
				return 1;
			}
		});
		return k;
	}

	
	public int addEditor(RegisteRequestDto registeRequestDto) {
		// TODO Auto-generated method stub
		return 0;
	}

	
	public int addExpert(RegisteRequestDto registeRequestDto) {
		// TODO Auto-generated method stub
		return 0;
	}

	
	public int addReader(RegisteRequestDto registeRequestDto) {
		// TODO Auto-generated method stub
		return 0;
	}

}
