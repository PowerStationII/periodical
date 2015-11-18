/*
 * Powered By code-generator
 * Since 2015 - 2015
 */

package com.cn.periodical.manager.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.cn.periodical.dao.ReaderInfoDao;
import com.cn.periodical.manager.ReaderInfoManager;
import com.cn.periodical.pojo.ReaderInfo;
import com.cn.periodical.pojo.ReaderInfoPage;
import com.cn.periodical.pojo.ReaderInfoQuery;
import com.cn.periodical.utils.Pagenation;

@Component("readerInfoManager")
public class ReaderInfoManagerImpl implements ReaderInfoManager {
	
	@Autowired
	@Qualifier("readerInfoDao")
	private ReaderInfoDao readerInfoDao;
	
	
	public void saveReaderInfo(ReaderInfo readerInfo) {
		if (readerInfo.getId() == null) {
			readerInfoDao.insertSelective(readerInfo);
		} else {
			readerInfoDao.updateByPrimaryKeySelective(readerInfo);
		}
	}
	
	
	public ReaderInfo findReaderInfoById(Long id) {
		return readerInfoDao.selectByPrimaryKey(id);
	}
	
	
	public List<ReaderInfo> queryList(ReaderInfoQuery query) {
		return readerInfoDao.selectByExample(query);
	}
	
	
	public void deleteReaderInfoById(Long id) {
		readerInfoDao.deleteByPrimaryKey(id);
	}
	
	
	public void deleteReaderInfo(ReaderInfoQuery query) {
		readerInfoDao.deleteByExample(query);
	}
	
	
	public ReaderInfoPage queryPageList(ReaderInfoQuery query) {
		ReaderInfoPage readerInfoPage = new ReaderInfoPage();
		Integer itemCount = readerInfoDao.countByExample(query);
		query.setItemCount(itemCount);
		
		if (itemCount == 0) {
			readerInfoPage.setValues(null);
		} else {
			readerInfoPage.setValues(readerInfoDao.selectPageByExample(query));
		}
		
		readerInfoPage.setPagenation(new Pagenation(query.getPageNo(),query.getPageSize(),query.getItemCount()));
		return readerInfoPage;
	}
}

