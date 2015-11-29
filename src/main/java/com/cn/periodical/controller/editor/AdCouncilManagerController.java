package com.cn.periodical.controller.editor;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.cn.periodical.manager.CouncilContractFlowsManager;
import com.cn.periodical.manager.CouncilInfoManager;
import com.cn.periodical.pojo.BizCouncil;
import com.cn.periodical.pojo.CouncilContractFlows;
import com.cn.periodical.pojo.CouncilInfo;
import com.cn.periodical.pojo.CouncilInfoQuery;
import com.cn.periodical.request.AdCouncilManagerReqDto;
import com.cn.periodical.service.AdCouncilManagerService;
/**
 * 广告编辑-会员管理Controller
 * */
@Controller
public class AdCouncilManagerController extends EditorController{
	
	private static final Logger logger = LoggerFactory.getLogger(AdCouncilManagerController.class);
	
	@Autowired
	AdCouncilManagerService adCouncilManagerService;
	@Autowired
	CouncilInfoManager councilInfoManager;
	@Autowired
	CouncilContractFlowsManager councilContractFlowsManager;
	/**
	 * toCouncilManagerPage
	 * 会员管理 End
	 */
	@RequestMapping(value="/toCouncilManagerPage")
	public ModelAndView toCouncilManagerPage(@ModelAttribute BizCouncil reqDto) {
		logger.info("会员管理Page in:["+JSON.toJSONString(reqDto)+"]");
		ModelAndView mav = new ModelAndView("editor_councilManagerPage");
		List<BizCouncil> list = adCouncilManagerService.queryCouncilInfo(reqDto);
		mav.addObject("list", list);
		logger.info("会员管理Page out:["+JSON.toJSONString(list)+"]");
		return mav;
	}
	
	@RequestMapping(value = "/toCouncilInfoAdd", method = RequestMethod.GET)
	public ModelAndView toCouncilInfoAdd() {
		ModelAndView mav = new ModelAndView("editor_councilManagerDetailPage");

		return mav;
	}
	
	/**
	 * 保存理事会及合同数据 End
	 */
	@RequestMapping(value = "/toSaveCouncilInfo", method = { RequestMethod.POST })
	public ModelAndView saveCouncilInfo(@ModelAttribute AdCouncilManagerReqDto reqDto) {
		ModelAndView mav = new ModelAndView("redirect:../editor/toCouncilManagerPage");
		logger.info("保存理事会信息 in:["+JSON.toJSONString(reqDto)+"]");
		try {
			adCouncilManagerService.saveCouncilInfo(reqDto);
		} catch (Exception e) {
			//记录错误日志
			logger.error("保存理事会信息异常!", e);
			return new ModelAndView("error");
		}
		logger.info("保存理事会信息 out:[]");
		return mav;
	}
	
	
	
	/**
	 * 理事会单条记录查询
	 * */
	@RequestMapping(value = "/toQrySingleCouncilInfo")
	public ModelAndView toQrySingleAdInfo(@RequestParam("councilId") String councilId) {
		ModelAndView mav = new ModelAndView("editor_councilManagerEditPage");
		CouncilInfoQuery query =new CouncilInfoQuery();
		query.setCouncilId(councilId);
		List<CouncilInfo> councilInfos = councilInfoManager.queryList(query);
		logger.info("理事会信息...."+councilInfos.size());
		CouncilInfo councilInfo = councilInfos.get(0);
		mav.addObject("c", councilInfo);
		return mav;
	}
	
	/**
	 * 理事会编辑保存Action
	 * */
	@RequestMapping(value = "/toSaveCouncilInfoEdit")
	public ModelAndView toSaveAdInfoEdit(@ModelAttribute CouncilInfo c) {
		logger.info("修改理事会信息:"+JSON.toJSONString(c));
		ModelAndView mav = new ModelAndView("redirect:../editor/toCouncilManagerPage");
		c.setId(c.getId());
		councilInfoManager.saveCouncilInfo(c);
		return mav;
	}
	
	
	/**
	 * 续费页
	 * */
	@RequestMapping(value = "/toRenewPage")
	public ModelAndView toRenewPage(@RequestParam("councilId") String councilId) {
		ModelAndView mav = new ModelAndView("editor_councilFeeManagerEditPage");
		CouncilInfoQuery query =new CouncilInfoQuery();
		query.setCouncilId(councilId);
		List<CouncilInfo> councilInfos = councilInfoManager.queryList(query);
		CouncilInfo councilInfo = councilInfos.get(0);
		mav.addObject("c", councilInfo);
		return mav;
	}

	/**
	 * 续费
	 * */
	@RequestMapping(value = "/toSaveRenewInfo")
	public ModelAndView toSaveRenewInfo(@ModelAttribute CouncilContractFlows ccf) {
		ModelAndView mav = new ModelAndView("redirect:../editor/toCouncilManagerPage");
		/**
		 * 续费信息表中的发票号是否唯一
		 * 因为续费信息表中没有id
		 * */
		councilContractFlowsManager.saveCouncilContractFlows(ccf);
		return mav;
	}
}
