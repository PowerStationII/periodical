package com.cn.periodical.controller.editor;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import com.cn.periodical.enums.ArticalCodeEnums;
import com.cn.periodical.manager.ArticalCodeManager;
import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.cn.periodical.enums.PeriodicalStateEnums;
import com.cn.periodical.manager.PayeeInfoManager;
import com.cn.periodical.manager.PeriodicalInfoManager;
import com.cn.periodical.manager.PeriodicalManager;
import com.cn.periodical.pojo.PayeeInfo;
import com.cn.periodical.pojo.Periodical;
import com.cn.periodical.pojo.PeriodicalInfo;
import com.cn.periodical.pojo.PeriodicalInfoQuery;
import com.cn.periodical.pojo.UserInfo;
import com.cn.periodical.utils.GenerateOrderNo;

/**
 * 主编-期刊管理
 * */
@Controller
public class PeriodicalManagerController extends EditorController {

	public PeriodicalManagerController() {
		// TODO Auto-generated constructor stub
	}
	
	@Autowired
	PeriodicalInfoManager periodicalInfoManager;
	@Autowired
	PeriodicalManager periodicalManager;
	@Autowired
	PayeeInfoManager PayeeInfoManager;
	@Autowired
    ArticalCodeManager  aticalCodeManager;
	private static final Logger logger = LoggerFactory.getLogger(PeriodicalManagerController.class);
	/**
	 * toPeriodicalManagerPage
	 * 期刊管理
	 */
	@RequestMapping(value="/toPeriodicalManagerPage")
	public ModelAndView toPeriodicalManagerPage(HttpServletRequest request,@ModelAttribute PeriodicalInfoQuery query) {
		UserInfo userInfo = getUserInfo(request);
		logger.info("期刊管理首页Page in:[]");
		ModelAndView mav = new ModelAndView("editor_periodicalManagerPage");
		/**
		 * 期刊管理首页查询
		 * 查询条件:
		 * periodicalName=期刊名称;
		 * 
		 * 查询一个list列表,页面展示用
		 * */
		List<PeriodicalInfo> lists = periodicalInfoManager.queryList(query);
		mav.addObject("list", lists);
		logger.info("期刊管理管理首页Page out:[]");
		return mav;
	}
	
	@RequestMapping(value = "/toPeriodicalInfoAdd")
	public ModelAndView toPeriodicalInfoAdd(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView("editor_periodicalInfoDetailPage");

		return mav;
	}
	
	@RequestMapping(value = "/isPerNameExsit")
	@ResponseBody
	public boolean isPerNameExsit(HttpServletRequest request,String name) {
		PeriodicalInfoQuery query = new PeriodicalInfoQuery();
		query.setPeriodicalCnName(name);
		List<PeriodicalInfo> pInfos = periodicalInfoManager.queryList(query);
		if(pInfos!=null && pInfos.size()>=1){
			return true;
		}
		return false;
	}
	
	/**
	 * 保存编辑信息
	 */
	@RequestMapping(value = "/toSavePeriodicalInfo", method = { RequestMethod.POST })
	public ModelAndView toSavePeriodicalInfo(@ModelAttribute PeriodicalInfo periodicalInfo,@ModelAttribute PayeeInfo payeeInfo) {
		ModelAndView mav = new ModelAndView("redirect:../editor/toPeriodicalManagerPage");
		logger.info("新增期刊信息 in:["+JSON.toJSONString(periodicalInfo)+"]");
		try {
			/**
			 * 1,保存PeriodicalInfo到Periodical_info表
			 * */
//			String periodicalId = UUID.randomUUID().toString().replaceAll("-", "");
            String periodicalId = aticalCodeManager.getCode(ArticalCodeEnums.QIKAN_CONDE1.getCode(),ArticalCodeEnums.QIKAN_CONDE1.getName());
			String payeeId = UUID.randomUUID().toString().replaceAll("-", "");
			periodicalInfo.setPeriodicalId(periodicalId);
			periodicalInfo.setPayeeId(payeeId);
			periodicalInfo.setCreateTime(new Date());
			payeeInfo.setPayeeId(payeeId);
			
			for(int i=1;i<=periodicalInfo.getCycle();i++){
				Periodical periodical = new Periodical();
				periodical.setPeriodicalId(periodicalInfo.getPeriodicalId());
				periodical.setPeriodicalIssueNo(GenerateOrderNo.generateOrderNo()); //  就用国内刊号
//				periodical.setPeriodicalIssueNo(periodicalInfo.getCnNo());
				periodical.setPeriodicalState(PeriodicalStateEnums.NEW.getCode());
				periodical.setCycleNums(i);
				periodical.setPeriodicalYear(periodicalInfo.getPeriodicalYear()==null?new DateTime().toString("YYYY"):periodicalInfo.getPeriodicalYear());
//				periodical.setPublishNums(periodicalInfo.getPublishNums()==null?10000:periodicalInfo.get);
				periodical.setCreateTime(new Date());
				periodicalManager.savePeriodical(periodical);
			}
			PayeeInfoManager.savePayeeInfo(payeeInfo);
			periodicalInfoManager.savePeriodicalInfo(periodicalInfo);
		} catch (Exception e) {
			//记录错误日志
			logger.error("新增期刊信息异常!", e);
			return new ModelAndView("error");
		}
		return mav;
	}
}
