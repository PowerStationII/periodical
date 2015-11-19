/*
 * Powered By code-generator
 * Since 2015 - 2015
 */

package com.cn.periodical.manager;

import java.util.List;

import com.cn.periodical.pojo.BizCouncil;
import com.cn.periodical.pojo.CouncilInfo;
import com.cn.periodical.pojo.CouncilInfoPage;
import com.cn.periodical.pojo.CouncilInfoQuery;

public interface CouncilInfoManager {
	void saveCouncilInfo(CouncilInfo councilInfo);

	CouncilInfo findCouncilInfoById(Long id);
	
	List<CouncilInfo> queryList(CouncilInfoQuery query);
	
	void deleteCouncilInfoById(Long id);
	
	void deleteCouncilInfo(CouncilInfoQuery query);
	
	CouncilInfoPage queryPageList(CouncilInfoQuery query);
	
	public List<BizCouncil> queryBizCouncil(BizCouncil reqDto);
	
}
