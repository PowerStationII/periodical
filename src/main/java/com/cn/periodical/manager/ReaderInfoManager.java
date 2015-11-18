/*
 * Powered By code-generator
 * Since 2015 - 2015
 */

package com.cn.periodical.manager;

import java.util.List;

import com.cn.periodical.pojo.ReaderInfo;
import com.cn.periodical.pojo.ReaderInfoPage;
import com.cn.periodical.pojo.ReaderInfoQuery;

public interface ReaderInfoManager {
	void saveReaderInfo(ReaderInfo readerInfo);

	ReaderInfo findReaderInfoById(Long id);
	
	List<ReaderInfo> queryList(ReaderInfoQuery query);
	
	void deleteReaderInfoById(Long id);
	
	void deleteReaderInfo(ReaderInfoQuery query);
	
	ReaderInfoPage queryPageList(ReaderInfoQuery query);
}
