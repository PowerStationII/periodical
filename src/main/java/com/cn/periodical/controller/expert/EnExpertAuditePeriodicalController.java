package com.cn.periodical.controller.expert;

import java.io.File;
import java.util.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSONObject;
import com.cn.periodical.enums.RoleIdEnums;
import com.cn.periodical.pojo.*;
import com.cn.periodical.service.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.cn.periodical.enums.PeriodicalStateEnums;
import com.cn.periodical.manager.ArticleAttachmentInfoManager;
import com.cn.periodical.manager.ArticleFlowsManager;
import com.cn.periodical.manager.ArticleInfoManager;
import com.cn.periodical.manager.ArticleQueryManager;
import com.cn.periodical.manager.BizPeriodicalManager;
import com.cn.periodical.manager.PeriodicalDetailsManager;
import com.cn.periodical.manager.PeriodicalManager;
import com.cn.periodical.manager.UserInfoManager;
import com.cn.periodical.manager.UserQueryManager;
import com.cn.periodical.utils.FileCopyUtils;
import com.cn.periodical.utils.PropertiesInitManager;
import com.cn.periodical.utils.UtilLoad;

/**
 * 英文审刊
 * */
@Controller
public class EnExpertAuditePeriodicalController extends ExpertController{
	
	private static final Logger logger = LoggerFactory.getLogger(EnExpertAuditePeriodicalController.class);
	
	@Autowired
	ExpertArticleAuditeService articleAuditeService;
	
	@Autowired
	ArticleQueryService articleQueryService;
	
	@Autowired
	EditorArticleDealService articleDealService;
	@Autowired
	ArticleAttachmentInfoManager articleAttachmentInfoManager;
	
	@Autowired
	UserInfoManager userInfoManager;
	
	@Autowired 
	UserQueryManager userQueryManager;
	
	@Autowired
	ArticleWorkFlowService articleWorkFlowService;
	
	@Autowired
	ArticleInfoManager articleInfoManager;
	
	@Autowired
	ArticleFlowsManager articleFlowsManager;
	@Autowired
	ArticleQueryManager articleQueryManager;
	
	@Autowired
	BizPeriodicalManager bizPeriodicalManager;
	@Autowired
	PeriodicalDetailsManager periodicalDetailsManager;
	@Autowired
	PeriodicalManager periodicalManager;
    @Autowired
    AuthorContributeService authorContributeService ;
	
	/**
	 * toEnAuditePeriodicalPage
	 * 去英文审刊页面
	 */
//	@RequestMapping(value="/toEnAuditePeriodicalPage")
//	public ModelAndView toEnAuditePeriodicalPage(HttpServletRequest request,
//			@ModelAttribute BizPeriodical reqDto) {
//		UserInfo userInfo = getUserInfo(request);
//		logger.info("英文审刊Page:["+JSON.toJSONString(reqDto)+"]");
//		ModelAndView mav = new ModelAndView("expert_enAuditPeriodicalPage");
//		logger.info(JSON.toJSONString(reqDto));
//		/**
//		 *
//		 * */
//		List<BizPeriodical> list = bizPeriodicalManager.queryPeriodicalInfosForEnExpert(null);
//		mav.addObject("list", list);
//		return mav;
//	}
	/**
	 * toEnAuditePeriodicalPage
	 * 去英文审刊页面
	 */
	@RequestMapping(value="/toEnAuditePeriodicalPage")
	public ModelAndView toEnAuditePeriodicalPage(HttpServletRequest request,
			@ModelAttribute BizPeriodical reqDto) {
		logger.info("英文审刊Page:["+JSON.toJSONString(reqDto)+"]");
		ModelAndView mav = new ModelAndView("expert_enAuditPeriodicalPage");
		return mav;
	}
	/**
	 * toEnAuditePeriodicalPage
	 * 去英文审刊页面
	 */
	@RequestMapping(value="/toEnAuditePeriodicalPageSet")
    @ResponseBody
    public JSONObject toEnAuditePeriodicalPageSet(HttpServletRequest request,
			@ModelAttribute BizPeriodicalQuery query,
            @RequestParam(required = false, value = "page", defaultValue = "1") int page,
            @RequestParam(required = false, value = "rows", defaultValue = "10") int rows) {
		UserInfo userInfo = getUserInfo(request);
		logger.info("英文审刊Page:["+JSON.toJSONString(query)+"]");
		logger.info(JSON.toJSONString(query));

        JSONObject json = new JSONObject();
        int count = bizPeriodicalManager.queryPeriodicalInfosForEnExpertCount(query);
        json.put("total", count);

        query.setPageSize((page-1)*rows);//开始
        query.setPageNo(rows);//截止

        logger.info("广告管理首页*****Page in:["+JSON.toJSONString(query)+"]");

        BizPeriodicalPage bizPeriodicalPage = bizPeriodicalManager.queryPeriodicalInfosForEnExpert(query,count);
        json.put("rows", bizPeriodicalPage.getValues());

        return json ;
	}

	
	
	
	/**
	 * auditPeriodicalDetailPage
	 * 点击审核
	 */
	@RequestMapping(value="/auditPeriodicalDetailPage")
	public ModelAndView auditPeriodicalDetailPage(HttpServletRequest request,
			@ModelAttribute BizPeriodical reqDto,String periodicalId,String periodicalIssueNo) {
		UserInfo userInfo = getUserInfo(request);
		logger.info("英文审刊-待审稿件明细PageperiodicalId["+periodicalId+"]&periodicalIssueNo["+periodicalIssueNo+"]"
				+ "\n:["+JSON.toJSONString(reqDto)+"]");
		ModelAndView mav = new ModelAndView("expert_enAuditPeriodicalDetailPage");
		/**
		 * 查询期刊下所有稿件明细
		 * */
		reqDto.setpId(periodicalId);
		reqDto.setIsNo(periodicalIssueNo);
		List<BizPeriodical> list =bizPeriodicalManager.queryPeriodicalInfosForEnExpertDetail(reqDto);
		mav.addObject("list", list);

		return mav;
	}
	
	/**
	 * auditArticleEnDetailPage
	 * 审核稿件打开稿件明细页
	 */
	@RequestMapping(value="/auditArticleEnDetailPage")
	public ModelAndView auditArticleEnPage(HttpServletRequest request,
			@ModelAttribute BizPeriodical reqDto,String articleId,
			String periodicalId,String periodicalIssueNo) {
		UserInfo userInfo = getUserInfo(request);
		logger.info("英文审刊-稿件Page:["+JSON.toJSONString(reqDto)+"]");
		ModelAndView mav = new ModelAndView("expert_auditArticleEnDetailPage");
		logger.info(JSON.toJSONString(reqDto));
		/**
		 * 查询稿件明细/需要下载稿件
		 * periodical_details&article_info&article_attachment_info
		 * */
		AuthorQueryDetail aqd=new AuthorQueryDetail();
		aqd.setArticleId(articleId);
		aqd.setPeriodicalId(periodicalId);
		aqd.setPeriodicalIssueNo(periodicalIssueNo);
		AuthorQueryDetail dto = articleQueryManager.articleDetailForEnExpert(aqd);
		mav.addObject("dto", dto);
		mav.addObject("periodicalId", periodicalId);
		mav.addObject("periodicalIssueNo", periodicalIssueNo);
		return mav;
	}
	
	/**
	 * toDownLoadArticlePage
	 * 下载
	 */
	@RequestMapping(value="/toDownLoadArticlePage")
	@ResponseBody
	public String toDownLoadArticlePage(HttpServletRequest request,
			@ModelAttribute BizPeriodical reqDto,HttpServletResponse response,String fileName,String filePath) {
		UserInfo userInfo = getUserInfo(request);
		logger.info("英文审刊-稿件审核:["+JSON.toJSONString(reqDto)+"]");
		//ModelAndView mav = new ModelAndView("redirect:../expert/auditArticleEnDetailPage");
		logger.info(JSON.toJSONString(reqDto));
		/**
		 * 下载编辑&专家文件夹下稿件
		 * */
		UtilLoad.fileDownload(request, response, fileName, filePath.replace(fileName,""));

		return "";
	}
	
	/**
	 * toEnAuditAgreePage
	 * 审核通过
	 */
	@RequestMapping(value="/toEnAuditAgreePage")
	public @ResponseBody Object toEnAuditAgreePage(HttpServletRequest request,
			@ModelAttribute BizPeriodical reqDto,String articleId,
			String periodicalId,String periodicalIssueNo,@RequestParam(value="files", required=true) MultipartFile[] files,String dealOpinion ) {
		UserInfo userInfo = getUserInfo(request);
		logger.info("英文审刊-稿件审核:["+JSON.toJSONString(reqDto)+"]");
		Map<String,Object>  map = new HashMap<String ,Object>();
        map.put("articleId", articleId);
        map.put("periodicalId", periodicalId);
        map.put("periodicalIssueNo", periodicalIssueNo);
		logger.info(JSON.toJSONString(reqDto));

        Map<String, Object> resMap = UtilLoad.fileUpload(files, "enExpertPath", articleId);
        String filePathRet = (String) resMap.get("filePath");
        if(null!=filePathRet){
            String type = RoleIdEnums.EN_EXPERT.getCode();
            try {
                authorContributeService.saveAtricalAtt(articleId ,  files[0].getOriginalFilename() ,  filePathRet,type );
            } catch (Exception e) {
            }
        }

		PeriodicalDetailsQuery query = new PeriodicalDetailsQuery();
		query.setArticleId(articleId);
		query.setPeriodicalId(periodicalId);
		query.setPeriodicalIssueNo(periodicalIssueNo);
		List<PeriodicalDetails> list = periodicalDetailsManager.queryList(query);
		PeriodicalDetails p = list.get(0);
		p.setId(p.getId());
		p.setExtend1("Y");//稿件英文审稿结束,后续签发时会检查期刊下的所有稿件是否都已经审核结束
		periodicalDetailsManager.savePeriodicalDetails(p);
        map.put("message",super.success);
		return map;
	}
//	/**
//	 * toEnAuditAgreePage
//	 * 审核通过
//	 */
//	@RequestMapping(value="/toEnAuditAgreePage")
//	public ModelAndView toEnAuditAgreePage(HttpServletRequest request,
//			@ModelAttribute BizPeriodical reqDto,String articleId,
//			String periodicalId,String periodicalIssueNo) {
//		UserInfo userInfo = getUserInfo(request);
//		logger.info("英文审刊-稿件审核:["+JSON.toJSONString(reqDto)+"]");
//		ModelAndView mav = new ModelAndView("redirect:../expert/auditPeriodicalDetailPage");
//		mav.addObject("articleId", reqDto.getaId());
//		mav.addObject("periodicalId", reqDto.getpId());
//		mav.addObject("periodicalIssueNo", reqDto.getIsNo());
//		logger.info(JSON.toJSONString(reqDto));
//		/**
//		 * 审核通过
//		 * 复制一份稿件信息到英文审稿目录
//		 * */
//		PropertiesInitManager.dataInit();
//		String path = (String)PropertiesInitManager.PROPERTIES.get("enExpertPath");
//		String oldPath = reqDto.getAttachmentPath();
//		String oldName = reqDto.getAttachmentName();
//		StringBuffer newPath= new StringBuffer();
//		newPath.append(path);
//		newPath.append(File.separator);
//		newPath.append(reqDto.getaId());
//		newPath.append(File.separator);
//
//		try{
//			FileCopyUtils.copyFile(oldPath, "", newPath.toString(), oldName);
//
//			ArticleAttachmentInfo copyFile = new ArticleAttachmentInfo();
//			copyFile.setArticleId(reqDto.getaId());
//			copyFile.setAttachmentName(oldName);
//			copyFile.setAttachmentPath(newPath.toString()+oldName);
//			copyFile.setBdjcbgAttachmentName("");
//			copyFile.setBdjcbgAttachmentPath("");
//			copyFile.setCxcnsAttachmentName("");
//			copyFile.setCxcnsAttachmentPath("");
//			copyFile.setEditTimes(0);
//			copyFile.setSjtztsjAttachmentName("");
//			copyFile.setSjtztsjAttachmentPath("");
//			copyFile.setYjspzpAttachmentName("");
//			copyFile.setYjspzpAttachmentPath("");
//			copyFile.setType("1004");
//			copyFile.setStatus("Y");
//			copyFile.setCreateTime(new Date());
//			copyFile.setUpdateTime(new Date());
//
//			articleAttachmentInfoManager.saveArticleAttachmentInfo(copyFile);
//		}catch(Exception e){
//			logger.info("稿件复制异常!!!怎么通知系统呢?");
//			e.printStackTrace();
//			return new ModelAndView("error");
//		}
//		PeriodicalDetailsQuery query = new PeriodicalDetailsQuery();
//		query.setArticleId(reqDto.getaId());
//		query.setPeriodicalId(reqDto.getpId());
//		query.setPeriodicalIssueNo(reqDto.getIsNo());
//		List<PeriodicalDetails> list = periodicalDetailsManager.queryList(query);
//		PeriodicalDetails p = list.get(0);
//		p.setId(p.getId());
//		p.setExtend1("Y");//稿件英文审稿结束,后续签发时会检查期刊下的所有稿件是否都已经审核结束
//		periodicalDetailsManager.savePeriodicalDetails(p);
//		return mav;
//	}

	
	/**
	 * toEnAuditDisagreePage
	 * 审核不通过
	 */
	@RequestMapping(value="/toEnAuditDisagreePage")
	public ModelAndView toEnAuditDisagreePage(HttpServletRequest request,
			@RequestParam(value="file", required=true) MultipartFile file,
			@ModelAttribute BizPeriodical reqDto) {
		UserInfo userInfo = getUserInfo(request);
		logger.info("英文审刊-稿件审核不通过:["+JSON.toJSONString(reqDto)+"]");
		ModelAndView mav = new ModelAndView("redirect:../expert/auditPeriodicalDetailPage");
		logger.info(JSON.toJSONString(reqDto));
		/**
		 * 审核不通过
		 * */
		
		try {
			this.saveFile(file, request, "", reqDto.getaId());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		/**
		 * 向英文专家显示上传按钮
		 * 将英文专家上传的附件保存到attachment_info
		 * */
		
		

		return mav;
	}
	
	private String saveFile(@RequestParam(value="file", required=true) MultipartFile file,HttpServletRequest request,String userId,String articleId) throws Exception{  
    	PropertiesInitManager.dataInit();
    	String basePath = PropertiesInitManager.PROPERTIES.getProperty("filePath");
    	StringBuffer sbPath = new StringBuffer();
    	sbPath.append(basePath);
    	sbPath.append(File.separator);
    	sbPath.append(userId);
    	sbPath.append(File.separator);
    	sbPath.append(articleId);
    	sbPath.append(File.separator);
    	String filePath = sbPath.toString();
    	File headPath = new File(filePath);//获取文件夹路径       
    	if(!headPath.exists()){
    	//判断文件夹是否创建，没有创建则创建新文件夹        	
    		headPath.mkdirs();
    	}
    	
    	String fileName = filePath+file.getOriginalFilename();
    	File uploadFile = new File(fileName); 
        // 转存文件  
        file.transferTo(uploadFile);  
        logger.info(uploadFile.getAbsolutePath());
        return uploadFile.getAbsolutePath();  
    }  
	
	/**
	 * sendToIssueEditorPage
	 * 期刊审核结束,送去签发编辑
	 */
	@RequestMapping(value="/sendToIssueEditorPage")
	public @ResponseBody Object sendToIssueEditorPage(HttpServletRequest request,
			String periodicalIssueNo,String periodicalId) {
        Map<String,Object> map = new HashMap<String , Object>();
		UserInfo userInfo = getUserInfo(request);
		logger.info("期刊审核审核完成,送去签发编辑:["+periodicalIssueNo+"]["+periodicalId+"]");
		/**
		 * 检查稿件是否已全部审核完成
		 * */	
		PeriodicalDetailsQuery query =new PeriodicalDetailsQuery();
		query.setPeriodicalId(periodicalId);
		query.setPeriodicalIssueNo(periodicalIssueNo);
		query.setType("0000");
		List<PeriodicalDetails> pds =periodicalDetailsManager.queryList(query);
        boolean flag = false ;
        for(PeriodicalDetails periodicalDetails : pds){
             if((!"Y".equals(periodicalDetails.getExtend1()))){
                 flag = true ;
                 break ;
             }
        }

        if(flag){
            map.put("message",super.error);
        }else{
            PeriodicalQuery pQuery = new PeriodicalQuery();
            pQuery.setPeriodicalIssueNo(periodicalIssueNo);
            pQuery.setPeriodicalId(periodicalId);
            List<Periodical> ps = periodicalManager.queryList(pQuery);
            Periodical p =ps.get(0);
            p.setId(p.getId());
            p.setPeriodicalState(PeriodicalStateEnums.EN_TOBIANJI.getCode());
            periodicalManager.savePeriodical(p);
            map.put("message",super.success);
        }
        return map ;
	}


    /**
     * sendToIssueEditorPage
     * 期刊审核结束,送去签发编辑
     */
    @RequestMapping(value="/editSendToIssue")
    public @ResponseBody Object  editSendToIssue(HttpServletRequest request,
                                                      String periodicalIssueNo,String periodicalId) {
        Map<String,Object> map = new HashMap<String , Object>();
        UserInfo userInfo = getUserInfo(request);
        logger.info("期刊审核审核完成,送去签发编辑:["+periodicalIssueNo+"]["+periodicalId+"]");
        PeriodicalQuery pQuery = new PeriodicalQuery();
        pQuery.setPeriodicalIssueNo(periodicalIssueNo);
        pQuery.setPeriodicalId(periodicalId);
        List<Periodical> ps = periodicalManager.queryList(pQuery);
        Periodical p =ps.get(0);
        p.setId(p.getId());
        p.setPeriodicalState(PeriodicalStateEnums.PRE_ISSUE.getCode());
        periodicalManager.savePeriodical(p);
        map.put("message",super.success);
        return map ;
    }
    /**
     * sendToIssueEditorPage
     * 期刊审核结束,送去签发编辑
     */
    @RequestMapping(value="/editSendToIssueGuangGao")
    public @ResponseBody Object  editSendToIssueGuangGao(HttpServletRequest request,
                                                 String periodicalIssueNo,String periodicalId) {
        Map<String,Object> map = new HashMap<String , Object>();
        UserInfo userInfo = getUserInfo(request);
        logger.info("期刊审核审核完成,送去签发编辑:["+periodicalIssueNo+"]["+periodicalId+"]");
        PeriodicalQuery pQuery = new PeriodicalQuery();
        pQuery.setPeriodicalIssueNo(periodicalIssueNo);
        pQuery.setPeriodicalId(periodicalId);
        List<Periodical> ps = periodicalManager.queryList(pQuery);
        Periodical p =ps.get(0);
        p.setId(p.getId());
        p.setExtend2(PeriodicalStateEnums.PRE_ISSUE.getCode());
        periodicalManager.savePeriodical(p);
        map.put("message",super.success);
        return map ;
    }

}
