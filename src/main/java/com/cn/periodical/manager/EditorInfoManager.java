/*
 * Powered By code-generator
 * Since 2015 - 2015
 */

package com.cn.periodical.manager;

import java.util.List;

import com.cn.periodical.pojo.BizEditor;
import com.cn.periodical.pojo.EditorInfo;
import com.cn.periodical.pojo.EditorInfoPage;
import com.cn.periodical.pojo.EditorInfoQuery;

public interface EditorInfoManager {
	void saveEditorInfo(EditorInfo editorInfo);

	EditorInfo findEditorInfoById(Long id);
	
	List<EditorInfo> queryList(EditorInfoQuery query);
	
	void deleteEditorInfoById(Long id);
	
	void deleteEditorInfo(EditorInfoQuery query);
	List<BizEditor>  queryEditors(BizEditor bizEditor);
	EditorInfoPage queryPageList(EditorInfoQuery query);
}
