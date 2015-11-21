/*
 * Powered By code-generator
 * Since 2015 - 2015
 */

package com.cn.periodical.manager.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.cn.periodical.dao.PayerInfoDao;
import com.cn.periodical.manager.PayerInfoManager;
import com.cn.periodical.pojo.PayerInfo;
import com.cn.periodical.pojo.PayerInfoPage;
import com.cn.periodical.pojo.PayerInfoQuery;
import com.cn.periodical.utils.Pagenation;

@Component("payerInfoManager")
public class PayerInfoManagerImpl implements PayerInfoManager {
	
	@Autowired
	@Qualifier("payerInfoDao")
	private PayerInfoDao payerInfoDao;
	
	
	public void savePayerInfo(PayerInfo payerInfo) {
		if (payerInfo.getId() == null) {
			payerInfoDao.insertSelective(payerInfo);
		} else {
			payerInfoDao.updateByPrimaryKeySelective(payerInfo);
		}
	}
	
	
	public PayerInfo findPayerInfoById(Long id) {
		return payerInfoDao.selectByPrimaryKey(id);
	}
	
	
	public List<PayerInfo> queryList(PayerInfoQuery query) {
		return payerInfoDao.selectByExample(query);
	}
	
	
	public void deletePayerInfoById(Long id) {
		payerInfoDao.deleteByPrimaryKey(id);
	}
	
	
	public void deletePayerInfo(PayerInfoQuery query) {
		payerInfoDao.deleteByExample(query);
	}
	
	
	public PayerInfoPage queryPageList(PayerInfoQuery query) {
		PayerInfoPage payerInfoPage = new PayerInfoPage();
		Integer itemCount = payerInfoDao.countByExample(query);
		query.setItemCount(itemCount);
		
		if (itemCount == 0) {
			payerInfoPage.setValues(null);
		} else {
			payerInfoPage.setValues(payerInfoDao.selectPageByExample(query));
		}
		
		payerInfoPage.setPagenation(new Pagenation(query.getPageNo(),query.getPageSize(),query.getItemCount()));
		return payerInfoPage;
	}
}

