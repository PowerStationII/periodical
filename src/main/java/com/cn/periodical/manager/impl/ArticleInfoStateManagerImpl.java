/*
 * Powered By code-generator
 * Since 2015 - 2015
 */

package com.cn.periodical.manager.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.cn.periodical.dao.ArticleInfoStateDao;
import com.cn.periodical.manager.ArticleInfoStateManager;
import com.cn.periodical.pojo.ArticleInfoState;
import com.cn.periodical.pojo.ArticleInfoStatePage;
import com.cn.periodical.pojo.ArticleInfoStateQuery;
import com.cn.periodical.utils.Pagenation;

@Component("articleInfoStateManager")
public class ArticleInfoStateManagerImpl implements ArticleInfoStateManager {
	
	@Autowired
	@Qualifier("articleInfoStateDao")
	private ArticleInfoStateDao articleInfoStateDao;
	
	
	public void saveArticleInfoState(ArticleInfoState articleInfoState) {
		if (articleInfoState.getId() == null) {
			articleInfoStateDao.insertSelective(articleInfoState);
		} else {
			articleInfoStateDao.updateByPrimaryKeySelective(articleInfoState);
		}
	}
	
	
	public ArticleInfoState findArticleInfoStateById(Long id) {
		return articleInfoStateDao.selectByPrimaryKey(id);
	}
	
	
	public List<ArticleInfoState> queryList(ArticleInfoStateQuery query) {
		return articleInfoStateDao.selectByExample(query);
	}
	
	
	public void deleteArticleInfoStateById(Long id) {
		articleInfoStateDao.deleteByPrimaryKey(id);
	}
	
	
	public void deleteArticleInfoState(ArticleInfoStateQuery query) {
		articleInfoStateDao.deleteByExample(query);
	}
	
	
	public ArticleInfoStatePage queryPageList(ArticleInfoStateQuery query) {
		ArticleInfoStatePage articleInfoStatePage = new ArticleInfoStatePage();
		Integer itemCount = articleInfoStateDao.countByExample(query);
		query.setItemCount(itemCount);
		
		if (itemCount == 0) {
			articleInfoStatePage.setValues(null);
		} else {
			articleInfoStatePage.setValues(articleInfoStateDao.selectPageByExample(query));
		}
		
		articleInfoStatePage.setPagenation(new Pagenation(query.getPageNo(),query.getPageSize(),query.getItemCount()));
		return articleInfoStatePage;
	}
}

