/*
 * Powered By chanjetpay-code-generator
 * Web Site: http://www.chanjetpay.com
 * Since 2014 - 2015
 */

package com.cn.periodical.manager;

import java.util.List;

import com.cn.periodical.pojo.UserInfo;
import com.cn.periodical.pojo.UserInfoPage;
import com.cn.periodical.pojo.UserInfoQuery;
import com.cn.periodical.request.UserQueryReqDto;

public interface UserQueryManager {
	public UserQueryReqDto queryUserRef(UserQueryReqDto dto);
}
