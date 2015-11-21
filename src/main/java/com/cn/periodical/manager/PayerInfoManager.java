/*
 * Powered By code-generator
 * Since 2015 - 2015
 */

package com.cn.periodical.manager;

import java.util.List;

import com.cn.periodical.pojo.PayerInfo;
import com.cn.periodical.pojo.PayerInfoPage;
import com.cn.periodical.pojo.PayerInfoQuery;

public interface PayerInfoManager {
	void savePayerInfo(PayerInfo payerInfo);

	PayerInfo findPayerInfoById(Long id);
	
	List<PayerInfo> queryList(PayerInfoQuery query);
	
	void deletePayerInfoById(Long id);
	
	void deletePayerInfo(PayerInfoQuery query);
	
	PayerInfoPage queryPageList(PayerInfoQuery query);
}
