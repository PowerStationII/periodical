/*
 * Powered By code-generator
 * Since 2015 - 2015
 */

package com.cn.periodical.manager.impl;

import java.util.List;

import com.cn.periodical.pojo.BizPeriodicalPage;
import com.cn.periodical.pojo.BizPeriodicalQuery;
import com.cn.periodical.utils.Pagenation;
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
	public BizPeriodicalPage queryPeriodicalInfosForIssueEditorPage(BizPeriodicalQuery query,int itemCount) {
        BizPeriodicalPage adInfoPage = new BizPeriodicalPage();
        if (itemCount == 0) {
            adInfoPage.setValues(null);
        } else {
            adInfoPage.setValues(bizPeriodicalDao.queryPeriodicalInfosForIssueEditorPage(query));
        }

        adInfoPage.setPagenation(new Pagenation(query.getPageNo(),query.getPageSize(),query.getItemCount()));
        return adInfoPage;
	}
	public int queryPeriodicalInfosForIssueEditorPageCount(BizPeriodicalQuery reqDto) {
		// TODO Auto-generated method stub
		return bizPeriodicalDao.queryPeriodicalInfosForIssueEditorPageCount(reqDto);
	}

	public BizPeriodicalPage queryPeriodicalInfosForEnExpert(BizPeriodicalQuery query,int itemCount) {
        BizPeriodicalPage bizAdPage = new BizPeriodicalPage();
        query.setItemCount(itemCount);

        if (itemCount == 0) {
            bizAdPage.setValues(null);
        } else {
            bizAdPage.setValues(bizPeriodicalDao.queryPeriodicalInfosForEnExpert(query));
        }

        bizAdPage.setPagenation(new Pagenation(query.getPageNo(),query.getPageSize(),query.getItemCount()));
        return bizAdPage;
	}
	public int queryPeriodicalInfosForEnExpertCount(BizPeriodicalQuery reqDto) {
		// TODO Auto-generated method stub
		return bizPeriodicalDao.queryPeriodicalInfosForEnExpertCount(reqDto);
	}

	public List<BizPeriodical> queryPeriodicalInfosForEnExpertDetail(BizPeriodical reqDto) {
		// TODO Auto-generated method stub
		return bizPeriodicalDao.queryPeriodicalInfosForEnExpertDetail(reqDto);
	}
}

