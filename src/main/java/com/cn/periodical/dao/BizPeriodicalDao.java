/*
 * Powered By code-generator
 * Since 2015 - 2015
 */

package com.cn.periodical.dao;

import java.util.List;

import com.cn.periodical.pojo.BizPeriodical;
import com.cn.periodical.pojo.BizPeriodicalQuery;

public interface BizPeriodicalDao {
	public List<BizPeriodical> queryPeriodicalInfosForIssueEditor(BizPeriodical reqDto);
    public List<BizPeriodical> queryPeriodicalInfosForIssueEditorPage(BizPeriodicalQuery reqDto) ;
    public int queryPeriodicalInfosForIssueEditorPageCount(BizPeriodicalQuery reqDto) ;
	public List<BizPeriodical> queryPeriodicalInfosForEnExpert(BizPeriodicalQuery reqDto);
	public int queryPeriodicalInfosForEnExpertCount(BizPeriodicalQuery reqDto);
	public List<BizPeriodical> queryPeriodicalInfosForEnExpertDetail(BizPeriodical reqDto);
	
	
	
}
