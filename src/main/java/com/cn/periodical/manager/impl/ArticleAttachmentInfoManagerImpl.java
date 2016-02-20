/*
 * Powered By code-generator
 * Since 2015 - 2015
 */

package com.cn.periodical.manager.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.cn.periodical.dao.ArticleAttachmentInfoDao;
import com.cn.periodical.manager.ArticleAttachmentInfoManager;
import com.cn.periodical.pojo.ArticleAttachmentInfo;
import com.cn.periodical.pojo.ArticleAttachmentInfoPage;
import com.cn.periodical.pojo.ArticleAttachmentInfoQuery;
import com.cn.periodical.utils.Pagenation;

@Component("articleAttachmentInfoManager")
public class ArticleAttachmentInfoManagerImpl implements ArticleAttachmentInfoManager {
	
	@Autowired
	@Qualifier("articleAttachmentInfoDao")
	private ArticleAttachmentInfoDao articleAttachmentInfoDao;
	
	
	public void saveArticleAttachmentInfo(ArticleAttachmentInfo articleAttachmentInfo) {
		if (articleAttachmentInfo.getId() == null) {
			articleAttachmentInfoDao.insertSelective(articleAttachmentInfo);
		} else {
			articleAttachmentInfoDao.updateByPrimaryKeySelective(articleAttachmentInfo);
		}
	}
	
	
	public ArticleAttachmentInfo findArticleAttachmentInfoById(Long id) {
		return articleAttachmentInfoDao.selectByPrimaryKey(id);
	}
	
	
	public List<ArticleAttachmentInfo> queryList(ArticleAttachmentInfoQuery query) {
		return articleAttachmentInfoDao.selectByExample(query);
	}
	
	
	public void deleteArticleAttachmentInfoById(Long id) {
		articleAttachmentInfoDao.deleteByPrimaryKey(id);
	}
	
	
	public void deleteArticleAttachmentInfo(ArticleAttachmentInfoQuery query) {
		articleAttachmentInfoDao.deleteByExample(query);
	}
	
	
	public ArticleAttachmentInfoPage queryPageList(ArticleAttachmentInfoQuery query) {
		ArticleAttachmentInfoPage articleAttachmentInfoPage = new ArticleAttachmentInfoPage();
		Integer itemCount = articleAttachmentInfoDao.countByExample(query);
		query.setItemCount(itemCount);
		
		if (itemCount == 0) {
			articleAttachmentInfoPage.setValues(null);
		} else {
			articleAttachmentInfoPage.setValues(articleAttachmentInfoDao.selectPageByExample(query));
		}
		
		articleAttachmentInfoPage.setPagenation(new Pagenation(query.getPageNo(),query.getPageSize(),query.getItemCount()));
		return articleAttachmentInfoPage;
	}

    public List<ArticleAttachmentInfo>  queryAttByArtcicle(String article){
        return articleAttachmentInfoDao.queryAttByArtcicle(article);
    }
    public List<ArticleAttachmentInfo>  queryAttByArtcicleIds(List<String> list){
        return articleAttachmentInfoDao.queryAttByArtcicleIds(list);
    }
}

