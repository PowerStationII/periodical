package com.cn.periodical.controller.editor;

import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.cn.periodical.manager.PeriodicalInfoManager;
import com.cn.periodical.manager.SectionInfoManager;
import com.cn.periodical.pojo.PeriodicalInfo;
import com.cn.periodical.pojo.PeriodicalInfoQuery;
import com.cn.periodical.pojo.SectionInfo;
import com.cn.periodical.pojo.SectionInfoQuery;
import com.cn.periodical.pojo.UserInfo;

/**
 * 主编-期刊栏目管理
 * */
@Controller
public class SectionManagerController extends EditorController {
	
	@Autowired
	SectionInfoManager sectionInfoManager;
	
	@Autowired
	PeriodicalInfoManager periodicalInfoManager;
	
	private static final Logger logger = LoggerFactory.getLogger(SectionManagerController.class);
	public SectionManagerController() {
		// TODO Auto-generated constructor stub
	}
	/**
	 * toSectionManagerPage
	 * 期刊栏目管理
	 */
	@RequestMapping(value="/toSectionManagerPage",method = RequestMethod.GET)
	public ModelAndView toSectionManagerPage(HttpServletRequest request,@ModelAttribute SectionInfoQuery query,
			@RequestParam("periodicalId") String periodicalId) {
		UserInfo userInfo = getUserInfo(request);
		logger.info("期刊栏目管理首页Page in:["+periodicalId+"]");
		ModelAndView mav = new ModelAndView("editor_sectionManagerPage");
		/**
		 * 期刊栏目管理首页查询
		 * 根据periodicalId查询该期刊下的所有栏目
		 * 
		 * 查询一个list列表,页面展示用
		 * */
        PeriodicalInfoQuery periodicalInfoQuery = new PeriodicalInfoQuery ();
        periodicalInfoQuery.setPeriodicalId(periodicalId);
        periodicalInfoQuery.setPeriodicalYear("");
 		PeriodicalInfo p= periodicalInfoManager.selectByPeriodicalId(periodicalInfoQuery);
		
		mav.addObject("periodical", p);
		
		query.setPeriodicalId(periodicalId);
		List<SectionInfo> lists = sectionInfoManager.queryList(query);
		mav.addObject("list", lists);
		
		logger.info("期刊栏目管理首页Page out:[]");
		return mav;
	}
	
	@RequestMapping(value = "/toSectionInfoAdd")
	public ModelAndView toSectionInfoAdd(@RequestParam("periodicalId") String periodicalId) {
		ModelAndView mav = new ModelAndView("editor_SectionInfoDetailPage");
		PeriodicalInfoQuery query = new PeriodicalInfoQuery();
		query.setPeriodicalId(periodicalId);
		List<PeriodicalInfo> list = periodicalInfoManager.queryList(query);
		mav.addObject("periodical", list.get(0));
		return mav;
	}
	
	@RequestMapping(value = "/isSecNameExsit")
	@ResponseBody
	public boolean isSecNameExsit(HttpServletRequest request,String name,String value) {
		SectionInfoQuery query = new SectionInfoQuery();
		query.setSectionName(name);
		query.setPeriodicalId(value);
		List<SectionInfo> pInfos = sectionInfoManager.queryList(query);
		if(pInfos!=null && pInfos.size()>=1){
			return true;
		}
		return false;
	}
	
	/**
	 * 保存栏目信息
	 */
	@RequestMapping(value = "/toSaveSectionInfo")
	public ModelAndView toSaveSectionInfo(@ModelAttribute SectionInfo sectionInfo,
			@RequestParam("periodicalId") String periodicalId) {
		ModelAndView mav = new ModelAndView("redirect:../editor/toSectionManagerPage");
		mav.addObject("periodicalId", periodicalId);
		logger.info("新增期刊下栏目信息 in:["+JSON.toJSONString(sectionInfo)+"]");
		try {
			/**
			 * 1,保存PeriodicalInfo到Periodical_info表
			 * */
			String sectionId = UUID.randomUUID().toString().replaceAll("-", "");
			sectionInfo.setSectionId(sectionId);
			sectionInfo.setPeriodicalId(periodicalId);
			/**
			 * 如果是广告类型,则extend1变为Y
			 * 否则默认为N
			 * */
			if("0001".equals(sectionInfo.getState())){
				sectionInfo.setExtend1("Y");
			}else{
				sectionInfo.setExtend1("N");
			}
			sectionInfoManager.saveSectionInfo(sectionInfo);
			
		} catch (Exception e) {
			//记录错误日志
			logger.error("新增期刊信息异常!", e);
			return new ModelAndView("error");
		}
		return mav;
	}
	
	/**
	 * 删除栏目信息
	 */
	@RequestMapping(value = "/toDeleteSectionInfo")
	public ModelAndView toDeleteSectionInfo(@RequestParam("sectionId") String sectionId,
			@RequestParam("periodicalId") String periodicalId) {
		ModelAndView mav = new ModelAndView("redirect:../editor/toSectionManagerPage");
		mav.addObject("periodicalId", periodicalId);
		logger.info("删除期刊下栏目信息 in:["+JSON.toJSONString(sectionId)+"]");
		try {
			/**
			 * 根据sectionId删除sectionInfo信息
			 * */
			SectionInfoQuery query=new SectionInfoQuery();
			query.setSectionId(sectionId);
			sectionInfoManager.deleteSectionInfo(query);
		} catch (Exception e) {
			//记录错误日志
			logger.error("删除期刊信息异常!", e);
			return new ModelAndView("error");
		}
		return mav;
	}
	
	
//	@RequestMapping(value = "/toSectionInfoUpdate")
//	public ModelAndView toSectionInfoUpdate(@RequestParam("periodicalId") String periodicalId) {
//		ModelAndView mav = new ModelAndView("editor_sectionInfoUpdatePage");
//		PeriodicalInfoQuery query = new PeriodicalInfoQuery();
//		query.setPeriodicalId(periodicalId);
//		List<PeriodicalInfo> list = periodicalInfoManager.queryList(query);
//		mav.addObject("periodical", list.get(0));
//		return mav;
//	}
}
