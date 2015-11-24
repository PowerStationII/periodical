/*
 * Powered By code-generator
 * Since 2015 - 2015
 */

package com.cn.periodical.manager.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.cn.periodical.dao.BizPeriodicalDao;
import com.cn.periodical.manager.BizPeriodicalManager;
import com.cn.periodical.pojo.BizPeriodical;

@Component("bizPeriodicalManager")
public class BizPeriodicalManagerImpl implements BizPeriodicalManager {
	
	@Autowired
	@Qualifier("bizPeriodicalDao")
	public BizPeriodicalDao bizPeriodicalDao;

	public List<BizPeriodical> queryPeriodicalInfosForIssueEditor(BizPeriodical reqDto) {
		// TODO Auto-generated method stub
		return bizPeriodicalDao.queryPeriodicalInfosForIssueEditor(reqDto);
	}
}

