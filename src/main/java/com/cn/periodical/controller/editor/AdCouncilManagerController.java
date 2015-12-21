package com.cn.periodical.controller.editor;

import java.io.File;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
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
import com.cn.periodical.utils.PropertiesInitManager;
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
	public ModelAndView saveCouncilInfo(@ModelAttribute AdCouncilManagerReqDto reqDto,
			HttpServletRequest request) throws Exception{
//		/**
//		 * 保存上传的附件
//		 * */
//		String[] paths =  new String[5];
//		final String articleId= UUID.randomUUID().toString().replaceAll("-", "");
//		
//		//判断file数组不能为空并且长度大于0  
//        if(files!=null&&files.length>0){  
//            //循环获取file数组中得文件  
//            for(int i = 0;i<files.length;i++){  
//                MultipartFile file = files[i];  
//                logger.info(file.getOriginalFilename());
//                //保存文件  
//                paths[i]=saveFile(file,request,reqDto.getCouncilCompany());  
//            }  
//        }else{
//        	throw new Exception("上传稿件异常!!");
//        }
        
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
	/**
	 * 上传logo
	 * */
	@RequestMapping(value = "/uploadLogo")
	@ResponseBody
	public ModelAndView uploadLogo(@RequestParam(value="files", required=true) MultipartFile[] files,
			HttpServletRequest request){
		ModelAndView mav = new ModelAndView("error");
		try{
			mav = new ModelAndView("editor_councilManagerDetailPage");
			/**
			 * 保存上传的附件
			 * */
			String[] paths =  new String[5];
			final String articleId= UUID.randomUUID().toString().replaceAll("-", "");
			
			//判断file数组不能为空并且长度大于0  
	        if(files!=null&&files.length>0){  
	            //循环获取file数组中得文件  
	            for(int i = 0;i<files.length;i++){  
	                MultipartFile file = files[i];  
	                logger.info(file.getOriginalFilename());
	                //保存文件  
	                paths[i]=saveFile(file,request);
	                mav.addObject("fileName", file.getOriginalFilename());
	                mav.addObject("filePath", paths[0]);
	                
	            }  
	        }else{
	        	throw new Exception("上传稿件异常!!");
	        }
	       
	        return mav;
		}catch(Exception e){
			e.printStackTrace();
		}
		return mav;
	}
	
	private String saveFile(MultipartFile file,HttpServletRequest request) throws Exception{  
    	PropertiesInitManager.dataInit();
    	String basePath = request.getSession().getServletContext().getRealPath("/") + "councilImg" + File.separator;
    	//String basePath = PropertiesInitManager.PROPERTIES.getProperty("councilImgPath");
    	logger.info("hhahahahahahahah--------" + basePath);
    	StringBuffer sbPath = new StringBuffer();
    	sbPath.append(basePath);
    	sbPath.append(File.separator);
    	String filePath = sbPath.toString();
    	File headPath = new File(filePath);//获取文件夹路径       
    	if(!headPath.exists()){
    	//判断文件夹是否创建，没有创建则创建新文件夹        	
    		headPath.mkdirs();
    	}
    	String fileName = filePath+file.getOriginalFilename();
    	logger.info("-----------" + fileName);
    	File uploadFile = new File(fileName); 
        // 转存文件  
        file.transferTo(uploadFile);  
        logger.info(uploadFile.getAbsolutePath());
        return uploadFile.getAbsolutePath();  
    }  
}
