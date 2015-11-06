package com.cn.periodical.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.cn.periodical.manager.CouncilInfoManager;
import com.cn.periodical.pojo.CouncilInfo;
import com.cn.periodical.request.EditorAdCouncilManagerReqDto;
import com.cn.periodical.service.EditorAdCouncilManagerService;

public class EditorAdCouncilManagerServiceImpl implements EditorAdCouncilManagerService{

	@Autowired
	CouncilInfoManager councilInfoManager;
	
	public EditorAdCouncilManagerServiceImpl() {
		// TODO Auto-generated constructor stub
	}

	public int saveCouncilInfo(EditorAdCouncilManagerReqDto adCouncilManagerReqDto) {
		// TODO Auto-generated method stub
		CouncilInfo councilInfo = new CouncilInfo();
//		councilInfo.set
		
		
		
		
		return 0;
	}

}
