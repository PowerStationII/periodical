/*
 * Powered By code-generator
 * Since 2015 - 2015
 */

package com.cn.periodical.dao;

import java.util.List;

import com.cn.periodical.pojo.BizOrder;
import com.cn.periodical.pojo.BizOrderQuery;

public interface BizOrderDao {
	List<BizOrder> queryDistributeOrderInfos(BizOrder example);
	public List<BizOrder> queryOrderInfosForSubEditor(BizOrder example);

    public List<BizOrder> queryOrderInfosForSubEditorPage(BizOrderQuery example) ;
    public int queryOrderInfosForSubEditorPageCount(BizOrderQuery example);
    public List<BizOrder> queryOrderInfosForSubEditorDetails(BizOrder example);
	
	
}
