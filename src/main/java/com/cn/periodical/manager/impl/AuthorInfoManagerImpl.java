/*
 * Powered By code-generator
 * Since 2015 - 2015
 */

package com.cn.periodical.manager.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.cn.periodical.dao.AuthorInfoDao;
import com.cn.periodical.manager.AuthorInfoManager;
import com.cn.periodical.pojo.AuthorInfo;
import com.cn.periodical.pojo.AuthorInfoPage;
import com.cn.periodical.pojo.AuthorInfoQuery;
import com.cn.periodical.utils.Pagenation;

@Component("authorInfoManager")
public class AuthorInfoManagerImpl implements AuthorInfoManager {
	
	@Autowired
	@Qualifier("authorInfoDao")
	private AuthorInfoDao authorInfoDao;
	

	public void saveAuthorInfo(AuthorInfo authorInfo) {
		if (authorInfo.getId() == null) {
			authorInfoDao.insertSelective(authorInfo);
		} else {
			authorInfoDao.updateByPrimaryKeySelective(authorInfo);
		}
	}
	

	public AuthorInfo findAuthorInfoById(Long id) {
		return authorInfoDao.selectByPrimaryKey(id);
	}
    public List<AuthorInfo> selectByArticleIdKey(String articleId)  {
		return authorInfoDao.selectByArticleIdKey(articleId);
	}


	public List<AuthorInfo> queryList(AuthorInfoQuery query) {
		return authorInfoDao.selectByExample(query);
	}
	

	public void deleteAuthorInfoById(Long id) {
		authorInfoDao.deleteByPrimaryKey(id);
	}
	

	public void deleteAuthorInfo(AuthorInfoQuery query) {
		authorInfoDao.deleteByExample(query);
	}
	

	public AuthorInfoPage queryPageList(AuthorInfoQuery query) {
		AuthorInfoPage authorInfoPage = new AuthorInfoPage();
		Integer itemCount = authorInfoDao.countByExample(query);
		query.setItemCount(itemCount);
		
		if (itemCount == 0) {
			authorInfoPage.setValues(null);
		} else {
			authorInfoPage.setValues(authorInfoDao.selectPageByExample(query));
		}
		
		authorInfoPage.setPagenation(new Pagenation(query.getPageNo(),query.getPageSize(),query.getItemCount()));
		return authorInfoPage;
	}

    public List<Object> selectAuthorByArticl(String atricleId){
        return authorInfoDao.selectAuthorByArticl(atricleId);
    }
}

