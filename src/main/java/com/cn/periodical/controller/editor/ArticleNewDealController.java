package com.cn.periodical.controller.editor;

import java.io.File;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSONObject;
import com.cn.periodical.manager.PeriodicalChongtouLogManager;
import com.cn.periodical.pojo.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.cn.periodical.enums.ArticleStateEnums;
import com.cn.periodical.enums.RoleIdEnums;
import com.cn.periodical.manager.ArticleFlowsManager;
import com.cn.periodical.manager.ArticleInfoManager;
import com.cn.periodical.manager.ArticleInfoStateManager;
import com.cn.periodical.request.AritcleWorkFlowReqDto;
import com.cn.periodical.request.ArticleQueryReqDto;
import com.cn.periodical.response.ArticleQueryRespDto;
import com.cn.periodical.service.ArticleQueryService;
import com.cn.periodical.service.ArticleWorkFlowService;
import com.cn.periodical.service.EditorArticleDealService;
import com.cn.periodical.utils.UtilLoad;
/**
 * 稿件编辑-稿件处理Controller
 * */
@Controller
public class ArticleNewDealController extends EditorController{
	
	private static final Logger logger = LoggerFactory.getLogger(ArticleNewDealController.class);
	
	@Autowired
	EditorArticleDealService articleDealService;/**作废*/
	
	@Autowired
	ArticleQueryService articleQueryService;
	
	@Autowired
	ArticleWorkFlowService articleWorkFlowService;
	
	@Autowired
	ArticleInfoManager articleInfoManager;
	
	@Autowired
	ArticleFlowsManager articleFlowsManager;
	@Autowired
	ArticleInfoStateManager articleInfoStateManager;
    @Autowired
    PeriodicalChongtouLogManager periodicalChongtouLogManager;
	
	/**
	 * toNewArticlePage
	 * 新稿 End
	 */
	@RequestMapping(value="/toNewArticlePage")
	public ModelAndView toNewArticlePage(HttpServletRequest request,HttpServletResponse response) {
		logger.info("新稿Page入参:["+JSON.toJSONString(userInfo)+"]");
		ModelAndView mav = new ModelAndView("editor_newArticlePage");
		return mav;
	}

    /**
     * toNewArticlePage
     * 新稿 End
     */
    @RequestMapping(value="/toNewArticlePageSet")
    @ResponseBody
    public JSONObject  toNewArticlePageSet(HttpServletRequest request,HttpServletResponse response,
                                            @ModelAttribute ArticleQueryReqDto query,
                                            @RequestParam(required = false, value = "page", defaultValue = "1") int page,
                                            @RequestParam(required = false, value = "rows", defaultValue = "10") int rows) {
        UserInfo userInfo = (UserInfo)request.getSession().getAttribute("userInfo");
        logger.info("新稿Page入参:["+JSON.toJSONString(userInfo)+"]");



        // 返回给页面的一个json
        JSONObject json = new JSONObject();
        query.setEditorState(ArticleStateEnums.NEW_ARTICLE.getCode());
        /**
         * 查询总数
         */
        int count = articleQueryService.queryArticleInfosCount(query);
        json.put("total", count);
        logger.info("+++++++++"+count);

        query.setPageSize((page-1)*rows);//开始
        query.setPageNo(rows);//截止

        logger.info("稿分页件查询首页*****Page in:["+JSON.toJSONString(query)+"]");
        ZuoZheGaoJianPage zuoZheGaoJianPage =articleQueryService.queryArticleInfos(query,count);
        json.put("rows", zuoZheGaoJianPage.getValues());

        logger.info("稿分页件查询Page out:[]");
        return json;
    }

	/**
	 * toNewArticleDetailPage
	 * 新稿-详情页 End
	 */
	@RequestMapping(value="/toNewArticleDetailPage",method = RequestMethod.GET)
	public ModelAndView toNewArticleDetailPage(@RequestParam("artilceId") String artilceId,
			HttpServletRequest request ) {
		logger.info("新稿详情页Page入参:artilceId:["+artilceId+"]");
		ModelAndView mav = new ModelAndView("editor_newArticleDetailPage");
		ArticleQueryReqDto reqDto= new ArticleQueryReqDto();
		reqDto.setArticleId(artilceId);
		reqDto.setRoleId(RoleIdEnums.ARTICLE_EDITOR.getCode());/**编辑下载编辑目录的稿件*/
		ArticleQueryRespDto articleQueryRespDto =articleQueryService.queryArticleInfoDetail(reqDto);
		mav.addObject("respDto", articleQueryRespDto);
		logger.info("新稿详情页Page出参:["+JSON.toJSONString(articleQueryRespDto)+"]");
		return mav;
	}
	
	/**
	 * toEnlistedPage
	 * 登记稿件状态页 End
	 */
	@RequestMapping(value="/toEnlistedPage")
	public ModelAndView toEnlistedPage(@RequestParam("articleId") String articleId,
			HttpServletRequest request,String isDown) {
		logger.info("稿件登记Page入参:artilceId:["+articleId+"]");
		ModelAndView mav = new ModelAndView("editor_artilce_enlistedPage");
		ArticleQueryReqDto reqDto= new ArticleQueryReqDto();
		reqDto.setArticleId(articleId);
		reqDto.setRoleId(RoleIdEnums.AUTHOR.getCode());/**编辑下载作者的稿件*/
		ArticleQueryRespDto articleQueryRespDto =articleQueryService.queryArticleInfoDetail(reqDto);
        PeriodicalChongtouLog periodicalChongtouLog = new PeriodicalChongtouLog () ;
        periodicalChongtouLog.setArticleNo(articleId);
        List<PeriodicalChongtouLog> listFanxiu = periodicalChongtouLogManager.selectByCondition(periodicalChongtouLog);
        articleQueryRespDto.setOriArticleId(articleId);
        if(null!=listFanxiu && !listFanxiu.isEmpty()){
            articleQueryRespDto.setArticleId(listFanxiu.get(0).getGroupFlag());
        } else{
            articleQueryRespDto.setArticleId(articleId);
        }
        mav.addObject("respDto", articleQueryRespDto);
		mav.addObject("isDown", isDown);
		logger.info("稿件登记Page出参:["+JSON.toJSONString(articleQueryRespDto)+"]");
		return mav;
	}
	
	/**
	 * toEnlistedModify
	 * 稿件状态变更为已登记
	 * 登记去新稿页 End
	 */
	@RequestMapping(value="/toEnlistedModify")
	@ResponseBody
	public String toUpdateArticleState(@RequestParam("articleId") String articleId,
			HttpServletRequest request) {
		logger.info("稿件登记Action入参:artilceId:["+articleId+"]");
		//ModelAndView mav = new ModelAndView("redirect:/editor/toNewArticlePage");
		Map<String,String> map =new HashMap<String,String>();
		map.put("articleId", articleId);
		map.put("userId", getUserInfo(request).getUserId());
		map.put("roleId", getUserInfo(request).getRoleId());
		ArticleInfo articleInfo = articleInfoManager.qryInfoByArticleId(map);
		
		
		ArticleFlowsQuery query = new ArticleFlowsQuery();
		query.setArticleId(articleId);
		query.setUserId(getUserInfo(request).getUserId());
		query.setRoleId(getUserInfo(request).getRoleId());
		query.setId(articleInfo.getLatelyFlowsId());
		ArticleFlows articleFlows = articleFlowsManager.queryFlowsDetail(query);
		
		articleInfo.setId(articleInfo.getId());
		articleInfo.setAuthorState(ArticleStateEnums.ENLISTED_ARTICLE.getCode());
		articleInfo.setEditorState(ArticleStateEnums.ENLISTED_ARTICLE.getCode());
		articleInfoManager.saveArticleInfo(articleInfo);
		
		/**
		 * 修改已登记流水的状态
		 * 共四个条件
		 * */
		articleFlows.setId(articleFlows.getId());
		articleFlows.setArticleId(articleId);
		articleFlows.setUserId(getUserInfo(request).getUserId());
		articleFlows.setRoleId(getUserInfo(request).getRoleId());
		
		articleFlows.setDealState(ArticleStateEnums.ENLISTED_ARTICLE.getCode());
		articleFlows.setDealOpinion("");
		articleFlows.setDealEndTime(new Date());
		articleFlowsManager.updateFlows(articleFlows);
		
		logger.info("稿件登记Action出参:[]");
		return "true";
	}
	
	/**
	 * toDownLoadArticle
	 * 下载触发记录稿件流水 
	 * 停留在登记操作页面 End
	 */
	@RequestMapping(value="/toDownLoadArticle")
	public ModelAndView toDownLoadArticle(@RequestParam("articleId") String articleId,String editorDownload,
			String fileName,String filePath,String isDown,
			HttpServletRequest request,HttpServletResponse response) {
		logger.info("稿件登记页-下载稿件Action入参:editorDownload:["+editorDownload+"],artilceId:["+articleId+"]fileName:["+fileName+"]filePath:["+filePath+"]");
		ModelAndView mav = new ModelAndView("redirect:../editor/toEnlistedPage");
		mav.addObject("articleId", articleId);
		mav.addObject("isDown", isDown);
		if("N".equals(editorDownload)&&editorDownload!=null){
			/**
			 * 记录稿件开始处理流水
			 * 如果编辑人员未下载过稿件,第一次稿件下载的时候会记录稿件的流水和下载状态变更.
			 * */
			AritcleWorkFlowReqDto reqDto = new AritcleWorkFlowReqDto();
			UserInfo userInfo = getUserInfo(request);
			reqDto.setUserId(userInfo.getUserId());
			reqDto.setArticleId(articleId);
			reqDto.setRoleId(userInfo.getRoleId());
			reqDto.setDealStartTime(new Date());
			reqDto.setToRoleId(userInfo.getRoleId());
			articleWorkFlowService.registArticleWorkFlow(reqDto);
			
			ArticleInfoStateQuery stateQuery= new ArticleInfoStateQuery();
			stateQuery.setArticleId(articleId);
			List<ArticleInfoState> articleInfoStates = articleInfoStateManager.queryList(stateQuery);
			ArticleInfoState articleInfoState = articleInfoStates.get(0);
			articleInfoState.setId(articleInfoState.getId());
			articleInfoState.setEditorDownload("Y");
			articleInfoState.setEditorDownloadTime(new Date());
			articleInfoStateManager.saveArticleInfoState(articleInfoState);
			logger.info("稿件登记页-下载稿件Action出参:[]");
		}
		return mav;
	}
	
	@RequestMapping(value="/toDownLoadNewArticle")
	public void download (HttpServletRequest request,HttpServletResponse response,
				String fileName,String filePath) {
		logger.info(filePath);
		UtilLoad.fileDownload(request, response,fileName,filePath.replace(fileName,""));
	}
}
