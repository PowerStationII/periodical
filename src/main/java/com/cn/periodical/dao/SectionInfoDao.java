/*
 * Powered By code-generator
 * Since 2015 - 2015
 */

package com.cn.periodical.dao;

import java.util.List;

import com.cn.periodical.pojo.SectionInfo;
import com.cn.periodical.pojo.SectionInfoQuery;

public interface SectionInfoDao {
	int countByExample(SectionInfoQuery example);
	
	int deleteByExample(SectionInfoQuery example);
	
	int deleteByPrimaryKey(Long id);
	
	int insert(SectionInfo record);
	
	int insertSelective(SectionInfo record);
	
	List<SectionInfo> selectByExample(SectionInfoQuery example);
	List<SectionInfo> selectByExampleForAd(SectionInfoQuery example);
	
	List<SectionInfo> selectPageByExample(SectionInfoQuery example);
	
	SectionInfo selectByPrimaryKey(Long id);
	
	int updateByPrimaryKeySelective(SectionInfo record);
	
	int updateByPrimaryKey(SectionInfo record);
	
	/**
	 * 排刊组稿调用sql
	 * */
	List<SectionInfo> queryListForGroupAticle(SectionInfoQuery query);
}
