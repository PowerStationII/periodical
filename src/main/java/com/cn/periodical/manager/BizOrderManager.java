/*
 * Powered By code-generator
 * Since 2015 - 2015
 */

package com.cn.periodical.manager;

import java.util.List;

import com.cn.periodical.pojo.*;

public interface BizOrderManager {
	public List<BizOrder> queryDistributeOrderInfos(BizOrder example);
	public List<BizOrder> queryOrderInfosForSubEditor(BizOrder example);

    public BizOrderPage queryOrderInfosForSubEditorPage(BizOrderQuery example , int count) ;
    public int queryOrderInfosForSubEditorPageCount(BizOrderQuery example);
	public List<BizOrder> queryOrderInfosForSubEditorDetails(BizOrder example);
}
