/*
 * Powered By code-generator
 * Since 2015 - 2015
 */

package com.cn.periodical.manager;

import java.util.List;

import com.cn.periodical.pojo.*;

public interface CouncilInfoManager {
	void saveCouncilInfo(CouncilInfo councilInfo);

	CouncilInfo findCouncilInfoById(Long id);
	
	List<CouncilInfo> queryList(CouncilInfoQuery query);
	
	void deleteCouncilInfoById(Long id);
	
	void deleteCouncilInfo(CouncilInfoQuery query);
	
	CouncilInfoPage queryPageList(CouncilInfoQuery query);
	
	public List<BizCouncil> queryBizCouncil(BizCouncil reqDto);
	public List<BizCouncil> queryBizCouncilPage(BizCouncilQuery reqDto);
	public int queryBizCouncilPageCount(BizCouncilQuery reqDto);

}
