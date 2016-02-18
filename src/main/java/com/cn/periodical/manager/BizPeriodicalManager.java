/*
 * Powered By code-generator
 * Since 2015 - 2015
 */

package com.cn.periodical.manager;

import java.util.List;

import com.cn.periodical.pojo.*;

public interface BizPeriodicalManager {
	public List<BizPeriodical> queryPeriodicalInfosForIssueEditor(BizPeriodical reqDto);
	public BizPeriodicalPage queryPeriodicalInfosForEnExpert(BizPeriodicalQuery reqDto,int count);
	public int queryPeriodicalInfosForEnExpertCount(BizPeriodicalQuery reqDto);
	public List<BizPeriodical> queryPeriodicalInfosForEnExpertDetail(BizPeriodical reqDto);

}
