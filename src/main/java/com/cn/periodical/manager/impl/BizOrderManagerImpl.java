/*
 * Powered By code-generator
 * Since 2015 - 2015
 */

package com.cn.periodical.manager.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.cn.periodical.dao.BizOrderDao;
import com.cn.periodical.manager.BizOrderManager;
import com.cn.periodical.pojo.BizOrder;

@Component("bizOrderManager")
public class BizOrderManagerImpl implements BizOrderManager {
	
	@Autowired
	@Qualifier("bizOrderDao")
	private BizOrderDao bizOrderDao;

	public List<BizOrder> queryDistributeOrderInfos(BizOrder example) {
		// TODO Auto-generated method stub
		return bizOrderDao.queryDistributeOrderInfos(example);
	}
}

