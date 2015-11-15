/*
 * Powered By code-generator
 * Since 2015 - 2015
 */

package com.cn.periodical.manager.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.cn.periodical.dao.AccountInfoDao;
import com.cn.periodical.manager.AccountInfoManager;
import com.cn.periodical.pojo.AccountInfo;
import com.cn.periodical.pojo.AccountInfoPage;
import com.cn.periodical.pojo.AccountInfoQuery;
import com.cn.periodical.utils.Pagenation;

@Component("accountInfoManager")
public class AccountInfoManagerImpl implements AccountInfoManager {
	
	@Autowired
	@Qualifier("accountInfoDao")
	private AccountInfoDao accountInfoDao;
	
	
	public void saveAccountInfo(AccountInfo accountInfo) {
		if (accountInfo.getId() == null) {
			accountInfoDao.insertSelective(accountInfo);
		} else {
			accountInfoDao.updateByPrimaryKeySelective(accountInfo);
		}
	}
	
	
	public AccountInfo findAccountInfoById(Long id) {
		return accountInfoDao.selectByPrimaryKey(id);
	}
	
	
	public List<AccountInfo> queryList(AccountInfoQuery query) {
		return accountInfoDao.selectByExample(query);
	}
	
	
	public void deleteAccountInfoById(Long id) {
		accountInfoDao.deleteByPrimaryKey(id);
	}
	
	
	public void deleteAccountInfo(AccountInfoQuery query) {
		accountInfoDao.deleteByExample(query);
	}
	
	
	public AccountInfoPage queryPageList(AccountInfoQuery query) {
		AccountInfoPage accountInfoPage = new AccountInfoPage();
		Integer itemCount = accountInfoDao.countByExample(query);
		query.setItemCount(itemCount);
		
		if (itemCount == 0) {
			accountInfoPage.setValues(null);
		} else {
			accountInfoPage.setValues(accountInfoDao.selectPageByExample(query));
		}
		
		accountInfoPage.setPagenation(new Pagenation(query.getPageNo(),query.getPageSize(),query.getItemCount()));
		return accountInfoPage;
	}
}

