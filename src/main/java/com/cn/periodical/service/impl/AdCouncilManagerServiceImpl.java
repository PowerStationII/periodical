package com.cn.periodical.service.impl;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import com.cn.periodical.pojo.*;
import com.cn.periodical.utils.Pagenation;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cn.periodical.manager.CouncilContractFlowsManager;
import com.cn.periodical.manager.CouncilInfoManager;
import com.cn.periodical.request.AdCouncilManagerReqDto;
import com.cn.periodical.service.AdCouncilManagerService;

@Service
public class AdCouncilManagerServiceImpl implements AdCouncilManagerService {

	@Autowired
	CouncilInfoManager councilInfoManager;
	
	@Autowired
	CouncilContractFlowsManager councilContractFlowsManager;

	public AdCouncilManagerServiceImpl() {
		// TODO Auto-generated constructor stub
	}

	public int saveCouncilInfo(AdCouncilManagerReqDto reqDto) {
		// TODO Auto-generated method stub
		CouncilInfo councilInfo = new CouncilInfo();
		String councilId=UUID.randomUUID().toString().replaceAll("-", "");
		councilInfo.setAddressDetail(reqDto.getAddressDetail());
		councilInfo.setAreaCity(reqDto.getAreaCity());
		councilInfo.setAreaPro(reqDto.getAreaPro());
		councilInfo.setCompanySetupTime(new DateTime(reqDto.getCompanySetupTime()).toDate());
		councilInfo.setContactEmail("");
		councilInfo.setContactMobileno("");
		councilInfo.setContactName(reqDto.getContactName());
		councilInfo.setContactQq("");
		councilInfo.setContactSex("");
		councilInfo.setContactTelephone(reqDto.getContactTelephone());
		councilInfo.setCouncilCompany(reqDto.getCouncilCompany());
		councilInfo.setCouncilId(councilId);
		councilInfo.setCouncilName(reqDto.getCouncilCompany());
		councilInfo.setCouncilType(reqDto.getType());
		councilInfo.setEmployeeNums(reqDto.getEmployeeNums());
		councilInfo.setCreateTime(new Date());
		councilInfo.setIsad("");
		councilInfo.setIscouncil("");
		councilInfo.setIspayfees("");
		councilInfo.setWebsite(reqDto.getWebsite());
		councilInfo.setUpdateTime(null);
		councilInfo.setState("Y");
		councilInfo.setRanges("");
		councilInfo.setPostCode(reqDto.getPostCode());
		councilInfo.setLogoUrl(reqDto.getLogoUrl());
		councilInfo.setLogoName(reqDto.getLogoName());
		councilInfo.setLegalTelephone(reqDto.getLegalTelephone());
		councilInfo.setLegalSex("");
		councilInfo.setLegalNation("");
		councilInfo.setLegalName(reqDto.getLegalName());
		councilInfo.setLegalEmail("");
		councilInfo.setExtend1(reqDto.getExtend1());
		councilInfo.setLegalDuties(reqDto.getLegalDuties());
		
		CouncilContractFlows councilContractFlows = new CouncilContractFlows();
		councilContractFlows.setAmount(Long.valueOf(reqDto.getAmount()));
		councilContractFlows.setContractContacter("");
		councilContractFlows.setContractContacterPhone(reqDto.getContractContacterPhone());
		councilContractFlows.setCouncilId(councilId);
		councilContractFlows.setCreateTime(new Date());
		councilContractFlows.setEndTime(new DateTime(reqDto.getEndTime()).toDate());
		councilContractFlows.setInvoiceNo(reqDto.getInvoiceNo());
		councilContractFlows.setIsLatelyRecord("N");
		councilContractFlows.setStartTime(new DateTime(reqDto.getStartTime()).toDate());
		councilContractFlows.setPayState("N");
		councilContractFlows.setUpdateTime(null);
		
		councilInfoManager.saveCouncilInfo(councilInfo);
		councilContractFlowsManager.saveCouncilContractFlows(councilContractFlows);
		
		return 0;
	}

	public List<BizCouncil> queryCouncilInfo(BizCouncil reqDto) {
		List<BizCouncil> list = councilInfoManager.queryBizCouncil(reqDto);
		return list;
	}
	public BizCouncilPage queryCouncilInfoPage(BizCouncilQuery query,int itemCount) {
        BizCouncilPage adInfoPage = new BizCouncilPage();
        if (itemCount == 0) {
            adInfoPage.setValues(null);
        } else {
            adInfoPage.setValues(councilInfoManager.queryBizCouncilPage(query));
        }
        adInfoPage.setPagenation(new Pagenation(query.getPageNo(),query.getPageSize(),query.getItemCount()));
        return adInfoPage;
	}
	public int queryCouncilInfoPageCount(BizCouncilQuery reqDto) {
		int count = councilInfoManager.queryBizCouncilPageCount(reqDto);
		return count;
	}

	public AdCouncilManagerReqDto queryAdCouncilInfoDetail(String councilId) {
		// TODO Auto-generated method stub
		
		
		
		return null;
	}

}
