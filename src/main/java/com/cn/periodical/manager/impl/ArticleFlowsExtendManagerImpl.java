/*
 * Powered By code-generator
 * Since 2015 - 2015
 */

package com.cn.periodical.manager.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.cn.periodical.dao.ArticleFlowsExtendDao;
import com.cn.periodical.manager.ArticleFlowsExtendManager;
import com.cn.periodical.pojo.ArticleFlowsExtend;
import com.cn.periodical.pojo.ArticleFlowsExtendPage;
import com.cn.periodical.pojo.ArticleFlowsExtendQuery;
import com.cn.periodical.utils.Pagenation;

@Component("articleFlowsExtendManager")
public class ArticleFlowsExtendManagerImpl implements ArticleFlowsExtendManager {
	
	@Autowired
	@Qualifier("articleFlowsExtendDao")
	private ArticleFlowsExtendDao articleFlowsExtendDao;
	
	
	public void saveArticleFlowsExtend(ArticleFlowsExtend articleFlowsExtend) {
		if (articleFlowsExtend.getId() == null) {
			articleFlowsExtendDao.insertSelective(articleFlowsExtend);
		} else {
			articleFlowsExtendDao.updateByPrimaryKeySelective(articleFlowsExtend);
		}
	}
	
	
	public ArticleFlowsExtend findArticleFlowsExtendById(Long id) {
		return articleFlowsExtendDao.selectByPrimaryKey(id);
	}
	
	
	public List<ArticleFlowsExtend> queryList(ArticleFlowsExtendQuery query) {
		return articleFlowsExtendDao.selectByExample(query);
	}
	
	
	public void deleteArticleFlowsExtendById(Long id) {
		articleFlowsExtendDao.deleteByPrimaryKey(id);
	}
	
	
	public void deleteArticleFlowsExtend(ArticleFlowsExtendQuery query) {
		articleFlowsExtendDao.deleteByExample(query);
	}
	
	
	public ArticleFlowsExtendPage queryPageList(ArticleFlowsExtendQuery query) {
		ArticleFlowsExtendPage articleFlowsExtendPage = new ArticleFlowsExtendPage();
		Integer itemCount = articleFlowsExtendDao.countByExample(query);
		query.setItemCount(itemCount);
		
		if (itemCount == 0) {
			articleFlowsExtendPage.setValues(null);
		} else {
			articleFlowsExtendPage.setValues(articleFlowsExtendDao.selectPageByExample(query));
		}
		
		articleFlowsExtendPage.setPagenation(new Pagenation(query.getPageNo(),query.getPageSize(),query.getItemCount()));
		return articleFlowsExtendPage;
	}
}

