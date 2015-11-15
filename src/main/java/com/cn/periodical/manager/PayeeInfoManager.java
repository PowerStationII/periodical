/*
 * Powered By code-generator
 * Since 2015 - 2015
 */

package com.cn.periodical.manager;

import java.util.List;

import com.cn.periodical.pojo.PayeeInfo;
import com.cn.periodical.pojo.PayeeInfoPage;
import com.cn.periodical.pojo.PayeeInfoQuery;

public interface PayeeInfoManager {
	void savePayeeInfo(PayeeInfo payeeInfo);

	PayeeInfo findPayeeInfoById(Long id);
	
	List<PayeeInfo> queryList(PayeeInfoQuery query);
	
	void deletePayeeInfoById(Long id);
	
	void deletePayeeInfo(PayeeInfoQuery query);
	
	PayeeInfoPage queryPageList(PayeeInfoQuery query);
}
