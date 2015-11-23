/*
 * Powered By code-generator
 * Since 2015 - 2015
 */

package com.cn.periodical.manager;

import java.util.List;

import com.cn.periodical.pojo.ResetPassword;
import com.cn.periodical.pojo.ResetPasswordPage;
import com.cn.periodical.pojo.ResetPasswordQuery;

public interface ResetPasswordManager {
	void saveResetPassword(ResetPassword resetPassword);

	ResetPassword findResetPasswordById(Long id);
	
	List<ResetPassword> queryList(ResetPasswordQuery query);
	
	void deleteResetPasswordById(Long id);
	
	void deleteResetPassword(ResetPasswordQuery query);
	
	ResetPasswordPage queryPageList(ResetPasswordQuery query);
}
