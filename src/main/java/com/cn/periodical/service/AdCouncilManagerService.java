package com.cn.periodical.service;

import java.util.List;

import com.cn.periodical.pojo.BizCouncil;
import com.cn.periodical.request.AdCouncilManagerReqDto;

public interface AdCouncilManagerService {

	public int saveCouncilInfo(AdCouncilManagerReqDto reqDto);
	public List<BizCouncil> queryCouncilInfo(BizCouncil reqDto);
	
	public AdCouncilManagerReqDto queryAdCouncilInfoDetail(String councilId);
		
}
