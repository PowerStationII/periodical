/*
 * Powered By code-generator
 * Since 2015 - 2015
 */

package com.cn.periodical.manager.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.cn.periodical.dao.EditorInfoDao;
import com.cn.periodical.manager.EditorInfoManager;
import com.cn.periodical.pojo.EditorInfo;
import com.cn.periodical.pojo.EditorInfoPage;
import com.cn.periodical.pojo.EditorInfoQuery;
import com.cn.periodical.utils.Pagenation;

@Component("editorInfoManager")
public class EditorInfoManagerImpl implements EditorInfoManager {
	
	@Autowired
	@Qualifier("editorInfoDao")
	private EditorInfoDao editorInfoDao;
	
	
	public void saveEditorInfo(EditorInfo editorInfo) {
		if (editorInfo.getId() == null) {
			editorInfoDao.insertSelective(editorInfo);
		} else {
			editorInfoDao.updateByPrimaryKeySelective(editorInfo);
		}
	}
	
	
	public EditorInfo findEditorInfoById(Long id) {
		return editorInfoDao.selectByPrimaryKey(id);
	}
	
	
	public List<EditorInfo> queryList(EditorInfoQuery query) {
		return editorInfoDao.selectByExample(query);
	}
	
	
	public void deleteEditorInfoById(Long id) {
		editorInfoDao.deleteByPrimaryKey(id);
	}
	
	
	public void deleteEditorInfo(EditorInfoQuery query) {
		editorInfoDao.deleteByExample(query);
	}
	
	
	public EditorInfoPage queryPageList(EditorInfoQuery query) {
		EditorInfoPage editorInfoPage = new EditorInfoPage();
		Integer itemCount = editorInfoDao.countByExample(query);
		query.setItemCount(itemCount);
		
		if (itemCount == 0) {
			editorInfoPage.setValues(null);
		} else {
			editorInfoPage.setValues(editorInfoDao.selectPageByExample(query));
		}
		
		editorInfoPage.setPagenation(new Pagenation(query.getPageNo(),query.getPageSize(),query.getItemCount()));
		return editorInfoPage;
	}
}

