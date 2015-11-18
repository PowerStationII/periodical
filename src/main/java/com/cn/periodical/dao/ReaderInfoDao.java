/*
 * Powered By code-generator
 * Since 2015 - 2015
 */

package com.cn.periodical.dao;

import java.util.List;

import com.cn.periodical.pojo.ReaderInfo;
import com.cn.periodical.pojo.ReaderInfoQuery;

public interface ReaderInfoDao {
	int countByExample(ReaderInfoQuery example);
	
	int deleteByExample(ReaderInfoQuery example);
	
	int deleteByPrimaryKey(Long id);
	
	int insert(ReaderInfo record);
	
	int insertSelective(ReaderInfo record);
	
	List<ReaderInfo> selectByExample(ReaderInfoQuery example);
	
	List<ReaderInfo> selectPageByExample(ReaderInfoQuery example);
	
	ReaderInfo selectByPrimaryKey(Long id);
	
	int updateByPrimaryKeySelective(ReaderInfo record);
	
	int updateByPrimaryKey(ReaderInfo record);
}
