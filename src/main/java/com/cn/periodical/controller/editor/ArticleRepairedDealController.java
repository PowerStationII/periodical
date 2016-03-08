package com.cn.periodical.controller.editor;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSONObject;
import com.cn.periodical.manager.*;
import com.cn.periodical.pojo.*;
import com.cn.periodical.service.AuthorContributeService;
import com.cn.periodical.utils.UtilLoad;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.cn.periodical.enums.ArticleStateEnums;
import com.cn.periodical.enums.RoleIdEnums;
import com.cn.periodical.enums.SystemIdEnums;
import com.cn.periodical.request.AritcleWorkFlowReqDto;
import com.cn.periodical.request.ArticleQueryReqDto;
import com.cn.periodical.request.UserQueryReqDto;
import com.cn.periodical.response.ArticleQueryRespDto;
import com.cn.periodical.response.EditorArticleDealRespDto;
import com.cn.periodical.service.ArticleQueryService;
import com.cn.periodical.service.ArticleWorkFlowService;
import com.cn.periodical.service.EditorArticleDealService;
/**
 * 稿件编辑-稿件处理Controller
 * */
@Controller
public class ArticleRepairedDealController extends EditorController{
	
	private static final Logger logger = LoggerFactory.getLogger(ArticleRepairedDealController.class);
	
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
	UserInfoManager userInfoManager;
	
	@Autowired 
	UserQueryManager userQueryManager;

    @Autowired
    AuthorContributeService authorContributeService ;
    @Autowired
    PeriodicalChongtouLogManager periodicalChongtouLogManager;
	
	/**
	 * toRepairedArticlePage
	 * 返修
	 */
	@RequestMapping(value="/toRepaireArticlePage",method = RequestMethod.GET)
	public ModelAndView toRepairedArticlePage(HttpServletRequest request) {
		logger.info("返修PageList in:[]");
		ModelAndView mav = new ModelAndView("editor_repaireArticlePage");
		return mav;
	}
	/**
	 * toRepairedArticlePage
	 * 返修
	 */
	@RequestMapping(value="/toRepaireArticlePageSet")
    @ResponseBody
    public JSONObject toRepairedArticlePageSet(HttpServletRequest request,HttpServletResponse response,
                                               @ModelAttribute ArticleQueryReqDto query,
                                               @RequestParam(required = false, value = "page", defaultValue = "1") int page,
                                               @RequestParam(required = false, value = "rows", defaultValue = "10") int rows) {
		logger.info("返修PageList in:[]");
		UserInfo userInfo = getUserInfo(request);


        JSONObject json = new JSONObject();
        query.setEditorState(ArticleStateEnums.SUBMITED_ARTICLE.getCode());
//        query.setEditorState(ArticleStateEnums.END_ARTICLE.getCode());
        query.setExpertState(ArticleStateEnums.REPAIR_ARTICLE.getCode());
        query.setRoleId(userInfo.getRoleId());
        /**
         * 查询总数
         */
        int count = articleQueryService.queryArticleInfosCount(query);
        json.put("total", count);
        logger.info("+++++++++"+count);

        query.setPageSize((page-1)*rows);//开始
        query.setPageNo(rows);//截止

        logger.info("已登记Page出参 in:["+JSON.toJSONString(query)+"]");

        ZuoZheGaoJianPage zuoZheGaoJianPage =articleQueryService.queryArticleInfos(query,count);
        json.put("rows", zuoZheGaoJianPage.getValues());

        logger.info("已登记Page出参 out:[]");
        return json;
	}

	/**
	 * toRepairedPage
	 * 返修-Page
	 */
	@RequestMapping(value="/toRepairePage")
	public ModelAndView toRepairedPage(@RequestParam("articleId") String articleId,String flag ,HttpServletRequest request) {
		logger.info("返修Page in :["+articleId+"]");
		ModelAndView mav = new ModelAndView("editor_artilce_repairedPage");
		
		ArticleQueryReqDto reqDto= new ArticleQueryReqDto();
		reqDto.setArticleId(articleId);
        if("gaoJian".equals(flag)){
            reqDto.setRoleId(RoleIdEnums.AUTHOR.getCode());
        }else{
            reqDto.setRoleId(RoleIdEnums.ARTICLE_EDITOR.getCode());/**编辑和专家共用一个稿件目录*/
        }
		ArticleQueryRespDto articleQueryRespDto =articleQueryService.queryArticleInfoDetail(reqDto);
        PeriodicalChongtouLog periodicalChongtouLog = new PeriodicalChongtouLog () ;
        periodicalChongtouLog.setArticleNo(articleId);
        List<PeriodicalChongtouLog> listFanxiu = periodicalChongtouLogManager.selectByCondition(periodicalChongtouLog);
        articleQueryRespDto.setOriArticleId(articleId);
        if(null!=listFanxiu && !listFanxiu.isEmpty()){
            articleQueryRespDto.setArticleId(listFanxiu.get(0).getGroupFlag());
        }
        Opinion  opinion = articleFlowsManager.queryOpinion1(articleId);
		mav.addObject("respDto", articleQueryRespDto);
		mav.addObject("opinion", opinion);

		logger.info("返修Page out :["+JSON.toJSONString(articleQueryRespDto)+"]");
		return mav;
	}
	
	
	/**
	 * toRepairedModify
	 * 返修-Action
	 */
	@RequestMapping(value="/toRepaireModify")
    public @ResponseBody
    Object toPublishArticleDetailPage(@RequestParam("articleId") String articleId,
			HttpServletRequest request,@ModelAttribute AritcleWorkFlowReqDto aritcleWorkFlowReqDto
            ,@RequestParam(value="files", required=true) MultipartFile[] files) {
		logger.info("返修Action in:articleId:["+articleId+"]&aritcleWorkFlowReqDto:["+JSON.toJSONString(aritcleWorkFlowReqDto)+"]");
//		ModelAndView mav = new ModelAndView("redirect:../editor/toRepaireArticlePage");
        Map<String , Object> map = new HashMap<String ,Object>();
		ArticleInfoQuery query= new ArticleInfoQuery();
		query.setArticleId(articleId);
		List<ArticleInfo> articleInfos = articleInfoManager.queryList(query);
		ArticleInfo	articleInfo = articleInfos.get(0);
		
		/**
		 * 记录稿件开始处理流水
		 * refId谁把articleId稿件送给dtoResult.getUserId审
		 * userId对articleId稿件做了dealState/dealOpinion什么
		 * */
		AritcleWorkFlowReqDto reqDto = new AritcleWorkFlowReqDto();
		reqDto.setUserId(getUserInfo(request).getUserId());
		reqDto.setArticleId(articleId);
		reqDto.setRoleId(RoleIdEnums.ARTICLE_EDITOR.getCode());
		reqDto.setDealState(ArticleStateEnums.REPAIR_ARTICLE.getCode());
		reqDto.setToRoleId(RoleIdEnums.ARTICLE_EDITOR.getCode());
		reqDto.setDealOpinion(aritcleWorkFlowReqDto.getDealOpinion());
		reqDto.setDealStartTime(new Date());
		articleWorkFlowService.registArticleWorkFlow(reqDto);
		
		/**
		 * 变更稿件状态
		 * */
		articleInfo.setId(articleInfo.getId());
		articleInfo.setAuthorState(ArticleStateEnums.REPAIR_ARTICLE.getCode());
		articleInfo.setEditorState(ArticleStateEnums.REPAIR_ARTICLE.getCode());
		articleInfoManager.saveArticleInfo(articleInfo);

        Map<String, Object> resMap = UtilLoad.fileUpload(files, "editorPath", articleId);
        String filePathRet = (String) resMap.get("filePath");
        if(null!=filePathRet){
            String type = RoleIdEnums.ARTICLE_EDITOR.getCode();
            try {
                authorContributeService.saveAtricalAtt(articleId ,  files[0].getOriginalFilename() ,  filePathRet,type );
            } catch (Exception e) {
            }
        }
        map.put("message",super.success);
		logger.info("返修Action out:["+JSON.toJSONString(articleInfo)+"]");
		return map;
	}
}
