/*
 * Powered By code-generator
 * Since 2015 - 2015
 */

package com.cn.periodical.manager.impl;

import java.util.List;

import com.cn.periodical.pojo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.cn.periodical.dao.CouncilInfoDao;
import com.cn.periodical.manager.CouncilInfoManager;
import com.cn.periodical.utils.Pagenation;

@Component("councilInfoManager")
public class CouncilInfoManagerImpl implements CouncilInfoManager {
	
	@Autowired
	@Qualifier("councilInfoDao")
	private CouncilInfoDao councilInfoDao;
	
	
	public void saveCouncilInfo(CouncilInfo councilInfo) {
		if (councilInfo.getId() == null) {
			councilInfoDao.insertSelective(councilInfo);
		} else {
			councilInfoDao.updateByPrimaryKeySelective(councilInfo);
		}
	}
	
	
	public CouncilInfo findCouncilInfoById(Long id) {
		return councilInfoDao.selectByPrimaryKey(id);
	}
	
	
	public List<CouncilInfo> queryList(CouncilInfoQuery query) {
		return councilInfoDao.selectByExample(query);
	}
	
	
	public void deleteCouncilInfoById(Long id) {
		councilInfoDao.deleteByPrimaryKey(id);
	}
	
	
	public void deleteCouncilInfo(CouncilInfoQuery query) {
		councilInfoDao.deleteByExample(query);
	}
	
	
	public CouncilInfoPage queryPageList(CouncilInfoQuery query) {
		CouncilInfoPage councilInfoPage = new CouncilInfoPage();
		Integer itemCount = councilInfoDao.countByExample(query);
		query.setItemCount(itemCount);
		
		if (itemCount == 0) {
			councilInfoPage.setValues(null);
		} else {
			councilInfoPage.setValues(councilInfoDao.selectPageByExample(query));
		}
		
		councilInfoPage.setPagenation(new Pagenation(query.getPageNo(),query.getPageSize(),query.getItemCount()));
		return councilInfoPage;
	}


	public List<BizCouncil> queryBizCouncil(BizCouncil reqDto) {
		// TODO Auto-generated method stub
		return councilInfoDao.queryBizCouncil(reqDto);
	}
	public List<BizCouncil> queryBizCouncilPage(BizCouncilQuery reqDto) {
		// TODO Auto-generated method stub
		return councilInfoDao.queryBizCouncilPage(reqDto);
	}
	public int queryBizCouncilPageCount(BizCouncilQuery reqDto) {
		// TODO Auto-generated method stub
		return councilInfoDao.queryBizCouncilPageCount(reqDto);
	}
}

