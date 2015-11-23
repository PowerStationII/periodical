/*
 * Powered By code-generator
 * Since 2015 - 2015
 */

package com.cn.periodical.manager.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.cn.periodical.dao.ResetPasswordDao;
import com.cn.periodical.manager.ResetPasswordManager;
import com.cn.periodical.pojo.ResetPassword;
import com.cn.periodical.pojo.ResetPasswordPage;
import com.cn.periodical.pojo.ResetPasswordQuery;
import com.cn.periodical.utils.Pagenation;

@Component("resetPasswordManager")
public class ResetPasswordManagerImpl implements ResetPasswordManager {
	
	@Autowired
	@Qualifier("resetPasswordDao")
	private ResetPasswordDao resetPasswordDao;
	
	
	public void saveResetPassword(ResetPassword resetPassword) {
		if (resetPassword.getId() == null) {
			resetPasswordDao.insertSelective(resetPassword);
		} else {
			resetPasswordDao.updateByPrimaryKeySelective(resetPassword);
		}
	}
	
	
	public ResetPassword findResetPasswordById(Long id) {
		return resetPasswordDao.selectByPrimaryKey(id);
	}
	
	
	public List<ResetPassword> queryList(ResetPasswordQuery query) {
		return resetPasswordDao.selectByExample(query);
	}
	
	
	public void deleteResetPasswordById(Long id) {
		resetPasswordDao.deleteByPrimaryKey(id);
	}
	
	
	public void deleteResetPassword(ResetPasswordQuery query) {
		resetPasswordDao.deleteByExample(query);
	}
	
	
	public ResetPasswordPage queryPageList(ResetPasswordQuery query) {
		ResetPasswordPage resetPasswordPage = new ResetPasswordPage();
		Integer itemCount = resetPasswordDao.countByExample(query);
		query.setItemCount(itemCount);
		
		if (itemCount == 0) {
			resetPasswordPage.setValues(null);
		} else {
			resetPasswordPage.setValues(resetPasswordDao.selectPageByExample(query));
		}
		
		resetPasswordPage.setPagenation(new Pagenation(query.getPageNo(),query.getPageSize(),query.getItemCount()));
		return resetPasswordPage;
	}
}

