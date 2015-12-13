package com.cn.periodical.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.cn.periodical.manager.SectionInfoManager;
import com.cn.periodical.pojo.SectionInfo;
import com.cn.periodical.pojo.SectionInfoQuery;


/**
 * 数据库数据查询
 */
@Controller 
public class DataBaseUtilsController {

	private static final Logger logger = LoggerFactory.getLogger(DataBaseUtilsController.class);

	@Autowired
	SectionInfoManager sectionInfoManager;
	
	/**
	 * 根据期刊id查询栏目信息
	 */
	@RequestMapping(value="/toQuerySectionInfos")
	@ResponseBody
	public JSONArray toQuerySectionInfos(String periodicalId) {
		SectionInfoQuery query = new SectionInfoQuery();
		query.setPeriodicalId(periodicalId);
		query.setExtend1("N");
		List<SectionInfo> sectionInfos = sectionInfoManager.queryList(query);
		JSONArray a = new JSONArray();
		for (int i=0;i<sectionInfos.size();i++){
			JSONObject j = new JSONObject();
			j.put("id", sectionInfos.get(i).getSectionId());
			j.put("text", sectionInfos.get(i).getSectionName());
			j.put("value", sectionInfos.get(i).getSectionId());
			a.add(j);
		}
		return a;
	}
}
