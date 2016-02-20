/*
 * Powered By code-generator
 * Since 2015 - 2015
 */

package com.cn.periodical.dao;

import java.util.List;

import com.cn.periodical.pojo.BizCouncil;
import com.cn.periodical.pojo.BizCouncilQuery;
import com.cn.periodical.pojo.CouncilInfo;
import com.cn.periodical.pojo.CouncilInfoQuery;

public interface CouncilInfoDao {
	int countByExample(CouncilInfoQuery example);
	
	int deleteByExample(CouncilInfoQuery example);
	
	int deleteByPrimaryKey(Long id);
	
	int insert(CouncilInfo record);
	
	int insertSelective(CouncilInfo record);
	
	List<CouncilInfo> selectByExample(CouncilInfoQuery example);
	
	List<CouncilInfo> selectPageByExample(CouncilInfoQuery example);
	
	CouncilInfo selectByPrimaryKey(Long id);
	
	int updateByPrimaryKeySelective(CouncilInfo record);
	
	int updateByPrimaryKey(CouncilInfo record);
	
	public List<BizCouncil> queryBizCouncil(BizCouncil reqDto);
	public List<BizCouncil> queryBizCouncilPage(BizCouncilQuery reqDto);
	public int queryBizCouncilPageCount(BizCouncilQuery reqDto);
}
