/*
 * Powered By code-generator
 * Since 2015 - 2015
 */

package com.cn.periodical.manager;

import java.util.List;

import com.cn.periodical.pojo.AdInfo;
import com.cn.periodical.pojo.AdInfoPage;
import com.cn.periodical.pojo.AdInfoQuery;
import com.cn.periodical.pojo.BizPeriodical;

public interface BizPeriodicalManager {
	public List<BizPeriodical> queryPeriodicalInfosForIssueEditor(BizPeriodical reqDto);
	public List<BizPeriodical> queryPeriodicalInfosForEnExpert(BizPeriodical reqDto);
	public List<BizPeriodical> queryPeriodicalInfosForEnExpertDetail(BizPeriodical reqDto);

}
