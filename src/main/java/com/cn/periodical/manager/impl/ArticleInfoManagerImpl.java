/*
 * Powered By code-generator
 * Since 2015 - 2015
 */

package com.cn.periodical.manager.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.cn.periodical.dao.ArticleInfoDao;
import com.cn.periodical.manager.ArticleInfoManager;
import com.cn.periodical.pojo.ArticleInfo;
import com.cn.periodical.pojo.ArticleInfoPage;
import com.cn.periodical.pojo.ArticleInfoQuery;
import com.cn.periodical.utils.Pagenation;

@Component("articleInfoManager")
public class ArticleInfoManagerImpl implements ArticleInfoManager {
	
	@Autowired
	@Qualifier("articleInfoDao")
	private ArticleInfoDao articleInfoDao;
	
	
	public void saveArticleInfo(ArticleInfo articleInfo) {
		if (articleInfo.getId() == null) {
			articleInfoDao.insertSelective(articleInfo);
		} else {
			articleInfoDao.updateByPrimaryKeySelective(articleInfo);
		}
	}
	
	
	public ArticleInfo findArticleInfoById(Long id) {
		return articleInfoDao.selectByPrimaryKey(id);
	}
	
	
	public List<ArticleInfo> queryList(ArticleInfoQuery query) {
		return articleInfoDao.selectByExample(query);
	}
	
	
	public void deleteArticleInfoById(Long id) {
		articleInfoDao.deleteByPrimaryKey(id);
	}
	
	
	public void deleteArticleInfo(ArticleInfoQuery query) {
		articleInfoDao.deleteByExample(query);
	}
	
	
	public ArticleInfoPage queryPageList(ArticleInfoQuery query) {
		ArticleInfoPage articleInfoPage = new ArticleInfoPage();
		Integer itemCount = articleInfoDao.countByExample(query);
		query.setItemCount(itemCount);
		
		if (itemCount == 0) {
			articleInfoPage.setValues(null);
		} else {
			articleInfoPage.setValues(articleInfoDao.selectPageByExample(query));
		}
		
		articleInfoPage.setPagenation(new Pagenation(query.getPageNo(),query.getPageSize(),query.getItemCount()));
		return articleInfoPage;
	}
}
