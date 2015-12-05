/*
 * Powered By code-generator
 * Since 2015 - 2015
 */

package com.cn.periodical.manager;

import java.util.List;

import com.cn.periodical.pojo.AdFlows;
import com.cn.periodical.pojo.AdFlowsPage;
import com.cn.periodical.pojo.AdFlowsQuery;
import com.cn.periodical.pojo.BizArticleFee;
import com.cn.periodical.pojo.BizOrder;

public interface BizOrderManager {
	public List<BizOrder> queryDistributeOrderInfos(BizOrder example);
	public List<BizOrder> queryOrderInfosForSubEditor(BizOrder example);
	public List<BizOrder> queryOrderInfosForSubEditorDetails(BizOrder example);
}
