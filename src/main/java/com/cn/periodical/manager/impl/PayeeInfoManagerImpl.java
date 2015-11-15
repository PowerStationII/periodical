/*
 * Powered By code-generator
 * Since 2015 - 2015
 */

package com.cn.periodical.manager.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.cn.periodical.dao.PayeeInfoDao;
import com.cn.periodical.manager.PayeeInfoManager;
import com.cn.periodical.pojo.PayeeInfo;
import com.cn.periodical.pojo.PayeeInfoPage;
import com.cn.periodical.pojo.PayeeInfoQuery;
import com.cn.periodical.utils.Pagenation;

@Component("payeeInfoManager")
public class PayeeInfoManagerImpl implements PayeeInfoManager {
	
	@Autowired
	@Qualifier("payeeInfoDao")
	private PayeeInfoDao payeeInfoDao;
	
	
	public void savePayeeInfo(PayeeInfo payeeInfo) {
		if (payeeInfo.getId() == null) {
			payeeInfoDao.insertSelective(payeeInfo);
		} else {
			payeeInfoDao.updateByPrimaryKeySelective(payeeInfo);
		}
	}
	
	
	public PayeeInfo findPayeeInfoById(Long id) {
		return payeeInfoDao.selectByPrimaryKey(id);
	}
	
	
	public List<PayeeInfo> queryList(PayeeInfoQuery query) {
		return payeeInfoDao.selectByExample(query);
	}
	
	
	public void deletePayeeInfoById(Long id) {
		payeeInfoDao.deleteByPrimaryKey(id);
	}
	
	
	public void deletePayeeInfo(PayeeInfoQuery query) {
		payeeInfoDao.deleteByExample(query);
	}
	
	
	public PayeeInfoPage queryPageList(PayeeInfoQuery query) {
		PayeeInfoPage payeeInfoPage = new PayeeInfoPage();
		Integer itemCount = payeeInfoDao.countByExample(query);
		query.setItemCount(itemCount);
		
		if (itemCount == 0) {
			payeeInfoPage.setValues(null);
		} else {
			payeeInfoPage.setValues(payeeInfoDao.selectPageByExample(query));
		}
		
		payeeInfoPage.setPagenation(new Pagenation(query.getPageNo(),query.getPageSize(),query.getItemCount()));
		return payeeInfoPage;
	}
}

