package com.cn.periodical.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.cn.periodical.dao.ArticleQueryDao;
import com.cn.periodical.dao.BaseDao;
import com.cn.periodical.dao.UserQueryDao;
import com.cn.periodical.request.ArticleQueryReqDto;
import com.cn.periodical.request.UserQueryReqDto;
import com.cn.periodical.response.ArticleQueryRespDto;

@Repository("userQueryDao")
public class UserQueryDaoImpl extends BaseDao implements UserQueryDao {

	public UserQueryDaoImpl() {
		// TODO Auto-generated constructor stub
	}

	public UserQueryReqDto queryUserRef(UserQueryReqDto dto) {
		// TODO Auto-generated method stub
		return super.getSqlSession().selectOne("UserQueryMapper.selectUserQuery", dto);
	}
}
