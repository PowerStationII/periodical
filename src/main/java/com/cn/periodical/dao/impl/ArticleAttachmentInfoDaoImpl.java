/*
 * Powered By code-generator
 * Since 2015 - 2015
 */

package com.cn.periodical.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.cn.periodical.dao.ArticleAttachmentInfoDao;
import com.cn.periodical.pojo.ArticleAttachmentInfo;
import com.cn.periodical.pojo.ArticleAttachmentInfoQuery;
import com.cn.periodical.dao.BaseDao;

@Repository("articleAttachmentInfoDao")
public class ArticleAttachmentInfoDaoImpl extends BaseDao implements ArticleAttachmentInfoDao {
	
	
	public int countByExample(ArticleAttachmentInfoQuery example) {
		return super.getSqlSession().selectOne("ArticleAttachmentInfoMapper.countByExample", example);
	}
	
	
	public int deleteByExample(ArticleAttachmentInfoQuery example) {
		return super.getSqlSession().delete("ArticleAttachmentInfoMapper.deleteByExample", example);
	}
	
	
	public int deleteByPrimaryKey(Long id) {
		return super.getSqlSession().delete("ArticleAttachmentInfoMapper.deleteByPrimaryKey", id);
	}
	
	
	public int insert(ArticleAttachmentInfo record) {
		return super.getSqlSession().insert("ArticleAttachmentInfoMapper.insert", record);
	}
	
	
	public int insertSelective(ArticleAttachmentInfo record) {
		return super.getSqlSession().insert("ArticleAttachmentInfoMapper.insertSelective", record);
	}
	
	
	public List<ArticleAttachmentInfo> selectByExample(ArticleAttachmentInfoQuery example) {
		return super.getSqlSession().selectList("ArticleAttachmentInfoMapper.selectByExample", example);
	}
	
	
	public List<ArticleAttachmentInfo> selectPageByExample(ArticleAttachmentInfoQuery example) {
		return super.getSqlSession().selectList("ArticleAttachmentInfoMapper.selectPageByExample", example);
	}
	
	
	public ArticleAttachmentInfo selectByPrimaryKey(Long id) {
		return super.getSqlSession().selectOne("ArticleAttachmentInfoMapper.selectByPrimaryKey", id);
	}
	
	
	public int updateByPrimaryKeySelective(ArticleAttachmentInfo record) {
		return super.getSqlSession().update("ArticleAttachmentInfoMapper.updateByPrimaryKeySelective", record);
	}
	
	
	public int updateByPrimaryKey(ArticleAttachmentInfo record) {
		return super.getSqlSession().update("ArticleAttachmentInfoMapper.updateByPrimaryKey", record);
	}
	
}
