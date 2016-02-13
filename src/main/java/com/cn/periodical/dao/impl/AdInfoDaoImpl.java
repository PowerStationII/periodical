/*
 * Powered By code-generator
 * Since 2015 - 2015
 */

package com.cn.periodical.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.cn.periodical.dao.AdInfoDao;
import com.cn.periodical.pojo.AdInfo;
import com.cn.periodical.pojo.AdInfoQuery;
import com.cn.periodical.pojo.BizAd;
import com.cn.periodical.pojo.BizAdQuery;
import com.cn.periodical.dao.BaseDao;

@Repository("adInfoDao")
public class AdInfoDaoImpl extends BaseDao implements AdInfoDao {
	
	
	public int countByExample(AdInfoQuery example) {
		return super.getSqlSession().selectOne("AdInfoMapper.countByExample", example);
	}
	
	
	public int deleteByExample(AdInfoQuery example) {
		return super.getSqlSession().delete("AdInfoMapper.deleteByExample", example);
	}
	
	
	public int deleteByPrimaryKey(Long id) {
		return super.getSqlSession().delete("AdInfoMapper.deleteByPrimaryKey", id);
	}
	
	
	public int insert(AdInfo record) {
		return super.getSqlSession().insert("AdInfoMapper.insert", record);
	}
	
	
	public int insertSelective(AdInfo record) {
		return super.getSqlSession().insert("AdInfoMapper.insertSelective", record);
	}
	
	
	public List<AdInfo> selectByExample(AdInfoQuery example) {
		return super.getSqlSession().selectList("AdInfoMapper.selectByExample", example);
	}
	
	
	public List<AdInfo> selectPageByExample(AdInfoQuery example) {
		return super.getSqlSession().selectList("AdInfoMapper.selectPageByExample", example);
	}
	
	
	public AdInfo selectByPrimaryKey(Long id) {
		return super.getSqlSession().selectOne("AdInfoMapper.selectByPrimaryKey", id);
	}
	
	
	public int updateByPrimaryKeySelective(AdInfo record) {
		return super.getSqlSession().update("AdInfoMapper.updateByPrimaryKeySelective", record);
	}
	
	
	public int updateByPrimaryKey(AdInfo record) {
		return super.getSqlSession().update("AdInfoMapper.updateByPrimaryKey", record);
	}


	public List<BizAd> selectAdsForEditor(BizAd bizAd) {
		// TODO Auto-generated method stub
		return super.getSqlSession().selectList("AdInfoMapper.selectAdsForEditor", bizAd);
	}


	public int countByBizAd(BizAdQuery example) {
		// TODO Auto-generated method stub
		return super.getSqlSession().selectOne("AdInfoMapper.countByBizAd", example);
	}

	public List<BizAd> selectPageByBizAd(BizAdQuery example) {
		// TODO Auto-generated method stub
		return super.getSqlSession().selectList("AdInfoMapper.selectPageByBizAd", example);
	}
	
}
