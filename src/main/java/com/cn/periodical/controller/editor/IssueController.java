package com.cn.periodical.controller.editor;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.cn.periodical.enums.PeriodicalStateEnums;
import com.cn.periodical.manager.BizPeriodicalManager;
import com.cn.periodical.manager.PeriodicalManager;
import com.cn.periodical.pojo.BizPeriodical;
import com.cn.periodical.pojo.Periodical;
import com.cn.periodical.pojo.PeriodicalQuery;
import com.cn.periodical.pojo.UserInfo;
/**
 * 签发人-签发管理Controller
 * */
@Controller
public class IssueController extends EditorController{
	
	@Autowired
	BizPeriodicalManager bizPeriodicalManager;
	@Autowired
	PeriodicalManager periodicalManager;
	
	private static final Logger logger = LoggerFactory.getLogger(IssueController.class);
	/**
	 * toIssueManagerPage
	 * 签发管理
	 */
	@RequestMapping(value="/toIssueManagerPage",method = RequestMethod.GET)
	public ModelAndView toIssueManagerPage(HttpServletRequest request,BizPeriodical reqDto) {
		logger.info("签发管理Page:[  ]");
		UserInfo userInfo = getUserInfo(request);
		ModelAndView mav = new ModelAndView("editor_issueManagerPage");
		/**
		 * 查询广告+稿件全部完成的期刊
		 * */
 		List<BizPeriodical> list = bizPeriodicalManager.queryPeriodicalInfosForIssueEditor(reqDto);
		mav.addObject("list", list);
		return mav;
	}

    @RequestMapping(value="/toIssue")
    public @ResponseBody Object toIssue(HttpServletRequest request,String periodicalId  ,String periodicalIsNo) {
        logger.info("签发Page:[  ]");
        UserInfo userInfo = getUserInfo(request);
        Map<String,Object> map = new HashMap<String ,Object>();
        PeriodicalQuery query= new PeriodicalQuery();
        query.setPeriodicalId(periodicalId);
        query.setPeriodicalIssueNo(periodicalIsNo);
        List<Periodical> list = periodicalManager.queryList(query);
        Periodical p = list.get(0);
        if(PeriodicalStateEnums.FINISH_ISSUE.getCode().equals(p.getPeriodicalState()) || PeriodicalStateEnums.FINISH_ISSUE.getCode().equals(p.getExtend2())){
            map.put("message","期刊已经签发过，不可重复签发");
            return map ;
        }
        if(!PeriodicalStateEnums.PRE_ISSUE.getCode().equals(p.getPeriodicalState())){
            map.put("message","期刊文章未送到签发");
            return map ;
        }
        if(!PeriodicalStateEnums.PRE_ISSUE.getCode().equals(p.getExtend2())){
            map.put("message","期刊广告未送到签发");
            return map ;
        }
        p.setId(p.getId());
        p.setIssueOpinion("同意");
        p.setPeriodicalState(PeriodicalStateEnums.FINISH_ISSUE.getCode());
        p.setIssueTime(new Date());
        periodicalManager.savePeriodical(p);
        map.put("message",super.success);
        return map;
    }
//	@RequestMapping(value="/toIssue")
//	public ModelAndView toIssue(HttpServletRequest request) {
//		logger.info("签发Page:[  ]");
//		UserInfo userInfo = getUserInfo(request);
//		ModelAndView mav = new ModelAndView("redirect:../editor/toIssueManagerPage");
////		periodicalId=${dtos.pId}&periodicalIsNo
//		String periodicalId=request.getParameter("periodicalId");
//		String periodicalIssueNo=request.getParameter("periodicalIsNo");
//		PeriodicalQuery query= new PeriodicalQuery();
//		query.setPeriodicalId(periodicalId);
//		query.setPeriodicalIssueNo(periodicalIssueNo);
//		List<Periodical> list = periodicalManager.queryList(query);
//		Periodical p = list.get(0);
//		p.setId(p.getId());
//		p.setIssueOpinion("同意");
//		p.setPeriodicalState(PeriodicalStateEnums.FINISH_ISSUE.getCode());
//		p.setIssueTime(new Date());
//		periodicalManager.savePeriodical(p);
////		BizPeriodical reqDto = new BizPeriodical();
////		reqDto.setpState(pState);
//		return mav;
//	}
}
