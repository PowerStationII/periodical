/*
 * Powered By code-generator
 * Since 2015 - 2015
 */

package com.cn.periodical.dao;

import java.util.List;

import com.cn.periodical.pojo.BizEditor;
import com.cn.periodical.pojo.EditorInfo;
import com.cn.periodical.pojo.EditorInfoQuery;

public interface EditorInfoDao {
	int countByExample(EditorInfoQuery example);
	
	int deleteByExample(EditorInfoQuery example);
	
	int deleteByPrimaryKey(Long id);
	
	int insert(EditorInfo record);
	
	int insertSelective(EditorInfo record);
	
	List<EditorInfo> selectByExample(EditorInfoQuery example);
	
	List<EditorInfo> selectPageByExample(EditorInfoQuery example);
	
	EditorInfo selectByPrimaryKey(Long id);
	
	List<BizEditor>  queryEditors (BizEditor bizEditor);
	
	int updateByPrimaryKeySelective(EditorInfo record);
	
	int updateByPrimaryKey(EditorInfo record);
}
