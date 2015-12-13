/*
 * Powered By code-generator
 * Since 2015 - 2015
 */

package com.cn.periodical.manager;

import java.util.List;

import com.cn.periodical.pojo.SectionInfo;
import com.cn.periodical.pojo.SectionInfoPage;
import com.cn.periodical.pojo.SectionInfoQuery;

public interface SectionInfoManager {
	void saveSectionInfo(SectionInfo sectionInfo);

	SectionInfo findSectionInfoById(Long id);
	
	List<SectionInfo> queryList(SectionInfoQuery query);
	List<SectionInfo> queryListForGroupAticle(SectionInfoQuery query);
	List<SectionInfo> selectByExampleForAd(SectionInfoQuery query);
	
	void deleteSectionInfoById(Long id);
	
	void deleteSectionInfo(SectionInfoQuery query);
	
	SectionInfoPage queryPageList(SectionInfoQuery query);
}
