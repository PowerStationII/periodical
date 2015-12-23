/*
 * Powered By code-generator
 * Since 2015 - 2015
 */

package com.cn.periodical.manager;

import java.util.List;
import java.util.Map;

import com.cn.periodical.pojo.AdFlows;
import com.cn.periodical.pojo.AdFlowsPage;
import com.cn.periodical.pojo.AdFlowsQuery;
import com.cn.periodical.pojo.BizArticleFee;

public interface BizArticleFeeManager {
	List<BizArticleFee> editArticleFee(BizArticleFee example);
	public List<Map<String, String>> editArticleFeeMap(BizArticleFee example);
}
