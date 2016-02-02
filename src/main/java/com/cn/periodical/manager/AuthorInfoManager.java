/*
 * Powered By code-generator
 * Since 2015 - 2015
 */

package com.cn.periodical.manager;

import java.util.List;
import java.util.Map;

import com.cn.periodical.pojo.AuthorInfo;
import com.cn.periodical.pojo.AuthorInfoPage;
import com.cn.periodical.pojo.AuthorInfoQuery;

public interface AuthorInfoManager {
	void saveAuthorInfo(AuthorInfo authorInfo);

	AuthorInfo findAuthorInfoById(Long id);

    public List<AuthorInfo> selectByArticleIdKey(String articleId);
	
	List<AuthorInfo> queryList(AuthorInfoQuery query);
	
	void deleteAuthorInfoById(Long id);
	
	void deleteAuthorInfo(AuthorInfoQuery query);
	
	AuthorInfoPage queryPageList(AuthorInfoQuery query);

    public List<Object> selectAuthorByArticl(String atricleId);
}
