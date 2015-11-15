/*
 * Powered By code-generator
 * Since 2015 - 2015
 */

package com.cn.periodical.manager;

import java.util.List;

import com.cn.periodical.pojo.AccountInfo;
import com.cn.periodical.pojo.AccountInfoPage;
import com.cn.periodical.pojo.AccountInfoQuery;

public interface AccountInfoManager {
	void saveAccountInfo(AccountInfo accountInfo);

	AccountInfo findAccountInfoById(Long id);
	
	List<AccountInfo> queryList(AccountInfoQuery query);
	
	void deleteAccountInfoById(Long id);
	
	void deleteAccountInfo(AccountInfoQuery query);
	
	AccountInfoPage queryPageList(AccountInfoQuery query);
}
