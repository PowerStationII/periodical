/*
 * Powered By code-generator
 * Since 2015 - 2015
 */

package com.cn.periodical.manager.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.cn.periodical.dao.ArticleInfoExtendDao;
import com.cn.periodical.manager.ArticleInfoExtendManager;
import com.cn.periodical.pojo.ArticleInfoExtend;
import com.cn.periodical.pojo.ArticleInfoExtendPage;
import com.cn.periodical.pojo.ArticleInfoExtendQuery;
import com.cn.periodical.utils.Pagenation;

@Component("articleInfoExtendManager")
public class ArticleInfoExtendManagerImpl implements ArticleInfoExtendManager {
	
	@Autowired
	@Qualifier("articleInfoExtendDao")
	private ArticleInfoExtendDao articleInfoExtendDao;
	
	
	public void saveArticleInfoExtend(ArticleInfoExtend articleInfoExtend) {
		if (articleInfoExtend.getId() == null) {
			articleInfoExtendDao.insertSelective(articleInfoExtend);
		} else {
			articleInfoExtendDao.updateByPrimaryKeySelective(articleInfoExtend);
		}
	}
	
	
	public ArticleInfoExtend findArticleInfoExtendById(Long id) {
		return articleInfoExtendDao.selectByPrimaryKey(id);
	}
    public ArticleInfoExtend selectByArticleIdKey(ArticleInfoExtendQuery example) {
		return articleInfoExtendDao.selectByArticleIdKey(example);
	}

	
	public List<ArticleInfoExtend> queryList(ArticleInfoExtendQuery query) {
		return articleInfoExtendDao.selectByExample(query);
	}
	
	
	public void deleteArticleInfoExtendById(Long id) {
		articleInfoExtendDao.deleteByPrimaryKey(id);
	}
	
	
	public void deleteArticleInfoExtend(ArticleInfoExtendQuery query) {
		articleInfoExtendDao.deleteByExample(query);
	}
	
	
	public ArticleInfoExtendPage queryPageList(ArticleInfoExtendQuery query) {
		ArticleInfoExtendPage articleInfoExtendPage = new ArticleInfoExtendPage();
		Integer itemCount = articleInfoExtendDao.countByExample(query);
		query.setItemCount(itemCount);
		
		if (itemCount == 0) {
			articleInfoExtendPage.setValues(null);
		} else {
			articleInfoExtendPage.setValues(articleInfoExtendDao.selectPageByExample(query));
		}
		
		articleInfoExtendPage.setPagenation(new Pagenation(query.getPageNo(),query.getPageSize(),query.getItemCount()));
		return articleInfoExtendPage;
	}
}

