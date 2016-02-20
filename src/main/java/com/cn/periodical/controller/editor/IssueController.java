package com.cn.periodical.controller.editor;

import com.alibaba.fastjson.JSONObject;
import com.cn.periodical.enums.PeriodicalStateEnums;
import com.cn.periodical.manager.BizPeriodicalManager;
import com.cn.periodical.manager.PeriodicalManager;
import com.cn.periodical.pojo.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
	/**
	 * toIssueManagerPage
	 * 签发管理
	 */
//	@RequestMapping(value="/toIssueManagerPage",method = RequestMethod.GET)
//	public ModelAndView toIssueManagerPage(HttpServletRequest request,BizPeriodical reqDto) {
//		logger.info("签发管理Page:[  ]");
//		ModelAndView mav = new ModelAndView("editor_issueManagerPage");
//		return mav;
//	}
	/**
	 * toIssueManagerPage
	 * 签发管理
	 */
	@RequestMapping(value="/toIssueManagerPageSet",method = RequestMethod.GET)
    @ResponseBody
    public JSONObject toIssueManagerPageSet(HttpServletRequest request,
                                            @ModelAttribute BizPeriodicalQuery query,
                                            @RequestParam(required = false, value = "page", defaultValue = "1") int page,
                                            @RequestParam(required = false, value = "rows", defaultValue = "10") int rows) {
		logger.info("签发管理Page:[  ]");
		/**
		 * 查询广告+稿件全部完成的期刊
		 * */
 		int count = bizPeriodicalManager.queryPeriodicalInfosForIssueEditorPageCount(query);

        UserInfo userInfo = getUserInfo(request);
        JSONObject json = new JSONObject();
        json.put("total", count);

        query.setPageSize((page-1)*rows);//开始
        query.setPageNo(rows);//截止

        BizPeriodicalPage bizAdPage = bizPeriodicalManager.queryPeriodicalInfosForIssueEditorPage(query,count);
        json.put("rows", bizAdPage.getValues());

        return json;
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
}
