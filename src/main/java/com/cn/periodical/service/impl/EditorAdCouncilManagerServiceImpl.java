package com.cn.periodical.service.impl;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cn.periodical.manager.CouncilInfoManager;
import com.cn.periodical.pojo.CouncilInfo;
import com.cn.periodical.pojo.CouncilInfoQuery;
import com.cn.periodical.request.EditorAdCouncilManagerReqDto;
import com.cn.periodical.service.EditorAdCouncilManagerService;

@Service
public class EditorAdCouncilManagerServiceImpl implements EditorAdCouncilManagerService {

	@Autowired
	CouncilInfoManager councilInfoManager;

	public EditorAdCouncilManagerServiceImpl() {
		// TODO Auto-generated constructor stub
	}

	public int saveCouncilInfo(EditorAdCouncilManagerReqDto adCouncilManagerReqDto) {
		// TODO Auto-generated method stub
		CouncilInfo councilInfo = new CouncilInfo();
		councilInfo.setCompanySetupTime(new DateTime(adCouncilManagerReqDto.getCompanySetupTime()).toDate());
		councilInfo.setContactEmail(adCouncilManagerReqDto.getContactEmail());
		councilInfo.setContactMobileno(adCouncilManagerReqDto.getContactMobileno());
		councilInfo.setContactName(adCouncilManagerReqDto.getContactName());
		councilInfo.setContactQq(adCouncilManagerReqDto.getContactQq());
		councilInfo.setContactSex(adCouncilManagerReqDto.getContactSex());
		councilInfo.setContactTelephone(adCouncilManagerReqDto.getContactTelephone());
		councilInfo.setCouncilCompany(adCouncilManagerReqDto.getCouncilCompany());
		councilInfo.setCouncilId(UUID.randomUUID().toString().replaceAll("-", ""));
		councilInfo.setCouncilType(adCouncilManagerReqDto.getCouncilType());
		councilInfo.setCouncilName(adCouncilManagerReqDto.getCouncilName());
		councilInfo.setCreateTime(new Date());
		// councilInfo.setEmployeeNums(adCouncilManagerReqDto.get);
		councilInfo.setExtend1("");
		councilInfo.setExtend2("");
		councilInfo.setExtend3("");
		councilInfo.setExtend4("");
		councilInfo.setIsad("");
		councilInfo.setWebsite(adCouncilManagerReqDto.getWebsite());
		councilInfo.setUpdateTime(null);
		councilInfo.setRanges(adCouncilManagerReqDto.getRanges());
		councilInfo.setLogoUrl(adCouncilManagerReqDto.getLogoUrl());
		councilInfo.setLegalTelephone(adCouncilManagerReqDto.getLegalTelephone());
		councilInfo.setLegalSex(adCouncilManagerReqDto.getLegalSex());
		councilInfo.setLegalNation(adCouncilManagerReqDto.getLegalNation());
		councilInfo.setLegalName(adCouncilManagerReqDto.getLegalName());
		councilInfo.setLegalEmail(adCouncilManagerReqDto.getLegalEmail());
		councilInfo.setLegalDuties(adCouncilManagerReqDto.getLegalDuties());
		councilInfo.setIspayfees("");
		councilInfo.setIscouncil("");
		councilInfo.setIsad("");
		councilInfoManager.saveCouncilInfo(councilInfo);

		return 0;
	}

	public List<CouncilInfo> queryCouncilInfo(EditorAdCouncilManagerReqDto adCouncilManagerReqDto) {
		// TODO Auto-generated method stub
		if (adCouncilManagerReqDto == null) {
			CouncilInfoQuery councilInfoQuery = new CouncilInfoQuery();
			// councilInfoQuery.set
			List<CouncilInfo> councilInfos = councilInfoManager.queryList(councilInfoQuery);
			return councilInfos;
		} else {
			CouncilInfoQuery councilInfoQuery = new CouncilInfoQuery();
			councilInfoQuery.setCouncilName(adCouncilManagerReqDto.getCouncilName());
			councilInfoQuery.setCouncilId(adCouncilManagerReqDto.getCouncilId());
			councilInfoQuery.setCouncilCompany(adCouncilManagerReqDto.getCouncilCompany());
			List<CouncilInfo> councilInfos = councilInfoManager.queryList(councilInfoQuery);
			return councilInfos;
		}
	}

//	public List<CouncilInfo> queryCouncilInfo(AdCouncilManagerReqDto reqDto) {
//		// TODO Auto-generated method stub
//		if (reqDto == null) {
//			CouncilInfoQuery councilInfoQuery = new CouncilInfoQuery();
//			// councilInfoQuery.set
//			List<CouncilInfo> councilInfos = councilInfoManager.queryList(councilInfoQuery);
//			return councilInfos;
//		} else {
//			CouncilInfoQuery councilInfoQuery = new CouncilInfoQuery();
//			councilInfoQuery.setContactName(reqDto.getCouncilName());
//			councilInfoQuery.setCouncilId(reqDto.getCouncilId());
//			councilInfoQuery.setCouncilCompany(reqDto.getCouncilName());
//			List<CouncilInfo> councilInfos = councilInfoManager.queryList(councilInfoQuery);
//			return councilInfos;
//		}
//	}

}
