package com.cn.periodical.controller.expert;

import java.io.File;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
import com.cn.periodical.pojo.ArticleAttachmentInfo;
import com.cn.periodical.pojo.AuthorQueryDetail;
import com.cn.periodical.pojo.BizPeriodical;
import com.cn.periodical.pojo.Periodical;
import com.cn.periodical.pojo.PeriodicalDetails;
import com.cn.periodical.pojo.PeriodicalDetailsQuery;
import com.cn.periodical.pojo.PeriodicalQuery;
import com.cn.periodical.pojo.UserInfo;
import com.cn.periodical.service.ArticleQueryService;
import com.cn.periodical.service.ArticleWorkFlowService;
import com.cn.periodical.service.EditorArticleDealService;
import com.cn.periodical.service.ExpertArticleAuditeService;
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
	
	/**
	 * toEnAuditePeriodicalPage
	 * 去英文审刊页面
	 */
	@RequestMapping(value="/toEnAuditePeriodicalPage")
	public ModelAndView toEnAuditePeriodicalPage(HttpServletRequest request,
			@ModelAttribute BizPeriodical reqDto) {
		UserInfo userInfo = getUserInfo(request);
		logger.info("英文审刊Page:["+JSON.toJSONString(reqDto)+"]");
		ModelAndView mav = new ModelAndView("expert_enAuditPeriodicalPage");
		logger.info(JSON.toJSONString(reqDto));
		/**
		 * 
		 * */
		List<BizPeriodical> list = bizPeriodicalManager.queryPeriodicalInfosForEnExpert(null);
		mav.addObject("list", list);
		return mav;
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
	public ModelAndView toEnAuditAgreePage(HttpServletRequest request,
			@ModelAttribute BizPeriodical reqDto) {
		UserInfo userInfo = getUserInfo(request);
		logger.info("英文审刊-稿件审核:["+JSON.toJSONString(reqDto)+"]");
		ModelAndView mav = new ModelAndView("redirect:../expert/auditPeriodicalDetailPage");
		mav.addObject("articleId", reqDto.getaId());
		mav.addObject("periodicalId", reqDto.getpId());
		mav.addObject("periodicalIssueNo", reqDto.getIsNo());
		logger.info(JSON.toJSONString(reqDto));
		/**
		 * 审核通过
		 * 复制一份稿件信息到英文审稿目录
		 * */
		PropertiesInitManager.dataInit();
		String path = (String)PropertiesInitManager.PROPERTIES.get("enExpertPath");
		String oldPath = reqDto.getAttachmentPath();
		String oldName = reqDto.getAttachmentName();
		StringBuffer newPath= new StringBuffer();
		newPath.append(path);
		newPath.append(File.separator);
		newPath.append(reqDto.getaId());
		newPath.append(File.separator);
		
		try{
			FileCopyUtils.copyFile(oldPath, "", newPath.toString(), oldName);
			
			ArticleAttachmentInfo copyFile = new ArticleAttachmentInfo();
			copyFile.setArticleId(reqDto.getaId());
			copyFile.setAttachmentName(oldName);
			copyFile.setAttachmentPath(newPath.toString()+oldName);
			copyFile.setBdjcbgAttachmentName("");
			copyFile.setBdjcbgAttachmentPath("");
			copyFile.setCxcnsAttachmentName("");
			copyFile.setCxcnsAttachmentPath("");
			copyFile.setEditTimes(0);
			copyFile.setSjtztsjAttachmentName("");
			copyFile.setSjtztsjAttachmentPath("");
			copyFile.setYjspzpAttachmentName("");
			copyFile.setYjspzpAttachmentPath("");
			copyFile.setType("1004");
			copyFile.setStatus("Y");
			copyFile.setCreateTime(new Date());
			copyFile.setUpdateTime(new Date());
			
			articleAttachmentInfoManager.saveArticleAttachmentInfo(copyFile);
		}catch(Exception e){
			logger.info("稿件复制异常!!!怎么通知系统呢?");
		}
		PeriodicalDetailsQuery query = new PeriodicalDetailsQuery();
		query.setArticleId(reqDto.getaId());
		query.setPeriodicalId(reqDto.getpId());
		query.setPeriodicalIssueNo(reqDto.getIsNo());
		List<PeriodicalDetails> list = periodicalDetailsManager.queryList(query);
		PeriodicalDetails p = list.get(0);
		p.setId(p.getId());
		p.setExtend1("Y");
		periodicalDetailsManager.savePeriodicalDetails(p);
		return mav;
	}
	
	
	/**
	 * toEnAuditDisagreePage
	 * 审核不通过
	 */
	@RequestMapping(value="/toEnAuditDisagreePage")
	public ModelAndView toEnAuditDisagreePage(HttpServletRequest request,
			@RequestParam(value="files", required=true) MultipartFile up,
			@ModelAttribute BizPeriodical reqDto) {
		UserInfo userInfo = getUserInfo(request);
		logger.info("英文审刊-稿件审核不通过:["+JSON.toJSONString(reqDto)+"]");
		ModelAndView mav = new ModelAndView("redirect:../expert/auditPeriodicalDetailPage");
		logger.info(JSON.toJSONString(reqDto));
		/**
		 * 审核不通过
		 * */
		
		try {
			this.saveFile(up, request, "", reqDto.getaId());
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
	public ModelAndView sendToIssueEditorPage(HttpServletRequest request,
			String periodicalIssueNo,String periodicalId) {
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
		Iterator<PeriodicalDetails> its =pds.iterator();
		while(its.hasNext()){
			PeriodicalDetails pd = its.next();
			logger.info(pd.getExtend1());
			if(!"Y".equals(pd.getExtend1())){
				/**
				 * 弹出窗口,稿件审核未完成,不可签发
				 * */
				ModelAndView mav = new ModelAndView("");
				return mav;
			}else{
				ModelAndView mav = new ModelAndView("redirect:../expert/toEnAuditePeriodicalPage");
				PeriodicalQuery pQuery = new PeriodicalQuery();
				pQuery.setPeriodicalIssueNo(periodicalIssueNo);
				pQuery.setPeriodicalId(periodicalId);
				List<Periodical> ps = periodicalManager.queryList(pQuery);
				Periodical p =ps.get(0);
				p.setId(p.getId());
				p.setPeriodicalState(PeriodicalStateEnums.PRE_ISSUE.getCode());
				periodicalManager.savePeriodical(p);
				return mav;
			}
		}
		return new ModelAndView("error");
	}
}
