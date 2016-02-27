/*
 * Powered By code-generator
 * Since 2015 - 2015
 */

package com.cn.periodical.manager.impl;

import java.util.List;

import com.cn.periodical.pojo.BizOrderPage;
import com.cn.periodical.pojo.BizOrderQuery;
import com.cn.periodical.utils.Pagenation;
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
	public List<BizOrder> queryOrderInfosForSubEditor(BizOrder example) {
		// TODO Auto-generated method stub
		return bizOrderDao.queryOrderInfosForSubEditor(example);
	}
	public BizOrderPage queryOrderInfosForSubEditorPage(BizOrderQuery query,int itemCount) {

        BizOrderPage bizAdPage = new BizOrderPage();
        query.setItemCount(itemCount);

        if (itemCount == 0) {
            bizAdPage.setValues(null);
        } else {
            bizAdPage.setValues(bizOrderDao.queryOrderInfosForSubEditorPage(query));
        }

        bizAdPage.setPagenation(new Pagenation(query.getPageNo(),query.getPageSize(),query.getItemCount()));
        return bizAdPage;
	}
	public int queryOrderInfosForSubEditorPageCount(BizOrderQuery example) {
		// TODO Auto-generated method stub
		return bizOrderDao.queryOrderInfosForSubEditorPageCount(example);
	}
	public List<BizOrder> queryOrderInfosForSubEditorDetails(BizOrder example) {
		// TODO Auto-generated method stub
		return bizOrderDao.queryOrderInfosForSubEditorDetails(example);
	}
}

