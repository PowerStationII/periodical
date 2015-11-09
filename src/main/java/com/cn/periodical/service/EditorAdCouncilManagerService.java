package com.cn.periodical.service;

import java.util.List;

import com.cn.periodical.pojo.CouncilInfo;
import com.cn.periodical.request.EditorAdCouncilManagerReqDto;

public interface EditorAdCouncilManagerService {

	public int saveCouncilInfo(EditorAdCouncilManagerReqDto adCouncilManagerReqDto);
	public List<CouncilInfo> queryCouncilInfo(EditorAdCouncilManagerReqDto adCouncilManagerReqDto);
		
}
