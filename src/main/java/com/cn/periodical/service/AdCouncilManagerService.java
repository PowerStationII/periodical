package com.cn.periodical.service;

import java.util.List;

import com.cn.periodical.pojo.BizCouncil;
import com.cn.periodical.pojo.BizCouncilPage;
import com.cn.periodical.pojo.BizCouncilQuery;
import com.cn.periodical.request.AdCouncilManagerReqDto;

public interface AdCouncilManagerService {

	public int saveCouncilInfo(AdCouncilManagerReqDto reqDto);
	public List<BizCouncil> queryCouncilInfo(BizCouncil reqDto);
	public BizCouncilPage queryCouncilInfoPage(BizCouncilQuery reqDto,int count);
	public int queryCouncilInfoPageCount(BizCouncilQuery reqDto);

	public AdCouncilManagerReqDto queryAdCouncilInfoDetail(String councilId);
		
}
