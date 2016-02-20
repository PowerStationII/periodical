/*
 * Powered By code-generator
 * Since 2015 - 2015
 */

package com.cn.periodical.dao;

import java.util.List;

import com.cn.periodical.pojo.ArticleAttachmentInfo;
import com.cn.periodical.pojo.ArticleAttachmentInfoQuery;

public interface ArticleAttachmentInfoDao {
	int countByExample(ArticleAttachmentInfoQuery example);
	
	int deleteByExample(ArticleAttachmentInfoQuery example);
	
	int deleteByPrimaryKey(Long id);
	
	int insert(ArticleAttachmentInfo record);
	
	int insertSelective(ArticleAttachmentInfo record);
	
	List<ArticleAttachmentInfo> selectByExample(ArticleAttachmentInfoQuery example);
	
	List<ArticleAttachmentInfo> selectPageByExample(ArticleAttachmentInfoQuery example);
	
	ArticleAttachmentInfo selectByPrimaryKey(Long id);
	
	int updateByPrimaryKeySelective(ArticleAttachmentInfo record);
	
	int updateByPrimaryKey(ArticleAttachmentInfo record);

    public List<ArticleAttachmentInfo>  queryAttByArtcicle(String article);
    public List<ArticleAttachmentInfo>  queryAttByArtcicleIds (List<String> list);
}
