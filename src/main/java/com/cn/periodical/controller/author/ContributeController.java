package com.cn.periodical.controller.author;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.cn.periodical.manager.AuthorInfoManager;
import com.cn.periodical.manager.PeriodicalInfoManager;
import com.cn.periodical.manager.SectionInfoManager;
import com.cn.periodical.pojo.*;
import com.cn.periodical.request.AuthorContributeReqDto;
import com.cn.periodical.service.AuthorContributeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 作者工作区-投稿
 * */
@Controller
public class ContributeController extends AuthorController{
	
	private static final Logger logger = LoggerFactory.getLogger(ContributeController.class);
	
	@Autowired
	AuthorContributeService contributeService;
	
	@Autowired
	SectionInfoManager sectionInfoManager;
	@Autowired
	PeriodicalInfoManager periodicalInfoManager;
	@Autowired
	AuthorInfoManager authorInfoManager;
	
	/**
	 * toContributePage
	 * author/toContributePage
	 * 去投稿页面
	 */
	@RequestMapping(value="/toContributePage")
	public ModelAndView toContributePage(HttpServletRequest request,HttpServletResponse response) {
		UserInfo userInfo = (UserInfo)request.getSession().getAttribute("userInfo");
		logger.info("投稿Page:["+JSON.toJSONString(userInfo)+"]");
		ModelAndView mav = new ModelAndView("contributePage");
		AuthorInfoQuery authorQuery=new AuthorInfoQuery();
		authorQuery.setAuthorId(userInfo.getRefId());
		List<AuthorInfo> authorInfos = authorInfoManager.queryList(authorQuery);
		mav.addObject("authorInfo",authorInfos.get(0));
		
		PeriodicalInfoQuery periodicalInfoQuery =  new PeriodicalInfoQuery();
		List<PeriodicalInfo> periodicalInfos =periodicalInfoManager.queryList(periodicalInfoQuery);
		mav.addObject("periodicalInfos", periodicalInfos);
		
		String periodicalId = periodicalInfos.get(0).getPeriodicalId();
		
		SectionInfoQuery query = new SectionInfoQuery();
		query.setPeriodicalId(periodicalId);
		query.setExtend1("N");
		List<SectionInfo> sectionInfos = sectionInfoManager.queryList(query);
		mav.addObject("infos", sectionInfos);
		
		return mav;
	}
	
	/**
	 * 投稿按钮
	 * HttpServletRequest request
	 * ,@RequestParam(value="files", required=true) MultipartFile[] files
	 * ,HttpServletRequest request
	 */
	@RequestMapping(value="/toContribute",method = RequestMethod.POST)
	public ModelAndView toContribute(@ModelAttribute(value="contributeRequestDto") AuthorContributeReqDto contributeRequestDto,
			@RequestParam(value="files", required=true) MultipartFile[] files,HttpServletRequest request) {
		logger.info("提交投稿信息入参:["+JSON.toJSONString(contributeRequestDto)+"]&上传附件数量["+files.length+"]");
		ModelAndView mav = null;
		try{
	        mav=new ModelAndView("redirect:/author/toArticleQueryPage");
			contributeRequestDto.setUserId(getUserInfo(request).getUserId());
			contributeRequestDto.setRoleId(getUserInfo(request).getRoleId());
			/**
			 * 	保存投稿信息
			 * */
			logger.info("保存新稿信息.....Start");
			contributeService.saveArticle(contributeRequestDto,files,request);
			logger.info("保存新稿信息.....end");
			return mav;
		}catch(Exception e){
			logger.info("投稿功能异常!!!!!!",e);
			mav=new ModelAndView("error");
            mav.addObject("message",e.getMessage());
			return mav;
		}

	}
//	/**
//	 * 投稿按钮
//	 * HttpServletRequest request
//	 * ,@RequestParam(value="files", required=true) MultipartFile[] files
//	 * ,HttpServletRequest request
//	 */
//	@RequestMapping(value="/toContribute",method = RequestMethod.POST)
//    public @ResponseBody
//    Object toContribute(String contributeRequestDto,
//                        String articleType ,String classificationNums ,String articleCnTitle ,String articleCnSummary ,String articleCnKeywords ,
//                        String articleEnTile ,String articleEnSummary ,String articleEnKeywords ,String isfund ,String fundTitle ,String periodicalId ,
//                        String investSection ,String totalPages ,String totalPics ,String totalTabs ,String remark ,String inovationPoint ,
//                        String referenceDoc ,
//                        String[] isfirstauthor ,String[] isContacter ,String[] authorName ,String[] sex ,String[] birthday ,  String[] companyName,
//                        String[] technicalTitle,String[] duties,String[] email,String[] certificateNo
//                        ,String[] extend,String[] receiveAddress,String[] contacterMobile,
//                        @RequestParam(value="files", required=true) MultipartFile[] files,HttpServletRequest request) {
//		logger.info("提交投稿信息入参:["+JSON.toJSONString(contributeRequestDto)+"]&上传附件数量["+files.length+"]");
//        Map<String,String> map = new HashMap<String,String>();
//		try{
//
////            AuthorContributeReqDto authorContributeReqDto = JSON.parseObject(str,AuthorContributeReqDto.class) ;
////			contributeRequestDto.setUserId(getUserInfo(request).getUserId());
////			contributeRequestDto.setRoleId(getUserInfo(request).getRoleId());
//			/**
//			 * 	保存投稿信息
//			 * */
//			logger.info("保存新稿信息.....Start");
////			contributeService.saveArticle(contributeRequestDto,files,request);
//			logger.info("保存新稿信息.....end");
//			return map;
//		}catch(Exception e){
//			logger.info("投稿功能异常!!!!!!", e);
//			return map;
//		}
//
//	}
    /**
     * 稿件重投按钮触发的函数
     * @param contributeRequestDto
     * @param files
     * @param request
     * @return
     */
	@RequestMapping(value="/toChongTou",method = RequestMethod.POST)
	public @ResponseBody
    Object toChongTou(@ModelAttribute(value="contributeRequestDto") AuthorContributeReqDto contributeRequestDto,
			@RequestParam(value="files", required=true) MultipartFile[] files,HttpServletRequest request) {
		logger.info("提交投稿信息入参:["+JSON.toJSONString(contributeRequestDto)+"]&上传附件数量["+files.length+"]");
		Map<String,String> map = new HashMap<String,String>();
		try{
			contributeRequestDto.setUserId(getUserInfo(request).getUserId());
			contributeRequestDto.setRoleId(getUserInfo(request).getRoleId());
			/**
			 * 	保存投稿信息
			 * */
			logger.info("保存新稿信息.....Start");
			contributeService.saveChongTouArticle(contributeRequestDto,files,request);
            map.put("message",super.success);
			logger.info("保存新稿信息.....end");
			return map;
		}catch(Exception e){
			logger.info("投稿功能异常!!!!!!",e);
			return map;
		}

	}
}
