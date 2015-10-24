package com.cn.periodical.manager;

import java.util.List;

import com.cn.periodical.pojo.AuthorInfo;
import com.cn.periodical.pojo.AuthorInfoPage;
import com.cn.periodical.pojo.AuthorInfoQuery;

public interface AuthorInfoManager {
	void saveAuthorInfo(AuthorInfo authorInfo);

	AuthorInfo findAuthorInfoById(Long id);
	
	List<AuthorInfo> queryList(AuthorInfoQuery query);
	
	void deleteAuthorInfoById(Long id);
	
	void deleteAuthorInfo(AuthorInfoQuery query);
	
	AuthorInfoPage queryPageList(AuthorInfoQuery query);
}
