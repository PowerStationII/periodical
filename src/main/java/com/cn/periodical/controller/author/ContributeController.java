package com.cn.periodical.controller.author;

import java.io.File;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.cn.periodical.request.AuthorContributeReqDto;
import com.cn.periodical.service.AuthorContributeService;
import com.cn.periodical.service.LoginService;
/**
 * 作者工作区-投稿
 * */
@Controller
public class ContributeController extends AuthorController{
	
	private static final Logger logger = LoggerFactory.getLogger(ContributeController.class);
	
	@Autowired
	AuthorContributeService contributeService;
	
	/**
	 * toContributePage
	 * author/toContributePage
	 * 去投稿页面
	 */
	@RequestMapping(value="/toContributePage",method = RequestMethod.GET)
	public ModelAndView toContributePage(@RequestParam("userId") String userId,
			HttpServletRequest request) {
		logger.info("投稿Page:["+userId+"]");
		ModelAndView mav = new ModelAndView("contributePage");
		mav.addObject("userId", userId);
		return mav;
	}
	
	private boolean saveFile(MultipartFile file,HttpServletRequest request) {  
        // 判断文件是否为空  
        if (!file.isEmpty()) {  
            try {  
            	String fileName = "E://temp"+File.separator+file.getOriginalFilename();
            	File uploadFile = new File(fileName); 
                logger.info(uploadFile.getAbsolutePath());
                // 转存文件  
                file.transferTo(uploadFile);  
                return true;  
            } catch (Exception e) {  
                e.printStackTrace();  
            }  
        }  
        return false;  
    }  
	
	
	@RequestMapping(value="/toUpload",method = RequestMethod.POST)
	public ModelAndView toUpload(HttpServletRequest request,@RequestParam(value="files", required=true) MultipartFile[] files){
		//判断file数组不能为空并且长度大于0  
        if(files!=null&&files.length>0){  
            //循环获取file数组中得文件  
            for(int i = 0;i<files.length;i++){  
                MultipartFile file = files[i];  
                logger.info(file.getOriginalFilename());
                //保存文件  
                saveFile(file,request);  
            }  
        }  
        ModelAndView mav=new ModelAndView("portal");
        return mav;
	}
	
	
	/**
	 * 投稿按钮
	 * HttpServletRequest request
	 * ,@RequestParam(value="files", required=true) MultipartFile[] files
	 * ,HttpServletRequest request
	 */
	@RequestMapping(value="/toContribute",method = RequestMethod.POST)
	public ModelAndView toContribute(AuthorContributeReqDto contributeRequestDto) {
		logger.info("提交投稿信息入参:["+JSON.toJSONString(contributeRequestDto)+"]");
//		logger.info("&files["+JSON.toJSONString(files)+"]");
//		
//		//判断file数组不能为空并且长度大于0  
//        if(files!=null&&files.length>0){  
//            //循环获取file数组中得文件  
//            for(int i = 0;i<files.length;i++){  
//                MultipartFile file = files[i];  
//                //保存文件  
//                saveFile(file,request);  
//            }  
//        }  
		
		
		
		
		
		
		
		
		
		
		ModelAndView mav = new ModelAndView("author_area");//不能去这个页面
		mav.addObject("userId", contributeRequestDto.getUserId());
		/**
		 * 	保存投稿信息 
		 * */
		logger.info("保存新稿信息.....Start");
		try {
			contributeService.saveArticle(contributeRequestDto);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		logger.info("保存新稿信息.....end");
		return mav;
	}
}
